package b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: AsyncTimeout.java */
/* loaded from: classes.dex */
public class a extends t {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    static a f1157b;
    private boolean e;

    @Nullable
    private a f;
    private long g;

    /* renamed from: a, reason: collision with root package name */
    private static final long f1156a = TimeUnit.SECONDS.toMillis(60);
    private static final long d = TimeUnit.MILLISECONDS.toNanos(f1156a);

    protected void a() {
    }

    public final void c() {
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jH_ = H_();
        boolean zI_ = I_();
        if (jH_ != 0 || zI_) {
            this.e = true;
            a(this, jH_, zI_);
        }
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        if (f1157b == null) {
            f1157b = new a();
            new C0056a().start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z) {
            aVar.g = Math.min(j, aVar.d() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            aVar.g = j + jNanoTime;
        } else if (z) {
            aVar.g = aVar.d();
        } else {
            throw new AssertionError();
        }
        long jB = aVar.b(jNanoTime);
        a aVar2 = f1157b;
        while (aVar2.f != null && jB >= aVar2.f.b(jNanoTime)) {
            aVar2 = aVar2.f;
        }
        aVar.f = aVar2.f;
        aVar2.f = aVar;
        if (aVar2 == f1157b) {
            a.class.notify();
        }
    }

    public final boolean G_() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        return a(this);
    }

    private static synchronized boolean a(a aVar) {
        for (a aVar2 = f1157b; aVar2 != null; aVar2 = aVar2.f) {
            if (aVar2.f == aVar) {
                aVar2.f = aVar.f;
                aVar.f = null;
                return false;
            }
        }
        return true;
    }

    private long b(long j) {
        return this.g - j;
    }

    public final r a(final r rVar) {
        return new r() { // from class: b.a.1
            @Override // b.r
            public void a_(c cVar, long j) throws IOException {
                u.a(cVar.f1165b, 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j <= 0) {
                        return;
                    }
                    o oVar = cVar.f1164a;
                    while (true) {
                        if (j2 >= 65536) {
                            break;
                        }
                        j2 += oVar.c - oVar.f1188b;
                        if (j2 >= j) {
                            j2 = j;
                            break;
                        }
                        oVar = oVar.f;
                    }
                    a.this.c();
                    try {
                        try {
                            rVar.a_(cVar, j2);
                            j -= j2;
                            a.this.a(true);
                        } catch (IOException e) {
                            throw a.this.b(e);
                        }
                    } catch (Throwable th) {
                        a.this.a(false);
                        throw th;
                    }
                }
            }

            @Override // b.r, java.io.Flushable
            public void flush() throws IOException {
                a.this.c();
                try {
                    try {
                        rVar.flush();
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.b(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // b.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                a.this.c();
                try {
                    try {
                        rVar.close();
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.b(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // b.r
            public t a() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + rVar + ")";
            }
        };
    }

    public final s a(final s sVar) {
        return new s() { // from class: b.a.2
            @Override // b.s
            public long a(c cVar, long j) throws IOException {
                a.this.c();
                try {
                    try {
                        long jA = sVar.a(cVar, j);
                        a.this.a(true);
                        return jA;
                    } catch (IOException e) {
                        throw a.this.b(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    try {
                        sVar.close();
                        a.this.a(true);
                    } catch (IOException e) {
                        throw a.this.b(e);
                    }
                } catch (Throwable th) {
                    a.this.a(false);
                    throw th;
                }
            }

            @Override // b.s
            public t a() {
                return a.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + sVar + ")";
            }
        };
    }

    final void a(boolean z) throws IOException {
        if (G_() && z) {
            throw a((IOException) null);
        }
    }

    final IOException b(IOException iOException) {
        return !G_() ? iOException : a(iOException);
    }

    protected IOException a(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* compiled from: AsyncTimeout.java */
    /* renamed from: b.a$a, reason: collision with other inner class name */
    private static final class C0056a extends Thread {
        C0056a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        
            r1.a();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<b.a> r0 = b.a.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                b.a r1 = b.a.e()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                b.a r2 = b.a.f1157b     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                b.a.f1157b = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.a()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.C0056a.run():void");
        }
    }

    @Nullable
    static a e() throws InterruptedException {
        a aVar = f1157b.f;
        if (aVar == null) {
            long jNanoTime = System.nanoTime();
            a.class.wait(f1156a);
            if (f1157b.f != null || System.nanoTime() - jNanoTime < d) {
                return null;
            }
            return f1157b;
        }
        long jB = aVar.b(System.nanoTime());
        if (jB > 0) {
            long j = jB / 1000000;
            a.class.wait(j, (int) (jB - (1000000 * j)));
            return null;
        }
        f1157b.f = aVar.f;
        aVar.f = null;
        return aVar;
    }
}
