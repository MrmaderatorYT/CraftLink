package io.fabric.sdk.android;

import android.content.Context;
import io.fabric.sdk.android.services.b.r;
import java.io.File;
import java.util.Collection;

/* compiled from: Kit.java */
/* loaded from: classes.dex */
public abstract class h<Result> implements Comparable<h> {
    c e;
    Context g;
    f<Result> h;
    r i;
    g<Result> f = new g<>(this);
    final io.fabric.sdk.android.services.concurrency.d j = (io.fabric.sdk.android.services.concurrency.d) getClass().getAnnotation(io.fabric.sdk.android.services.concurrency.d.class);

    public abstract String a();

    protected void a(Result result) {
    }

    public abstract String b();

    protected void b(Result result) {
    }

    protected boolean b_() {
        return true;
    }

    protected abstract Result f();

    void a(Context context, c cVar, f<Result> fVar, r rVar) {
        this.e = cVar;
        this.g = new d(context, b(), t());
        this.h = fVar;
        this.i = rVar;
    }

    final void p() {
        this.f.a(this.e.e(), (Object[]) new Void[]{(Void) null});
    }

    protected r q() {
        return this.i;
    }

    public Context r() {
        return this.g;
    }

    public c s() {
        return this.e;
    }

    public String t() {
        return ".Fabric" + File.separator + b();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        if (b(hVar)) {
            return 1;
        }
        if (hVar.b((h) this)) {
            return -1;
        }
        if (!u() || hVar.u()) {
            return (u() || !hVar.u()) ? 0 : -1;
        }
        return 1;
    }

    boolean b(h hVar) {
        if (u()) {
            for (Class<?> cls : this.j.a()) {
                if (cls.isAssignableFrom(hVar.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean u() {
        return this.j != null;
    }

    protected Collection<io.fabric.sdk.android.services.concurrency.l> v() {
        return this.f.c();
    }
}
