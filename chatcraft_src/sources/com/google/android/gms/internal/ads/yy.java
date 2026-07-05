package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class yy {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f3620a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<Double> f3621b = new ArrayList();
    private final List<Double> c = new ArrayList();

    public final yy a(String str, double d, double d2) {
        int i = 0;
        while (i < this.f3620a.size()) {
            double dDoubleValue = this.c.get(i).doubleValue();
            double dDoubleValue2 = this.f3621b.get(i).doubleValue();
            if (d < dDoubleValue || (dDoubleValue == d && d2 < dDoubleValue2)) {
                break;
            }
            i++;
        }
        this.f3620a.add(i, str);
        this.c.add(i, Double.valueOf(d));
        this.f3621b.add(i, Double.valueOf(d2));
        return this;
    }

    public final yv a() {
        return new yv(this);
    }
}
