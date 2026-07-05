package com.afollestad.materialdialogs.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import com.afollestad.materialdialogs.e;
import com.afollestad.materialdialogs.g;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class MDButton extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1224a;

    /* renamed from: b, reason: collision with root package name */
    private e f1225b;
    private int c;
    private Drawable d;
    private Drawable e;

    public MDButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1224a = false;
        a(context);
    }

    public MDButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1224a = false;
        a(context);
    }

    private void a(Context context) {
        this.c = context.getResources().getDimensionPixelSize(g.c.md_dialog_frame_margin);
        this.f1225b = e.END;
    }

    void a(boolean z, boolean z2) {
        if (this.f1224a != z || z2) {
            setGravity(z ? this.f1225b.a() | 16 : 17);
            if (Build.VERSION.SDK_INT >= 17) {
                setTextAlignment(z ? this.f1225b.b() : 4);
            }
            com.afollestad.materialdialogs.a.a.a(this, z ? this.d : this.e);
            if (z) {
                setPadding(this.c, getPaddingTop(), this.c, getPaddingBottom());
            }
            this.f1224a = z;
        }
    }

    public void setStackedGravity(e eVar) {
        this.f1225b = eVar;
    }

    public void setStackedSelector(Drawable drawable) {
        this.d = drawable;
        if (this.f1224a) {
            a(true, true);
        }
    }

    public void setDefaultSelector(Drawable drawable) {
        this.e = drawable;
        if (this.f1224a) {
            return;
        }
        a(false, true);
    }

    public void setAllCapsCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 14) {
            setAllCaps(z);
        } else if (z) {
            setTransformationMethod(new a(getContext()));
        } else {
            setTransformationMethod(null);
        }
    }
}
