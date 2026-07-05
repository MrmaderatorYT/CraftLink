package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.q;
import androidx.preference.Preference;
import androidx.preference.j;
import androidx.preference.m;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PreferenceGroupAdapter.java */
/* loaded from: classes.dex */
public class h extends RecyclerView.a<l> implements Preference.b {

    /* renamed from: a, reason: collision with root package name */
    private PreferenceGroup f984a;

    /* renamed from: b, reason: collision with root package name */
    private List<Preference> f985b;
    private List<Preference> c;
    private List<a> d;
    private a e;
    private Handler f;
    private androidx.preference.a g;
    private Runnable h;

    /* compiled from: PreferenceGroupAdapter.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        int f989a;

        /* renamed from: b, reason: collision with root package name */
        int f990b;
        String c;

        a() {
        }

        a(a aVar) {
            this.f989a = aVar.f989a;
            this.f990b = aVar.f990b;
            this.c = aVar.c;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f989a == aVar.f989a && this.f990b == aVar.f990b && TextUtils.equals(this.c, aVar.c);
        }

        public int hashCode() {
            return ((((527 + this.f989a) * 31) + this.f990b) * 31) + this.c.hashCode();
        }
    }

    public h(PreferenceGroup preferenceGroup) {
        this(preferenceGroup, new Handler());
    }

    private h(PreferenceGroup preferenceGroup, Handler handler) {
        this.e = new a();
        this.h = new Runnable() { // from class: androidx.preference.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.a();
            }
        };
        this.f984a = preferenceGroup;
        this.f = handler;
        this.g = new androidx.preference.a(preferenceGroup, this);
        this.f984a.a((Preference.b) this);
        this.f985b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        if (this.f984a instanceof PreferenceScreen) {
            a(((PreferenceScreen) this.f984a).g());
        } else {
            a(true);
        }
        a();
    }

    void a() {
        Iterator<Preference> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a((Preference.b) null);
        }
        ArrayList arrayList = new ArrayList(this.c.size());
        a(arrayList, this.f984a);
        final List<Preference> listA = this.g.a(this.f984a);
        final List<Preference> list = this.f985b;
        this.f985b = listA;
        this.c = arrayList;
        j jVarK = this.f984a.K();
        if (jVarK != null && jVarK.g() != null) {
            final j.d dVarG = jVarK.g();
            androidx.recyclerview.widget.f.a(new f.a() { // from class: androidx.preference.h.2
                @Override // androidx.recyclerview.widget.f.a
                public int a() {
                    return list.size();
                }

                @Override // androidx.recyclerview.widget.f.a
                public int b() {
                    return listA.size();
                }

                @Override // androidx.recyclerview.widget.f.a
                public boolean a(int i, int i2) {
                    return dVarG.a((Preference) list.get(i), (Preference) listA.get(i2));
                }

                @Override // androidx.recyclerview.widget.f.a
                public boolean b(int i, int i2) {
                    return dVarG.b((Preference) list.get(i), (Preference) listA.get(i2));
                }
            }).a(this);
        } else {
            e();
        }
        Iterator<Preference> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().N();
        }
    }

    private void a(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.f();
        int iC = preferenceGroup.c();
        for (int i = 0; i < iC; i++) {
            Preference preferenceH = preferenceGroup.h(i);
            list.add(preferenceH);
            c(preferenceH);
            if (preferenceH instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceH;
                if (preferenceGroup2.d()) {
                    a(list, preferenceGroup2);
                }
            }
            preferenceH.a((Preference.b) this);
        }
    }

    private a a(Preference preference, a aVar) {
        if (aVar == null) {
            aVar = new a();
        }
        aVar.c = preference.getClass().getName();
        aVar.f989a = preference.v();
        aVar.f990b = preference.w();
        return aVar;
    }

    private void c(Preference preference) {
        a aVarA = a(preference, (a) null);
        if (this.d.contains(aVarA)) {
            return;
        }
        this.d.add(aVarA);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int b() {
        return this.f985b.size();
    }

    public Preference a(int i) {
        if (i < 0 || i >= b()) {
            return null;
        }
        return this.f985b.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public long b(int i) {
        if (c()) {
            return a(i).a();
        }
        return -1L;
    }

    @Override // androidx.preference.Preference.b
    public void a(Preference preference) {
        int iIndexOf = this.f985b.indexOf(preference);
        if (iIndexOf != -1) {
            a(iIndexOf, preference);
        }
    }

    @Override // androidx.preference.Preference.b
    public void b(Preference preference) {
        this.f.removeCallbacks(this.h);
        this.f.post(this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int c(int i) {
        this.e = a(a(i), this.e);
        int iIndexOf = this.d.indexOf(this.e);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.d.size();
        this.d.add(new a(this.e));
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public l b(ViewGroup viewGroup, int i) {
        a aVar = this.d.get(i);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, m.g.BackgroundStyle);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(m.g.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = androidx.core.a.a.a(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(aVar.f989a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            q.a(viewInflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            if (aVar.f990b != 0) {
                layoutInflaterFrom.inflate(aVar.f990b, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new l(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(l lVar, int i) {
        a(i).a(lVar);
    }
}
