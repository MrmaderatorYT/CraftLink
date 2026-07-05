package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

@qj
/* loaded from: classes.dex */
public final class aee implements azq, bfp, bjp<bja>, bkw {

    /* renamed from: a, reason: collision with root package name */
    private static int f1893a;

    /* renamed from: b, reason: collision with root package name */
    private static int f1894b;
    private final Context c;
    private final bag e;
    private final adj h;
    private azp i;
    private ByteBuffer j;
    private boolean k;
    private ael l;
    private int m;
    private final aed d = new aed();
    private final bag f = new bbh(bef.f2581a);
    private final bio g = new bil();

    public aee(Context context, adj adjVar) {
        this.c = context;
        this.h = adjVar;
        this.e = new bkq(this.c, bef.f2581a, 0L, xn.f3583a, this, -1);
        if (xe.a()) {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(strValueOf);
            xe.a(sb.toString());
        }
        f1893a++;
        this.i = azt.a(new bag[]{this.f, this.e}, this.g, this.d);
        this.i.a(this);
    }

    @Override // com.google.android.gms.internal.ads.bkw
    public final void a(int i, long j) {
    }

    @Override // com.google.android.gms.internal.ads.bkw
    public final void a(Surface surface) {
    }

    @Override // com.google.android.gms.internal.ads.bkw
    public final void a(bab babVar) {
    }

    @Override // com.google.android.gms.internal.ads.azq
    public final void a(baf bafVar) {
    }

