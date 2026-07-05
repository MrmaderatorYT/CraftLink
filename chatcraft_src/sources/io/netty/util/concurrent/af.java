package io.netty.util.concurrent;

/* compiled from: SucceededFuture.java */
/* loaded from: classes.dex */
public final class af<V> extends e<V> {

    /* renamed from: a, reason: collision with root package name */
    private final V f4721a;

    @Override // io.netty.util.concurrent.p
    public Throwable k() {
        return null;
    }

    @Override // io.netty.util.concurrent.p
    public boolean l() {
        return true;
    }

    public af(j jVar, V v) {
        super(jVar);
        this.f4721a = v;
    }

    @Override // io.netty.util.concurrent.p
    public V j() {
        return this.f4721a;
    }
}
