package com.github.steveice10.mc.auth.util;

import com.github.steveice10.mc.v1_5.util.Constants;

/* loaded from: classes.dex */
public class Base64 {
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final byte[] ALPHABET = {65, 66, 67, 68, 69, Constants.ObjectIds.FALLING_OBJECT, Constants.ObjectIds.ITEM_FRAME, Constants.ObjectIds.EYE_OF_ENDER, Constants.ObjectIds.THROWN_POTION, 74, Constants.ObjectIds.XP_BOTTLE, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, Constants.MobIds.SNOWMAN, Constants.MobIds.OCELOT, Constants.MobIds.IRON_GOLEM, 100, 101, Constants.AnimationIds.UNKNOWN, 103, Constants.AnimationIds.CROUCH, Constants.AnimationIds.UNCROUCH, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, Constants.MobIds.VILLAGER, 121, 122, 48, 49, 50, 51, Constants.MobIds.SPIDER, Constants.MobIds.GIANT_ZOMBIE, Constants.MobIds.ZOMBIE, Constants.MobIds.SLIME, Constants.MobIds.GHAST, Constants.MobIds.ZOMBIE_PIGMAN, 43, 47};
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte[] DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, WHITE_SPACE_ENC, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, WHITE_SPACE_ENC, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Constants.MobIds.ENDER_DRAGON, Constants.MobIds.SPIDER, Constants.MobIds.GIANT_ZOMBIE, Constants.MobIds.ZOMBIE, Constants.MobIds.SLIME, Constants.MobIds.GHAST, Constants.MobIds.ZOMBIE_PIGMAN, Constants.MobIds.ENDERMAN, Constants.MobIds.CAVE_SPIDER, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private Base64() {
    }

    public static byte[] encode(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        byte[] bArr2 = new byte[((bArr.length / 3) * 4) + (bArr.length % 3 <= 0 ? 0 : 4)];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length - 2) {
            encode3to4(bArr, i, 3, bArr2, i2);
            i += 3;
            i2 += 4;
        }
        if (i < bArr.length) {
            encode3to4(bArr, i, bArr.length - i, bArr2, i2);
            i2 += 4;
        }
        if (i2 > bArr2.length - 1) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, i2);
        return bArr3;
    }

    public static byte[] decode(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        byte[] bArr2 = new byte[(bArr.length * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i = 0;
        int iDecode4to3 = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = DECODABET[bArr[i2] & 255];
            if (b2 < -5) {
                throw new IllegalArgumentException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)));
            }
            if (b2 >= -1) {
                int i3 = i + 1;
                bArr3[i] = bArr[i2];
                if (i3 > 3) {
                    iDecode4to3 += decode4to3(bArr3, 0, bArr2, iDecode4to3);
                    if (bArr[i2] == 61) {
                        break;
                    }
                    i = 0;
                } else {
                    i = i3;
                }
            }
        }
        byte[] bArr4 = new byte[iDecode4to3];
        System.arraycopy(bArr2, 0, bArr4, 0, iDecode4to3);
        return bArr4;
    }

    private static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0);
        switch (i2) {
            case 1:
                bArr2[i3] = ALPHABET[i4 >>> 18];
                bArr2[i3 + 1] = ALPHABET[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = 61;
                bArr2[i3 + 3] = 61;
                break;
            case 2:
                bArr2[i3] = ALPHABET[i4 >>> 18];
                bArr2[i3 + 1] = ALPHABET[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = ALPHABET[(i4 >>> 6) & 63];
                bArr2[i3 + 3] = 61;
                break;
            case 3:
                bArr2[i3] = ALPHABET[i4 >>> 18];
                bArr2[i3 + 1] = ALPHABET[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = ALPHABET[(i4 >>> 6) & 63];
                bArr2[i3 + 3] = ALPHABET[i4 & 63];
                break;
        }
        return bArr2;
    }

    private static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3;
        int i4;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i < 0 || (i3 = i + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        }
        if (i2 < 0 || (i4 = i2 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        }
        int i5 = i + 2;
        if (bArr[i5] == 61) {
            bArr2[i2] = (byte) ((((DECODABET[bArr[i + 1]] & 255) << 12) | ((DECODABET[bArr[i]] & 255) << 18)) >>> 16);
            return 1;
        }
        if (bArr[i3] == 61) {
            int i6 = ((DECODABET[bArr[i5]] & 255) << 6) | ((DECODABET[bArr[i + 1]] & 255) << 12) | ((DECODABET[bArr[i]] & 255) << 18);
            bArr2[i2] = (byte) (i6 >>> 16);
            bArr2[i2 + 1] = (byte) (i6 >>> 8);
            return 2;
        }
        int i7 = (DECODABET[bArr[i3]] & 255) | ((DECODABET[bArr[i + 1]] & 255) << 12) | ((DECODABET[bArr[i]] & 255) << 18) | ((DECODABET[bArr[i5]] & 255) << 6);
        bArr2[i2] = (byte) (i7 >> 16);
        bArr2[i2 + 1] = (byte) (i7 >> 8);
        bArr2[i4] = (byte) i7;
        return 3;
    }
}
