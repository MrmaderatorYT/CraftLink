package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes.dex */
final class sg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f3443a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f3444b;
    private final /* synthetic */ se c;

    sg(se seVar, JSONObject jSONObject, String str) {
        this.c = seVar;
        this.f3443a = jSONObject;
        this.f3444b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.l = se.d.b((axe) null);
        this.c.l.a(new sh(this), new si(this));
    }
}
