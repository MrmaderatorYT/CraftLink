package com.google.android.gms.internal.ads;

import android.net.Uri;

@qj
/* loaded from: classes.dex */
final class aen implements bja {

    /* renamed from: a, reason: collision with root package name */
    private final bja f1905a;

    /* renamed from: b, reason: collision with root package name */
    private final long f1906b;
    private final bja c;
    private long d;
    private Uri e;

    aen(bja bjaVar, int i, bja bjaVar2) {
        this.f1905a = bjaVar;
        this.f1906b = i;
        this.c = bjaVar2;
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final long a(bjd bjdVar) {
        long jMin;
        bjd bjdVar2;
        bjd bjdVar3;
        this.e = bjdVar.f2725a;
        if (bjdVar.d >= this.f1906b) {
            bjdVar2 = null;
        } else {
            long j = bjdVar.d;
            if (bjdVar.e != -1) {
                jMin = Math.min(bjdVar.e, this.f1906b - j);
            } else {
                jMin = this.f1906b - j;
            }
            bjdVar2 = new bjd(bjdVar.f2725a, j, jMin, null);
        }
        if (bjdVar.e == -1 || bjdVar.d + bjdVar.e > this.f1906b) {
            bjdVar3 = new bjd(bjdVar.f2725a, Math.max(this.f1906b, bjdVar.d), bjdVar.e != -1 ? Math.min(bjdVar.e, (bjdVar.d + bjdVar.e) - this.f1906b) : -1L, null);
        } else {
            bjdVar3 = null;
        }
        long jA = bjdVar2 != null ? this.f1905a.a(bjdVar2) : 0L;
        long jA2 = bjdVar3 != null ? this.c.a(bjdVar3) : 0L;
        this.d = bjdVar.d;
        if (jA == -1 || jA2 == -1) {
            return -1L;
        }
        return jA + jA2;
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final int a(byte[] bArr, int i, int i2) {
        int iA;
        if (this.d < this.f1906b) {
            iA = this.f1905a.a(bArr, i, (int) Math.min(i2, this.f1906b - this.d));
            this.d += iA;
        } else {
            iA = 0;
        }
        if (this.d < this.f1906b) {
            return iA;
        }
        int iA2 = this.c.a(bArr, i + iA, i2 - iA);
        int i3 = iA + iA2;
        this.d += iA2;
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final Uri b() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final void a() {
        this.f1905a.a();
        this.c.a();
    }
}
