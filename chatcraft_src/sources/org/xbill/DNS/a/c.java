package org.xbill.DNS.a;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.ByteArrayOutputStream;

/* compiled from: base64.java */
/* loaded from: classes.dex */
public class c {
    public static String a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < (bArr.length + 2) / 3; i++) {
            short[] sArr = new short[3];
            short[] sArr2 = new short[4];
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = (i * 3) + i2;
                if (i3 < bArr.length) {
                    sArr[i2] = (short) (bArr[i3] & Constants.DimensionIds.NETHER);
                } else {
                    sArr[i2] = -1;
                }
            }
            sArr2[0] = (short) (sArr[0] >> 2);
            if (sArr[1] == -1) {
                sArr2[1] = (short) ((sArr[0] & 3) << 4);
            } else {
                sArr2[1] = (short) (((sArr[0] & 3) << 4) + (sArr[1] >> 4));
            }
            if (sArr[1] == -1) {
                sArr2[3] = 64;
                sArr2[2] = 64;
            } else if (sArr[2] == -1) {
                sArr2[2] = (short) ((sArr[1] & 15) << 2);
                sArr2[3] = 64;
            } else {
                sArr2[2] = (short) (((sArr[1] & 15) << 2) + (sArr[2] >> 6));
                sArr2[3] = (short) (sArr[2] & 63);
            }
            for (int i4 = 0; i4 < 4; i4++) {
                byteArrayOutputStream.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(sArr2[i4]));
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    public static String a(byte[] bArr, int i, String str, boolean z) {
        String strA = a(bArr);
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (i2 < strA.length()) {
            stringBuffer.append(str);
            int i3 = i2 + i;
            if (i3 >= strA.length()) {
                stringBuffer.append(strA.substring(i2));
                if (z) {
                    stringBuffer.append(" )");
                }
            } else {
                stringBuffer.append(strA.substring(i2, i3));
                stringBuffer.append("\n");
            }
            i2 = i3;
        }
        return stringBuffer.toString();
    }
}
