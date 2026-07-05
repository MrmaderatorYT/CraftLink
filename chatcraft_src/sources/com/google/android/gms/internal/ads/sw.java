package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class sw {
    public static JSONObject a(Context context, sp spVar) {
        int i;
        String id;
        boolean zIsLimitAdTrackingEnabled;
        String str;
        String str2;
        int i2;
        ri riVar = spVar.i;
        Location location = spVar.d;
        ta taVar = spVar.j;
        Bundle bundle = spVar.f3449a;
        JSONObject jSONObject = spVar.k;
        try {
            HashMap map = new HashMap();
            map.put("extra_caps", bra.e().a(o.bt));
            if (spVar.c.size() > 0) {
                map.put("eid", TextUtils.join(",", spVar.c));
            }
            if (riVar.f3423b != null) {
                map.put("ad_pos", riVar.f3423b);
            }
            bqj bqjVar = riVar.c;
            wz.a();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
            if (bqjVar.f2970b != -1) {
                map.put("cust_age", simpleDateFormat.format(new Date(bqjVar.f2970b)));
            }
            if (bqjVar.c != null) {
                map.put("extras", bqjVar.c);
            }
            int i3 = -1;
            if (bqjVar.d != -1) {
                map.put("cust_gender", Integer.valueOf(bqjVar.d));
            }
            if (bqjVar.e != null) {
                map.put("kw", bqjVar.e);
            }
            if (bqjVar.g != -1) {
                map.put("tag_for_child_directed_treatment", Integer.valueOf(bqjVar.g));
            }
            if (bqjVar.f) {
                map.put("test_request", true);
            }
            if (bqjVar.f2969a >= 2) {
                if (bqjVar.h) {
                    map.put("d_imp_hdr", 1);
                }
                if (!TextUtils.isEmpty(bqjVar.i)) {
                    map.put("ppid", bqjVar.i);
                }
            }
            if (bqjVar.f2969a >= 3 && bqjVar.l != null) {
                map.put("url", bqjVar.l);
            }
            if (bqjVar.f2969a >= 5) {
                if (bqjVar.n != null) {
                    map.put("custom_targeting", bqjVar.n);
                }
                if (bqjVar.o != null) {
                    map.put("category_exclusions", bqjVar.o);
                }
                if (bqjVar.p != null) {
                    map.put("request_agent", bqjVar.p);
                }
            }
            if (bqjVar.f2969a >= 6 && bqjVar.q != null) {
                map.put("request_pkg", bqjVar.q);
            }
            if (bqjVar.f2969a >= 7) {
                map.put("is_designed_for_families", Boolean.valueOf(bqjVar.r));
            }
            if (bqjVar.f2969a >= 8) {
                if (bqjVar.t != -1) {
                    map.put("tag_for_under_age_of_consent", Integer.valueOf(bqjVar.t));
                }
                if (bqjVar.u != null) {
                    map.put("max_ad_content_rating", bqjVar.u);
                }
            }
            if (riVar.d.g != null) {
                boolean z = false;
                boolean z2 = false;
                for (bqn bqnVar : riVar.d.g) {
                    if (!bqnVar.i && !z) {
                        map.put("format", bqnVar.f2974a);
                        z = true;
                    }
                    if (bqnVar.i && !z2) {
                        map.put("fluid", "height");
                        z2 = true;
                    }
                    if (z && z2) {
                        break;
                    }
                }
            } else {
                map.put("format", riVar.d.f2974a);
                if (riVar.d.i) {
                    map.put("fluid", "height");
                }
            }
            if (riVar.d.e == -1) {
                map.put("smart_w", "full");
            }
            if (riVar.d.f2975b == -2) {
                map.put("smart_h", "auto");
            }
            if (riVar.d.g != null) {
                StringBuilder sb = new StringBuilder();
                bqn[] bqnVarArr = riVar.d.g;
                int length = bqnVarArr.length;
                int i4 = 0;
                boolean z3 = false;
                while (i4 < length) {
                    bqn bqnVar2 = bqnVarArr[i4];
                    if (bqnVar2.i) {
                        z3 = true;
                    } else {
                        if (sb.length() != 0) {
                            sb.append("|");
                        }
                        sb.append(bqnVar2.e == i3 ? (int) (bqnVar2.f / taVar.t) : bqnVar2.e);
                        sb.append("x");
                        sb.append(bqnVar2.f2975b == -2 ? (int) (bqnVar2.c / taVar.t) : bqnVar2.f2975b);
                    }
                    i4++;
                    i3 = -1;
                }
                if (z3) {
                    if (sb.length() != 0) {
                        i2 = 0;
                        sb.insert(0, "|");
                    } else {
                        i2 = 0;
                    }
                    sb.insert(i2, "320x50");
                }
                map.put("sz", sb);
            }
            if (riVar.m != 0) {
                map.put("native_version", Integer.valueOf(riVar.m));
                map.put("native_templates", riVar.n);
                br brVar = riVar.y;
                if (brVar != null) {
                    switch (brVar.c) {
                        case 0:
                            str2 = "any";
                            break;
                        case 1:
                            str2 = "portrait";
                            break;
                        case 2:
                            str2 = "landscape";
                            break;
                        default:
                            str2 = "not_set";
                            break;
                    }
                } else {
                    str2 = "any";
                }
                map.put("native_image_orientation", str2);
                br brVar2 = riVar.y;
                map.put("native_multiple_images", Boolean.valueOf(brVar2 != null && brVar2.d));
                if (!riVar.z.isEmpty()) {
                    map.put("native_custom_templates", riVar.z);
                }
                if (riVar.f3422a >= 24) {
                    map.put("max_num_ads", Integer.valueOf(riVar.Y));
                }
                if (!TextUtils.isEmpty(riVar.W)) {
                    try {
                        map.put("native_advanced_settings", new JSONArray(riVar.W));
                    } catch (JSONException e) {
                        xe.c("Problem creating json from native advanced settings", e);
                    }
                }
            }
            if (riVar.V != null && riVar.V.size() > 0) {
                for (Integer num : riVar.V) {
                    if (num.intValue() == 2) {
                        map.put("iba", true);
                    } else if (num.intValue() == 1) {
                        map.put("ina", true);
                    }
                }
            }
            if (riVar.d.j) {
                map.put("ene", true);
            }
            if (riVar.O != null) {
                map.put("is_icon_ad", true);
                map.put("icon_ad_expansion_behavior", Integer.valueOf(riVar.O.f3009a));
            }
            if (riVar.ae != null) {
                ey eyVar = riVar.ae;
                switch (eyVar.f3078a) {
                    case 1:
                        str = "l";
                        break;
                    case 2:
                        str = "p";
                        break;
                    default:
                        int i5 = eyVar.f3078a;
                        StringBuilder sb2 = new StringBuilder(52);
                        sb2.append("Instream ad video aspect ratio ");
                        sb2.append(i5);
                        sb2.append(" is wrong.");
                        aan.c(sb2.toString());
                        str = "l";
                        break;
                }
                map.put("ia_var", str);
                map.put("instr", true);
            }
            map.put("slotname", riVar.e);
            map.put("pn", riVar.f.packageName);
            if (riVar.g != null) {
                map.put("vc", Integer.valueOf(riVar.g.versionCode));
            }
            map.put("ms", spVar.g);
            map.put("seq_num", riVar.i);
            map.put("session_id", riVar.j);
            map.put("js", riVar.k.f1790a);
            Bundle bundle2 = riVar.M;
            Bundle bundle3 = spVar.f3450b;
            map.put("am", Integer.valueOf(taVar.f3463a));
            map.put("cog", a(taVar.f3464b));
            map.put("coh", a(taVar.c));
            if (!TextUtils.isEmpty(taVar.d)) {
                map.put("carrier", taVar.d);
            }
            map.put("gl", taVar.e);
            if (taVar.f) {
                map.put("simulator", 1);
            }
            map.put("is_latchsky", Boolean.valueOf(taVar.g));
            if (taVar.h) {
                map.put("is_sidewinder", 1);
            }
            map.put("ma", a(taVar.i));
            map.put("sp", a(taVar.j));
            map.put("hl", taVar.k);
            if (!TextUtils.isEmpty(taVar.l)) {
                map.put("mv", taVar.l);
            }
            map.put("muv", Integer.valueOf(taVar.n));
            if (taVar.o != -2) {
                map.put("cnt", Integer.valueOf(taVar.o));
            }
            map.put("gnt", Integer.valueOf(taVar.p));
            map.put("pt", Integer.valueOf(taVar.q));
            map.put("rm", Integer.valueOf(taVar.r));
            map.put("riv", Integer.valueOf(taVar.s));
            Bundle bundle4 = new Bundle();
            bundle4.putString("build_build", taVar.A);
            bundle4.putString("build_device", taVar.B);
            Bundle bundle5 = new Bundle();
            bundle5.putBoolean("is_charging", taVar.x);
            bundle5.putDouble("battery_level", taVar.w);
            bundle4.putBundle("battery", bundle5);
            Bundle bundle6 = new Bundle();
            bundle6.putInt("active_network_state", taVar.z);
            bundle6.putBoolean("active_network_metered", taVar.y);
            bundle4.putBundle("network", bundle6);
            Bundle bundle7 = new Bundle();
            bundle7.putBoolean("is_browser_custom_tabs_capable", taVar.C);
            bundle4.putBundle("browser", bundle7);
            if (bundle2 != null) {
                Bundle bundle8 = new Bundle();
                bundle8.putString("runtime_free", Long.toString(bundle2.getLong("runtime_free_memory", -1L)));
                bundle8.putString("runtime_max", Long.toString(bundle2.getLong("runtime_max_memory", -1L)));
                bundle8.putString("runtime_total", Long.toString(bundle2.getLong("runtime_total_memory", -1L)));
                i = 0;
                bundle8.putString("web_view_count", Integer.toString(bundle2.getInt("web_view_count", 0)));
                Debug.MemoryInfo memoryInfo = (Debug.MemoryInfo) bundle2.getParcelable("debug_memory_info");
                if (memoryInfo != null) {
                    bundle8.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
                    bundle8.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
                    bundle8.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
                    bundle8.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
                    bundle8.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
                    bundle8.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
                    bundle8.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
                    bundle8.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
                    bundle8.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
                }
                bundle4.putBundle("android_mem_info", bundle8);
            } else {
                i = 0;
            }
            Bundle bundle9 = new Bundle();
            bundle9.putBundle("parental_controls", bundle3);
            if (!TextUtils.isEmpty(taVar.m)) {
                bundle9.putString("package_version", taVar.m);
            }
            bundle4.putBundle("play_store", bundle9);
            map.put("device", bundle4);
            Bundle bundle10 = new Bundle();
            bundle10.putString("doritos", spVar.e);
            bundle10.putString("doritos_v2", spVar.f);
            if (((Boolean) bra.e().a(o.aw)).booleanValue()) {
                if (spVar.h != null) {
                    id = spVar.h.getId();
                    zIsLimitAdTrackingEnabled = spVar.h.isLimitAdTrackingEnabled();
                } else {
                    id = null;
                    zIsLimitAdTrackingEnabled = false;
                }
                if (TextUtils.isEmpty(id)) {
                    bra.a();
                    bundle10.putString("pdid", aac.b(context));
                    bundle10.putString("pdidtype", "ssaid");
                } else {
                    bundle10.putString("rdid", id);
                    bundle10.putBoolean("is_lat", zIsLimitAdTrackingEnabled);
                    bundle10.putString("idtype", "adid");
                }
            }
            map.put("pii", bundle10);
            map.put("platform", Build.MANUFACTURER);
            map.put("submodel", Build.MODEL);
            if (location != null) {
                a((HashMap<String, Object>) map, location);
            } else if (riVar.c.f2969a >= 2 && riVar.c.k != null) {
                a((HashMap<String, Object>) map, riVar.c.k);
            }
            if (riVar.f3422a >= 2) {
                map.put("quality_signals", riVar.l);
            }
            if (riVar.f3422a >= 4 && riVar.p) {
                map.put("forceHttps", Boolean.valueOf(riVar.p));
            }
            if (bundle != null) {
                map.put("content_info", bundle);
            }
            if (riVar.f3422a >= 5) {
                map.put("u_sd", Float.valueOf(riVar.s));
                map.put("sh", Integer.valueOf(riVar.r));
                map.put("sw", Integer.valueOf(riVar.q));
            } else {
                map.put("u_sd", Float.valueOf(taVar.t));
                map.put("sh", Integer.valueOf(taVar.v));
                map.put("sw", Integer.valueOf(taVar.u));
            }
            if (riVar.f3422a >= 6) {
                if (!TextUtils.isEmpty(riVar.t)) {
                    try {
                        map.put("view_hierarchy", new JSONObject(riVar.t));
                    } catch (JSONException e2) {
                        xe.c("Problem serializing view hierarchy to JSON", e2);
                    }
                }
                map.put("correlation_id", Long.valueOf(riVar.u));
            }
            if (riVar.f3422a >= 7) {
                map.put("request_id", riVar.v);
            }
            if (riVar.f3422a >= 12 && !TextUtils.isEmpty(riVar.B)) {
                map.put("anchor", riVar.B);
            }
            if (riVar.f3422a >= 13) {
                map.put("android_app_volume", Float.valueOf(riVar.C));
            }
            if (riVar.f3422a >= 18) {
                map.put("android_app_muted", Boolean.valueOf(riVar.I));
            }
            if (riVar.f3422a >= 14 && riVar.D > 0) {
                map.put("target_api", Integer.valueOf(riVar.D));
            }
            if (riVar.f3422a >= 15) {
                int i6 = -1;
                if (riVar.E != -1) {
                    i6 = riVar.E;
                }
                map.put("scroll_index", Integer.valueOf(i6));
            }
            if (riVar.f3422a >= 16) {
                map.put("_activity_context", Boolean.valueOf(riVar.F));
            }
            if (riVar.f3422a >= 18) {
                if (!TextUtils.isEmpty(riVar.J)) {
                    try {
                        map.put("app_settings", new JSONObject(riVar.J));
                    } catch (JSONException e3) {
                        xe.c("Problem creating json from app settings", e3);
                    }
                }
                map.put("render_in_browser", Boolean.valueOf(riVar.K));
            }
            if (riVar.f3422a >= 18) {
                map.put("android_num_video_cache_tasks", Integer.valueOf(riVar.L));
            }
            aar aarVar = riVar.k;
            boolean z4 = riVar.Z;
            boolean z5 = spVar.l;
            boolean z6 = riVar.ab;
            Bundle bundle11 = new Bundle();
            Bundle bundle12 = new Bundle();
            bundle12.putString("cl", "220701481");
            bundle12.putString("rapid_rc", "dev");
            bundle12.putString("rapid_rollup", "HEAD");
            bundle11.putBundle("build_meta", bundle12);
            bundle11.putString("mf", Boolean.toString(((Boolean) bra.e().a(o.bv)).booleanValue()));
            bundle11.putBoolean("instant_app", z4);
            bundle11.putBoolean("lite", aarVar.e);
            bundle11.putBoolean("local_service", z5);
            bundle11.putBoolean("is_privileged_process", z6);
            bundle11.putInt("container_version", 12451009);
            map.put("sdk_env", bundle11);
            map.put("cache_state", jSONObject);
            if (riVar.f3422a >= 19) {
                map.put("gct", riVar.N);
            }
            if (riVar.f3422a >= 21 && riVar.P) {
                map.put("de", "1");
            }
            if (((Boolean) bra.e().a(o.aC)).booleanValue()) {
                String str3 = riVar.d.f2974a;
                boolean z7 = str3.equals("interstitial_mb") || str3.equals("reward_mb");
                Bundle bundle13 = riVar.Q;
                boolean z8 = bundle13 != null;
                if (z7 && z8) {
                    Bundle bundle14 = new Bundle();
                    bundle14.putBundle("interstitial_pool", bundle13);
                    map.put("counters", bundle14);
                }
            }
            if (riVar.R != null) {
                map.put("gmp_app_id", riVar.R);
            }
            if (riVar.S == null) {
                map.put("fbs_aiid", BuildConfig.FLAVOR);
            } else if ("TIME_OUT".equals(riVar.S)) {
                map.put("sai_timeout", bra.e().a(o.ah));
            } else {
                map.put("fbs_aiid", riVar.S);
            }
            if (riVar.T != null) {
                map.put("fbs_aeid", riVar.T);
            }
            if (riVar.af != null) {
                map.put("apm_id_origin", riVar.af);
            }
            if (riVar.f3422a >= 24) {
                map.put("disable_ml", Boolean.valueOf(riVar.aa));
            }
            String str4 = (String) bra.e().a(o.D);
            if (str4 != null && !str4.isEmpty()) {
                if (Build.VERSION.SDK_INT >= ((Integer) bra.e().a(o.E)).intValue()) {
                    HashMap map2 = new HashMap();
                    String[] strArrSplit = str4.split(",");
                    int length2 = strArrSplit.length;
                    while (i < length2) {
                        String str5 = strArrSplit[i];
                        map2.put(str5, aaa.a(str5));
                        i++;
                    }
                    map.put("video_decoders", map2);
                }
            }
            if (((Boolean) bra.e().a(o.cC)).booleanValue()) {
                map.put("omid_v", com.google.android.gms.ads.internal.ax.v().b(context));
            }
            if (riVar.ac != null && !riVar.ac.isEmpty()) {
                map.put("android_permissions", riVar.ac);
            }
            if (riVar.ad != null) {
                map.put("consent_string", riVar.ad);
            }
            if (riVar.ad != null) {
                map.put("iab_consent_info", riVar.ag);
            }
            if (xe.a(2)) {
                String strValueOf = String.valueOf(com.google.android.gms.ads.internal.ax.e().a(map).toString(2));
                xe.a(strValueOf.length() != 0 ? "Ad Request JSON: ".concat(strValueOf) : new String("Ad Request JSON: "));
            }
            return com.google.android.gms.ads.internal.ax.e().a(map);
        } catch (JSONException e4) {
            String strValueOf2 = String.valueOf(e4.getMessage());
            xe.e(strValueOf2.length() != 0 ? "Problem serializing ad request to JSON: ".concat(strValueOf2) : new String("Problem serializing ad request to JSON: "));
            return null;
        }
    }

    private static void a(HashMap<String, Object> map, Location location) {
        HashMap map2 = new HashMap();
        Float fValueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long lValueOf = Long.valueOf(location.getTime() * 1000);
        Long lValueOf2 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long lValueOf3 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        map2.put("radius", fValueOf);
        map2.put("lat", lValueOf2);
        map2.put("long", lValueOf3);
        map2.put("time", lValueOf);
        map.put("uule", map2);
    }

    private static Integer a(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00de A[Catch: JSONException -> 0x0288, TryCatch #0 {JSONException -> 0x0288, blocks: (B:3:0x0003, B:5:0x0026, B:9:0x002f, B:11:0x0037, B:13:0x003f, B:15:0x0047, B:17:0x004f, B:18:0x0053, B:20:0x0069, B:22:0x007c, B:24:0x008b, B:30:0x00a9, B:32:0x00af, B:34:0x00b5, B:37:0x00de, B:39:0x00e4, B:44:0x00f2, B:45:0x00f7, B:50:0x0105, B:51:0x010a, B:56:0x0118, B:58:0x0121, B:63:0x012f, B:66:0x013a, B:68:0x013e, B:69:0x0142, B:71:0x014a, B:73:0x0150, B:75:0x015e, B:77:0x0169, B:79:0x022d, B:83:0x023a, B:61:0x012b, B:54:0x0114, B:48:0x0101, B:42:0x00ee, B:26:0x0096, B:28:0x009e), top: B:92:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e4 A[Catch: JSONException -> 0x0288, TryCatch #0 {JSONException -> 0x0288, blocks: (B:3:0x0003, B:5:0x0026, B:9:0x002f, B:11:0x0037, B:13:0x003f, B:15:0x0047, B:17:0x004f, B:18:0x0053, B:20:0x0069, B:22:0x007c, B:24:0x008b, B:30:0x00a9, B:32:0x00af, B:34:0x00b5, B:37:0x00de, B:39:0x00e4, B:44:0x00f2, B:45:0x00f7, B:50:0x0105, B:51:0x010a, B:56:0x0118, B:58:0x0121, B:63:0x012f, B:66:0x013a, B:68:0x013e, B:69:0x0142, B:71:0x014a, B:73:0x0150, B:75:0x015e, B:77:0x0169, B:79:0x022d, B:83:0x023a, B:61:0x012b, B:54:0x0114, B:48:0x0101, B:42:0x00ee, B:26:0x0096, B:28:0x009e), top: B:92:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014e A[PHI: r18
      0x014e: PHI (r18v2 int) = (r18v1 int), (r18v4 int) binds: [B:65:0x0138, B:70:0x0148] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.rm a(android.content.Context r56, com.google.android.gms.internal.ads.ri r57, java.lang.String r58) {
        /*
            Method dump skipped, instructions count: 685
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.sw.a(android.content.Context, com.google.android.gms.internal.ads.ri, java.lang.String):com.google.android.gms.internal.ads.rm");
    }

    private static List<String> a(JSONArray jSONArray, List<String> list) {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    public static JSONObject a(rm rmVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (rmVar.f3427a != null) {
            jSONObject.put("ad_base_url", rmVar.f3427a);
        }
        if (rmVar.l != null) {
            jSONObject.put("ad_size", rmVar.l);
        }
        jSONObject.put("native", rmVar.s);
        if (rmVar.s) {
            jSONObject.put("ad_json", rmVar.f3428b);
        } else {
            jSONObject.put("ad_html", rmVar.f3428b);
        }
        if (rmVar.n != null) {
            jSONObject.put("debug_dialog", rmVar.n);
        }
        if (rmVar.L != null) {
            jSONObject.put("debug_signals", rmVar.L);
        }
        if (rmVar.f != -1) {
            double d = rmVar.f;
            Double.isNaN(d);
            jSONObject.put("interstitial_timeout", d / 1000.0d);
        }
        if (rmVar.k == com.google.android.gms.ads.internal.ax.g().b()) {
            jSONObject.put("orientation", "portrait");
        } else if (rmVar.k == com.google.android.gms.ads.internal.ax.g().a()) {
            jSONObject.put("orientation", "landscape");
        }
        if (rmVar.c != null) {
            jSONObject.put("click_urls", a(rmVar.c));
        }
        if (rmVar.e != null) {
            jSONObject.put("impression_urls", a(rmVar.e));
        }
        if (rmVar.R != null) {
            jSONObject.put("downloaded_impression_urls", a(rmVar.R));
        }
        if (rmVar.i != null) {
            jSONObject.put("manual_impression_urls", a(rmVar.i));
        }
        if (rmVar.q != null) {
            jSONObject.put("active_view", rmVar.q);
        }
        jSONObject.put("ad_is_javascript", rmVar.o);
        if (rmVar.p != null) {
            jSONObject.put("ad_passback_url", rmVar.p);
        }
        jSONObject.put("mediation", rmVar.g);
        jSONObject.put("custom_render_allowed", rmVar.r);
        jSONObject.put("content_url_opted_out", rmVar.u);
        jSONObject.put("content_vertical_opted_out", rmVar.M);
        jSONObject.put("prefetch", rmVar.v);
        if (rmVar.j != -1) {
            jSONObject.put("refresh_interval_milliseconds", rmVar.j);
        }
        if (rmVar.h != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", rmVar.h);
        }
        if (!TextUtils.isEmpty(rmVar.x)) {
            jSONObject.put("gws_query_id", rmVar.x);
        }
        jSONObject.put("fluid", rmVar.y ? "height" : BuildConfig.FLAVOR);
        jSONObject.put("native_express", rmVar.z);
        if (rmVar.B != null) {
            jSONObject.put("video_start_urls", a(rmVar.B));
        }
        if (rmVar.C != null) {
            jSONObject.put("video_complete_urls", a(rmVar.C));
        }
        if (rmVar.A != null) {
            vh vhVar = rmVar.A;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rb_type", vhVar.f3518a);
            jSONObject2.put("rb_amount", vhVar.f3519b);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("rewards", jSONArray);
        }
        jSONObject.put("use_displayed_impression", rmVar.D);
        jSONObject.put("auto_protection_configuration", rmVar.E);
        jSONObject.put("render_in_browser", rmVar.I);
        jSONObject.put("disable_closable_area", rmVar.S);
        return jSONObject;
    }

    private static JSONArray a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }
}
