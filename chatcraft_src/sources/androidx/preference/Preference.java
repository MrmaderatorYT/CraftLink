package androidx.preference;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.j;
import androidx.preference.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private b H;
    private List<Preference> I;
    private PreferenceGroup J;
    private boolean K;
    private boolean L;
    private final View.OnClickListener M;

    /* renamed from: a, reason: collision with root package name */
    private Context f950a;

    /* renamed from: b, reason: collision with root package name */
    private j f951b;
    private e c;
    private long d;
    private boolean e;
    private c f;
    private d g;
    private int h;
    private int i;
    private CharSequence j;
    private CharSequence k;
    private int l;
    private Drawable m;
    private String n;
    private Intent o;
    private String p;
    private Bundle q;
    private boolean r;
    private boolean s;
    private boolean t;
    private String u;
    private Object v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    interface b {
        void a(Preference preference);

        void b(Preference preference);
    }

    public interface c {
        boolean a(Preference preference, Object obj);
    }

    public interface d {
        boolean a(Preference preference);
    }

    protected Object a(TypedArray typedArray, int i) {
        return null;
    }

    public void a(androidx.core.g.a.c cVar) {
    }

    protected void a(Object obj) {
    }

    protected void h() {
    }

    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        this.h = Integer.MAX_VALUE;
        this.i = 0;
        this.r = true;
        this.s = true;
        this.t = true;
        this.w = true;
        this.x = true;
        this.y = true;
        this.z = true;
        this.A = true;
        this.C = true;
        this.E = true;
        this.F = m.d.preference;
        this.M = new View.OnClickListener() { // from class: androidx.preference.Preference.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Preference.this.a(view);
            }
        };
        this.f950a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.g.Preference, i, i2);
        this.l = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.Preference_icon, m.g.Preference_android_icon, 0);
        this.n = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.Preference_key, m.g.Preference_android_key);
        this.j = androidx.core.a.a.g.c(typedArrayObtainStyledAttributes, m.g.Preference_title, m.g.Preference_android_title);
        this.k = androidx.core.a.a.g.c(typedArrayObtainStyledAttributes, m.g.Preference_summary, m.g.Preference_android_summary);
        this.h = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.Preference_order, m.g.Preference_android_order, Integer.MAX_VALUE);
        this.p = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.Preference_fragment, m.g.Preference_android_fragment);
        this.F = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.Preference_layout, m.g.Preference_android_layout, m.d.preference);
        this.G = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.Preference_widgetLayout, m.g.Preference_android_widgetLayout, 0);
        this.r = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.Preference_enabled, m.g.Preference_android_enabled, true);
        this.s = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.Preference_selectable, m.g.Preference_android_selectable, true);
        this.t = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.Preference_persistent, m.g.Preference_android_persistent, true);
        this.u = androidx.core.a.a.g.b(typedArrayObtainStyledAttributes, m.g.Preference_dependency, m.g.Preference_android_dependency);
        this.z = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.Preference_allowDividerAbove, m.g.Preference_allowDividerAbove, this.s);
        this.A = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.Preference_allowDividerBelow, m.g.Preference_allowDividerBelow, this.s);
        if (typedArrayObtainStyledAttributes.hasValue(m.g.Preference_defaultValue)) {
            this.v = a(typedArrayObtainStyledAttributes, m.g.Preference_defaultValue);
        } else if (typedArrayObtainStyledAttributes.hasValue(m.g.Preference_android_defaultValue)) {
            this.v = a(typedArrayObtainStyledAttributes, m.g.Preference_android_defaultValue);
        }
        this.E = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.Preference_shouldDisableView, m.g.Preference_android_shouldDisableView, true);
        this.B = typedArrayObtainStyledAttributes.hasValue(m.g.Preference_singleLineTitle);
        if (this.B) {
            this.C = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.Preference_singleLineTitle, m.g.Preference_android_singleLineTitle, true);
        }
        this.D = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.Preference_iconSpaceReserved, m.g.Preference_android_iconSpaceReserved, false);
        this.y = androidx.core.a.a.g.a(typedArrayObtainStyledAttributes, m.g.Preference_isPreferenceVisible, m.g.Preference_isPreferenceVisible, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.a.a.g.a(context, m.a.preferenceStyle, R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }

    public void a(Intent intent) {
        this.o = intent;
    }

    public Intent r() {
        return this.o;
    }

    public String s() {
        return this.p;
    }

    public e t() {
        if (this.c != null) {
            return this.c;
        }
        if (this.f951b != null) {
            return this.f951b.b();
        }
        return null;
    }

    public Bundle u() {
        if (this.q == null) {
            this.q = new Bundle();
        }
        return this.q;
    }

    public void a(int i) {
        this.F = i;
    }

    public final int v() {
        return this.F;
    }

    public final int w() {
        return this.G;
    }

    public void a(l lVar) {
        lVar.f1052a.setOnClickListener(this.M);
        lVar.f1052a.setId(this.i);
        TextView textView = (TextView) lVar.a(R.id.title);
        if (textView != null) {
            CharSequence charSequenceY = y();
            if (!TextUtils.isEmpty(charSequenceY)) {
                textView.setText(charSequenceY);
                textView.setVisibility(0);
                if (this.B) {
                    textView.setSingleLine(this.C);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) lVar.a(R.id.summary);
        if (textView2 != null) {
            CharSequence charSequenceO = o();
            if (!TextUtils.isEmpty(charSequenceO)) {
                textView2.setText(charSequenceO);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) lVar.a(R.id.icon);
        if (imageView != null) {
            if (this.l != 0 || this.m != null) {
                if (this.m == null) {
                    this.m = androidx.core.a.a.a(H(), this.l);
                }
                if (this.m != null) {
                    imageView.setImageDrawable(this.m);
                }
            }
            if (this.m != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.D ? 4 : 8);
            }
        }
        View viewA = lVar.a(m.c.icon_frame);
        if (viewA == null) {
            viewA = lVar.a(R.id.icon_frame);
        }
        if (viewA != null) {
            if (this.m != null) {
                viewA.setVisibility(0);
            } else {
                viewA.setVisibility(this.D ? 4 : 8);
            }
        }
        if (this.E) {
            a(lVar.f1052a, z());
        } else {
            a(lVar.f1052a, true);
        }
        boolean zA = A();
        lVar.f1052a.setFocusable(zA);
        lVar.f1052a.setClickable(zA);
        lVar.a(this.z);
        lVar.b(this.A);
    }

    private void a(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                a(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public void b(int i) {
        if (i != this.h) {
            this.h = i;
            J();
        }
    }

    public int x() {
        return this.h;
    }

    public void b(CharSequence charSequence) {
        if ((charSequence != null || this.j == null) && (charSequence == null || charSequence.equals(this.j))) {
            return;
        }
        this.j = charSequence;
        j();
    }

    public void c(int i) {
        b((CharSequence) this.f950a.getString(i));
    }

    public CharSequence y() {
        return this.j;
    }

    public void a(Drawable drawable) {
        if ((drawable != null || this.m == null) && (drawable == null || this.m == drawable)) {
            return;
        }
        this.m = drawable;
        this.l = 0;
        j();
    }

    public void d(int i) {
        a(androidx.core.a.a.a(this.f950a, i));
        this.l = i;
    }

    public CharSequence o() {
        return this.k;
    }

    public void a(CharSequence charSequence) {
        if ((charSequence != null || this.k == null) && (charSequence == null || charSequence.equals(this.k))) {
            return;
        }
        this.k = charSequence;
        j();
    }

    public void a(boolean z) {
        if (this.r != z) {
            this.r = z;
            b(k());
            j();
        }
    }

    public boolean z() {
        return this.r && this.w && this.x;
    }

    public boolean A() {
        return this.s;
    }

    public final boolean B() {
        return this.y;
    }

    long a() {
        return this.d;
    }

    public String C() {
        return this.n;
    }

    public boolean D() {
        return !TextUtils.isEmpty(this.n);
    }

    public boolean E() {
        return this.t;
    }

    protected boolean F() {
        return this.f951b != null && E() && D();
    }

    public boolean b(Object obj) {
        return this.f == null || this.f.a(this, obj);
    }

    public void a(d dVar) {
        this.g = dVar;
    }

    protected void a(View view) {
        G();
    }

    public void G() {
        j.c cVarH;
        if (z()) {
            h();
            if (this.g == null || !this.g.a(this)) {
                j jVarK = K();
                if ((jVarK == null || (cVarH = jVarK.h()) == null || !cVarH.b(this)) && this.o != null) {
                    H().startActivity(this.o);
                }
            }
        }
    }

    public Context H() {
        return this.f950a;
    }

    public SharedPreferences I() {
        if (this.f951b == null || t() != null) {
            return null;
        }
        return this.f951b.c();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        if (this.h != preference.h) {
            return this.h - preference.h;
        }
        if (this.j == preference.j) {
            return 0;
        }
        if (this.j == null) {
            return 1;
        }
        if (preference.j == null) {
            return -1;
        }
        return this.j.toString().compareToIgnoreCase(preference.j.toString());
    }

    final void a(b bVar) {
        this.H = bVar;
    }

    protected void j() {
        if (this.H != null) {
            this.H.a(this);
        }
    }

    protected void J() {
        if (this.H != null) {
            this.H.b(this);
        }
    }

    public j K() {
        return this.f951b;
    }

    protected void a(j jVar) {
        this.f951b = jVar;
        if (!this.e) {
            this.d = jVar.a();
        }
        d();
    }

    protected void a(j jVar, long j) {
        this.d = j;
        this.e = true;
        try {
            a(jVar);
        } finally {
            this.e = false;
        }
    }

    void a(PreferenceGroup preferenceGroup) {
        this.J = preferenceGroup;
    }

    public void L() {
        b();
    }

    public void M() {
        c();
        this.K = true;
    }

    public final void N() {
        this.K = false;
    }

    private void b() {
        if (TextUtils.isEmpty(this.u)) {
            return;
        }
        Preference preferenceD = d(this.u);
        if (preferenceD != null) {
            preferenceD.b(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.u + "\" not found for preference \"" + this.n + "\" (title: \"" + ((Object) this.j) + "\"");
    }

    private void c() {
        Preference preferenceD;
        if (this.u == null || (preferenceD = d(this.u)) == null) {
            return;
        }
        preferenceD.c(this);
    }

    protected Preference d(String str) {
        if (TextUtils.isEmpty(str) || this.f951b == null) {
            return null;
        }
        return this.f951b.a((CharSequence) str);
    }

    private void b(Preference preference) {
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.add(preference);
        preference.a(this, k());
    }

    private void c(Preference preference) {
        if (this.I != null) {
            this.I.remove(preference);
        }
    }

    public void b(boolean z) {
        List<Preference> list = this.I;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).a(this, z);
        }
    }

    public void a(Preference preference, boolean z) {
        if (this.w == z) {
            this.w = !z;
            b(k());
            j();
        }
    }

    public void b(Preference preference, boolean z) {
        if (this.x == z) {
            this.x = !z;
            b(k());
            j();
        }
    }

    public boolean k() {
        return !z();
    }

    public PreferenceGroup O() {
        return this.J;
    }

    private void d() {
        if (t() != null) {
            a(true, this.v);
            return;
        }
        if (!F() || !I().contains(this.n)) {
            if (this.v != null) {
                a(false, this.v);
                return;
            }
            return;
        }
        a(true, (Object) null);
    }

    @Deprecated
    protected void a(boolean z, Object obj) {
        a(obj);
    }

    private void a(SharedPreferences.Editor editor) {
        if (this.f951b.f()) {
            editor.apply();
        }
    }

    protected boolean e(String str) {
        if (!F()) {
            return false;
        }
        if (TextUtils.equals(str, f((String) null))) {
            return true;
        }
        e eVarT = t();
        if (eVarT != null) {
            eVarT.a(this.n, str);
        } else {
            SharedPreferences.Editor editorE = this.f951b.e();
            editorE.putString(this.n, str);
            a(editorE);
        }
        return true;
    }

    protected String f(String str) {
        if (!F()) {
            return str;
        }
        e eVarT = t();
        if (eVarT != null) {
            return eVarT.b(this.n, str);
        }
        return this.f951b.c().getString(this.n, str);
    }

    public boolean b(Set<String> set) {
        if (!F()) {
            return false;
        }
        if (set.equals(c((Set<String>) null))) {
            return true;
        }
        e eVarT = t();
        if (eVarT != null) {
            eVarT.a(this.n, set);
        } else {
            SharedPreferences.Editor editorE = this.f951b.e();
            editorE.putStringSet(this.n, set);
            a(editorE);
        }
        return true;
    }

    public Set<String> c(Set<String> set) {
        if (!F()) {
            return set;
        }
        e eVarT = t();
        if (eVarT != null) {
            return eVarT.b(this.n, set);
        }
        return this.f951b.c().getStringSet(this.n, set);
    }

    protected boolean e(int i) {
        if (!F()) {
            return false;
        }
        if (i == f(i ^ (-1))) {
            return true;
        }
        e eVarT = t();
        if (eVarT != null) {
            eVarT.a(this.n, i);
        } else {
            SharedPreferences.Editor editorE = this.f951b.e();
            editorE.putInt(this.n, i);
            a(editorE);
        }
        return true;
    }

    protected int f(int i) {
        if (!F()) {
            return i;
        }
        e eVarT = t();
        if (eVarT != null) {
            return eVarT.b(this.n, i);
        }
        return this.f951b.c().getInt(this.n, i);
    }

    protected boolean c(boolean z) {
        if (!F()) {
            return false;
        }
        if (z == d(!z)) {
            return true;
        }
        e eVarT = t();
        if (eVarT != null) {
            eVarT.a(this.n, z);
        } else {
            SharedPreferences.Editor editorE = this.f951b.e();
            editorE.putBoolean(this.n, z);
            a(editorE);
        }
        return true;
    }

    protected boolean d(boolean z) {
        if (!F()) {
            return z;
        }
        e eVarT = t();
        if (eVarT != null) {
            return eVarT.b(this.n, z);
        }
        return this.f951b.c().getBoolean(this.n, z);
    }

    public String toString() {
        return P().toString();
    }

    StringBuilder P() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceY = y();
        if (!TextUtils.isEmpty(charSequenceY)) {
            sb.append(charSequenceY);
            sb.append(' ');
        }
        CharSequence charSequenceO = o();
        if (!TextUtils.isEmpty(charSequenceO)) {
            sb.append(charSequenceO);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public void a(Bundle bundle) {
        b(bundle);
    }

    void b(Bundle bundle) {
        if (D()) {
            this.L = false;
            Parcelable parcelableL = l();
            if (!this.L) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (parcelableL != null) {
                bundle.putParcelable(this.n, parcelableL);
            }
        }
    }

    protected Parcelable l() {
        this.L = true;
        return a.EMPTY_STATE;
    }

    public void c(Bundle bundle) {
        d(bundle);
    }

    void d(Bundle bundle) {
        Parcelable parcelable;
        if (!D() || (parcelable = bundle.getParcelable(this.n)) == null) {
            return;
        }
        this.L = false;
        a(parcelable);
        if (!this.L) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    protected void a(Parcelable parcelable) {
        this.L = true;
        if (parcelable != a.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public static class a extends AbsSavedState {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: androidx.preference.Preference.a.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }
        };

        public a(Parcel parcel) {
            super(parcel);
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
