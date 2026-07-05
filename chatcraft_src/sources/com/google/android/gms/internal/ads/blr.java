package com.google.android.gms.internal.ads;

import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class blr implements bmf {

    /* renamed from: a, reason: collision with root package name */
    private final blj f2815a;

    /* renamed from: b, reason: collision with root package name */
    private final afu f2816b;
    private final com.google.android.gms.ads.internal.gmsg.ac<afu> c = new bls(this);
    private final com.google.android.gms.ads.internal.gmsg.ac<afu> d = new blt(this);
    private final com.google.android.gms.ads.internal.gmsg.ac<afu> e = new blu(this);

    public blr(blj bljVar, afu afuVar) {
        this.f2815a = bljVar;
        this.f2816b = afuVar;
        afu afuVar2 = this.f2816b;
        afuVar2.a("/updateActiveView", this.c);
        afuVar2.a("/untrackActiveViewUnit", this.d);
        afuVar2.a("/visibilityChanged", this.e);
        String strValueOf = String.valueOf(this.f2815a.f2805a.d());
        xe.b(strValueOf.length() != 0 ? "Custom JS tracking ad unit: ".concat(strValueOf) : new String("Custom JS tracking ad unit: "));
    }

    @Override // com.google.android.gms.internal.ads.bmf
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bmf
    public final void a(JSONObject jSONObject, boolean z) {
        if (!z) {
            this.f2816b.b("AFMA_updateActiveView", jSONObject);
        } else {
            this.f2815a.b(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.bmf
    public final void b() {
        afu afuVar = this.f2816b;
        afuVar.b("/visibilityChanged", this.e);
        afuVar.b("/untrackActiveViewUnit", this.d);
        afuVar.b("/updateActiveView", this.c);
    }
}
