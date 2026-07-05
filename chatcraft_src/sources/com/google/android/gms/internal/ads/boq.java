package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.b;

/* loaded from: classes.dex */
final class boq implements b.InterfaceC0066b {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ abv f2910a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bok f2911b;

    boq(bok bokVar, abv abvVar) {
        this.f2911b = bokVar;
        this.f2910a = abvVar;
    }

    @Override // com.google.android.gms.common.internal.b.InterfaceC0066b
    public final void a(com.google.android.gms.common.b bVar) {
        synchronized (this.f2911b.d) {
            this.f2910a.a(new RuntimeException("Connection failed."));
        }
    }
}
