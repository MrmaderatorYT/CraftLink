package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
final class bo implements com.google.android.gms.ads.internal.gmsg.ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ pn f2893a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bl f2894b;

    bo(bl blVar, pn pnVar) {
        this.f2894b = blVar;
        this.f2893a = pnVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) {
        afu afuVar = (afu) this.f2894b.f2787a.get();
        if (afuVar == null) {
            this.f2893a.b("/showOverlay", this);
        } else {
            afuVar.getView().setVisibility(0);
        }
    }
}
