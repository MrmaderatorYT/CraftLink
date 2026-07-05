package androidx.i;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
class ad {

    /* renamed from: a, reason: collision with root package name */
    static final Property<View, Float> f803a;

    /* renamed from: b, reason: collision with root package name */
    static final Property<View, Rect> f804b;
    private static final ah c;
    private static Field d;
    private static boolean e;

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            c = new ag();
        } else if (Build.VERSION.SDK_INT >= 21) {
            c = new af();
        } else if (Build.VERSION.SDK_INT >= 19) {
            c = new ae();
        } else {
            c = new ah();
        }
        f803a = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.i.ad.1
            @Override // android.util.Property
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(View view) {
                return Float.valueOf(ad.c(view));
            }

            @Override // android.util.Property
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(View view, Float f) {
                ad.a(view, f.floatValue());
            }
        };
        f804b = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.i.ad.2
            @Override // android.util.Property
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Rect get(View view) {
                return androidx.core.g.q.z(view);
            }

            @Override // android.util.Property
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void set(View view, Rect rect) {
                androidx.core.g.q.a(view, rect);
            }
        };
    }

    static ac a(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ab(view);
        }
        return aa.d(view);
    }

    static al b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ak(view);
        }
        return new aj(view.getWindowToken());
    }

    static void a(View view, float f) {
        c.a(view, f);
    }

    static float c(View view) {
        return c.a(view);
    }

    static void d(View view) {
        c.b(view);
    }

    static void e(View view) {
        c.c(view);
    }

    static void a(View view, int i) throws IllegalAccessException, IllegalArgumentException {
        a();
        if (d != null) {
            try {
                d.setInt(view, i | (d.getInt(view) & (-13)));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    static void a(View view, Matrix matrix) {
        c.a(view, matrix);
    }

    static void b(View view, Matrix matrix) {
        c.b(view, matrix);
    }

    static void a(View view, int i, int i2, int i3, int i4) {
        c.a(view, i, i2, i3, i4);
    }

    private static void a() {
        if (e) {
            return;
        }
        try {
            d = View.class.getDeclaredField("mViewFlags");
            d.setAccessible(true);
        } catch (NoSuchFieldException unused) {
            Log.i("ViewUtils", "fetchViewFlagsField: ");
        }
        e = true;
    }
}
