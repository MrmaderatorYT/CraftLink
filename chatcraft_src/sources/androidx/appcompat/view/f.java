package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.q;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper.java */
/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    final Context f193a;

    /* renamed from: b, reason: collision with root package name */
    final b f194b;

    public f(Context context, b bVar) {
        this.f193a = context;
        this.f194b = bVar;
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f194b.j();
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f194b.a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f194b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f194b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f194b.d();
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f194b.c();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return q.a(this.f193a, (androidx.core.b.a.a) this.f194b.b());
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f194b.f();
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f194b.a(i);
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f194b.g();
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f194b.b(i);
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f194b.i();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f194b.a(view);
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f194b.a();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f194b.k();
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f194b.a(z);
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f194b.h();
    }

    /* compiled from: SupportActionModeWrapper.java */
    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f195a;

        /* renamed from: b, reason: collision with root package name */
        final Context f196b;
        final ArrayList<f> c = new ArrayList<>();
        final androidx.b.g<Menu, Menu> d = new androidx.b.g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f196b = context;
            this.f195a = callback;
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f195a.onCreateActionMode(b(bVar), a(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f195a.onPrepareActionMode(b(bVar), a(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f195a.onActionItemClicked(b(bVar), q.a(this.f196b, (androidx.core.b.a.b) menuItem));
        }

        @Override // androidx.appcompat.view.b.a
        public void a(b bVar) {
            this.f195a.onDestroyActionMode(b(bVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu menuA = q.a(this.f196b, (androidx.core.b.a.a) menu);
            this.d.put(menu, menuA);
            return menuA;
        }

        public ActionMode b(b bVar) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.c.get(i);
                if (fVar != null && fVar.f194b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f196b, bVar);
            this.c.add(fVar2);
            return fVar2;
        }
    }
}
