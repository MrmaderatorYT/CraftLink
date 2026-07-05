package com.google.gson.b.a;

import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: CollectionTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class b implements u {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.b.c f3910a;

    public b(com.google.gson.b.c cVar) {
        this.f3910a = cVar;
    }

    @Override // com.google.gson.u
    public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
        Type typeB = aVar.b();
        Class<? super T> clsA = aVar.a();
        if (!Collection.class.isAssignableFrom(clsA)) {
            return null;
        }
        Type typeA = com.google.gson.b.b.a(typeB, (Class<?>) clsA);
        return new a(fVar, typeA, fVar.a((com.google.gson.c.a) com.google.gson.c.a.a(typeA)), this.f3910a.a(aVar));
    }

    /* compiled from: CollectionTypeAdapterFactory.java */
    private static final class a<E> extends t<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        private final t<E> f3911a;

        /* renamed from: b, reason: collision with root package name */
        private final com.google.gson.b.i<? extends Collection<E>> f3912b;

        public a(com.google.gson.f fVar, Type type, t<E> tVar, com.google.gson.b.i<? extends Collection<E>> iVar) {
            this.f3911a = new m(fVar, tVar, type);
            this.f3912b = iVar;
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<E> read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            Collection<E> collectionA = this.f3912b.a();
            aVar.a();
            while (aVar.e()) {
                collectionA.add(this.f3911a.read(aVar));
            }
            aVar.b();
            return collectionA;
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.f();
                return;
            }
            cVar.b();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f3911a.write(cVar, it.next());
            }
            cVar.c();
        }
    }
}
