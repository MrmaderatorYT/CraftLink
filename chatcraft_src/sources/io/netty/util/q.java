package io.netty.util;

import java.lang.reflect.Constructor;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* compiled from: ResourceLeakDetectorFactory.java */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4789a = io.netty.util.a.b.d.a((Class<?>) q.class);

    /* renamed from: b, reason: collision with root package name */
    private static volatile q f4790b = new a();

    public abstract <T> p<T> a(Class<T> cls, int i, long j);

    public static q a() {
        return f4790b;
    }

    public final <T> p<T> a(Class<T> cls) {
        return a(cls, 128, Long.MAX_VALUE);
    }

    /* compiled from: ResourceLeakDetectorFactory.java */
    private static final class a extends q {

        /* renamed from: a, reason: collision with root package name */
        private final Constructor<?> f4791a;

        a() {
            String str;
            try {
                str = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.util.q.a.1
                    @Override // java.security.PrivilegedAction
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public String run() {
                        return io.netty.util.a.q.b("io.netty.customResourceLeakDetector");
                    }
                });
            } catch (Throwable th) {
                q.f4789a.c("Could not access System property: io.netty.customResourceLeakDetector", th);
                str = null;
            }
            this.f4791a = str != null ? a(str) : null;
        }

        private static Constructor<?> a(String str) {
            try {
                Class<?> cls = Class.forName(str, true, io.netty.util.a.l.p());
                if (p.class.isAssignableFrom(cls)) {
                    return cls.getConstructor(Class.class, Integer.TYPE, Long.TYPE);
                }
                q.f4789a.d("Class {} does not inherit from ResourceLeakDetector.", str);
                return null;
            } catch (Throwable th) {
                q.f4789a.d("Could not load custom resource leak detector class provided: {}", str, th);
                return null;
            }
        }

        @Override // io.netty.util.q
        public <T> p<T> a(Class<T> cls, int i, long j) {
            if (this.f4791a != null) {
                try {
                    p<T> pVar = (p) this.f4791a.newInstance(cls, Integer.valueOf(i), Long.valueOf(j));
                    q.f4789a.b("Loaded custom ResourceLeakDetector: {}", this.f4791a.getDeclaringClass().getName());
                    return pVar;
                } catch (Throwable th) {
                    q.f4789a.c("Could not load custom resource leak detector provided: {} with the given resource: {}", this.f4791a.getDeclaringClass().getName(), cls, th);
                }
            }
            p<T> pVar2 = new p<>((Class<?>) cls, i, j);
            q.f4789a.b("Loaded default ResourceLeakDetector: {}", pVar2);
            return pVar2;
        }
    }
}
