package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static f f1706a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1707b;

    private f(Context context) {
        this.f1707b = context.getApplicationContext();
    }

    public static f a(Context context) {
        com.google.android.gms.common.internal.i.a(context);
        synchronized (f.class) {
            if (f1706a == null) {
                j.a(context);
                f1706a = new f(context);
            }
        }
        return f1706a;
    }

    public static boolean a(PackageInfo packageInfo, boolean z) {
        k kVarA;
        if (packageInfo != null && packageInfo.signatures != null) {
            if (z) {
                kVarA = a(packageInfo, n.f1751a);
            } else {
                kVarA = a(packageInfo, n.f1751a[0]);
            }
            if (kVarA != null) {
                return true;
            }
        }
        return false;
    }

    private static k a(PackageInfo packageInfo, k... kVarArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        l lVar = new l(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < kVarArr.length; i++) {
            if (kVarArr[i].equals(lVar)) {
                return kVarArr[i];
            }
        }
        return null;
    }
}
