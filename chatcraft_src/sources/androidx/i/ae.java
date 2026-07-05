package androidx.i;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
class ae extends ah {

    /* renamed from: a, reason: collision with root package name */
    private static Method f805a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f806b;
    private static Method c;
    private static boolean d;

    @Override // androidx.i.ah
    public void b(View view) {
    }

    @Override // androidx.i.ah
    public void c(View view) {
    }

    ae() {
    }

    @Override // androidx.i.ah
    public void a(View view, float f) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a();
        if (f805a != null) {
            try {
                f805a.invoke(view, Float.valueOf(f));
                return;
            } catch (IllegalAccessException unused) {
                return;
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        view.setAlpha(f);
    }

    @Override // androidx.i.ah
    public float a(View view) {
        b();
        if (c != null) {
            try {
                return ((Float) c.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return super.a(view);
    }

    private void a() {
        if (f806b) {
            return;
        }
        try {
            f805a = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
            f805a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
        }
        f806b = true;
    }

    private void b() {
        if (d) {
            return;
        }
        try {
            c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
            c.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
        }
        d = true;
    }
}
