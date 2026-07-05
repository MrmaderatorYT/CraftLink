package io.netty.util.concurrent;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultThreadFactory.java */
/* loaded from: classes.dex */
public class i implements ThreadFactory {

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f4741b = new AtomicInteger();

    /* renamed from: a, reason: collision with root package name */
    protected final ThreadGroup f4742a;
    private final AtomicInteger c;
    private final String d;
    private final boolean e;
    private final int f;

    public i(Class<?> cls) {
        this(cls, false, 5);
    }

    public i(Class<?> cls, int i) {
        this(cls, false, i);
    }

    public i(Class<?> cls, boolean z, int i) {
        this(a(cls), z, i);
    }

    public static String a(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException("poolType");
        }
        String strA = io.netty.util.a.p.a(cls);
        switch (strA.length()) {
            case 0:
                return "unknown";
            case 1:
                return strA.toLowerCase(Locale.US);
            default:
                if (!Character.isUpperCase(strA.charAt(0)) || !Character.isLowerCase(strA.charAt(1))) {
                    return strA;
                }
                return Character.toLowerCase(strA.charAt(0)) + strA.substring(1);
        }
    }

    public i(String str, boolean z, int i, ThreadGroup threadGroup) {
        this.c = new AtomicInteger();
        if (str == null) {
            throw new NullPointerException("poolName");
        }
        if (i < 1 || i > 10) {
            throw new IllegalArgumentException("priority: " + i + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
        }
        this.d = str + '-' + f4741b.incrementAndGet() + '-';
        this.e = z;
        this.f = i;
        this.f4742a = threadGroup;
    }

    public i(String str, boolean z, int i) {
        this(str, z, i, System.getSecurityManager() == null ? Thread.currentThread().getThreadGroup() : System.getSecurityManager().getThreadGroup());
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadA = a(new a(runnable), this.d + this.c.incrementAndGet());
        try {
            if (threadA.isDaemon()) {
                if (!this.e) {
                    threadA.setDaemon(false);
                }
            } else if (this.e) {
                threadA.setDaemon(true);
            }
            if (threadA.getPriority() != this.f) {
                threadA.setPriority(this.f);
            }
        } catch (Exception unused) {
        }
        return threadA;
    }

    protected Thread a(Runnable runnable, String str) {
        return new o(this.f4742a, runnable, str);
    }

    /* compiled from: DefaultThreadFactory.java */
    private static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f4743a;

        a(Runnable runnable) {
            this.f4743a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4743a.run();
            } finally {
                n.c();
            }
        }
    }
}
