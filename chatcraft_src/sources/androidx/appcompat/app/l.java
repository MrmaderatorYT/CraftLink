package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.aa;
import androidx.appcompat.widget.al;
import androidx.core.g.q;
import androidx.core.g.u;
import androidx.core.g.v;
import androidx.core.g.w;
import androidx.core.g.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
public class l extends androidx.appcompat.app.a implements ActionBarOverlayLayout.a {
    static final /* synthetic */ boolean s = !l.class.desiredAssertionStatus();
    private static final Interpolator t = new AccelerateInterpolator();
    private static final Interpolator u = new DecelerateInterpolator();
    private boolean A;
    private boolean B;
    private boolean D;
    private boolean F;
    private boolean H;

    /* renamed from: a, reason: collision with root package name */
    Context f161a;

    /* renamed from: b, reason: collision with root package name */
    ActionBarOverlayLayout f162b;
    ActionBarContainer c;
    aa d;
    ActionBarContextView e;
    View f;
    al g;
    a h;
    androidx.appcompat.view.b i;
    b.a j;
    boolean l;
    boolean m;
    androidx.appcompat.view.h n;
    boolean o;
    private Context v;
    private Activity w;
    private Dialog x;
    private ArrayList<Object> y = new ArrayList<>();
    private int z = -1;
    private ArrayList<a.b> C = new ArrayList<>();
    private int E = 0;
    boolean k = true;
    private boolean G = true;
    final v p = new w() { // from class: androidx.appcompat.app.l.1
        @Override // androidx.core.g.w, androidx.core.g.v
        public void b(View view) {
            if (l.this.k && l.this.f != null) {
                l.this.f.setTranslationY(0.0f);
                l.this.c.setTranslationY(0.0f);
            }
            l.this.c.setVisibility(8);
            l.this.c.setTransitioning(false);
            l.this.n = null;
            l.this.h();
            if (l.this.f162b != null) {
                q.p(l.this.f162b);
            }
        }
    };
    final v q = new w() { // from class: androidx.appcompat.app.l.2
        @Override // androidx.core.g.w, androidx.core.g.v
        public void b(View view) {
            l.this.n = null;
            l.this.c.requestLayout();
        }
    };
    final x r = new x() { // from class: androidx.appcompat.app.l.3
        @Override // androidx.core.g.x
        public void a(View view) {
            ((View) l.this.c.getParent()).invalidate();
        }
    };

    static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void m() {
    }

    public l(Activity activity, boolean z) {
        this.w = activity;
        View decorView = activity.getWindow().getDecorView();
        a(decorView);
        if (z) {
            return;
        }
        this.f = decorView.findViewById(R.id.content);
    }

