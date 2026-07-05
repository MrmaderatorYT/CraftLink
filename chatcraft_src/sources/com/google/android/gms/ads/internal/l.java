package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.brh;
import com.google.android.gms.internal.ads.brk;
import com.google.android.gms.internal.ads.bro;
import com.google.android.gms.internal.ads.bsg;
import com.google.android.gms.internal.ads.dd;
import com.google.android.gms.internal.ads.dg;
import com.google.android.gms.internal.ads.dj;
import com.google.android.gms.internal.ads.dm;
import com.google.android.gms.internal.ads.dp;
import com.google.android.gms.internal.ads.ds;
import com.google.android.gms.internal.ads.ey;
import com.google.android.gms.internal.ads.ff;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.qj;

@qj
/* loaded from: classes.dex */
public final class l extends bro {

    /* renamed from: a, reason: collision with root package name */
    private brh f1617a;

    /* renamed from: b, reason: collision with root package name */
    private dd f1618b;
    private ds c;
    private dg d;
    private dp g;
    private bqn h;
    private com.google.android.gms.ads.b.j i;
    private com.google.android.gms.internal.ads.br j;
    private ey k;
    private ff l;
    private bsg m;
    private final Context n;
    private final kk o;
    private final String p;
    private final aar q;
    private final bt r;
    private androidx.b.g<String, dm> f = new androidx.b.g<>();
    private androidx.b.g<String, dj> e = new androidx.b.g<>();

    public l(Context context, String str, kk kkVar, aar aarVar, bt btVar) {
        this.n = context;
        this.p = str;
        this.o = kkVar;
        this.q = aarVar;
        this.r = btVar;
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final brk a() {
        return new i(this.n, this.p, this.o, this.q, this.f1617a, this.f1618b, this.c, this.l, this.d, this.f, this.e, this.j, this.k, this.m, this.r, this.g, this.h, this.i);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(brh brhVar) {
        this.f1617a = brhVar;
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(com.google.android.gms.internal.ads.br brVar) {
        this.j = brVar;
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(com.google.android.gms.ads.b.j jVar) {
        this.i = jVar;
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(bsg bsgVar) {
        this.m = bsgVar;
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(ey eyVar) {
        this.k = eyVar;
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(dg dgVar) {
        this.d = dgVar;
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(dd ddVar) {
        this.f1618b = ddVar;
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(ds dsVar) {
        this.c = dsVar;
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(ff ffVar) {
        this.l = ffVar;
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(String str, dm dmVar, dj djVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.f.put(str, dmVar);
        this.e.put(str, djVar);
    }

    @Override // com.google.android.gms.internal.ads.brn
    public final void a(dp dpVar, bqn bqnVar) {
        this.g = dpVar;
        this.h = bqnVar;
    }
}
