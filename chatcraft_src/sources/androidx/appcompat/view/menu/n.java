package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.o;

/* compiled from: MenuPopupHelper.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f249a;

    /* renamed from: b, reason: collision with root package name */
    private final h f250b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private o.a i;
    private m j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    public n(Context context, h hVar, View view, boolean z, int i) {
        this(context, hVar, view, z, i, 0);
    }

    public n(Context context, h hVar, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.n.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                n.this.e();
            }
        };
        this.f249a = context;
        this.f250b = hVar;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void a(View view) {
        this.f = view;
    }

    public void a(boolean z) {
        this.h = z;
        if (this.j != null) {
            this.j.b(z);
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void a() {
        if (!c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public m b() {
        if (this.j == null) {
            this.j = g();
        }
        return this.j;
    }

    public boolean c() {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public boolean a(int i, int i2) {
        if (f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    private m g() {
        m tVar;
        Display defaultDisplay = ((WindowManager) this.f249a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f249a.getResources().getDimensionPixelSize(a.d.abc_cascading_menus_min_smallest_width)) {
            tVar = new e(this.f249a, this.f, this.d, this.e, this.c);
        } else {
            tVar = new t(this.f249a, this.f250b, this.f, this.d, this.e, this.c);
        }
        tVar.a(this.f250b);
        tVar.a(this.l);
        tVar.a(this.f);
        tVar.a(this.i);
        tVar.b(this.h);
        tVar.a(this.g);
        return tVar;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        m mVarB = b();
        mVarB.c(z2);
        if (z) {
            if ((androidx.core.g.c.a(this.g, androidx.core.g.q.f(this.f)) & 7) == 5) {
                i -= this.f.getWidth();
            }
            mVarB.b(i);
            mVarB.c(i2);
            int i3 = (int) ((this.f249a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            mVarB.a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        mVarB.a();
    }

    public void d() {
        if (f()) {
            this.j.c();
        }
    }

    protected void e() {
        this.j = null;
        if (this.k != null) {
            this.k.onDismiss();
        }
    }

    public boolean f() {
        return this.j != null && this.j.d();
    }

    public void a(o.a aVar) {
        this.i = aVar;
        if (this.j != null) {
            this.j.a(aVar);
        }
    }
}
