package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
class ata<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final int f2245a;

    /* renamed from: b, reason: collision with root package name */
    private List<ath> f2246b;
    private Map<K, V> c;
    private boolean d;
    private volatile atj e;
    private Map<K, V> f;
    private volatile atd g;

    static <FieldDescriptorType extends aqq<FieldDescriptorType>> ata<FieldDescriptorType, Object> a(int i) {
        return new atb(i);
    }

    private ata(int i) {
        this.f2245a = i;
        this.f2246b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }

    public void a() {
        Map<K, V> mapUnmodifiableMap;
        Map<K, V> mapUnmodifiableMap2;
        if (this.d) {
            return;
        }
        if (this.c.isEmpty()) {
            mapUnmodifiableMap = Collections.emptyMap();
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(this.c);
        }
        this.c = mapUnmodifiableMap;
        if (this.f.isEmpty()) {
            mapUnmodifiableMap2 = Collections.emptyMap();
        } else {
            mapUnmodifiableMap2 = Collections.unmodifiableMap(this.f);
        }
        this.f = mapUnmodifiableMap2;
        this.d = true;
    }

    public final boolean b() {
        return this.d;
    }

    public final int c() {
        return this.f2246b.size();
    }

    public final Map.Entry<K, V> b(int i) {
        return this.f2246b.get(i);
    }

    public final Iterable<Map.Entry<K, V>> d() {
        if (this.c.isEmpty()) {
            return ate.a();
        }
        return this.c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f2246b.size() + this.c.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((ata<K, V>) comparable) >= 0 || this.c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a((ata<K, V>) comparable);
        if (iA >= 0) {
            return (V) this.f2246b.get(iA).getValue();
        }
        return this.c.get(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V a(K k, V v) {
        f();
        int iA = a((ata<K, V>) k);
        if (iA >= 0) {
            return (V) this.f2246b.get(iA).setValue(v);
        }
        f();
        if (this.f2246b.isEmpty() && !(this.f2246b instanceof ArrayList)) {
            this.f2246b = new ArrayList(this.f2245a);
        }
        int i = -(iA + 1);
        if (i >= this.f2245a) {
            return g().put(k, v);
        }
        if (this.f2246b.size() == this.f2245a) {
            ath athVarRemove = this.f2246b.remove(this.f2245a - 1);
            g().put((Comparable) athVarRemove.getKey(), athVarRemove.getValue());
        }
        this.f2246b.add(i, new ath(this, k, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f2246b.isEmpty()) {
            this.f2246b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int iA = a((ata<K, V>) comparable);
        if (iA >= 0) {
            return c(iA);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V c(int i) {
        f();
        V v = (V) this.f2246b.remove(i).getValue();
        if (!this.c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            this.f2246b.add(new ath(this, it.next()));
            it.remove();
        }
        return v;
    }

    private final int a(K k) {
        int size = this.f2246b.size() - 1;
        if (size >= 0) {
            int iCompareTo = k.compareTo((Comparable) this.f2246b.get(size).getKey());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int iCompareTo2 = k.compareTo((Comparable) this.f2246b.get(i2).getKey());
            if (iCompareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.e == null) {
            this.e = new atj(this, null);
        }
        return this.e;
    }

    final Set<Map.Entry<K, V>> e() {
        if (this.g == null) {
            this.g = new atd(this, null);
        }
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> g() {
        f();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            this.c = new TreeMap();
            this.f = ((TreeMap) this.c).descendingMap();
        }
        return (SortedMap) this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ata)) {
            return super.equals(obj);
        }
        ata ataVar = (ata) obj;
        int size = size();
        if (size != ataVar.size()) {
            return false;
        }
        int iC = c();
        if (iC != ataVar.c()) {
            return entrySet().equals(ataVar.entrySet());
        }
        for (int i = 0; i < iC; i++) {
            if (!b(i).equals(ataVar.b(i))) {
                return false;
            }
        }
        if (iC != size) {
            return this.c.equals(ataVar.c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iC = c();
        int iHashCode = 0;
        for (int i = 0; i < iC; i++) {
            iHashCode += this.f2246b.get(i).hashCode();
        }
        return this.c.size() > 0 ? iHashCode + this.c.hashCode() : iHashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return a((ata<K, V>) obj, (Comparable) obj2);
    }

    /* synthetic */ ata(int i, atb atbVar) {
        this(i);
    }
}
