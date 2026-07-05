package androidx.appcompat.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.j;
import java.util.WeakHashMap;

/* compiled from: AppCompatResources.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f85a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0019a>> f86b = new WeakHashMap<>(0);
    private static final Object c = new Object();

    public static ColorStateList a(Context context, int i) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList colorStateListD = d(context, i);
        if (colorStateListD != null) {
            return colorStateListD;
        }
        ColorStateList colorStateListC = c(context, i);
        if (colorStateListC != null) {
            a(context, i, colorStateListC);
            return colorStateListC;
        }
        return androidx.core.a.a.b(context, i);
    }

    public static Drawable b(Context context, int i) {
        return j.a().a(context, i);
    }

    private static ColorStateList c(Context context, int i) throws Resources.NotFoundException {
        if (e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return androidx.core.a.a.a.a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static ColorStateList d(Context context, int i) {
        C0019a c0019a;
        synchronized (c) {
            SparseArray<C0019a> sparseArray = f86b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (c0019a = sparseArray.get(i)) != null) {
                if (c0019a.f88b.equals(context.getResources().getConfiguration())) {
                    return c0019a.f87a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    private static void a(Context context, int i, ColorStateList colorStateList) {
        synchronized (c) {
            SparseArray<C0019a> sparseArray = f86b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f86b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0019a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static boolean e(Context context, int i) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        TypedValue typedValueA = a();
        resources.getValue(i, typedValueA, true);
        return typedValueA.type >= 28 && typedValueA.type <= 31;
    }

    private static TypedValue a() {
        TypedValue typedValue = f85a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f85a.set(typedValue2);
        return typedValue2;
    }

    /* compiled from: AppCompatResources.java */
    /* renamed from: androidx.appcompat.a.a.a$a, reason: collision with other inner class name */
    private static class C0019a {

        /* renamed from: a, reason: collision with root package name */
        final ColorStateList f87a;

        /* renamed from: b, reason: collision with root package name */
        final Configuration f88b;

        C0019a(ColorStateList colorStateList, Configuration configuration) {
            this.f87a = colorStateList;
            this.f88b = configuration;
        }
    }
}
