package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import java.io.IOException;

/* loaded from: classes.dex */
public final class bgy implements bfs {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2657a;

    /* renamed from: b, reason: collision with root package name */
    private final bjb f2658b;
    private final bgv c;
    private final int d;
    private final long e;
    private final bex f;
    private final bjo<? extends bho> g;
    private final bhd h;
    private final Object i;
    private final SparseArray<bgw> j;
    private final Runnable k;
    private final Runnable l;
    private bft m;
    private bja n;
    private bji o;
    private bjm p;
    private Uri q;
    private long r;
    private long s;
    private bho t;
    private Handler u;
    private long v;
    private int w;

    public bgy(Uri uri, bjb bjbVar, bgv bgvVar, Handler handler, bew bewVar) {
        this(uri, bjbVar, bgvVar, 3, -1L, handler, null);
    }

    private bgy(Uri uri, bjb bjbVar, bgv bgvVar, int i, long j, Handler handler, bew bewVar) {
        this(uri, bjbVar, new bhp(), bgvVar, 3, -1L, handler, null);
    }

    private bgy(Uri uri, bjb bjbVar, bjo<? extends bho> bjoVar, bgv bgvVar, int i, long j, Handler handler, bew bewVar) {
        this(null, uri, bjbVar, bjoVar, bgvVar, 3, -1L, handler, bewVar);
    }

    private bgy(bho bhoVar, Uri uri, bjb bjbVar, bjo<? extends bho> bjoVar, bgv bgvVar, int i, long j, Handler handler, bew bewVar) {
        this.t = null;
        this.q = uri;
        this.f2658b = bjbVar;
        this.g = bjoVar;
        this.c = bgvVar;
        this.d = i;
        this.e = j;
        this.f2657a = false;
        this.f = new bex(handler, bewVar);
        this.i = new Object();
        this.j = new SparseArray<>();
        this.h = new bhd(this, null);
        this.k = new bgz(this);
        this.l = new bha(this);
    }

    @Override // com.google.android.gms.internal.ads.bfs
    public final void a(azp azpVar, boolean z, bft bftVar) {
        this.m = bftVar;
        this.n = this.f2658b.a();
        this.o = new bji("Loader:DashMediaSource");
        this.p = this.o;
        this.u = new Handler();
        c();
    }

    @Override // com.google.android.gms.internal.ads.bfs
    public final void a() {
        this.p.c();
    }

    @Override // com.google.android.gms.internal.ads.bfs
    public final bfq a(int i, biy biyVar) {
        bgw bgwVar = new bgw(this.w + i, this.t, i, this.c, this.d, this.f.a(this.t.a(i).f2686b), this.v, this.p, biyVar);
        this.j.put(bgwVar.f2653a, bgwVar);
        return bgwVar;
    }

    @Override // com.google.android.gms.internal.ads.bfs
    public final void a(bfq bfqVar) {
        bgw bgwVar = (bgw) bfqVar;
        bgwVar.b();
        this.j.remove(bgwVar.f2653a);
    }

    @Override // com.google.android.gms.internal.ads.bfs
    public final void b() {
        this.n = null;
        this.p = null;
        if (this.o != null) {
            this.o.a((Runnable) null);
            this.o = null;
        }
        this.r = 0L;
        this.s = 0L;
        this.t = null;
        if (this.u != null) {
            this.u.removeCallbacksAndMessages(null);
            this.u = null;
        }
        this.v = 0L;
        this.j.clear();
    }

