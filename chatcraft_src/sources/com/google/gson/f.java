package com.google.gson;

import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson.java */
/* loaded from: classes.dex */
public final class f {
    private static final com.google.gson.c.a<?> r = com.google.gson.c.a.b(Object.class);

    /* renamed from: a, reason: collision with root package name */
    final List<u> f4023a;

    /* renamed from: b, reason: collision with root package name */
    final com.google.gson.b.d f4024b;
    final e c;
    final Map<Type, h<?>> d;
    final boolean e;
    final boolean f;
    final boolean g;
    final boolean h;
    final boolean i;
    final boolean j;
    final boolean k;
    final String l;
    final int m;
    final int n;
    final s o;
    final List<u> p;
    final List<u> q;
    private final ThreadLocal<Map<com.google.gson.c.a<?>, a<?>>> s;
    private final Map<com.google.gson.c.a<?>, t<?>> t;
    private final com.google.gson.b.c u;
    private final com.google.gson.b.a.d v;

    public f() {
        this(com.google.gson.b.d.f3992a, d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, s.DEFAULT, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    f(com.google.gson.b.d dVar, e eVar, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, s sVar, String str, int i, int i2, List<u> list, List<u> list2, List<u> list3) {
        this.s = new ThreadLocal<>();
        this.t = new ConcurrentHashMap();
        this.f4024b = dVar;
        this.c = eVar;
        this.d = map;
        this.u = new com.google.gson.b.c(map);
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = z4;
        this.i = z5;
        this.j = z6;
        this.k = z7;
        this.o = sVar;
        this.l = str;
        this.m = i;
        this.n = i2;
        this.p = list;
        this.q = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.b.a.n.Y);
        arrayList.add(com.google.gson.b.a.h.f3923a);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(com.google.gson.b.a.n.D);
        arrayList.add(com.google.gson.b.a.n.m);
        arrayList.add(com.google.gson.b.a.n.g);
        arrayList.add(com.google.gson.b.a.n.i);
        arrayList.add(com.google.gson.b.a.n.k);
        t<Number> tVarA = a(sVar);
        arrayList.add(com.google.gson.b.a.n.a(Long.TYPE, Long.class, tVarA));
        arrayList.add(com.google.gson.b.a.n.a(Double.TYPE, Double.class, a(z7)));
        arrayList.add(com.google.gson.b.a.n.a(Float.TYPE, Float.class, b(z7)));
        arrayList.add(com.google.gson.b.a.n.x);
        arrayList.add(com.google.gson.b.a.n.o);
        arrayList.add(com.google.gson.b.a.n.q);
        arrayList.add(com.google.gson.b.a.n.a(AtomicLong.class, a(tVarA)));
        arrayList.add(com.google.gson.b.a.n.a(AtomicLongArray.class, b(tVarA)));
        arrayList.add(com.google.gson.b.a.n.s);
        arrayList.add(com.google.gson.b.a.n.z);
        arrayList.add(com.google.gson.b.a.n.F);
        arrayList.add(com.google.gson.b.a.n.H);
        arrayList.add(com.google.gson.b.a.n.a(BigDecimal.class, com.google.gson.b.a.n.B));
        arrayList.add(com.google.gson.b.a.n.a(BigInteger.class, com.google.gson.b.a.n.C));
        arrayList.add(com.google.gson.b.a.n.J);
        arrayList.add(com.google.gson.b.a.n.L);
        arrayList.add(com.google.gson.b.a.n.P);
        arrayList.add(com.google.gson.b.a.n.R);
        arrayList.add(com.google.gson.b.a.n.W);
        arrayList.add(com.google.gson.b.a.n.N);
        arrayList.add(com.google.gson.b.a.n.d);
        arrayList.add(com.google.gson.b.a.c.f3913a);
        arrayList.add(com.google.gson.b.a.n.U);
        arrayList.add(com.google.gson.b.a.k.f3934a);
        arrayList.add(com.google.gson.b.a.j.f3932a);
        arrayList.add(com.google.gson.b.a.n.S);
        arrayList.add(com.google.gson.b.a.a.f3907a);
        arrayList.add(com.google.gson.b.a.n.f3944b);
        arrayList.add(new com.google.gson.b.a.b(this.u));
        arrayList.add(new com.google.gson.b.a.g(this.u, z2));
        this.v = new com.google.gson.b.a.d(this.u);
        arrayList.add(this.v);
        arrayList.add(com.google.gson.b.a.n.Z);
        arrayList.add(new com.google.gson.b.a.i(this.u, eVar, dVar, this.v));
        this.f4023a = Collections.unmodifiableList(arrayList);
    }

    private t<Number> a(boolean z) {
        if (z) {
            return com.google.gson.b.a.n.v;
        }
        return new t<Number>() { // from class: com.google.gson.f.1
            @Override // com.google.gson.t
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Double read(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.f() == com.google.gson.stream.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Double.valueOf(aVar.k());
            }

            @Override // com.google.gson.t
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                } else {
                    f.a(number.doubleValue());
                    cVar.a(number);
                }
            }
        };
    }

    private t<Number> b(boolean z) {
        if (z) {
            return com.google.gson.b.a.n.u;
        }
        return new t<Number>() { // from class: com.google.gson.f.2
            @Override // com.google.gson.t
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float read(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.f() == com.google.gson.stream.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Float.valueOf((float) aVar.k());
            }

            @Override // com.google.gson.t
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                } else {
                    f.a(number.floatValue());
                    cVar.a(number);
                }
            }
        };
    }

    static void a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static t<Number> a(s sVar) {
        if (sVar == s.DEFAULT) {
            return com.google.gson.b.a.n.t;
        }
        return new t<Number>() { // from class: com.google.gson.f.3
            @Override // com.google.gson.t
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Number read(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.f() == com.google.gson.stream.b.NULL) {
                    aVar.j();
                    return null;
                }
                return Long.valueOf(aVar.l());
            }

            @Override // com.google.gson.t
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void write(com.google.gson.stream.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.f();
                } else {
                    cVar.b(number.toString());
                }
            }
        };
    }

    private static t<AtomicLong> a(final t<Number> tVar) {
        return new t<AtomicLong>() { // from class: com.google.gson.f.4
            @Override // com.google.gson.t
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void write(com.google.gson.stream.c cVar, AtomicLong atomicLong) {
                tVar.write(cVar, Long.valueOf(atomicLong.get()));
            }

            @Override // com.google.gson.t
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AtomicLong read(com.google.gson.stream.a aVar) {
                return new AtomicLong(((Number) tVar.read(aVar)).longValue());
            }
        }.nullSafe();
    }

    private static t<AtomicLongArray> b(final t<Number> tVar) {
        return new t<AtomicLongArray>() { // from class: com.google.gson.f.5
            @Override // com.google.gson.t
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void write(com.google.gson.stream.c cVar, AtomicLongArray atomicLongArray) throws IOException {
                cVar.b();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    tVar.write(cVar, Long.valueOf(atomicLongArray.get(i)));
                }
                cVar.c();
            }

            @Override // com.google.gson.t
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AtomicLongArray read(com.google.gson.stream.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(Long.valueOf(((Number) tVar.read(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.nullSafe();
    }

    public <T> t<T> a(com.google.gson.c.a<T> aVar) {
        t<T> tVar = (t) this.t.get(aVar == null ? r : aVar);
        if (tVar != null) {
            return tVar;
        }
        Map<com.google.gson.c.a<?>, a<?>> map = this.s.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.s.set(map);
            z = true;
        }
        a<?> aVar2 = map.get(aVar);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            a<?> aVar3 = new a<>();
            map.put(aVar, aVar3);
            Iterator<u> it = this.f4023a.iterator();
            while (it.hasNext()) {
                t<T> tVarA = it.next().a(this, aVar);
                if (tVarA != null) {
                    aVar3.a(tVarA);
                    this.t.put(aVar, tVarA);
                    return tVarA;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z) {
                this.s.remove();
            }
        }
    }

    public <T> t<T> a(u uVar, com.google.gson.c.a<T> aVar) {
        if (!this.f4023a.contains(uVar)) {
            uVar = this.v;
        }
        boolean z = false;
        for (u uVar2 : this.f4023a) {
            if (z) {
                t<T> tVarA = uVar2.a(this, aVar);
                if (tVarA != null) {
                    return tVarA;
                }
            } else if (uVar2 == uVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public <T> t<T> a(Class<T> cls) {
        return a((com.google.gson.c.a) com.google.gson.c.a.b(cls));
    }

    public String a(Object obj) {
        if (obj == null) {
            return a((l) m.f4033a);
        }
        return a(obj, obj.getClass());
    }

    public String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void a(Object obj, Type type, Appendable appendable) {
        try {
            a(obj, type, a(com.google.gson.b.l.a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public void a(Object obj, Type type, com.google.gson.stream.c cVar) {
        t tVarA = a((com.google.gson.c.a) com.google.gson.c.a.a(type));
        boolean zG = cVar.g();
        cVar.b(true);
        boolean zH = cVar.h();
        cVar.c(this.h);
        boolean zI = cVar.i();
        cVar.d(this.e);
        try {
            try {
                tVarA.write(cVar, obj);
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e2.getMessage(), e2);
            }
        } finally {
            cVar.b(zG);
            cVar.c(zH);
            cVar.d(zI);
        }
    }

    public String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        a(lVar, stringWriter);
        return stringWriter.toString();
    }

    public void a(l lVar, Appendable appendable) {
        try {
            a(lVar, a(com.google.gson.b.l.a(appendable)));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public com.google.gson.stream.c a(Writer writer) throws IOException {
        if (this.g) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.c cVar = new com.google.gson.stream.c(writer);
        if (this.i) {
            cVar.c("  ");
        }
        cVar.d(this.e);
        return cVar;
    }

    public com.google.gson.stream.a a(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.a(this.j);
        return aVar;
    }

    public void a(l lVar, com.google.gson.stream.c cVar) {
        boolean zG = cVar.g();
        cVar.b(true);
        boolean zH = cVar.h();
        cVar.c(this.h);
        boolean zI = cVar.i();
        cVar.d(this.e);
        try {
            try {
                com.google.gson.b.l.a(lVar, cVar);
            } catch (IOException e) {
                throw new JsonIOException(e);
            } catch (AssertionError e2) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e2.getMessage(), e2);
            }
        } finally {
            cVar.b(zG);
            cVar.c(zH);
            cVar.d(zI);
        }
    }

    public <T> T a(String str, Class<T> cls) {
        return (T) com.google.gson.b.k.a((Class) cls).cast(a(str, (Type) cls));
    }

    public <T> T a(String str, Type type) {
        if (str == null) {
            return null;
        }
        return (T) a((Reader) new StringReader(str), type);
    }

    public <T> T a(Reader reader, Type type) {
        com.google.gson.stream.a aVarA = a(reader);
        T t = (T) a(aVarA, type);
        a(t, aVarA);
        return t;
    }

    private static void a(Object obj, com.google.gson.stream.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() == com.google.gson.stream.b.END_DOCUMENT) {
                } else {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e) {
                throw new JsonSyntaxException(e);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
    }

    public <T> T a(com.google.gson.stream.a aVar, Type type) {
        boolean zQ = aVar.q();
        boolean z = true;
        aVar.a(true);
        try {
            try {
                try {
                    aVar.f();
                    z = false;
                    T t = a((com.google.gson.c.a) com.google.gson.c.a.a(type)).read(aVar);
                    aVar.a(zQ);
                    return t;
                } catch (IOException e) {
                    throw new JsonSyntaxException(e);
                } catch (IllegalStateException e2) {
                    throw new JsonSyntaxException(e2);
                }
            } catch (EOFException e3) {
                if (!z) {
                    throw new JsonSyntaxException(e3);
                }
                aVar.a(zQ);
                return null;
            } catch (AssertionError e4) {
                throw new AssertionError("AssertionError (GSON 2.8.5): " + e4.getMessage(), e4);
            }
        } catch (Throwable th) {
            aVar.a(zQ);
            throw th;
        }
    }

    public <T> T a(l lVar, Class<T> cls) {
        return (T) com.google.gson.b.k.a((Class) cls).cast(a(lVar, (Type) cls));
    }

    public <T> T a(l lVar, Type type) {
        if (lVar == null) {
            return null;
        }
        return (T) a((com.google.gson.stream.a) new com.google.gson.b.a.e(lVar), type);
    }

    /* compiled from: Gson.java */
    static class a<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private t<T> f4029a;

        a() {
        }

        public void a(t<T> tVar) {
            if (this.f4029a != null) {
                throw new AssertionError();
            }
            this.f4029a = tVar;
        }

        @Override // com.google.gson.t
        public T read(com.google.gson.stream.a aVar) {
            if (this.f4029a == null) {
                throw new IllegalStateException();
            }
            return this.f4029a.read(aVar);
        }

        @Override // com.google.gson.t
        public void write(com.google.gson.stream.c cVar, T t) {
            if (this.f4029a == null) {
                throw new IllegalStateException();
            }
            this.f4029a.write(cVar, t);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.e + ",factories:" + this.f4023a + ",instanceCreators:" + this.u + "}";
    }
}
