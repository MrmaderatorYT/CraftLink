package com.google.gson.b.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class i implements u {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.gson.b.c f3926a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.gson.e f3927b;
    private final com.google.gson.b.d c;
    private final d d;
    private final com.google.gson.b.b.b e = com.google.gson.b.b.b.a();

    public i(com.google.gson.b.c cVar, com.google.gson.e eVar, com.google.gson.b.d dVar, d dVar2) {
        this.f3926a = cVar;
        this.f3927b = eVar;
        this.c = dVar;
        this.d = dVar2;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.c);
    }

    static boolean a(Field field, boolean z, com.google.gson.b.d dVar) {
        return (dVar.a(field.getType(), z) || dVar.a(field, z)) ? false : true;
    }

    private List<String> a(Field field) {
        com.google.gson.a.c cVar = (com.google.gson.a.c) field.getAnnotation(com.google.gson.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f3927b.a(field));
        }
        String strA = cVar.a();
        String[] strArrB = cVar.b();
        if (strArrB.length == 0) {
            return Collections.singletonList(strA);
        }
        ArrayList arrayList = new ArrayList(strArrB.length + 1);
        arrayList.add(strA);
        for (String str : strArrB) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.u
    public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) {
        Class<? super T> clsA = aVar.a();
        if (Object.class.isAssignableFrom(clsA)) {
            return new a(this.f3926a.a(aVar), a(fVar, (com.google.gson.c.a<?>) aVar, (Class<?>) clsA));
        }
        return null;
    }

    private b a(final com.google.gson.f fVar, final Field field, String str, final com.google.gson.c.a<?> aVar, boolean z, boolean z2) {
        final boolean zA = com.google.gson.b.k.a((Type) aVar.a());
        com.google.gson.a.b bVar = (com.google.gson.a.b) field.getAnnotation(com.google.gson.a.b.class);
        t<?> tVarA = bVar != null ? this.d.a(this.f3926a, fVar, aVar, bVar) : null;
        final boolean z3 = tVarA != null;
        if (tVarA == null) {
            tVarA = fVar.a((com.google.gson.c.a) aVar);
        }
        final t<?> tVar = tVarA;
        return new b(str, z, z2) { // from class: com.google.gson.b.a.i.1
            @Override // com.google.gson.b.a.i.b
            void a(com.google.gson.stream.c cVar, Object obj) throws IllegalAccessException, IllegalArgumentException {
                (z3 ? tVar : new m(fVar, tVar, aVar.b())).write(cVar, field.get(obj));
            }

            @Override // com.google.gson.b.a.i.b
            void a(com.google.gson.stream.a aVar2, Object obj) throws IllegalAccessException, IllegalArgumentException {
                Object obj2 = tVar.read(aVar2);
                if (obj2 == null && zA) {
                    return;
                }
                field.set(obj, obj2);
            }

            @Override // com.google.gson.b.a.i.b
            public boolean a(Object obj) {
                return this.i && field.get(obj) != obj;
            }
        };
    }

    private Map<String, b> a(com.google.gson.f fVar, com.google.gson.c.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type typeB = aVar.b();
        com.google.gson.c.a<?> aVarA = aVar;
        Class<?> clsA = cls;
        while (clsA != Object.class) {
            Field[] declaredFields = clsA.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean zA = a(field, true);
                boolean zA2 = a(field, z);
                if (zA || zA2) {
                    this.e.a(field);
                    Type typeA = com.google.gson.b.b.a(aVarA.b(), clsA, field.getGenericType());
                    List<String> listA = a(field);
                    int size = listA.size();
                    b bVar = null;
                    int i2 = 0;
                    while (i2 < size) {
                        String str = listA.get(i2);
                        boolean z2 = i2 != 0 ? false : zA;
                        b bVar2 = bVar;
                        int i3 = i2;
                        int i4 = size;
                        List<String> list = listA;
                        Field field2 = field;
                        bVar = bVar2 == null ? (b) linkedHashMap.put(str, a(fVar, field, str, com.google.gson.c.a.a(typeA), z2, zA2)) : bVar2;
                        i2 = i3 + 1;
                        zA = z2;
                        listA = list;
                        size = i4;
                        field = field2;
                    }
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        throw new IllegalArgumentException(typeB + " declares multiple JSON fields named " + bVar3.h);
                    }
                }
                i++;
                z = false;
            }
            aVarA = com.google.gson.c.a.a(com.google.gson.b.b.a(aVarA.b(), clsA, clsA.getGenericSuperclass()));
            clsA = aVarA.a();
        }
        return linkedHashMap;
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    static abstract class b {
        final String h;
        final boolean i;
        final boolean j;

        abstract void a(com.google.gson.stream.a aVar, Object obj);

        abstract void a(com.google.gson.stream.c cVar, Object obj);

        abstract boolean a(Object obj);

        protected b(String str, boolean z, boolean z2) {
            this.h = str;
            this.i = z;
            this.j = z2;
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    public static final class a<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final com.google.gson.b.i<T> f3930a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, b> f3931b;

        a(com.google.gson.b.i<T> iVar, Map<String, b> map) {
            this.f3930a = iVar;
            this.f3931b = map;
        }

        @Override // com.google.gson.t
        public T read(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.f() == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            T tA = this.f3930a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.f3931b.get(aVar.g());
                    if (bVar == null || !bVar.j) {
                        aVar.n();
                    } else {
                        bVar.a(aVar, tA);
                    }
                }
                aVar.d();
                return tA;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.t
        public void write(com.google.gson.stream.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.f();
                return;
            }
            cVar.d();
            try {
                for (b bVar : this.f3931b.values()) {
                    if (bVar.a(t)) {
                        cVar.a(bVar.h);
                        bVar.a(cVar, t);
                    }
                }
                cVar.e();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
