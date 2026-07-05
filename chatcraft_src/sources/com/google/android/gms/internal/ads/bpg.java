package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class bpg {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f2937a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<blc<?>> f2938b;
    private final PriorityBlockingQueue<blc<?>> c;
    private final PriorityBlockingQueue<blc<?>> d;
    private final zh e;
    private final bge f;
    private final a g;
    private final bhe[] h;
    private axi i;
    private final List<bqh> j;

    private bpg(zh zhVar, bge bgeVar, int i, a aVar) {
        this.f2937a = new AtomicInteger();
        this.f2938b = new HashSet();
        this.c = new PriorityBlockingQueue<>();
        this.d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.e = zhVar;
        this.f = bgeVar;
        this.h = new bhe[4];
        this.g = aVar;
    }

    private bpg(zh zhVar, bge bgeVar, int i) {
        this(zhVar, bgeVar, 4, new bcd(new Handler(Looper.getMainLooper())));
    }

    public bpg(zh zhVar, bge bgeVar) {
        this(zhVar, bgeVar, 4);
    }

    public final void a() {
        if (this.i != null) {
            this.i.a();
        }
        for (bhe bheVar : this.h) {
            if (bheVar != null) {
                bheVar.a();
            }
        }
        this.i = new axi(this.c, this.d, this.e, this.g);
        this.i.start();
        for (int i = 0; i < this.h.length; i++) {
            bhe bheVar2 = new bhe(this.d, this.f, this.e, this.g);
            this.h[i] = bheVar2;
            bheVar2.start();
        }
    }

    public final <T> blc<T> a(blc<T> blcVar) {
        blcVar.a(this);
        synchronized (this.f2938b) {
            this.f2938b.add(blcVar);
        }
        blcVar.a(this.f2937a.incrementAndGet());
        blcVar.b("add-to-queue");
        if (!blcVar.i()) {
            this.d.add(blcVar);
            return blcVar;
        }
        this.c.add(blcVar);
        return blcVar;
    }

    final <T> void b(blc<T> blcVar) {
        synchronized (this.f2938b) {
            this.f2938b.remove(blcVar);
        }
        synchronized (this.j) {
            Iterator<bqh> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().a(blcVar);
            }
        }
    }
}
