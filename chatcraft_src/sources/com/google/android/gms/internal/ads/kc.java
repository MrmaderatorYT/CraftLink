package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class kc {
    public static List<String> a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            arrayList.add(jSONArrayOptJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void a(Context context, String str, wk wkVar, String str2, boolean z, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String str3 = z ? "1" : "0";
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strA = a(a(a(a(a(a(a(it.next(), "@gw_adlocid@", str2), "@gw_adnetrefresh@", str3), "@gw_qdata@", wkVar.r.i), "@gw_sdkver@", str), "@gw_sessid@", bra.f()), "@gw_seqnum@", wkVar.j), "@gw_adnetstatus@", wkVar.t);
            if (wkVar.o != null) {
                strA = a(a(strA, "@gw_adnetid@", wkVar.o.f3210b), "@gw_allocid@", wkVar.o.d);
            }
            String strA2 = wd.a(strA, context, wkVar.P);
            com.google.android.gms.ads.internal.ax.e();
            xn.a(context, str, strA2);
        }
    }

    public static void a(Context context, String str, List<String> list, String str2, String str3, vh vhVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String strA = a(str2);
        String strA2 = a(str3);
        long jA = com.google.android.gms.ads.internal.ax.l().a();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strA3 = a(a(a(it.next(), "@gw_rwd_userid@", Uri.encode(strA)), "@gw_rwd_custom_data@", Uri.encode(strA2)), "@gw_tmstmp@", Long.toString(jA));
            if (vhVar != null) {
                strA3 = a(a(strA3, "@gw_rwd_itm@", Uri.encode(vhVar.f3518a)), "@gw_rwd_amt@", Integer.toString(vhVar.f3519b));
            }
            com.google.android.gms.ads.internal.ax.e();
            xn.a(context, str, strA3);
        }
    }

    private static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = BuildConfig.FLAVOR;
        }
        return str.replaceAll(str2, str3);
    }

    private static String a(String str) {
        return (TextUtils.isEmpty(str) || !aag.c()) ? str : "fakeForAdDebugLog";
    }

    public static boolean a(String str, int[] iArr) {
        if (TextUtils.isEmpty(str) || iArr.length != 2) {
            return false;
        }
        String[] strArrSplit = str.split("x");
        if (strArrSplit.length != 2) {
            return false;
        }
        try {
            iArr[0] = Integer.parseInt(strArrSplit[0]);
            iArr[1] = Integer.parseInt(strArrSplit[1]);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
