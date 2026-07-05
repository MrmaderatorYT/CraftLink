package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class aqg implements auk {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqk f2164a;

    public static aqg a(zzbqk zzbqkVar) {
        return zzbqkVar.f3659a != null ? zzbqkVar.f3659a : new aqg(zzbqkVar);
    }

    private aqg(zzbqk zzbqkVar) {
        this.f2164a = (zzbqk) ara.a(zzbqkVar, "output");
        this.f2164a.f3659a = this;
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final int a() {
        return aqy.e.j;
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, int i2) {
        this.f2164a.e(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, long j) {
        this.f2164a.a(i, j);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void b(int i, long j) {
        this.f2164a.c(i, j);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, float f) {
        this.f2164a.a(i, f);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, double d) {
        this.f2164a.a(i, d);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void b(int i, int i2) {
        this.f2164a.b(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void c(int i, long j) {
        this.f2164a.a(i, j);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void c(int i, int i2) {
        this.f2164a.b(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void d(int i, long j) {
        this.f2164a.c(i, j);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void d(int i, int i2) {
        this.f2164a.e(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, boolean z) {
        this.f2164a.a(i, z);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, String str) {
        this.f2164a.a(i, str);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, apo apoVar) {
        this.f2164a.a(i, apoVar);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void e(int i, int i2) {
        this.f2164a.c(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void f(int i, int i2) {
        this.f2164a.d(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void e(int i, long j) {
        this.f2164a.b(i, j);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, Object obj, asx asxVar) {
        this.f2164a.a(i, (asf) obj, asxVar);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void b(int i, Object obj, asx asxVar) {
        zzbqk zzbqkVar = this.f2164a;
        zzbqkVar.a(i, 3);
        asxVar.a((asx) obj, (auk) zzbqkVar.f3659a);
        zzbqkVar.a(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i) {
        this.f2164a.a(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void b(int i) {
        this.f2164a.a(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, Object obj) {
        if (obj instanceof apo) {
            this.f2164a.b(i, (apo) obj);
        } else {
            this.f2164a.b(i, (asf) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iF += zzbqk.f(list.get(i3).intValue());
            }
            this.f2164a.b(iF);
            while (i2 < list.size()) {
                this.f2164a.a(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.b(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void b(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzbqk.i(list.get(i4).intValue());
            }
            this.f2164a.b(i3);
            while (i2 < list.size()) {
                this.f2164a.d(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.e(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void c(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iD += zzbqk.d(list.get(i3).longValue());
            }
            this.f2164a.b(iD);
            while (i2 < list.size()) {
                this.f2164a.a(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.a(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void d(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iE += zzbqk.e(list.get(i3).longValue());
            }
            this.f2164a.b(iE);
            while (i2 < list.size()) {
                this.f2164a.a(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.a(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void e(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iG += zzbqk.g(list.get(i3).longValue());
            }
            this.f2164a.b(iG);
            while (i2 < list.size()) {
                this.f2164a.c(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.c(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void f(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iB += zzbqk.b(list.get(i3).floatValue());
            }
            this.f2164a.b(iB);
            while (i2 < list.size()) {
                this.f2164a.a(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.a(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void g(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iB += zzbqk.b(list.get(i3).doubleValue());
            }
            this.f2164a.b(iB);
            while (i2 < list.size()) {
                this.f2164a.a(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.a(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void h(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iK = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iK += zzbqk.k(list.get(i3).intValue());
            }
            this.f2164a.b(iK);
            while (i2 < list.size()) {
                this.f2164a.a(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.b(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void i(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iB += zzbqk.b(list.get(i3).booleanValue());
            }
            this.f2164a.b(iB);
            while (i2 < list.size()) {
                this.f2164a.a(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.a(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof arn) {
            arn arnVar = (arn) list;
            while (i2 < list.size()) {
                Object objB = arnVar.b(i2);
                if (objB instanceof String) {
                    this.f2164a.a(i, (String) objB);
                } else {
                    this.f2164a.a(i, (apo) objB);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.a(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void b(int i, List<apo> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f2164a.a(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void j(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iG = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iG += zzbqk.g(list.get(i3).intValue());
            }
            this.f2164a.b(iG);
            while (i2 < list.size()) {
                this.f2164a.b(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.c(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void k(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iJ = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iJ += zzbqk.j(list.get(i3).intValue());
            }
            this.f2164a.b(iJ);
            while (i2 < list.size()) {
                this.f2164a.d(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.e(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void l(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iH = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iH += zzbqk.h(list.get(i3).longValue());
            }
            this.f2164a.b(iH);
            while (i2 < list.size()) {
                this.f2164a.c(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.c(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void m(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iH = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iH += zzbqk.h(list.get(i3).intValue());
            }
            this.f2164a.b(iH);
            while (i2 < list.size()) {
                this.f2164a.c(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.d(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void n(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f2164a.a(i, 2);
            int iF = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iF += zzbqk.f(list.get(i3).longValue());
            }
            this.f2164a.b(iF);
            while (i2 < list.size()) {
                this.f2164a.b(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f2164a.b(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void a(int i, List<?> list, asx asxVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(i, list.get(i2), asxVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final void b(int i, List<?> list, asx asxVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            b(i, list.get(i2), asxVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.auk
    public final <K, V> void a(int i, ary<K, V> aryVar, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f2164a.a(i, 2);
            this.f2164a.b(arx.a(aryVar, entry.getKey(), entry.getValue()));
            arx.a(this.f2164a, aryVar, entry.getKey(), entry.getValue());
        }
    }
}
