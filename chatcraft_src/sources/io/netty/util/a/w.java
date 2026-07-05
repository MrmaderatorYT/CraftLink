package io.netty.util.a;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import sun.misc.Unsafe;

/* compiled from: UnsafeAtomicLongFieldUpdater.java */
/* loaded from: classes.dex */
final class w<T> extends AtomicLongFieldUpdater<T> {

    /* renamed from: a, reason: collision with root package name */
    private final long f4709a;

    /* renamed from: b, reason: collision with root package name */
    private final Unsafe f4710b;

    w(Unsafe unsafe, Class<? super T> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (!Modifier.isVolatile(declaredField.getModifiers())) {
            throw new IllegalArgumentException("Must be volatile");
        }
        this.f4710b = unsafe;
        this.f4709a = unsafe.objectFieldOffset(declaredField);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public boolean compareAndSet(T t, long j, long j2) {
        return this.f4710b.compareAndSwapLong(t, this.f4709a, j, j2);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public boolean weakCompareAndSet(T t, long j, long j2) {
        return this.f4710b.compareAndSwapLong(t, this.f4709a, j, j2);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public void set(T t, long j) {
        this.f4710b.putLongVolatile(t, this.f4709a, j);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public void lazySet(T t, long j) {
        this.f4710b.putOrderedLong(t, this.f4709a, j);
    }

    @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
    public long get(T t) {
        return this.f4710b.getLongVolatile(t, this.f4709a);
    }
}
