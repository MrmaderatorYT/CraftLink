package io.netty.util;

/* compiled from: Signal.java */
/* loaded from: classes.dex */
public final class s extends Error implements g<s> {

    /* renamed from: a, reason: collision with root package name */
    private static final h<s> f4793a = new h<s>() { // from class: io.netty.util.s.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s b(int i, String str) {
            return new s(i, str);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final a f4794b;

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public Throwable initCause(Throwable th) {
        return this;
    }

    public static s a(Class<?> cls, String str) {
        return (s) f4793a.a(cls, str);
    }

    private s(int i, String str) {
        this.f4794b = new a(i, str);
    }

    public String a() {
        return this.f4794b.a();
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(s sVar) {
        if (this == sVar) {
            return 0;
        }
        return this.f4794b.compareTo(sVar.f4794b);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return a();
    }

    /* compiled from: Signal.java */
    private static final class a extends io.netty.util.a<a> {
        a(int i, String str) {
            super(i, str);
        }
    }
}
