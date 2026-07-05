package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class axr extends asu<Integer, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Long f2382a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f2383b;
    public Boolean c;

    public axr() {
    }

    public axr(String str) {
        a(str);
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final void a(String str) {
        HashMap mapB = b(str);
        if (mapB != null) {
            this.f2382a = (Long) mapB.get(0);
            this.f2383b = (Boolean) mapB.get(1);
            this.c = (Boolean) mapB.get(2);
        }
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final HashMap<Integer, Object> a() {
        HashMap<Integer, Object> map = new HashMap<>();
        map.put(0, this.f2382a);
        map.put(1, this.f2383b);
        map.put(2, this.c);
        return map;
    }
}
