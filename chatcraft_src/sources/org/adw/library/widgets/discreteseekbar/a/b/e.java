package org.adw.library.widgets.discreteseekbar.a.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: TrackRectDrawable.java */
/* loaded from: classes.dex */
public class e extends c {
    public e(ColorStateList colorStateList) {
        super(colorStateList);
    }

    @Override // org.adw.library.widgets.discreteseekbar.a.b.c
    void a(Canvas canvas, Paint paint) {
        canvas.drawRect(getBounds(), paint);
    }
}
