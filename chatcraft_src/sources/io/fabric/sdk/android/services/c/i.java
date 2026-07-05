package io.fabric.sdk.android.services.c;

import android.content.Context;

/* compiled from: TimeBasedFileRollOverRunnable.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4253a;

    /* renamed from: b, reason: collision with root package name */
    private final e f4254b;

    public i(Context context, e eVar) {
        this.f4253a = context;
        this.f4254b = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            io.fabric.sdk.android.services.b.i.a(this.f4253a, "Performing time based file roll over.");
            if (this.f4254b.c()) {
                return;
            }
            this.f4254b.d();
        } catch (Exception e) {
            io.fabric.sdk.android.services.b.i.a(this.f4253a, "Failed to roll over file", e);
        }
    }
}
