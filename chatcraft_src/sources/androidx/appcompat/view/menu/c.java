package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BaseMenuWrapper.java */
/* loaded from: classes.dex */
abstract class c<T> extends d<T> {

    /* renamed from: a, reason: collision with root package name */
    final Context f219a;
    private Map<androidx.core.b.a.b, MenuItem> c;
    private Map<androidx.core.b.a.c, SubMenu> d;

    c(Context context, T t) {
        super(t);
        this.f219a = context;
    }

    final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof androidx.core.b.a.b)) {
            return menuItem;
        }
        androidx.core.b.a.b bVar = (androidx.core.b.a.b) menuItem;
        if (this.c == null) {
            this.c = new androidx.b.a();
        }
        MenuItem menuItem2 = this.c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem menuItemA = q.a(this.f219a, bVar);
        this.c.put(bVar, menuItemA);
        return menuItemA;
    }

    final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof androidx.core.b.a.c)) {
            return subMenu;
        }
        androidx.core.b.a.c cVar = (androidx.core.b.a.c) subMenu;
        if (this.d == null) {
            this.d = new androidx.b.a();
        }
        SubMenu subMenu2 = this.d.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu subMenuA = q.a(this.f219a, cVar);
        this.d.put(cVar, subMenuA);
        return subMenuA;
    }

    final void a() {
        if (this.c != null) {
            this.c.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }

    final void a(int i) {
        if (this.c == null) {
            return;
        }
        Iterator<androidx.core.b.a.b> it = this.c.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    final void b(int i) {
        if (this.c == null) {
            return;
        }
        Iterator<androidx.core.b.a.b> it = this.c.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
