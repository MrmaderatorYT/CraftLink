package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class axg extends asu<Integer, Long> {

    /* renamed from: a, reason: collision with root package name */
    public long f2367a;

    /* renamed from: b, reason: collision with root package name */
    public long f2368b;

    public axg() {
        this.f2367a = -1L;
        this.f2368b = -1L;
    }

    public axg(String str) {
        this();
        a(str);
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final HashMap<Integer, Long> a() {
        HashMap<Integer, Long> map = new HashMap<>();
        map.put(0, Long.valueOf(this.f2367a));
        map.put(1, Long.valueOf(this.f2368b));
        return map;
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final void a(String str) {
        HashMap mapB = b(str);
        if (mapB != null) {
            this.f2367a = ((Long) mapB.get(0)).longValue();
            this.f2368b = ((Long) mapB.get(1)).longValue();
        }
    }
}
