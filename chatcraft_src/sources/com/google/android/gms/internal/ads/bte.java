package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@qj
/* loaded from: classes.dex */
public final class bte {

    /* renamed from: a, reason: collision with root package name */
    private final Date f3010a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3011b;
    private final int c;
    private final Set<String> d;
    private final Location e;
    private final boolean f;
    private final Bundle g;
    private final Map<Class<? extends Object>, Object> h;
    private final String i;
    private final String j;
    private final com.google.android.gms.ads.d.a k;
    private final int l;
    private final Set<String> m;
    private final Bundle n;
    private final Set<String> o;
    private final boolean p;
    private final aiq q;
    private final int r;
    private final String s;

    public bte(btf btfVar) {
        this(btfVar, null);
    }

    public bte(btf btfVar, com.google.android.gms.ads.d.a aVar) {
        this.f3010a = btfVar.g;
        this.f3011b = btfVar.h;
        this.c = btfVar.i;
        this.d = Collections.unmodifiableSet(btfVar.f3012a);
        this.e = btfVar.j;
        this.f = btfVar.k;
        this.g = btfVar.f3013b;
        this.h = Collections.unmodifiableMap(btfVar.c);
        this.i = btfVar.l;
        this.j = btfVar.m;
        this.k = aVar;
        this.l = btfVar.n;
        this.m = Collections.unmodifiableSet(btfVar.d);
        this.n = btfVar.e;
        this.o = Collections.unmodifiableSet(btfVar.f);
        this.p = btfVar.o;
        this.q = null;
        this.r = btfVar.p;
        this.s = btfVar.q;
    }

    @Deprecated
    public final Date a() {
        return this.f3010a;
    }

    public final String b() {
        return this.f3011b;
    }

    @Deprecated
    public final int c() {
        return this.c;
    }

    public final Set<String> d() {
        return this.d;
    }

    public final Location e() {
        return this.e;
    }

    public final boolean f() {
        return this.f;
    }

    public final Bundle a(Class<? extends com.google.android.gms.ads.mediation.b> cls) {
        return this.g.getBundle(cls.getName());
    }

    public final String g() {
        return this.i;
    }

    public final String h() {
        return this.j;
    }

    public final com.google.android.gms.ads.d.a i() {
        return this.k;
    }

    public final boolean a(Context context) {
        Set<String> set = this.m;
        bra.a();
        return set.contains(aac.a(context));
    }

    public final Map<Class<? extends Object>, Object> j() {
        return this.h;
    }

    public final Bundle k() {
        return this.g;
    }

    public final int l() {
        return this.l;
    }

    public final Bundle m() {
        return this.n;
    }

    public final Set<String> n() {
        return this.o;
    }

    @Deprecated
    public final boolean o() {
        return this.p;
    }

    public final int p() {
        return this.r;
    }

    public final String q() {
        return this.s;
    }
}
