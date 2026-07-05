package io.fabric.sdk.android.services.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: PriorityTask.java */
/* loaded from: classes.dex */
public class j implements b<l>, i, l {

    /* renamed from: a, reason: collision with root package name */
    private final List<l> f4284a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f4285b = new AtomicBoolean(false);
    private final AtomicReference<Throwable> c = new AtomicReference<>(null);

    @Override // io.fabric.sdk.android.services.concurrency.b
    public synchronized Collection<l> c() {
        return Collections.unmodifiableCollection(this.f4284a);
    }

    @Override // io.fabric.sdk.android.services.concurrency.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized void c(l lVar) {
        this.f4284a.add(lVar);
    }

    @Override // io.fabric.sdk.android.services.concurrency.b
    public boolean d() {
        Iterator<l> it = c().iterator();
        while (it.hasNext()) {
            if (!it.next().f()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.fabric.sdk.android.services.concurrency.l
    public synchronized void b(boolean z) {
        this.f4285b.set(z);
    }

    @Override // io.fabric.sdk.android.services.concurrency.l
    public boolean f() {
        return this.f4285b.get();
    }

    public e b() {
        return e.NORMAL;
    }

    @Override // io.fabric.sdk.android.services.concurrency.l
    public void a(Throwable th) {
        this.c.set(th);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return e.a(this, obj);
    }

    public static boolean a(Object obj) {
        try {
            return (((b) obj) == null || ((l) obj) == null || ((i) obj) == null) ? false : true;
        } catch (ClassCastException unused) {
            return false;
        }
    }
}
