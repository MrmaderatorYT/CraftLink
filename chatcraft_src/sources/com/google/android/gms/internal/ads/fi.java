package com.google.android.gms.internal.ads;

import android.content.Context;

@qj
/* loaded from: classes.dex */
public final class fi {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3081a;

    /* renamed from: b, reason: collision with root package name */
    private final kk f3082b;
    private final aar c;
    private final com.google.android.gms.ads.internal.bt d;

    fi(Context context, kk kkVar, aar aarVar, com.google.android.gms.ads.internal.bt btVar) {
        this.f3081a = context;
        this.f3082b = kkVar;
        this.c = aarVar;
        this.d = btVar;
    }

    public final com.google.android.gms.ads.internal.m a(String str) {
        return new com.google.android.gms.ads.internal.m(this.f3081a, new bqn(), str, this.f3082b, this.c, this.d);
    }

    public final com.google.android.gms.ads.internal.m b(String str) {
        return new com.google.android.gms.ads.internal.m(this.f3081a.getApplicationContext(), new bqn(), str, this.f3082b, this.c, this.d);
    }

    public final Context a() {
        return this.f3081a.getApplicationContext();
    }

    public final fi b() {
        return new fi(this.f3081a.getApplicationContext(), this.f3082b, this.c, this.d);
    }
}
