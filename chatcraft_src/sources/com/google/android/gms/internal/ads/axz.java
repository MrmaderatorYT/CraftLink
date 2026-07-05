package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class axz extends asu<Integer, Long> {

    /* renamed from: a, reason: collision with root package name */
    public Long f2395a;

    /* renamed from: b, reason: collision with root package name */
    public Long f2396b;
    public Long c;
    public Long d;
    public Long e;
    public Long f;
    public Long g;
    public Long h;
    public Long i;
    public Long j;
    public Long k;

    public axz() {
    }

    public axz(String str) {
        a(str);
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final void a(String str) {
        HashMap mapB = b(str);
        if (mapB != null) {
            this.f2395a = (Long) mapB.get(0);
            this.f2396b = (Long) mapB.get(1);
            this.c = (Long) mapB.get(2);
            this.d = (Long) mapB.get(3);
            this.e = (Long) mapB.get(4);
            this.f = (Long) mapB.get(5);
            this.g = (Long) mapB.get(6);
            this.h = (Long) mapB.get(7);
            this.i = (Long) mapB.get(8);
            this.j = (Long) mapB.get(9);
            this.k = (Long) mapB.get(10);
        }
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, this.f2395a);
        map.put(1, this.f2396b);
        map.put(2, this.c);
        map.put(3, this.d);
        map.put(4, this.e);
        map.put(5, this.f);
        map.put(6, this.g);
        map.put(7, this.h);
        map.put(8, this.i);
        map.put(9, this.j);
        map.put(10, this.k);
        return map;
    }
}
