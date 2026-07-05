package com.crashlytics.android.c;

import android.annotation.SuppressLint;

/* compiled from: PreferenceManager.java */
@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes.dex */
class aj {

    /* renamed from: a, reason: collision with root package name */
    private final io.fabric.sdk.android.services.d.c f1305a;

    /* renamed from: b, reason: collision with root package name */
    private final l f1306b;

    public static aj a(io.fabric.sdk.android.services.d.c cVar, l lVar) {
        return new aj(cVar, lVar);
    }

    public aj(io.fabric.sdk.android.services.d.c cVar, l lVar) {
        this.f1305a = cVar;
        this.f1306b = lVar;
    }

    void a(boolean z) {
        this.f1305a.a(this.f1305a.b().putBoolean("always_send_reports_opt_in", z));
    }

    boolean a() {
        if (!this.f1305a.a().contains("preferences_migration_complete")) {
            io.fabric.sdk.android.services.d.d dVar = new io.fabric.sdk.android.services.d.d(this.f1306b);
            if (!this.f1305a.a().contains("always_send_reports_opt_in") && dVar.a().contains("always_send_reports_opt_in")) {
                this.f1305a.a(this.f1305a.b().putBoolean("always_send_reports_opt_in", dVar.a().getBoolean("always_send_reports_opt_in", false)));
            }
            this.f1305a.a(this.f1305a.b().putBoolean("preferences_migration_complete", true));
        }
        return this.f1305a.a().getBoolean("always_send_reports_opt_in", false);
    }
}
