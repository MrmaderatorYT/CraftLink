package com.google.android.material.c.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.cardview.widget.CardView;
import com.google.android.material.c.c;
import com.google.android.material.c.d;

/* compiled from: CircularRevealCardView.java */
/* loaded from: classes.dex */
public class a extends CardView implements d {
    private final c e;

    @Override // com.google.android.material.c.d
    public void a() {
        this.e.a();
    }

    @Override // com.google.android.material.c.d
    public void b() {
        this.e.b();
    }

    @Override // com.google.android.material.c.d
    public void setRevealInfo(d.C0083d c0083d) {
        this.e.a(c0083d);
    }

    @Override // com.google.android.material.c.d
    public d.C0083d getRevealInfo() {
        return this.e.c();
    }

    @Override // com.google.android.material.c.d
    public void setCircularRevealScrimColor(int i) {
        this.e.a(i);
    }

    @Override // com.google.android.material.c.d
    public int getCircularRevealScrimColor() {
        return this.e.d();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.e.e();
    }

    @Override // com.google.android.material.c.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.e.a(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.e != null) {
            this.e.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.c.c.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    public boolean isOpaque() {
        if (this.e != null) {
            return this.e.f();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.c.c.a
    public boolean c() {
        return super.isOpaque();
    }
}
