package io.netty.util.concurrent;

import io.netty.util.concurrent.k;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultEventExecutorChooserFactory.java */
/* loaded from: classes.dex */
public final class f implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final f f4728a = new f();

    private static boolean a(int i) {
        return ((-i) & i) == i;
    }

    private f() {
    }

    @Override // io.netty.util.concurrent.k
    public k.a a(j[] jVarArr) {
        if (a(jVarArr.length)) {
            return new b(jVarArr);
        }
        return new a(jVarArr);
    }

    /* compiled from: DefaultEventExecutorChooserFactory.java */
    private static final class b implements k.a {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4731a = new AtomicInteger();

        /* renamed from: b, reason: collision with root package name */
        private final j[] f4732b;

        b(j[] jVarArr) {
            this.f4732b = jVarArr;
        }

        @Override // io.netty.util.concurrent.k.a
        public j a() {
            return this.f4732b[this.f4731a.getAndIncrement() & (this.f4732b.length - 1)];
        }
    }

    /* compiled from: DefaultEventExecutorChooserFactory.java */
    private static final class a implements k.a {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4729a = new AtomicInteger();

        /* renamed from: b, reason: collision with root package name */
        private final j[] f4730b;

        a(j[] jVarArr) {
            this.f4730b = jVarArr;
        }

        @Override // io.netty.util.concurrent.k.a
        public j a() {
            return this.f4730b[Math.abs(this.f4729a.getAndIncrement() % this.f4730b.length)];
        }
    }
}
