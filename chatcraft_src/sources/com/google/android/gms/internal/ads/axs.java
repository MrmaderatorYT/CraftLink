package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class axs extends asu<Integer, Long> {

    /* renamed from: a, reason: collision with root package name */
    public Long f2384a;

    /* renamed from: b, reason: collision with root package name */
    public Long f2385b;

    public axs() {
    }

    public axs(String str) {
        a(str);
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final void a(String str) {
        HashMap mapB = b(str);
        if (mapB != null) {
            this.f2384a = (Long) mapB.get(0);
            this.f2385b = (Long) mapB.get(1);
        }
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, this.f2384a);
        map.put(1, this.f2385b);
        return map;
    }
}
