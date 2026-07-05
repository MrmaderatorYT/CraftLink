package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.b;

/* loaded from: classes.dex */
final class bnz implements b.InterfaceC0066b {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bnv f2892a;

    bnz(bnv bnvVar) {
        this.f2892a = bnvVar;
    }

    @Override // com.google.android.gms.common.internal.b.InterfaceC0066b
    public final void a(com.google.android.gms.common.b bVar) {
        synchronized (this.f2892a.f2888b) {
            this.f2892a.e = null;
            if (this.f2892a.c != null) {
                bnv.a(this.f2892a, (boc) null);
            }
            this.f2892a.f2888b.notifyAll();
        }
    }
}
