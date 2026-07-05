package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class bkf {
    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        int[] iArrA = a(str2);
        if (iArrA[0] != -1) {
            sb.append(str2);
            a(sb, iArrA[1], iArrA[2]);
            return sb.toString();
        }
        int[] iArrA2 = a(str);
        if (iArrA[3] == 0) {
            sb.append((CharSequence) str, 0, iArrA2[3]);
            sb.append(str2);
            return sb.toString();
        }
        if (iArrA[2] == 0) {
            sb.append((CharSequence) str, 0, iArrA2[2]);
            sb.append(str2);
            return sb.toString();
        }
        if (iArrA[1] != 0) {
            int i = iArrA2[0] + 1;
            sb.append((CharSequence) str, 0, i);
            sb.append(str2);
            return a(sb, iArrA[1] + i, i + iArrA[2]);
        }
        if (str2.charAt(iArrA[1]) == '/') {
            sb.append((CharSequence) str, 0, iArrA2[1]);
            sb.append(str2);
            return a(sb, iArrA2[1], iArrA2[1] + iArrA[2]);
        }
        if (iArrA2[0] + 2 < iArrA2[1] && iArrA2[1] == iArrA2[2]) {
            sb.append((CharSequence) str, 0, iArrA2[1]);
            sb.append('/');
            sb.append(str2);
            return a(sb, iArrA2[1], iArrA2[1] + iArrA[2] + 1);
        }
        int iLastIndexOf = str.lastIndexOf(47, iArrA2[2] - 1);
        int i2 = iLastIndexOf == -1 ? iArrA2[1] : iLastIndexOf + 1;
        sb.append((CharSequence) str, 0, i2);
        sb.append(str2);
        return a(sb, iArrA2[1], i2 + iArrA[2]);
    }

    private static String a(StringBuilder sb, int i, int i2) {
        int i3;
        if (i >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int iLastIndexOf = i;
        int i4 = i2;
        while (true) {
            for (int i5 = iLastIndexOf; i5 <= i4; i5++) {
                if (i5 == i4) {
                    i3 = i5;
                } else if (sb.charAt(i5) == '/') {
                    i3 = i5 + 1;
                }
                int i6 = iLastIndexOf + 1;
                if (i5 == i6 && sb.charAt(iLastIndexOf) == '.') {
                    sb.delete(iLastIndexOf, i3);
                    i4 -= i3 - iLastIndexOf;
                } else if (i5 == iLastIndexOf + 2 && sb.charAt(iLastIndexOf) == '.' && sb.charAt(i6) == '.') {
                    iLastIndexOf = sb.lastIndexOf("/", iLastIndexOf - 2) + 1;
                    int i7 = iLastIndexOf > i ? iLastIndexOf : i;
                    sb.delete(i7, i3);
                    i4 -= i3 - i7;
                } else {
                    iLastIndexOf = i5 + 1;
                }
            }
            return sb.toString();
        }
    }

    private static int[] a(String str) {
        int iIndexOf;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            length = iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(63);
        if (iIndexOf3 == -1 || iIndexOf3 > length) {
            iIndexOf3 = length;
        }
        int iIndexOf4 = str.indexOf(47);
        if (iIndexOf4 == -1 || iIndexOf4 > iIndexOf3) {
            iIndexOf4 = iIndexOf3;
        }
        int iIndexOf5 = str.indexOf(58);
        if (iIndexOf5 > iIndexOf4) {
            iIndexOf5 = -1;
        }
        int i = iIndexOf5 + 2;
        if (i < iIndexOf3 && str.charAt(iIndexOf5 + 1) == '/' && str.charAt(i) == '/') {
            iIndexOf = str.indexOf(47, iIndexOf5 + 3);
            if (iIndexOf == -1 || iIndexOf > iIndexOf3) {
                iIndexOf = iIndexOf3;
            }
        } else {
            iIndexOf = iIndexOf5 + 1;
        }
        iArr[0] = iIndexOf5;
        iArr[1] = iIndexOf;
        iArr[2] = iIndexOf3;
        iArr[3] = length;
        return iArr;
    }
}
