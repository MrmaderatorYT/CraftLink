package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@qj
/* loaded from: classes.dex */
public final class lk extends kx {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.ads.mediation.g f3245a;

    public lk(com.google.android.gms.ads.mediation.g gVar) {
        this.f3245a = gVar;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final bz o() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final com.google.android.gms.dynamic.a q() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String a() {
        return this.f3245a.i();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final List b() {
        List<c.b> listJ = this.f3245a.j();
        if (listJ == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c.b bVar : listJ) {
            arrayList.add(new at(bVar.a(), bVar.b(), bVar.c()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String c() {
        return this.f3245a.k();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final cd d() {
        c.b bVarL = this.f3245a.l();
        if (bVarL != null) {
            return new at(bVarL.a(), bVarL.b(), bVarL.c());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String e() {
        return this.f3245a.m();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final double f() {
        return this.f3245a.n();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String g() {
        return this.f3245a.o();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final String h() {
        return this.f3245a.p();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void i() {
        this.f3245a.e();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void a(com.google.android.gms.dynamic.a aVar) {
        this.f3245a.c((View) com.google.android.gms.dynamic.b.a(aVar));
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void b(com.google.android.gms.dynamic.a aVar) {
        this.f3245a.a((View) com.google.android.gms.dynamic.b.a(aVar));
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void a(com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3) {
        this.f3245a.a((View) com.google.android.gms.dynamic.b.a(aVar), (HashMap) com.google.android.gms.dynamic.b.a(aVar2), (HashMap) com.google.android.gms.dynamic.b.a(aVar3));
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final void c(com.google.android.gms.dynamic.a aVar) {
        this.f3245a.b((View) com.google.android.gms.dynamic.b.a(aVar));
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final boolean j() {
        return this.f3245a.a();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final boolean k() {
        return this.f3245a.b();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final Bundle l() {
        return this.f3245a.c();
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final bsw m() {
        if (this.f3245a.g() != null) {
            return this.f3245a.g().a();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final com.google.android.gms.dynamic.a n() {
        View viewD = this.f3245a.d();
        if (viewD == null) {
            return null;
        }
        return com.google.android.gms.dynamic.b.a(viewD);
    }

    @Override // com.google.android.gms.internal.ads.kw
    public final com.google.android.gms.dynamic.a p() {
        View viewF = this.f3245a.f();
        if (viewF == null) {
            return null;
        }
        return com.google.android.gms.dynamic.b.a(viewF);
    }
}
