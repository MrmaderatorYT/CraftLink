package com.crashlytics.android.a;

import android.annotation.SuppressLint;
import android.content.Context;

/* compiled from: AnswersPreferenceManager.java */
/* loaded from: classes.dex */
class h {

    /* renamed from: a, reason: collision with root package name */
    private final io.fabric.sdk.android.services.d.c f1269a;

    public static h a(Context context) {
        return new h(new io.fabric.sdk.android.services.d.d(context, "settings"));
    }

    h(io.fabric.sdk.android.services.d.c cVar) {
        this.f1269a = cVar;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a() {
        this.f1269a.a(this.f1269a.b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean b() {
        return this.f1269a.a().getBoolean("analytics_launched", false);
    }
}
