package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
final class ie implements com.google.android.gms.ads.internal.gmsg.ac<iu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ axe f3161a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ hk f3162b;
    private final /* synthetic */ zs c;
    private final /* synthetic */ hv d;

    ie(hv hvVar, axe axeVar, hk hkVar, zs zsVar) {
        this.d = hvVar;
        this.f3161a = axeVar;
        this.f3162b = hkVar;
        this.c = zsVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(iu iuVar, Map map) {
        synchronized (this.d.f3146a) {
            xe.d("JS Engine is requesting an update");
            if (this.d.h == 0) {
                xe.d("Starting reload.");
                this.d.h = 2;
                this.d.a(this.f3161a);
            }
            this.f3162b.b("/requestReload", (com.google.android.gms.ads.internal.gmsg.ac<? super iu>) this.c.a());
        }
    }
}
