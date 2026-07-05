package androidx.i;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18.java */
/* loaded from: classes.dex */
class v implements w {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f869a;

    v(ViewGroup viewGroup) {
        this.f869a = viewGroup.getOverlay();
    }

    @Override // androidx.i.ac
    public void a(Drawable drawable) {
        this.f869a.add(drawable);
    }

    @Override // androidx.i.ac
    public void b(Drawable drawable) {
        this.f869a.remove(drawable);
    }

    @Override // androidx.i.w
    public void a(View view) {
        this.f869a.add(view);
    }

    @Override // androidx.i.w
    public void b(View view) {
        this.f869a.remove(view);
    }
}
