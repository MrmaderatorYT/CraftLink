package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
final class bp implements com.google.android.gms.ads.internal.gmsg.ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ pn f2921a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bl f2922b;

    bp(bl blVar, pn pnVar) {
        this.f2922b = blVar;
        this.f2921a = pnVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) {
        afu afuVar = (afu) this.f2922b.f2787a.get();
        if (afuVar == null) {
            this.f2921a.b("/hideOverlay", this);
        } else {
            afuVar.getView().setVisibility(8);
        }
    }
}
