package org.adw.library.widgets.discreteseekbar.a.a;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;

/* compiled from: SeekBarCompat.java */
/* loaded from: classes.dex */
public class c {
    public static void a(View view, org.adw.library.widgets.discreteseekbar.a.b.b bVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            d.a(view, bVar);
        }
    }

    public static Drawable a(ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            return d.a(colorStateList);
        }
        return new org.adw.library.widgets.discreteseekbar.a.b.a(colorStateList);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            ((RippleDrawable) drawable).setColor(colorStateList);
        } else {
            ((org.adw.library.widgets.discreteseekbar.a.b.a) drawable).a(colorStateList);
        }
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 21) {
            int i5 = (i3 - i) / 8;
            androidx.core.graphics.drawable.a.a(drawable, i + i5, i2 + i5, i3 - i5, i4 - i5);
        } else {
            drawable.setBounds(i, i2, i3, i4);
        }
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            d.a(view, drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void a(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            d.a(textView, i);
        }
    }

    public static boolean a(ViewParent viewParent) {
        if (Build.VERSION.SDK_INT >= 14) {
            return d.a(viewParent);
        }
        return false;
    }

    public static boolean a(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            return d.a(view);
        }
        return false;
    }
}
