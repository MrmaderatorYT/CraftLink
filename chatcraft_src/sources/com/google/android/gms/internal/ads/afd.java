package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class afd implements com.google.android.gms.ads.internal.gmsg.ac<adk> {
    private static Integer a(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            xe.e(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(adk adkVar, Map map) {
        aex aexVarA;
        adk adkVar2 = adkVar;
        if (xe.a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String strValueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(strValueOf);
            xe.b(sb.toString());
        }
        com.google.android.gms.ads.internal.ax.C();
        if (map.containsKey("abort")) {
            if (aew.a(adkVar2)) {
                return;
            }
            xe.e("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        if (str != null) {
            if (aew.b(adkVar2) != null) {
                xe.e("Precache task is already running.");
                return;
            }
            if (adkVar2.e() == null) {
                xe.e("Precache requires a dependency provider.");
                return;
            }
            adj adjVar = new adj((String) map.get("flags"));
            Integer numA = a(map, "player");
            if (numA == null) {
                numA = 0;
            }
            aexVarA = adkVar2.e().f1565a.a(adkVar2, numA.intValue(), null, adjVar);
            new aeu(adkVar2, aexVarA, str).c();
        } else {
            aeu aeuVarB = aew.b(adkVar2);
            if (aeuVarB != null) {
                aexVarA = aeuVarB.f1912b;
            } else {
                xe.e("Precache must specify a source.");
                return;
            }
        }
        Integer numA2 = a(map, "minBufferMs");
        if (numA2 != null) {
            aexVarA.c(numA2.intValue());
        }
        Integer numA3 = a(map, "maxBufferMs");
        if (numA3 != null) {
            aexVarA.a(numA3.intValue());
        }
        Integer numA4 = a(map, "bufferForPlaybackMs");
        if (numA4 != null) {
            aexVarA.d(numA4.intValue());
        }
        Integer numA5 = a(map, "bufferForPlaybackAfterRebufferMs");
        if (numA5 != null) {
            aexVarA.e(numA5.intValue());
        }
    }
}
