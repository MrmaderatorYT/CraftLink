package com.google.android.gms.internal.ads;

import android.util.Log;

@qj
/* loaded from: classes.dex */
public class aan {
    public static void b(String str) {
        if (a(3)) {
            Log.d("Ads", str);
        }
    }

    public static void a(String str, Throwable th) {
        if (a(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static void c(String str) {
        if (a(6)) {
            Log.e("Ads", str);
        }
    }

    public static void b(String str, Throwable th) {
        if (a(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void d(String str) {
        if (a(4)) {
            Log.i("Ads", str);
        }
    }

    public static void e(String str) {
        if (a(5)) {
            Log.w("Ads", str);
        }
    }

    public static void c(String str, Throwable th) {
        if (a(5)) {
            Log.w("Ads", str, th);
        }
    }

    private static String a(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append(" @");
        sb.append(lineNumber);
        return sb.toString();
    }

    public static void d(String str, Throwable th) {
        if (a(5)) {
            if (th != null) {
                c(a(str), th);
            } else {
                e(a(str));
            }
        }
    }

    public static void f(String str) {
        d(str, null);
    }

    public static boolean a(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }
}
