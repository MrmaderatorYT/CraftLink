package io.netty.channel;

import io.netty.channel.d;

/* compiled from: ReflectiveChannelFactory.java */
/* loaded from: classes.dex */
public class as<T extends d> implements g<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<? extends T> f4485a;

    public as(Class<? extends T> cls) {
        if (cls == null) {
            throw new NullPointerException("clazz");
        }
        this.f4485a = cls;
    }

    @Override // io.netty.a.e
    public T newChannel() {
        try {
            return this.f4485a.newInstance();
        } catch (Throwable th) {
            throw new ChannelException("Unable to create Channel from class " + this.f4485a, th);
        }
    }

    public String toString() {
        return io.netty.util.a.p.a((Class<?>) this.f4485a) + ".class";
    }
}
