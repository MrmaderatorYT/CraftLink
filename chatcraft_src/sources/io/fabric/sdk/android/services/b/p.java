package io.fabric.sdk.android.services.b;

import android.content.Context;
import java.lang.reflect.Method;

/* compiled from: FirebaseAppImpl.java */
/* loaded from: classes.dex */
final class p implements o {

    /* renamed from: a, reason: collision with root package name */
    private final Method f4227a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f4228b;

    public static o a(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.google.firebase.FirebaseApp");
            return new p(clsLoadClass, clsLoadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(clsLoadClass, new Object[0]));
        } catch (ClassNotFoundException unused) {
            io.fabric.sdk.android.c.g().a("Fabric", "Could not find class: com.google.firebase.FirebaseApp");
            return null;
        } catch (NoSuchMethodException e) {
            io.fabric.sdk.android.c.g().a("Fabric", "Could not find method: " + e.getMessage());
            return null;
        } catch (Exception e2) {
            io.fabric.sdk.android.c.g().a("Fabric", "Unexpected error loading FirebaseApp instance.", e2);
            return null;
        }
    }

    private p(Class cls, Object obj) {
        this.f4228b = obj;
        this.f4227a = cls.getDeclaredMethod("isDataCollectionDefaultEnabled", new Class[0]);
    }

    @Override // io.fabric.sdk.android.services.b.o
    public boolean a() {
        try {
            return ((Boolean) this.f4227a.invoke(this.f4228b, new Object[0])).booleanValue();
        } catch (Exception e) {
            io.fabric.sdk.android.c.g().a("Fabric", "Cannot check isDataCollectionDefaultEnabled on FirebaseApp.", e);
            return false;
        }
    }
}
