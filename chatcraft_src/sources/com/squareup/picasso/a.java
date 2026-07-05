package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.t;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: Action.java */
/* loaded from: classes.dex */
abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    final t f4099a;

    /* renamed from: b, reason: collision with root package name */
    final w f4100b;
    final WeakReference<T> c;
    final boolean d;
    final int e;
    final int f;
    final int g;
    final Drawable h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    abstract void a(Bitmap bitmap, t.d dVar);

    abstract void a(Exception exc);

    /* compiled from: Action.java */
    /* renamed from: com.squareup.picasso.a$a, reason: collision with other inner class name */
    static class C0093a<M> extends WeakReference<M> {

        /* renamed from: a, reason: collision with root package name */
        final a f4101a;

        C0093a(a aVar, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f4101a = aVar;
        }
    }

    a(t tVar, T t, w wVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.f4099a = tVar;
        this.f4100b = wVar;
        this.c = t == null ? null : new C0093a(this, t, tVar.i);
        this.e = i;
        this.f = i2;
        this.d = z;
        this.g = i3;
        this.h = drawable;
        this.i = str;
        this.j = obj == null ? this : obj;
    }

    void a() {
        this.l = true;
    }

    w b() {
        return this.f4100b;
    }

    T c() {
        if (this.c == null) {
            return null;
        }
        return this.c.get();
    }

    String d() {
        return this.i;
    }

    boolean e() {
        return this.l;
    }

    boolean f() {
        return this.k;
    }

    int g() {
        return this.e;
    }

    int h() {
        return this.f;
    }

    t i() {
        return this.f4099a;
    }

    t.e j() {
        return this.f4100b.t;
    }

    Object k() {
        return this.j;
    }
}
