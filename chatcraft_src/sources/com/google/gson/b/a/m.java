package com.google.gson.b.a;

import com.google.gson.b.a.i;
import com.google.gson.t;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes.dex */
final class m<T> extends t<T> {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.f f3941a;

    /* renamed from: b, reason: collision with root package name */
    private final t<T> f3942b;
    private final Type c;

    m(com.google.gson.f fVar, t<T> tVar, Type type) {
        this.f3941a = fVar;
        this.f3942b = tVar;
        this.c = type;
    }

    @Override // com.google.gson.t
    public T read(com.google.gson.stream.a aVar) {
        return this.f3942b.read(aVar);
    }

    @Override // com.google.gson.t
    public void write(com.google.gson.stream.c cVar, T t) {
        t<T> tVarA = this.f3942b;
        Type typeA = a(this.c, t);
        if (typeA != this.c) {
            tVarA = this.f3941a.a((com.google.gson.c.a) com.google.gson.c.a.a(typeA));
            if ((tVarA instanceof i.a) && !(this.f3942b instanceof i.a)) {
                tVarA = this.f3942b;
            }
        }
        tVarA.write(cVar, t);
    }

    private Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }
}
