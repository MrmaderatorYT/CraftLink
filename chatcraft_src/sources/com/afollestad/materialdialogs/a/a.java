package com.afollestad.materialdialogs.a;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.afollestad.materialdialogs.e;
import com.afollestad.materialdialogs.f;

/* compiled from: DialogUtils.java */
/* loaded from: classes.dex */
public class a {
    public static int a(Context context) {
        return a(a(a(context, R.attr.textColorPrimary)) ? -16777216 : -1, 0.3f);
    }

    public static int a(int i, float f) {
        return Color.argb(Math.round(Color.alpha(i) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public static int a(Context context, int i) {
        return a(context, i, 0);
    }

    public static int a(Context context, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return typedArrayObtainStyledAttributes.getColor(0, i2);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList a(Context context, int i, ColorStateList colorStateList) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(0);
            if (typedValuePeekValue == null) {
                return colorStateList;
            }
            if (typedValuePeekValue.type >= 28 && typedValuePeekValue.type <= 31) {
                return h(context, typedValuePeekValue.data);
            }
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(0);
            return colorStateList2 != null ? colorStateList2 : colorStateList;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList b(Context context, int i) throws Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        if (typedValue.type >= 28 && typedValue.type <= 31) {
            return h(context, typedValue.data);
        }
        if (Build.VERSION.SDK_INT <= 22) {
            return context.getResources().getColorStateList(i);
        }
        return context.getColorStateList(i);
    }

    public static int c(Context context, int i) {
        return androidx.core.a.a.c(context, i);
    }

    public static String d(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return (String) typedValue.string;
    }

    private static int a(e eVar) {
        switch (eVar) {
            case CENTER:
                return 1;
            case END:
                return 2;
            default:
                return 0;
        }
    }

    public static e a(Context context, int i, e eVar) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            switch (typedArrayObtainStyledAttributes.getInt(0, a(eVar))) {
                case 1:
                    return e.CENTER;
                case 2:
                    return e.END;
                default:
                    return e.START;
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static Drawable e(Context context, int i) {
        return a(context, i, (Drawable) null);
    }

    private static Drawable a(Context context, int i, Drawable drawable) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(0);
            if (drawable2 == null && drawable != null) {
                drawable2 = drawable;
            }
            return drawable2;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int f(Context context, int i) {
        return b(context, i, -1);
    }

    private static int b(Context context, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i2);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static boolean a(Context context, int i, boolean z) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return typedArrayObtainStyledAttributes.getBoolean(0, z);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static boolean g(Context context, int i) {
        return a(context, i, false);
    }

    public static boolean a(int i) {
        double dRed = Color.red(i);
        Double.isNaN(dRed);
        double dGreen = Color.green(i);
        Double.isNaN(dGreen);
        double d = (dRed * 0.299d) + (dGreen * 0.587d);
        double dBlue = Color.blue(i);
        Double.isNaN(dBlue);
        return 1.0d - ((d + (dBlue * 0.114d)) / 255.0d) >= 0.5d;
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    public static void a(DialogInterface dialogInterface, final f.a aVar) {
        final f fVar = (f) dialogInterface;
        if (fVar.g() == null) {
            return;
        }
        fVar.g().post(new Runnable() { // from class: com.afollestad.materialdialogs.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                fVar.g().requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) aVar.a().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(fVar.g(), 1);
                }
            }
        });
    }

    public static void b(DialogInterface dialogInterface, f.a aVar) {
        InputMethodManager inputMethodManager;
        f fVar = (f) dialogInterface;
        if (fVar.g() == null || (inputMethodManager = (InputMethodManager) aVar.a().getSystemService("input_method")) == null) {
            return;
        }
        View currentFocus = fVar.getCurrentFocus();
        IBinder windowToken = null;
        if (currentFocus != null) {
            windowToken = currentFocus.getWindowToken();
        } else if (fVar.f() != null) {
            windowToken = fVar.f().getWindowToken();
        }
        if (windowToken != null) {
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        }
    }

    public static ColorStateList h(Context context, int i) {
        int iA = a(context, R.attr.textColorPrimary);
        if (i != 0) {
            iA = i;
        }
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[0]}, new int[]{a(iA, 0.4f), iA});
    }

    public static <T> boolean a(T t, T[] tArr) {
        if (tArr == null || tArr.length == 0) {
            return false;
        }
        for (T t2 : tArr) {
            if (t2.equals(t)) {
                return true;
            }
        }
        return false;
    }
}
