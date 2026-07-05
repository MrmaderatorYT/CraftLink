package androidx.i;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi22.java */
/* loaded from: classes.dex */
class ag extends af {

    /* renamed from: a, reason: collision with root package name */
    private static Method f809a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f810b;

    ag() {
    }

    @Override // androidx.i.ah
    public void a(View view, int i, int i2, int i3, int i4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a();
        if (f809a != null) {
            try {
                f809a.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    private void a() {
        if (f810b) {
            return;
        }
        try {
            f809a = View.class.getDeclaredMethod("setLeftTopRightBottom", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            f809a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e);
        }
        f810b = true;
    }
}
