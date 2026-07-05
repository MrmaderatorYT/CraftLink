package com.google.android.gms.common.b;

import android.content.Context;
import com.google.android.gms.common.util.j;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f1695a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f1696b;

    public static synchronized boolean a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (f1695a != null && f1696b != null && f1695a == applicationContext) {
            return f1696b.booleanValue();
        }
        f1696b = null;
        if (j.k()) {
            f1696b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f1696b = true;
            } catch (ClassNotFoundException unused) {
                f1696b = false;
            }
        }
        f1695a = applicationContext;
        return f1696b.booleanValue();
    }
}
