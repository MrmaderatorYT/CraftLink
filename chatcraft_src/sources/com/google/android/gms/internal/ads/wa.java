package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
public final class wa {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<ThreadPoolExecutor> f3534a = new AtomicReference<>(null);

    /* renamed from: b, reason: collision with root package name */
    private final Object f3535b = new Object();

    @GuardedBy("mGmpAppIdLock")
    private String c = null;

    @GuardedBy("mGmpAppIdLock")
    private String d = null;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final AtomicInteger f = new AtomicInteger(-1);
    private final AtomicReference<Object> g = new AtomicReference<>(null);
    private final AtomicReference<Object> h = new AtomicReference<>(null);
    private ConcurrentMap<String, Method> i = new ConcurrentHashMap(9);
    private final AtomicReference<ahz> j = new AtomicReference<>(null);

    @GuardedBy("proxyReference")
    private final List<FutureTask> k = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(android.content.Context r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.d<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.o.ac
            com.google.android.gms.internal.ads.l r1 = com.google.android.gms.internal.ads.bra.e()
            java.lang.Object r0 = r1.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L68
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.e
            boolean r0 = r0.get()
            if (r0 == 0) goto L1c
            goto L68
        L1c:
            com.google.android.gms.internal.ads.d<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.o.aj
            com.google.android.gms.internal.ads.l r2 = com.google.android.gms.internal.ads.bra.e()
            java.lang.Object r0 = r2.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = 1
            if (r0 == 0) goto L30
            return r2
        L30:
            java.util.concurrent.atomic.AtomicInteger r0 = r4.f
            int r0 = r0.get()
            r3 = -1
            if (r0 != r3) goto L5e
            com.google.android.gms.internal.ads.bra.a()
            r0 = 12451000(0xbdfcb8, float:1.7447567E-38)
            boolean r0 = com.google.android.gms.internal.ads.aac.c(r5, r0)
            if (r0 != 0) goto L59
            com.google.android.gms.internal.ads.bra.a()
            boolean r5 = com.google.android.gms.internal.ads.aac.c(r5)
            if (r5 == 0) goto L59
            java.lang.String r5 = "Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service."
            com.google.android.gms.internal.ads.xe.e(r5)
            java.util.concurrent.atomic.AtomicInteger r5 = r4.f
            r5.set(r1)
            goto L5e
        L59:
            java.util.concurrent.atomic.AtomicInteger r5 = r4.f
            r5.set(r2)
        L5e:
            java.util.concurrent.atomic.AtomicInteger r5 = r4.f
            int r5 = r5.get()
            if (r5 != r2) goto L67
            return r2
        L67:
            return r1
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.wa.a(android.content.Context):boolean");
    }

    public final void a(Context context, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (a(context)) {
            b(context, str, "beginAdUnitExposure");
        }
    }

    public final void b(Context context, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (a(context)) {
            b(context, str, "endAdUnitExposure");
        }
    }

    public final String b(Context context) {
        if (!a(context) || !a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
            return BuildConfig.FLAVOR;
        }
        try {
            String str = (String) h(context, "getCurrentScreenName").invoke(this.g.get(), new Object[0]);
            if (str == null) {
                str = (String) h(context, "getCurrentScreenClass").invoke(this.g.get(), new Object[0]);
            }
            return str != null ? str : BuildConfig.FLAVOR;
        } catch (Exception e) {
            a(e, "getCurrentScreenName", false);
            return BuildConfig.FLAVOR;
        }
    }

    public final void c(Context context, String str) {
        if (a(context) && (context instanceof Activity) && a(context, "com.google.firebase.analytics.FirebaseAnalytics", this.h, false)) {
            try {
                i(context, "setCurrentScreen").invoke(this.h.get(), (Activity) context, str, context.getPackageName());
            } catch (Exception e) {
                a(e, "setCurrentScreen", false);
            }
        }
    }

    public final String c(Context context) {
        if (!a(context)) {
            return null;
        }
        synchronized (this.f3535b) {
            if (this.c != null) {
                return this.c;
            }
            this.c = (String) a("getGmpAppId", context);
            return this.c;
        }
    }

