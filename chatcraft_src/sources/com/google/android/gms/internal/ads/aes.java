package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class aes implements com.google.android.gms.ads.internal.gmsg.ac<adk> {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1910a;

    private static int a(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                bra.a();
                return aac.a(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
                sb.append("Could not parse ");
                sb.append(str);
                sb.append(" in a video GMSG: ");
                sb.append(str2);
                xe.e(sb.toString());
            }
        }
        return i;
    }

    private static void a(acv acvVar, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        if (str != null) {
            try {
                acvVar.b(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                xe.e(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            acvVar.c(Integer.parseInt(str2));
        }
        if (str3 != null) {
            acvVar.d(Integer.parseInt(str3));
        }
        if (str4 != null) {
            acvVar.e(Integer.parseInt(str4));
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(adk adkVar, Map map) throws NumberFormatException {
        int i;
        adk adkVar2 = adkVar;
        String str = (String) map.get("action");
        if (str == null) {
            xe.e("Action missing from video GMSG.");
            return;
        }
        if (xe.a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String string = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(string).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(string);
            xe.b(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                xe.e("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                adkVar2.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                xe.e("Invalid color parameter in video GMSG.");
                return;
            }
        }
        if ("decoderProps".equals(str)) {
            String str3 = (String) map.get("mimeTypes");
            if (str3 == null) {
                xe.e("No MIME types specified for decoder properties inspection.");
                acv.a(adkVar2, "missingMimeTypes");
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                xe.e("Video decoder properties available on API versions >= 16.");
                acv.a(adkVar2, "deficientApiVersion");
                return;
            }
            HashMap map2 = new HashMap();
            for (String str4 : str3.split(",")) {
                map2.put(str4, aaa.a(str4.trim()));
            }
            acv.a(adkVar2, map2);
            return;
        }
        adb adbVarA = adkVar2.a();
        if (adbVarA == null) {
            xe.e("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean zEquals = "new".equals(str);
        boolean zEquals2 = "position".equals(str);
        if (zEquals || zEquals2) {
            Context context = adkVar2.getContext();
            int iA = a(context, map, "x", 0);
            int iA2 = a(context, map, "y", 0);
            int iA3 = a(context, map, "w", -1);
            int iA4 = a(context, map, "h", -1);
            int iMin = Math.min(iA3, adkVar2.m() - iA);
            int iMin2 = Math.min(iA4, adkVar2.l() - iA2);
            try {
                i = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException unused2) {
                i = 0;
            }
            boolean z = Boolean.parseBoolean((String) map.get("spherical"));
            if (zEquals && adbVarA.a() == null) {
                adbVarA.a(iA, iA2, iMin, iMin2, i, z, new adj((String) map.get("flags")));
                acv acvVarA = adbVarA.a();
                if (acvVarA != null) {
                    a(acvVarA, map);
                    return;
                }
                return;
            }
            adbVarA.a(iA, iA2, iMin, iMin2);
            return;
        }
        agj agjVarB = adkVar2.b();
        if (agjVarB != null) {
            if ("timeupdate".equals(str)) {
                String str5 = (String) map.get("currentTime");
                if (str5 == null) {
                    xe.e("currentTime parameter missing from timeupdate video GMSG.");
                    return;
                } else {
                    try {
                        agjVarB.a(Float.parseFloat(str5));
                    } catch (NumberFormatException unused3) {
                        String strValueOf = String.valueOf(str5);
                        xe.e(strValueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(strValueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                    }
                }
            } else if ("skip".equals(str)) {
                agjVarB.k();
            }
        }
        acv acvVarA2 = adbVarA.a();
        if (acvVarA2 == null) {
            acv.a(adkVar2);
            return;
        }
        if ("click".equals(str)) {
            Context context2 = adkVar2.getContext();
            int iA5 = a(context2, map, "x", 0);
            int iA6 = a(context2, map, "y", 0);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, iA5, iA6, 0);
            acvVarA2.a(motionEventObtain);
            motionEventObtain.recycle();
            return;
        }
        if ("currentTime".equals(str)) {
            String str6 = (String) map.get("time");
            if (str6 == null) {
                xe.e("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                acvVarA2.a((int) (Float.parseFloat(str6) * 1000.0f));
                return;
            } catch (NumberFormatException unused4) {
                String strValueOf2 = String.valueOf(str6);
                xe.e(strValueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(strValueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                return;
            }
        }
        if ("hide".equals(str)) {
            acvVarA2.setVisibility(4);
            return;
        }
        if ("load".equals(str)) {
            acvVarA2.h();
            return;
        }
        if ("loadControl".equals(str)) {
            a(acvVarA2, map);
            return;
        }
        if ("muted".equals(str)) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                acvVarA2.k();
                return;
            } else {
                acvVarA2.l();
                return;
            }
        }
        if ("pause".equals(str)) {
            acvVarA2.i();
            return;
        }
        if ("play".equals(str)) {
            acvVarA2.j();
            return;
        }
        if ("show".equals(str)) {
            acvVarA2.setVisibility(0);
            return;
        }
        if ("src".equals(str)) {
            acvVarA2.a((String) map.get("src"));
            return;
        }
        if ("touchMove".equals(str)) {
            Context context3 = adkVar2.getContext();
            acvVarA2.a(a(context3, map, "dx", 0), a(context3, map, "dy", 0));
            if (this.f1910a) {
                return;
            }
            adkVar2.f();
            this.f1910a = true;
            return;
        }
        if ("volume".equals(str)) {
            String str7 = (String) map.get("volume");
            if (str7 == null) {
                xe.e("Level parameter missing from volume video GMSG.");
                return;
            }
            try {
                acvVarA2.setVolume(Float.parseFloat(str7));
                return;
            } catch (NumberFormatException unused5) {
                String strValueOf3 = String.valueOf(str7);
                xe.e(strValueOf3.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(strValueOf3) : new String("Could not parse volume parameter from volume video GMSG: "));
                return;
            }
        }
        if ("watermark".equals(str)) {
            acvVarA2.m();
        } else {
            String strValueOf4 = String.valueOf(str);
            xe.e(strValueOf4.length() != 0 ? "Unknown video action: ".concat(strValueOf4) : new String("Unknown video action: "));
        }
    }
}
