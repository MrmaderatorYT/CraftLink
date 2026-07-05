package io.netty.util.a.a;

import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

/* compiled from: ConcurrentHashMapV8.java */
/* loaded from: classes.dex */
public class a<K, V> implements Serializable, ConcurrentMap<K, V> {
    private static final Unsafe o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u;
    private static final long v;
    private static final int w;

    /* renamed from: b, reason: collision with root package name */
    volatile transient j<K, V>[] f4627b;
    private volatile transient j<K, V>[] e;
    private volatile transient long f;
    private volatile transient int g;
    private volatile transient int h;
    private volatile transient int i;
    private volatile transient int j;
    private volatile transient c[] k;
    private transient h<K, V> l;
    private transient p<K, V> m;
    private transient e<K, V> n;

    /* renamed from: a, reason: collision with root package name */
    static final int f4626a = Runtime.getRuntime().availableProcessors();
    private static final ObjectStreamField[] d = {new ObjectStreamField("segments", k[].class), new ObjectStreamField("segmentMask", Integer.TYPE), new ObjectStreamField("segmentShift", Integer.TYPE)};
    static final AtomicInteger c = new AtomicInteger();

    /* compiled from: ConcurrentHashMapV8.java */
    static class k<K, V> extends ReentrantLock implements Serializable {
    }

    static final int a(int i2) {
        return (i2 ^ (i2 >>> 16)) & Integer.MAX_VALUE;
    }

    private static final int b(int i2) {
        int i3 = i2 - 1;
        int i4 = i3 | (i3 >>> 1);
        int i5 = i4 | (i4 >>> 2);
        int i6 = i5 | (i5 >>> 4);
        int i7 = i6 | (i6 >>> 8);
        int i8 = i7 | (i7 >>> 16);
        if (i8 < 0) {
            return 1;
        }
        if (i8 >= 1073741824) {
            return 1073741824;
        }
        return 1 + i8;
    }

