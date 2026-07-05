package com.google.gson.b.a;

import com.google.gson.JsonSyntaxException;
import com.google.gson.p;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class g implements u {

    /* renamed from: a, reason: collision with root package name */
    final boolean f3919a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.gson.b.c f3920b;

    public g(com.google.gson.b.c cVar, boolean z) {
        this.f3920b = cVar;
        this.f3919a = z;
    }

    @Override // com.google.gson.u
    public <T> t<T> a(com.google.gson.f fVar, com.google.gson.c.a<T> aVar) throws NoSuchMethodException, SecurityException {
        Type typeB = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] typeArrB = com.google.gson.b.b.b(typeB, com.google.gson.b.b.e(typeB));
        return new a(fVar, typeArrB[0], a(fVar, typeArrB[0]), typeArrB[1], fVar.a((com.google.gson.c.a) com.google.gson.c.a.a(typeArrB[1])), this.f3920b.a(aVar));
    }

    private t<?> a(com.google.gson.f fVar, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return n.f;
        }
        return fVar.a((com.google.gson.c.a) com.google.gson.c.a.a(type));
    }

    /* compiled from: MapTypeAdapterFactory.java */
    private final class a<K, V> extends t<Map<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        private final t<K> f3922b;
        private final t<V> c;
        private final com.google.gson.b.i<? extends Map<K, V>> d;

        public a(com.google.gson.f fVar, Type type, t<K> tVar, Type type2, t<V> tVar2, com.google.gson.b.i<? extends Map<K, V>> iVar) {
            this.f3922b = new m(fVar, tVar, type);
            this.c = new m(fVar, tVar2, type2);
            this.d = iVar;
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<K, V> read(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.b bVarF = aVar.f();
            if (bVarF == com.google.gson.stream.b.NULL) {
                aVar.j();
                return null;
            }
            Map<K, V> mapA = this.d.a();
            if (bVarF == com.google.gson.stream.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K k = this.f3922b.read(aVar);
                    if (mapA.put(k, this.c.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + k);
                    }
                    aVar.b();
                }
                aVar.b();
            } else {
                aVar.c();
                while (aVar.e()) {
                    com.google.gson.b.f.f3997a.a(aVar);
                    K k2 = this.f3922b.read(aVar);
                    if (mapA.put(k2, this.c.read(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + k2);
                    }
                }
                aVar.d();
            }
            return mapA;
        }

        @Override // com.google.gson.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void write(com.google.gson.stream.c cVar, Map<K, V> map) throws IOException {
            if (map == null) {
                cVar.f();
                return;
            }
            if (!g.this.f3919a) {
                cVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.a(String.valueOf(entry.getKey()));
                    this.c.write(cVar, entry.getValue());
                }
                cVar.e();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                com.google.gson.l jsonTree = this.f3922b.toJsonTree(entry2.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(entry2.getValue());
                z |= jsonTree.h() || jsonTree.i();
            }
            if (z) {
                cVar.b();
                int size = arrayList.size();
                while (i < size) {
                    cVar.b();
                    com.google.gson.b.l.a((com.google.gson.l) arrayList.get(i), cVar);
                    this.c.write(cVar, arrayList2.get(i));
                    cVar.c();
                    i++;
                }
                cVar.c();
                return;
            }
            cVar.d();
            int size2 = arrayList.size();
            while (i < size2) {
                cVar.a(a((com.google.gson.l) arrayList.get(i)));
                this.c.write(cVar, arrayList2.get(i));
                i++;
            }
            cVar.e();
        }

        private String a(com.google.gson.l lVar) {
            if (lVar.j()) {
                p pVarN = lVar.n();
                if (pVarN.p()) {
                    return String.valueOf(pVarN.b());
                }
                if (pVarN.a()) {
                    return Boolean.toString(pVarN.g());
                }
                if (pVarN.q()) {
                    return pVarN.c();
                }
                throw new AssertionError();
            }
            if (lVar.k()) {
                return "null";
            }
            throw new AssertionError();
        }
    }
}
