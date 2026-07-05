package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
final class gp {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<gq> f3105a;

    /* renamed from: b, reason: collision with root package name */
    private bqj f3106b;
    private final String c;
    private final int d;
    private boolean e;

    gp(bqj bqjVar, String str, int i) {
        com.google.android.gms.common.internal.i.a(bqjVar);
        com.google.android.gms.common.internal.i.a(str);
        this.f3105a = new LinkedList<>();
        this.f3106b = bqjVar;
        this.c = str;
        this.d = i;
    }

    final bqj a() {
        return this.f3106b;
    }

    final int b() {
        return this.d;
    }

    final String c() {
        return this.c;
    }

    final gq a(bqj bqjVar) {
        if (bqjVar != null) {
            this.f3106b = bqjVar;
        }
        return this.f3105a.remove();
    }

    final int d() {
        return this.f3105a.size();
    }

    final int e() {
        Iterator<gq> it = this.f3105a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().e) {
                i++;
            }
        }
        return i;
    }

    final boolean a(fi fiVar) {
        gq gqVar = new gq(this, fiVar);
        this.f3105a.add(gqVar);
        return gqVar.a();
    }

    final int f() {
        Iterator<gq> it = this.f3105a.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().a()) {
                i++;
            }
        }
        return i;
    }

    final void a(fi fiVar, bqj bqjVar) {
        this.f3105a.add(new gq(this, fiVar, bqjVar));
    }

    final void g() {
        this.e = true;
    }

    final boolean h() {
        return this.e;
    }
}
