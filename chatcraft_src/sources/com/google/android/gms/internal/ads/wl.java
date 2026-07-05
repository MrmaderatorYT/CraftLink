package com.google.android.gms.internal.ads;

import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class wl {

    /* renamed from: a, reason: collision with root package name */
    public final ri f3545a;

    /* renamed from: b, reason: collision with root package name */
    public final rm f3546b;
    public final ju c;
    public final bqn d;
    public final int e;
    public final long f;
    public final long g;
    public final JSONObject h;
    public final bos i;
    public final boolean j;

    public wl(ri riVar, rm rmVar, ju juVar, bqn bqnVar, int i, long j, long j2, JSONObject jSONObject, box boxVar) {
        this.f3545a = riVar;
        this.f3546b = rmVar;
        this.c = null;
        this.d = null;
        this.e = i;
        this.f = j;
        this.g = j2;
        this.h = null;
        this.i = new bos(boxVar);
        this.j = false;
    }

    public wl(ri riVar, rm rmVar, ju juVar, bqn bqnVar, int i, long j, long j2, JSONObject jSONObject, bos bosVar, Boolean bool) {
        this.f3545a = riVar;
        this.f3546b = rmVar;
        this.c = juVar;
        this.d = bqnVar;
        this.e = i;
        this.f = j;
        this.g = j2;
        this.h = jSONObject;
        this.i = bosVar;
        if (bool != null) {
            this.j = bool.booleanValue();
        } else {
            this.j = zu.a(riVar.c.m);
        }
    }
}
