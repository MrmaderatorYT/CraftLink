package androidx.a.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    c<K, V> f77a;

    /* renamed from: b, reason: collision with root package name */
    private c<K, V> f78b;
    private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap<>();
    private int d = 0;

    /* compiled from: SafeIterableMap.java */
    interface f<K, V> {
        void a_(c<K, V> cVar);
    }

    protected c<K, V> a(K k) {
        c<K, V> cVar = this.f77a;
        while (cVar != null && !cVar.f79a.equals(k)) {
            cVar = cVar.c;
        }
        return cVar;
    }

    public V a(K k, V v) {
        c<K, V> cVarA = a(k);
        if (cVarA != null) {
            return cVarA.f80b;
        }
        b(k, v);
        return null;
    }

    protected c<K, V> b(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.d++;
        if (this.f78b == null) {
            this.f77a = cVar;
            this.f78b = this.f77a;
            return cVar;
        }
        this.f78b.c = cVar;
        cVar.d = this.f78b;
        this.f78b = cVar;
        return cVar;
    }

    public V b(K k) {
        c<K, V> cVarA = a(k);
        if (cVarA == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            Iterator<f<K, V>> it = this.c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a_(cVarA);
            }
        }
        if (cVarA.d != null) {
            cVarA.d.c = cVarA.c;
        } else {
            this.f77a = cVarA.c;
        }
        if (cVarA.c != null) {
            cVarA.c.d = cVarA.d;
        } else {
            this.f78b = cVarA.d;
        }
        cVarA.c = null;
        cVarA.d = null;
        return cVarA.f80b;
    }

    public int a() {
        return this.d;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f77a, this.f78b);
        this.c.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> b() {
        C0017b c0017b = new C0017b(this.f78b, this.f77a);
        this.c.put(c0017b, false);
        return c0017b;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f77a;
    }

    public Map.Entry<K, V> e() {
        return this.f78b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (a() != bVar.a()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* compiled from: SafeIterableMap.java */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        c<K, V> f83a;

        /* renamed from: b, reason: collision with root package name */
        c<K, V> f84b;

        abstract c<K, V> a(c<K, V> cVar);

        abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f83a = cVar2;
            this.f84b = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f84b != null;
        }

        @Override // androidx.a.a.b.b.f
        public void a_(c<K, V> cVar) {
            if (this.f83a == cVar && cVar == this.f84b) {
                this.f84b = null;
                this.f83a = null;
            }
            if (this.f83a == cVar) {
                this.f83a = b(this.f83a);
            }
            if (this.f84b == cVar) {
                this.f84b = b();
            }
        }

        private c<K, V> b() {
            if (this.f84b == this.f83a || this.f83a == null) {
                return null;
            }
            return a(this.f84b);
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f84b;
            this.f84b = b();
            return cVar;
        }
    }

    /* compiled from: SafeIterableMap.java */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.c;
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: androidx.a.a.b.b$b, reason: collision with other inner class name */
    private static class C0017b<K, V> extends e<K, V> {
        C0017b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.d;
        }

        @Override // androidx.a.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SafeIterableMap.java */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        private c<K, V> f82b;
        private boolean c = true;

        d() {
        }

        @Override // androidx.a.a.b.b.f
        public void a_(c<K, V> cVar) {
            if (cVar == this.f82b) {
                this.f82b = this.f82b.d;
                this.c = this.f82b == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c ? b.this.f77a != null : (this.f82b == null || this.f82b.c == null) ? false : true;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.c) {
                this.c = false;
                this.f82b = b.this.f77a;
            } else {
                this.f82b = this.f82b != null ? this.f82b.c : null;
            }
            return this.f82b;
        }
    }

    /* compiled from: SafeIterableMap.java */
    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f79a;

        /* renamed from: b, reason: collision with root package name */
        final V f80b;
        c<K, V> c;
        c<K, V> d;

        c(K k, V v) {
            this.f79a = k;
            this.f80b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f79a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f80b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f79a + "=" + this.f80b;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f79a.equals(cVar.f79a) && this.f80b.equals(cVar.f80b);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f79a.hashCode() ^ this.f80b.hashCode();
        }
    }
}
