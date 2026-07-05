package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* compiled from: VectorEnabledTintResources.java */
/* loaded from: classes.dex */
public class ax extends Resources {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f381a = false;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f382b;

    public static boolean a() {
        return b() && Build.VERSION.SDK_INT <= 20;
    }

    public ax(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f382b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Context context = this.f382b.get();
        if (context != null) {
            return j.a().a(context, this, i);
        }
        return super.getDrawable(i);
    }

    final Drawable a(int i) {
        return super.getDrawable(i);
    }

    public static boolean b() {
        return f381a;
    }
}
