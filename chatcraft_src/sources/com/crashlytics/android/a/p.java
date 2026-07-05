package com.crashlytics.android.a;

import android.content.Context;

/* compiled from: FirebaseAnalyticsApiAdapter.java */
/* loaded from: classes.dex */
class p {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1279a;

    /* renamed from: b, reason: collision with root package name */
    private final r f1280b;
    private o c;

    public p(Context context) {
        this(context, new r());
    }

    public p(Context context, r rVar) {
        this.f1279a = context;
        this.f1280b = rVar;
    }

    public o a() {
        if (this.c == null) {
            this.c = j.a(this.f1279a);
        }
        return this.c;
    }

    public void a(ab abVar) {
        o oVarA = a();
        if (oVarA == null) {
            io.fabric.sdk.android.c.g().a("Answers", "Firebase analytics logging was enabled, but not available...");
            return;
        }
        q qVarA = this.f1280b.a(abVar);
        if (qVarA == null) {
            io.fabric.sdk.android.c.g().a("Answers", "Fabric event was not mappable to Firebase event: " + abVar);
            return;
        }
        oVarA.a(qVarA.a(), qVarA.b());
        if ("levelEnd".equals(abVar.g)) {
            oVarA.a("post_score", qVarA.b());
        }
    }
}
