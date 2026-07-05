package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes.dex */
final class y extends v {
    y() {
    }

    @Override // com.google.android.gms.internal.ads.v
    public final String a(String str, String str2) {
        String strA = a(str);
        String strA2 = a(str2);
        if (TextUtils.isEmpty(strA)) {
            return strA2;
        }
        if (TextUtils.isEmpty(strA2)) {
            return strA;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 1 + String.valueOf(strA2).length());
        sb.append(strA);
        sb.append(",");
        sb.append(strA2);
        return sb.toString();
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i) {
            return null;
        }
        return (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }
}
