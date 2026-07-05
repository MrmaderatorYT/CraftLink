package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: BundleCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* compiled from: BundleCompat.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Method f543a;

        /* renamed from: b, reason: collision with root package name */
        private static boolean f544b;
        private static Method c;
        private static boolean d;

        public static IBinder a(Bundle bundle, String str) {
            if (!f544b) {
                try {
                    f543a = Bundle.class.getMethod("getIBinder", String.class);
                    f543a.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", e);
                }
                f544b = true;
            }
            if (f543a != null) {
                try {
                    return (IBinder) f543a.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", e2);
                    f543a = null;
                }
            }
            return null;
        }

        public static void a(Bundle bundle, String str, IBinder iBinder) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (!d) {
                try {
                    c = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    c.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("BundleCompatBaseImpl", "Failed to retrieve putIBinder method", e);
                }
                d = true;
            }
            if (c != null) {
                try {
                    c.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i("BundleCompatBaseImpl", "Failed to invoke putIBinder via reflection", e2);
                    c = null;
                }
            }
        }
    }

    public static IBinder a(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return a.a(bundle, str);
    }

    public static void a(Bundle bundle, String str, IBinder iBinder) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            a.a(bundle, str, iBinder);
        }
    }
}
