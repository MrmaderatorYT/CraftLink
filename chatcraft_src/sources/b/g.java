package b;

/* compiled from: ForwardingSink.java */
/* loaded from: classes.dex */
public abstract class g implements r {

    /* renamed from: a, reason: collision with root package name */
    private final r f1169a;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f1169a = rVar;
    }

    @Override // b.r
    public void a_(c cVar, long j) {
        this.f1169a.a_(cVar, j);
    }

    @Override // b.r, java.io.Flushable
    public void flush() {
        this.f1169a.flush();
    }

    @Override // b.r
    public t a() {
        return this.f1169a.a();
    }

    @Override // b.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1169a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f1169a.toString() + ")";
    }
}
