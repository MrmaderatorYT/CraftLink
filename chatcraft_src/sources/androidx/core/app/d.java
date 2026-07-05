package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.g.d;
import androidx.lifecycle.e;
import androidx.lifecycle.o;

/* compiled from: ComponentActivity.java */
/* loaded from: classes.dex */
public class d extends Activity implements d.a, androidx.lifecycle.g {

    /* renamed from: a, reason: collision with root package name */
    private androidx.b.g<Class<? extends Object>, Object> f545a = new androidx.b.g<>();

    /* renamed from: b, reason: collision with root package name */
    private androidx.lifecycle.h f546b = new androidx.lifecycle.h(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.a(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.f546b.a(e.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.e g() {
        return this.f546b;
    }

    @Override // androidx.core.g.d.a
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.g.d.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.g.d.a(decorView, keyEvent)) {
            return androidx.core.g.d.a(this, decorView, this, keyEvent);
        }
        return true;
    }
}
