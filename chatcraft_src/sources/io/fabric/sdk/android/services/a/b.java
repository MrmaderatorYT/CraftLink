package io.fabric.sdk.android.services.a;

import android.content.Context;

/* compiled from: MemoryValueCache.java */
/* loaded from: classes.dex */
public class b<T> extends a<T> {

    /* renamed from: a, reason: collision with root package name */
    private T f4199a;

    public b() {
        this(null);
    }

    public b(c<T> cVar) {
        super(cVar);
    }

    @Override // io.fabric.sdk.android.services.a.a
    protected T a(Context context) {
        return this.f4199a;
    }

    @Override // io.fabric.sdk.android.services.a.a
    protected void a(Context context, T t) {
        this.f4199a = t;
    }
}
