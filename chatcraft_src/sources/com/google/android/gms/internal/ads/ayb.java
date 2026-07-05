package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class ayb extends asu<Integer, Long> {

    /* renamed from: a, reason: collision with root package name */
    public Long f2400a;

    /* renamed from: b, reason: collision with root package name */
    public Long f2401b;
    public Long c;

    public ayb() {
    }

    public ayb(String str) {
        a(str);
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final void a(String str) {
        HashMap mapB = b(str);
        if (mapB != null) {
            this.f2400a = (Long) mapB.get(0);
            this.f2401b = (Long) mapB.get(1);
            this.c = (Long) mapB.get(2);
        }
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, this.f2400a);
        map.put(1, this.f2401b);
        map.put(2, this.c);
        return map;
    }
}
