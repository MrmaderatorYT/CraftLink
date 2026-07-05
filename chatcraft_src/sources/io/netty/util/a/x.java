package io.netty.util.a;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* compiled from: UnsafeAtomicReferenceFieldUpdater.java */
/* loaded from: classes.dex */
final class x<U, M> extends AtomicReferenceFieldUpdater<U, M> {

    /* renamed from: a, reason: collision with root package name */
    private final long f4711a;

    /* renamed from: b, reason: collision with root package name */
    private final Unsafe f4712b;

    x(Unsafe unsafe, Class<? super U> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (!Modifier.isVolatile(declaredField.getModifiers())) {
            throw new IllegalArgumentException("Must be volatile");
        }
        this.f4712b = unsafe;
        this.f4711a = unsafe.objectFieldOffset(declaredField);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public boolean compareAndSet(U u, M m, M m2) {
        return this.f4712b.compareAndSwapObject(u, this.f4711a, m, m2);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public boolean weakCompareAndSet(U u, M m, M m2) {
        return this.f4712b.compareAndSwapObject(u, this.f4711a, m, m2);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public void set(U u, M m) {
        this.f4712b.putObjectVolatile(u, this.f4711a, m);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public void lazySet(U u, M m) {
        this.f4712b.putOrderedObject(u, this.f4711a, m);
    }

    @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
    public M get(U u) {
        return (M) this.f4712b.getObjectVolatile(u, this.f4711a);
    }
}
