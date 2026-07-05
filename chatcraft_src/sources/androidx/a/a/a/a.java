package androidx.a.a.a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor.java */
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f70a;
    private static final Executor d = new Executor() { // from class: androidx.a.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().b(runnable);
        }
    };
    private static final Executor e = new Executor() { // from class: androidx.a.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().a(runnable);
        }
    };
    private c c = new b();

    /* renamed from: b, reason: collision with root package name */
    private c f71b = this.c;

    private a() {
    }

    public static a a() {
        if (f70a != null) {
            return f70a;
        }
        synchronized (a.class) {
            if (f70a == null) {
                f70a = new a();
            }
        }
        return f70a;
    }

    @Override // androidx.a.a.a.c
    public void a(Runnable runnable) {
        this.f71b.a(runnable);
    }

    @Override // androidx.a.a.a.c
    public void b(Runnable runnable) {
        this.f71b.b(runnable);
    }

    @Override // androidx.a.a.a.c
    public boolean b() {
        return this.f71b.b();
    }
}
