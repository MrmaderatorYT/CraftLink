package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ax;
import androidx.core.app.m;

/* compiled from: AppCompatActivity.java */
/* loaded from: classes.dex */
public class c extends androidx.fragment.app.d implements d, m.a {
    private e j;
    private int k = 0;
    private Resources l;

    @Override // androidx.appcompat.app.d
    public androidx.appcompat.view.b a(b.a aVar) {
        return null;
    }

    @Override // androidx.appcompat.app.d
    public void a(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public void b(androidx.appcompat.view.b bVar) {
    }

    public void b(m mVar) {
    }

    @Deprecated
    public void e() {
    }

    @Override // androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        e eVarF = f();
        eVarF.h();
        eVarF.a(bundle);
        if (eVarF.i() && this.k != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.k, false);
            } else {
                setTheme(this.k);
            }
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        this.k = i;
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        f().b(bundle);
    }

    public a a() {
        return f().a();
    }

    public void a(Toolbar toolbar) {
        f().a(toolbar);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return f().b();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        f().b(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        f().a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        f().a(view, layoutParams);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        f().b(view, layoutParams);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f().a(configuration);
        if (this.l != null) {
            this.l.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        f().e();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onStart() {
        super.onStart();
        f().c();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onStop() {
        super.onStop();
        f().d();
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) f().a(i);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a aVarA = a();
        if (menuItem.getItemId() != 16908332 || aVarA == null || (aVarA.a() & 4) == 0) {
            return false;
        }
        return c();
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        f().g();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        f().a(charSequence);
    }

    @Override // androidx.fragment.app.d
    public void b() {
        f().f();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        f().f();
    }

    public void a(m mVar) {
        mVar.a((Activity) this);
    }

    public boolean c() {
        Intent intentD = d();
        if (intentD == null) {
            return false;
        }
        if (a(intentD)) {
            m mVarA = m.a((Context) this);
            a(mVarA);
            b(mVarA);
            mVarA.a();
            try {
                androidx.core.app.a.a((Activity) this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        }
        b(intentD);
        return true;
    }

    @Override // androidx.core.app.m.a
    public Intent d() {
        return androidx.core.app.e.a(this);
    }

    public boolean a(Intent intent) {
        return androidx.core.app.e.a(this, intent);
    }

    public void b(Intent intent) {
        androidx.core.app.e.b(this, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        e();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // androidx.fragment.app.d, androidx.core.app.d, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        f().c(bundle);
    }

    public e f() {
        if (this.j == null) {
            this.j = e.a(this, this);
        }
        return this.j;
    }

    @Override // androidx.core.app.d, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a aVarA = a();
        if (keyCode == 82 && aVarA != null && aVarA.a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.l == null && ax.a()) {
            this.l = new ax(this, super.getResources());
        }
        return this.l == null ? super.getResources() : this.l;
    }

    private boolean a(int i, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a aVarA = a();
        if (getWindow().hasFeature(0)) {
            if (aVarA == null || !aVarA.c()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a aVarA = a();
        if (getWindow().hasFeature(0)) {
            if (aVarA == null || !aVarA.d()) {
                super.closeOptionsMenu();
            }
        }
    }
}
