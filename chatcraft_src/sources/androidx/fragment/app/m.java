package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* compiled from: FragmentStatePagerAdapter.java */
/* loaded from: classes.dex */
public abstract class m extends androidx.viewpager.widget.a {

    /* renamed from: a, reason: collision with root package name */
    private final h f762a;

    /* renamed from: b, reason: collision with root package name */
    private n f763b = null;
    private ArrayList<Fragment.c> c = new ArrayList<>();
    private ArrayList<Fragment> d = new ArrayList<>();
    private Fragment e = null;

    public abstract Fragment a(int i);

    public m(h hVar) {
        this.f762a = hVar;
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    @Override // androidx.viewpager.widget.a
    public Object a(ViewGroup viewGroup, int i) {
        Fragment.c cVar;
        Fragment fragment;
        if (this.d.size() > i && (fragment = this.d.get(i)) != null) {
            return fragment;
        }
        if (this.f763b == null) {
            this.f763b = this.f762a.a();
        }
        Fragment fragmentA = a(i);
        if (this.c.size() > i && (cVar = this.c.get(i)) != null) {
            fragmentA.a(cVar);
        }
        while (this.d.size() <= i) {
            this.d.add(null);
        }
        fragmentA.d(false);
        fragmentA.e(false);
        this.d.set(i, fragmentA);
        this.f763b.a(viewGroup.getId(), fragmentA);
        return fragmentA;
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f763b == null) {
            this.f763b = this.f762a.a();
        }
        while (this.c.size() <= i) {
            this.c.add(null);
        }
        this.c.set(i, fragment.s() ? this.f762a.a(fragment) : null);
        this.d.set(i, null);
        this.f763b.a(fragment);
    }

    @Override // androidx.viewpager.widget.a
    public void b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.e) {
            if (this.e != null) {
                this.e.d(false);
                this.e.e(false);
            }
            fragment.d(true);
            fragment.e(true);
            this.e = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void b(ViewGroup viewGroup) {
        if (this.f763b != null) {
            this.f763b.e();
            this.f763b = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public boolean a(View view, Object obj) {
        return ((Fragment) obj).u() == view;
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable a() {
        Bundle bundle;
        if (this.c.size() > 0) {
            bundle = new Bundle();
            Fragment.c[] cVarArr = new Fragment.c[this.c.size()];
            this.c.toArray(cVarArr);
            bundle.putParcelableArray("states", cVarArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.d.size(); i++) {
            Fragment fragment = this.d.get(i);
            if (fragment != null && fragment.s()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f762a.a(bundle, "f" + i, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.a
    public void a(Parcelable parcelable, ClassLoader classLoader) throws NumberFormatException {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.c.clear();
            this.d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.c.add((Fragment.c) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i = Integer.parseInt(str.substring(1));
                    Fragment fragmentA = this.f762a.a(bundle, str);
                    if (fragmentA != null) {
                        while (this.d.size() <= i) {
                            this.d.add(null);
                        }
                        fragmentA.d(false);
                        this.d.set(i, fragmentA);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
