package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

@qj
/* loaded from: classes.dex */
public final class yv {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f3616a;

    /* renamed from: b, reason: collision with root package name */
    private final double[] f3617b;
    private final double[] c;
    private final int[] d;
    private int e;

    private yv(yy yyVar) {
        int size = yyVar.f3621b.size();
        this.f3616a = (String[]) yyVar.f3620a.toArray(new String[size]);
        this.f3617b = a((List<Double>) yyVar.f3621b);
        this.c = a((List<Double>) yyVar.c);
        this.d = new int[size];
        this.e = 0;
    }

    private static double[] a(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void a(double d) {
        this.e++;
        for (int i = 0; i < this.c.length; i++) {
            if (this.c[i] <= d && d < this.f3617b[i]) {
                int[] iArr = this.d;
                iArr[i] = iArr[i] + 1;
            }
            if (d < this.c[i]) {
                return;
            }
        }
    }

    public final List<yx> a() {
        ArrayList arrayList = new ArrayList(this.f3616a.length);
        for (int i = 0; i < this.f3616a.length; i++) {
            String str = this.f3616a[i];
            double d = this.c[i];
            double d2 = this.f3617b[i];
            double d3 = this.d[i];
            double d4 = this.e;
            Double.isNaN(d3);
            Double.isNaN(d4);
            arrayList.add(new yx(str, d, d2, d3 / d4, this.d[i]));
        }
        return arrayList;
    }
}
