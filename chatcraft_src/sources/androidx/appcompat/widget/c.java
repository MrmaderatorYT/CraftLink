package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.g.b;
import java.util.ArrayList;

/* compiled from: ActionMenuPresenter.java */
/* loaded from: classes.dex */
class c extends androidx.appcompat.view.menu.b implements b.a {
    private b A;
    d g;
    e h;
    a i;
    RunnableC0026c j;
    final f k;
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y;
    private View z;

    public c(Context context) {
        super(context, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
        this.y = new SparseBooleanArray();
        this.k = new f();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.o
    public void a(Context context, androidx.appcompat.view.menu.h hVar) {
        super.a(context, hVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a aVarA = androidx.appcompat.view.a.a(context);
        if (!this.p) {
            this.o = aVarA.b();
        }
        if (!this.v) {
            this.q = aVarA.c();
        }
        if (!this.t) {
            this.s = aVarA.a();
        }
        int measuredWidth = this.q;
        if (this.o) {
            if (this.g == null) {
                this.g = new d(this.f217a);
                if (this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = measuredWidth;
        this.x = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.z = null;
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = androidx.appcompat.view.a.a(this.f218b).a();
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void b(boolean z) {
        this.o = z;
        this.p = true;
    }

    public void c(boolean z) {
        this.w = z;
    }

    public void a(Drawable drawable) {
        if (this.g != null) {
            this.g.setImageDrawable(drawable);
        } else {
            this.n = true;
            this.m = drawable;
        }
    }

    public Drawable c() {
        if (this.g != null) {
            return this.g.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.p a(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.p pVar = this.f;
        androidx.appcompat.view.menu.p pVarA = super.a(viewGroup);
        if (pVar != pVarA) {
            ((ActionMenuView) pVarA).setPresenter(this);
        }
        return pVarA;
    }

    @Override // androidx.appcompat.view.menu.b
    public View a(androidx.appcompat.view.menu.j jVar, View view, ViewGroup viewGroup) {
        View actionView = jVar.getActionView();
        if (actionView == null || jVar.n()) {
            actionView = super.a(jVar, view, viewGroup);
        }
        actionView.setVisibility(jVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public void a(androidx.appcompat.view.menu.j jVar, p.a aVar) {
        aVar.a(jVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(int i, androidx.appcompat.view.menu.j jVar) {
        return jVar.j();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.o
    public void a(boolean z) {
        super.a(z);
        ((View) this.f).requestLayout();
        boolean z2 = false;
        if (this.c != null) {
            ArrayList<androidx.appcompat.view.menu.j> arrayListL = this.c.l();
            int size = arrayListL.size();
            for (int i = 0; i < size; i++) {
                androidx.core.g.b bVarA = arrayListL.get(i).a();
                if (bVarA != null) {
                    bVarA.a(this);
                }
            }
        }
        ArrayList<androidx.appcompat.view.menu.j> arrayListM = this.c != null ? this.c.m() : null;
        if (this.o && arrayListM != null) {
            int size2 = arrayListM.size();
            if (size2 == 1) {
                z2 = !arrayListM.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.g == null) {
                this.g = new d(this.f217a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.c());
            }
        } else if (this.g != null && this.g.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.g);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.o);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.g) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.o
    public boolean a(androidx.appcompat.view.menu.u uVar) {
        boolean z = false;
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.u uVar2 = uVar;
        while (uVar2.t() != this.c) {
            uVar2 = (androidx.appcompat.view.menu.u) uVar2.t();
        }
        View viewA = a(uVar2.getItem());
        if (viewA == null) {
            return false;
        }
        this.l = uVar.getItem().getItemId();
        int size = uVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = uVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.i = new a(this.f218b, uVar, viewA);
        this.i.a(z);
        this.i.a();
        super.a(uVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof p.a) && ((p.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean d() {
        if (!this.o || h() || this.c == null || this.f == null || this.j != null || this.c.m().isEmpty()) {
            return false;
        }
        this.j = new RunnableC0026c(new e(this.f218b, this.c, this.g, true));
        ((View) this.f).post(this.j);
        super.a((androidx.appcompat.view.menu.u) null);
        return true;
    }

    public boolean e() {
        if (this.j != null && this.f != null) {
            ((View) this.f).removeCallbacks(this.j);
            this.j = null;
            return true;
        }
        e eVar = this.h;
        if (eVar == null) {
            return false;
        }
        eVar.d();
        return true;
    }

    public boolean f() {
        return e() | g();
    }

    public boolean g() {
        if (this.i == null) {
            return false;
        }
        this.i.d();
        return true;
    }

    public boolean h() {
        return this.h != null && this.h.f();
    }

    public boolean i() {
        return this.j != null || h();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.o
    public boolean b() {
        ArrayList<androidx.appcompat.view.menu.j> arrayListJ;
        int size;
        int iA;
        int i;
        int i2;
        boolean z;
        c cVar = this;
        int i3 = 0;
        if (cVar.c != null) {
            arrayListJ = cVar.c.j();
            size = arrayListJ.size();
        } else {
            arrayListJ = null;
            size = 0;
        }
        int i4 = cVar.s;
        int i5 = cVar.r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f;
        int i6 = i4;
        int i7 = 0;
        boolean z2 = false;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            androidx.appcompat.view.menu.j jVar = arrayListJ.get(i9);
            if (jVar.l()) {
                i7++;
            } else if (jVar.k()) {
                i8++;
            } else {
                z2 = true;
            }
            if (cVar.w && jVar.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (cVar.o && (z2 || i8 + i7 > i6)) {
            i6--;
        }
        int i10 = i6 - i7;
        SparseBooleanArray sparseBooleanArray = cVar.y;
        sparseBooleanArray.clear();
        if (cVar.u) {
            iA = i5 / cVar.x;
            i = ((i5 % cVar.x) / iA) + cVar.x;
        } else {
            iA = 0;
            i = 0;
        }
        int i11 = i5;
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            androidx.appcompat.view.menu.j jVar2 = arrayListJ.get(i12);
            if (jVar2.l()) {
                View viewA = cVar.a(jVar2, cVar.z, viewGroup);
                if (cVar.z == null) {
                    cVar.z = viewA;
                }
                if (cVar.u) {
                    iA -= ActionMenuView.a(viewA, i, iA, iMakeMeasureSpec, i3);
                } else {
                    viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewA.getMeasuredWidth();
                i11 -= measuredWidth;
                if (i13 != 0) {
                    measuredWidth = i13;
                }
                int groupId = jVar2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                jVar2.d(z);
                i2 = size;
                i13 = measuredWidth;
            } else if (jVar2.k()) {
                int groupId2 = jVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i10 > 0 || z3) && i11 > 0 && (!cVar.u || iA > 0);
                if (z4) {
                    boolean z5 = z4;
                    View viewA2 = cVar.a(jVar2, cVar.z, viewGroup);
                    i2 = size;
                    if (cVar.z == null) {
                        cVar.z = viewA2;
                    }
                    if (cVar.u) {
                        int iA2 = ActionMenuView.a(viewA2, i, iA, iMakeMeasureSpec, 0);
                        iA -= iA2;
                        if (iA2 == 0) {
                            z5 = false;
                        }
                    } else {
                        viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth2 = viewA2.getMeasuredWidth();
                    i11 -= measuredWidth2;
                    if (i13 == 0) {
                        i13 = measuredWidth2;
                    }
                    z4 = cVar.u ? z5 & (i11 >= 0) : z5 & (i11 + i13 > 0);
                } else {
                    i2 = size;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i14 = 0; i14 < i12; i14++) {
                        androidx.appcompat.view.menu.j jVar3 = arrayListJ.get(i14);
                        if (jVar3.getGroupId() == groupId2) {
                            if (jVar3.j()) {
                                i10++;
                            }
                            jVar3.d(false);
                        }
                    }
                }
                if (z4) {
                    i10--;
                }
                jVar2.d(z4);
            } else {
                i2 = size;
                jVar2.d(false);
                i12++;
                size = i2;
                cVar = this;
                i3 = 0;
            }
            i12++;
            size = i2;
            cVar = this;
            i3 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.o
    public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
        f();
        super.a(hVar, z);
    }

    @Override // androidx.core.g.b.a
    public void d(boolean z) {
        if (z) {
            super.a((androidx.appcompat.view.menu.u) null);
        } else if (this.c != null) {
            this.c.a(false);
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    /* compiled from: ActionMenuPresenter.java */
    private class d extends o implements ActionMenuView.a {

        /* renamed from: b, reason: collision with root package name */
        private final float[] f390b;

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean d() {
            return false;
        }

        public d(Context context) {
            super(context, null, a.C0018a.actionOverflowButtonStyle);
            this.f390b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            au.a(this, getContentDescription());
            setOnTouchListener(new ae(this) { // from class: androidx.appcompat.widget.c.d.1
                @Override // androidx.appcompat.widget.ae
                public androidx.appcompat.view.menu.s a() {
                    if (c.this.h == null) {
                        return null;
                    }
                    return c.this.h.b();
                }

                @Override // androidx.appcompat.widget.ae
                public boolean b() {
                    c.this.d();
                    return true;
                }

                @Override // androidx.appcompat.widget.ae
                public boolean c() {
                    if (c.this.j != null) {
                        return false;
                    }
                    c.this.e();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.d();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    private class e extends androidx.appcompat.view.menu.n {
        public e(Context context, androidx.appcompat.view.menu.h hVar, View view, boolean z) {
            super(context, hVar, view, z, a.C0018a.actionOverflowMenuStyle);
            a(8388613);
            a(c.this.k);
        }

        @Override // androidx.appcompat.view.menu.n
        protected void e() {
            if (c.this.c != null) {
                c.this.c.close();
            }
            c.this.h = null;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    private class a extends androidx.appcompat.view.menu.n {
        public a(Context context, androidx.appcompat.view.menu.u uVar, View view) {
            super(context, uVar, view, false, a.C0018a.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.j) uVar.getItem()).j()) {
                a(c.this.g == null ? (View) c.this.f : c.this.g);
            }
            a(c.this.k);
        }

        @Override // androidx.appcompat.view.menu.n
        protected void e() {
            c.this.i = null;
            c.this.l = 0;
            super.e();
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    private class f implements o.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.o.a
        public boolean a(androidx.appcompat.view.menu.h hVar) {
            if (hVar == null) {
                return false;
            }
            c.this.l = ((androidx.appcompat.view.menu.u) hVar).getItem().getItemId();
            o.a aVarA = c.this.a();
            if (aVarA != null) {
                return aVarA.a(hVar);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.o.a
        public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
            if (hVar instanceof androidx.appcompat.view.menu.u) {
                hVar.q().a(false);
            }
            o.a aVarA = c.this.a();
            if (aVarA != null) {
                aVarA.a(hVar, z);
            }
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    /* renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    private class RunnableC0026c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private e f388b;

        public RunnableC0026c(e eVar) {
            this.f388b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.c != null) {
                c.this.c.g();
            }
            View view = (View) c.this.f;
            if (view != null && view.getWindowToken() != null && this.f388b.c()) {
                c.this.h = this.f388b;
            }
            c.this.j = null;
        }
    }

    /* compiled from: ActionMenuPresenter.java */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.s a() {
            if (c.this.i != null) {
                return c.this.i.b();
            }
            return null;
        }
    }
}
