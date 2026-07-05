package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;

/* loaded from: classes.dex */
final class aty {
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(byte b2) {
        return b2 >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(byte b2) {
        return b2 < -32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(byte b2) {
        return b2 < -16;
    }

    private static boolean g(byte b2) {
        return b2 > -65;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(byte b2, char[] cArr, int i) {
        cArr[i] = (char) b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(byte b2, byte b3, char[] cArr, int i) throws zzbrl {
        if (b2 < -62 || g(b3)) {
            throw zzbrl.i();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & Constants.MobIds.ENDER_DRAGON));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(byte b2, byte b3, byte b4, char[] cArr, int i) throws zzbrl {
        if (g(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || g(b4)))) {
            throw zzbrl.i();
        }
        cArr[i] = (char) (((b2 & 15) << 12) | ((b3 & Constants.MobIds.ENDER_DRAGON) << 6) | (b4 & Constants.MobIds.ENDER_DRAGON));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws zzbrl {
        if (g(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || g(b4) || g(b5)) {
            throw zzbrl.i();
        }
        int i2 = ((b2 & 7) << 18) | ((b3 & Constants.MobIds.ENDER_DRAGON) << 12) | ((b4 & Constants.MobIds.ENDER_DRAGON) << 6) | (b5 & Constants.MobIds.ENDER_DRAGON);
        cArr[i] = (char) ((i2 >>> 10) + 55232);
        cArr[i + 1] = (char) ((i2 & 1023) + 56320);
    }
}
