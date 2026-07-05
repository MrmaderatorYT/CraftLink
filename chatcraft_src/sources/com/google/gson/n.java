package com.google.gson;

import java.util.Map;
import java.util.Set;

/* compiled from: JsonObject.java */
/* loaded from: classes.dex */
public final class n extends l {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.b.h<String, l> f4034a = new com.google.gson.b.h<>();

    public void a(String str, l lVar) {
        if (lVar == null) {
            lVar = m.f4033a;
        }
        this.f4034a.put(str, lVar);
    }

    public void a(String str, String str2) {
        a(str, a((Object) str2));
    }

    public void a(String str, Number number) {
        a(str, a(number));
    }

    public void a(String str, Boolean bool) {
        a(str, a(bool));
    }

    private l a(Object obj) {
        return obj == null ? m.f4033a : new p(obj);
    }

    public Set<Map.Entry<String, l>> a() {
        return this.f4034a.entrySet();
    }

    public boolean a(String str) {
        return this.f4034a.containsKey(str);
    }

    public l b(String str) {
        return this.f4034a.get(str);
    }

    public i c(String str) {
        return (i) this.f4034a.get(str);
    }

    public n d(String str) {
        return (n) this.f4034a.get(str);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof n) && ((n) obj).f4034a.equals(this.f4034a));
    }

    public int hashCode() {
        return this.f4034a.hashCode();
    }
}
