package com.google.gson.b.a;

import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;

/* compiled from: TreeTypeAdapter.java */
/* loaded from: classes.dex */
public final class l<T> extends t<T> {

    /* renamed from: a, reason: collision with root package name */
    final com.google.gson.f f3936a;

    /* renamed from: b, reason: collision with root package name */
    private final r<T> f3937b;
    private final com.google.gson.k<T> c;
    private final com.google.gson.c.a<T> d;
    private final u e;
    private final l<T>.a f = new a();
    private t<T> g;

    public l(r<T> rVar, com.google.gson.k<T> kVar, com.google.gson.f fVar, com.google.gson.c.a<T> aVar, u uVar) {
        this.f3937b = rVar;
        this.c = kVar;
        this.f3936a = fVar;
        this.d = aVar;
        this.e = uVar;
    }

    @Override // com.google.gson.t
    public T read(com.google.gson.stream.a aVar) {
        if (this.c == null) {
            return a().read(aVar);
        }
        com.google.gson.l lVarA = com.google.gson.b.l.a(aVar);
        if (lVarA.k()) {
            return null;
        }
        return this.c.a(lVarA, this.d.b(), this.f);
    }

    @Override // com.google.gson.t
    public void write(com.google.gson.stream.c cVar, T t) throws IOException {
        if (this.f3937b == null) {
            a().write(cVar, t);
        } else if (t == null) {
            cVar.f();
        } else {
            com.google.gson.b.l.a(this.f3937b.a(t, this.d.b(), this.f), cVar);
        }
    }

    private t<T> a() {
        t<T> tVar = this.g;
        if (tVar != null) {
            return tVar;
        }
        t<T> tVarA = this.f3936a.a(this.e, this.d);
        this.g = tVarA;
        return tVarA;
    }

    public static u a(com.google.gson.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.b() == aVar.a(), null);
    }

    /* compiled from: TreeTypeAdapter.java */
    private static final class b implements u {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.gson.c.a<?> f3939a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f3940b;
        private final Class<?> c;
        private final r<?> d;
        private final com.google.gson.k<?> e;

        b(Object obj, com.google.gson.c.a<?> aVar, boolean z, Class<?> cls) {
            this.d = obj instanceof r ? (r) obj : null;
            this.e = obj instanceof com.google.gson.k ? (com.google.gson.k) obj : null;
            com.google.gson.b.a.a((this.d == null && this.e == null) ? false : true);
            this.f3939a = aVar;
            this.f3940b = z;
            this.c = cls;
        }

        @Override // com.google.gson.u
        public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
            boolean zIsAssignableFrom;
            if (this.f3939a != null) {
                zIsAssignableFrom = this.f3939a.equals(aVar) || (this.f3940b && this.f3939a.b() == aVar.a());
            } else {
                zIsAssignableFrom = this.c.isAssignableFrom(aVar.a());
            }
            if (zIsAssignableFrom) {
                return new l(this.d, this.e, fVar, aVar, this);
            }
            return null;
        }
    }

    /* compiled from: TreeTypeAdapter.java */
    private final class a implements com.google.gson.j, q {
        private a() {
        }
    }
}
