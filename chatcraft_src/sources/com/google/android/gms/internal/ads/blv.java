package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class blv implements bmf {

    /* renamed from: a, reason: collision with root package name */
    private final blj f2820a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f2821b;
    private final com.google.android.gms.ads.internal.gmsg.b c;
    private il d;
    private boolean e;
    private final com.google.android.gms.ads.internal.gmsg.ac<iu> f = new bma(this);
    private final com.google.android.gms.ads.internal.gmsg.ac<iu> g = new bmb(this);
    private final com.google.android.gms.ads.internal.gmsg.ac<iu> h = new bmc(this);
    private final com.google.android.gms.ads.internal.gmsg.ac<iu> i = new bme(this);

    public blv(blj bljVar, hv hvVar, Context context) {
        this.f2820a = bljVar;
        this.f2821b = context;
        this.c = new com.google.android.gms.ads.internal.gmsg.b(this.f2821b);
        this.d = hvVar.b((axe) null);
        this.d.a(new blw(this), new blx(this));
        String strValueOf = String.valueOf(this.f2820a.f2805a.d());
        xe.b(strValueOf.length() != 0 ? "Core JS tracking ad unit: ".concat(strValueOf) : new String("Core JS tracking ad unit: "));
    }

    @Override // com.google.android.gms.internal.ads.bmf
    public final void a(JSONObject jSONObject, boolean z) {
        this.d.a(new bly(this, jSONObject), new abz());
    }

    @Override // com.google.android.gms.internal.ads.bmf
    public final boolean a() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.bmf
    public final void b() {
        this.d.a(new blz(this), new abz());
        this.d.a();
    }

    final void a(iu iuVar) {
        iuVar.a("/updateActiveView", this.f);
        iuVar.a("/untrackActiveViewUnit", this.g);
        iuVar.a("/visibilityChanged", this.h);
        if (com.google.android.gms.ads.internal.ax.E().a(this.f2821b)) {
            iuVar.a("/logScionEvent", this.i);
        }
    }

    final void b(iu iuVar) {
        iuVar.b("/visibilityChanged", this.h);
        iuVar.b("/untrackActiveViewUnit", this.g);
        iuVar.b("/updateActiveView", this.f);
        if (com.google.android.gms.ads.internal.ax.E().a(this.f2821b)) {
            iuVar.b("/logScionEvent", this.i);
        }
    }

    static /* synthetic */ boolean a(blv blvVar, boolean z) {
        blvVar.e = true;
        return true;
    }
}
