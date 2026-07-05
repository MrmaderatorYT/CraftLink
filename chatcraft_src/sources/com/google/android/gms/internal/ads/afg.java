package com.google.android.gms.internal.ads;

@qj
/* loaded from: classes.dex */
public final class afg extends aex {
    public afg(adk adkVar) {
        super(adkVar);
    }

    @Override // com.google.android.gms.internal.ads.aex
    public final void a() {
    }

    @Override // com.google.android.gms.internal.ads.aex
    public final boolean a(String str) {
        adk adkVar = this.c.get();
        if (adkVar != null) {
            adkVar.a(b(str), this);
        }
        xe.e("VideoStreamNoopCache is doing nothing.");
        a(str, b(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
