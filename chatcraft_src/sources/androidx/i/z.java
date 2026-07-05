package androidx.i;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtilsApi18.java */
/* loaded from: classes.dex */
class z {

    /* renamed from: a, reason: collision with root package name */
    private static Method f872a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f873b;

    static void a(ViewGroup viewGroup, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a();
        if (f872a != null) {
            try {
                f872a.invoke(viewGroup, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e);
            } catch (InvocationTargetException e2) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e2);
            }
        }
    }

    private static void a() {
        if (f873b) {
            return;
        }
        try {
            f872a = ViewGroup.class.getDeclaredMethod("suppressLayout", Boolean.TYPE);
            f872a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
        }
        f873b = true;
    }
}
