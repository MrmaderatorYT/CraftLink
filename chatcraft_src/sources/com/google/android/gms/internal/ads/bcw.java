package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class bcw {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G;
    public int H;
    public int I;
    public long J;
    public long K;
    public boolean L;
    public boolean M;
    public bcm N;
    public int O;
    private String P;

    /* renamed from: a, reason: collision with root package name */
    public String f2527a;

    /* renamed from: b, reason: collision with root package name */
    public int f2528b;
    public int c;
    public int d;
    public boolean e;
    public byte[] f;
    public bcn g;
    public byte[] h;
    public bbt i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public float w;
    public float x;
    public float y;
    public float z;

    private bcw() {
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = 0;
        this.o = null;
        this.p = -1;
        this.q = false;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = 1000;
        this.v = 200;
        this.w = -1.0f;
        this.x = -1.0f;
        this.y = -1.0f;
        this.z = -1.0f;
        this.A = -1.0f;
        this.B = -1.0f;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = -1.0f;
        this.F = -1.0f;
        this.G = 1;
        this.H = -1;
        this.I = 8000;
        this.J = 0L;
        this.K = 0L;
        this.M = true;
        this.P = "eng";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:146:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.android.gms.internal.ads.bcf r28, int r29) throws com.google.android.gms.internal.ads.zzfx {
        /*
            Method dump skipped, instructions count: 1446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcw.a(com.google.android.gms.internal.ads.bcf, int):void");
    }

    private static List<byte[]> a(bjz bjzVar) throws zzfx {
        try {
            bjzVar.d(16);
            if (bjzVar.k() != 826496599) {
                return null;
            }
            byte[] bArr = bjzVar.f2752a;
            for (int iD = bjzVar.d() + 20; iD < bArr.length - 4; iD++) {
                if (bArr[iD] == 0 && bArr[iD + 1] == 0 && bArr[iD + 2] == 1 && bArr[iD + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, iD, bArr.length));
                }
            }
            throw new zzfx("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzfx("Error parsing FourCC VC1 codec private");
        }
    }

    private static List<byte[]> a(byte[] bArr) throws zzfx {
        try {
            if (bArr[0] != 2) {
                throw new zzfx("Error parsing vorbis codec private");
            }
            int i = 1;
            int i2 = 0;
            while (bArr[i] == -1) {
                i2 += 255;
                i++;
            }
            int i3 = i + 1;
            int i4 = i2 + bArr[i];
            int i5 = 0;
            while (bArr[i3] == -1) {
                i5 += 255;
                i3++;
            }
            int i6 = i3 + 1;
            int i7 = i5 + bArr[i3];
            if (bArr[i6] != 1) {
                throw new zzfx("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i6, bArr2, 0, i4);
            int i8 = i6 + i4;
            if (bArr[i8] != 3) {
                throw new zzfx("Error parsing vorbis codec private");
            }
            int i9 = i8 + i7;
            if (bArr[i9] != 5) {
                throw new zzfx("Error parsing vorbis codec private");
            }
            byte[] bArr3 = new byte[bArr.length - i9];
            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzfx("Error parsing vorbis codec private");
        }
    }

    private static boolean b(bjz bjzVar) throws zzfx {
        try {
            int iH = bjzVar.h();
            if (iH == 1) {
                return true;
            }
            if (iH != 65534) {
                return false;
            }
            bjzVar.c(24);
            if (bjzVar.m() == bct.d.getMostSignificantBits()) {
                if (bjzVar.m() == bct.d.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzfx("Error parsing MS/ACM codec private");
        }
    }

    /* synthetic */ bcw(bcu bcuVar) {
        this();
    }
}
