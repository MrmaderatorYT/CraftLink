package androidx.a.a.b;

import androidx.a.a.b.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FastSafeIterableMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* renamed from: b, reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f76b = new HashMap<>();

    @Override // androidx.a.a.b.b
    protected b.c<K, V> a(K k) {
        return this.f76b.get(k);
    }

    @Override // androidx.a.a.b.b
    public V a(K k, V v) {
        b.c<K, V> cVarA = a(k);
        if (cVarA != null) {
            return cVarA.f80b;
        }
        this.f76b.put(k, b(k, v));
        return null;
    }

    @Override // androidx.a.a.b.b
    public V b(K k) {
        V v = (V) super.b(k);
        this.f76b.remove(k);
        return v;
    }

    public boolean c(K k) {
        return this.f76b.containsKey(k);
    }

    public Map.Entry<K, V> d(K k) {
        if (c(k)) {
            return this.f76b.get(k).d;
        }
        return null;
    }
}
