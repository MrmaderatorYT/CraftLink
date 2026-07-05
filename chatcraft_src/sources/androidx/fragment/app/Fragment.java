package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.g, androidx.lifecycle.s {

    /* renamed from: a, reason: collision with root package name */
    private static final androidx.b.g<String, Class<?>> f707a = new androidx.b.g<>();
    static final Object j = new Object();
    int A;
    i B;
    g C;
    i D;
    j E;
    androidx.lifecycle.r F;
    Fragment G;
    int H;
    int I;
    String J;
    boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    boolean Q;
    ViewGroup R;
    View S;
    View T;
    boolean U;
    a W;
    boolean X;
    boolean Y;
    float Z;
    LayoutInflater aa;
    boolean ab;
    androidx.lifecycle.h ad;
    androidx.lifecycle.g ae;
    Bundle l;
    SparseArray<Parcelable> m;
    Boolean n;
    String p;
    Bundle q;
    Fragment r;
    int t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;
    int k = 0;
    int o = -1;
    int s = -1;
    boolean P = true;
    boolean V = true;
    androidx.lifecycle.h ac = new androidx.lifecycle.h(this);
    androidx.lifecycle.l<androidx.lifecycle.g> af = new androidx.lifecycle.l<>();

    interface b {
        void a();

        void b();
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void a(int i, String[] strArr, int[] iArr) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(Fragment fragment) {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public Animator b(int i, boolean z, int i2) {
        return null;
    }

    public void b(Menu menu) {
    }

    public void b(boolean z) {
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public void e(Bundle bundle) {
    }

    public void f(boolean z) {
    }

    public void g(boolean z) {
    }

    public void z() {
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.e g() {
        return this.ac;
    }

    @Override // androidx.lifecycle.s
    public androidx.lifecycle.r a_() {
        if (l() == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.F == null) {
            this.F = new androidx.lifecycle.r();
        }
        return this.F;
    }

    public static class c implements Parcelable {
        public static final Parcelable.Creator<c> CREATOR = new Parcelable.ClassLoaderCreator<c>() { // from class: androidx.fragment.app.Fragment.c.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i) {
                return new c[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        final Bundle f713a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        c(Bundle bundle) {
            this.f713a = bundle;
        }

        c(Parcel parcel, ClassLoader classLoader) {
            this.f713a = parcel.readBundle();
            if (classLoader == null || this.f713a == null) {
                return;
            }
            this.f713a.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f713a);
        }
    }

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static Fragment a(Context context, String str, Bundle bundle) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = f707a.get(str);
            if (clsLoadClass == null) {
                clsLoadClass = context.getClassLoader().loadClass(str);
                f707a.put(str, clsLoadClass);
            }
            Fragment fragment = (Fragment) clsLoadClass.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.g(bundle);
            }
            return fragment;
        } catch (ClassNotFoundException e) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (java.lang.InstantiationException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    static boolean a(Context context, String str) throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = f707a.get(str);
            if (clsLoadClass == null) {
                clsLoadClass = context.getClassLoader().loadClass(str);
                f707a.put(str, clsLoadClass);
            }
            return Fragment.class.isAssignableFrom(clsLoadClass);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    final void f(Bundle bundle) {
        if (this.m != null) {
            this.T.restoreHierarchyState(this.m);
            this.m = null;
        }
        this.Q = false;
        k(bundle);
        if (!this.Q) {
            throw new s("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
        if (this.S != null) {
            this.ad.a(e.a.ON_CREATE);
        }
    }

    final void a(int i, Fragment fragment) {
        this.o = i;
        if (fragment != null) {
            this.p = fragment.p + ":" + this.o;
            return;
        }
        this.p = "android:fragment:" + this.o;
    }

    final boolean h() {
        return this.A > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        androidx.core.f.a.a(this, sb);
        if (this.o >= 0) {
            sb.append(" #");
            sb.append(this.o);
        }
        if (this.H != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.H));
        }
        if (this.J != null) {
            sb.append(" ");
            sb.append(this.J);
        }
        sb.append('}');
        return sb.toString();
    }

    public void g(Bundle bundle) {
        if (this.o >= 0 && j()) {
            throw new IllegalStateException("Fragment already active and state has been saved");
        }
        this.q = bundle;
    }

    public final Bundle i() {
        return this.q;
    }

    public final boolean j() {
        if (this.B == null) {
            return false;
        }
        return this.B.d();
    }

    public void a(c cVar) {
        if (this.o >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.l = (cVar == null || cVar.f713a == null) ? null : cVar.f713a;
    }

    public void a(Fragment fragment, int i) {
        h hVarP = p();
        h hVarP2 = fragment != null ? fragment.p() : null;
        if (hVarP != null && hVarP2 != null && hVarP != hVarP2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragmentK = fragment; fragmentK != null; fragmentK = fragmentK.k()) {
            if (fragmentK == this) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        this.r = fragment;
        this.t = i;
    }

    public final Fragment k() {
        return this.r;
    }

    public Context l() {
        if (this.C == null) {
            return null;
        }
        return this.C.g();
    }

    public final Context m() {
        Context contextL = l();
        if (contextL != null) {
            return contextL;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final d n() {
        if (this.C == null) {
            return null;
        }
        return (d) this.C.f();
    }

    public final Resources o() {
        return m().getResources();
    }

    public final String a(int i) {
        return o().getString(i);
    }

    public final h p() {
        return this.B;
    }

    public final h q() {
        if (this.D == null) {
            K();
            if (this.k >= 4) {
                this.D.q();
            } else if (this.k >= 3) {
                this.D.p();
            } else if (this.k >= 2) {
                this.D.o();
            } else if (this.k >= 1) {
                this.D.n();
            }
        }
        return this.D;
    }

    h r() {
        return this.D;
    }

    public final boolean s() {
        return this.C != null && this.u;
    }

    public final boolean t() {
        return this.K;
    }

    public void c(boolean z) {
        this.M = z;
    }

    public void d(boolean z) {
        if (this.P != z) {
            this.P = z;
            if (this.O && s() && !t()) {
                this.C.c();
            }
        }
    }

    public void e(boolean z) {
        if (!this.V && z && this.k < 3 && this.B != null && s() && this.ab) {
            this.B.b(this);
        }
        this.V = z;
        this.U = this.k < 3 && !z;
        if (this.l != null) {
            this.n = Boolean.valueOf(z);
        }
    }

    public void a(Intent intent) {
        a(intent, (Bundle) null);
    }

    public void a(Intent intent, Bundle bundle) {
        if (this.C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.C.a(this, intent, -1, bundle);
    }

    public LayoutInflater b(Bundle bundle) {
        return i(bundle);
    }

    LayoutInflater h(Bundle bundle) {
        this.aa = b(bundle);
        return this.aa;
    }

    @Deprecated
    public LayoutInflater i(Bundle bundle) throws IllegalAccessException, IllegalArgumentException {
        if (this.C == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterB = this.C.b();
        q();
        androidx.core.g.e.a(layoutInflaterB, this.D.x());
        return layoutInflaterB;
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.Q = true;
        Activity activityF = this.C == null ? null : this.C.f();
        if (activityF != null) {
            this.Q = false;
            a(activityF, attributeSet, bundle);
        }
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.Q = true;
    }

    public void a(Context context) {
        this.Q = true;
        Activity activityF = this.C == null ? null : this.C.f();
        if (activityF != null) {
            this.Q = false;
            a(activityF);
        }
    }

    @Deprecated
    public void a(Activity activity) {
        this.Q = true;
    }

    public void a(Bundle bundle) {
        this.Q = true;
        j(bundle);
        if (this.D == null || this.D.a(1)) {
            return;
        }
        this.D.n();
    }

    void j(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        if (this.D == null) {
            K();
        }
        this.D.a(parcelable, this.E);
        this.E = null;
        this.D.n();
    }

    public View u() {
        return this.S;
    }

    public void d(Bundle bundle) {
        this.Q = true;
    }

    public void k(Bundle bundle) {
        this.Q = true;
    }

    public void c() {
        this.Q = true;
    }

    public void v() {
        this.Q = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.Q = true;
    }

    public void w() {
        this.Q = true;
    }

    public void d() {
        this.Q = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.Q = true;
    }

    public void e() {
        this.Q = true;
    }

    public void x() {
        this.Q = true;
        d dVarN = n();
        boolean z = dVarN != null && dVarN.isChangingConfigurations();
        if (this.F == null || z) {
            return;
        }
        this.F.a();
    }

    void y() {
        this.o = -1;
        this.p = null;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.A = 0;
        this.B = null;
        this.D = null;
        this.C = null;
        this.H = 0;
        this.I = 0;
        this.J = null;
        this.K = false;
        this.L = false;
        this.N = false;
    }

    public void b() {
        this.Q = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        n().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public Object A() {
        if (this.W == null) {
            return null;
        }
        return this.W.g;
    }

    public Object B() {
        if (this.W == null) {
            return null;
        }
        return this.W.h == j ? A() : this.W.h;
    }

    public Object C() {
        if (this.W == null) {
            return null;
        }
        return this.W.i;
    }

    public Object D() {
        if (this.W == null) {
            return null;
        }
        return this.W.j == j ? C() : this.W.j;
    }

    public Object E() {
        if (this.W == null) {
            return null;
        }
        return this.W.k;
    }

    public Object F() {
        if (this.W == null) {
            return null;
        }
        return this.W.l == j ? E() : this.W.l;
    }

    public boolean G() {
        if (this.W == null || this.W.n == null) {
            return true;
        }
        return this.W.n.booleanValue();
    }

    public boolean H() {
        if (this.W == null || this.W.m == null) {
            return true;
        }
        return this.W.m.booleanValue();
    }

    public void I() {
        if (this.B == null || this.B.m == null) {
            a().q = false;
        } else if (Looper.myLooper() != this.B.m.h().getLooper()) {
            this.B.m.h().postAtFrontOfQueue(new Runnable() { // from class: androidx.fragment.app.Fragment.1
                @Override // java.lang.Runnable
                public void run() {
                    Fragment.this.J();
                }
            });
        } else {
            J();
        }
    }

    void J() {
        b bVar;
        if (this.W == null) {
            bVar = null;
        } else {
            this.W.q = false;
            bVar = this.W.r;
            this.W.r = null;
        }
        if (bVar != null) {
            bVar.a();
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.H));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.I));
        printWriter.print(" mTag=");
        printWriter.println(this.J);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.k);
        printWriter.print(" mIndex=");
        printWriter.print(this.o);
        printWriter.print(" mWho=");
        printWriter.print(this.p);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.A);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.u);
        printWriter.print(" mRemoving=");
        printWriter.print(this.v);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.w);
        printWriter.print(" mInLayout=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.K);
        printWriter.print(" mDetached=");
        printWriter.print(this.L);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.P);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.O);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.M);
        printWriter.print(" mRetaining=");
        printWriter.print(this.N);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.V);
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.B);
        }
        if (this.C != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.C);
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.G);
        }
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.q);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.l);
        }
        if (this.m != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.m);
        }
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.r);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.t);
        }
        if (U() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(U());
        }
        if (this.R != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.R);
        }
        if (this.S != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.S);
        }
        if (this.T != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.S);
        }
        if (Z() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(Z());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(ab());
        }
        if (l() != null) {
            androidx.h.a.a.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        if (this.D != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.D + ":");
            this.D.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    Fragment a(String str) {
        if (str.equals(this.p)) {
            return this;
        }
        if (this.D != null) {
            return this.D.b(str);
        }
        return null;
    }

    void K() {
        if (this.C == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }
        this.D = new i();
        this.D.a(this.C, new e() { // from class: androidx.fragment.app.Fragment.2
            @Override // androidx.fragment.app.e
            public View a(int i) {
                if (Fragment.this.S == null) {
                    throw new IllegalStateException("Fragment does not have a view");
                }
                return Fragment.this.S.findViewById(i);
            }

            @Override // androidx.fragment.app.e
            public boolean a() {
                return Fragment.this.S != null;
            }

            @Override // androidx.fragment.app.e
            public Fragment a(Context context, String str, Bundle bundle) {
                return Fragment.this.C.a(context, str, bundle);
            }
        }, this);
    }

    void l(Bundle bundle) {
        if (this.D != null) {
            this.D.m();
        }
        this.k = 1;
        this.Q = false;
        a(bundle);
        this.ab = true;
        if (!this.Q) {
            throw new s("Fragment " + this + " did not call through to super.onCreate()");
        }
        this.ac.a(e.a.ON_CREATE);
    }

    void b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.D != null) {
            this.D.m();
        }
        this.z = true;
        this.ae = new androidx.lifecycle.g() { // from class: androidx.fragment.app.Fragment.3
            @Override // androidx.lifecycle.g
            public androidx.lifecycle.e g() {
                if (Fragment.this.ad == null) {
                    Fragment.this.ad = new androidx.lifecycle.h(Fragment.this.ae);
                }
                return Fragment.this.ad;
            }
        };
        this.ad = null;
        this.S = a(layoutInflater, viewGroup, bundle);
        if (this.S != null) {
            this.ae.g();
            this.af.a((androidx.lifecycle.l<androidx.lifecycle.g>) this.ae);
        } else {
            if (this.ad != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.ae = null;
        }
    }

    void m(Bundle bundle) {
        if (this.D != null) {
            this.D.m();
        }
        this.k = 2;
        this.Q = false;
        d(bundle);
        if (!this.Q) {
            throw new s("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        if (this.D != null) {
            this.D.o();
        }
    }

    void L() {
        if (this.D != null) {
            this.D.m();
            this.D.g();
        }
        this.k = 3;
        this.Q = false;
        c();
        if (!this.Q) {
            throw new s("Fragment " + this + " did not call through to super.onStart()");
        }
        if (this.D != null) {
            this.D.p();
        }
        this.ac.a(e.a.ON_START);
        if (this.S != null) {
            this.ad.a(e.a.ON_START);
        }
    }

    void M() {
        if (this.D != null) {
            this.D.m();
            this.D.g();
        }
        this.k = 4;
        this.Q = false;
        v();
        if (!this.Q) {
            throw new s("Fragment " + this + " did not call through to super.onResume()");
        }
        if (this.D != null) {
            this.D.q();
            this.D.g();
        }
        this.ac.a(e.a.ON_RESUME);
        if (this.S != null) {
            this.ad.a(e.a.ON_RESUME);
        }
    }

    void N() {
        if (this.D != null) {
            this.D.m();
        }
    }

    void h(boolean z) {
        f(z);
        if (this.D != null) {
            this.D.a(z);
        }
    }

    void i(boolean z) {
        g(z);
        if (this.D != null) {
            this.D.b(z);
        }
    }

    void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.D != null) {
            this.D.a(configuration);
        }
    }

    void O() {
        onLowMemory();
        if (this.D != null) {
            this.D.v();
        }
    }

    boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.K) {
            return false;
        }
        if (this.O && this.P) {
            z = true;
            a(menu, menuInflater);
        }
        return this.D != null ? z | this.D.a(menu, menuInflater) : z;
    }

    boolean c(Menu menu) {
        boolean z = false;
        if (this.K) {
            return false;
        }
        if (this.O && this.P) {
            z = true;
            a(menu);
        }
        return this.D != null ? z | this.D.a(menu) : z;
    }

    boolean c(MenuItem menuItem) {
        if (this.K) {
            return false;
        }
        if (this.O && this.P && a(menuItem)) {
            return true;
        }
        return this.D != null && this.D.a(menuItem);
    }

    boolean d(MenuItem menuItem) {
        if (this.K) {
            return false;
        }
        if (b(menuItem)) {
            return true;
        }
        return this.D != null && this.D.b(menuItem);
    }

    void d(Menu menu) {
        if (this.K) {
            return;
        }
        if (this.O && this.P) {
            b(menu);
        }
        if (this.D != null) {
            this.D.b(menu);
        }
    }

    void n(Bundle bundle) {
        Parcelable parcelableL;
        e(bundle);
        if (this.D == null || (parcelableL = this.D.l()) == null) {
            return;
        }
        bundle.putParcelable("android:support:fragments", parcelableL);
    }

    void P() {
        if (this.S != null) {
            this.ad.a(e.a.ON_PAUSE);
        }
        this.ac.a(e.a.ON_PAUSE);
        if (this.D != null) {
            this.D.r();
        }
        this.k = 3;
        this.Q = false;
        w();
        if (this.Q) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onPause()");
    }

    void Q() {
        if (this.S != null) {
            this.ad.a(e.a.ON_STOP);
        }
        this.ac.a(e.a.ON_STOP);
        if (this.D != null) {
            this.D.s();
        }
        this.k = 2;
        this.Q = false;
        d();
        if (this.Q) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onStop()");
    }

    void R() {
        if (this.S != null) {
            this.ad.a(e.a.ON_DESTROY);
        }
        if (this.D != null) {
            this.D.t();
        }
        this.k = 1;
        this.Q = false;
        e();
        if (!this.Q) {
            throw new s("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        androidx.h.a.a.a(this).a();
        this.z = false;
    }

    void S() {
        this.ac.a(e.a.ON_DESTROY);
        if (this.D != null) {
            this.D.u();
        }
        this.k = 0;
        this.Q = false;
        this.ab = false;
        x();
        if (!this.Q) {
            throw new s("Fragment " + this + " did not call through to super.onDestroy()");
        }
        this.D = null;
    }

    void T() {
        this.Q = false;
        b();
        this.aa = null;
        if (!this.Q) {
            throw new s("Fragment " + this + " did not call through to super.onDetach()");
        }
        if (this.D != null) {
            if (!this.N) {
                throw new IllegalStateException("Child FragmentManager of " + this + " was not  destroyed and this fragment is not retaining instance");
            }
            this.D.u();
            this.D = null;
        }
    }

    void a(b bVar) {
        a();
        if (bVar == this.W.r) {
            return;
        }
        if (bVar != null && this.W.r != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (this.W.q) {
            this.W.r = bVar;
        }
        if (bVar != null) {
            bVar.b();
        }
    }

    private a a() {
        if (this.W == null) {
            this.W = new a();
        }
        return this.W;
    }

    int U() {
        if (this.W == null) {
            return 0;
        }
        return this.W.d;
    }

    void b(int i) {
        if (this.W == null && i == 0) {
            return;
        }
        a().d = i;
    }

    int V() {
        if (this.W == null) {
            return 0;
        }
        return this.W.e;
    }

    void a(int i, int i2) {
        if (this.W == null && i == 0 && i2 == 0) {
            return;
        }
        a();
        this.W.e = i;
        this.W.f = i2;
    }

    int W() {
        if (this.W == null) {
            return 0;
        }
        return this.W.f;
    }

    androidx.core.app.l X() {
        if (this.W == null) {
            return null;
        }
        return this.W.o;
    }

    androidx.core.app.l Y() {
        if (this.W == null) {
            return null;
        }
        return this.W.p;
    }

    View Z() {
        if (this.W == null) {
            return null;
        }
        return this.W.f711a;
    }

    void a(View view) {
        a().f711a = view;
    }

    void a(Animator animator) {
        a().f712b = animator;
    }

    Animator aa() {
        if (this.W == null) {
            return null;
        }
        return this.W.f712b;
    }

    int ab() {
        if (this.W == null) {
            return 0;
        }
        return this.W.c;
    }

    void c(int i) {
        a().c = i;
    }

    boolean ac() {
        if (this.W == null) {
            return false;
        }
        return this.W.q;
    }

    boolean ad() {
        if (this.W == null) {
            return false;
        }
        return this.W.s;
    }

    void j(boolean z) {
        a().s = z;
    }

    static class a {

        /* renamed from: a, reason: collision with root package name */
        View f711a;

        /* renamed from: b, reason: collision with root package name */
        Animator f712b;
        int c;
        int d;
        int e;
        int f;
        Boolean m;
        Boolean n;
        boolean q;
        b r;
        boolean s;
        Object g = null;
        Object h = Fragment.j;
        Object i = null;
        Object j = Fragment.j;
        Object k = null;
        Object l = Fragment.j;
        androidx.core.app.l o = null;
        androidx.core.app.l p = null;

        a() {
        }
    }
}
