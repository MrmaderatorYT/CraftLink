package androidx.core.g;

import android.os.Build;
import android.view.WindowInsets;

/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private final Object f652a;

    private y(Object obj) {
        this.f652a = obj;
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f652a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f652a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f652a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f652a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f652a).isConsumed();
        }
        return false;
    }

    public y a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new y(((WindowInsets) this.f652a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        return this.f652a == null ? yVar.f652a == null : this.f652a.equals(yVar.f652a);
    }

    public int hashCode() {
        if (this.f652a == null) {
            return 0;
        }
        return this.f652a.hashCode();
    }

    static y a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new y(obj);
    }

    static Object a(y yVar) {
        if (yVar == null) {
            return null;
        }
        return yVar.f652a;
    }
}
