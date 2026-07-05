package com.crashlytics.android.c;

import android.content.Context;

/* compiled from: ResourceUnityVersionProvider.java */
/* loaded from: classes.dex */
class aq implements aw {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1323a;

    /* renamed from: b, reason: collision with root package name */
    private final aw f1324b;
    private boolean c = false;
    private String d;

    public aq(Context context, aw awVar) {
        this.f1323a = context;
        this.f1324b = awVar;
    }

    @Override // com.crashlytics.android.c.aw
    public String a() {
        if (!this.c) {
            this.d = io.fabric.sdk.android.services.b.i.n(this.f1323a);
            this.c = true;
        }
        if (this.d != null) {
            return this.d;
        }
        if (this.f1324b != null) {
            return this.f1324b.a();
        }
        return null;
    }
}
