package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class atd extends atj {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ata f2249a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private atd(ata ataVar) {
        super(ataVar, null);
        this.f2249a = ataVar;
    }

    @Override // com.google.android.gms.internal.ads.atj, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new atc(this.f2249a, null);
    }

    /* synthetic */ atd(ata ataVar, atb atbVar) {
        this(ataVar);
    }
}
