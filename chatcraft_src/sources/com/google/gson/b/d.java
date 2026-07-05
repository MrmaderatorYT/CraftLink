package com.google.gson.b;

import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: Excluder.java */
/* loaded from: classes.dex */
public final class d implements u, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public static final d f3992a = new d();
    private boolean e;

    /* renamed from: b, reason: collision with root package name */
    private double f3993b = -1.0d;
    private int c = 136;
    private boolean d = true;
    private List<com.google.gson.b> f = Collections.emptyList();
    private List<com.google.gson.b> g = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.u
    public <T> t<T> a(final com.google.gson.f fVar, final com.google.gson.c.a<T> aVar) {
        Class<? super T> clsA = aVar.a();
        boolean zA = a(clsA);
        final boolean z = zA || b(clsA, true);
        final boolean z2 = zA || b(clsA, false);
        if (z || z2) {
            return new t<T>() { // from class: com.google.gson.b.d.1
                private t<T> f;

                @Override // com.google.gson.t
                public T read(com.google.gson.stream.a aVar2) throws IOException {
                    if (z2) {
                        aVar2.n();
                        return null;
                    }
                    return a().read(aVar2);
                }

                @Override // com.google.gson.t
                public void write(com.google.gson.stream.c cVar, T t) throws IOException {
                    if (z) {
                        cVar.f();
                    } else {
                        a().write(cVar, t);
                    }
                }

                private t<T> a() {
                    t<T> tVar = this.f;
                    if (tVar != null) {
                        return tVar;
                    }
                    t<T> tVarA = fVar.a(d.this, aVar);
                    this.f = tVarA;
                    return tVarA;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f3993b != -1.0d && !a((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.e && ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) == null || (!z ? aVar.b() : aVar.a()))) {
            return true;
        }
        if ((!this.d && c(field.getType())) || b(field.getType())) {
            return true;
        }
        List<com.google.gson.b> list = z ? this.f : this.g;
        if (list.isEmpty()) {
            return false;
        }
        com.google.gson.c cVar = new com.google.gson.c(field);
        Iterator<com.google.gson.b> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(cVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Class<?> cls) {
        if (this.f3993b == -1.0d || a((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return (!this.d && c(cls)) || b(cls);
        }
        return true;
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    private boolean b(Class<?> cls, boolean z) {
        Iterator<com.google.gson.b> it = (z ? this.f : this.g).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean b(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean a(com.google.gson.a.d dVar, com.google.gson.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.google.gson.a.d dVar) {
        return dVar == null || dVar.a() <= this.f3993b;
    }

    private boolean a(com.google.gson.a.e eVar) {
        return eVar == null || eVar.a() > this.f3993b;
    }
}
