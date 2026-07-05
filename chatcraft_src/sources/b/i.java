package b;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.java */
/* loaded from: classes.dex */
public class i extends t {

    /* renamed from: a, reason: collision with root package name */
    private t f1171a;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f1171a = tVar;
    }

    public final t a() {
        return this.f1171a;
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f1171a = tVar;
        return this;
    }

    @Override // b.t
    public t a(long j, TimeUnit timeUnit) {
        return this.f1171a.a(j, timeUnit);
    }

    @Override // b.t
    public long H_() {
        return this.f1171a.H_();
    }

    @Override // b.t
    public boolean I_() {
        return this.f1171a.I_();
    }

    @Override // b.t
    public long d() {
        return this.f1171a.d();
    }

    @Override // b.t
    public t a(long j) {
        return this.f1171a.a(j);
    }

    @Override // b.t
    public t J_() {
        return this.f1171a.J_();
    }

    @Override // b.t
    public t f() {
        return this.f1171a.f();
    }

    @Override // b.t
    public void g() throws InterruptedIOException {
        this.f1171a.g();
    }
}