    static {
        try {
            o = f();
            p = o.objectFieldOffset(a.class.getDeclaredField("sizeCtl"));
            q = o.objectFieldOffset(a.class.getDeclaredField("transferIndex"));
            r = o.objectFieldOffset(a.class.getDeclaredField("transferOrigin"));
            s = o.objectFieldOffset(a.class.getDeclaredField("baseCount"));
            t = o.objectFieldOffset(a.class.getDeclaredField("cellsBusy"));
            u = o.objectFieldOffset(c.class.getDeclaredField("value"));
            v = o.arrayBaseOffset(j[].class);
            int iArrayIndexScale = o.arrayIndexScale(j[].class);
            if (((iArrayIndexScale - 1) & iArrayIndexScale) != 0) {
                throw new Error("data type scale not a power of two");
            }
            w = 31 - Integer.numberOfLeadingZeros(iArrayIndexScale);
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static class j<K, V> implements Map.Entry<K, V> {

        /* renamed from: b, reason: collision with root package name */
        final int f4636b;
        final K c;
        volatile V d;
        volatile j<K, V> e;

        j(int i, K k, V v, j<K, V> jVar) {
            this.f4636b = i;
            this.c = k;
            this.d = v;
            this.e = jVar;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.c;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.d;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.c.hashCode() ^ this.d.hashCode();
        }

        public final String toString() {
            return this.c + "=" + this.d;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            V v;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == this.c || key.equals(this.c)) && (value == (v = this.d) || value.equals(v));
        }

        j<K, V> a(int i, Object obj) {
            K k;
            if (obj == null) {
                return null;
            }
            j<K, V> jVar = this;
            do {
                if (jVar.f4636b == i && ((k = jVar.c) == obj || (k != null && obj.equals(k)))) {
                    return jVar;
                }
                jVar = jVar.e;
            } while (jVar != null);
            return null;
        }
    }

    static Class<?> a(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls == String.class) {
            return cls;
        }
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null) {
            return null;
        }
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    return cls;
                }
            }
        }
        return null;
    }

    static int a(Class<?> cls, Object obj, Object obj2) {
        if (obj2 == null || obj2.getClass() != cls) {
            return 0;
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    static final <K, V> j<K, V> a(j<K, V>[] jVarArr, int i2) {
        return (j) o.getObjectVolatile(jVarArr, (i2 << w) + v);
    }

    static final <K, V> boolean a(j<K, V>[] jVarArr, int i2, j<K, V> jVar, j<K, V> jVar2) {
        return o.compareAndSwapObject(jVarArr, v + (i2 << w), jVar, jVar2);
    }

    static final <K, V> void a(j<K, V>[] jVarArr, int i2, j<K, V> jVar) {
        o.putObjectVolatile(jVarArr, (i2 << w) + v, jVar);
    }

    @Override // java.util.Map
    public int size() {
        long jC = c();
        if (jC < 0) {
            return 0;
        }
        if (jC > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jC;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return c() <= 0;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        int length;
        j<K, V> jVarA;
        K k2;
        int iA = a(obj.hashCode());
        j<K, V>[] jVarArr = this.f4627b;
        if (jVarArr != null && (length = jVarArr.length) > 0 && (jVarA = a(jVarArr, (length - 1) & iA)) != null) {
            int i2 = jVarA.f4636b;
            if (i2 == iA) {
                K k3 = jVarA.c;
                if (k3 == obj || (k3 != null && obj.equals(k3))) {
                    return jVarA.d;
                }
            } else if (i2 < 0) {
                j<K, V> jVarA2 = jVarA.a(iA, obj);
                if (jVarA2 != null) {
                    return jVarA2.d;
                }
                return null;
            }
            while (true) {
                jVarA = jVarA.e;
                if (jVarA == null) {
                    break;
                }
                if (jVarA.f4636b == iA && ((k2 = jVarA.c) == obj || (k2 != null && obj.equals(k2)))) {
                    break;
                }
            }
            return jVarA.d;
        }
        return null;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        j<K, V>[] jVarArr = this.f4627b;
        if (jVarArr != null) {
            l lVar = new l(jVarArr, jVarArr.length, 0, jVarArr.length);
            while (true) {
                j<K, V> jVarB = lVar.b();
                if (jVarB == null) {
                    break;
                }
                V v2 = jVarB.d;
                if (v2 == obj) {
                    return true;
                }
                if (v2 != null && obj.equals(v2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map
    public V put(K k2, V v2) {
        return a((a<K, V>) k2, (K) v2, false);
    }

    final V a(K k2, V v2, boolean z) {
        V v3;
        K k3;
        if (k2 == null || v2 == null) {
            throw new NullPointerException();
        }
        int iA = a(k2.hashCode());
        int i2 = 0;
        j<K, V>[] jVarArrE = this.f4627b;
        while (true) {
            if (jVarArrE != null) {
                int length = jVarArrE.length;
                if (length != 0) {
                    int i3 = (length - 1) & iA;
                    j<K, V> jVarA = a(jVarArrE, i3);
                    if (jVarA == null) {
                        if (a(jVarArrE, i3, (j) null, new j(iA, k2, v2, null))) {
                            break;
                        }
                    } else {
                        int i4 = jVarA.f4636b;
                        if (i4 == -1) {
                            jVarArrE = a(jVarArrE, jVarA);
                        } else {
                            synchronized (jVarA) {
                                if (a(jVarArrE, i3) == jVarA) {
                                    if (i4 >= 0) {
                                        j<K, V> jVar = jVarA;
                                        int i5 = 1;
                                        while (true) {
                                            if (jVar.f4636b == iA && ((k3 = jVar.c) == k2 || (k3 != null && k2.equals(k3)))) {
                                                break;
                                            }
                                            j<K, V> jVar2 = jVar.e;
                                            if (jVar2 == null) {
                                                jVar.e = new j<>(iA, k2, v2, null);
                                                v3 = null;
                                                break;
                                            }
                                            i5++;
                                            jVar = jVar2;
                                        }
                                        v3 = jVar.d;
                                        if (!z) {
                                            jVar.d = v2;
                                        }
                                        i2 = i5;
                                    } else if (jVarA instanceof m) {
                                        i2 = 2;
                                        n<K, V> nVarA = ((m) jVarA).a(iA, k2, v2);
                                        if (nVarA != null) {
                                            v3 = nVarA.d;
                                            if (!z) {
                                                nVarA.d = v2;
                                            }
                                        }
                                    }
                                }
                                v3 = null;
                            }
                            if (i2 != 0) {
                                if (i2 >= 8) {
                                    b(jVarArrE, i3);
                                }
                                if (v3 != null) {
                                    return v3;
                                }
                            }
                        }
                    }
                }
            }
            jVarArrE = e();
        }
        a(1L, i2);
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            a((a<K, V>) entry.getKey(), (K) entry.getValue(), false);
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return a(obj, (Object) null, (Object) null);
    }

    final V a(Object obj, V v2, Object obj2) {
        int length;
        int i2;
        j<K, V> jVarA;
        boolean z;
        V v3;
        n<K, V> nVarA;
        K k2;
        int iA = a(obj.hashCode());
        j<K, V>[] jVarArrA = this.f4627b;
        while (true) {
            if (jVarArrA == null || (length = jVarArrA.length) == 0 || (jVarA = a(jVarArrA, (i2 = (length - 1) & iA))) == null) {
                break;
            }
            int i3 = jVarA.f4636b;
            if (i3 == -1) {
                jVarArrA = a(jVarArrA, jVarA);
            } else {
                synchronized (jVarA) {
                    z = true;
                    if (a(jVarArrA, i2) == jVarA) {
                        if (i3 >= 0) {
                            j<K, V> jVar = null;
                            j<K, V> jVar2 = jVarA;
                            while (true) {
                                if (jVar2.f4636b == iA && ((k2 = jVar2.c) == obj || (k2 != null && obj.equals(k2)))) {
                                    break;
                                }
                                j<K, V> jVar3 = jVar2.e;
                                if (jVar3 == null) {
                                    break;
                                }
                                jVar = jVar2;
                                jVar2 = jVar3;
                            }
                            v3 = jVar2.d;
                            if (obj2 != null && obj2 != v3 && (v3 == null || !obj2.equals(v3))) {
                                v3 = null;
                            } else if (v2 != null) {
                                jVar2.d = v2;
                            } else if (jVar != null) {
                                jVar.e = jVar2.e;
                            } else {
                                a(jVarArrA, i2, jVar2.e);
                            }
                        } else if (jVarA instanceof m) {
                            m mVar = (m) jVarA;
                            n<K, V> nVar = mVar.f4637a;
                            if (nVar != null && (nVarA = nVar.a(iA, obj, null)) != null) {
                                v3 = nVarA.d;
                                if (obj2 == null || obj2 == v3 || (v3 != null && obj2.equals(v3))) {
                                    if (v2 != null) {
                                        nVarA.d = v2;
                                    } else if (mVar.a(nVarA)) {
                                        a(jVarArrA, i2, a((j) mVar.f));
                                    }
                                }
                            }
                            v3 = null;
                        }
                    }
                    v3 = null;
                    z = false;
                }
                if (z) {
                    if (v3 != null) {
                        if (v2 == null) {
                            a(-1L, -1);
                        }
                        return v3;
                    }
                }
            }
        }
        return null;
    }

    @Override // java.util.Map
    public void clear() {
        j<K, V> jVarA;
        j<K, V> jVar;
        j<K, V>[] jVarArrA = this.f4627b;
        long j2 = 0;
        loop0: while (true) {
            int i2 = 0;
            while (jVarArrA != null && i2 < jVarArrA.length) {
                jVarA = a(jVarArrA, i2);
                if (jVarA == null) {
                    i2++;
                } else {
                    int i3 = jVarA.f4636b;
                    if (i3 == -1) {
                        break;
                    }
                    synchronized (jVarA) {
                        if (a(jVarArrA, i2) == jVarA) {
                            if (i3 >= 0) {
                                jVar = jVarA;
                            } else {
                                jVar = jVarA instanceof m ? ((m) jVarA).f : null;
                            }
                            while (jVar != null) {
                                j2--;
                                jVar = jVar.e;
                            }
                            a(jVarArrA, i2, (j) null);
                            i2++;
                        }
                    }
                }
            }
            jVarArrA = a(jVarArrA, jVarA);
        }
        if (j2 != 0) {
            a(j2, -1);
        }
    }

    @Override // java.util.Map
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public h<K, V> keySet() {
        h<K, V> hVar = this.l;
        if (hVar != null) {
            return hVar;
        }
        h<K, V> hVar2 = new h<>(this, null);
        this.l = hVar2;
        return hVar2;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        p<K, V> pVar = this.m;
        if (pVar != null) {
            return pVar;
        }
        p<K, V> pVar2 = new p<>(this);
        this.m = pVar2;
        return pVar2;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        e<K, V> eVar = this.n;
        if (eVar != null) {
            return eVar;
        }
        e<K, V> eVar2 = new e<>(this);
        this.n = eVar2;
        return eVar2;
    }

    @Override // java.util.Map
    public int hashCode() {
        j<K, V>[] jVarArr = this.f4627b;
        int iHashCode = 0;
        if (jVarArr != null) {
            l lVar = new l(jVarArr, jVarArr.length, 0, jVarArr.length);
            while (true) {
                j<K, V> jVarB = lVar.b();
                if (jVarB == null) {
                    break;
                }
                iHashCode += jVarB.d.hashCode() ^ jVarB.c.hashCode();
            }
        }
        return iHashCode;
    }

    public String toString() {
        j<K, V>[] jVarArr = this.f4627b;
        int length = jVarArr == null ? 0 : jVarArr.length;
        l lVar = new l(jVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        j<K, V> jVarB = lVar.b();
        if (jVarB != null) {
            while (true) {
                Object obj = jVarB.c;
                Object obj2 = jVarB.d;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                jVarB = lVar.b();
                if (jVarB == null) {
                    break;
                }
                sb.append(',');
                sb.append(' ');
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        V value;
        V v2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        j<K, V>[] jVarArr = this.f4627b;
        int length = jVarArr == null ? 0 : jVarArr.length;
        l lVar = new l(jVarArr, length, 0, length);
        while (true) {
            j<K, V> jVarB = lVar.b();
            if (jVarB != null) {
                V v3 = jVarB.d;
                Object obj2 = map.get(jVarB.c);
                if (obj2 == null || (obj2 != v3 && !obj2.equals(v3))) {
                    break;
                }
            } else {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (v2 = get(key)) == null || (value != v2 && !value.equals(v2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V putIfAbsent(K k2, V v2) {
        return a((a<K, V>) k2, (K) v2, true);
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean remove(Object obj, Object obj2) {
        if (obj != null) {
            return (obj2 == null || a(obj, (Object) null, obj2) == null) ? false : true;
        }
        throw new NullPointerException();
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public boolean replace(K k2, V v2, V v3) {
        if (k2 == null || v2 == null || v3 == null) {
            throw new NullPointerException();
        }
        return a((Object) k2, (K) v3, (Object) v2) != null;
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V replace(K k2, V v2) {
        if (k2 == null || v2 == null) {
            throw new NullPointerException();
        }
        return a((Object) k2, (K) v2, (Object) null);
    }

    @Override // java.util.concurrent.ConcurrentMap, java.util.Map
    public V getOrDefault(Object obj, V v2) {
        V v3 = get(obj);
        return v3 == null ? v2 : v3;
    }

    public long b() {
        long jC = c();
        if (jC < 0) {
            return 0L;
        }
        return jC;
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static final class f<K, V> extends j<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final j<K, V>[] f4632a;

        f(j<K, V>[] jVarArr) {
            super(-1, null, null, null);
            this.f4632a = jVarArr;
        }

        @Override // io.netty.util.a.a.a.j
        j<K, V> a(int i, Object obj) {
            int length;
            j<K, V> jVarA;
            K k;
            j<K, V>[] jVarArr = this.f4632a;
            while (obj != null && jVarArr != null && (length = jVarArr.length) != 0 && (jVarA = a.a(jVarArr, (length - 1) & i)) != null) {
                do {
                    int i2 = jVarA.f4636b;
                    if (i2 == i && ((k = jVarA.c) == obj || (k != null && obj.equals(k)))) {
                        return jVarA;
                    }
                    if (i2 < 0) {
                        if (jVarA instanceof f) {
                            jVarArr = ((f) jVarA).f4632a;
                        } else {
                            return jVarA.a(i, obj);
                        }
                    } else {
                        jVarA = jVarA.e;
                    }
                } while (jVarA != null);
                return null;
            }
            return null;
        }
    }

    private final j<K, V>[] e() {
        while (true) {
            j<K, V>[] jVarArr = this.f4627b;
            if (jVarArr != null && jVarArr.length != 0) {
                return jVarArr;
            }
            int i2 = this.g;
            if (i2 < 0) {
                Thread.yield();
            } else if (o.compareAndSwapInt(this, p, i2, -1)) {
                try {
                    j<K, V>[] jVarArr2 = this.f4627b;
                    if (jVarArr2 == null || jVarArr2.length == 0) {
                        int i3 = i2 > 0 ? i2 : 16;
                        j<K, V>[] jVarArr3 = new j[i3];
                        this.f4627b = jVarArr3;
                        i2 = i3 - (i3 >>> 2);
                        jVarArr2 = jVarArr3;
                    }
                    this.g = i2;
                    return jVarArr2;
                } catch (Throwable th) {
                    this.g = i2;
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(long r20, int r22) {
        /*
            r19 = this;
            r8 = r19
            r9 = r22
            io.netty.util.a.a.a$c[] r10 = r8.k
            if (r10 != 0) goto L19
            sun.misc.Unsafe r0 = io.netty.util.a.a.a.o
            long r2 = io.netty.util.a.a.a.s
            long r4 = r8.f
            long r11 = r4 + r20
            r1 = r19
            r6 = r11
            boolean r0 = r0.compareAndSwapLong(r1, r2, r4, r6)
            if (r0 != 0) goto L49
        L19:
            io.netty.util.a.d r1 = io.netty.util.a.d.b()
            io.netty.util.a.c r4 = r1.j()
            r0 = 1
            if (r4 == 0) goto L94
            if (r10 == 0) goto L94
            int r2 = r10.length
            int r2 = r2 - r0
            if (r2 < 0) goto L94
            int r3 = r4.f4660a
            r2 = r2 & r3
            r12 = r10[r2]
            if (r12 == 0) goto L94
            sun.misc.Unsafe r11 = io.netty.util.a.a.a.o
            long r13 = io.netty.util.a.a.a.u
            long r2 = r12.f4631a
            long r17 = r2 + r20
            r15 = r2
            boolean r2 = r11.compareAndSwapLong(r12, r13, r15, r17)
            if (r2 != 0) goto L42
            r5 = r2
            goto L95
        L42:
            if (r9 > r0) goto L45
            return
        L45:
            long r11 = r19.c()
        L49:
            if (r9 < 0) goto L93
        L4b:
            int r4 = r8.g
            long r0 = (long) r4
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 < 0) goto L93
            io.netty.util.a.a.a$j<K, V>[] r6 = r8.f4627b
            if (r6 == 0) goto L93
            int r0 = r6.length
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 >= r1) goto L93
            if (r4 >= 0) goto L7d
            r0 = -1
            if (r4 == r0) goto L93
            int r0 = r8.h
            int r1 = r8.i
            if (r0 <= r1) goto L93
            io.netty.util.a.a.a$j<K, V>[] r7 = r8.e
            if (r7 != 0) goto L6b
            goto L93
        L6b:
            sun.misc.Unsafe r0 = io.netty.util.a.a.a.o
            long r2 = io.netty.util.a.a.a.p
            int r5 = r4 + (-1)
            r1 = r19
            boolean r0 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r0 == 0) goto L8e
            r8.a(r6, r7)
            goto L8e
        L7d:
            sun.misc.Unsafe r0 = io.netty.util.a.a.a.o
            long r2 = io.netty.util.a.a.a.p
            r5 = -2
            r1 = r19
            boolean r0 = r0.compareAndSwapInt(r1, r2, r4, r5)
            if (r0 == 0) goto L8e
            r0 = 0
            r8.a(r6, r0)
        L8e:
            long r11 = r19.c()
            goto L4b
        L93:
            return
        L94:
            r5 = 1
        L95:
            r0 = r19
            r2 = r20
            r0.a(r1, r2, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.a.a.a.a(long, int):void");
    }

    final j<K, V>[] a(j<K, V>[] jVarArr, j<K, V> jVar) {
        j<K, V>[] jVarArr2;
        int i2;
        if ((jVar instanceof f) && (jVarArr2 = ((f) jVar).f4632a) != null) {
            if (jVarArr2 == this.e && jVarArr == this.f4627b && this.h > this.i && (i2 = this.g) < -1 && o.compareAndSwapInt(this, p, i2, i2 - 1)) {
                a(jVarArr, jVarArr2);
            }
            return jVarArr2;
        }
        return this.f4627b;
    }

    private final void c(int i2) {
        int length;
        int iB = i2 >= 536870912 ? 1073741824 : b(i2 + (i2 >>> 1) + 1);
        while (true) {
            int i3 = this.g;
            if (i3 < 0) {
                return;
            }
            j<K, V>[] jVarArr = this.f4627b;
            if (jVarArr == null || (length = jVarArr.length) == 0) {
                int i4 = i3 > iB ? i3 : iB;
                if (o.compareAndSwapInt(this, p, i3, -1)) {
                    try {
                        if (this.f4627b == jVarArr) {
                            this.f4627b = new j[i4];
                            i3 = i4 - (i4 >>> 2);
                        }
                    } finally {
                        this.g = i3;
                    }
                } else {
                    continue;
                }
            } else {
                if (iB <= i3 || length >= 1073741824) {
                    return;
                }
                if (jVarArr == this.f4627b && o.compareAndSwapInt(this, p, i3, -2)) {
                    a(jVarArr, (j[]) null);
                }
            }
        }
    }

    private final void a(j<K, V>[] jVarArr, j<K, V>[] jVarArr2) {
        j<K, V>[] jVarArr3;
        int i2;
        int i3;
        f fVar;
        a<K, V> aVar;
        Unsafe unsafe;
        long j2;
        int i4;
        int i5;
        int i6;
        int i7;
        j mVar;
        j mVar2;
        j<K, V> jVar;
        j<K, V> jVar2;
        a<K, V> aVar2 = this;
        j<K, V>[] jVarArr4 = jVarArr;
        int length = jVarArr4.length;
        int i8 = f4626a > 1 ? (length >>> 3) / f4626a : length;
        int i9 = i8 < 16 ? 16 : i8;
        if (jVarArr2 == null) {
            try {
                j<K, V>[] jVarArr5 = new j[length << 1];
                aVar2.e = jVarArr5;
                aVar2.i = length;
                aVar2.h = length;
                f fVar2 = new f(jVarArr4);
                int i10 = length;
                while (i10 > 0) {
                    int i11 = i10 > i9 ? i10 - i9 : 0;
                    for (int i12 = i11; i12 < i10; i12++) {
                        jVarArr5[i12] = fVar2;
                    }
                    for (int i13 = length + i11; i13 < length + i10; i13++) {
                        jVarArr5[i13] = fVar2;
                    }
                    o.putOrderedInt(aVar2, r, i11);
                    i10 = i11;
                }
                jVarArr3 = jVarArr5;
            } catch (Throwable unused) {
                aVar2.g = Integer.MAX_VALUE;
                return;
            }
        } else {
            jVarArr3 = jVarArr2;
        }
        int length2 = jVarArr3.length;
        f fVar3 = new f(jVarArr3);
        int i14 = -1;
        int i15 = 0;
        int i16 = 0;
        boolean z = true;
        boolean z2 = false;
        while (true) {
            if (z) {
                int i17 = i15 - 1;
                if (i17 >= i16 || z2) {
                    i15 = i17;
                    i16 = i16;
                    z = false;
                } else {
                    int i18 = aVar2.h;
                    if (i18 <= aVar2.i) {
                        i15 = -1;
                    } else {
                        Unsafe unsafe2 = o;
                        long j3 = q;
                        int i19 = i18 > i9 ? i18 - i9 : 0;
                        int i20 = i16;
                        if (unsafe2.compareAndSwapInt(this, j3, i18, i19)) {
                            i15 = i18 - 1;
                            i16 = i19;
                        } else {
                            i15 = i17;
                            i16 = i20;
                        }
                    }
                    z = false;
                }
            } else {
                int i21 = i16;
                j<K, V> jVar3 = null;
                if (i15 < 0 || i15 >= length || (i7 = i15 + length) >= length2) {
                    i2 = i9;
                    i3 = length2;
                    fVar = fVar3;
                    if (z2) {
                        this.e = null;
                        this.f4627b = jVarArr3;
                        this.g = (length << 1) - (length >>> 1);
                        return;
                    }
                    aVar = this;
                    do {
                        unsafe = o;
                        j2 = p;
                        i4 = aVar.g;
                        i5 = i4 + 1;
                    } while (!unsafe.compareAndSwapInt(this, j2, i4, i5));
                    if (i5 != -1) {
                        return;
                    }
                    i6 = length;
                    z = true;
                    z2 = true;
                } else {
                    j<K, V> jVarA = a(jVarArr4, i15);
                    if (jVarA == null) {
                        if (a(jVarArr4, i15, (j) null, fVar3)) {
                            a(jVarArr3, i15, (j) null);
                            a(jVarArr3, i7, (j) null);
                            i6 = i15;
                            aVar = aVar2;
                            i2 = i9;
                            i3 = length2;
                            fVar = fVar3;
                            z = true;
                        } else {
                            i6 = i15;
                            aVar = aVar2;
                            i2 = i9;
                            i3 = length2;
                            fVar = fVar3;
                        }
                    } else {
                        int i22 = jVarA.f4636b;
                        if (i22 != i14) {
                            synchronized (jVarA) {
                                if (a(jVarArr4, i15) == jVarA) {
                                    if (i22 >= 0) {
                                        int i23 = i22 & length;
                                        j<K, V> jVar4 = jVarA;
                                        for (j<K, V> jVar5 = jVarA.e; jVar5 != null; jVar5 = jVar5.e) {
                                            int i24 = jVar5.f4636b & length;
                                            if (i24 != i23) {
                                                jVar4 = jVar5;
                                                i23 = i24;
                                            }
                                        }
                                        if (i23 == 0) {
                                            jVar = null;
                                            jVar3 = jVar4;
                                        } else {
                                            jVar = jVar4;
                                        }
                                        j<K, V> jVar6 = jVar;
                                        j<K, V> jVar7 = jVar3;
                                        j<K, V> jVar8 = jVarA;
                                        while (jVar8 != jVar4) {
                                            int i25 = jVar8.f4636b;
                                            K k2 = jVar8.c;
                                            int i26 = i9;
                                            V v2 = jVar8.d;
                                            if ((i25 & length) == 0) {
                                                jVar2 = jVar4;
                                                jVar7 = new j<>(i25, k2, v2, jVar7);
                                            } else {
                                                jVar2 = jVar4;
                                                jVar6 = new j<>(i25, k2, v2, jVar6);
                                            }
                                            jVar8 = jVar8.e;
                                            i9 = i26;
                                            jVar4 = jVar2;
                                        }
                                        i2 = i9;
                                        a(jVarArr3, i15, jVar7);
                                        a(jVarArr3, i7, jVar6);
                                        a(jVarArr4, i15, fVar3);
                                        i3 = length2;
                                        fVar = fVar3;
                                    } else {
                                        i2 = i9;
                                        if (jVarA instanceof m) {
                                            m mVar3 = (m) jVarA;
                                            j jVar9 = mVar3.f;
                                            n<K, V> nVar = null;
                                            n<K, V> nVar2 = null;
                                            n<K, V> nVar3 = null;
                                            int i27 = 0;
                                            n<K, V> nVar4 = null;
                                            int i28 = 0;
                                            while (jVar9 != null) {
                                                int i29 = length2;
                                                int i30 = jVar9.f4636b;
                                                f fVar4 = fVar3;
                                                n<K, V> nVar5 = new n<>(i30, jVar9.c, jVar9.d, null, null);
                                                if ((i30 & length) == 0) {
                                                    nVar5.h = nVar3;
                                                    if (nVar3 == null) {
                                                        nVar = nVar5;
                                                    } else {
                                                        nVar3.e = nVar5;
                                                    }
                                                    i28++;
                                                    nVar3 = nVar5;
                                                } else {
                                                    nVar5.h = nVar4;
                                                    if (nVar4 == null) {
                                                        nVar2 = nVar5;
                                                    } else {
                                                        nVar4.e = nVar5;
                                                    }
                                                    i27++;
                                                    nVar4 = nVar5;
                                                }
                                                jVar9 = jVar9.e;
                                                length2 = i29;
                                                fVar3 = fVar4;
                                            }
                                            i3 = length2;
                                            f fVar5 = fVar3;
                                            if (i28 <= 6) {
                                                mVar = a((j) nVar);
                                            } else {
                                                mVar = i27 != 0 ? new m(nVar) : mVar3;
                                            }
                                            if (i27 <= 6) {
                                                mVar2 = a((j) nVar2);
                                            } else {
                                                mVar2 = i28 != 0 ? new m(nVar2) : mVar3;
                                            }
                                            a(jVarArr3, i15, mVar);
                                            a(jVarArr3, i7, mVar2);
                                            fVar = fVar5;
                                            jVarArr4 = jVarArr;
                                            a(jVarArr4, i15, fVar);
                                        }
                                    }
                                    z = true;
                                } else {
                                    i2 = i9;
                                }
                                i3 = length2;
                                fVar = fVar3;
                            }
                            i6 = i15;
                            aVar = this;
                        }
                        i6 = i15;
                        aVar = aVar2;
                        i2 = i9;
                        i3 = length2;
                        fVar = fVar3;
                        z = true;
                    }
                }
                i15 = i6;
                fVar3 = fVar;
                aVar2 = aVar;
                i16 = i21;
                i9 = i2;
                length2 = i3;
                i14 = -1;
            }
        }
    }

    private final void b(j<K, V>[] jVarArr, int i2) {
        int i3;
        if (jVarArr != null) {
            n<K, V> nVar = null;
            if (jVarArr.length < 64) {
                if (jVarArr == this.f4627b && (i3 = this.g) >= 0 && o.compareAndSwapInt(this, p, i3, -2)) {
                    a(jVarArr, (j[]) null);
                    return;
                }
                return;
            }
            j<K, V> jVarA = a(jVarArr, i2);
            if (jVarA == null || jVarA.f4636b < 0) {
                return;
            }
            synchronized (jVarA) {
                if (a(jVarArr, i2) == jVarA) {
                    j<K, V> jVar = jVarA;
                    n<K, V> nVar2 = null;
                    while (jVar != null) {
                        n<K, V> nVar3 = new n<>(jVar.f4636b, jVar.c, jVar.d, null, null);
                        nVar3.h = nVar2;
                        if (nVar2 == null) {
                            nVar = nVar3;
                        } else {
                            nVar2.e = nVar3;
                        }
                        jVar = jVar.e;
                        nVar2 = nVar3;
                    }
                    a(jVarArr, i2, new m(nVar));
                }
            }
        }
    }

    static <K, V> j<K, V> a(j<K, V> jVar) {
        j<K, V> jVar2 = null;
        j<K, V> jVar3 = null;
        while (jVar != null) {
            j<K, V> jVar4 = new j<>(jVar.f4636b, jVar.c, jVar.d, null);
            if (jVar2 == null) {
                jVar3 = jVar4;
            } else {
                jVar2.e = jVar4;
            }
            jVar = jVar.e;
            jVar2 = jVar4;
        }
        return jVar3;
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static final class n<K, V> extends j<K, V> {

        /* renamed from: a, reason: collision with root package name */
        n<K, V> f4638a;
        n<K, V> f;
        n<K, V> g;
        n<K, V> h;
        boolean i;

        n(int i, K k, V v, j<K, V> jVar, n<K, V> nVar) {
            super(i, k, v, jVar);
            this.f4638a = nVar;
        }

        @Override // io.netty.util.a.a.a.j
        j<K, V> a(int i, Object obj) {
            return a(i, obj, null);
        }

        final n<K, V> a(int i, Object obj, Class<?> cls) {
            int iA;
            n<K, V> nVarA;
            if (obj == null) {
                return null;
            }
            Class<?> clsA = cls;
            n<K, V> nVar = this;
            do {
                n<K, V> nVar2 = nVar.f;
                n<K, V> nVar3 = nVar.g;
                int i2 = nVar.f4636b;
                if (i2 <= i) {
                    if (i2 >= i) {
                        K k = nVar.c;
                        if (k == obj || (k != null && obj.equals(k))) {
                            return nVar;
                        }
                        if (nVar2 == null && nVar3 == null) {
                            return null;
                        }
                        if ((clsA == null && (clsA = a.a(obj)) == null) || (iA = a.a(clsA, obj, (Object) k)) == 0) {
                            if (nVar2 != null) {
                                if (nVar3 != null && (nVarA = nVar3.a(i, obj, clsA)) != null) {
                                    return nVarA;
                                }
                            }
                        } else if (iA >= 0) {
                            nVar2 = nVar3;
                        }
                        nVar = nVar2;
                    }
                    nVar = nVar3;
                } else {
                    nVar = nVar2;
                }
            } while (nVar != null);
            return null;
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static final class m<K, V> extends j<K, V> {
        static final /* synthetic */ boolean i = !a.class.desiredAssertionStatus();
        private static final Unsafe j;
        private static final long k;

        /* renamed from: a, reason: collision with root package name */
        n<K, V> f4637a;
        volatile n<K, V> f;
        volatile Thread g;
        volatile int h;

        static {
            try {
                j = a.f();
                k = j.objectFieldOffset(m.class.getDeclaredField("lockState"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        m(n<K, V> nVar) {
            int iA;
            super(-2, null, null, null);
            this.f = nVar;
            n<K, V> nVar2 = null;
            while (nVar != null) {
                n<K, V> nVar3 = (n) nVar.e;
                nVar.g = null;
                nVar.f = null;
                if (nVar2 == null) {
                    nVar.f4638a = null;
                    nVar.i = false;
                } else {
                    K k2 = nVar.c;
                    int i2 = nVar.f4636b;
                    Class<?> clsA = null;
                    n<K, V> nVar4 = nVar2;
                    while (true) {
                        int i3 = nVar4.f4636b;
                        if (i3 > i2) {
                            iA = -1;
                        } else if (i3 < i2) {
                            iA = 1;
                        } else {
                            iA = (clsA == null && (clsA = a.a(k2)) == null) ? 0 : a.a(clsA, (Object) k2, (Object) nVar4.c);
                        }
                        n<K, V> nVar5 = iA <= 0 ? nVar4.f : nVar4.g;
                        if (nVar5 == null) {
                            break;
                        } else {
                            nVar4 = nVar5;
                        }
                    }
                    nVar.f4638a = nVar4;
                    if (iA <= 0) {
                        nVar4.f = nVar;
                    } else {
                        nVar4.g = nVar;
                    }
                    nVar = c(nVar2, nVar);
                }
                nVar2 = nVar;
                nVar = nVar3;
            }
            this.f4637a = nVar2;
        }

        private final void a() {
            if (j.compareAndSwapInt(this, k, 0, 1)) {
                return;
            }
            c();
        }

        private final void b() {
            this.h = 0;
        }

        private final void c() {
            boolean z = false;
            while (true) {
                int i2 = this.h;
                if ((i2 & 1) == 0) {
                    if (j.compareAndSwapInt(this, k, i2, 1)) {
                        break;
                    }
                } else if ((i2 & 2) == 0) {
                    if (j.compareAndSwapInt(this, k, i2, i2 | 2)) {
                        this.g = Thread.currentThread();
                        z = true;
                    }
                } else if (z) {
                    LockSupport.park(this);
                }
            }
            if (z) {
                this.g = null;
            }
        }

        @Override // io.netty.util.a.a.a.j
        final j<K, V> a(int i2, Object obj) {
            Unsafe unsafe;
            long j2;
            int i3;
            Thread thread;
            K k2;
            n<K, V> nVarA = null;
            if (obj != null) {
                for (j<K, V> jVar = this.f; jVar != null; jVar = jVar.e) {
                    int i4 = this.h;
                    if ((i4 & 3) != 0) {
                        if (jVar.f4636b == i2 && ((k2 = jVar.c) == obj || (k2 != null && obj.equals(k2)))) {
                            return jVar;
                        }
                    } else if (j.compareAndSwapInt(this, k, i4, i4 + 4)) {
                        try {
                            n<K, V> nVar = this.f4637a;
                            if (nVar != null) {
                                nVarA = nVar.a(i2, obj, null);
                            }
                            do {
                                unsafe = j;
                                j2 = k;
                                i3 = this.h;
                            } while (!unsafe.compareAndSwapInt(this, j2, i3, i3 - 4));
                            if (i3 == 6 && (thread = this.g) != null) {
                                LockSupport.unpark(thread);
                            }
                            return nVarA;
                        } finally {
                        }
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x008b, code lost:
        
            if (io.netty.util.a.a.a.m.i != false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
        
            if (b(r12.f4637a) == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x009b, code lost:
        
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x009c, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00a5, code lost:
        
            return r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00a2 A[LOOP:0: B:3:0x0004->B:58:0x00a2, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x005a A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final io.netty.util.a.a.a.n<K, V> a(int r13, K r14, V r15) {
            /*
                r12 = this;
                io.netty.util.a.a.a$n<K, V> r0 = r12.f4637a
                r1 = 0
                r2 = r1
            L4:
                if (r0 != 0) goto L17
                io.netty.util.a.a.a$n r0 = new io.netty.util.a.a.a$n
                r7 = 0
                r8 = 0
                r3 = r0
                r4 = r13
                r5 = r14
                r6 = r15
                r3.<init>(r4, r5, r6, r7, r8)
                r12.f4637a = r0
                r12.f = r0
                goto L89
            L17:
                int r3 = r0.f4636b
                r4 = -1
                r8 = 1
                if (r3 <= r13) goto L1f
            L1d:
                r9 = -1
                goto L51
            L1f:
                if (r3 >= r13) goto L23
            L21:
                r9 = 1
                goto L51
            L23:
                K r3 = r0.c
                if (r3 == r14) goto La5
                if (r3 == 0) goto L31
                boolean r5 = r14.equals(r3)
                if (r5 == 0) goto L31
                goto La5
            L31:
                if (r2 != 0) goto L39
                java.lang.Class r2 = io.netty.util.a.a.a.a(r14)
                if (r2 == 0) goto L3f
            L39:
                int r3 = io.netty.util.a.a.a.a(r2, r14, r3)
                if (r3 != 0) goto L50
            L3f:
                io.netty.util.a.a.a$n<K, V> r3 = r0.f
                if (r3 != 0) goto L44
                goto L21
            L44:
                io.netty.util.a.a.a$n<K, V> r3 = r0.g
                if (r3 == 0) goto L1d
                io.netty.util.a.a.a$n r3 = r3.a(r13, r14, r2)
                if (r3 != 0) goto L4f
                goto L1d
            L4f:
                return r3
            L50:
                r9 = r3
            L51:
                if (r9 >= 0) goto L56
                io.netty.util.a.a.a$n<K, V> r3 = r0.f
                goto L58
            L56:
                io.netty.util.a.a.a$n<K, V> r3 = r0.g
            L58:
                if (r3 != 0) goto La2
                io.netty.util.a.a.a$n<K, V> r10 = r12.f
                io.netty.util.a.a.a$n r11 = new io.netty.util.a.a.a$n
                r2 = r11
                r3 = r13
                r4 = r14
                r5 = r15
                r6 = r10
                r7 = r0
                r2.<init>(r3, r4, r5, r6, r7)
                r12.f = r11
                if (r10 == 0) goto L6d
                r10.h = r11
            L6d:
                if (r9 >= 0) goto L72
                r0.f = r11
                goto L74
            L72:
                r0.g = r11
            L74:
                boolean r13 = r0.i
                if (r13 != 0) goto L7b
                r11.i = r8
                goto L89
            L7b:
                r12.a()
                io.netty.util.a.a.a$n<K, V> r13 = r12.f4637a     // Catch: java.lang.Throwable -> L9d
                io.netty.util.a.a.a$n r13 = c(r13, r11)     // Catch: java.lang.Throwable -> L9d
                r12.f4637a = r13     // Catch: java.lang.Throwable -> L9d
                r12.b()
            L89:
                boolean r13 = io.netty.util.a.a.a.m.i
                if (r13 != 0) goto L9c
                io.netty.util.a.a.a$n<K, V> r13 = r12.f4637a
                boolean r13 = b(r13)
                if (r13 == 0) goto L96
                goto L9c
            L96:
                java.lang.AssertionError r13 = new java.lang.AssertionError
                r13.<init>()
                throw r13
            L9c:
                return r1
            L9d:
                r13 = move-exception
                r12.b()
                throw r13
            La2:
                r0 = r3
                goto L4
            La5:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.a.a.a.m.a(int, java.lang.Object, java.lang.Object):io.netty.util.a.a.a$n");
        }

        final boolean a(n<K, V> nVar) {
            n<K, V> nVar2;
            n<K, V> nVar3;
            n<K, V> nVar4 = (n) nVar.e;
            n<K, V> nVar5 = nVar.h;
            if (nVar5 == null) {
                this.f = nVar4;
            } else {
                nVar5.e = nVar4;
            }
            if (nVar4 != null) {
                nVar4.h = nVar5;
            }
            if (this.f == null) {
                this.f4637a = null;
                return true;
            }
            n<K, V> nVarD = this.f4637a;
            if (nVarD == null || nVarD.g == null || (nVar2 = nVarD.f) == null || nVar2.f == null) {
                return true;
            }
            a();
            try {
                n<K, V> nVar6 = nVar.f;
                n<K, V> nVar7 = nVar.g;
                if (nVar6 != null && nVar7 != null) {
                    n<K, V> nVar8 = nVar7;
                    while (true) {
                        n<K, V> nVar9 = nVar8.f;
                        if (nVar9 == null) {
                            break;
                        }
                        nVar8 = nVar9;
                    }
                    boolean z = nVar8.i;
                    nVar8.i = nVar.i;
                    nVar.i = z;
                    n<K, V> nVar10 = nVar8.g;
                    n<K, V> nVar11 = nVar.f4638a;
                    if (nVar8 == nVar7) {
                        nVar.f4638a = nVar8;
                        nVar8.g = nVar;
                    } else {
                        n<K, V> nVar12 = nVar8.f4638a;
                        nVar.f4638a = nVar12;
                        if (nVar12 != null) {
                            if (nVar8 == nVar12.f) {
                                nVar12.f = nVar;
                            } else {
                                nVar12.g = nVar;
                            }
                        }
                        nVar8.g = nVar7;
                        nVar7.f4638a = nVar8;
                    }
                    nVar.f = null;
                    nVar8.f = nVar6;
                    nVar6.f4638a = nVar8;
                    nVar.g = nVar10;
                    if (nVar10 != null) {
                        nVar10.f4638a = nVar;
                    }
                    nVar8.f4638a = nVar11;
                    if (nVar11 == null) {
                        nVarD = nVar8;
                    } else if (nVar == nVar11.f) {
                        nVar11.f = nVar8;
                    } else {
                        nVar11.g = nVar8;
                    }
                    if (nVar10 == null) {
                        nVar10 = nVar;
                    }
                    nVar6 = nVar10;
                } else if (nVar6 == null) {
                    nVar6 = nVar7 != null ? nVar7 : nVar;
                }
                if (nVar6 != nVar) {
                    n<K, V> nVar13 = nVar.f4638a;
                    nVar6.f4638a = nVar13;
                    if (nVar13 == null) {
                        nVarD = nVar6;
                    } else if (nVar == nVar13.f) {
                        nVar13.f = nVar6;
                    } else {
                        nVar13.g = nVar6;
                    }
                    nVar.f4638a = null;
                    nVar.g = null;
                    nVar.f = null;
                }
                if (!nVar.i) {
                    nVarD = d(nVarD, nVar6);
                }
                this.f4637a = nVarD;
                if (nVar == nVar6 && (nVar3 = nVar.f4638a) != null) {
                    if (nVar == nVar3.f) {
                        nVar3.f = null;
                    } else if (nVar == nVar3.g) {
                        nVar3.g = null;
                    }
                    nVar.f4638a = null;
                }
                b();
                if (i || b(this.f4637a)) {
                    return false;
                }
                throw new AssertionError();
            } catch (Throwable th) {
                b();
                throw th;
            }
        }

        static <K, V> n<K, V> a(n<K, V> nVar, n<K, V> nVar2) {
            n<K, V> nVar3;
            if (nVar2 != null && (nVar3 = nVar2.g) != null) {
                n<K, V> nVar4 = nVar3.f;
                nVar2.g = nVar4;
                if (nVar4 != null) {
                    nVar4.f4638a = nVar2;
                }
                n<K, V> nVar5 = nVar2.f4638a;
                nVar3.f4638a = nVar5;
                if (nVar5 == null) {
                    nVar3.i = false;
                    nVar = nVar3;
                } else if (nVar5.f == nVar2) {
                    nVar5.f = nVar3;
                } else {
                    nVar5.g = nVar3;
                }
                nVar3.f = nVar2;
                nVar2.f4638a = nVar3;
            }
            return nVar;
        }

        static <K, V> n<K, V> b(n<K, V> nVar, n<K, V> nVar2) {
            n<K, V> nVar3;
            if (nVar2 != null && (nVar3 = nVar2.f) != null) {
                n<K, V> nVar4 = nVar3.g;
                nVar2.f = nVar4;
                if (nVar4 != null) {
                    nVar4.f4638a = nVar2;
                }
                n<K, V> nVar5 = nVar2.f4638a;
                nVar3.f4638a = nVar5;
                if (nVar5 == null) {
                    nVar3.i = false;
                    nVar = nVar3;
                } else if (nVar5.g == nVar2) {
                    nVar5.g = nVar3;
                } else {
                    nVar5.f = nVar3;
                }
                nVar3.g = nVar2;
                nVar2.f4638a = nVar3;
            }
            return nVar;
        }

        static <K, V> n<K, V> c(n<K, V> nVar, n<K, V> nVar2) {
            n<K, V> nVar3;
            n<K, V> nVar4;
            n<K, V> nVar5;
            nVar2.i = true;
            while (true) {
                n<K, V> nVar6 = nVar2.f4638a;
                if (nVar6 == null) {
                    nVar2.i = false;
                    return nVar2;
                }
                if (!nVar6.i || (nVar3 = nVar6.f4638a) == null) {
                    break;
                }
                n<K, V> nVar7 = nVar3.f;
                if (nVar6 == nVar7) {
                    n<K, V> nVar8 = nVar3.g;
                    if (nVar8 != null && nVar8.i) {
                        nVar8.i = false;
                        nVar6.i = false;
                        nVar3.i = true;
                        nVar2 = nVar3;
                    } else {
                        if (nVar2 == nVar6.g) {
                            nVar = a(nVar, nVar6);
                            nVar5 = nVar6.f4638a;
                            nVar3 = nVar5 == null ? null : nVar5.f4638a;
                        } else {
                            nVar6 = nVar2;
                            nVar5 = nVar6;
                        }
                        if (nVar5 != null) {
                            nVar5.i = false;
                            if (nVar3 != null) {
                                nVar3.i = true;
                                nVar = b(nVar, nVar3);
                            }
                        }
                        nVar2 = nVar6;
                    }
                } else if (nVar7 != null && nVar7.i) {
                    nVar7.i = false;
                    nVar6.i = false;
                    nVar3.i = true;
                    nVar2 = nVar3;
                } else {
                    if (nVar2 == nVar6.f) {
                        nVar = b(nVar, nVar6);
                        nVar4 = nVar6.f4638a;
                        nVar3 = nVar4 == null ? null : nVar4.f4638a;
                    } else {
                        nVar6 = nVar2;
                        nVar4 = nVar6;
                    }
                    if (nVar4 != null) {
                        nVar4.i = false;
                        if (nVar3 != null) {
                            nVar3.i = true;
                            nVar = a(nVar, nVar3);
                        }
                    }
                    nVar2 = nVar6;
                }
            }
            return nVar;
        }

        static <K, V> n<K, V> d(n<K, V> nVar, n<K, V> nVar2) {
            while (nVar2 != null && nVar2 != nVar) {
                n<K, V> nVar3 = nVar2.f4638a;
                if (nVar3 == null) {
                    nVar2.i = false;
                    return nVar2;
                }
                if (nVar2.i) {
                    nVar2.i = false;
                    return nVar;
                }
                n<K, V> nVar4 = nVar3.f;
                if (nVar4 == nVar2) {
                    n<K, V> nVar5 = nVar3.g;
                    if (nVar5 != null && nVar5.i) {
                        nVar5.i = false;
                        nVar3.i = true;
                        nVar = a(nVar, nVar3);
                        nVar3 = nVar2.f4638a;
                        nVar5 = nVar3 == null ? null : nVar3.g;
                    }
                    if (nVar5 != null) {
                        n<K, V> nVar6 = nVar5.f;
                        n<K, V> nVar7 = nVar5.g;
                        if ((nVar7 == null || !nVar7.i) && (nVar6 == null || !nVar6.i)) {
                            nVar5.i = true;
                        } else {
                            if (nVar7 == null || !nVar7.i) {
                                if (nVar6 != null) {
                                    nVar6.i = false;
                                }
                                nVar5.i = true;
                                nVar = b(nVar, nVar5);
                                nVar3 = nVar2.f4638a;
                                nVar5 = nVar3 != null ? nVar3.g : null;
                            }
                            if (nVar5 != null) {
                                nVar5.i = nVar3 == null ? false : nVar3.i;
                                n<K, V> nVar8 = nVar5.g;
                                if (nVar8 != null) {
                                    nVar8.i = false;
                                }
                            }
                            if (nVar3 != null) {
                                nVar3.i = false;
                                nVar = a(nVar, nVar3);
                            }
                            nVar2 = nVar;
                        }
                    }
                    nVar2 = nVar3;
                } else {
                    if (nVar4 != null && nVar4.i) {
                        nVar4.i = false;
                        nVar3.i = true;
                        nVar = b(nVar, nVar3);
                        nVar3 = nVar2.f4638a;
                        nVar4 = nVar3 == null ? null : nVar3.f;
                    }
                    if (nVar4 != null) {
                        n<K, V> nVar9 = nVar4.f;
                        n<K, V> nVar10 = nVar4.g;
                        if ((nVar9 == null || !nVar9.i) && (nVar10 == null || !nVar10.i)) {
                            nVar4.i = true;
                        } else {
                            if (nVar9 == null || !nVar9.i) {
                                if (nVar10 != null) {
                                    nVar10.i = false;
                                }
                                nVar4.i = true;
                                nVar = a(nVar, nVar4);
                                nVar3 = nVar2.f4638a;
                                nVar4 = nVar3 != null ? nVar3.f : null;
                            }
                            if (nVar4 != null) {
                                nVar4.i = nVar3 == null ? false : nVar3.i;
                                n<K, V> nVar11 = nVar4.f;
                                if (nVar11 != null) {
                                    nVar11.i = false;
                                }
                            }
                            if (nVar3 != null) {
                                nVar3.i = false;
                                nVar = b(nVar, nVar3);
                            }
                            nVar2 = nVar;
                        }
                    }
                    nVar2 = nVar3;
                }
            }
            return nVar;
        }

        static <K, V> boolean b(n<K, V> nVar) {
            n<K, V> nVar2 = nVar.f4638a;
            n<K, V> nVar3 = nVar.f;
            n<K, V> nVar4 = nVar.g;
            n<K, V> nVar5 = nVar.h;
            n nVar6 = (n) nVar.e;
            if (nVar5 != null && nVar5.e != nVar) {
                return false;
            }
            if (nVar6 != null && nVar6.h != nVar) {
                return false;
            }
            if (nVar2 != null && nVar != nVar2.f && nVar != nVar2.g) {
                return false;
            }
            if (nVar3 != null && (nVar3.f4638a != nVar || nVar3.f4636b > nVar.f4636b)) {
                return false;
            }
            if (nVar4 != null && (nVar4.f4638a != nVar || nVar4.f4636b < nVar.f4636b)) {
                return false;
            }
            if (nVar.i && nVar3 != null && nVar3.i && nVar4 != null && nVar4.i) {
                return false;
            }
            if (nVar3 == null || b(nVar3)) {
                return nVar4 == null || b(nVar4);
            }
            return false;
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static class l<K, V> {
        j<K, V>[] c;
        j<K, V> d = null;
        int e;
        int f;
        int g;
        final int h;

        l(j<K, V>[] jVarArr, int i, int i2, int i3) {
            this.c = jVarArr;
            this.h = i;
            this.e = i2;
            this.f = i2;
            this.g = i3;
        }

        final j<K, V> b() {
            j<K, V>[] jVarArr;
            int length;
            int i;
            j<K, V> jVarA = this.d;
            if (jVarA != null) {
                jVarA = jVarA.e;
            }
            while (jVarA == null) {
                if (this.f >= this.g || (jVarArr = this.c) == null || (length = jVarArr.length) <= (i = this.e) || i < 0) {
                    this.d = null;
                    return null;
                }
                jVarA = a.a(jVarArr, this.e);
                if (jVarA != null && jVarA.f4636b < 0) {
                    if (jVarA instanceof f) {
                        this.c = ((f) jVarA).f4632a;
                        jVarA = null;
                    } else {
                        jVarA = jVarA instanceof m ? ((m) jVarA).f : null;
                    }
                }
                int i2 = this.e + this.h;
                this.e = i2;
                if (i2 >= length) {
                    int i3 = this.f + 1;
                    this.f = i3;
                    this.e = i3;
                }
            }
            this.d = jVarA;
            return jVarA;
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    /* renamed from: io.netty.util.a.a.a$a, reason: collision with other inner class name */
    static class C0108a<K, V> extends l<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final a<K, V> f4628a;

        /* renamed from: b, reason: collision with root package name */
        j<K, V> f4629b;

        C0108a(j<K, V>[] jVarArr, int i, int i2, int i3, a<K, V> aVar) {
            super(jVarArr, i, i2, i3);
            this.f4628a = aVar;
            b();
        }

        public final boolean hasNext() {
            return this.d != null;
        }

        public final boolean hasMoreElements() {
            return this.d != null;
        }

        public final void remove() {
            j<K, V> jVar = this.f4629b;
            if (jVar == null) {
                throw new IllegalStateException();
            }
            this.f4629b = null;
            this.f4628a.a(jVar.c, (K) null, (Object) null);
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static final class g<K, V> extends C0108a<K, V> implements Enumeration<K>, Iterator<K> {
        g(j<K, V>[] jVarArr, int i, int i2, int i3, a<K, V> aVar) {
            super(jVarArr, i, i2, i3, aVar);
        }

        @Override // java.util.Iterator
        public final K next() {
            j<K, V> jVar = this.d;
            if (jVar == null) {
                throw new NoSuchElementException();
            }
            K k = jVar.c;
            this.f4629b = jVar;
            b();
            return k;
        }

        @Override // java.util.Enumeration
        public final K nextElement() {
            return next();
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static final class o<K, V> extends C0108a<K, V> implements Enumeration<V>, Iterator<V> {
        o(j<K, V>[] jVarArr, int i, int i2, int i3, a<K, V> aVar) {
            super(jVarArr, i, i2, i3, aVar);
        }

        @Override // java.util.Iterator
        public final V next() {
            j<K, V> jVar = this.d;
            if (jVar == null) {
                throw new NoSuchElementException();
            }
            V v = jVar.d;
            this.f4629b = jVar;
            b();
            return v;
        }

        @Override // java.util.Enumeration
        public final V nextElement() {
            return next();
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static final class d<K, V> extends C0108a<K, V> implements Iterator<Map.Entry<K, V>> {
        d(j<K, V>[] jVarArr, int i, int i2, int i3, a<K, V> aVar) {
            super(jVarArr, i, i2, i3, aVar);
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map.Entry<K, V> next() {
            j<K, V> jVar = this.d;
            if (jVar == null) {
                throw new NoSuchElementException();
            }
            K k = jVar.c;
            V v = jVar.d;
            this.f4629b = jVar;
            b();
            return new i(k, v, this.f4628a);
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static final class i<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f4634a;

        /* renamed from: b, reason: collision with root package name */
        V f4635b;
        final a<K, V> c;

        i(K k, V v, a<K, V> aVar) {
            this.f4634a = k;
            this.f4635b = v;
            this.c = aVar;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4634a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f4635b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f4634a.hashCode() ^ this.f4635b.hashCode();
        }

        public String toString() {
            return this.f4634a + "=" + this.f4635b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && (key == this.f4634a || key.equals(this.f4634a)) && (value == this.f4635b || value.equals(this.f4635b));
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (v == null) {
                throw new NullPointerException();
            }
            V v2 = this.f4635b;
            this.f4635b = v;
            this.c.put(this.f4634a, v);
            return v2;
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static abstract class b<K, V, E> implements Serializable, Collection<E> {

        /* renamed from: a, reason: collision with root package name */
        final a<K, V> f4630a;

        @Override // java.util.Collection
        public abstract boolean contains(Object obj);

        @Override // java.util.Collection, java.lang.Iterable
        public abstract Iterator<E> iterator();

        b(a<K, V> aVar) {
            this.f4630a = aVar;
        }

        @Override // java.util.Collection
        public final void clear() {
            this.f4630a.clear();
        }

        @Override // java.util.Collection
        public final int size() {
            return this.f4630a.size();
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return this.f4630a.isEmpty();
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            long jB = this.f4630a.b();
            if (jB > 2147483639) {
                throw new OutOfMemoryError("Required array size too large");
            }
            int i = (int) jB;
            Object[] objArrCopyOf = new Object[i];
            int i2 = 0;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (i2 == i) {
                    if (i >= 2147483639) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    int i3 = i < 1073741819 ? (i >>> 1) + 1 + i : 2147483639;
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    i = i3;
                }
                objArrCopyOf[i2] = next;
                i2++;
            }
            return i2 == i ? objArrCopyOf : Arrays.copyOf(objArrCopyOf, i2);
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            long jB = this.f4630a.b();
            if (jB > 2147483639) {
                throw new OutOfMemoryError("Required array size too large");
            }
            int i = (int) jB;
            Object[] objArr = tArr.length >= i ? tArr : (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            int length = objArr.length;
            int i2 = 0;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (i2 == length) {
                    if (length >= 2147483639) {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                    int i3 = length < 1073741819 ? (length >>> 1) + 1 + length : 2147483639;
                    objArr = (T[]) Arrays.copyOf(objArr, i3);
                    length = i3;
                }
                objArr[i2] = next;
                i2++;
            }
            if (tArr != objArr || i2 >= length) {
                return i2 == length ? (T[]) objArr : (T[]) Arrays.copyOf(objArr, i2);
            }
            objArr[i2] = null;
            return (T[]) objArr;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Iterator<E> it = iterator();
            if (it.hasNext()) {
                while (true) {
                    Object next = it.next();
                    if (next == this) {
                        next = "(this Collection)";
                    }
                    sb.append(next);
                    if (!it.hasNext()) {
                        break;
                    }
                    sb.append(',');
                    sb.append(' ');
                }
            }
            sb.append(']');
            return sb.toString();
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            if (collection == this) {
                return true;
            }
            for (Object obj : collection) {
                if (obj == null || !contains(obj)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            Iterator<E> it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            Iterator<E> it = iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    public static class h<K, V> extends b<K, V, K> implements Serializable, Set<K> {

        /* renamed from: b, reason: collision with root package name */
        private final V f4633b;

        h(a<K, V> aVar, V v) {
            super(aVar);
            this.f4633b = v;
        }

        @Override // io.netty.util.a.a.a.b, java.util.Collection
        public boolean contains(Object obj) {
            return this.f4630a.containsKey(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return this.f4630a.remove(obj) != null;
        }

        @Override // io.netty.util.a.a.a.b, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            a<K, V> aVar = this.f4630a;
            j<K, V>[] jVarArr = aVar.f4627b;
            int length = jVarArr == null ? 0 : jVarArr.length;
            return new g(jVarArr, length, 0, length, aVar);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(K k) {
            V v = this.f4633b;
            if (v != null) {
                return this.f4630a.a((a<K, V>) k, (K) v, true) == null;
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends K> collection) {
            V v = this.f4633b;
            if (v == null) {
                throw new UnsupportedOperationException();
            }
            Iterator<? extends K> it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (this.f4630a.a((a<K, V>) it.next(), (K) v, true) == null) {
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            Iterator<K> it = iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                iHashCode += it.next().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static final class p<K, V> extends b<K, V, V> implements Serializable, Collection<V> {
        p(a<K, V> aVar) {
            super(aVar);
        }

        @Override // io.netty.util.a.a.a.b, java.util.Collection
        public final boolean contains(Object obj) {
            return this.f4630a.containsValue(obj);
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            if (obj == null) {
                return false;
            }
            Iterator<V> it = iterator();
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // io.netty.util.a.a.a.b, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            a<K, V> aVar = this.f4630a;
            j<K, V>[] jVarArr = aVar.f4627b;
            int length = jVarArr == null ? 0 : jVarArr.length;
            return new o(jVarArr, length, 0, length, aVar);
        }

        @Override // java.util.Collection
        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static final class e<K, V> extends b<K, V, Map.Entry<K, V>> implements Serializable, Set<Map.Entry<K, V>> {
        e(a<K, V> aVar) {
            super(aVar);
        }

        @Override // io.netty.util.a.a.a.b, java.util.Collection
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            V v;
            Object value;
            return (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (v = this.f4630a.get(key)) == null || (value = entry.getValue()) == null || (value != v && !value.equals(v))) ? false : true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            Object value;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (value = entry.getValue()) != null && this.f4630a.remove(key, value);
        }

        @Override // io.netty.util.a.a.a.b, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            a<K, V> aVar = this.f4630a;
            j<K, V>[] jVarArr = aVar.f4627b;
            int length = jVarArr == null ? 0 : jVarArr.length;
            return new d(jVarArr, length, 0, length, aVar);
        }

        @Override // java.util.Collection, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            return this.f4630a.a((a<K, V>) entry.getKey(), (K) entry.getValue(), false) == null;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            Iterator<? extends Map.Entry<K, V>> it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (add(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            j<K, V>[] jVarArr = this.f4630a.f4627b;
            int iHashCode = 0;
            if (jVarArr != null) {
                l lVar = new l(jVarArr, jVarArr.length, 0, jVarArr.length);
                while (true) {
                    j<K, V> jVarB = lVar.b();
                    if (jVarB == null) {
                        break;
                    }
                    iHashCode += jVarB.hashCode();
                }
            }
            return iHashCode;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            Set set;
            return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
        }
    }

    /* compiled from: ConcurrentHashMapV8.java */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        volatile long f4631a;

        c(long j) {
            this.f4631a = j;
        }
    }

    final long c() {
        c[] cVarArr = this.k;
        long j2 = this.f;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j2 += cVar.f4631a;
                }
            }
        }
        return j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ad, code lost:
    
        if (r25.k != r7) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00af, code lost:
    
        r1 = new io.netty.util.a.a.a.c[r8 << 1];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b4, code lost:
    
        if (r2 >= r8) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b6, code lost:
    
        r1[r2] = r7[r2];
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bd, code lost:
    
        r25.k = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x002a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0117 A[EDGE_INSN: B:93:0x0117->B:85:0x0117 BREAK  A[LOOP:0: B:10:0x0028->B:61:0x00bf, LOOP_LABEL: LOOP:0: B:10:0x0028->B:61:0x00bf], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(io.netty.util.a.d r26, long r27, io.netty.util.a.c r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.a.a.a.a(io.netty.util.a.d, long, io.netty.util.a.c, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe f() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: io.netty.util.a.a.a.1
                @Override // java.security.PrivilegedExceptionAction
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unsafe run() throws IllegalAccessException, IllegalArgumentException {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
    }
}
