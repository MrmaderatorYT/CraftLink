package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@qj
/* loaded from: classes.dex */
public class acb<T> implements abx<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1825a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private int f1826b = 0;
    private final BlockingQueue<acc> c = new LinkedBlockingQueue();
    private T d;

    @Override // com.google.android.gms.internal.ads.abx
    public final void a(aca<T> acaVar, aby abyVar) {
        synchronized (this.f1825a) {
            if (this.f1826b == 1) {
                acaVar.a(this.d);
            } else if (this.f1826b == -1) {
                abyVar.a();
            } else if (this.f1826b == 0) {
                this.c.add(new acc(this, acaVar, abyVar));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.abx
    public final void a(T t) {
        synchronized (this.f1825a) {
            if (this.f1826b != 0) {
                throw new UnsupportedOperationException();
            }
            this.d = t;
            this.f1826b = 1;
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((acc) it.next()).f1827a.a(t);
            }
            this.c.clear();
        }
    }

    public final void d() {
        synchronized (this.f1825a) {
            if (this.f1826b != 0) {
                throw new UnsupportedOperationException();
            }
            this.f1826b = -1;
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((acc) it.next()).f1828b.a();
            }
            this.c.clear();
        }
    }

    public final int e() {
        return this.f1826b;
    }
}
