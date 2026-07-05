package com.google.android.material.g;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;

/* compiled from: RippleUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f3801a;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f3802b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private static final int[] j;

    static {
        f3801a = Build.VERSION.SDK_INT >= 21;
        f3802b = new int[]{R.attr.state_pressed};
        c = new int[]{R.attr.state_hovered, R.attr.state_focused};
        d = new int[]{R.attr.state_focused};
        e = new int[]{R.attr.state_hovered};
        f = new int[]{R.attr.state_selected, R.attr.state_pressed};
        g = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        h = new int[]{R.attr.state_selected, R.attr.state_focused};
        i = new int[]{R.attr.state_selected, R.attr.state_hovered};
        j = new int[]{R.attr.state_selected};
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f3801a) {
            return new ColorStateList(new int[][]{j, StateSet.NOTHING}, new int[]{a(colorStateList, f), a(colorStateList, f3802b)});
        }
        return new ColorStateList(new int[][]{f, g, h, i, j, f3802b, c, d, e, StateSet.NOTHING}, new int[]{a(colorStateList, f), a(colorStateList, g), a(colorStateList, h), a(colorStateList, i), 0, a(colorStateList, f3802b), a(colorStateList, c), a(colorStateList, d), a(colorStateList, e), 0});
    }

    private static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f3801a ? a(colorForState) : colorForState;
    }

    @TargetApi(21)
    private static int a(int i2) {
        return androidx.core.graphics.a.b(i2, Math.min(Color.alpha(i2) * 2, 255));
    }
}
