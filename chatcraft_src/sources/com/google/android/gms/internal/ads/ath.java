package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes.dex */
final class ath<K, V> implements Comparable<ath>, Map.Entry<K, V> {

    /* renamed from: a, reason: collision with root package name */
    /* JADX INFO: Incorrect field signature: TK; */
    private final Comparable f2252a;

    /* renamed from: b, reason: collision with root package name */
    private V f2253b;
    private final /* synthetic */ ata c;

    ath(ata ataVar, Map.Entry<K, V> entry) {
        this(ataVar, (Comparable) entry.getKey(), entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    ath(ata ataVar, K k, V v) {
        this.c = ataVar;
        this.f2252a = k;
        this.f2253b = v;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f2253b;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.c.f();
        V v2 = this.f2253b;
        this.f2253b = v;
        return v2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return a(this.f2252a, entry.getKey()) && a(this.f2253b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return (this.f2252a == null ? 0 : this.f2252a.hashCode()) ^ (this.f2253b != null ? this.f2253b.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f2252a);
        String strValueOf2 = String.valueOf(this.f2253b);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(strValueOf2).length());
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        return sb.toString();
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f2252a;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ath athVar) {
        return ((Comparable) getKey()).compareTo((Comparable) athVar.getKey());
    }
}
