#include <jni.h>
#include <android/bitmap.h>
#include <android/log.h>
#include <cstring>
#include <cstdio>
#include <cstdlib>
#include <string>
#include <unordered_map>
#include <vector>

#define TAG "NativeRender"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, TAG, __VA_ARGS__)

// ============================================================
//  RenderCache - singleton
// ============================================================

struct ItemInfo { int32_t universalId; std::string name; };
struct AtlasCoord { float u, v, size; bool hasTexture; };

class RenderCache {
public:
    static RenderCache& instance() { static RenderCache i; return i; }

    bool initialized = false;

    // universal_id -> name
    std::unordered_map<int32_t, ItemInfo> itemMap;

    // universal_id -> atlas coordinates
    std::unordered_map<int32_t, AtlasCoord> atlasMap;

    // Cross-version index: protocol -> (dynamic_id -> universal_id)
    struct ProtocolIndex {
        int32_t protocol;
        int32_t maxDynamicId;
        int32_t* mapping;  // array[maxDynamicId+1], 0 = no mapping
    };
    std::vector<ProtocolIndex> protocolIndices;

    // Atlas image data
    uint8_t* atlasPixels = nullptr;
    uint32_t atlasWidth = 0, atlasHeight = 0;

    // Placeholder
    uint8_t* placeholderPixels = nullptr;

    void cleanup() {
        free(atlasPixels); atlasPixels = nullptr;
        free(placeholderPixels); placeholderPixels = nullptr;
        itemMap.clear(); atlasMap.clear();
        for (auto& pi : protocolIndices) free(pi.mapping);
        protocolIndices.clear();
        initialized = false;
    }
};

// ============================================================
//  Loaders
// ============================================================

static void loadItemDict(const char* path) {
    FILE* f = fopen(path, "rb");
    if (!f) { LOGE("Cannot open %s", path); return; }

    char magic[5]; fread(magic, 1, 5, f);
    if (strncmp(magic, "CITEM", 5) != 0) { fclose(f); return; }

    uint32_t ver, count;
    fread(&ver, 4, 1, f);
    fread(&count, 4, 1, f);

    RenderCache::instance().itemMap.reserve(count);
    for (uint32_t i = 0; i < count; i++) {
        int32_t uid; uint16_t nameLen;
        fread(&uid, 4, 1, f);
        fread(&nameLen, 2, 1, f);
        char buf[256];
        fread(buf, 1, nameLen, f);
        buf[nameLen] = '\0';
        RenderCache::instance().itemMap[uid] = {uid, std::string(buf)};
    }
    fclose(f);
    LOGI("item_dict: %u items", count);
}

static void loadItemIndex(const char* path) {
    FILE* f = fopen(path, "rb");
    if (!f) { LOGI("item_index.bin not found (v1 format)"); return; }

    char magic[4]; fread(magic, 1, 4, f);
    if (strncmp(magic, "CIDX", 4) != 0) { fclose(f); return; }

    uint32_t ver; fread(&ver, 4, 1, f);

    if (ver >= 2) {
        // V2 format: cross-version index
        uint32_t protoCount; fread(&protoCount, 4, 1, f);
        uint32_t totalMappings; fread(&totalMappings, 4, 1, f);

        auto& cache = RenderCache::instance();
        cache.protocolIndices.reserve(protoCount);

        for (uint32_t p = 0; p < protoCount; p++) {
            int32_t protocol;
            uint32_t maxId, count;
            fread(&protocol, 4, 1, f);
            fread(&maxId, 4, 1, f);
            fread(&count, 4, 1, f);

            int32_t* arr = (int32_t*)calloc(maxId + 1, sizeof(int32_t));
            fread(arr, sizeof(int32_t), maxId + 1, f);

            RenderCache::instance().protocolIndices.push_back({protocol, (int32_t)maxId, arr});
            LOGI("  Protocol %d: max_id=%u, %u mappings", protocol, maxId, count);
        }
        LOGI("item_index v2: %u protocols loaded", protoCount);
    } else {
        LOGI("item_index v1 format (legacy), skipping cross-version");
    }
    fclose(f);
}

