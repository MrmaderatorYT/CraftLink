package com.google.android.gms.internal.ads;

import java.util.Locale;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class bif {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f2696a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f2697b;
    private final String[] c;
    private final int d;

    public static bif a(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        strArr[0] = BuildConfig.FLAVOR;
        int length = 0;
        int i = 0;
        while (length < str.length()) {
            int iIndexOf = str.indexOf("$", length);
            char c = 65535;
            if (iIndexOf == -1) {
                String strValueOf = String.valueOf(strArr[i]);
                String strValueOf2 = String.valueOf(str.substring(length));
                strArr[i] = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                length = str.length();
            } else if (iIndexOf != length) {
                String strValueOf3 = String.valueOf(strArr[i]);
                String strValueOf4 = String.valueOf(str.substring(length, iIndexOf));
                strArr[i] = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
                length = iIndexOf;
            } else if (str.startsWith("$$", length)) {
                strArr[i] = String.valueOf(strArr[i]).concat("$");
                length += 2;
            } else {
                int i2 = length + 1;
                int iIndexOf2 = str.indexOf("$", i2);
                String strSubstring = str.substring(i2, iIndexOf2);
                if (strSubstring.equals("RepresentationID")) {
                    iArr[i] = 1;
                } else {
                    int iIndexOf3 = strSubstring.indexOf("%0");
                    String strSubstring2 = "%01d";
                    if (iIndexOf3 != -1) {
                        strSubstring2 = strSubstring.substring(iIndexOf3);
                        if (!strSubstring2.endsWith("d")) {
                            strSubstring2 = String.valueOf(strSubstring2).concat("d");
                        }
                        strSubstring = strSubstring.substring(0, iIndexOf3);
                    }
                    int iHashCode = strSubstring.hashCode();
                    if (iHashCode != -1950496919) {
                        if (iHashCode != 2606829) {
                            if (iHashCode == 38199441 && strSubstring.equals("Bandwidth")) {
                                c = 1;
                            }
                        } else if (strSubstring.equals("Time")) {
                            c = 2;
                        }
                    } else if (strSubstring.equals("Number")) {
                        c = 0;
                    }
                    switch (c) {
                        case 0:
                            iArr[i] = 2;
                            break;
                        case 1:
                            iArr[i] = 3;
                            break;
                        case 2:
                            iArr[i] = 4;
                            break;
                        default:
                            String strValueOf5 = String.valueOf(str);
                            throw new IllegalArgumentException(strValueOf5.length() != 0 ? "Invalid template: ".concat(strValueOf5) : new String("Invalid template: "));
                    }
                    strArr2[i] = strSubstring2;
                }
                i++;
                strArr[i] = BuildConfig.FLAVOR;
                length = iIndexOf2 + 1;
            }
        }
        return new bif(strArr, iArr, strArr2, i);
    }

    private bif(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.f2696a = strArr;
        this.f2697b = iArr;
        this.c = strArr2;
        this.d = i;
    }

    public final String a(String str, int i, int i2, long j) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < this.d; i3++) {
            sb.append(this.f2696a[i3]);
            if (this.f2697b[i3] == 1) {
                sb.append(str);
            } else if (this.f2697b[i3] == 2) {
                sb.append(String.format(Locale.US, this.c[i3], Integer.valueOf(i)));
            } else if (this.f2697b[i3] == 3) {
                sb.append(String.format(Locale.US, this.c[i3], Integer.valueOf(i2)));
            } else if (this.f2697b[i3] == 4) {
                sb.append(String.format(Locale.US, this.c[i3], Long.valueOf(j)));
            }
        }
        sb.append(this.f2696a[this.d]);
        return sb.toString();
    }
}
