package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@qj
/* loaded from: classes.dex */
public final class lt extends ld {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.ads.mediation.l f3258a;

    public lt(com.google.android.gms.ads.mediation.l lVar) {
        this.f3258a = lVar;
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final bz k() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final String a() {
        return this.f3258a.a();
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final List b() {
        List<c.b> listB = this.f3258a.b();
        ArrayList arrayList = new ArrayList();
        if (listB != null) {
            for (c.b bVar : listB) {
                arrayList.add(new at(bVar.a(), bVar.b(), bVar.c()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final String c() {
        return this.f3258a.c();
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final cd d() {
        c.b bVarD = this.f3258a.d();
        if (bVarD != null) {
            return new at(bVarD.a(), bVarD.b(), bVarD.c());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final String e() {
        return this.f3258a.e();
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final String f() {
        return this.f3258a.f();
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final double g() {
        if (this.f3258a.g() != null) {
            return this.f3258a.g().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final String h() {
        return this.f3258a.h();
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final String i() {
        return this.f3258a.i();
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final bsw j() {
        if (this.f3258a.j() != null) {
            return this.f3258a.j().a();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final com.google.android.gms.dynamic.a l() {
        View viewL = this.f3258a.l();
        if (viewL == null) {
            return null;
        }
        return com.google.android.gms.dynamic.b.a(viewL);
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final com.google.android.gms.dynamic.a m() {
        View viewM = this.f3258a.m();
        if (viewM == null) {
            return null;
        }
        return com.google.android.gms.dynamic.b.a(viewM);
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final com.google.android.gms.dynamic.a n() {
        Object objN = this.f3258a.n();
        if (objN == null) {
            return null;
        }
        return com.google.android.gms.dynamic.b.a(objN);
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final Bundle o() {
        return this.f3258a.o();
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final boolean p() {
        return this.f3258a.p();
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final boolean q() {
        return this.f3258a.q();
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final void r() {
        this.f3258a.r();
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final void a(com.google.android.gms.dynamic.a aVar) {
        this.f3258a.a((View) com.google.android.gms.dynamic.b.a(aVar));
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final void a(com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3) {
        this.f3258a.a((View) com.google.android.gms.dynamic.b.a(aVar), (HashMap) com.google.android.gms.dynamic.b.a(aVar2), (HashMap) com.google.android.gms.dynamic.b.a(aVar3));
    }

    @Override // com.google.android.gms.internal.ads.lc
    public final void b(com.google.android.gms.dynamic.a aVar) {
        this.f3258a.b((View) com.google.android.gms.dynamic.b.a(aVar));
    }
}