    public l(Dialog dialog) {
        this.x = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(View view) {
        this.f162b = (ActionBarOverlayLayout) view.findViewById(a.f.decor_content_parent);
        if (this.f162b != null) {
            this.f162b.setActionBarVisibilityCallback(this);
        }
        this.d = b(view.findViewById(a.f.action_bar));
        this.e = (ActionBarContextView) view.findViewById(a.f.action_context_bar);
        this.c = (ActionBarContainer) view.findViewById(a.f.action_bar_container);
        if (this.d == null || this.e == null || this.c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f161a = this.d.b();
        boolean z = (this.d.o() & 4) != 0;
        if (z) {
            this.A = true;
        }
        androidx.appcompat.view.a aVarA = androidx.appcompat.view.a.a(this.f161a);
        c(aVarA.f() || z);
        l(aVarA.d());
        TypedArray typedArrayObtainStyledAttributes = this.f161a.obtainStyledAttributes(null, a.j.ActionBar, a.C0018a.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(a.j.ActionBar_hideOnContentScroll, false)) {
            d(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private aa b(View view) {
        if (view instanceof aa) {
            return (aa) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    @Override // androidx.appcompat.app.a
    public void a(float f) {
        q.a(this.c, f);
    }

    @Override // androidx.appcompat.app.a
    public void a(Configuration configuration) {
        l(androidx.appcompat.view.a.a(this.f161a).d());
    }

    private void l(boolean z) {
        this.D = z;
        if (!this.D) {
            this.d.a((al) null);
            this.c.setTabContainer(this.g);
        } else {
            this.c.setTabContainer(null);
            this.d.a(this.g);
        }
        boolean z2 = i() == 2;
        if (this.g != null) {
            if (z2) {
                this.g.setVisibility(0);
                if (this.f162b != null) {
                    q.p(this.f162b);
                }
            } else {
                this.g.setVisibility(8);
            }
        }
        this.d.a(!this.D && z2);
        this.f162b.setHasNonEmbeddedTabs(!this.D && z2);
    }

    void h() {
        if (this.j != null) {
            this.j.a(this.i);
            this.i = null;
            this.j = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void a(int i) {
        this.E = i;
    }

    @Override // androidx.appcompat.app.a
    public void f(boolean z) {
        this.H = z;
        if (z || this.n == null) {
            return;
        }
        this.n.c();
    }

    @Override // androidx.appcompat.app.a
    public void g(boolean z) {
        if (z == this.B) {
            return;
        }
        this.B = z;
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            this.C.get(i).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public void a(boolean z) {
        a(z ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.a
    public void b(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void c(boolean z) {
        this.d.b(z);
    }

    @Override // androidx.appcompat.app.a
    public void a(CharSequence charSequence) {
        this.d.a(charSequence);
    }

    public void a(int i, int i2) {
        int iO = this.d.o();
        if ((i2 & 4) != 0) {
            this.A = true;
        }
        this.d.c((i & i2) | ((i2 ^ (-1)) & iO));
    }

    public int i() {
        return this.d.p();
    }

    @Override // androidx.appcompat.app.a
    public int a() {
        return this.d.o();
    }

    @Override // androidx.appcompat.app.a
    public androidx.appcompat.view.b a(b.a aVar) {
        if (this.h != null) {
            this.h.c();
        }
        this.f162b.setHideOnContentScrollEnabled(false);
        this.e.c();
        a aVar2 = new a(this.e.getContext(), aVar);
        if (!aVar2.e()) {
            return null;
        }
        this.h = aVar2;
        aVar2.d();
        this.e.a(aVar2);
        k(true);
        this.e.sendAccessibilityEvent(32);
        return aVar2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void h(boolean z) {
        this.k = z;
    }

    private void n() {
        if (this.F) {
            return;
        }
        this.F = true;
        if (this.f162b != null) {
            this.f162b.setShowingForActionMode(true);
        }
        m(false);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void j() {
        if (this.m) {
            this.m = false;
            m(true);
        }
    }

    private void o() {
        if (this.F) {
            this.F = false;
            if (this.f162b != null) {
                this.f162b.setShowingForActionMode(false);
            }
            m(false);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void k() {
        if (this.m) {
            return;
        }
        this.m = true;
        m(true);
    }

    @Override // androidx.appcompat.app.a
    public void d(boolean z) {
        if (z && !this.f162b.a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.o = z;
        this.f162b.setHideOnContentScrollEnabled(z);
    }

    private void m(boolean z) {
        if (a(this.l, this.m, this.F)) {
            if (this.G) {
                return;
            }
            this.G = true;
            i(z);
            return;
        }
        if (this.G) {
            this.G = false;
            j(z);
        }
    }

    public void i(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        this.c.setVisibility(0);
        if (this.E == 0 && (this.H || z)) {
            this.c.setTranslationY(0.0f);
            float f = -this.c.getHeight();
            if (z) {
                this.c.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            this.c.setTranslationY(f);
            androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
            u uVarB = q.l(this.c).b(0.0f);
            uVarB.a(this.r);
            hVar.a(uVarB);
            if (this.k && this.f != null) {
                this.f.setTranslationY(f);
                hVar.a(q.l(this.f).b(0.0f));
            }
            hVar.a(u);
            hVar.a(250L);
            hVar.a(this.q);
            this.n = hVar;
            hVar.a();
        } else {
            this.c.setAlpha(1.0f);
            this.c.setTranslationY(0.0f);
            if (this.k && this.f != null) {
                this.f.setTranslationY(0.0f);
            }
            this.q.b(null);
        }
        if (this.f162b != null) {
            q.p(this.f162b);
        }
    }

    public void j(boolean z) {
        if (this.n != null) {
            this.n.c();
        }
        if (this.E == 0 && (this.H || z)) {
            this.c.setAlpha(1.0f);
            this.c.setTransitioning(true);
            androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
            float f = -this.c.getHeight();
            if (z) {
                this.c.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            u uVarB = q.l(this.c).b(f);
            uVarB.a(this.r);
            hVar.a(uVarB);
            if (this.k && this.f != null) {
                hVar.a(q.l(this.f).b(f));
            }
            hVar.a(t);
            hVar.a(250L);
            hVar.a(this.p);
            this.n = hVar;
            hVar.a();
            return;
        }
        this.p.b(null);
    }

    public void k(boolean z) {
        u uVarA;
        u uVarA2;
        if (z) {
            n();
        } else {
            o();
        }
        if (!p()) {
            if (z) {
                this.d.d(4);
                this.e.setVisibility(0);
                return;
            } else {
                this.d.d(0);
                this.e.setVisibility(8);
                return;
            }
        }
        if (z) {
            uVarA2 = this.d.a(4, 100L);
            uVarA = this.e.a(0, 200L);
        } else {
            uVarA = this.d.a(0, 200L);
            uVarA2 = this.e.a(8, 100L);
        }
        androidx.appcompat.view.h hVar = new androidx.appcompat.view.h();
        hVar.a(uVarA2, uVarA);
        hVar.a();
    }

    private boolean p() {
        return q.x(this.c);
    }

    @Override // androidx.appcompat.app.a
    public Context b() {
        if (this.v == null) {
            TypedValue typedValue = new TypedValue();
            this.f161a.getTheme().resolveAttribute(a.C0018a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.v = new ContextThemeWrapper(this.f161a, i);
            } else {
                this.v = this.f161a;
            }
        }
        return this.v;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.a
    public void l() {
        if (this.n != null) {
            this.n.c();
            this.n = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean f() {
        if (this.d == null || !this.d.c()) {
            return false;
        }
        this.d.d();
        return true;
    }

    /* compiled from: WindowDecorActionBar.java */
    public class a extends androidx.appcompat.view.b implements h.a {

        /* renamed from: b, reason: collision with root package name */
        private final Context f167b;
        private final androidx.appcompat.view.menu.h c;
        private b.a d;
        private WeakReference<View> e;

        public a(Context context, b.a aVar) {
            this.f167b = context;
            this.d = aVar;
            this.c = new androidx.appcompat.view.menu.h(context).a(1);
            this.c.a(this);
        }

        @Override // androidx.appcompat.view.b
        public MenuInflater a() {
            return new androidx.appcompat.view.g(this.f167b);
        }

        @Override // androidx.appcompat.view.b
        public Menu b() {
            return this.c;
        }

        @Override // androidx.appcompat.view.b
        public void c() {
            if (l.this.h != this) {
                return;
            }
            if (!l.a(l.this.l, l.this.m, false)) {
                l.this.i = this;
                l.this.j = this.d;
            } else {
                this.d.a(this);
            }
            this.d = null;
            l.this.k(false);
            l.this.e.b();
            l.this.d.a().sendAccessibilityEvent(32);
            l.this.f162b.setHideOnContentScrollEnabled(l.this.o);
            l.this.h = null;
        }

        @Override // androidx.appcompat.view.b
        public void d() {
            if (l.this.h != this) {
                return;
            }
            this.c.h();
            try {
                this.d.b(this, this.c);
            } finally {
                this.c.i();
            }
        }

        public boolean e() {
            this.c.h();
            try {
                return this.d.a(this, this.c);
            } finally {
                this.c.i();
            }
        }

        @Override // androidx.appcompat.view.b
        public void a(View view) {
            l.this.e.setCustomView(view);
            this.e = new WeakReference<>(view);
        }

        @Override // androidx.appcompat.view.b
        public void a(CharSequence charSequence) {
            l.this.e.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void b(CharSequence charSequence) {
            l.this.e.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.b
        public void a(int i) {
            b(l.this.f161a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.b
        public void b(int i) {
            a((CharSequence) l.this.f161a.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.b
        public CharSequence f() {
            return l.this.e.getTitle();
        }

        @Override // androidx.appcompat.view.b
        public CharSequence g() {
            return l.this.e.getSubtitle();
        }

        @Override // androidx.appcompat.view.b
        public void a(boolean z) {
            super.a(z);
            l.this.e.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.b
        public boolean h() {
            return l.this.e.d();
        }

        @Override // androidx.appcompat.view.b
        public View i() {
            if (this.e != null) {
                return this.e.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.menu.h.a
        public boolean a(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
            if (this.d != null) {
                return this.d.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.h.a
        public void a(androidx.appcompat.view.menu.h hVar) {
            if (this.d == null) {
                return;
            }
            d();
            l.this.e.a();
        }
    }

    @Override // androidx.appcompat.app.a
    public void e(boolean z) {
        if (this.A) {
            return;
        }
        b(z);
    }

    @Override // androidx.appcompat.app.a
    public boolean a(int i, KeyEvent keyEvent) {
        Menu menuB;
        if (this.h == null || (menuB = this.h.b()) == null) {
            return false;
        }
        menuB.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuB.performShortcut(i, keyEvent, 0);
    }
}
