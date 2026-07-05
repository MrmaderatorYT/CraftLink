package com.google.android.material.c;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.google.android.material.c.d;

/* compiled from: CircularRevealFrameLayout.java */
/* loaded from: classes.dex */
public class b extends FrameLayout implements d {

    /* renamed from: a, reason: collision with root package name */
    private final c f3770a;

    @Override // com.google.android.material.c.d
    public void a() {
        this.f3770a.a();
    }

    @Override // com.google.android.material.c.d
    public void b() {
        this.f3770a.b();
    }

    @Override // com.google.android.material.c.d
    public d.C0083d getRevealInfo() {
        return this.f3770a.c();
    }

    @Override // com.google.android.material.c.d
    public void setRevealInfo(d.C0083d c0083d) {
        this.f3770a.a(c0083d);
    }

    @Override // com.google.android.material.c.d
    public int getCircularRevealScrimColor() {
        return this.f3770a.d();
    }

    @Override // com.google.android.material.c.d
    public void setCircularRevealScrimColor(int i) {
        this.f3770a.a(i);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f3770a.e();
    }

    @Override // com.google.android.material.c.d
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f3770a.a(drawable);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        if (this.f3770a != null) {
            this.f3770a.a(canvas);
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
        if (this.f3770a != null) {
            return this.f3770a.f();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.c.c.a
    public boolean c() {
        return super.isOpaque();
    }
}
