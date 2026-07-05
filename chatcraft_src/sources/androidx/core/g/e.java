package androidx.core.g;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* compiled from: LayoutInflaterCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static Field f632a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f633b;

    private static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) throws IllegalAccessException, IllegalArgumentException {
        if (!f633b) {
            try {
                f632a = LayoutInflater.class.getDeclaredField("mFactory2");
                f632a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f633b = true;
        }
        if (f632a != null) {
            try {
                f632a.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) throws IllegalAccessException, IllegalArgumentException {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                b(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                b(layoutInflater, factory2);
            }
        }
    }
}
