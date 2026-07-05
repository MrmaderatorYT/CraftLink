package com.crashlytics.android.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import io.fabric.sdk.android.services.b.j;
import java.io.File;

/* compiled from: Answers.java */
/* loaded from: classes.dex */
public class b extends io.fabric.sdk.android.h<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    boolean f1251a = false;

    /* renamed from: b, reason: collision with root package name */
    z f1252b;

    @Override // io.fabric.sdk.android.h
    public String a() {
        return "1.4.4.28";
    }

    @Override // io.fabric.sdk.android.h
    public String b() {
        return "com.crashlytics.sdk.android:answers";
    }

    public void a(j.b bVar) {
        if (this.f1252b != null) {
            this.f1252b.a(bVar.a());
        }
    }

    public void a(j.a aVar) {
        if (this.f1252b != null) {
            this.f1252b.a(aVar.a(), aVar.b());
        }
    }

    @Override // io.fabric.sdk.android.h
    @SuppressLint({"NewApi"})
    protected boolean b_() throws PackageManager.NameNotFoundException {
        long jLastModified;
        try {
            Context contextR = r();
            PackageManager packageManager = contextR.getPackageManager();
            String packageName = contextR.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String string = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (Build.VERSION.SDK_INT >= 9) {
                jLastModified = packageInfo.firstInstallTime;
            } else {
                jLastModified = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.f1252b = z.a(this, contextR, q(), string, str, jLastModified);
            this.f1252b.b();
            this.f1251a = new io.fabric.sdk.android.services.b.q().b(contextR);
            return true;
        } catch (Exception e) {
            io.fabric.sdk.android.c.g().e("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.h
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Boolean f() {
        if (!new io.fabric.sdk.android.services.b.q().f(r())) {
            io.fabric.sdk.android.c.g().a("Fabric", "Analytics collection disabled, because data collection is disabled by Firebase.");
            this.f1252b.c();
            return false;
        }
        try {
            io.fabric.sdk.android.services.e.t tVarB = io.fabric.sdk.android.services.e.q.a().b();
            if (tVarB == null) {
                io.fabric.sdk.android.c.g().e("Answers", "Failed to retrieve settings");
                return false;
            }
            if (tVarB.d.d) {
                io.fabric.sdk.android.c.g().a("Answers", "Analytics collection enabled");
                this.f1252b.a(tVarB.e, e());
                return true;
            }
            io.fabric.sdk.android.c.g().a("Answers", "Analytics collection disabled");
            this.f1252b.c();
            return false;
        } catch (Exception e) {
            io.fabric.sdk.android.c.g().e("Answers", "Error dealing with settings", e);
            return false;
        }
    }

    String e() {
        return io.fabric.sdk.android.services.b.i.b(r(), "com.crashlytics.ApiEndpoint");
    }
}
