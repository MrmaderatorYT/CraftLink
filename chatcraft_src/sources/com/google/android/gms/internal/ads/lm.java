package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.b.d;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@qj
/* loaded from: classes.dex */
public final class lm implements com.google.android.gms.ads.mediation.i {

    /* renamed from: a, reason: collision with root package name */
    private final Date f3247a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3248b;
    private final Set<String> c;
    private final boolean d;
    private final Location e;
    private final int f;
    private final br g;
    private final boolean i;
    private final List<String> h = new ArrayList();
    private final Map<String, Boolean> j = new HashMap();

    public lm(Date date, int i, Set<String> set, Location location, boolean z, int i2, br brVar, List<String> list, boolean z2) {
        this.f3247a = date;
        this.f3248b = i;
        this.c = set;
        this.e = location;
        this.d = z;
        this.f = i2;
        this.g = brVar;
        this.i = z2;
        if (list != null) {
            for (String str : list) {
                if (str.startsWith("custom:")) {
                    String[] strArrSplit = str.split(":", 3);
                    if (strArrSplit.length == 3) {
                        if ("true".equals(strArrSplit[2])) {
                            this.j.put(strArrSplit[1], true);
                        } else if ("false".equals(strArrSplit[2])) {
                            this.j.put(strArrSplit[1], false);
                        }
                    }
                } else {
                    this.h.add(str);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.a
    @Deprecated
    public final Date a() {
        return this.f3247a;
    }

    @Override // com.google.android.gms.ads.mediation.a
    @Deprecated
    public final int b() {
        return this.f3248b;
    }

    @Override // com.google.android.gms.ads.mediation.a
    public final Set<String> c() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.mediation.a
    public final Location d() {
        return this.e;
    }

    @Override // com.google.android.gms.ads.mediation.a
    public final boolean f() {
        return this.d;
    }

    @Override // com.google.android.gms.ads.mediation.a
    public final int e() {
        return this.f;
    }

    @Override // com.google.android.gms.ads.mediation.i
    public final com.google.android.gms.ads.b.d h() {
        if (this.g == null) {
            return null;
        }
        d.a aVarB = new d.a().a(this.g.f2997b).a(this.g.c).b(this.g.d);
        if (this.g.f2996a >= 2) {
            aVarB.b(this.g.e);
        }
        if (this.g.f2996a >= 3 && this.g.f != null) {
            aVarB.a(new com.google.android.gms.ads.k(this.g.f));
        }
        return aVarB.a();
    }

    @Override // com.google.android.gms.ads.mediation.i
    public final boolean i() {
        if (this.h != null) {
            return this.h.contains("2") || this.h.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.i
    public final boolean j() {
        return this.h != null && this.h.contains("6");
    }

    @Override // com.google.android.gms.ads.mediation.i
    public final boolean k() {
        if (this.h != null) {
            return this.h.contains("1") || this.h.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.i
    public final boolean l() {
        return this.h != null && this.h.contains("3");
    }

    @Override // com.google.android.gms.ads.mediation.i
    public final Map<String, Boolean> m() {
        return this.j;
    }

    @Override // com.google.android.gms.ads.mediation.a
    @Deprecated
    public final boolean g() {
        return this.i;
    }
}
