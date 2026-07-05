package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.f;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ad;
import androidx.appcompat.widget.as;
import androidx.appcompat.widget.ax;
import androidx.appcompat.widget.ay;
import androidx.appcompat.widget.z;
import androidx.core.g.d;
import androidx.core.g.o;
import androidx.core.g.q;
import androidx.core.g.u;
import androidx.core.g.v;
import androidx.core.g.w;
import androidx.core.g.y;
import java.lang.Thread;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
class f extends androidx.appcompat.app.e implements LayoutInflater.Factory2, h.a {
    private static final boolean u;
    private static final int[] v;
    private static boolean w;
    private g A;
    private boolean C;
    private ViewGroup D;
    private TextView E;
    private View F;
    private boolean G;
    private boolean H;
    private boolean I;
    private C0022f[] J;
    private C0022f K;
    private boolean L;
    private boolean N;
    private d O;
    private boolean Q;
    private Rect R;
    private Rect S;
    private AppCompatViewInflater T;

    /* renamed from: a, reason: collision with root package name */
    final Context f120a;

    /* renamed from: b, reason: collision with root package name */
    final Window f121b;
    final Window.Callback c;
    final Window.Callback d;
    final androidx.appcompat.app.d e;
    androidx.appcompat.app.a f;
    MenuInflater g;
    androidx.appcompat.view.b h;
    ActionBarContextView i;
    PopupWindow j;
    Runnable k;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    int t;
    private CharSequence x;
    private z y;
    private a z;
    u l = null;
    private boolean B = true;
    private int M = -100;
    private final Runnable P = new Runnable() { // from class: androidx.appcompat.app.f.2
        @Override // java.lang.Runnable
        public void run() {
            if ((f.this.t & 1) != 0) {
                f.this.g(0);
            }
            if ((f.this.t & 4096) != 0) {
                f.this.g(108);
            }
            f.this.s = false;
            f.this.t = 0;
        }
    };

    void a(ViewGroup viewGroup) {
    }

