package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.util.Stack;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class bco implements bcr {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2520a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    private final Stack<bcq> f2521b = new Stack<>();
    private final bcy c = new bcy();
    private bcs d;
    private int e;
    private int f;
    private long g;

    bco() {
    }

    @Override // com.google.android.gms.internal.ads.bcr
    public final void a(bcs bcsVar) {
        this.d = bcsVar;
    }

    @Override // com.google.android.gms.internal.ads.bcr
    public final void a() {
        this.e = 0;
        this.f2521b.clear();
        this.c.a();
    }

    @Override // com.google.android.gms.internal.ads.bcr
    public final boolean a(bce bceVar) throws zzfx {
        String str;
        double dLongBitsToDouble;
        bjq.b(this.d != null);
        while (true) {
            if (!this.f2521b.isEmpty() && bceVar.b() >= this.f2521b.peek().f2523b) {
                this.d.c(this.f2521b.pop().f2522a);
                return true;
            }
            if (this.e == 0) {
                long jA = this.c.a(bceVar, true, false, 4);
                if (jA == -2) {
                    bceVar.a();
                    while (true) {
                        bceVar.c(this.f2520a, 0, 4);
                        int iA = bcy.a(this.f2520a[0]);
                        if (iA != -1 && iA <= 4) {
                            int iA2 = (int) bcy.a(this.f2520a, iA, false);
                            if (this.d.b(iA2)) {
                                bceVar.b(iA);
                                jA = iA2;
                            }
                        }
                        bceVar.b(1);
                    }
                }
                if (jA == -1) {
                    return false;
                }
                this.f = (int) jA;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.a(bceVar, false, true, 8);
                this.e = 2;
            }
            int iA3 = this.d.a(this.f);
            switch (iA3) {
                case 0:
                    bceVar.b((int) this.g);
                    this.e = 0;
                case 1:
                    long jB = bceVar.b();
                    this.f2521b.add(new bcq(this.f, this.g + jB));
                    this.d.a(this.f, jB, this.g);
                    this.e = 0;
                    return true;
                case 2:
                    if (this.g > 8) {
                        long j = this.g;
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Invalid integer size: ");
                        sb.append(j);
                        throw new zzfx(sb.toString());
                    }
                    this.d.a(this.f, a(bceVar, (int) this.g));
                    this.e = 0;
                    return true;
                case 3:
                    if (this.g > 2147483647L) {
                        long j2 = this.g;
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j2);
                        throw new zzfx(sb2.toString());
                    }
                    bcs bcsVar = this.d;
                    int i = this.f;
                    int i2 = (int) this.g;
                    if (i2 == 0) {
                        str = BuildConfig.FLAVOR;
                    } else {
                        byte[] bArr = new byte[i2];
                        bceVar.b(bArr, 0, i2);
                        str = new String(bArr);
                    }
                    bcsVar.a(i, str);
                    this.e = 0;
                    return true;
                case 4:
                    this.d.a(this.f, (int) this.g, bceVar);
                    this.e = 0;
                    return true;
                case 5:
                    if (this.g != 4 && this.g != 8) {
                        long j3 = this.g;
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j3);
                        throw new zzfx(sb3.toString());
                    }
                    bcs bcsVar2 = this.d;
                    int i3 = this.f;
                    int i4 = (int) this.g;
                    long jA2 = a(bceVar, i4);
                    if (i4 == 4) {
                        dLongBitsToDouble = Float.intBitsToFloat((int) jA2);
                    } else {
                        dLongBitsToDouble = Double.longBitsToDouble(jA2);
                    }
                    bcsVar2.a(i3, dLongBitsToDouble);
                    this.e = 0;
                    return true;
                default:
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(iA3);
                    throw new zzfx(sb4.toString());
            }
        }
    }

    private final long a(bce bceVar, int i) {
        bceVar.b(this.f2520a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.f2520a[i2] & Constants.DimensionIds.NETHER);
        }
        return j;
    }
}
