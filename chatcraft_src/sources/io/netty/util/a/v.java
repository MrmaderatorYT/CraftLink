package io.netty.util.a;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import sun.misc.Unsafe;

/* compiled from: UnsafeAtomicIntegerFieldUpdater.java */
/* loaded from: classes.dex */
final class v<T> extends AtomicIntegerFieldUpdater<T> {

    /* renamed from: a, reason: collision with root package name */
    private final long f4707a;

    /* renamed from: b, reason: collision with root package name */
    private final Unsafe f4708b;

    v(Unsafe unsafe, Class<? super T> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (!Modifier.isVolatile(declaredField.getModifiers())) {
            throw new IllegalArgumentException("Must be volatile");
        }
        this.f4708b = unsafe;
        this.f4707a = unsafe.objectFieldOffset(declaredField);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public boolean compareAndSet(T t, int i, int i2) {
        return this.f4708b.compareAndSwapInt(t, this.f4707a, i, i2);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public boolean weakCompareAndSet(T t, int i, int i2) {
        return this.f4708b.compareAndSwapInt(t, this.f4707a, i, i2);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public void set(T t, int i) {
        this.f4708b.putIntVolatile(t, this.f4707a, i);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public void lazySet(T t, int i) {
        this.f4708b.putOrderedInt(t, this.f4707a, i);
    }

    @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
    public int get(T t) {
        return this.f4708b.getIntVolatile(t, this.f4707a);
    }
}
