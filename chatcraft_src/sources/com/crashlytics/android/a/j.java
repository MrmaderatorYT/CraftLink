package com.crashlytics.android.a;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: AppMeasurementEventLogger.java */
/* loaded from: classes.dex */
public class j implements o {

    /* renamed from: a, reason: collision with root package name */
    private final Method f1272a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f1273b;

    public static o a(Context context) {
        Object objA;
        Method methodB;
        Class clsB = b(context);
        if (clsB == null || (objA = a(context, clsB)) == null || (methodB = b(context, clsB)) == null) {
            return null;
        }
        return new j(objA, methodB);
    }

    private static Class b(Context context) {
        try {
            return context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement");
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object a(Context context, Class cls) {
        try {
            return cls.getDeclaredMethod("getInstance", Context.class).invoke(cls, context);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method b(Context context, Class cls) {
        try {
            return cls.getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public j(Object obj, Method method) {
        this.f1273b = obj;
        this.f1272a = method;
    }

    @Override // com.crashlytics.android.a.o
    public void a(String str, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a("fab", str, bundle);
    }

    @Override // com.crashlytics.android.a.o
    public void a(String str, String str2, Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f1272a.invoke(this.f1273b, str, str2, bundle);
        } catch (Exception unused) {
        }
    }
}
