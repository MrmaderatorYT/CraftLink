package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.preference.DialogPreference;
import androidx.preference.internal.AbstractMultiSelectListPreference;
import androidx.preference.j;
import androidx.preference.m;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PreferenceFragmentCompat.java */
/* loaded from: classes.dex */
public abstract class g extends Fragment implements DialogPreference.a, j.a, j.b, j.c {

    /* renamed from: a, reason: collision with root package name */
    RecyclerView f978a;
    private Runnable ag;

    /* renamed from: b, reason: collision with root package name */
    private j f979b;
    private boolean c;
    private boolean d;
    private Context e;
    private int f = m.d.preference_list_fragment;
    private final a g = new a();
    private Handler h = new Handler() { // from class: androidx.preference.g.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            g.this.ae();
        }
    };
    private final Runnable i = new Runnable() { // from class: androidx.preference.g.2
        @Override // java.lang.Runnable
        public void run() {
            g.this.f978a.focusableViewAvailable(g.this.f978a);
        }
    };

    /* compiled from: PreferenceFragmentCompat.java */
    public interface b {
        boolean a(g gVar, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    public interface c {
        boolean a(g gVar, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat.java */
    public interface d {
        boolean a(g gVar, PreferenceScreen preferenceScreen);
    }

    public abstract void a(Bundle bundle, String str);

    protected void af() {
    }

    protected void ag() {
    }

    public Fragment aj() {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        TypedValue typedValue = new TypedValue();
        n().getTheme().resolveAttribute(m.a.preferenceTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i == 0) {
            i = m.f.PreferenceThemeOverlay;
        }
        this.e = new ContextThemeWrapper(n(), i);
        this.f979b = new j(this.e);
        this.f979b.a((j.b) this);
        a(bundle, i() != null ? i().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = this.e.obtainStyledAttributes(null, m.g.PreferenceFragmentCompat, m.a.preferenceFragmentCompatStyle, 0);
        this.f = typedArrayObtainStyledAttributes.getResourceId(m.g.PreferenceFragmentCompat_android_layout, this.f);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(m.g.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.g.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(m.g.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(this.e);
        View viewInflate = layoutInflaterCloneInContext.inflate(this.f, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewC = c(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewC == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.f978a = recyclerViewC;
        recyclerViewC.a(this.g);
        a(drawable);
        if (dimensionPixelSize != -1) {
            d(dimensionPixelSize);
        }
        this.g.a(z);
        if (this.f978a.getParent() == null) {
            viewGroup2.addView(this.f978a);
        }
        this.h.post(this.i);
        return viewInflate;
    }

    public void a(Drawable drawable) {
        this.g.a(drawable);
    }

    public void d(int i) {
        this.g.a(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void a(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreenA;
        super.a(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreenA = a()) != null) {
            preferenceScreenA.c(bundle2);
        }
        if (this.c) {
            ae();
            if (this.ag != null) {
                this.ag.run();
                this.ag = null;
            }
        }
        this.d = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void c() {
        super.c();
        this.f979b.a((j.c) this);
        this.f979b.a((j.a) this);
    }

    @Override // androidx.fragment.app.Fragment
    public void d() {
        super.d();
        this.f979b.a((j.c) null);
        this.f979b.a((j.a) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void e() {
        this.h.removeCallbacks(this.i);
        this.h.removeMessages(1);
        if (this.c) {
            am();
        }
        this.f978a = null;
        super.e();
    }

    @Override // androidx.fragment.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        PreferenceScreen preferenceScreenA = a();
        if (preferenceScreenA != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreenA.a(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    public void a(PreferenceScreen preferenceScreen) {
        if (!this.f979b.a(preferenceScreen) || preferenceScreen == null) {
            return;
        }
        ag();
        this.c = true;
        if (this.d) {
            al();
        }
    }

    public PreferenceScreen a() {
        return this.f979b.d();
    }

    public void e(int i) {
        ak();
        a(this.f979b.a(this.e, i, a()));
    }

    @Override // androidx.preference.j.c
    public boolean b(Preference preference) {
        if (preference.s() == null) {
            return false;
        }
        boolean zA = aj() instanceof c ? ((c) aj()).a(this, preference) : false;
        return (zA || !(n() instanceof c)) ? zA : ((c) n()).a(this, preference);
    }

    @Override // androidx.preference.j.b
    public void b(PreferenceScreen preferenceScreen) {
        if ((aj() instanceof d ? ((d) aj()).a(this, preferenceScreen) : false) || !(n() instanceof d)) {
            return;
        }
        ((d) n()).a(this, preferenceScreen);
    }

    @Override // androidx.preference.DialogPreference.a
    public Preference a(CharSequence charSequence) {
        if (this.f979b == null) {
            return null;
        }
        return this.f979b.a(charSequence);
    }

    private void ak() {
        if (this.f979b == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void al() {
        if (this.h.hasMessages(1)) {
            return;
        }
        this.h.obtainMessage(1).sendToTarget();
    }

    void ae() {
        PreferenceScreen preferenceScreenA = a();
        if (preferenceScreenA != null) {
            ah().setAdapter(c(preferenceScreenA));
            preferenceScreenA.L();
        }
        af();
    }

    private void am() {
        PreferenceScreen preferenceScreenA = a();
        if (preferenceScreenA != null) {
            preferenceScreenA.M();
        }
        ag();
    }

    public final RecyclerView ah() {
        return this.f978a;
    }

    public RecyclerView c(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (this.e.getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(m.c.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(m.d.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(ai());
        recyclerView2.setAccessibilityDelegateCompat(new k(recyclerView2));
        return recyclerView2;
    }

    public RecyclerView.i ai() {
        return new LinearLayoutManager(n());
    }

    protected RecyclerView.a c(PreferenceScreen preferenceScreen) {
        return new h(preferenceScreen);
    }

    @Override // androidx.preference.j.a
    public void c(Preference preference) {
        androidx.fragment.app.c cVarB;
        boolean zA = aj() instanceof b ? ((b) aj()).a(this, preference) : false;
        if (!zA && (n() instanceof b)) {
            zA = ((b) n()).a(this, preference);
        }
        if (!zA && p().a("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                cVarB = androidx.preference.b.b(preference.C());
            } else if (preference instanceof ListPreference) {
                cVarB = androidx.preference.c.b(preference.C());
            } else if (preference instanceof AbstractMultiSelectListPreference) {
                cVarB = androidx.preference.d.b(preference.C());
            } else {
                throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
            }
            cVarB.a(this, 0);
            cVarB.a(p(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    /* compiled from: PreferenceFragmentCompat.java */
    private class a extends RecyclerView.h {

        /* renamed from: b, reason: collision with root package name */
        private Drawable f983b;
        private int c;
        private boolean d = true;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.u uVar) {
            if (this.f983b == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (a(childAt, recyclerView)) {
                    int y = ((int) childAt.getY()) + childAt.getHeight();
                    this.f983b.setBounds(0, y, width, this.c + y);
                    this.f983b.draw(canvas);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.u uVar) {
            if (a(view, recyclerView)) {
                rect.bottom = this.c;
            }
        }

        private boolean a(View view, RecyclerView recyclerView) {
            RecyclerView.x xVarB = recyclerView.b(view);
            if (!((xVarB instanceof l) && ((l) xVarB).b())) {
                return false;
            }
            boolean z = this.d;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z;
            }
            RecyclerView.x xVarB2 = recyclerView.b(recyclerView.getChildAt(iIndexOfChild + 1));
            return (xVarB2 instanceof l) && ((l) xVarB2).a();
        }

        public void a(Drawable drawable) {
            if (drawable != null) {
                this.c = drawable.getIntrinsicHeight();
            } else {
                this.c = 0;
            }
            this.f983b = drawable;
            g.this.f978a.v();
        }

        public void a(int i) {
            this.c = i;
            g.this.f978a.v();
        }

        public void a(boolean z) {
            this.d = z;
        }
    }
}
