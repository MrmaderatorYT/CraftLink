package androidx.core.g;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f626a;

    /* renamed from: b, reason: collision with root package name */
    private a f627b;
    private InterfaceC0041b c;

    /* compiled from: ActionProvider.java */
    public interface a {
        void d(boolean z);
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.g.b$b, reason: collision with other inner class name */
    public interface InterfaceC0041b {
        void a(boolean z);
    }

    public abstract View a();

    public void a(SubMenu subMenu) {
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return true;
    }

    public b(Context context) {
        this.f626a = context;
    }

    public View a(MenuItem menuItem) {
        return a();
    }

    public void a(boolean z) {
        if (this.f627b != null) {
            this.f627b.d(z);
        }
    }

    public void a(a aVar) {
        this.f627b = aVar;
    }

    public void a(InterfaceC0041b interfaceC0041b) {
        if (this.c != null && interfaceC0041b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = interfaceC0041b;
    }

    public void f() {
        this.c = null;
        this.f627b = null;
    }
}
