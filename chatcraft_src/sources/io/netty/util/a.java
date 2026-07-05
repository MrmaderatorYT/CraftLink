package io.netty.util;

import io.netty.util.a;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: AbstractConstant.java */
/* loaded from: classes.dex */
public abstract class a<T extends a<T>> implements g<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicLong f4622a = new AtomicLong();

    /* renamed from: b, reason: collision with root package name */
    private final int f4623b;
    private final String c;
    private final long d = f4622a.getAndIncrement();

    protected a(int i, String str) {
        this.f4623b = i;
        this.c = str;
    }

    public final String a() {
        return this.c;
    }

    public final int b() {
        return this.f4623b;
    }

    public final String toString() {
        return a();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(T t) {
        if (this == t) {
            return 0;
        }
        int iHashCode = hashCode() - t.hashCode();
        if (iHashCode != 0) {
            return iHashCode;
        }
        if (this.d < t.d) {
            return -1;
        }
        if (this.d > t.d) {
            return 1;
        }
        throw new Error("failed to compare two different constants");
    }
}