static void loadAtlasMap(const char* path) {
    FILE* f = fopen(path, "rb");
    if (!f) { LOGE("Cannot open %s", path); return; }

    char magic[4]; fread(magic, 1, 4, f);
    if (strncmp(magic, "CLAT", 4) != 0) { fclose(f); return; }

    uint32_t ver, w, h, count;
    fread(&ver, 4, 1, f);
    fread(&w, 4, 1, f);
    fread(&h, 4, 1, f);
    fread(&count, 4, 1, f);

    auto& cache = RenderCache::instance();
    cache.atlasWidth = w;
    cache.atlasHeight = h;
    cache.atlasMap.reserve(count);

    for (uint32_t i = 0; i < count; i++) {
        int32_t uid; float u, v, sz; uint8_t flag;
        fread(&uid, 4, 1, f);
        fread(&u, 4, 1, f);
        fread(&v, 4, 1, f);
        fread(&sz, 4, 1, f);
        fread(&flag, 1, 1, f);
        cache.atlasMap[uid] = {u, v, sz, flag != 0};
    }
    fclose(f);
    LOGI("atlas_map: %ux%u, %u entries", w, h, count);
}

static void loadAtlasPixels(JNIEnv* env, const char* path) {
    jclass bmFactory = env->FindClass("android/graphics/BitmapFactory");
    jmethodID decodeFile = env->GetStaticMethodID(bmFactory, "decodeFile",
            "(Ljava/lang/String;)Landroid/graphics/Bitmap;");
    jobject bmp = env->CallStaticObjectMethod(bmFactory, decodeFile, env->NewStringUTF(path));
    if (!bmp) { LOGE("Failed to decode atlas"); return; }

    AndroidBitmapInfo info;
    AndroidBitmap_getInfo(env, bmp, &info);

    void* pixels;
    AndroidBitmap_lockPixels(env, bmp, &pixels);

    auto& cache = RenderCache::instance();
    cache.atlasWidth = info.width;
    cache.atlasHeight = info.height;
    cache.atlasPixels = (uint8_t*)malloc(info.width * info.height * 4);
    memcpy(cache.atlasPixels, pixels, info.width * info.height * 4);

    AndroidBitmap_unlockPixels(env, bmp);
    env->DeleteLocalRef(bmp);
    LOGI("atlas image: %ux%u", info.width, info.height);
}

static void generatePlaceholder() {
    auto& c = RenderCache::instance();
    c.placeholderPixels = (uint8_t*)malloc(16 * 16 * 4);
    for (int y = 0; y < 16; y++) {
        for (int x = 0; x < 16; x++) {
            int idx = (y * 16 + x) * 4;
            uint8_t v = ((x / 4 + y / 4) % 2 == 0) ? 160 : 128;
            c.placeholderPixels[idx] = v;
            c.placeholderPixels[idx+1] = v;
            c.placeholderPixels[idx+2] = v;
            c.placeholderPixels[idx+3] = 255;
        }
    }
}

// ============================================================
//  Protocol -> Universal ID lookup
// ============================================================

static int32_t resolveUniversalId(int32_t protocol, int32_t dynamicId) {
    auto& indices = RenderCache::instance().protocolIndices;
    for (auto& pi : indices) {
        if (pi.protocol == protocol && dynamicId >= 0 && dynamicId <= pi.maxDynamicId) {
            return pi.mapping[dynamicId];
        }
    }
    return -1; // not found
}

// ============================================================
//  Bitmap creation
// ============================================================

static jobject createBitmapFromPixels(JNIEnv* env, const uint8_t* px, int w, int h) {
    jclass cls = env->FindClass("android/graphics/Bitmap");
    jmethodID m = env->GetStaticMethodID(cls, "createBitmap",
            "(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;");
    jclass cfg = env->FindClass("android/graphics/Bitmap$Config");
    jfieldID f = env->GetStaticFieldID(cfg, "ARGB_8888", "Landroid/graphics/Bitmap$Config;");
    jobject bmp = env->CallStaticObjectMethod(cls, m, w, h, env->GetStaticObjectField(cfg, f));
    if (!bmp) return nullptr;

    AndroidBitmapInfo info;
    void* bpx;
    AndroidBitmap_getInfo(env, bmp, &info);
    AndroidBitmap_lockPixels(env, bmp, &bpx);
    memcpy(bpx, px, w * h * 4);
    AndroidBitmap_unlockPixels(env, bmp);
    return bmp;
}

// ============================================================
//  JNI Functions
// ============================================================

