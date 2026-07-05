package com.google.gson.b.a;

import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes.dex */
public final class a<E> extends t<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final u f3907a = new u() { // from class: com.google.gson.b.a.a.1
        @Override // com.google.gson.u
        public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
            Type typeB = aVar.b();
            if (!(typeB instanceof GenericArrayType) && (!(typeB instanceof Class) || !((Class) typeB).isArray())) {
                return null;
            }
            Type typeG = com.google.gson.b.b.g(typeB);
            return new a(fVar, fVar.a((com.google.gson.c.a) com.google.gson.c.a.a(typeG)), com.google.gson.b.b.e(typeG));
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final Class<E> f3908b;
    private final t<E> c;

    public a(com.google.gson.f fVar, t<E> tVar, Class<E> cls) {
        this.c = new m(fVar, tVar, cls);
        this.f3908b = cls;
    }

    @Override // com.google.gson.t
    public Object read(com.google.gson.stream.a aVar) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (aVar.f() == com.google.gson.stream.b.NULL) {
            aVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.c.read(aVar));
        }
        aVar.b();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f3908b, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.t
    public void write(com.google.gson.stream.c cVar, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            cVar.f();
            return;
        }
        cVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.write(cVar, Array.get(obj, i));
        }
        cVar.c();
    }
}
