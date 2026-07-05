package com.google.gson.b.a;

import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ObjectTypeAdapter.java */
/* loaded from: classes.dex */
public final class h extends t<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final u f3923a = new u() { // from class: com.google.gson.b.a.h.1
        @Override // com.google.gson.u
        public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
            if (aVar.a() == Object.class) {
                return new h(fVar);
            }
            return null;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final com.google.gson.f f3924b;

    h(com.google.gson.f fVar) {
        this.f3924b = fVar;
    }

    @Override // com.google.gson.t
    public Object read(com.google.gson.stream.a aVar) throws IOException {
        switch (aVar.f()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(read(aVar));
                }
                aVar.b();
                return arrayList;
            case BEGIN_OBJECT:
                com.google.gson.b.h hVar = new com.google.gson.b.h();
                aVar.c();
                while (aVar.e()) {
                    hVar.put(aVar.g(), read(aVar));
                }
                aVar.d();
                return hVar;
            case STRING:
                return aVar.h();
            case NUMBER:
                return Double.valueOf(aVar.k());
            case BOOLEAN:
                return Boolean.valueOf(aVar.i());
            case NULL:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.t
    public void write(com.google.gson.stream.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        t tVarA = this.f3924b.a((Class) obj.getClass());
        if (tVarA instanceof h) {
            cVar.d();
            cVar.e();
        } else {
            tVarA.write(cVar, obj);
        }
    }
}
