package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bmx {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2855a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mActivityTrackerLock")
    private bmy f2856b = null;

    @GuardedBy("mActivityTrackerLock")
    private boolean c = false;

    public final void a(Context context) {
        synchronized (this.f2855a) {
            if (!this.c) {
                if (!com.google.android.gms.common.util.j.a()) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    xe.e("Can not cast Context to Application");
                    return;
                }
                if (this.f2856b == null) {
                    this.f2856b = new bmy();
                }
                this.f2856b.a(application, context);
                this.c = true;
            }
        }
    }

    public final void a(bna bnaVar) {
        synchronized (this.f2855a) {
            if (com.google.android.gms.common.util.j.a()) {
                if (this.f2856b == null) {
                    this.f2856b = new bmy();
                }
                this.f2856b.a(bnaVar);
            }
        }
    }

    public final Activity a() {
        synchronized (this.f2855a) {
            if (!com.google.android.gms.common.util.j.a()) {
                return null;
            }
            if (this.f2856b == null) {
                return null;
            }
            return this.f2856b.a();
        }
    }

    public final Context b() {
        synchronized (this.f2855a) {
            if (!com.google.android.gms.common.util.j.a()) {
                return null;
            }
            if (this.f2856b == null) {
                return null;
            }
            return this.f2856b.b();
        }
    }
}