    final void a(bjn<bho> bjnVar, long j, long j2) {
        this.f.a(bjnVar.f2739a, bjnVar.f2740b, j, j2, bjnVar.e());
        bho bhoVarD = bjnVar.d();
        int i = 0;
        int iA = this.t == null ? 0 : this.t.a();
        long j3 = bhoVarD.a(0).f2686b;
        while (i < iA && this.t.a(i).f2686b < j3) {
            i++;
        }
        if (iA - i > bhoVarD.a()) {
            Log.w("DashMediaSource", "Out of sync manifest");
            d();
            return;
        }
        this.t = bhoVarD;
        this.r = j - j2;
        this.s = j;
        if (this.t.g != null) {
            synchronized (this.i) {
                if (bjnVar.f2739a.f2725a == this.q) {
                    this.q = this.t.g;
                }
            }
        }
        if (iA == 0) {
            if (this.t.f != null) {
                big bigVar = this.t.f;
                String str = bigVar.f2698a;
                if (bkg.a(str, "urn:mpeg:dash:utc:direct:2014") || bkg.a(str, "urn:mpeg:dash:utc:direct:2012")) {
                    try {
                        a(bkg.e(bigVar.f2699b) - this.s);
                        return;
                    } catch (zzfx e) {
                        a(e);
                        return;
                    }
                }
                bgz bgzVar = null;
                if (bkg.a(str, "urn:mpeg:dash:utc:http-iso:2014") || bkg.a(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                    a(bigVar, new bhc(bgzVar));
                    return;
                } else if (bkg.a(str, "urn:mpeg:dash:utc:http-xsdate:2014") || bkg.a(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                    a(bigVar, new bhh(bgzVar));
                    return;
                } else {
                    a(new IOException("Unsupported UTC timing scheme"));
                    return;
                }
            }
            a(true);
            return;
        }
        this.w += i;
        a(true);
    }

    final int a(bjn<bho> bjnVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof zzfx;
        this.f.a(bjnVar.f2739a, bjnVar.f2740b, j, j2, bjnVar.e(), iOException, z);
        return z ? 3 : 0;
    }

    final void b(bjn<Long> bjnVar, long j, long j2) {
        this.f.a(bjnVar.f2739a, bjnVar.f2740b, j, j2, bjnVar.e());
        a(bjnVar.d().longValue() - j);
    }

    final int b(bjn<Long> bjnVar, long j, long j2, IOException iOException) {
        this.f.a(bjnVar.f2739a, bjnVar.f2740b, j, j2, bjnVar.e(), iOException, true);
        a(iOException);
        return 2;
    }

    final void c(bjn<?> bjnVar, long j, long j2) {
        this.f.b(bjnVar.f2739a, bjnVar.f2740b, j, j2, bjnVar.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        Uri uri;
        synchronized (this.i) {
            uri = this.q;
        }
        a(new bjn(this.n, uri, 4, this.g), this.h, this.d);
    }

    private final void a(big bigVar, bjo<Long> bjoVar) {
        a(new bjn(this.n, Uri.parse(bigVar.f2699b), 5, bjoVar), new bhg(this, null), 1);
    }

    private final void a(long j) {
        this.v = j;
        a(true);
    }

    private final void a(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        long j;
        boolean z2;
        long jB;
        long jB2;
        for (int i = 0; i < this.j.size(); i++) {
            int iKeyAt = this.j.keyAt(i);
            if (iKeyAt >= this.w) {
                this.j.valueAt(i).a(this.t, iKeyAt - this.w);
            }
        }
        int iA = this.t.a() - 1;
        bhf bhfVarA = bhf.a(this.t.a(0), this.t.b(0));
        bhf bhfVarA2 = bhf.a(this.t.a(iA), this.t.b(iA));
        long j2 = bhfVarA.f2666b;
        long jMin = bhfVarA2.c;
        long jB3 = 0;
        if (!this.t.f2678b || bhfVarA2.f2665a) {
            j = j2;
            z2 = false;
        } else {
            if (this.v != 0) {
                jB = azo.b(SystemClock.elapsedRealtime() + this.v);
            } else {
                jB = azo.b(System.currentTimeMillis());
            }
            jMin = Math.min((jB - azo.b(this.t.f2677a)) - azo.b(this.t.a(iA).f2686b), jMin);
            if (this.t.d != -9223372036854775807L) {
                long jB4 = jMin - azo.b(this.t.d);
                while (jB4 < 0 && iA > 0) {
                    iA--;
                    jB4 += this.t.b(iA);
                }
                if (iA == 0) {
                    jB2 = Math.max(j2, jB4);
                } else {
                    jB2 = this.t.b(0);
                }
                j2 = jB2;
            }
            j = j2;
            z2 = true;
        }
        long jB5 = jMin - j;
        for (int i2 = 0; i2 < this.t.a() - 1; i2++) {
            jB5 += this.t.b(i2);
        }
        if (this.t.f2678b) {
            long j3 = this.e;
            if (j3 == -1) {
                j3 = this.t.e != -9223372036854775807L ? this.t.e : 30000L;
            }
            jB3 = jB5 - azo.b(j3);
            if (jB3 < 5000000) {
                jB3 = Math.min(5000000L, jB5 / 2);
            }
        }
        this.m.a(new bhb(this.t.f2677a, this.t.f2677a + this.t.a(0).f2686b + azo.a(j), this.w, j, jB5, jB3, this.t), this.t);
        this.u.removeCallbacks(this.l);
        if (z2) {
            this.u.postDelayed(this.l, 5000L);
        }
        if (z) {
            d();
        }
    }

    private final void d() {
        if (this.t.f2678b) {
            long j = this.t.c;
            if (j == 0) {
                j = 5000;
            }
            this.u.postDelayed(this.k, Math.max(0L, (this.r + j) - SystemClock.elapsedRealtime()));
        }
    }

    private final <T> void a(bjn<T> bjnVar, bjj<bjn<T>> bjjVar, int i) {
        this.f.a(bjnVar.f2739a, bjnVar.f2740b, this.o.a(bjnVar, bjjVar, i));
    }
}
