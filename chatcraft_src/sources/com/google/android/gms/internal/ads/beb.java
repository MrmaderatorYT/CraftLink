package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
public final class beb implements bcc {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2573a = bkg.f("RCC\u0001");

    /* renamed from: b, reason: collision with root package name */
    private final bab f2574b;
    private bcm d;
    private int f;
    private long g;
    private int h;
    private int i;
    private final bjz c = new bjz(9);
    private int e = 0;

    public beb(bab babVar) {
        this.f2574b = babVar;
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void c() {
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void a(bcf bcfVar) {
        bcfVar.a(new bcl(-9223372036854775807L));
        this.d = bcfVar.a(0, 3);
        bcfVar.a();
        this.d.a(this.f2574b);
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final boolean a(bce bceVar) {
        this.c.a();
        bceVar.c(this.c.f2752a, 0, 8);
        return this.c.l() == f2573a;
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final int a(bce bceVar, bcj bcjVar) throws IOException {
        while (true) {
            boolean z = true;
            boolean z2 = false;
            switch (this.e) {
                case 0:
                    this.c.a();
                    if (bceVar.a(this.c.f2752a, 0, 8, true)) {
                        if (this.c.l() != f2573a) {
                            throw new IOException("Input not RawCC");
                        }
                        this.f = this.c.f();
                        z2 = true;
                    }
                    if (!z2) {
                        return -1;
                    }
                    this.e = 1;
                    break;
                case 1:
                    this.c.a();
                    if (this.f == 0) {
                        if (bceVar.a(this.c.f2752a, 0, 5, true)) {
                            this.g = (this.c.j() * 1000) / 45;
                            this.h = this.c.f();
                            this.i = 0;
                        }
                        z = false;
                    } else if (this.f == 1) {
                        if (bceVar.a(this.c.f2752a, 0, 9, true)) {
                            this.g = this.c.m();
                            this.h = this.c.f();
                            this.i = 0;
                        }
                        z = false;
                    } else {
                        int i = this.f;
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unsupported version number: ");
                        sb.append(i);
                        throw new zzfx(sb.toString());
                    }
                    if (z) {
                        this.e = 2;
                        break;
                    } else {
                        this.e = 0;
                        return -1;
                    }
                case 2:
                    while (this.h > 0) {
                        this.c.a();
                        bceVar.b(this.c.f2752a, 0, 3);
                        this.d.a(this.c, 3);
                        this.i += 3;
                        this.h--;
                    }
                    if (this.i > 0) {
                        this.d.a(this.g, 1, this.i, 0, null);
                    }
                    this.e = 1;
                    return 0;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bcc
    public final void a(long j, long j2) {
        this.e = 0;
    }
}
