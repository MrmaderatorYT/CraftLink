package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class jp extends aia {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3204a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("lock")
    private static jp f3205b;
    private final com.google.android.gms.a.a.a c;

    private jp(com.google.android.gms.a.a.a aVar) {
        this.c = aVar;
    }

    public static void a(final Context context, String str, Bundle bundle) {
        synchronized (f3204a) {
            if (f3205b != null) {
                return;
            }
            final jp jpVar = new jp(com.google.android.gms.a.a.a.a(context, "Ads", "am", str, bundle));
            f3205b = jpVar;
            new Thread(new Runnable(context, jpVar) { // from class: com.google.android.gms.internal.ads.jq

                /* renamed from: a, reason: collision with root package name */
                private final Context f3206a;

                /* renamed from: b, reason: collision with root package name */
                private final jp f3207b;

                {
                    this.f3206a = context;
                    this.f3207b = jpVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    jp.a(this.f3206a, this.f3207b);
                }
            }).start();
        }
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final void a(Bundle bundle) {
        this.c.c(bundle);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final Bundle b(Bundle bundle) {
        return this.c.b(bundle);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final void a(String str, String str2, Bundle bundle) {
        this.c.a(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final void a(String str, String str2, com.google.android.gms.dynamic.a aVar) {
        this.c.a(str, str2, aVar != null ? com.google.android.gms.dynamic.b.a(aVar) : null);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final Map a(String str, String str2, boolean z) {
        return this.c.a(str, str2, z);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final int a(String str) {
        return this.c.c(str);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final void c(Bundle bundle) {
        this.c.a(bundle);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final void b(String str, String str2, Bundle bundle) {
        this.c.b(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final List a(String str, String str2) {
        return this.c.a(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final String a() {
        return this.c.c();
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final String b() {
        return this.c.d();
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final long c() {
        return this.c.e();
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final void b(String str) {
        this.c.a(str);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final void c(String str) {
        this.c.b(str);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final void a(com.google.android.gms.dynamic.a aVar, String str, String str2) {
        this.c.a(aVar != null ? (Activity) com.google.android.gms.dynamic.b.a(aVar) : null, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final String d() {
        return this.c.a();
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final String e() {
        return this.c.b();
    }

    @Override // com.google.android.gms.internal.ads.ahz
    public final String f() {
        return this.c.f();
    }

    static final /* synthetic */ void a(Context context, jp jpVar) {
        try {
            ((aib) aao.a(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", jr.f3208a)).a(jpVar);
        } catch (RemoteException | zzbbg | NullPointerException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }
}
