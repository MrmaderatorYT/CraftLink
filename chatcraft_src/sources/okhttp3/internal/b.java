package okhttp3.internal;

/* compiled from: NamedRunnable.java */
/* loaded from: classes.dex */
public abstract class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    protected final String f5105b;

    protected abstract void c();

    public b(String str, Object... objArr) {
        this.f5105b = c.a(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f5105b);
        try {
            c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
