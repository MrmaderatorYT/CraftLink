package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.b;

/* compiled from: ActionBar.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: ActionBar.java */
    public interface b {
        void a(boolean z);
    }

    /* compiled from: ActionBar.java */
    @Deprecated
    public static abstract class c {
        public abstract Drawable a();

        public abstract CharSequence b();

        public abstract View c();

        public abstract void d();

        public abstract CharSequence e();
    }

    public abstract int a();

    public androidx.appcompat.view.b a(b.a aVar) {
        return null;
    }

    public void a(Configuration configuration) {
    }

    public void a(CharSequence charSequence) {
    }

    public abstract void a(boolean z);

    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public Context b() {
        return null;
    }

    public abstract void b(boolean z);

    public void c(boolean z) {
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public void e(boolean z) {
    }

    public boolean e() {
        return false;
    }

    public void f(boolean z) {
    }

    public boolean f() {
        return false;
    }

    void g() {
    }

    public void g(boolean z) {
    }

    public void d(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    /* compiled from: ActionBar.java */
    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0021a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f115a;

        public C0021a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f115a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionBarLayout);
            this.f115a = typedArrayObtainStyledAttributes.getInt(a.j.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0021a(int i, int i2) {
            super(i, i2);
            this.f115a = 0;
            this.f115a = 8388627;
        }

        public C0021a(C0021a c0021a) {
            super((ViewGroup.MarginLayoutParams) c0021a);
            this.f115a = 0;
            this.f115a = c0021a.f115a;
        }

        public C0021a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f115a = 0;
        }
    }
}
