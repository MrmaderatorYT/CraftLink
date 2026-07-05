package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@qj
/* loaded from: classes.dex */
public final class ke implements js {

    /* renamed from: a, reason: collision with root package name */
    private final ri f3222a;

    /* renamed from: b, reason: collision with root package name */
    private final kk f3223b;
    private final Context c;
    private final ju d;
    private final boolean e;
    private final long f;
    private final long g;
    private final boolean l;
    private final String m;
    private final boolean o;
    private final Object i = new Object();
    private boolean j = false;
    private final Map<abl<ka>, jx> k = new HashMap();
    private List<ka> n = new ArrayList();
    private final int h = 2;

    public ke(Context context, ri riVar, kk kkVar, ju juVar, boolean z, boolean z2, String str, long j, long j2, int i, boolean z3) {
        this.c = context;
        this.f3222a = riVar;
        this.f3223b = kkVar;
        this.d = juVar;
        this.e = z;
        this.l = z2;
        this.m = str;
        this.f = j;
        this.g = j2;
        this.o = z3;
    }

    @Override // com.google.android.gms.internal.ads.js
    public final ka a(List<jt> list) {
        xe.b("Starting mediation.");
        ArrayList arrayList = new ArrayList();
        bqn bqnVar = this.f3222a.d;
        int[] iArr = new int[2];
        if (bqnVar.g != null) {
            com.google.android.gms.ads.internal.ax.y();
            if (kc.a(this.m, iArr)) {
                int i = 0;
                int i2 = iArr[0];
                int i3 = iArr[1];
                bqn[] bqnVarArr = bqnVar.g;
                int length = bqnVarArr.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    bqn bqnVar2 = bqnVarArr[i];
                    if (i2 == bqnVar2.e && i3 == bqnVar2.f2975b) {
                        bqnVar = bqnVar2;
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator<jt> it = list.iterator();
        while (it.hasNext()) {
            jt next = it.next();
            String strValueOf = String.valueOf(next.f3210b);
            xe.d(strValueOf.length() != 0 ? "Trying mediation network: ".concat(strValueOf) : new String("Trying mediation network: "));
            for (Iterator<String> it2 = next.c.iterator(); it2.hasNext(); it2 = it2) {
                ArrayList arrayList2 = arrayList;
                jx jxVar = new jx(this.c, it2.next(), this.f3223b, this.d, next, this.f3222a.c, bqnVar, this.f3222a.k, this.e, this.l, this.f3222a.y, this.f3222a.n, this.f3222a.z, this.f3222a.X, this.o);
                abl<ka> ablVarA = xl.a(new kf(this, jxVar));
                this.k.put(ablVarA, jxVar);
                arrayList2.add(ablVarA);
                arrayList = arrayList2;
                it = it;
            }
        }
        ArrayList arrayList3 = arrayList;
        if (this.h == 2) {
            return c(arrayList3);
        }
        return b(arrayList3);
    }

    private final ka b(List<abl<ka>> list) {
        ka kaVar;
        synchronized (this.i) {
            if (this.j) {
                return new ka(-1);
            }
            for (abl<ka> ablVar : list) {
                try {
                    kaVar = ablVar.get();
                    this.n.add(kaVar);
                } catch (InterruptedException | ExecutionException e) {
                    xe.c("Exception while processing an adapter; continuing with other adapters", e);
                }
                if (kaVar != null && kaVar.f3220a == 0) {
                    a(ablVar);
                    return kaVar;
                }
            }
            a((abl<ka>) null);
            return new ka(1);
        }
    }

    private final ka c(List<abl<ka>> list) {
        ka kaVar;
        kt ktVar;
        synchronized (this.i) {
            if (this.j) {
                return new ka(-1);
            }
            long j = this.d.n != -1 ? this.d.n : 10000L;
            abl<ka> ablVar = null;
            long jMax = j;
            ka kaVar2 = null;
            int iA = -1;
            for (abl<ka> ablVar2 : list) {
                long jA = com.google.android.gms.ads.internal.ax.l().a();
                if (jMax == 0) {
                    try {
                        try {
                            if (ablVar2.isDone()) {
                                kaVar = ablVar2.get();
                            }
                            this.n.add(kaVar);
                            if (kaVar != null && kaVar.f3220a == 0 && (ktVar = kaVar.f) != null && ktVar.a() > iA) {
                                ablVar = ablVar2;
                                kaVar2 = kaVar;
                                iA = ktVar.a();
                            }
                            jMax = Math.max(jMax - (com.google.android.gms.ads.internal.ax.l().a() - jA), 0L);
                        } catch (RemoteException | InterruptedException | ExecutionException | TimeoutException e) {
                            xe.c("Exception while processing an adapter; continuing with other adapters", e);
                            jMax = Math.max(jMax - (com.google.android.gms.ads.internal.ax.l().a() - jA), 0L);
                        }
                    } catch (Throwable th) {
                        Math.max(jMax - (com.google.android.gms.ads.internal.ax.l().a() - jA), 0L);
                        throw th;
                    }
                }
                kaVar = ablVar2.get(jMax, TimeUnit.MILLISECONDS);
                this.n.add(kaVar);
                if (kaVar != null) {
                    ablVar = ablVar2;
                    kaVar2 = kaVar;
                    iA = ktVar.a();
                }
                jMax = Math.max(jMax - (com.google.android.gms.ads.internal.ax.l().a() - jA), 0L);
            }
            a(ablVar);
            return kaVar2 == null ? new ka(1) : kaVar2;
        }
    }

    private final void a(abl<ka> ablVar) {
        xn.f3583a.post(new kg(this, ablVar));
    }

    @Override // com.google.android.gms.internal.ads.js
    public final void a() {
        synchronized (this.i) {
            this.j = true;
            Iterator<jx> it = this.k.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.js
    public final List<ka> b() {
        return this.n;
    }
}
