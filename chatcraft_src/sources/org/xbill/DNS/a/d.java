package org.xbill.DNS.a;

import com.github.steveice10.mc.v1_5.util.Constants;

/* compiled from: hexdump.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f5303a = "0123456789ABCDEF".toCharArray();

    public static String a(String str, byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(i2);
        stringBuffer2.append("b");
        stringBuffer.append(stringBuffer2.toString());
        if (str != null) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(" (");
            stringBuffer3.append(str);
            stringBuffer3.append(")");
            stringBuffer.append(stringBuffer3.toString());
        }
        stringBuffer.append(':');
        int length = (stringBuffer.toString().length() + 8) & (-8);
        stringBuffer.append('\t');
        int i3 = (80 - length) / 3;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 != 0 && i4 % i3 == 0) {
                stringBuffer.append('\n');
                for (int i5 = 0; i5 < length / 8; i5++) {
                    stringBuffer.append('\t');
                }
            }
            int i6 = bArr[i4 + i] & Constants.DimensionIds.NETHER;
            stringBuffer.append(f5303a[i6 >> 4]);
            stringBuffer.append(f5303a[i6 & 15]);
            stringBuffer.append(' ');
        }
        stringBuffer.append('\n');
        return stringBuffer.toString();
    }

    public static String a(String str, byte[] bArr) {
        return a(str, bArr, 0, bArr.length);
    }
}
