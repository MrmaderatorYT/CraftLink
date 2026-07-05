package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.a;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: PriorityAsyncTask.java */
/* loaded from: classes.dex */
public abstract class f<Params, Progress, Result> extends io.fabric.sdk.android.services.concurrency.a<Params, Progress, Result> implements b<l>, i, l {

    /* renamed from: a, reason: collision with root package name */
    private final j f4279a = new j();

    public final void a(ExecutorService executorService, Params... paramsArr) {
        super.a(new a(executorService, this), paramsArr);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return e.a(this, obj);
    }

    @Override // io.fabric.sdk.android.services.concurrency.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(l lVar) {
        if (t_() != a.d.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((b) ((i) g())).c(lVar);
    }

    @Override // io.fabric.sdk.android.services.concurrency.b
    public Collection<l> c() {
        return ((b) ((i) g())).c();
    }

    @Override // io.fabric.sdk.android.services.concurrency.b
    public boolean d() {
        return ((b) ((i) g())).d();
    }

    public e b() {
        return ((i) g()).b();
    }

    @Override // io.fabric.sdk.android.services.concurrency.l
    public void b(boolean z) {
        ((l) ((i) g())).b(z);
    }

    @Override // io.fabric.sdk.android.services.concurrency.l
    public boolean f() {
        return ((l) ((i) g())).f();
    }

    @Override // io.fabric.sdk.android.services.concurrency.l
    public void a(Throwable th) {
        ((l) ((i) g())).a(th);
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lio/fabric/sdk/android/services/concurrency/b<Lio/fabric/sdk/android/services/concurrency/l;>;:Lio/fabric/sdk/android/services/concurrency/i;:Lio/fabric/sdk/android/services/concurrency/l;>()TT; */
    public b g() {
        return this.f4279a;
    }

    /* compiled from: PriorityAsyncTask.java */
    private static class a<Result> implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Executor f4280a;

        /* renamed from: b, reason: collision with root package name */
        private final f f4281b;

        public a(Executor executor, f fVar) {
            this.f4280a = executor;
            this.f4281b = fVar;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f4280a.execute(new h<Result>(runnable, null) { // from class: io.fabric.sdk.android.services.concurrency.f.a.1
                /* JADX WARN: Incorrect return type in method signature: <T::Lio/fabric/sdk/android/services/concurrency/b<Lio/fabric/sdk/android/services/concurrency/l;>;:Lio/fabric/sdk/android/services/concurrency/i;:Lio/fabric/sdk/android/services/concurrency/l;>()TT; */
                @Override // io.fabric.sdk.android.services.concurrency.h
                public b a() {
                    return a.this.f4281b;
                }
            });
        }
    }
}
