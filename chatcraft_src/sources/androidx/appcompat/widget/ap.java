package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper.java */
/* loaded from: classes.dex */
public class ap extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f362a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<WeakReference<ap>> f363b;
    private final Resources c;
    private final Resources.Theme d;

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (f362a) {
            if (f363b == null) {
                f363b = new ArrayList<>();
            } else {
                for (int size = f363b.size() - 1; size >= 0; size--) {
                    WeakReference<ap> weakReference = f363b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f363b.remove(size);
                    }
                }
                for (int size2 = f363b.size() - 1; size2 >= 0; size2--) {
                    WeakReference<ap> weakReference2 = f363b.get(size2);
                    ap apVar = weakReference2 != null ? weakReference2.get() : null;
                    if (apVar != null && apVar.getBaseContext() == context) {
                        return apVar;
                    }
                }
            }
            ap apVar2 = new ap(context);
            f363b.add(new WeakReference<>(apVar2));
            return apVar2;
        }
    }

    private static boolean b(Context context) {
        if ((context instanceof ap) || (context.getResources() instanceof ar) || (context.getResources() instanceof ax)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || ax.a();
    }

    private ap(Context context) {
        super(context);
        if (ax.a()) {
            this.c = new ax(this, context.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(context.getTheme());
        } else {
            this.c = new ar(this, context.getResources());
            this.d = null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.d == null ? super.getTheme() : this.d;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.d == null) {
            super.setTheme(i);
        } else {
            this.d.applyStyle(i, true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.c.getAssets();
    }
}
