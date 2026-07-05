package com.google.android.gms.internal.ads;

import android.net.Uri;

/* loaded from: classes.dex */
final class bfl implements bjl {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f2618a;

    /* renamed from: b, reason: collision with root package name */
    private final bja f2619b;
    private final bfm c;
    private final bjs d;
    private volatile boolean f;
    private long h;
    private final /* synthetic */ bfg j;
    private final bcj e = new bcj();
    private boolean g = true;
    private long i = -1;

    public bfl(bfg bfgVar, Uri uri, bja bjaVar, bfm bfmVar, bjs bjsVar) {
        this.j = bfgVar;
        this.f2618a = (Uri) bjq.a(uri);
        this.f2619b = (bja) bjq.a(bjaVar);
        this.c = (bfm) bjq.a(bfmVar);
        this.d = bjsVar;
    }

    public final void a(long j, long j2) {
        this.e.f2516a = j;
        this.h = j2;
        this.g = true;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final void a() {
        this.f = true;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final boolean b() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final void c() throws Throwable {
        bca bcaVar;
        int i = 0;
        while (i == 0 && !this.f) {
            try {
                long jB = this.e.f2516a;
                this.i = this.f2619b.a(new bjd(this.f2618a, jB, -1L, this.j.h));
                if (this.i != -1) {
                    this.i += jB;
                }
                bcaVar = new bca(this.f2619b, jB, this.i);
                try {
                    bcc bccVarA = this.c.a(bcaVar, this.f2619b.b());
                    if (this.g) {
                        bccVarA.a(jB, this.h);
                        this.g = false;
                    }
                    while (i == 0 && !this.f) {
                        this.d.c();
                        int iA = bccVarA.a(bcaVar, this.e);
                        try {
                            if (bcaVar.b() > this.j.i + jB) {
                                jB = bcaVar.b();
                                this.d.b();
                                this.j.o.post(this.j.n);
                            }
                            i = iA;
                        } catch (Throwable th) {
                            th = th;
                            i = iA;
                            if (i != 1 && bcaVar != null) {
                                this.e.f2516a = bcaVar.b();
                            }
                            bkg.a(this.f2619b);
                            throw th;
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.e.f2516a = bcaVar.b();
                    }
                    bkg.a(this.f2619b);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bcaVar = null;
            }
        }
    }
}
