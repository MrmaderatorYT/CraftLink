package com.ccs.craftlink.render;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * JNI bridge for Minecraft item/block texture rendering.
 *
 * Usage:
 *   NativeRender.init(context);
 *   Bitmap bmp = NativeRender.renderItem(765, 363); // protocol 765, diamond_sword
 *   String name = NativeRender.getItemName(765, 363);
 */
public class NativeRender {
    private static final String TAG = "NativeRender";
    private static boolean nativeLibLoaded = false;
    private static boolean initialized = false;

    static {
        try {
            System.loadLibrary("native-render");
            nativeLibLoaded = true;
            Log.i(TAG, "native-render library loaded");
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "Failed to load native-render", e);
        }
    }

    // JNI methods
    private static native boolean nativeInit(String itemDictPath, String itemIndexPath,
                                             String atlasMapPath, String atlasImagePath);
    private static native String nativeGetItemName(int protocolVersion, int itemId);
    private static native int nativeGetItemCount();
    private static native Bitmap nativeRenderItem(int protocolVersion, int itemId);
    private static native void nativeCleanup();

    /**
     * Initialize the renderer by copying assets to internal storage and loading them.
     * Call once at app startup.
     */
    public static boolean init(Context context) {
        if (!nativeLibLoaded) {
            Log.e(TAG, "Native library not loaded");
            return false;
        }

        if (initialized) return true;

        try {
            File cacheDir = new File(context.getCacheDir(), "renderer");
            cacheDir.mkdirs();

            String[] files = {"item_dict.bin", "item_index.bin", "atlas_map.bin", "item_atlas.png"};
            for (String file : files) {
                File target = new File(cacheDir, file);
                copyAsset(context, "renderer/" + file, target);
            }

            String dictPath = new File(cacheDir, "item_dict.bin").getAbsolutePath();
            String indexPath = new File(cacheDir, "item_index.bin").getAbsolutePath();
            String atlasMapPath = new File(cacheDir, "atlas_map.bin").getAbsolutePath();
            String atlasImgPath = new File(cacheDir, "item_atlas.png").getAbsolutePath();

            initialized = nativeInit(dictPath, indexPath, atlasMapPath, atlasImgPath);
            Log.i(TAG, "NativeRender initialized: " + initialized);
            return initialized;

        } catch (Exception e) {
            Log.e(TAG, "Init failed", e);
            return false;
        }
    }

    /**
     * Render an item texture as a Bitmap.
     *
     * @param protocolVersion Minecraft protocol version (e.g. 765 for 1.20.4)
     * @param itemId Numeric item ID (e.g. 363 for cooked_beef)
     * @return ARGB_8888 Bitmap (16x16 or atlas cell size), or null on error
     */
    public static Bitmap renderItem(int protocolVersion, int itemId) {
        if (!nativeLibLoaded || !initialized) return null;
        return nativeRenderItem(protocolVersion, itemId);
    }

    /**
     * Get string name of an item by protocol version and item ID.
     *
     * @param protocolVersion Minecraft protocol version
     * @param itemId Numeric item ID
     * @return Item name string (e.g. "cooked_beef"), or "unknown"
     */
    public static String getItemName(int protocolVersion, int itemId) {
        if (!nativeLibLoaded || !initialized) return "unknown";
        return nativeGetItemName(protocolVersion, itemId);
    }

    /**
     * Get total number of items in the dictionary.
     */
    public static int getItemCount() {
        if (!nativeLibLoaded || !initialized) return 0;
        return nativeGetItemCount();
    }

    /**
     * Release native resources. Call on app shutdown.
     */
    public static void cleanup() {
        if (nativeLibLoaded) {
            nativeCleanup();
            initialized = false;
        }
    }

    private static void copyAsset(Context context, String assetName, File target) {
        try {
            AssetManager am = context.getAssets();
            InputStream is = am.open(assetName);
            FileOutputStream fos = new FileOutputStream(target);

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.close();
            is.close();
            Log.d(TAG, "Copied asset: " + assetName);

        } catch (IOException e) {
            Log.e(TAG, "Failed to copy asset: " + assetName, e);
        }
    }
}
