package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
final class arj<K> implements Map.Entry<K, Object> {

    /* renamed from: a, reason: collision with root package name */
    private Map.Entry<K, arh> f2203a;

    private arj(Map.Entry<K, arh> entry) {
        this.f2203a = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f2203a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f2203a.getValue() == null) {
            return null;
        }
        return arh.a();
    }

    public final arh a() {
        return this.f2203a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof asf)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.f2203a.getValue().a((asf) obj);
    }
}
