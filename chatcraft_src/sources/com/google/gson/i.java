package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: JsonArray.java */
/* loaded from: classes.dex */
public final class i extends l implements Iterable<l> {

    /* renamed from: a, reason: collision with root package name */
    private final List<l> f4032a = new ArrayList();

    public void a(l lVar) {
        if (lVar == null) {
            lVar = m.f4033a;
        }
        this.f4032a.add(lVar);
    }

    public int a() {
        return this.f4032a.size();
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return this.f4032a.iterator();
    }

    public l a(int i) {
        return this.f4032a.get(i);
    }

    @Override // com.google.gson.l
    public Number b() {
        if (this.f4032a.size() == 1) {
            return this.f4032a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public String c() {
        if (this.f4032a.size() == 1) {
            return this.f4032a.get(0).c();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public double d() {
        if (this.f4032a.size() == 1) {
            return this.f4032a.get(0).d();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public long e() {
        if (this.f4032a.size() == 1) {
            return this.f4032a.get(0).e();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public int f() {
        if (this.f4032a.size() == 1) {
            return this.f4032a.get(0).f();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.l
    public boolean g() {
        if (this.f4032a.size() == 1) {
            return this.f4032a.get(0).g();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f4032a.equals(this.f4032a));
    }

    public int hashCode() {
        return this.f4032a.hashCode();
    }
}
