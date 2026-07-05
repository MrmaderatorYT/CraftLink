package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;

/* loaded from: classes.dex */
public final class bfo implements bfs, bft {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f2624a;

    /* renamed from: b, reason: collision with root package name */
    private final bjb f2625b;
    private final bcg c;
    private final Handler e;
    private final bfp f;
    private final int i;
    private bft j;
    private baj k;
    private boolean l;
    private final int d = -1;
    private final String h = null;
    private final bal g = new bal();

    public bfo(Uri uri, bjb bjbVar, bcg bcgVar, int i, Handler handler, bfp bfpVar, String str, int i2) {
        this.f2624a = uri;
        this.f2625b = bjbVar;
        this.c = bcgVar;
        this.e = handler;
        this.f = bfpVar;
        this.i = i2;
    }

    @Override // com.google.android.gms.internal.ads.bfs
    public final void a() {
    }

    @Override // com.google.android.gms.internal.ads.bfs
    public final void a(azp azpVar, boolean z, bft bftVar) {
        this.j = bftVar;
        this.k = new bgc(-9223372036854775807L, false);
        bftVar.a(this.k, null);
    }

    @Override // com.google.android.gms.internal.ads.bfs
    public final bfq a(int i, biy biyVar) {
        bjq.a(i == 0);
        return new bfg(this.f2624a, this.f2625b.a(), this.c.a(), this.d, this.e, this.f, this, biyVar, null, this.i);
    }

    @Override // com.google.android.gms.internal.ads.bfs
    public final void a(bfq bfqVar) {
        ((bfg) bfqVar).b();
    }

    @Override // com.google.android.gms.internal.ads.bfs
    public final void b() {
        this.j = null;
    }

    @Override // com.google.android.gms.internal.ads.bft
    public final void a(baj bajVar, Object obj) {
        boolean z = bajVar.a(0, this.g, false).c != -9223372036854775807L;
        if (!this.l || z) {
            this.k = bajVar;
            this.l = z;
            this.j.a(this.k, null);
        }
    }
}
