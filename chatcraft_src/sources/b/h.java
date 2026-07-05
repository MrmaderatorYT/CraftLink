package b;

/* compiled from: ForwardingSource.java */
/* loaded from: classes.dex */
public abstract class h implements s {

    /* renamed from: a, reason: collision with root package name */
    private final s f1170a;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f1170a = sVar;
    }

    public final s b() {
        return this.f1170a;
    }

    @Override // b.s
    public long a(c cVar, long j) {
        return this.f1170a.a(cVar, j);
    }

    @Override // b.s
    public t a() {
        return this.f1170a.a();
    }

    @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1170a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f1170a.toString() + ")";
    }
}