extern "C" {

JNIEXPORT jboolean JNICALL
Java_com_ccs_craftlink_render_NativeRender_nativeInit(
        JNIEnv* env, jobject thiz,
        jstring itemDictPath, jstring itemIndexPath,
        jstring atlasMapPath, jstring atlasImagePath) {

    const char* dictP = env->GetStringUTFChars(itemDictPath, nullptr);
    const char* idxP  = env->GetStringUTFChars(itemIndexPath, nullptr);
    const char* mapP  = env->GetStringUTFChars(atlasMapPath, nullptr);
    const char* imgP  = env->GetStringUTFChars(atlasImagePath, nullptr);

    LOGI("=== NativeRender Init (v2 multi-version) ===");

    loadItemDict(dictP);
    loadItemIndex(idxP);
    loadAtlasMap(mapP);
    loadAtlasPixels(env, imgP);
    generatePlaceholder();

    RenderCache::instance().initialized = true;

    env->ReleaseStringUTFChars(itemDictPath, dictP);
    env->ReleaseStringUTFChars(itemIndexPath, idxP);
    env->ReleaseStringUTFChars(atlasMapPath, mapP);
    env->ReleaseStringUTFChars(atlasImagePath, imgP);

    LOGI("Init OK: %d items, %d atlas, %d protocols",
         (int)RenderCache::instance().itemMap.size(),
         (int)RenderCache::instance().atlasMap.size(),
         (int)RenderCache::instance().protocolIndices.size());
    return JNI_TRUE;
}

JNIEXPORT jstring JNICALL
Java_com_ccs_craftlink_render_NativeRender_nativeGetItemName(
        JNIEnv* env, jobject thiz, jint protocolVersion, jint itemId) {

    auto& cache = RenderCache::instance();
    int32_t uid = resolveUniversalId(protocolVersion, itemId);

    if (uid >= 0) {
        auto it = cache.itemMap.find(uid);
        if (it != cache.itemMap.end())
            return env->NewStringUTF(it->second.name.c_str());
    }
    return env->NewStringUTF("unknown");
}

JNIEXPORT jint JNICALL
Java_com_ccs_craftlink_render_NativeRender_nativeGetItemCount(
        JNIEnv* env, jobject thiz) {
    return (jint)RenderCache::instance().itemMap.size();
}

JNIEXPORT jobject JNICALL
Java_com_ccs_craftlink_render_NativeRender_nativeRenderItem(
        JNIEnv* env, jobject thiz, jint protocolVersion, jint itemId) {

    auto& cache = RenderCache::instance();
    if (!cache.initialized || !cache.atlasPixels) return nullptr;

    // Convert dynamic_id -> universal_id
    int32_t uid = resolveUniversalId(protocolVersion, itemId);

    if (uid < 0) {
        return nullptr;
    }

    // Find atlas coordinates for universal_id
    auto coordIt = cache.atlasMap.find(uid);
    if (coordIt == cache.atlasMap.end() || !coordIt->second.hasTexture) {
        return nullptr;
    }

    const AtlasCoord& coord = coordIt->second;
    int texSize = (int)(coord.size * cache.atlasWidth);
    if (texSize <= 0) texSize = 16;

    int sx = (int)(coord.u * cache.atlasWidth);
    int sy = (int)(coord.v * cache.atlasHeight);
    sx = std::max(0, std::min(sx, (int)cache.atlasWidth - texSize));
    sy = std::max(0, std::min(sy, (int)cache.atlasHeight - texSize));

    // Extract from atlas
    int bytesPerPixel = 4;
    uint8_t* tex = (uint8_t*)malloc(texSize * texSize * bytesPerPixel);
    for (int y = 0; y < texSize; y++) {
        int srcOff = ((sy + y) * cache.atlasWidth + sx) * bytesPerPixel;
        int dstOff = y * texSize * bytesPerPixel;
        int copyLen = texSize * bytesPerPixel;
        memcpy(tex + dstOff, cache.atlasPixels + srcOff, copyLen);
    }

    jobject result = createBitmapFromPixels(env, tex, texSize, texSize);
    free(tex);
    return result;
}

JNIEXPORT void JNICALL
Java_com_ccs_craftlink_render_NativeRender_nativeCleanup(
        JNIEnv* env, jobject thiz) {
    RenderCache::instance().cleanup();
}

} // extern "C"
