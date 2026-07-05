package com.afollestad.materialdialogs.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;

/* compiled from: RippleHelper.java */
@TargetApi(21)
/* loaded from: classes.dex */
public class b {
    public static void a(Drawable drawable, int i) {
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(ColorStateList.valueOf(i));
        }
    }
}
