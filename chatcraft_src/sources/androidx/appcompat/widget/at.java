package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.Toolbar;

/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class at implements aa {

    /* renamed from: a, reason: collision with root package name */
    Toolbar f369a;

    /* renamed from: b, reason: collision with root package name */
    CharSequence f370b;
    Window.Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private c n;
    private int o;
    private int p;
    private Drawable q;

    @Override // androidx.appcompat.widget.aa
    public void b(boolean z) {
    }

    public at(Toolbar toolbar, boolean z) {
        this(toolbar, z, a.h.abc_action_bar_up_description, a.e.abc_ic_ab_back_material);
    }

    public at(Toolbar toolbar, boolean z, int i, int i2) {
        this.o = 0;
        this.p = 0;
        this.f369a = toolbar;
        this.f370b = toolbar.getTitle();
        this.l = toolbar.getSubtitle();
        this.k = this.f370b != null;
        this.j = toolbar.getNavigationIcon();
        as asVarA = as.a(toolbar.getContext(), null, a.j.ActionBar, a.C0018a.actionBarStyle, 0);
        this.q = asVarA.a(a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceC = asVarA.c(a.j.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceC)) {
                b(charSequenceC);
            }
            CharSequence charSequenceC2 = asVarA.c(a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceC2)) {
                c(charSequenceC2);
            }
            Drawable drawableA = asVarA.a(a.j.ActionBar_logo);
            if (drawableA != null) {
                b(drawableA);
            }
            Drawable drawableA2 = asVarA.a(a.j.ActionBar_icon);
            if (drawableA2 != null) {
                a(drawableA2);
            }
            if (this.j == null && this.q != null) {
                c(this.q);
            }
            c(asVarA.a(a.j.ActionBar_displayOptions, 0));
            int iG = asVarA.g(a.j.ActionBar_customNavigationLayout, 0);
            if (iG != 0) {
                a(LayoutInflater.from(this.f369a.getContext()).inflate(iG, (ViewGroup) this.f369a, false));
                c(this.e | 16);
            }
            int iF = asVarA.f(a.j.ActionBar_height, 0);
            if (iF > 0) {
                ViewGroup.LayoutParams layoutParams = this.f369a.getLayoutParams();
                layoutParams.height = iF;
                this.f369a.setLayoutParams(layoutParams);
            }
            int iD = asVarA.d(a.j.ActionBar_contentInsetStart, -1);
            int iD2 = asVarA.d(a.j.ActionBar_contentInsetEnd, -1);
            if (iD >= 0 || iD2 >= 0) {
                this.f369a.a(Math.max(iD, 0), Math.max(iD2, 0));
            }
            int iG2 = asVarA.g(a.j.ActionBar_titleTextStyle, 0);
            if (iG2 != 0) {
                this.f369a.a(this.f369a.getContext(), iG2);
            }
            int iG3 = asVarA.g(a.j.ActionBar_subtitleTextStyle, 0);
            if (iG3 != 0) {
                this.f369a.b(this.f369a.getContext(), iG3);
            }
            int iG4 = asVarA.g(a.j.ActionBar_popupTheme, 0);
            if (iG4 != 0) {
                this.f369a.setPopupTheme(iG4);
            }
        } else {
            this.e = r();
        }
        asVarA.a();
        e(i);
        this.m = this.f369a.getNavigationContentDescription();
        this.f369a.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.at.1

            /* renamed from: a, reason: collision with root package name */
            final androidx.appcompat.view.menu.a f371a;

            {
                this.f371a = new androidx.appcompat.view.menu.a(at.this.f369a.getContext(), 0, R.id.home, 0, 0, at.this.f370b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (at.this.c == null || !at.this.d) {
                    return;
                }
                at.this.c.onMenuItemSelected(0, this.f371a);
            }
        });
    }

    public void e(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.f369a.getNavigationContentDescription())) {
            f(this.p);
        }
    }

    private int r() {
        if (this.f369a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f369a.getNavigationIcon();
        return 15;
    }

    @Override // androidx.appcompat.widget.aa
    public ViewGroup a() {
        return this.f369a;
    }

    @Override // androidx.appcompat.widget.aa
    public Context b() {
        return this.f369a.getContext();
    }

    @Override // androidx.appcompat.widget.aa
    public boolean c() {
        return this.f369a.g();
    }

    @Override // androidx.appcompat.widget.aa
    public void d() {
        this.f369a.h();
    }

    @Override // androidx.appcompat.widget.aa
    public void a(Window.Callback callback) {
        this.c = callback;
    }

    @Override // androidx.appcompat.widget.aa
    public void a(CharSequence charSequence) {
        if (this.k) {
            return;
        }
        e(charSequence);
    }

    @Override // androidx.appcompat.widget.aa
    public CharSequence e() {
        return this.f369a.getTitle();
    }

    public void b(CharSequence charSequence) {
        this.k = true;
        e(charSequence);
    }

    private void e(CharSequence charSequence) {
        this.f370b = charSequence;
        if ((this.e & 8) != 0) {
            this.f369a.setTitle(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        this.l = charSequence;
        if ((this.e & 8) != 0) {
            this.f369a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.aa
    public void f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.aa
    public void g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.aa
    public void a(int i) {
        a(i != 0 ? androidx.appcompat.a.a.a.b(b(), i) : null);
    }

    @Override // androidx.appcompat.widget.aa
    public void a(Drawable drawable) {
        this.h = drawable;
        s();
    }

    @Override // androidx.appcompat.widget.aa
    public void b(int i) {
        b(i != 0 ? androidx.appcompat.a.a.a.b(b(), i) : null);
    }

    public void b(Drawable drawable) {
        this.i = drawable;
        s();
    }

    private void s() {
        Drawable drawable;
        if ((this.e & 2) != 0) {
            drawable = ((this.e & 1) == 0 || this.i == null) ? this.h : this.i;
        } else {
            drawable = null;
        }
        this.f369a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.aa
    public boolean h() {
        return this.f369a.a();
    }

    @Override // androidx.appcompat.widget.aa
    public boolean i() {
        return this.f369a.b();
    }

    @Override // androidx.appcompat.widget.aa
    public boolean j() {
        return this.f369a.c();
    }

    @Override // androidx.appcompat.widget.aa
    public boolean k() {
        return this.f369a.d();
    }

    @Override // androidx.appcompat.widget.aa
    public boolean l() {
        return this.f369a.e();
    }

    @Override // androidx.appcompat.widget.aa
    public void m() {
        this.d = true;
    }

    @Override // androidx.appcompat.widget.aa
    public void a(Menu menu, o.a aVar) {
        if (this.n == null) {
            this.n = new c(this.f369a.getContext());
            this.n.a(a.f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.f369a.a((androidx.appcompat.view.menu.h) menu, this.n);
    }

    @Override // androidx.appcompat.widget.aa
    public void n() {
        this.f369a.f();
    }

    @Override // androidx.appcompat.widget.aa
    public int o() {
        return this.e;
    }

    @Override // androidx.appcompat.widget.aa
    public void c(int i) {
        int i2 = this.e ^ i;
        this.e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    u();
                }
                t();
            }
            if ((i2 & 3) != 0) {
                s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f369a.setTitle(this.f370b);
                    this.f369a.setSubtitle(this.l);
                } else {
                    this.f369a.setTitle((CharSequence) null);
                    this.f369a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || this.g == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f369a.addView(this.g);
            } else {
                this.f369a.removeView(this.g);
            }
        }
    }

    @Override // androidx.appcompat.widget.aa
    public void a(al alVar) {
        if (this.f != null && this.f.getParent() == this.f369a) {
            this.f369a.removeView(this.f);
        }
        this.f = alVar;
        if (alVar == null || this.o != 2) {
            return;
        }
        this.f369a.addView(this.f, 0);
        Toolbar.b bVar = (Toolbar.b) this.f.getLayoutParams();
        bVar.width = -2;
        bVar.height = -2;
        bVar.f115a = 8388691;
        alVar.setAllowCollapse(true);
    }

    @Override // androidx.appcompat.widget.aa
    public void a(boolean z) {
        this.f369a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.aa
    public int p() {
        return this.o;
    }

    public void a(View view) {
        if (this.g != null && (this.e & 16) != 0) {
            this.f369a.removeView(this.g);
        }
        this.g = view;
        if (view == null || (this.e & 16) == 0) {
            return;
        }
        this.f369a.addView(this.g);
    }

    @Override // androidx.appcompat.widget.aa
    public androidx.core.g.u a(final int i, long j) {
        return androidx.core.g.q.l(this.f369a).a(i == 0 ? 1.0f : 0.0f).a(j).a(new androidx.core.g.w() { // from class: androidx.appcompat.widget.at.2
            private boolean c = false;

            @Override // androidx.core.g.w, androidx.core.g.v
            public void a(View view) {
                at.this.f369a.setVisibility(0);
            }

            @Override // androidx.core.g.w, androidx.core.g.v
            public void b(View view) {
                if (this.c) {
                    return;
                }
                at.this.f369a.setVisibility(i);
            }

            @Override // androidx.core.g.w, androidx.core.g.v
            public void c(View view) {
                this.c = true;
            }
        });
    }

    public void c(Drawable drawable) {
        this.j = drawable;
        t();
    }

    private void t() {
        if ((this.e & 4) != 0) {
            this.f369a.setNavigationIcon(this.j != null ? this.j : this.q);
        } else {
            this.f369a.setNavigationIcon((Drawable) null);
        }
    }

    public void d(CharSequence charSequence) {
        this.m = charSequence;
        u();
    }

    public void f(int i) {
        d(i == 0 ? null : b().getString(i));
    }

    private void u() {
        if ((this.e & 4) != 0) {
            if (TextUtils.isEmpty(this.m)) {
                this.f369a.setNavigationContentDescription(this.p);
            } else {
                this.f369a.setNavigationContentDescription(this.m);
            }
        }
    }

    @Override // androidx.appcompat.widget.aa
    public void d(int i) {
        this.f369a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.aa
    public void a(o.a aVar, h.a aVar2) {
        this.f369a.a(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.aa
    public Menu q() {
        return this.f369a.getMenu();
    }
}