    static {
        u = Build.VERSION.SDK_INT < 21;
        v = new int[]{R.attr.windowBackground};
        if (!u || w) {
            return;
        }
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: androidx.appcompat.app.f.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                if (a(th)) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                    notFoundException.initCause(th.getCause());
                    notFoundException.setStackTrace(th.getStackTrace());
                    defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                    return;
                }
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }

            private boolean a(Throwable th) {
                String message;
                if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                    return false;
                }
                return message.contains("drawable") || message.contains("Drawable");
            }
        });
        w = true;
    }

    f(Context context, Window window, androidx.appcompat.app.d dVar) {
        this.f120a = context;
        this.f121b = window;
        this.e = dVar;
        this.c = this.f121b.getCallback();
        if (this.c instanceof c) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.d = new c(this.c);
        this.f121b.setCallback(this.d);
        as asVarA = as.a(context, (AttributeSet) null, v);
        Drawable drawableB = asVarA.b(0);
        if (drawableB != null) {
            this.f121b.setBackgroundDrawable(drawableB);
        }
        asVarA.a();
    }

    @Override // androidx.appcompat.app.e
    public void a(Bundle bundle) {
        if (this.c instanceof Activity) {
            String strB = null;
            try {
                strB = androidx.core.app.e.b((Activity) this.c);
            } catch (IllegalArgumentException unused) {
            }
            if (strB != null) {
                androidx.appcompat.app.a aVarK = k();
                if (aVarK == null) {
                    this.Q = true;
                } else {
                    aVarK.e(true);
                }
            }
        }
        if (bundle == null || this.M != -100) {
            return;
        }
        this.M = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override // androidx.appcompat.app.e
    public void b(Bundle bundle) {
        u();
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.app.a a() {
        t();
        return this.f;
    }

    final androidx.appcompat.app.a k() {
        return this.f;
    }

    final Window.Callback l() {
        return this.f121b.getCallback();
    }

    private void t() {
        u();
        if (this.m && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new l((Activity) this.c, this.n);
            } else if (this.c instanceof Dialog) {
                this.f = new l((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.e(this.Q);
            }
        }
    }

    @Override // androidx.appcompat.app.e
    public void a(Toolbar toolbar) {
        if (this.c instanceof Activity) {
            androidx.appcompat.app.a aVarA = a();
            if (aVarA instanceof l) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.g = null;
            if (aVarA != null) {
                aVarA.g();
            }
            if (toolbar != null) {
                i iVar = new i(toolbar, ((Activity) this.c).getTitle(), this.d);
                this.f = iVar;
                this.f121b.setCallback(iVar.h());
            } else {
                this.f = null;
                this.f121b.setCallback(this.d);
            }
            f();
        }
    }

    final Context m() {
        androidx.appcompat.app.a aVarA = a();
        Context contextB = aVarA != null ? aVarA.b() : null;
        return contextB == null ? this.f120a : contextB;
    }

    @Override // androidx.appcompat.app.e
    public MenuInflater b() {
        if (this.g == null) {
            t();
            this.g = new androidx.appcompat.view.g(this.f != null ? this.f.b() : this.f120a);
        }
        return this.g;
    }

    @Override // androidx.appcompat.app.e
    public <T extends View> T a(int i) {
        u();
        return (T) this.f121b.findViewById(i);
    }

    @Override // androidx.appcompat.app.e
    public void a(Configuration configuration) {
        androidx.appcompat.app.a aVarA;
        if (this.m && this.C && (aVarA = a()) != null) {
            aVarA.a(configuration);
        }
        androidx.appcompat.widget.j.a().a(this.f120a);
        i();
    }

    @Override // androidx.appcompat.app.e
    public void c() {
        i();
    }

    @Override // androidx.appcompat.app.e
    public void d() {
        androidx.appcompat.app.a aVarA = a();
        if (aVarA != null) {
            aVarA.f(false);
        }
        if (this.O != null) {
            this.O.d();
        }
    }

    @Override // androidx.appcompat.app.e
    public void e() {
        androidx.appcompat.app.a aVarA = a();
        if (aVarA != null) {
            aVarA.f(true);
        }
    }

    @Override // androidx.appcompat.app.e
    public void a(View view) {
        u();
        ViewGroup viewGroup = (ViewGroup) this.D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void b(int i) {
        u();
        ViewGroup viewGroup = (ViewGroup) this.D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f120a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        u();
        ViewGroup viewGroup = (ViewGroup) this.D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        u();
        ((ViewGroup) this.D.findViewById(R.id.content)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    @Override // androidx.appcompat.app.e
    public void c(Bundle bundle) {
        if (this.M != -100) {
            bundle.putInt("appcompat:local_night_mode", this.M);
        }
    }

    @Override // androidx.appcompat.app.e
    public void g() {
        if (this.s) {
            this.f121b.getDecorView().removeCallbacks(this.P);
        }
        this.r = true;
        if (this.f != null) {
            this.f.g();
        }
        if (this.O != null) {
            this.O.d();
        }
    }

    private void u() {
        if (this.C) {
            return;
        }
        this.D = v();
        CharSequence charSequenceN = n();
        if (!TextUtils.isEmpty(charSequenceN)) {
            if (this.y != null) {
                this.y.setWindowTitle(charSequenceN);
            } else if (k() != null) {
                k().a(charSequenceN);
            } else if (this.E != null) {
                this.E.setText(charSequenceN);
            }
        }
        w();
        a(this.D);
        this.C = true;
        C0022f c0022fA = a(0, false);
        if (this.r) {
            return;
        }
        if (c0022fA == null || c0022fA.j == null) {
            j(108);
        }
    }

    private ViewGroup v() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        Context dVar;
        TypedArray typedArrayObtainStyledAttributes = this.f120a.obtainStyledAttributes(a.j.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowNoTitle, false)) {
            c(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBar, false)) {
            c(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionBarOverlay, false)) {
            c(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(a.j.AppCompatTheme_windowActionModeOverlay, false)) {
            c(10);
        }
        this.p = typedArrayObtainStyledAttributes.getBoolean(a.j.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f121b.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f120a);
        if (!this.q) {
            if (this.p) {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(a.g.abc_dialog_title_material, (ViewGroup) null);
                this.n = false;
                this.m = false;
            } else if (this.m) {
                TypedValue typedValue = new TypedValue();
                this.f120a.getTheme().resolveAttribute(a.C0018a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    dVar = new androidx.appcompat.view.d(this.f120a, typedValue.resourceId);
                } else {
                    dVar = this.f120a;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(dVar).inflate(a.g.abc_screen_toolbar, (ViewGroup) null);
                this.y = (z) viewGroup.findViewById(a.f.decor_content_parent);
                this.y.setWindowCallback(l());
                if (this.n) {
                    this.y.a(109);
                }
                if (this.G) {
                    this.y.a(2);
                }
                if (this.H) {
                    this.y.a(5);
                }
            } else {
                viewGroup = null;
            }
        } else {
            if (this.o) {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(a.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
            } else {
                viewGroup = (ViewGroup) layoutInflaterFrom.inflate(a.g.abc_screen_simple, (ViewGroup) null);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                q.a(viewGroup, new o() { // from class: androidx.appcompat.app.f.3
                    @Override // androidx.core.g.o
                    public y a(View view, y yVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        int iB = yVar.b();
                        int iH = f.this.h(iB);
                        if (iB != iH) {
                            yVar = yVar.a(yVar.a(), iH, yVar.c(), yVar.d());
                        }
                        return q.a(view, yVar);
                    }
                });
            } else {
                ((ad) viewGroup).setOnFitSystemWindowsListener(new ad.a() { // from class: androidx.appcompat.app.f.4
                    @Override // androidx.appcompat.widget.ad.a
                    public void a(Rect rect) {
                        rect.top = f.this.h(rect.top);
                    }
                });
            }
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.m + ", windowActionBarOverlay: " + this.n + ", android:windowIsFloating: " + this.p + ", windowActionModeOverlay: " + this.o + ", windowNoTitle: " + this.q + " }");
        }
        if (this.y == null) {
            this.E = (TextView) viewGroup.findViewById(a.f.title);
        }
        ay.b(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.f.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f121b.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f121b.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.a() { // from class: androidx.appcompat.app.f.5
            @Override // androidx.appcompat.widget.ContentFrameLayout.a
            public void a() {
            }

            @Override // androidx.appcompat.widget.ContentFrameLayout.a
            public void b() {
                f.this.s();
            }
        });
        return viewGroup;
    }

    private void w() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.D.findViewById(R.id.content);
        View decorView = this.f121b.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f120a.obtainStyledAttributes(a.j.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(a.j.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @Override // androidx.appcompat.app.e
    public boolean c(int i) {
        int iK = k(i);
        if (this.q && iK == 108) {
            return false;
        }
        if (this.m && iK == 1) {
            this.m = false;
        }
        switch (iK) {
            case 1:
                x();
                this.q = true;
                return true;
            case 2:
                x();
                this.G = true;
                return true;
            case 5:
                x();
                this.H = true;
                return true;
            case 10:
                x();
                this.o = true;
                return true;
            case 108:
                x();
                this.m = true;
                return true;
            case 109:
                x();
                this.n = true;
                return true;
            default:
                return this.f121b.requestFeature(iK);
        }
    }

    @Override // androidx.appcompat.app.e
    public final void a(CharSequence charSequence) {
        this.x = charSequence;
        if (this.y != null) {
            this.y.setWindowTitle(charSequence);
        } else if (k() != null) {
            k().a(charSequence);
        } else if (this.E != null) {
            this.E.setText(charSequence);
        }
    }

    final CharSequence n() {
        if (this.c instanceof Activity) {
            return ((Activity) this.c).getTitle();
        }
        return this.x;
    }

    void d(int i) {
        if (i == 108) {
            androidx.appcompat.app.a aVarA = a();
            if (aVarA != null) {
                aVarA.g(false);
                return;
            }
            return;
        }
        if (i == 0) {
            C0022f c0022fA = a(i, true);
            if (c0022fA.o) {
                a(c0022fA, false);
            }
        }
    }

    void e(int i) {
        androidx.appcompat.app.a aVarA;
        if (i != 108 || (aVarA = a()) == null) {
            return;
        }
        aVarA.g(true);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean a(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
        C0022f c0022fA;
        Window.Callback callbackL = l();
        if (callbackL == null || this.r || (c0022fA = a((Menu) hVar.q())) == null) {
            return false;
        }
        return callbackL.onMenuItemSelected(c0022fA.f139a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void a(androidx.appcompat.view.menu.h hVar) {
        a(hVar, true);
    }

    public androidx.appcompat.view.b a(b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.h != null) {
            this.h.c();
        }
        b bVar = new b(aVar);
        androidx.appcompat.app.a aVarA = a();
        if (aVarA != null) {
            this.h = aVarA.a(bVar);
            if (this.h != null && this.e != null) {
                this.e.a(this.h);
            }
        }
        if (this.h == null) {
            this.h = b(bVar);
        }
        return this.h;
    }

    @Override // androidx.appcompat.app.e
    public void f() {
        androidx.appcompat.app.a aVarA = a();
        if (aVarA == null || !aVarA.e()) {
            j(0);
        }
    }

    androidx.appcompat.view.b b(b.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        androidx.appcompat.view.b bVarA;
        Context dVar;
        q();
        if (this.h != null) {
            this.h.c();
        }
        if (!(aVar instanceof b)) {
            aVar = new b(aVar);
        }
        if (this.e == null || this.r) {
            bVarA = null;
        } else {
            try {
                bVarA = this.e.a(aVar);
            } catch (AbstractMethodError unused) {
            }
        }
        if (bVarA != null) {
            this.h = bVarA;
        } else {
            if (this.i == null) {
                if (this.p) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f120a.getTheme();
                    theme.resolveAttribute(a.C0018a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f120a.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new androidx.appcompat.view.d(this.f120a, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f120a;
                    }
                    this.i = new ActionBarContextView(dVar);
                    this.j = new PopupWindow(dVar, (AttributeSet) null, a.C0018a.actionModePopupWindowStyle);
                    androidx.core.widget.h.a(this.j, 2);
                    this.j.setContentView(this.i);
                    this.j.setWidth(-1);
                    dVar.getTheme().resolveAttribute(a.C0018a.actionBarSize, typedValue, true);
                    this.i.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.j.setHeight(-2);
                    this.k = new Runnable() { // from class: androidx.appcompat.app.f.6
                        @Override // java.lang.Runnable
                        public void run() {
                            f.this.j.showAtLocation(f.this.i, 55, 0, 0);
                            f.this.q();
                            if (f.this.o()) {
                                f.this.i.setAlpha(0.0f);
                                f.this.l = q.l(f.this.i).a(1.0f);
                                f.this.l.a(new w() { // from class: androidx.appcompat.app.f.6.1
                                    @Override // androidx.core.g.w, androidx.core.g.v
                                    public void a(View view) {
                                        f.this.i.setVisibility(0);
                                    }

                                    @Override // androidx.core.g.w, androidx.core.g.v
                                    public void b(View view) {
                                        f.this.i.setAlpha(1.0f);
                                        f.this.l.a((v) null);
                                        f.this.l = null;
                                    }
                                });
                                return;
                            }
                            f.this.i.setAlpha(1.0f);
                            f.this.i.setVisibility(0);
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.D.findViewById(a.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m()));
                        this.i = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.i != null) {
                q();
                this.i.c();
                androidx.appcompat.view.e eVar = new androidx.appcompat.view.e(this.i.getContext(), this.i, aVar, this.j == null);
                if (aVar.a(eVar, eVar.b())) {
                    eVar.d();
                    this.i.a(eVar);
                    this.h = eVar;
                    if (o()) {
                        this.i.setAlpha(0.0f);
                        this.l = q.l(this.i).a(1.0f);
                        this.l.a(new w() { // from class: androidx.appcompat.app.f.7
                            @Override // androidx.core.g.w, androidx.core.g.v
                            public void a(View view) {
                                f.this.i.setVisibility(0);
                                f.this.i.sendAccessibilityEvent(32);
                                if (f.this.i.getParent() instanceof View) {
                                    q.p((View) f.this.i.getParent());
                                }
                            }

                            @Override // androidx.core.g.w, androidx.core.g.v
                            public void b(View view) {
                                f.this.i.setAlpha(1.0f);
                                f.this.l.a((v) null);
                                f.this.l = null;
                            }
                        });
                    } else {
                        this.i.setAlpha(1.0f);
                        this.i.setVisibility(0);
                        this.i.sendAccessibilityEvent(32);
                        if (this.i.getParent() instanceof View) {
                            q.p((View) this.i.getParent());
                        }
                    }
                    if (this.j != null) {
                        this.f121b.getDecorView().post(this.k);
                    }
                } else {
                    this.h = null;
                }
            }
        }
        if (this.h != null && this.e != null) {
            this.e.a(this.h);
        }
        return this.h;
    }

    final boolean o() {
        return this.C && this.D != null && q.x(this.D);
    }

    public boolean p() {
        return this.B;
    }

    void q() {
        if (this.l != null) {
            this.l.b();
        }
    }

    boolean r() {
        if (this.h != null) {
            this.h.c();
            return true;
        }
        androidx.appcompat.app.a aVarA = a();
        return aVarA != null && aVarA.f();
    }

    boolean a(int i, KeyEvent keyEvent) {
        androidx.appcompat.app.a aVarA = a();
        if (aVarA != null && aVarA.a(i, keyEvent)) {
            return true;
        }
        if (this.K != null && a(this.K, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.K != null) {
                this.K.n = true;
            }
            return true;
        }
        if (this.K == null) {
            C0022f c0022fA = a(0, true);
            b(c0022fA, keyEvent);
            boolean zA = a(c0022fA, keyEvent.getKeyCode(), keyEvent, 1);
            c0022fA.m = false;
            if (zA) {
                return true;
            }
        }
        return false;
    }

    boolean a(KeyEvent keyEvent) {
        View decorView;
        if (((this.c instanceof d.a) || (this.c instanceof androidx.appcompat.app.g)) && (decorView = this.f121b.getDecorView()) != null && androidx.core.g.d.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    boolean b(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.L;
            this.L = false;
            C0022f c0022fA = a(0, false);
            if (c0022fA != null && c0022fA.o) {
                if (!z) {
                    a(c0022fA, true);
                }
                return true;
            }
            if (r()) {
                return true;
            }
        } else if (i == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    boolean c(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.L = (keyEvent.getFlags() & 128) != 0;
        } else if (i == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean zA = false;
        if (this.T == null) {
            String string = this.f120a.obtainStyledAttributes(a.j.AppCompatTheme).getString(a.j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.T = new AppCompatViewInflater();
            } else {
                try {
                    this.T = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.T = new AppCompatViewInflater();
                }
            }
        }
        if (u) {
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zA = true;
                }
            } else {
                zA = a((ViewParent) view);
            }
            z = zA;
        } else {
            z = false;
        }
        return this.T.createView(view, str, context, attributeSet, z, u, true, ax.a());
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f121b.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || q.A((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    @Override // androidx.appcompat.app.e
    public void h() throws IllegalAccessException, IllegalArgumentException {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f120a);
        if (layoutInflaterFrom.getFactory() == null) {
            androidx.core.g.e.a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof f) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private void a(C0022f c0022f, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (c0022f.o || this.r) {
            return;
        }
        if (c0022f.f139a == 0) {
            if ((this.f120a.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackL = l();
        if (callbackL != null && !callbackL.onMenuOpened(c0022f.f139a, c0022f.j)) {
            a(c0022f, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f120a.getSystemService("window");
        if (windowManager != null && b(c0022f, keyEvent)) {
            if (c0022f.g == null || c0022f.q) {
                if (c0022f.g == null) {
                    if (!a(c0022f) || c0022f.g == null) {
                        return;
                    }
                } else if (c0022f.q && c0022f.g.getChildCount() > 0) {
                    c0022f.g.removeAllViews();
                }
                if (!c(c0022f) || !c0022f.a()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = c0022f.h.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                c0022f.g.setBackgroundResource(c0022f.f140b);
                ViewParent parent = c0022f.h.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(c0022f.h);
                }
                c0022f.g.addView(c0022f.h, layoutParams2);
                if (!c0022f.h.hasFocus()) {
                    c0022f.h.requestFocus();
                }
            } else {
                if (c0022f.i != null && (layoutParams = c0022f.i.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                }
                c0022f.n = false;
                WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, c0022f.d, c0022f.e, 1002, 8519680, -3);
                layoutParams3.gravity = c0022f.c;
                layoutParams3.windowAnimations = c0022f.f;
                windowManager.addView(c0022f.g, layoutParams3);
                c0022f.o = true;
            }
            i = -2;
            c0022f.n = false;
            WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, c0022f.d, c0022f.e, 1002, 8519680, -3);
            layoutParams32.gravity = c0022f.c;
            layoutParams32.windowAnimations = c0022f.f;
            windowManager.addView(c0022f.g, layoutParams32);
            c0022f.o = true;
        }
    }

    private boolean a(C0022f c0022f) {
        c0022f.a(m());
        c0022f.g = new e(c0022f.l);
        c0022f.c = 81;
        return true;
    }

    private void a(androidx.appcompat.view.menu.h hVar, boolean z) {
        if (this.y != null && this.y.e() && (!ViewConfiguration.get(this.f120a).hasPermanentMenuKey() || this.y.g())) {
            Window.Callback callbackL = l();
            if (!this.y.f() || !z) {
                if (callbackL == null || this.r) {
                    return;
                }
                if (this.s && (this.t & 1) != 0) {
                    this.f121b.getDecorView().removeCallbacks(this.P);
                    this.P.run();
                }
                C0022f c0022fA = a(0, true);
                if (c0022fA.j == null || c0022fA.r || !callbackL.onPreparePanel(0, c0022fA.i, c0022fA.j)) {
                    return;
                }
                callbackL.onMenuOpened(108, c0022fA.j);
                this.y.h();
                return;
            }
            this.y.i();
            if (this.r) {
                return;
            }
            callbackL.onPanelClosed(108, a(0, true).j);
            return;
        }
        C0022f c0022fA2 = a(0, true);
        c0022fA2.q = true;
        a(c0022fA2, false);
        a(c0022fA2, (KeyEvent) null);
    }

    private boolean b(C0022f c0022f) {
        Context context = this.f120a;
        if ((c0022f.f139a == 0 || c0022f.f139a == 108) && this.y != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(a.C0018a.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(a.C0018a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(a.C0018a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.h hVar = new androidx.appcompat.view.menu.h(context);
        hVar.a(this);
        c0022f.a(hVar);
        return true;
    }

    private boolean c(C0022f c0022f) {
        if (c0022f.i != null) {
            c0022f.h = c0022f.i;
            return true;
        }
        if (c0022f.j == null) {
            return false;
        }
        if (this.A == null) {
            this.A = new g();
        }
        c0022f.h = (View) c0022f.a(this.A);
        return c0022f.h != null;
    }

    private boolean b(C0022f c0022f, KeyEvent keyEvent) {
        if (this.r) {
            return false;
        }
        if (c0022f.m) {
            return true;
        }
        if (this.K != null && this.K != c0022f) {
            a(this.K, false);
        }
        Window.Callback callbackL = l();
        if (callbackL != null) {
            c0022f.i = callbackL.onCreatePanelView(c0022f.f139a);
        }
        boolean z = c0022f.f139a == 0 || c0022f.f139a == 108;
        if (z && this.y != null) {
            this.y.j();
        }
        if (c0022f.i == null && (!z || !(k() instanceof i))) {
            if (c0022f.j == null || c0022f.r) {
                if (c0022f.j == null && (!b(c0022f) || c0022f.j == null)) {
                    return false;
                }
                if (z && this.y != null) {
                    if (this.z == null) {
                        this.z = new a();
                    }
                    this.y.a(c0022f.j, this.z);
                }
                c0022f.j.h();
                if (!callbackL.onCreatePanelMenu(c0022f.f139a, c0022f.j)) {
                    c0022f.a((androidx.appcompat.view.menu.h) null);
                    if (z && this.y != null) {
                        this.y.a(null, this.z);
                    }
                    return false;
                }
                c0022f.r = false;
            }
            c0022f.j.h();
            if (c0022f.s != null) {
                c0022f.j.b(c0022f.s);
                c0022f.s = null;
            }
            if (!callbackL.onPreparePanel(0, c0022f.i, c0022f.j)) {
                if (z && this.y != null) {
                    this.y.a(null, this.z);
                }
                c0022f.j.i();
                return false;
            }
            c0022f.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            c0022f.j.setQwertyMode(c0022f.p);
            c0022f.j.i();
        }
        c0022f.m = true;
        c0022f.n = false;
        this.K = c0022f;
        return true;
    }

    void b(androidx.appcompat.view.menu.h hVar) {
        if (this.I) {
            return;
        }
        this.I = true;
        this.y.k();
        Window.Callback callbackL = l();
        if (callbackL != null && !this.r) {
            callbackL.onPanelClosed(108, hVar);
        }
        this.I = false;
    }

    void f(int i) {
        a(a(i, true), true);
    }

    void a(C0022f c0022f, boolean z) {
        if (z && c0022f.f139a == 0 && this.y != null && this.y.f()) {
            b(c0022f.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f120a.getSystemService("window");
        if (windowManager != null && c0022f.o && c0022f.g != null) {
            windowManager.removeView(c0022f.g);
            if (z) {
                a(c0022f.f139a, c0022f, null);
            }
        }
        c0022f.m = false;
        c0022f.n = false;
        c0022f.o = false;
        c0022f.h = null;
        c0022f.q = true;
        if (this.K == c0022f) {
            this.K = null;
        }
    }

    private boolean d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        C0022f c0022fA = a(i, true);
        if (c0022fA.o) {
            return false;
        }
        return b(c0022fA, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            androidx.appcompat.view.b r0 = r3.h
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.f$f r2 = r3.a(r4, r0)
            if (r4 != 0) goto L45
            androidx.appcompat.widget.z r4 = r3.y
            if (r4 == 0) goto L45
            androidx.appcompat.widget.z r4 = r3.y
            boolean r4 = r4.e()
            if (r4 == 0) goto L45
            android.content.Context r4 = r3.f120a
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L45
            androidx.appcompat.widget.z r4 = r3.y
            boolean r4 = r4.f()
            if (r4 != 0) goto L3e
            boolean r4 = r3.r
            if (r4 != 0) goto L65
            boolean r4 = r3.b(r2, r5)
            if (r4 == 0) goto L65
            androidx.appcompat.widget.z r4 = r3.y
            boolean r4 = r4.h()
            goto L6c
        L3e:
            androidx.appcompat.widget.z r4 = r3.y
            boolean r4 = r4.i()
            goto L6c
        L45:
            boolean r4 = r2.o
            if (r4 != 0) goto L67
            boolean r4 = r2.n
            if (r4 == 0) goto L4e
            goto L67
        L4e:
            boolean r4 = r2.m
            if (r4 == 0) goto L65
            boolean r4 = r2.r
            if (r4 == 0) goto L5d
            r2.m = r1
            boolean r4 = r3.b(r2, r5)
            goto L5e
        L5d:
            r4 = 1
        L5e:
            if (r4 == 0) goto L65
            r3.a(r2, r5)
            r4 = 1
            goto L6c
        L65:
            r4 = 0
            goto L6c
        L67:
            boolean r4 = r2.o
            r3.a(r2, r0)
        L6c:
            if (r4 == 0) goto L85
            android.content.Context r5 = r3.f120a
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L7e
            r5.playSoundEffect(r1)
            goto L85
        L7e:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r5, r0)
        L85:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.f.e(int, android.view.KeyEvent):boolean");
    }

    void a(int i, C0022f c0022f, Menu menu) {
        if (menu == null) {
            if (c0022f == null && i >= 0 && i < this.J.length) {
                c0022f = this.J[i];
            }
            if (c0022f != null) {
                menu = c0022f.j;
            }
        }
        if ((c0022f == null || c0022f.o) && !this.r) {
            this.c.onPanelClosed(i, menu);
        }
    }

    C0022f a(Menu menu) {
        C0022f[] c0022fArr = this.J;
        int length = c0022fArr != null ? c0022fArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0022f c0022f = c0022fArr[i];
            if (c0022f != null && c0022f.j == menu) {
                return c0022f;
            }
        }
        return null;
    }

    protected C0022f a(int i, boolean z) {
        C0022f[] c0022fArr = this.J;
        if (c0022fArr == null || c0022fArr.length <= i) {
            C0022f[] c0022fArr2 = new C0022f[i + 1];
            if (c0022fArr != null) {
                System.arraycopy(c0022fArr, 0, c0022fArr2, 0, c0022fArr.length);
            }
            this.J = c0022fArr2;
            c0022fArr = c0022fArr2;
        }
        C0022f c0022f = c0022fArr[i];
        if (c0022f != null) {
            return c0022f;
        }
        C0022f c0022f2 = new C0022f(i);
        c0022fArr[i] = c0022f2;
        return c0022f2;
    }

    private boolean a(C0022f c0022f, int i, KeyEvent keyEvent, int i2) {
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((c0022f.m || b(c0022f, keyEvent)) && c0022f.j != null) {
            zPerformShortcut = c0022f.j.performShortcut(i, keyEvent, i2);
        }
        if (zPerformShortcut && (i2 & 1) == 0 && this.y == null) {
            a(c0022f, true);
        }
        return zPerformShortcut;
    }

    private void j(int i) {
        this.t = (1 << i) | this.t;
        if (this.s) {
            return;
        }
        q.a(this.f121b.getDecorView(), this.P);
        this.s = true;
    }

    void g(int i) {
        C0022f c0022fA;
        C0022f c0022fA2 = a(i, true);
        if (c0022fA2.j != null) {
            Bundle bundle = new Bundle();
            c0022fA2.j.a(bundle);
            if (bundle.size() > 0) {
                c0022fA2.s = bundle;
            }
            c0022fA2.j.h();
            c0022fA2.j.clear();
        }
        c0022fA2.r = true;
        c0022fA2.q = true;
        if ((i != 108 && i != 0) || this.y == null || (c0022fA = a(0, false)) == null) {
            return;
        }
        c0022fA.m = false;
        b(c0022fA, (KeyEvent) null);
    }

    int h(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z;
        boolean z2;
        if (this.i == null || !(this.i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
            if (this.i.isShown()) {
                if (this.R == null) {
                    this.R = new Rect();
                    this.S = new Rect();
                }
                Rect rect = this.R;
                Rect rect2 = this.S;
                rect.set(0, i, 0, 0);
                ay.a(this.D, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.F == null) {
                        this.F = new View(this.f120a);
                        this.F.setBackgroundColor(this.f120a.getResources().getColor(a.c.abc_input_method_navigation_guard));
                        this.D.addView(this.F, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.F.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.F != null;
                if (!this.o && z) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = false;
            }
            if (z2) {
                this.i.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.F != null) {
            this.F.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    private void x() {
        if (this.C) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int k(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i != 9) {
            return i;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    void s() {
        if (this.y != null) {
            this.y.k();
        }
        if (this.j != null) {
            this.f121b.getDecorView().removeCallbacks(this.k);
            if (this.j.isShowing()) {
                try {
                    this.j.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.j = null;
        }
        q();
        C0022f c0022fA = a(0, false);
        if (c0022fA == null || c0022fA.j == null) {
            return;
        }
        c0022fA.j.close();
    }

    @Override // androidx.appcompat.app.e
    public boolean i() {
        int iY = y();
        int i = i(iY);
        boolean zL = i != -1 ? l(i) : false;
        if (iY == 0) {
            z();
            this.O.c();
        }
        this.N = true;
        return zL;
    }

    int i(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) this.f120a.getSystemService(UiModeManager.class)).getNightMode() == 0) {
            return -1;
        }
        z();
        return this.O.a();
    }

    private int y() {
        return this.M != -100 ? this.M : j();
    }

    private boolean l(int i) throws IllegalAccessException, IllegalArgumentException {
        Resources resources = this.f120a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (A()) {
            ((Activity) this.f120a).recreate();
            return true;
        }
        Configuration configuration2 = new Configuration(configuration);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        resources.updateConfiguration(configuration2, displayMetrics);
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        h.a(resources);
        return true;
    }

    private void z() {
        if (this.O == null) {
            this.O = new d(k.a(this.f120a));
        }
    }

    private boolean A() {
        if (!this.N || !(this.f120a instanceof Activity)) {
            return false;
        }
        try {
            return (this.f120a.getPackageManager().getActivityInfo(new ComponentName(this.f120a, this.f120a.getClass()), 0).configChanges & 512) == 0;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
            return true;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    class b implements b.a {

        /* renamed from: b, reason: collision with root package name */
        private b.a f132b;

        public b(b.a aVar) {
            this.f132b = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f132b.a(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f132b.b(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f132b.a(bVar, menuItem);
        }

        @Override // androidx.appcompat.view.b.a
        public void a(androidx.appcompat.view.b bVar) {
            this.f132b.a(bVar);
            if (f.this.j != null) {
                f.this.f121b.getDecorView().removeCallbacks(f.this.k);
            }
            if (f.this.i != null) {
                f.this.q();
                f.this.l = q.l(f.this.i).a(0.0f);
                f.this.l.a(new w() { // from class: androidx.appcompat.app.f.b.1
                    @Override // androidx.core.g.w, androidx.core.g.v
                    public void b(View view) {
                        f.this.i.setVisibility(8);
                        if (f.this.j != null) {
                            f.this.j.dismiss();
                        } else if (f.this.i.getParent() instanceof View) {
                            q.p((View) f.this.i.getParent());
                        }
                        f.this.i.removeAllViews();
                        f.this.l.a((v) null);
                        f.this.l = null;
                    }
                });
            }
            if (f.this.e != null) {
                f.this.e.b(f.this.h);
            }
            f.this.h = null;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    private final class g implements o.a {
        g() {
        }

        @Override // androidx.appcompat.view.menu.o.a
        public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
            androidx.appcompat.view.menu.h hVarQ = hVar.q();
            boolean z2 = hVarQ != hVar;
            f fVar = f.this;
            if (z2) {
                hVar = hVarQ;
            }
            C0022f c0022fA = fVar.a((Menu) hVar);
            if (c0022fA != null) {
                if (z2) {
                    f.this.a(c0022fA.f139a, c0022fA, hVarQ);
                    f.this.a(c0022fA, true);
                } else {
                    f.this.a(c0022fA, z);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.o.a
        public boolean a(androidx.appcompat.view.menu.h hVar) {
            Window.Callback callbackL;
            if (hVar != null || !f.this.m || (callbackL = f.this.l()) == null || f.this.r) {
                return true;
            }
            callbackL.onMenuOpened(108, hVar);
            return true;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    private final class a implements o.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.o.a
        public boolean a(androidx.appcompat.view.menu.h hVar) {
            Window.Callback callbackL = f.this.l();
            if (callbackL == null) {
                return true;
            }
            callbackL.onMenuOpened(108, hVar);
            return true;
        }

        @Override // androidx.appcompat.view.menu.o.a
        public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
            f.this.b(hVar);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: androidx.appcompat.app.f$f, reason: collision with other inner class name */
    protected static final class C0022f {

        /* renamed from: a, reason: collision with root package name */
        int f139a;

        /* renamed from: b, reason: collision with root package name */
        int f140b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        androidx.appcompat.view.menu.h j;
        androidx.appcompat.view.menu.f k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        C0022f(int i) {
            this.f139a = i;
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(a.C0018a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            themeNewTheme.resolveAttribute(a.C0018a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            } else {
                themeNewTheme.applyStyle(a.i.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(a.j.AppCompatTheme);
            this.f140b = typedArrayObtainStyledAttributes.getResourceId(a.j.AppCompatTheme_panelBackground, 0);
            this.f = typedArrayObtainStyledAttributes.getResourceId(a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(androidx.appcompat.view.menu.h hVar) {
            if (hVar == this.j) {
                return;
            }
            if (this.j != null) {
                this.j.b(this.k);
            }
            this.j = hVar;
            if (hVar == null || this.k == null) {
                return;
            }
            hVar.a(this.k);
        }

        p a(o.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new androidx.appcompat.view.menu.f(this.l, a.g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a(this.k);
            }
            return this.k.a(this.g);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    private class e extends ContentFrameLayout {
        public e(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                f.this.f(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
        }

        private boolean a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    class c extends androidx.appcompat.view.i {
        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onContentChanged() {
        }

        c(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return f.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || f.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.h)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.h hVar = menu instanceof androidx.appcompat.view.menu.h ? (androidx.appcompat.view.menu.h) menu : null;
            if (i == 0 && hVar == null) {
                return false;
            }
            if (hVar != null) {
                hVar.c(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (hVar != null) {
                hVar.c(false);
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            f.this.e(i);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            f.this.d(i);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (f.this.p()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(f.this.f120a, callback);
            androidx.appcompat.view.b bVarA = f.this.a(aVar);
            if (bVarA != null) {
                return aVar.b(bVarA);
            }
            return null;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (f.this.p() && i == 0) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            C0022f c0022fA = f.this.a(0, true);
            if (c0022fA != null && c0022fA.j != null) {
                super.onProvideKeyboardShortcuts(list, c0022fA.j, i);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i);
            }
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    final class d {

        /* renamed from: b, reason: collision with root package name */
        private k f136b;
        private boolean c;
        private BroadcastReceiver d;
        private IntentFilter e;

        d(k kVar) {
            this.f136b = kVar;
            this.c = kVar.a();
        }

        int a() {
            this.c = this.f136b.a();
            return this.c ? 2 : 1;
        }

        void b() {
            boolean zA = this.f136b.a();
            if (zA != this.c) {
                this.c = zA;
                f.this.i();
            }
        }

        void c() {
            d();
            if (this.d == null) {
                this.d = new BroadcastReceiver() { // from class: androidx.appcompat.app.f.d.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        d.this.b();
                    }
                };
            }
            if (this.e == null) {
                this.e = new IntentFilter();
                this.e.addAction("android.intent.action.TIME_SET");
                this.e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.e.addAction("android.intent.action.TIME_TICK");
            }
            f.this.f120a.registerReceiver(this.d, this.e);
        }

        void d() {
            if (this.d != null) {
                f.this.f120a.unregisterReceiver(this.d);
                this.d = null;
            }
        }
    }
}
