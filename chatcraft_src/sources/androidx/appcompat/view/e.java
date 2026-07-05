package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode.java */
/* loaded from: classes.dex */
public class e extends b implements h.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f191a;

    /* renamed from: b, reason: collision with root package name */
    private ActionBarContextView f192b;
    private b.a c;
    private WeakReference<View> d;
    private boolean e;
    private boolean f;
    private androidx.appcompat.view.menu.h g;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.f191a = context;
        this.f192b = actionBarContextView;
        this.c = aVar;
        this.g = new androidx.appcompat.view.menu.h(actionBarContextView.getContext()).a(1);
        this.g.a(this);
        this.f = z;
    }

    @Override // androidx.appcompat.view.b
    public void b(CharSequence charSequence) {
        this.f192b.setTitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void a(CharSequence charSequence) {
        this.f192b.setSubtitle(charSequence);
    }

    @Override // androidx.appcompat.view.b
    public void a(int i) {
        b(this.f191a.getString(i));
    }

    @Override // androidx.appcompat.view.b
    public void b(int i) {
        a((CharSequence) this.f191a.getString(i));
    }

    @Override // androidx.appcompat.view.b
    public void a(boolean z) {
        super.a(z);
        this.f192b.setTitleOptional(z);
    }

    @Override // androidx.appcompat.view.b
    public boolean h() {
        return this.f192b.d();
    }

    @Override // androidx.appcompat.view.b
    public void a(View view) {
        this.f192b.setCustomView(view);
        this.d = view != null ? new WeakReference<>(view) : null;
    }

    @Override // androidx.appcompat.view.b
    public void d() {
        this.c.b(this, this.g);
    }

    @Override // androidx.appcompat.view.b
    public void c() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.f192b.sendAccessibilityEvent(32);
        this.c.a(this);
    }

    @Override // androidx.appcompat.view.b
    public Menu b() {
        return this.g;
    }

    @Override // androidx.appcompat.view.b
    public CharSequence f() {
        return this.f192b.getTitle();
    }

    @Override // androidx.appcompat.view.b
    public CharSequence g() {
        return this.f192b.getSubtitle();
    }

    @Override // androidx.appcompat.view.b
    public View i() {
        if (this.d != null) {
            return this.d.get();
        }
        return null;
    }

    @Override // androidx.appcompat.view.b
    public MenuInflater a() {
        return new g(this.f192b.getContext());
    }

    @Override // androidx.appcompat.view.menu.h.a
    public boolean a(androidx.appcompat.view.menu.h hVar, MenuItem menuItem) {
        return this.c.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.h.a
    public void a(androidx.appcompat.view.menu.h hVar) {
        d();
        this.f192b.a();
    }
}
