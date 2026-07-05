package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ban {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2454a = {1, 2, 3, 6};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f2455b = {48000, 44100, 32000};
    private static final int[] c = {24000, 22050, 16000};
    private static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, ModuleDescriptor.MODULE_VERSION, 384, 448, 512, 576, 640};
    private static final int[] f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int a() {
        return 1536;
    }

    public static bab a(bjz bjzVar, String str, String str2, bbt bbtVar) {
        int i = f2455b[(bjzVar.f() & 192) >> 6];
        int iF = bjzVar.f();
        int i2 = d[(iF & 56) >> 3];
        if ((iF & 4) != 0) {
            i2++;
        }
        return bab.a(str, "audio/ac3", null, -1, -1, i2, i, null, bbtVar, 0, str2);
    }

    public static bab b(bjz bjzVar, String str, String str2, bbt bbtVar) {
        bjzVar.d(2);
        int i = f2455b[(bjzVar.f() & 192) >> 6];
        int iF = bjzVar.f();
        int i2 = d[(iF & 14) >> 1];
        if ((iF & 1) != 0) {
            i2++;
        }
        return bab.a(str, "audio/eac3", null, -1, -1, i2, i, null, bbtVar, 0, str2);
    }

    public static int a(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? f2454a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }
}
