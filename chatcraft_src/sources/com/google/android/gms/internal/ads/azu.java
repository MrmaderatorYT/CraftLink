package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
final class azu implements azp {

    /* renamed from: a, reason: collision with root package name */
    private final bag[] f2428a;

    /* renamed from: b, reason: collision with root package name */
    private final biu f2429b;
    private final bit c;
    private final Handler d;
    private final azw e;
    private final CopyOnWriteArraySet<azq> f;
    private final bam g;
    private final bal h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private baj p;
    private Object q;
    private bgf r;
    private bit s;
    private baf t;
    private azy u;
    private int v;
    private int w;
    private long x;

    @SuppressLint({"HandlerLeak"})
    public azu(bag[] bagVarArr, biu biuVar, bae baeVar) {
        String str = bkg.e;
        StringBuilder sb = new StringBuilder(String.valueOf("Init ExoPlayerLib/2.4.2 [").length() + 1 + String.valueOf(str).length());
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        bjq.b(bagVarArr.length > 0);
        this.f2428a = (bag[]) bjq.a(bagVarArr);
        this.f2429b = (biu) bjq.a(biuVar);
        this.j = false;
        this.k = 0;
        this.l = 1;
        this.f = new CopyOnWriteArraySet<>();
        this.c = new bit(new bir[bagVarArr.length]);
        this.p = baj.f2449a;
        this.g = new bam();
        this.h = new bal();
        this.r = bgf.f2637a;
        this.s = this.c;
        this.t = baf.f2445a;
        this.d = new azv(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.u = new azy(0, 0L);
        this.e = new azw(bagVarArr, biuVar, baeVar, this.j, 0, this.d, this.u, this);
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final void a(azq azqVar) {
        this.f.add(azqVar);
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final void b(azq azqVar) {
        this.f.remove(azqVar);
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final int a() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final void a(bfs bfsVar) {
        if (!this.p.a() || this.q != null) {
            this.p = baj.f2449a;
            this.q = null;
            Iterator<azq> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().a(this.p, this.q);
            }
        }
        if (this.i) {
            this.i = false;
            this.r = bgf.f2637a;
            this.s = this.c;
            this.f2429b.a((Object) null);
            Iterator<azq> it2 = this.f.iterator();
            while (it2.hasNext()) {
                it2.next().a(this.r, this.s);
            }
        }
        this.n++;
        this.e.a(bfsVar, true);
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.e.a(z);
            Iterator<azq> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().a(z, this.l);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final boolean b() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final void a(long j) {
        long jB;
        int i = i();
        if (i < 0 || (!this.p.a() && i >= this.p.b())) {
            throw new zzfv(this.p, i, j);
        }
        this.m++;
        this.v = i;
        if (this.p.a()) {
            this.w = 0;
        } else {
            this.p.a(i, this.g, false, 0L);
            if (j == -9223372036854775807L) {
                jB = this.g.d;
            } else {
                jB = azo.b(j);
            }
            long j2 = this.g.f + jB;
            long j3 = this.p.a(0, this.h, false).c;
            int i2 = 0;
            while (j3 != -9223372036854775807L && j2 >= j3 && i2 < this.g.c) {
                j2 -= j3;
                i2++;
                j3 = this.p.a(i2, this.h, false).c;
            }
            this.w = i2;
        }
        if (j == -9223372036854775807L) {
            this.x = 0L;
            this.e.a(this.p, i, -9223372036854775807L);
            return;
        }
        this.x = j;
        this.e.a(this.p, i, azo.b(j));
        Iterator<azq> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final void c() {
        this.e.a();
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final void d() {
        this.e.b();
        this.d.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final void a(azs... azsVarArr) {
        this.e.a(azsVarArr);
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final void b(azs... azsVarArr) {
        this.e.b(azsVarArr);
    }

    private final int i() {
        if (this.p.a() || this.m > 0) {
            return this.v;
        }
        this.p.a(this.u.f2435a, this.h, false);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final long f() {
        if (this.p.a()) {
            return -9223372036854775807L;
        }
        return azo.a(this.p.a(i(), this.g, false, 0L).e);
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final long g() {
        if (this.p.a() || this.m > 0) {
            return this.x;
        }
        this.p.a(this.u.f2435a, this.h, false);
        return this.h.a() + azo.a(this.u.c);
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final long h() {
        if (this.p.a() || this.m > 0) {
            return this.x;
        }
        this.p.a(this.u.f2435a, this.h, false);
        return this.h.a() + azo.a(this.u.d);
    }

    @Override // com.google.android.gms.internal.ads.azp
    public final int e() {
        return this.f2428a.length;
    }

    final void a(Message message) {
        switch (message.what) {
            case 0:
                this.n--;
                return;
            case 1:
                this.l = message.arg1;
                Iterator<azq> it = this.f.iterator();
                while (it.hasNext()) {
                    it.next().a(this.j, this.l);
                }
                return;
            case 2:
                this.o = message.arg1 != 0;
                Iterator<azq> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this.o);
                }
                return;
            case 3:
                if (this.n == 0) {
                    biw biwVar = (biw) message.obj;
                    this.i = true;
                    this.r = biwVar.f2715a;
                    this.s = biwVar.f2716b;
                    this.f2429b.a(biwVar.c);
                    Iterator<azq> it3 = this.f.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(this.r, this.s);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.m - 1;
                this.m = i;
                if (i == 0) {
                    this.u = (azy) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<azq> it4 = this.f.iterator();
                        while (it4.hasNext()) {
                            it4.next().g();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.m == 0) {
                    this.u = (azy) message.obj;
                    Iterator<azq> it5 = this.f.iterator();
                    while (it5.hasNext()) {
                        it5.next().g();
                    }
                    return;
                }
                return;
            case 6:
                baa baaVar = (baa) message.obj;
                this.m -= baaVar.d;
                if (this.n == 0) {
                    this.p = baaVar.f2440a;
                    this.q = baaVar.f2441b;
                    this.u = baaVar.c;
                    Iterator<azq> it6 = this.f.iterator();
                    while (it6.hasNext()) {
                        it6.next().a(this.p, this.q);
                    }
                    return;
                }
                return;
            case 7:
                baf bafVar = (baf) message.obj;
                if (this.t.equals(bafVar)) {
                    return;
                }
                this.t = bafVar;
                Iterator<azq> it7 = this.f.iterator();
                while (it7.hasNext()) {
                    it7.next().a(bafVar);
                }
                return;
            case 8:
                zzff zzffVar = (zzff) message.obj;
                Iterator<azq> it8 = this.f.iterator();
                while (it8.hasNext()) {
                    it8.next().a(zzffVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
