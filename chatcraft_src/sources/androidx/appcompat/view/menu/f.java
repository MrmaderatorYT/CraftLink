package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter.java */
/* loaded from: classes.dex */
public class f implements AdapterView.OnItemClickListener, o {

    /* renamed from: a, reason: collision with root package name */
    Context f230a;

    /* renamed from: b, reason: collision with root package name */
    LayoutInflater f231b;
    h c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    a h;
    private o.a i;

    @Override // androidx.appcompat.view.menu.o
    public boolean a(h hVar, j jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean b(h hVar, j jVar) {
        return false;
    }

    public f(Context context, int i) {
        this(i, 0);
        this.f230a = context;
        this.f231b = LayoutInflater.from(this.f230a);
    }

    public f(int i, int i2) {
        this.g = i;
        this.f = i2;
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(Context context, h hVar) {
        if (this.f != 0) {
            this.f230a = new ContextThemeWrapper(context, this.f);
            this.f231b = LayoutInflater.from(this.f230a);
        } else if (this.f230a != null) {
            this.f230a = context;
            if (this.f231b == null) {
                this.f231b = LayoutInflater.from(this.f230a);
            }
        }
        this.c = hVar;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    public p a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.f231b.inflate(a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a();
            }
            this.d.setAdapter((ListAdapter) this.h);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(boolean z) {
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(o.a aVar) {
        this.i = aVar;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean a(u uVar) {
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        new i(uVar).a((IBinder) null);
        if (this.i == null) {
            return true;
        }
        this.i.a(uVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(h hVar, boolean z) {
        if (this.i != null) {
            this.i.a(hVar, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.c.a(this.h.getItem(i), this, 0);
    }

    /* compiled from: ListMenuPresenter.java */
    private class a extends BaseAdapter {

        /* renamed from: b, reason: collision with root package name */
        private int f233b = -1;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public a() {
            a();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = f.this.c.m().size() - f.this.e;
            return this.f233b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j getItem(int i) {
            ArrayList<j> arrayListM = f.this.c.m();
            int i2 = i + f.this.e;
            if (this.f233b >= 0 && i2 >= this.f233b) {
                i2++;
            }
            return arrayListM.get(i2);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = f.this.f231b.inflate(f.this.g, viewGroup, false);
            }
            ((p.a) view).a(getItem(i), 0);
            return view;
        }

        void a() {
            j jVarS = f.this.c.s();
            if (jVarS != null) {
                ArrayList<j> arrayListM = f.this.c.m();
                int size = arrayListM.size();
                for (int i = 0; i < size; i++) {
                    if (arrayListM.get(i) == jVarS) {
                        this.f233b = i;
                        return;
                    }
                }
            }
            this.f233b = -1;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }
}
