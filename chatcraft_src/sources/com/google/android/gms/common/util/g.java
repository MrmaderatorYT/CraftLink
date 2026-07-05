package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f1755a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f1756b;
    private static Boolean c;
    private static Boolean d;

    @TargetApi(20)
    public static boolean a(Context context) {
        if (f1755a == null) {
            f1755a = Boolean.valueOf(j.g() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f1755a.booleanValue();
    }

    @TargetApi(26)
    public static boolean b(Context context) {
        if (!a(context)) {
            return false;
        }
        if (j.j()) {
            return c(context) && !j.k();
        }
        return true;
    }

    @TargetApi(21)
    public static boolean c(Context context) {
        if (f1756b == null) {
            f1756b = Boolean.valueOf(j.h() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f1756b.booleanValue();
    }

    public static boolean d(Context context) {
        if (c == null) {
            PackageManager packageManager = context.getPackageManager();
            c = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return c.booleanValue();
    }

    public static boolean e(Context context) {
        if (d == null) {
            d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return d.booleanValue();
    }
}
