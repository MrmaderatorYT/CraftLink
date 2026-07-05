package com.google.gson.b.a;

import com.google.gson.r;
import com.google.gson.t;
import com.google.gson.u;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class d implements u {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.b.c f3915a;

    public d(com.google.gson.b.c cVar) {
        this.f3915a = cVar;
    }

    @Override // com.google.gson.u
    public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
        com.google.gson.a.b bVar = (com.google.gson.a.b) aVar.a().getAnnotation(com.google.gson.a.b.class);
        if (bVar == null) {
            return null;
        }
        return (t<T>) a(this.f3915a, fVar, aVar, bVar);
    }

    t<?> a(com.google.gson.b.c cVar, com.google.gson.f fVar, com.google.gson.c.a<?> aVar, com.google.gson.a.b bVar) {
        t<?> lVar;
        Object objA = cVar.a(com.google.gson.c.a.b(bVar.a())).a();
        if (objA instanceof t) {
            lVar = (t) objA;
        } else if (objA instanceof u) {
            lVar = ((u) objA).a(fVar, aVar);
        } else {
            boolean z = objA instanceof r;
            if (z || (objA instanceof com.google.gson.k)) {
                lVar = new l<>(z ? (r) objA : null, objA instanceof com.google.gson.k ? (com.google.gson.k) objA : null, fVar, aVar, null);
            } else {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
        }
        return (lVar == null || !bVar.b()) ? lVar : lVar.nullSafe();
    }
}
