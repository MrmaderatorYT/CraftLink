package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private int A;
    private int B;
    private boolean C;
    private boolean D;
    private final ArrayList<View> E;
    private final ArrayList<View> F;
    private final int[] G;
    private final ActionMenuView.e H;
    private at I;
    private androidx.appcompat.widget.c J;
    private a K;
    private o.a L;
    private h.a M;
    private boolean N;
    private final Runnable O;

    /* renamed from: a, reason: collision with root package name */
    ImageButton f307a;

    /* renamed from: b, reason: collision with root package name */
    View f308b;
    int c;
    c d;
    private ActionMenuView e;
    private TextView f;
    private TextView g;
    private ImageButton h;
    private ImageView i;
    private Drawable j;
    private CharSequence k;
    private Context l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private ak u;
    private int v;
    private int w;
    private int x;
    private CharSequence y;
    private CharSequence z;

    public interface c {
        boolean a(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0018a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.H = new ActionMenuView.e() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.e
            public boolean a(MenuItem menuItem) {
                if (Toolbar.this.d != null) {
                    return Toolbar.this.d.a(menuItem);
                }
                return false;
            }
        };
        this.O = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.d();
            }
        };
        as asVarA = as.a(getContext(), attributeSet, a.j.Toolbar, i, 0);
        this.n = asVarA.g(a.j.Toolbar_titleTextAppearance, 0);
        this.o = asVarA.g(a.j.Toolbar_subtitleTextAppearance, 0);
        this.x = asVarA.c(a.j.Toolbar_android_gravity, this.x);
        this.c = asVarA.c(a.j.Toolbar_buttonGravity, 48);
        int iD = asVarA.d(a.j.Toolbar_titleMargin, 0);
        iD = asVarA.g(a.j.Toolbar_titleMargins) ? asVarA.d(a.j.Toolbar_titleMargins, iD) : iD;
        this.t = iD;
        this.s = iD;
        this.r = iD;
        this.q = iD;
        int iD2 = asVarA.d(a.j.Toolbar_titleMarginStart, -1);
        if (iD2 >= 0) {
            this.q = iD2;
        }
        int iD3 = asVarA.d(a.j.Toolbar_titleMarginEnd, -1);
        if (iD3 >= 0) {
            this.r = iD3;
        }
        int iD4 = asVarA.d(a.j.Toolbar_titleMarginTop, -1);
        if (iD4 >= 0) {
            this.s = iD4;
        }
        int iD5 = asVarA.d(a.j.Toolbar_titleMarginBottom, -1);
        if (iD5 >= 0) {
            this.t = iD5;
        }
        this.p = asVarA.e(a.j.Toolbar_maxButtonHeight, -1);
        int iD6 = asVarA.d(a.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iD7 = asVarA.d(a.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iE = asVarA.e(a.j.Toolbar_contentInsetLeft, 0);
        int iE2 = asVarA.e(a.j.Toolbar_contentInsetRight, 0);
        s();
        this.u.b(iE, iE2);
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.u.a(iD6, iD7);
        }
        this.v = asVarA.d(a.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.w = asVarA.d(a.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.j = asVarA.a(a.j.Toolbar_collapseIcon);
        this.k = asVarA.c(a.j.Toolbar_collapseContentDescription);
        CharSequence charSequenceC = asVarA.c(a.j.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceC)) {
            setTitle(charSequenceC);
        }
        CharSequence charSequenceC2 = asVarA.c(a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceC2)) {
            setSubtitle(charSequenceC2);
        }
        this.l = getContext();
        setPopupTheme(asVarA.g(a.j.Toolbar_popupTheme, 0));
        Drawable drawableA = asVarA.a(a.j.Toolbar_navigationIcon);
        if (drawableA != null) {
            setNavigationIcon(drawableA);
        }
        CharSequence charSequenceC3 = asVarA.c(a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceC3)) {
            setNavigationContentDescription(charSequenceC3);
        }
        Drawable drawableA2 = asVarA.a(a.j.Toolbar_logo);
        if (drawableA2 != null) {
            setLogo(drawableA2);
        }
        CharSequence charSequenceC4 = asVarA.c(a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceC4)) {
            setLogoDescription(charSequenceC4);
        }
        if (asVarA.g(a.j.Toolbar_titleTextColor)) {
            setTitleTextColor(asVarA.b(a.j.Toolbar_titleTextColor, -1));
        }
        if (asVarA.g(a.j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(asVarA.b(a.j.Toolbar_subtitleTextColor, -1));
        }
        asVarA.a();
    }

    public void setPopupTheme(int i) {
        if (this.m != i) {
            this.m = i;
            if (i == 0) {
                this.l = getContext();
            } else {
                this.l = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.m;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public void setTitleMarginStart(int i) {
        this.q = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public void setTitleMarginTop(int i) {
        this.s = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public void setTitleMarginEnd(int i) {
        this.r = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public void setTitleMarginBottom(int i) {
        this.t = i;
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        s();
        this.u.a(i == 1);
    }

    public void setLogo(int i) {
        setLogo(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public boolean a() {
        return getVisibility() == 0 && this.e != null && this.e.a();
    }

    public boolean b() {
        return this.e != null && this.e.g();
    }

    public boolean c() {
        return this.e != null && this.e.h();
    }

    public boolean d() {
        return this.e != null && this.e.e();
    }

    public boolean e() {
        return this.e != null && this.e.f();
    }

    public void a(androidx.appcompat.view.menu.h hVar, androidx.appcompat.widget.c cVar) {
        if (hVar == null && this.e == null) {
            return;
        }
        o();
        androidx.appcompat.view.menu.h hVarD = this.e.d();
        if (hVarD == hVar) {
            return;
        }
        if (hVarD != null) {
            hVarD.b(this.J);
            hVarD.b(this.K);
        }
        if (this.K == null) {
            this.K = new a();
        }
        cVar.c(true);
        if (hVar != null) {
            hVar.a(cVar, this.l);
            hVar.a(this.K, this.l);
        } else {
            cVar.a(this.l, (androidx.appcompat.view.menu.h) null);
            this.K.a(this.l, (androidx.appcompat.view.menu.h) null);
            cVar.a(true);
            this.K.a(true);
        }
        this.e.setPopupTheme(this.m);
        this.e.setPresenter(cVar);
        this.J = cVar;
    }

    public void f() {
        if (this.e != null) {
            this.e.i();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m();
            if (!d(this.i)) {
                a((View) this.i, true);
            }
        } else if (this.i != null && d(this.i)) {
            removeView(this.i);
            this.F.remove(this.i);
        }
        if (this.i != null) {
            this.i.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        if (this.i != null) {
            return this.i.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m();
        }
        if (this.i != null) {
            this.i.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        if (this.i != null) {
            return this.i.getContentDescription();
        }
        return null;
    }

    private void m() {
        if (this.i == null) {
            this.i = new o(getContext());
        }
    }

    public boolean g() {
        return (this.K == null || this.K.f313b == null) ? false : true;
    }

    public void h() {
        androidx.appcompat.view.menu.j jVar = this.K == null ? null : this.K.f313b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f == null) {
                Context context = getContext();
                this.f = new x(context);
                this.f.setSingleLine();
                this.f.setEllipsize(TextUtils.TruncateAt.END);
                if (this.n != 0) {
                    this.f.setTextAppearance(context, this.n);
                }
                if (this.A != 0) {
                    this.f.setTextColor(this.A);
                }
            }
            if (!d(this.f)) {
                a((View) this.f, true);
            }
        } else if (this.f != null && d(this.f)) {
            removeView(this.f);
            this.F.remove(this.f);
        }
        if (this.f != null) {
            this.f.setText(charSequence);
        }
        this.y = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.g == null) {
                Context context = getContext();
                this.g = new x(context);
                this.g.setSingleLine();
                this.g.setEllipsize(TextUtils.TruncateAt.END);
                if (this.o != 0) {
                    this.g.setTextAppearance(context, this.o);
                }
                if (this.B != 0) {
                    this.g.setTextColor(this.B);
                }
            }
            if (!d(this.g)) {
                a((View) this.g, true);
            }
        } else if (this.g != null && d(this.g)) {
            removeView(this.g);
            this.F.remove(this.g);
        }
        if (this.g != null) {
            this.g.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void a(Context context, int i) {
        this.n = i;
        if (this.f != null) {
            this.f.setTextAppearance(context, i);
        }
    }

    public void b(Context context, int i) {
        this.o = i;
        if (this.g != null) {
            this.g.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.A = i;
        if (this.f != null) {
            this.f.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.B = i;
        if (this.g != null) {
            this.g.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        if (this.h != null) {
            return this.h.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            p();
        }
        if (this.h != null) {
            this.h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            p();
            if (!d(this.h)) {
                a((View) this.h, true);
            }
        } else if (this.h != null && d(this.h)) {
            removeView(this.h);
            this.F.remove(this.h);
        }
        if (this.h != null) {
            this.h.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        if (this.h != null) {
            return this.h.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        p();
        this.h.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        n();
        return this.e.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        n();
        this.e.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        n();
        return this.e.getOverflowIcon();
    }

    private void n() {
        o();
        if (this.e.d() == null) {
            androidx.appcompat.view.menu.h hVar = (androidx.appcompat.view.menu.h) this.e.getMenu();
            if (this.K == null) {
                this.K = new a();
            }
            this.e.setExpandedActionViewsExclusive(true);
            hVar.a(this.K, this.l);
        }
    }

    private void o() {
        if (this.e == null) {
            this.e = new ActionMenuView(getContext());
            this.e.setPopupTheme(this.m);
            this.e.setOnMenuItemClickListener(this.H);
            this.e.a(this.L, this.M);
            b bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f115a = 8388613 | (this.c & 112);
            this.e.setLayoutParams(bVarGenerateDefaultLayoutParams);
            a((View) this.e, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g(getContext());
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.d = cVar;
    }

    public void a(int i, int i2) {
        s();
        this.u.a(i, i2);
    }

    public int getContentInsetStart() {
        if (this.u != null) {
            return this.u.c();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        if (this.u != null) {
            return this.u.d();
        }
        return 0;
    }

    public int getContentInsetLeft() {
        if (this.u != null) {
            return this.u.a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.u != null) {
            return this.u.b();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.v != Integer.MIN_VALUE ? this.v : getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        return this.w != Integer.MIN_VALUE ? this.w : getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.w) {
            this.w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.v, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.h hVarD;
        if ((this.e == null || (hVarD = this.e.d()) == null || !hVarD.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.w, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (androidx.core.g.q.f(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (androidx.core.g.q.f(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void p() {
        if (this.h == null) {
            this.h = new m(getContext(), null, a.C0018a.toolbarNavigationButtonStyle);
            b bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f115a = 8388611 | (this.c & 112);
            this.h.setLayoutParams(bVarGenerateDefaultLayoutParams);
        }
    }

    void i() {
        if (this.f307a == null) {
            this.f307a = new m(getContext(), null, a.C0018a.toolbarNavigationButtonStyle);
            this.f307a.setImageDrawable(this.j);
            this.f307a.setContentDescription(this.k);
            b bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f115a = 8388611 | (this.c & 112);
            bVarGenerateDefaultLayoutParams.f314b = 2;
            this.f307a.setLayoutParams(bVarGenerateDefaultLayoutParams);
            this.f307a.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.h();
                }
            });
        }
    }

    private void a(View view, boolean z) {
        b bVarGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVarGenerateLayoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            bVarGenerateLayoutParams = generateLayoutParams(layoutParams);
        } else {
            bVarGenerateLayoutParams = (b) layoutParams;
        }
        bVarGenerateLayoutParams.f314b = 1;
        if (z && this.f308b != null) {
            view.setLayoutParams(bVarGenerateLayoutParams);
            this.F.add(view);
        } else {
            addView(view, bVarGenerateLayoutParams);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        if (this.K != null && this.K.f313b != null) {
            dVar.f315a = this.K.f313b.getItemId();
        }
        dVar.f316b = b();
        return dVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.a());
        androidx.appcompat.view.menu.h hVarD = this.e != null ? this.e.d() : null;
        if (dVar.f315a != 0 && this.K != null && hVarD != null && (menuItemFindItem = hVarD.findItem(dVar.f315a)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (dVar.f316b) {
            q();
        }
    }

    private void q() {
        removeCallbacks(this.O);
        post(this.O);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private boolean r() {
        if (!this.N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        int[] iArr = this.G;
        if (ay.a(this)) {
            c2 = 1;
            c3 = 0;
        } else {
            c2 = 0;
            c3 = 1;
        }
        if (a(this.h)) {
            a(this.h, i, 0, i2, 0, this.p);
            measuredWidth = this.h.getMeasuredWidth() + b(this.h);
            iMax = Math.max(0, this.h.getMeasuredHeight() + c(this.h));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.h.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (a(this.f307a)) {
            a(this.f307a, i, 0, i2, 0, this.p);
            measuredWidth = this.f307a.getMeasuredWidth() + b(this.f307a);
            iMax = Math.max(iMax, this.f307a.getMeasuredHeight() + c(this.f307a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f307a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth) + 0;
        iArr[c2] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (a(this.e)) {
            a(this.e, i, iMax3, i2, 0, this.p);
            measuredWidth2 = this.e.getMeasuredWidth() + b(this.e);
            iMax = Math.max(iMax, this.e.getMeasuredHeight() + c(this.e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.e.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[c3] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (a(this.f308b)) {
            iMax4 += a(this.f308b, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.f308b.getMeasuredHeight() + c(this.f308b));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f308b.getMeasuredState());
        }
        if (a(this.i)) {
            iMax4 += a(this.i, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.i.getMeasuredHeight() + c(this.i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.i.getMeasuredState());
        }
        int childCount = getChildCount();
        int iMax5 = iMax;
        int iA = iMax4;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (((b) childAt.getLayoutParams()).f314b == 0 && a(childAt)) {
                iA += a(childAt, i, iA, i2, 0, iArr);
                iMax5 = Math.max(iMax5, childAt.getMeasuredHeight() + c(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i4 = this.s + this.t;
        int i5 = this.q + this.r;
        if (a(this.f)) {
            a(this.f, i, iA + i5, i2, i4, iArr);
            int measuredWidth3 = this.f.getMeasuredWidth() + b(this.f);
            measuredHeight = this.f.getMeasuredHeight() + c(this.f);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (a(this.g)) {
            iMax2 = Math.max(iMax2, a(this.g, i, iA + i5, i2, measuredHeight + i4, iArr));
            measuredHeight += this.g.getMeasuredHeight() + c(this.g);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.g.getMeasuredState());
        }
        int iMax6 = Math.max(iMax5, measuredHeight);
        int paddingLeft = iA + iMax2 + getPaddingLeft() + getPaddingRight();
        int paddingTop = iMax6 + getPaddingTop() + getPaddingBottom();
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (r()) {
            iResolveSizeAndState2 = 0;
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02aa A[LOOP:0: B:104:0x02a8->B:105:0x02aa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02cc A[LOOP:1: B:107:0x02ca->B:108:0x02cc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0306 A[LOOP:2: B:116:0x0304->B:117:0x0306, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r25, int r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 795
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    private int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = 0;
        int measuredWidth = 0;
        while (i4 < size) {
            View view = list.get(i4);
            b bVar = (b) view.getLayoutParams();
            int i5 = bVar.leftMargin - i;
            int i6 = bVar.rightMargin - i3;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, i6);
            int iMax3 = Math.max(0, -i5);
            int iMax4 = Math.max(0, -i6);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i4++;
            i3 = iMax4;
            i = iMax3;
        }
        return measuredWidth;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int iMax = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int iA = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iA, iMax + measuredWidth, view.getMeasuredHeight() + iA);
        return iMax + measuredWidth + bVar.rightMargin;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iA = a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iA, iMax, view.getMeasuredHeight() + iA);
        return iMax - (measuredWidth + bVar.leftMargin);
    }

    private int a(View view, int i) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int iA = a(bVar.f115a);
        if (iA == 48) {
            return getPaddingTop() - i2;
        }
        if (iA == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (iMax < bVar.topMargin) {
            iMax = bVar.topMargin;
        } else {
            int i3 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            if (i3 < bVar.bottomMargin) {
                iMax = Math.max(0, iMax - (bVar.bottomMargin - i3));
            }
        }
        return paddingTop + iMax;
    }

    private int a(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.x & 112;
    }

    private void a(List<View> list, int i) {
        boolean z = androidx.core.g.q.f(this) == 1;
        int childCount = getChildCount();
        int iA = androidx.core.g.c.a(i, androidx.core.g.q.f(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.f314b == 0 && a(childAt) && b(bVar.f115a) == iA) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.f314b == 0 && a(childAt2) && b(bVar2.f115a) == iA) {
                list.add(childAt2);
            }
        }
    }

    private int b(int i) {
        int iF = androidx.core.g.q.f(this);
        int iA = androidx.core.g.c.a(i, iF) & 7;
        return (iA == 1 || iA == 3 || iA == 5) ? iA : iF == 1 ? 5 : 3;
    }

    private boolean a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.g.f.a(marginLayoutParams) + androidx.core.g.f.b(marginLayoutParams);
    }

    private int c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b) layoutParams);
        }
        if (layoutParams instanceof a.C0021a) {
            return new b((a.C0021a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public aa getWrapper() {
        if (this.I == null) {
            this.I = new at(this, true);
        }
        return this.I;
    }

    void k() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((b) childAt.getLayoutParams()).f314b != 2 && childAt != this.e) {
                removeViewAt(childCount);
                this.F.add(childAt);
            }
        }
    }

    void l() {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            addView(this.F.get(size));
        }
        this.F.clear();
    }

    private boolean d(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.N = z;
        requestLayout();
    }

    public void a(o.a aVar, h.a aVar2) {
        this.L = aVar;
        this.M = aVar2;
        if (this.e != null) {
            this.e.a(aVar, aVar2);
        }
    }

    private void s() {
        if (this.u == null) {
            this.u = new ak();
        }
    }

    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.J;
    }

    Context getPopupContext() {
        return this.l;
    }

    public static class b extends a.C0021a {

        /* renamed from: b, reason: collision with root package name */
        int f314b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f314b = 0;
        }

        public b(int i, int i2) {
            super(i, i2);
            this.f314b = 0;
            this.f115a = 8388627;
        }

        public b(b bVar) {
            super((a.C0021a) bVar);
            this.f314b = 0;
            this.f314b = bVar.f314b;
        }

        public b(a.C0021a c0021a) {
            super(c0021a);
            this.f314b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f314b = 0;
            a(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f314b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static class d extends androidx.d.a.a {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.ClassLoaderCreator<d>() { // from class: androidx.appcompat.widget.Toolbar.d.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i) {
                return new d[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        int f315a;

        /* renamed from: b, reason: collision with root package name */
        boolean f316b;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f315a = parcel.readInt();
            this.f316b = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.d.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f315a);
            parcel.writeInt(this.f316b ? 1 : 0);
        }
    }

    private class a implements androidx.appcompat.view.menu.o {

        /* renamed from: a, reason: collision with root package name */
        androidx.appcompat.view.menu.h f312a;

        /* renamed from: b, reason: collision with root package name */
        androidx.appcompat.view.menu.j f313b;

        @Override // androidx.appcompat.view.menu.o
        public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.o
        public void a(o.a aVar) {
        }

        @Override // androidx.appcompat.view.menu.o
        public boolean a(androidx.appcompat.view.menu.u uVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.o
        public boolean b() {
            return false;
        }

        a() {
        }

        @Override // androidx.appcompat.view.menu.o
        public void a(Context context, androidx.appcompat.view.menu.h hVar) {
            if (this.f312a != null && this.f313b != null) {
                this.f312a.d(this.f313b);
            }
            this.f312a = hVar;
        }

        @Override // androidx.appcompat.view.menu.o
        public void a(boolean z) {
            if (this.f313b != null) {
                boolean z2 = false;
                if (this.f312a != null) {
                    int size = this.f312a.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        if (this.f312a.getItem(i) == this.f313b) {
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                }
                if (z2) {
                    return;
                }
                b(this.f312a, this.f313b);
            }
        }

        @Override // androidx.appcompat.view.menu.o
        public boolean a(androidx.appcompat.view.menu.h hVar, androidx.appcompat.view.menu.j jVar) {
            Toolbar.this.i();
            ViewParent parent = Toolbar.this.f307a.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.f307a);
                }
                Toolbar.this.addView(Toolbar.this.f307a);
            }
            Toolbar.this.f308b = jVar.getActionView();
            this.f313b = jVar;
            ViewParent parent2 = Toolbar.this.f308b.getParent();
            if (parent2 != Toolbar.this) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(Toolbar.this.f308b);
                }
                b bVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                bVarGenerateDefaultLayoutParams.f115a = 8388611 | (Toolbar.this.c & 112);
                bVarGenerateDefaultLayoutParams.f314b = 2;
                Toolbar.this.f308b.setLayoutParams(bVarGenerateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.f308b);
            }
            Toolbar.this.k();
            Toolbar.this.requestLayout();
            jVar.e(true);
            if (Toolbar.this.f308b instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) Toolbar.this.f308b).a();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.o
        public boolean b(androidx.appcompat.view.menu.h hVar, androidx.appcompat.view.menu.j jVar) {
            if (Toolbar.this.f308b instanceof androidx.appcompat.view.c) {
                ((androidx.appcompat.view.c) Toolbar.this.f308b).b();
            }
            Toolbar.this.removeView(Toolbar.this.f308b);
            Toolbar.this.removeView(Toolbar.this.f307a);
            Toolbar.this.f308b = null;
            Toolbar.this.l();
            this.f313b = null;
            Toolbar.this.requestLayout();
            jVar.e(false);
            return true;
        }
    }
}
