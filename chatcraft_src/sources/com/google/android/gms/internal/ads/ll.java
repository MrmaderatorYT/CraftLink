package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@qj
/* loaded from: classes.dex */
public final class ll extends la {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.ads.mediation.h f3246a;

    public ll(com.google.android.gms.ads.mediation.h hVar) {
        this.f3246a = hVar;
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final bz m() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final com.google.android.gms.dynamic.a o() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final String a() {
        return this.f3246a.i();
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final List b() {
        List<c.b> listJ = this.f3246a.j();
        if (listJ == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (c.b bVar : listJ) {
            arrayList.add(new at(bVar.a(), bVar.b(), bVar.c()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final String c() {
        return this.f3246a.k();
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final cd d() {
        c.b bVarL = this.f3246a.l();
        if (bVarL != null) {
            return new at(bVarL.a(), bVarL.b(), bVarL.c());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final String e() {
        return this.f3246a.m();
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final String f() {
        return this.f3246a.n();
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final void g() {
        this.f3246a.e();
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final void a(com.google.android.gms.dynamic.a aVar) {
        this.f3246a.c((View) com.google.android.gms.dynamic.b.a(aVar));
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final void b(com.google.android.gms.dynamic.a aVar) {
        this.f3246a.a((View) com.google.android.gms.dynamic.b.a(aVar));
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final void a(com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3) {
        this.f3246a.a((View) com.google.android.gms.dynamic.b.a(aVar), (HashMap) com.google.android.gms.dynamic.b.a(aVar2), (HashMap) com.google.android.gms.dynamic.b.a(aVar3));
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final void c(com.google.android.gms.dynamic.a aVar) {
        this.f3246a.b((View) com.google.android.gms.dynamic.b.a(aVar));
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final boolean h() {
        return this.f3246a.a();
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final boolean i() {
        return this.f3246a.b();
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final Bundle j() {
        return this.f3246a.c();
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final com.google.android.gms.dynamic.a k() {
        View viewD = this.f3246a.d();
        if (viewD == null) {
            return null;
        }
        return com.google.android.gms.dynamic.b.a(viewD);
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final bsw l() {
        if (this.f3246a.g() != null) {
            return this.f3246a.g().a();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.kz
    public final com.google.android.gms.dynamic.a n() {
        View viewF = this.f3246a.f();
        if (viewF == null) {
            return null;
        }
        return com.google.android.gms.dynamic.b.a(viewF);
    }
}
