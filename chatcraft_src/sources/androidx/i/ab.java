package androidx.i;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18.java */
/* loaded from: classes.dex */
class ab implements ac {

    /* renamed from: a, reason: collision with root package name */
    private final ViewOverlay f802a;

    ab(View view) {
        this.f802a = view.getOverlay();
    }

    @Override // androidx.i.ac
    public void a(Drawable drawable) {
        this.f802a.add(drawable);
    }

    @Override // androidx.i.ac
    public void b(Drawable drawable) {
        this.f802a.remove(drawable);
    }
}
