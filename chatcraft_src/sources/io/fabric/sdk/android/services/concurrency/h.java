package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: PriorityFutureTask.java */
/* loaded from: classes.dex */
public class h<V> extends FutureTask<V> implements b<l>, i, l {

    /* renamed from: b, reason: collision with root package name */
    final Object f4283b;

    public h(Callable<V> callable) {
        super(callable);
        this.f4283b = a(callable);
    }

    public h(Runnable runnable, V v) {
        super(runnable, v);
        this.f4283b = a(runnable);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((i) a()).compareTo(obj);
    }

    @Override // io.fabric.sdk.android.services.concurrency.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(l lVar) {
        ((b) ((i) a())).c(lVar);
    }

    @Override // io.fabric.sdk.android.services.concurrency.b
    public Collection<l> c() {
        return ((b) ((i) a())).c();
    }

    @Override // io.fabric.sdk.android.services.concurrency.b
    public boolean d() {
        return ((b) ((i) a())).d();
    }

    @Override // io.fabric.sdk.android.services.concurrency.i
    public e b() {
        return ((i) a()).b();
    }

    @Override // io.fabric.sdk.android.services.concurrency.l
    public void b(boolean z) {
        ((l) ((i) a())).b(z);
    }

    @Override // io.fabric.sdk.android.services.concurrency.l
    public boolean f() {
        return ((l) ((i) a())).f();
    }

    @Override // io.fabric.sdk.android.services.concurrency.l
    public void a(Throwable th) {
        ((l) ((i) a())).a(th);
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lio/fabric/sdk/android/services/concurrency/b<Lio/fabric/sdk/android/services/concurrency/l;>;:Lio/fabric/sdk/android/services/concurrency/i;:Lio/fabric/sdk/android/services/concurrency/l;>()TT; */
    public b a() {
        return (b) this.f4283b;
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lio/fabric/sdk/android/services/concurrency/b<Lio/fabric/sdk/android/services/concurrency/l;>;:Lio/fabric/sdk/android/services/concurrency/i;:Lio/fabric/sdk/android/services/concurrency/l;>(Ljava/lang/Object;)TT; */
    protected b a(Object obj) {
        if (j.a(obj)) {
            return (b) obj;
        }
        return new j();
    }
}