    public final String d(final Context context) {
        if (!a(context)) {
            return null;
        }
        long jLongValue = ((Long) bra.e().a(o.ah)).longValue();
        if (jLongValue < 0) {
            return (String) a("getAppInstanceId", context);
        }
        if (this.f3534a.get() == null) {
            this.f3534a.compareAndSet(null, new ThreadPoolExecutor(((Integer) bra.e().a(o.ai)).intValue(), ((Integer) bra.e().a(o.ai)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new wc(this)));
        }
        Future futureSubmit = this.f3534a.get().submit(new Callable(this, context) { // from class: com.google.android.gms.internal.ads.wb

            /* renamed from: a, reason: collision with root package name */
            private final wa f3536a;

            /* renamed from: b, reason: collision with root package name */
            private final Context f3537b;

            {
                this.f3536a = this;
                this.f3537b = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f3536a.g(this.f3537b);
            }
        });
        try {
            return (String) futureSubmit.get(jLongValue, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            futureSubmit.cancel(true);
            if (e instanceof TimeoutException) {
                return "TIME_OUT";
            }
            return null;
        }
    }

    public final String e(Context context) {
        Object objA;
        if (a(context) && (objA = a("generateEventId", context)) != null) {
            return objA.toString();
        }
        return null;
    }

    public final String f(Context context) {
        if (!a(context)) {
            return null;
        }
        synchronized (this.f3535b) {
            if (this.d != null) {
                return this.d;
            }
            this.d = "fa";
            return this.d;
        }
    }

    public final void d(Context context, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        a(context, "_ac", str);
    }

    public final void e(Context context, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        a(context, "_ai", str);
    }

    public final void f(Context context, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        a(context, "_aq", str);
    }

    public final void a(Context context, String str, String str2, String str3, int i) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (a(context)) {
            Bundle bundleA = a(str, false);
            bundleA.putString("_ai", str2);
            bundleA.putString("type", str3);
            bundleA.putInt("value", i);
            a(context, "_ar", bundleA);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            xe.a(sb.toString());
        }
    }

    public final void a(Context context, String str, String str2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (a(context)) {
            a(context, str, a(str2, "_ac".equals(str)));
        }
    }

    private final void a(Context context, String str, Bundle bundle) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (a(context) && a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
            try {
                h(context).invoke(this.g.get(), "am", str, bundle);
            } catch (Exception e) {
                a(e, "logEventInternal", true);
            }
        }
    }

    private static Bundle a(String str, boolean z) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String strValueOf = String.valueOf(str);
            xe.b(strValueOf.length() != 0 ? "Invalid event ID: ".concat(strValueOf) : new String("Invalid event ID: "), e);
        }
        if (z) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    private final Method h(Context context) throws NoSuchMethodException, SecurityException {
        Method method = this.i.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
            this.i.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            a(e, "logEventInternal", true);
            return null;
        }
    }

    private final Method g(Context context, String str) throws NoSuchMethodException, SecurityException {
        Method method = this.i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, String.class);
            this.i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            a(e, str, false);
            return null;
        }
    }

    private final Method h(Context context, String str) throws NoSuchMethodException, SecurityException {
        Method method = this.i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            a(e, str, false);
            return null;
        }
    }

    private final Method i(Context context, String str) throws NoSuchMethodException, SecurityException {
        Method method = this.i.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, Activity.class, String.class, String.class);
            this.i.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            a(e, str, false);
            return null;
        }
    }

    private final void b(Context context, String str, String str2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
            try {
                g(context, str2).invoke(this.g.get(), str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                xe.a(sb.toString());
            } catch (Exception e) {
                a(e, str2, false);
            }
        }
    }

    private final Object a(String str, Context context) throws NoSuchMethodException, SecurityException {
        if (!a(context, "com.google.android.gms.measurement.AppMeasurement", this.g, true)) {
            return null;
        }
        try {
            return h(context, str).invoke(this.g.get(), new Object[0]);
        } catch (Exception e) {
            a(e, str, true);
            return null;
        }
    }

    private final void a(Exception exc, String str, boolean z) {
        if (this.e.get()) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
        sb.append("Invoke Firebase method ");
        sb.append(str);
        sb.append(" error.");
        xe.e(sb.toString());
        if (z) {
            xe.e("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            this.e.set(true);
        }
    }

    private final boolean a(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception e) {
                a(e, "getInstance", z);
                return false;
            }
        }
        return true;
    }

    final /* synthetic */ String g(Context context) {
        return (String) a("getAppInstanceId", context);
    }
}
