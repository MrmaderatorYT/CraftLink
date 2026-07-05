package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.aa;
import androidx.appcompat.widget.at;
import androidx.core.g.q;
import java.util.ArrayList;

/* compiled from: ToolbarActionBar.java */
/* loaded from: classes.dex */
class i extends androidx.appcompat.app.a {

    /* renamed from: a, reason: collision with root package name */
    aa f147a;

    /* renamed from: b, reason: collision with root package name */
    boolean f148b;
    Window.Callback c;
    private boolean d;
    private boolean e;
    private ArrayList<a.b> f = new ArrayList<>();
    private final Runnable g = new Runnable() { // from class: androidx.appcompat.app.i.1
        @Override // java.lang.Runnable
        public void run() {
            i.this.i();
        }
    };
    private final Toolbar.c h = new Toolbar.c() { // from class: androidx.appcompat.app.i.2
        @Override // androidx.appcompat.widget.Toolbar.c
        public boolean a(MenuItem menuItem) {
            return i.this.c.onMenuItemSelected(0, menuItem);
        }
    };

    @Override // androidx.appcompat.app.a
    public void c(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void e(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void f(boolean z) {
    }

    i(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f147a = new at(toolbar, false);
        this.c = new c(callback);
        this.f147a.a(this.c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f147a.a(charSequence);
    }

    public Window.Callback h() {
        return this.c;
    }

    @Override // androidx.appcompat.app.a
    public void a(float f) {
        q.a(this.f147a.a(), f);
    }

    @Override // androidx.appcompat.app.a
    public Context b() {
        return this.f147a.b();
    }

    @Override // androidx.appcompat.app.a
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // androidx.appcompat.app.a
    public void a(CharSequence charSequence) {
        this.f147a.a(charSequence);
    }

    public void a(int i, int i2) {
        this.f147a.c((i & i2) | ((i2 ^ (-1)) & this.f147a.o()));
    }

    @Override // androidx.appcompat.app.a
    public void a(boolean z) {
        a(z ? 2 : 0, 2);
    }

    @Override // androidx.appcompat.app.a
    public void b(boolean z) {
        a(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public int a() {
        return this.f147a.o();
    }

    @Override // androidx.appcompat.app.a
    public boolean c() {
        return this.f147a.k();
    }

    @Override // androidx.appcompat.app.a
    public boolean d() {
        return this.f147a.l();
    }

    @Override // androidx.appcompat.app.a
    public boolean e() {
        this.f147a.a().removeCallbacks(this.g);
        q.a(this.f147a.a(), this.g);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean f() {
        if (!this.f147a.c()) {
            return false;
        }
        this.f147a.d();
        return true;
    }

    void i() {
        Menu menuJ = j();
        androidx.appcompat.view.menu.h hVar = menuJ instanceof androidx.appcompat.view.menu.h ? (androidx.appcompat.view.menu.h) menuJ : null;
        if (hVar != null) {
            hVar.h();
        }
        try {
            menuJ.clear();
            if (!this.c.onCreatePanelMenu(0, menuJ) || !this.c.onPreparePanel(0, null, menuJ)) {
                menuJ.clear();
            }
        } finally {
            if (hVar != null) {
                hVar.i();
            }
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            c();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean a(int i, KeyEvent keyEvent) {
        Menu menuJ = j();
        if (menuJ == null) {
            return false;
        }
        menuJ.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuJ.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    void g() {
        this.f147a.a().removeCallbacks(this.g);
    }

    @Override // androidx.appcompat.app.a
    public void g(boolean z) {
        if (z == this.e) {
            return;
        }
        this.e = z;
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.get(i).a(z);
        }
    }

    /* compiled from: ToolbarActionBar.java */
    private class c extends androidx.appcompat.view.i {
        public c(Window.Callback callback) {
            super(callback);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (zOnPreparePanel && !i.this.f148b) {
                i.this.f147a.m();
                i.this.f148b = true;
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(i.this.f147a.b());
            }
            return super.onCreatePanelView(i);
        }
    }

    private Menu j() {
        if (!this.d) {
            this.f147a.a(new a(), new b());
            this.d = true;
        }
        return this.f147a.q();
    }

    /* compiled from: ToolbarActionBar.java */
    private final class a implements o.a {

        /* renamed from: b, reason: collision with root package name */
        private boolean f152b;

        a() {
        }

        @Override // androidx.appcompat.view.menu.o.a
        public boolean a(androidx.appcompat.view.menu.h hVar) {
            if (i.this.c == null) {
                return false;
            }
            i.this.c.onMenuOpened(108, hVar);
            return true;
        }

        @Override // androidx.appcompat.view.menu.o.a
        public void a(androidx.appcompat.view.menu.h hVar, boolean z) {
            if (this.f152b) {
                return;
            }
            this.f152b = true;
            i.this.f147a.n();
            if (i.this.c != null) {
                i.this.c.onPanelClosed(108, hVar);
            }
            this.f152b = false;
        }
    }

    /* compiled from: ToolbarActionBar.java */
    private final class b implements h.a {
        @Override // androidx.appcompat.view.menu.h.a
        public boolean a(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
            return false;
        }

        b() {
        }

        @Override // androidx.appcompat.view.menu.h.a
        public void a(androidx.appcompat.view.menu.h hVar) {
            if (i.this.c != null) {
                if (i.this.f147a.i()) {
                    i.this.c.onPanelClosed(108, hVar);
                } else if (i.this.c.onPreparePanel(0, null, hVar)) {
                    i.this.c.onMenuOpened(108, hVar);
                }
            }
        }
    }
}
