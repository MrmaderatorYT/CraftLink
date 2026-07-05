package com.crashlytics.android.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* compiled from: AppData.java */
/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1293a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1294b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public static a a(Context context, io.fabric.sdk.android.services.b.r rVar, String str, String str2) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String strI = rVar.i();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        return new a(str, str2, strI, packageName, Integer.toString(packageInfo.versionCode), packageInfo.versionName == null ? "0.0" : packageInfo.versionName);
    }

    a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f1293a = str;
        this.f1294b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }
}
