package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class aut extends asu<Integer, Object> {

    /* renamed from: a, reason: collision with root package name */
    public String f2287a;

    /* renamed from: b, reason: collision with root package name */
    public long f2288b;
    public String c;
    public String d;
    public String e;

    public aut(String str) {
        this();
        a(str);
    }

    public aut() {
        this.f2287a = "E";
        this.f2288b = -1L;
        this.c = "E";
        this.d = "E";
        this.e = "E";
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final void a(String str) {
        HashMap mapB = b(str);
        if (mapB != null) {
            this.f2287a = mapB.get(0) == null ? "E" : (String) mapB.get(0);
            this.f2288b = mapB.get(1) == null ? -1L : ((Long) mapB.get(1)).longValue();
            this.c = mapB.get(2) == null ? "E" : (String) mapB.get(2);
            this.d = mapB.get(3) == null ? "E" : (String) mapB.get(3);
            this.e = mapB.get(4) == null ? "E" : (String) mapB.get(4);
        }
    }

    @Override // com.google.android.gms.internal.ads.asu
    protected final HashMap<Integer, Object> a() {
        HashMap<Integer, Object> map = new HashMap<>();
        map.put(0, this.f2287a);
        map.put(4, this.e);
        map.put(3, this.d);
        map.put(2, this.c);
        map.put(1, Long.valueOf(this.f2288b));
        return map;
    }
}
