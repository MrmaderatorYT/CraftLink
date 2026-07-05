package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
/* loaded from: classes.dex */
final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1745a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static Context f1746b;

    static synchronized void a(Context context) {
        if (f1746b != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f1746b = context.getApplicationContext();
        }
    }
}
