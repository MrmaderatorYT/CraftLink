package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources.java */
/* loaded from: classes.dex */
class ar extends aj {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Context> f366a;

    public ar(Context context, Resources resources) {
        super(resources);
        this.f366a = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.aj, android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f366a.get();
        if (drawable != null && context != null) {
            j.a();
            j.a(context, i, drawable);
        }
        return drawable;
    }
}
