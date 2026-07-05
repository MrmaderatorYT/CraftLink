package org.xbill.DNS.a;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.ByteArrayOutputStream;

/* compiled from: base32.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f5301a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5302b;
    private boolean c;

    private static int a(int i) {
        switch (i) {
            case 1:
                return 6;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 1;
            case 5:
                return 0;
            default:
                return -1;
        }
    }

    public b(String str, boolean z, boolean z2) {
        this.f5301a = str;
        this.f5302b = z;
        this.c = z2;
    }

    public String a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < (bArr.length + 4) / 5; i++) {
            short[] sArr = new short[5];
            int[] iArr = new int[8];
            int i2 = 5;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = (i * 5) + i3;
                if (i4 < bArr.length) {
                    sArr[i3] = (short) (bArr[i4] & Constants.DimensionIds.NETHER);
                } else {
                    sArr[i3] = 0;
                    i2--;
                }
            }
            int iA = a(i2);
            iArr[0] = (byte) ((sArr[0] >> 3) & 31);
            iArr[1] = (byte) (((sArr[0] & 7) << 2) | ((sArr[1] >> 6) & 3));
            iArr[2] = (byte) ((sArr[1] >> 1) & 31);
            iArr[3] = (byte) (((sArr[1] & 1) << 4) | ((sArr[2] >> 4) & 15));
            iArr[4] = (byte) (((sArr[2] & 15) << 1) | (1 & (sArr[3] >> 7)));
            iArr[5] = (byte) ((sArr[3] >> 2) & 31);
            iArr[6] = (byte) (((sArr[4] >> 5) & 7) | ((sArr[3] & 3) << 3));
            iArr[7] = (byte) (sArr[4] & 31);
            for (int i5 = 0; i5 < iArr.length - iA; i5++) {
                char cCharAt = this.f5301a.charAt(iArr[i5]);
                if (this.c) {
                    cCharAt = Character.toLowerCase(cCharAt);
                }
                byteArrayOutputStream.write(cCharAt);
            }
            if (this.f5302b) {
                for (int length = iArr.length - iA; length < iArr.length; length++) {
                    byteArrayOutputStream.write(61);
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
}
