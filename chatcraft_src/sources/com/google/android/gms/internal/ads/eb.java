package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class eb {

    /* renamed from: b, reason: collision with root package name */
    private static String f3058b = "Volley";

    /* renamed from: a, reason: collision with root package name */
    public static boolean f3057a = Log.isLoggable("Volley", 2);
    private static final String c = eb.class.getName();

    public static void a(String str, Object... objArr) {
        if (f3057a) {
            Log.v(f3058b, d(str, objArr));
        }
    }

    static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final boolean f3059a = eb.f3057a;

        /* renamed from: b, reason: collision with root package name */
        private final List<ez> f3060b = new ArrayList();
        private boolean c = false;

        a() {
        }

        public final synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f3060b.add(new ez(str, j, SystemClock.elapsedRealtime()));
        }

        public final synchronized void a(String str) {
            this.c = true;
            long j = this.f3060b.size() == 0 ? 0L : this.f3060b.get(this.f3060b.size() - 1).c - this.f3060b.get(0).c;
            if (j <= 0) {
                return;
            }
            long j2 = this.f3060b.get(0).c;
            eb.b("(%-4d ms) %s", Long.valueOf(j), str);
            for (ez ezVar : this.f3060b) {
                long j3 = ezVar.c;
                eb.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(ezVar.f3080b), ezVar.f3079a);
                j2 = j3;
            }
        }

        protected final void finalize() {
            if (this.c) {
                return;
            }
            a("Request on the loose");
            eb.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(f3058b, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f3058b, d(str, objArr));
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f3058b, d(str, objArr), th);
    }

    private static String d(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String string = "<unknown>";
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            }
            if (!stackTrace[i].getClassName().equals(c)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(strSubstring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(strSubstring2);
                sb.append(".");
                sb.append(methodName);
                string = sb.toString();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), string, str);
    }
}
