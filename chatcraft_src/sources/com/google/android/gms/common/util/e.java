package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f1752a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    /* renamed from: b, reason: collision with root package name */
    private static DropBoxManager f1753b = null;
    private static boolean c = false;
    private static int d = -1;

    @GuardedBy("CrashUtils.class")
    private static int e = 0;

    @GuardedBy("CrashUtils.class")
    private static int f = 0;

    public static boolean a(Context context, Throwable th) {
        return a(context, th, 536870912);
    }

    private static boolean a(Context context, Throwable th, int i) {
        try {
            com.google.android.gms.common.internal.i.a(context);
            com.google.android.gms.common.internal.i.a(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}
