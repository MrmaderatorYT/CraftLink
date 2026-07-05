package com.crashlytics.android.c;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefaultAppMeasurementEventListenerRegistrar.java */
/* loaded from: classes.dex */
class u implements b {

    /* renamed from: a, reason: collision with root package name */
    private final l f1427a;

    static b a(l lVar) {
        return new u(lVar);
    }

    private u(l lVar) {
        this.f1427a = lVar;
    }

    @Override // com.crashlytics.android.c.b
    public boolean a() {
        Class<?> clsA = a("com.google.android.gms.measurement.AppMeasurement");
        if (clsA == null) {
            io.fabric.sdk.android.c.g().d("CrashlyticsCore", "Firebase Analytics is not present; you will not see automatic logging of events before a crash occurs.");
            return false;
        }
        Object objA = a(clsA);
        if (objA == null) {
            io.fabric.sdk.android.c.g().d("CrashlyticsCore", "Could not create an instance of Firebase Analytics.");
            return false;
        }
        return a(clsA, objA, "registerOnMeasurementEventListener");
    }

    private Class<?> a(String str) {
        try {
            return this.f1427a.r().getClassLoader().loadClass(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private Object a(Class<?> cls) {
        try {
            return cls.getDeclaredMethod("getInstance", Context.class).invoke(cls, this.f1427a.r());
        } catch (Exception e) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Could not get instance of com.google.android.gms.measurement.AppMeasurement", e);
            return null;
        }
    }

    private boolean a(Class<?> cls, Object obj, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> clsA = a("com.google.android.gms.measurement.AppMeasurement$OnEventListener");
        if (clsA == null) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Could not get class com.google.android.gms.measurement.AppMeasurement$OnEventListener");
            return false;
        }
        try {
            cls.getDeclaredMethod(str, clsA).invoke(obj, b(clsA));
            return true;
        } catch (IllegalAccessException e) {
            io.fabric.sdk.android.c.g().d("CrashlyticsCore", "Cannot access method: " + str, e);
            return false;
        } catch (NoSuchMethodException e2) {
            io.fabric.sdk.android.c.g().d("CrashlyticsCore", "Expected method missing: " + str, e2);
            return false;
        } catch (InvocationTargetException e3) {
            io.fabric.sdk.android.c.g().d("CrashlyticsCore", "Cannot invoke method: " + str, e3);
            return false;
        }
    }

    private Object b(Class cls) {
        return Proxy.newProxyInstance(this.f1427a.r().getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.crashlytics.android.c.u.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                if (objArr.length != 4) {
                    throw new RuntimeException("Unexpected AppMeasurement.OnEventListener signature");
                }
                String str = (String) objArr[0];
                String str2 = (String) objArr[1];
                Bundle bundle = (Bundle) objArr[2];
                if (str == null || str.equals("crash")) {
                    return null;
                }
                u.b(u.this.f1427a, str2, bundle);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(l lVar, String str, Bundle bundle) {
        try {
            lVar.a("$A$:" + a(str, bundle));
        } catch (JSONException unused) {
            io.fabric.sdk.android.c.g().d("CrashlyticsCore", "Unable to serialize Firebase Analytics event; " + str);
        }
    }

    private static String a(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }
}
