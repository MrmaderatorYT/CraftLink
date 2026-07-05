package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.ah;
import androidx.appcompat.widget.ai;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
final class e extends m implements View.OnKeyListener, PopupWindow.OnDismissListener, o {
    private static final int g = a.g.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;

    /* renamed from: a, reason: collision with root package name */
    final Handler f221a;
    View d;
    ViewTreeObserver e;
    boolean f;
    private final Context h;
    private final int i;
    private final int j;
    private final int k;
    private final boolean l;
    private View r;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean y;
    private o.a z;
    private final List<h> m = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    final List<a> f222b = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener c = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.e.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!e.this.d() || e.this.f222b.size() <= 0 || e.this.f222b.get(0).f228a.g()) {
                return;
            }
            View view = e.this.d;
            if (view == null || !view.isShown()) {
                e.this.c();
                return;
            }
            Iterator<a> it = e.this.f222b.iterator();
            while (it.hasNext()) {
                it.next().f228a.a();
            }
        }
    };
    private final View.OnAttachStateChangeListener n = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.e.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (e.this.e != null) {
                if (!e.this.e.isAlive()) {
                    e.this.e = view.getViewTreeObserver();
                }
                e.this.e.removeGlobalOnLayoutListener(e.this.c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final ah o = new ah() { // from class: androidx.appcompat.view.menu.e.3
        @Override // androidx.appcompat.widget.ah
        public void a(h hVar, MenuItem menuItem) {
            e.this.f221a.removeCallbacksAndMessages(hVar);
        }

        @Override // androidx.appcompat.widget.ah
        public void b(final h hVar, final MenuItem menuItem) {
            e.this.f221a.removeCallbacksAndMessages(null);
            int size = e.this.f222b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (hVar == e.this.f222b.get(i).f229b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            final a aVar = i2 < e.this.f222b.size() ? e.this.f222b.get(i2) : null;
            e.this.f221a.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.e.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        e.this.f = true;
                        aVar.f229b.a(false);
                        e.this.f = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        hVar.a(menuItem, 4);
                    }
                }
            }, hVar, SystemClock.uptimeMillis() + 200);
        }
    };
    private int p = 0;
    private int q = 0;
    private boolean x = false;
    private int s = i();

    @Override // androidx.appcompat.view.menu.o
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    protected boolean f() {
        return false;
    }

    public e(Context context, View view, int i, int i2, boolean z) {
        this.h = context;
        this.r = view;
        this.j = i;
        this.k = i2;
        this.l = z;
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.f221a = new Handler();
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(boolean z) {
        this.x = z;
    }

    private ai h() {
        ai aiVar = new ai(this.h, null, this.j, this.k);
        aiVar.a(this.o);
        aiVar.a((AdapterView.OnItemClickListener) this);
        aiVar.a((PopupWindow.OnDismissListener) this);
        aiVar.b(this.r);
        aiVar.e(this.q);
        aiVar.a(true);
        aiVar.h(2);
        return aiVar;
    }

    @Override // androidx.appcompat.view.menu.s
    public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (d()) {
            return;
        }
        Iterator<h> it = this.m.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.m.clear();
        this.d = this.r;
        if (this.d != null) {
            boolean z = this.e == null;
            this.e = this.d.getViewTreeObserver();
            if (z) {
                this.e.addOnGlobalLayoutListener(this.c);
            }
            this.d.addOnAttachStateChangeListener(this.n);
        }
    }

    @Override // androidx.appcompat.view.menu.s
    public void c() {
        int size = this.f222b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.f222b.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.f228a.d()) {
                    aVar.f228a.c();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        c();
        return true;
    }

    private int i() {
        return androidx.core.g.q.f(this.r) == 1 ? 0 : 1;
    }

    private int d(int i) {
        ListView listViewA = this.f222b.get(this.f222b.size() - 1).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.d.getWindowVisibleDisplayFrame(rect);
        return this.s == 1 ? (iArr[0] + listViewA.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(h hVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        hVar.a(this, this.h);
        if (d()) {
            c(hVar);
        } else {
            this.m.add(hVar);
        }
    }

    private void c(h hVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a aVar;
        View viewA;
        int i;
        int i2;
        int width;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.h);
        g gVar = new g(hVar, layoutInflaterFrom, this.l, g);
        if (!d() && this.x) {
            gVar.a(true);
        } else if (d()) {
            gVar.a(m.b(hVar));
        }
        int iA = a(gVar, null, this.h, this.i);
        ai aiVarH = h();
        aiVarH.a((ListAdapter) gVar);
        aiVarH.g(iA);
        aiVarH.e(this.q);
        if (this.f222b.size() > 0) {
            aVar = this.f222b.get(this.f222b.size() - 1);
            viewA = a(aVar, hVar);
        } else {
            aVar = null;
            viewA = null;
        }
        if (viewA != null) {
            aiVarH.c(false);
            aiVarH.a((Object) null);
            int iD = d(iA);
            boolean z = iD == 1;
            this.s = iD;
            if (Build.VERSION.SDK_INT >= 26) {
                aiVarH.b(viewA);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewA.getLocationOnScreen(iArr2);
                if ((this.q & 7) == 5) {
                    iArr[0] = iArr[0] + this.r.getWidth();
                    iArr2[0] = iArr2[0] + viewA.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.q & 5) == 5) {
                width = z ? i + iA : i - viewA.getWidth();
            } else {
                width = z ? i + viewA.getWidth() : i - iA;
            }
            aiVarH.c(width);
            aiVarH.b(true);
            aiVarH.d(i2);
        } else {
            if (this.t) {
                aiVarH.c(this.v);
            }
            if (this.u) {
                aiVarH.d(this.w);
            }
            aiVarH.a(g());
        }
        this.f222b.add(new a(aiVarH, hVar, this.s));
        aiVarH.a();
        ListView listViewE = aiVarH.e();
        listViewE.setOnKeyListener(this);
        if (aVar == null && this.y && hVar.n() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) listViewE, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(hVar.n());
            listViewE.addHeaderView(frameLayout, null, false);
            aiVarH.a();
        }
    }

    private MenuItem a(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hVar.getItem(i);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, h hVar) {
        g gVar;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemA = a(aVar.f229b, hVar);
        if (menuItemA == null) {
            return null;
        }
        ListView listViewA = aVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            headersCount = 0;
        }
        int count = gVar.getCount();
        while (true) {
            if (i >= count) {
                i = -1;
                break;
            }
            if (menuItemA == gVar.getItem(i)) {
                break;
            }
            i++;
        }
        if (i != -1 && (firstVisiblePosition = (i + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.s
    public boolean d() {
        return this.f222b.size() > 0 && this.f222b.get(0).f228a.d();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.f222b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f222b.get(i);
            if (!aVar.f228a.d()) {
                break;
            } else {
                i++;
            }
        }
        if (aVar != null) {
            aVar.f229b.a(false);
        }
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(boolean z) {
        Iterator<a> it = this.f222b.iterator();
        while (it.hasNext()) {
            a(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(o.a aVar) {
        this.z = aVar;
    }

    @Override // androidx.appcompat.view.menu.o
    public boolean a(u uVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (a aVar : this.f222b) {
            if (uVar == aVar.f229b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        a((h) uVar);
        if (this.z != null) {
            this.z.a(uVar);
        }
        return true;
    }

    private int d(h hVar) {
        int size = this.f222b.size();
        for (int i = 0; i < size; i++) {
            if (hVar == this.f222b.get(i).f229b) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.appcompat.view.menu.o
    public void a(h hVar, boolean z) {
        int iD = d(hVar);
        if (iD < 0) {
            return;
        }
        int i = iD + 1;
        if (i < this.f222b.size()) {
            this.f222b.get(i).f229b.a(false);
        }
        a aVarRemove = this.f222b.remove(iD);
        aVarRemove.f229b.b(this);
        if (this.f) {
            aVarRemove.f228a.b((Object) null);
            aVarRemove.f228a.b(0);
        }
        aVarRemove.f228a.c();
        int size = this.f222b.size();
        if (size > 0) {
            this.s = this.f222b.get(size - 1).c;
        } else {
            this.s = i();
        }
        if (size != 0) {
            if (z) {
                this.f222b.get(0).f229b.a(false);
                return;
            }
            return;
        }
        c();
        if (this.z != null) {
            this.z.a(hVar, true);
        }
        if (this.e != null) {
            if (this.e.isAlive()) {
                this.e.removeGlobalOnLayoutListener(this.c);
            }
            this.e = null;
        }
        this.d.removeOnAttachStateChangeListener(this.n);
        this.A.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(int i) {
        if (this.p != i) {
            this.p = i;
            this.q = androidx.core.g.c.a(i, androidx.core.g.q.f(this.r));
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(View view) {
        if (this.r != view) {
            this.r = view;
            this.q = androidx.core.g.c.a(this.p, androidx.core.g.q.f(this.r));
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.s
    public ListView e() {
        if (this.f222b.isEmpty()) {
            return null;
        }
        return this.f222b.get(this.f222b.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(int i) {
        this.t = true;
        this.v = i;
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(int i) {
        this.u = true;
        this.w = i;
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(boolean z) {
        this.y = z;
    }

    /* compiled from: CascadingMenuPopup.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ai f228a;

        /* renamed from: b, reason: collision with root package name */
        public final h f229b;
        public final int c;

        public a(ai aiVar, h hVar, int i) {
            this.f228a = aiVar;
            this.f229b = hVar;
            this.c = i;
        }

        public ListView a() {
            return this.f228a.e();
        }
    }
}
