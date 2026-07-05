package com.afollestad.materialdialogs.internal;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.k;
import com.afollestad.materialdialogs.g;
import java.lang.reflect.Field;

/* compiled from: MDTintHelper.java */
@SuppressLint({"PrivateResource"})
/* loaded from: classes.dex */
public class c {
    public static void a(RadioButton radioButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 22) {
            radioButton.setButtonTintList(colorStateList);
            return;
        }
        Drawable drawableG = androidx.core.graphics.drawable.a.g(androidx.core.a.a.a(radioButton.getContext(), g.d.abc_btn_radio_material));
        androidx.core.graphics.drawable.a.a(drawableG, colorStateList);
        radioButton.setButtonDrawable(drawableG);
    }

    public static void a(RadioButton radioButton, int i) {
        int iA = com.afollestad.materialdialogs.a.a.a(radioButton.getContext());
        a(radioButton, new ColorStateList(new int[][]{new int[]{R.attr.state_enabled, -16842912}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{-16842910, -16842912}, new int[]{-16842910, R.attr.state_checked}}, new int[]{com.afollestad.materialdialogs.a.a.a(radioButton.getContext(), g.a.colorControlNormal), i, iA, iA}));
    }

    public static void a(CheckBox checkBox, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 22) {
            checkBox.setButtonTintList(colorStateList);
            return;
        }
        Drawable drawableG = androidx.core.graphics.drawable.a.g(androidx.core.a.a.a(checkBox.getContext(), g.d.abc_btn_check_material));
        androidx.core.graphics.drawable.a.a(drawableG, colorStateList);
        checkBox.setButtonDrawable(drawableG);
    }

    public static void a(CheckBox checkBox, int i) {
        int iA = com.afollestad.materialdialogs.a.a.a(checkBox.getContext());
        a(checkBox, new ColorStateList(new int[][]{new int[]{R.attr.state_enabled, -16842912}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{-16842910, -16842912}, new int[]{-16842910, R.attr.state_checked}}, new int[]{com.afollestad.materialdialogs.a.a.a(checkBox.getContext(), g.a.colorControlNormal), i, iA, iA}));
    }

    public static void a(ProgressBar progressBar, int i) {
        a(progressBar, i, false);
    }

    private static void a(ProgressBar progressBar, int i, boolean z) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        if (Build.VERSION.SDK_INT >= 21) {
            progressBar.setProgressTintList(colorStateListValueOf);
            progressBar.setSecondaryProgressTintList(colorStateListValueOf);
            if (z) {
                return;
            }
            progressBar.setIndeterminateTintList(colorStateListValueOf);
            return;
        }
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (Build.VERSION.SDK_INT <= 10) {
            mode = PorterDuff.Mode.MULTIPLY;
        }
        if (!z && progressBar.getIndeterminateDrawable() != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(i, mode);
        }
        if (progressBar.getProgressDrawable() != null) {
            progressBar.getProgressDrawable().setColorFilter(i, mode);
        }
    }

    private static ColorStateList a(Context context, int i) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{-16842919, -16842908}, new int[0]}, new int[]{com.afollestad.materialdialogs.a.a.a(context, g.a.colorControlNormal), com.afollestad.materialdialogs.a.a.a(context, g.a.colorControlNormal), i});
    }

    public static void a(EditText editText, int i) {
        ColorStateList colorStateListA = a(editText.getContext(), i);
        if (editText instanceof k) {
            ((k) editText).setSupportBackgroundTintList(colorStateListA);
        } else if (Build.VERSION.SDK_INT >= 21) {
            editText.setBackgroundTintList(colorStateListA);
        }
        b(editText, i);
    }

    private static void b(EditText editText, int i) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable[] drawableArr = {androidx.core.a.a.a(editText.getContext(), i2), androidx.core.a.a.a(editText.getContext(), i2)};
            drawableArr[0].setColorFilter(i, PorterDuff.Mode.SRC_IN);
            drawableArr[1].setColorFilter(i, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, drawableArr);
        } catch (NoSuchFieldException e) {
            Log.d("MDTintHelper", "Device issue with cursor tinting: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
