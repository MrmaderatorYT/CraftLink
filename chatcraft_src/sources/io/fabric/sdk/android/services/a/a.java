package io.fabric.sdk.android.services.a;

import android.content.Context;

/* compiled from: AbstractValueCache.java */
/* loaded from: classes.dex */
public abstract class a<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final c<T> f4198a;

    protected abstract T a(Context context);

    protected abstract void a(Context context, T t);

    public a(c<T> cVar) {
        this.f4198a = cVar;
    }

    @Override // io.fabric.sdk.android.services.a.c
    public final synchronized T a(Context context, d<T> dVar) {
        T tA;
        tA = a(context);
        if (tA == null) {
            tA = this.f4198a != null ? this.f4198a.a(context, dVar) : dVar.a(context);
            b(context, tA);
        }
        return tA;
    }

    private void b(Context context, T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        a(context, (Context) t);
    }
}
