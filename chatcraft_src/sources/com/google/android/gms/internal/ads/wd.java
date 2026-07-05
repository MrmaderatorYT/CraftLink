package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

@qj
/* loaded from: classes.dex */
public final class wd {
    public static String a(String str, Context context, boolean z) {
        String strE;
        if ((((Boolean) bra.e().a(o.ak)).booleanValue() && !z) || !com.google.android.gms.ads.internal.ax.E().a(context) || TextUtils.isEmpty(str) || (strE = com.google.android.gms.ads.internal.ax.E().e(context)) == null) {
            return str;
        }
        if (((Boolean) bra.e().a(o.af)).booleanValue()) {
            CharSequence charSequence = (String) bra.e().a(o.ag);
            if (str.contains(charSequence)) {
                if (com.google.android.gms.ads.internal.ax.e().d(str)) {
                    com.google.android.gms.ads.internal.ax.E().d(context, strE);
                    return str.replace(charSequence, strE);
                }
                if (com.google.android.gms.ads.internal.ax.e().e(str)) {
                    com.google.android.gms.ads.internal.ax.E().e(context, strE);
                    return str.replace(charSequence, strE);
                }
            }
        } else if (!str.contains("fbs_aeid")) {
            if (com.google.android.gms.ads.internal.ax.e().d(str)) {
                com.google.android.gms.ads.internal.ax.E().d(context, strE);
                return a(str, "fbs_aeid", strE).toString();
            }
            if (com.google.android.gms.ads.internal.ax.e().e(str)) {
                com.google.android.gms.ads.internal.ax.E().e(context, strE);
                return a(str, "fbs_aeid", strE).toString();
            }
        }
        return str;
    }

    public static String a(String str, Context context) {
        String strE;
        if (!com.google.android.gms.ads.internal.ax.E().a(context) || TextUtils.isEmpty(str) || (strE = com.google.android.gms.ads.internal.ax.E().e(context)) == null || !com.google.android.gms.ads.internal.ax.e().e(str)) {
            return str;
        }
        if (((Boolean) bra.e().a(o.af)).booleanValue()) {
            CharSequence charSequence = (String) bra.e().a(o.ag);
            if (str.contains(charSequence)) {
                return str.replace(charSequence, strE);
            }
        } else if (!str.contains("fbs_aeid")) {
            return a(str, "fbs_aeid", strE).toString();
        }
        return str;
    }

    public static String a(Uri uri, Context context) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!com.google.android.gms.ads.internal.ax.E().a(context)) {
            return uri.toString();
        }
        String strE = com.google.android.gms.ads.internal.ax.E().e(context);
        if (strE == null) {
            return uri.toString();
        }
        if (((Boolean) bra.e().a(o.af)).booleanValue()) {
            String str = (String) bra.e().a(o.ag);
            String string = uri.toString();
            if (string.contains(str)) {
                com.google.android.gms.ads.internal.ax.E().d(context, strE);
                return string.replace(str, strE);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            uri = a(uri.toString(), "fbs_aeid", strE);
            com.google.android.gms.ads.internal.ax.E().d(context, strE);
        }
        return uri.toString();
    }

    private static Uri a(String str, String str2, String str3) {
        int iIndexOf = str.indexOf("&adurl");
        if (iIndexOf == -1) {
            iIndexOf = str.indexOf("?adurl");
        }
        if (iIndexOf != -1) {
            int i = iIndexOf + 1;
            return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
        }
        return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }
}
