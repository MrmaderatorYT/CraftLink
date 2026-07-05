package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.p;
import java.util.ArrayList;

/* compiled from: MenuAdapter.java */
/* loaded from: classes.dex */
public class g extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    h f234a;

    /* renamed from: b, reason: collision with root package name */
    private int f235b = -1;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public g(h hVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.f234a = hVar;
        this.f = i;
        b();
    }

    public void a(boolean z) {
        this.c = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<j> arrayListM = this.d ? this.f234a.m() : this.f234a.j();
        if (this.f235b < 0) {
            return arrayListM.size();
        }
        return arrayListM.size() - 1;
    }

    public h a() {
        return this.f234a;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j getItem(int i) {
        ArrayList<j> arrayListM = this.d ? this.f234a.m() : this.f234a.j();
        if (this.f235b >= 0 && i >= this.f235b) {
            i++;
        }
        return arrayListM.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f234a.b() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        p.a aVar = (p.a) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    void b() {
        j jVarS = this.f234a.s();
        if (jVarS != null) {
            ArrayList<j> arrayListM = this.f234a.m();
            int size = arrayListM.size();
            for (int i = 0; i < size; i++) {
                if (arrayListM.get(i) == jVarS) {
                    this.f235b = i;
                    return;
                }
            }
        }
        this.f235b = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
