package b;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout.java */
/* loaded from: classes.dex */
public class t {
    public static final t c = new t() { // from class: b.t.1
        @Override // b.t
        public t a(long j) {
            return this;
        }

        @Override // b.t
        public t a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // b.t
        public void g() {
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private boolean f1191a;

    /* renamed from: b, reason: collision with root package name */
    private long f1192b;
    private long d;

    public t a(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.d = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long H_() {
        return this.d;
    }

    public boolean I_() {
        return this.f1191a;
    }

    public long d() {
        if (!this.f1191a) {
            throw new IllegalStateException("No deadline");
        }
        return this.f1192b;
    }

    public t a(long j) {
        this.f1191a = true;
        this.f1192b = j;
        return this;
    }

    public t J_() {
        this.d = 0L;
        return this;
    }

    public t f() {
        this.f1191a = false;
        return this;
    }

    public void g() throws InterruptedIOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.f1191a && this.f1192b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
