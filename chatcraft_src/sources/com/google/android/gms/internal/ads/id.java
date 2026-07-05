package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes.dex */
final class id implements com.google.android.gms.ads.internal.gmsg.ac<iu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ip f3159a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ hk f3160b;
    private final /* synthetic */ hv c;

    id(hv hvVar, ip ipVar, hk hkVar) {
        this.c = hvVar;
        this.f3159a = ipVar;
        this.f3160b = hkVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(iu iuVar, Map map) {
        synchronized (this.c.f3146a) {
            if (this.f3159a.e() != -1 && this.f3159a.e() != 1) {
                this.c.h = 0;
                this.c.e.a(this.f3160b);
                this.f3159a.a((ip) this.f3160b);
                this.c.g = this.f3159a;
                xe.a("Successfully loaded JS Engine.");
            }
        }
    }
}
