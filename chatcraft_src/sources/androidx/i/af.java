package androidx.i;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
class af extends ae {

    /* renamed from: a, reason: collision with root package name */
    private static Method f807a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f808b;
    private static Method c;
    private static boolean d;

    af() {
    }

    @Override // androidx.i.ah
    public void a(View view, Matrix matrix) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a();
        if (f807a != null) {
            try {
                f807a.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Override // androidx.i.ah
    public void b(View view, Matrix matrix) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        b();
        if (c != null) {
            try {
                c.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    private void a() {
        if (f808b) {
            return;
        }
        try {
            f807a = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            f807a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e);
        }
        f808b = true;
    }

    private void b() {
        if (d) {
            return;
        }
        try {
            c = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            c.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e);
        }
        d = true;
    }
}
