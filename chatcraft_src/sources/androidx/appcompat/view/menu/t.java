package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.ai;

/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
final class t extends m implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, o {
    private static final int e = a.g.abc_popup_menu_item_layout;

    /* renamed from: a, reason: collision with root package name */
    final ai f252a;
    View c;
    ViewTreeObserver d;
    private final Context f;
    private final h g;
    private final g h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private PopupWindow.OnDismissListener n;
    private View o;
    private o.a p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean u;

    /* renamed from: b, reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f253b = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.t.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!t.this.d() || t.this.f252a.g()) {
                return;
            }
            View view = t.this.c;
            if (view == null || !view.isShown()) {
                t.this.c();
            } else {
                t.this.f252a.a();
            }
        }
    };
    private final View.OnAttachStateChangeListener m = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.t.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (t.this.d != null) {
                if (!t.this.d.isAlive()) {
                    t.this.d = view.getViewTreeObserver();
                }
                t.this.d.removeGlobalOnLayoutListener(t.this.f253b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int t = 0;

    @Override // androidx.appcompat.view.menu.m
    public void a(h hVar) {
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean b() {
        return false;
    }

    public t(Context context, h hVar, View view, int i, int i2, boolean z) {
        this.f = context;
        this.g = hVar;
        this.i = z;
        this.h = new g(hVar, LayoutInflater.from(context), this.i, e);
        this.k = i;
        this.l = i2;
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.o = view;
        this.f252a = new ai(this.f, null, this.k, this.l);
        hVar.a(this, context);
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(boolean z) {
        this.h.a(z);
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(int i) {
        this.t = i;
    }

    private boolean h() {
        if (d()) {
            return true;
        }
        if (this.q || this.o == null) {
            return false;
        }
        this.c = this.o;
        this.f252a.a((PopupWindow.OnDismissListener) this);
        this.f252a.a((AdapterView.OnItemClickListener) this);
        this.f252a.a(true);
        View view = this.c;
        boolean z = this.d == null;
        this.d = view.getViewTreeObserver();
        if (z) {
            this.d.addOnGlobalLayoutListener(this.f253b);
        }
        view.addOnAttachStateChangeListener(this.m);
        this.f252a.b(view);
        this.f252a.e(this.t);
        if (!this.r) {
            this.s = a(this.h, null, this.f, this.j);
            this.r = true;
        }
        this.f252a.g(this.s);
        this.f252a.h(2);
        this.f252a.a(g());
        this.f252a.a();
        ListView listViewE = this.f252a.e();
        listViewE.setOnKeyListener(this);
        if (this.u && this.g.n() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) listViewE, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.g.n());
            }
            frameLayout.setEnabled(false);
            listViewE.addHeaderView(frameLayout, null, false);
        }
        this.f252a.a((ListAdapter) this.h);
        this.f252a.a();
        return true;
    }

    @Override // androidx.appcompat.view.menu.s
    public void a() {
        if (!h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.s
    public void c() {
        if (d()) {
            this.f252a.c();
        }
    }

    @Override // androidx.appcompat.view.menu.s
    public boolean d() {
        return !this.q && this.f252a.d();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.q = true;
        this.g.close();
        if (this.d != null) {
            if (!this.d.isAlive()) {
                this.d = this.c.getViewTreeObserver();
            }
            this.d.removeGlobalOnLayoutListener(this.f253b);
            this.d = null;
        }
        this.c.removeOnAttachStateChangeListener(this.m);
        if (this.n != null) {
            this.n.onDismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(boolean z) {
        this.r = false;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(o.a aVar) {
        this.p = aVar;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean a(u uVar) {
        if (uVar.hasVisibleItems()) {
            n nVar = new n(this.f, uVar, this.c, this.i, this.k, this.l);
            nVar.a(this.p);
            nVar.a(m.b(uVar));
            nVar.a(this.n);
            this.n = null;
            this.g.a(false);
            int iJ = this.f252a.j();
            int iK = this.f252a.k();
            if ((Gravity.getAbsoluteGravity(this.t, androidx.core.g.q.f(this.o)) & 7) == 5) {
                iJ += this.o.getWidth();
            }
            if (nVar.a(iJ, iK)) {
                if (this.p == null) {
                    return true;
                }
                this.p.a(uVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(h hVar, boolean z) {
        if (hVar != this.g) {
            return;
        }
        c();
        if (this.p != null) {
            this.p.a(hVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(View view) {
        this.o = view;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        c();
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.s
    public ListView e() {
        return this.f252a.e();
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(int i) {
        this.f252a.c(i);
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(int i) {
        this.f252a.d(i);
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(boolean z) {
        this.u = z;
    }
}
