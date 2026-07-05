package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* compiled from: FragmentController.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final g<?> f728a;

    public static f a(g<?> gVar) {
        return new f(gVar);
    }

    private f(g<?> gVar) {
        this.f728a = gVar;
    }

    public h a() {
        return this.f728a.i();
    }

    public Fragment a(String str) {
        return this.f728a.f730b.b(str);
    }

    public void a(Fragment fragment) {
        this.f728a.f730b.a(this.f728a, this.f728a, fragment);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f728a.f730b.onCreateView(view, str, context, attributeSet);
    }

    public void b() {
        this.f728a.f730b.m();
    }

    public Parcelable c() {
        return this.f728a.f730b.l();
    }

    public void a(Parcelable parcelable, j jVar) {
        this.f728a.f730b.a(parcelable, jVar);
    }

    public j d() {
        return this.f728a.f730b.j();
    }

    public void e() {
        this.f728a.f730b.n();
    }

    public void f() {
        this.f728a.f730b.o();
    }

    public void g() {
        this.f728a.f730b.p();
    }

    public void h() {
        this.f728a.f730b.q();
    }

    public void i() {
        this.f728a.f730b.r();
    }

    public void j() {
        this.f728a.f730b.s();
    }

    public void k() {
        this.f728a.f730b.u();
    }

    public void a(boolean z) {
        this.f728a.f730b.a(z);
    }

    public void b(boolean z) {
        this.f728a.f730b.b(z);
    }

    public void a(Configuration configuration) {
        this.f728a.f730b.a(configuration);
    }

    public void l() {
        this.f728a.f730b.v();
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f728a.f730b.a(menu, menuInflater);
    }

    public boolean a(Menu menu) {
        return this.f728a.f730b.a(menu);
    }

    public boolean a(MenuItem menuItem) {
        return this.f728a.f730b.a(menuItem);
    }

    public boolean b(MenuItem menuItem) {
        return this.f728a.f730b.b(menuItem);
    }

    public void b(Menu menu) {
        this.f728a.f730b.b(menu);
    }

    public boolean m() {
        return this.f728a.f730b.g();
    }
}