    @Override // com.google.android.gms.internal.ads.azq
    public final void a(baj bajVar, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.bkw
    public final void a(bbr bbrVar) {
    }

    @Override // com.google.android.gms.internal.ads.azq
    public final void a(bgf bgfVar, bit bitVar) {
    }

    @Override // com.google.android.gms.internal.ads.bjp
    public final /* bridge */ /* synthetic */ void a(bja bjaVar) {
    }

    @Override // com.google.android.gms.internal.ads.bkw
    public final void a(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.azq
    public final void a(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.bkw
    public final void b(bbr bbrVar) {
    }

    @Override // com.google.android.gms.internal.ads.azq
    public final void g() {
    }

    public final azp a() {
        return this.i;
    }

    public static int b() {
        return f1893a;
    }

    public static int c() {
        return f1894b;
    }

    public final void a(ael aelVar) {
        this.l = aelVar;
    }

    public final aed d() {
        return this.d;
    }

    public final void a(Uri uri, String str) {
        a(uri, str, ByteBuffer.allocate(0), false);
    }

    public final void a(Uri uri, String str, ByteBuffer byteBuffer, boolean z) {
        bfs bfoVar;
        this.j = byteBuffer;
        this.k = z;
        if (this.h.j) {
            bjb bjbVarB = b(str);
            bfoVar = new bgy(uri, bjbVarB, new bhl(bjbVarB), xn.f3583a, null);
        } else {
            bfoVar = new bfo(uri, b(str), aej.f1902a, -1, xn.f3583a, this, null, this.h.g);
        }
        this.i.a(bfoVar);
        f1894b++;
    }

    public final void e() {
        if (this.i != null) {
            this.i.b(this);
            this.i.d();
            this.i = null;
            f1894b--;
        }
    }

    public final long f() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.bfp
    public final void a(IOException iOException) {
        if (this.l != null) {
            this.l.a("onLoadError", iOException);
        }
    }

    @Override // com.google.android.gms.internal.ads.bkw
    public final void a(int i, int i2, int i3, float f) {
        if (this.l != null) {
            this.l.a(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.azq
    public final void a(boolean z, int i) {
        if (this.l != null) {
            this.l.b(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.azq
    public final void a(zzff zzffVar) {
        if (this.l != null) {
            this.l.a("onPlayerError", zzffVar);
        }
    }

    final void a(Surface surface, boolean z) {
        azs azsVar = new azs(this.e, 1, surface);
        if (z) {
            this.i.b(azsVar);
        } else {
            this.i.a(azsVar);
        }
    }

    final void a(float f, boolean z) {
        azs azsVar = new azs(this.f, 2, Float.valueOf(f));
        if (z) {
            this.i.b(azsVar);
        } else {
            this.i.a(azsVar);
        }
    }

    final void b(boolean z) {
        for (int i = 0; i < this.i.e(); i++) {
            this.g.a(i, !z);
        }
    }

    private final bjb b(final String str) {
        if (this.k && this.j.limit() > 0) {
            final byte[] bArr = new byte[this.j.limit()];
            this.j.get(bArr);
            return new bjb(bArr) { // from class: com.google.android.gms.internal.ads.aef

                /* renamed from: a, reason: collision with root package name */
                private final byte[] f1895a;

                {
                    this.f1895a = bArr;
                }

                @Override // com.google.android.gms.internal.ads.bjb
                public final bja a() {
                    return new biz(this.f1895a);
                }
            };
        }
        final bjb bjbVar = new bjb(this, str) { // from class: com.google.android.gms.internal.ads.aeg

            /* renamed from: a, reason: collision with root package name */
            private final aee f1896a;

            /* renamed from: b, reason: collision with root package name */
            private final String f1897b;

            {
                this.f1896a = this;
                this.f1897b = str;
            }

            @Override // com.google.android.gms.internal.ads.bjb
            public final bja a() {
                return this.f1896a.a(this.f1897b);
            }
        };
        final bjb bjbVar2 = this.h.i ? new bjb(this, bjbVar) { // from class: com.google.android.gms.internal.ads.aeh

            /* renamed from: a, reason: collision with root package name */
            private final aee f1898a;

            /* renamed from: b, reason: collision with root package name */
            private final bjb f1899b;

            {
                this.f1898a = this;
                this.f1899b = bjbVar;
            }

            @Override // com.google.android.gms.internal.ads.bjb
            public final bja a() {
                return this.f1898a.a(this.f1899b);
            }
        } : bjbVar;
        if (this.j.limit() <= 0) {
            return bjbVar2;
        }
        final byte[] bArr2 = new byte[this.j.limit()];
        this.j.get(bArr2);
        return new bjb(bjbVar2, bArr2) { // from class: com.google.android.gms.internal.ads.aei

            /* renamed from: a, reason: collision with root package name */
            private final bjb f1900a;

            /* renamed from: b, reason: collision with root package name */
            private final byte[] f1901b;

            {
                this.f1900a = bjbVar2;
                this.f1901b = bArr2;
            }

            @Override // com.google.android.gms.internal.ads.bjb
            public final bja a() {
                bjb bjbVar3 = this.f1900a;
                byte[] bArr3 = this.f1901b;
                return new aen(new biz(bArr3), bArr3.length, bjbVar3.a());
            }
        };
    }

    public final void finalize() {
        f1893a--;
        if (xe.a()) {
            String strValueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(strValueOf);
            xe.a(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.bjp
    public final /* synthetic */ void a(bja bjaVar, int i) {
        this.m += i;
    }

    @Override // com.google.android.gms.internal.ads.bjp
    public final /* synthetic */ void a(bja bjaVar, bjd bjdVar) {
        this.m = 0;
    }

    final /* synthetic */ bja a(bjb bjbVar) {
        return new aeb(this.c, bjbVar.a(), this, new aec(this) { // from class: com.google.android.gms.internal.ads.aek

            /* renamed from: a, reason: collision with root package name */
            private final aee f1903a;

            {
                this.f1903a = this;
            }

            @Override // com.google.android.gms.internal.ads.aec
            public final void a(boolean z, long j) {
                this.f1903a.a(z, j);
            }
        });
    }

    final /* synthetic */ void a(boolean z, long j) {
        if (this.l != null) {
            this.l.a(z, j);
        }
    }

    final /* synthetic */ bja a(String str) {
        return new bjg(str, null, this.h.i ? null : this, this.h.d, this.h.f, true, null);
    }
}
