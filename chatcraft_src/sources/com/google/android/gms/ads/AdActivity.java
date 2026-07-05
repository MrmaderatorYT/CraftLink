package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.nm;

/* loaded from: classes.dex */
public class AdActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private nm f1463a;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1463a = bra.b().a(this);
        if (this.f1463a == null) {
            aan.d("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            this.f1463a.a(bundle);
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        try {
            if (this.f1463a != null) {
                this.f1463a.f();
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            if (this.f1463a != null) {
                this.f1463a.g();
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            if (this.f1463a != null) {
                this.f1463a.h();
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            if (this.f1463a != null) {
                this.f1463a.i();
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f1463a != null) {
                this.f1463a.b(bundle);
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            if (this.f1463a != null) {
                this.f1463a.j();
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            if (this.f1463a != null) {
                this.f1463a.k();
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    private final void a() {
        if (this.f1463a != null) {
            try {
                this.f1463a.l();
            } catch (RemoteException e) {
                aan.d("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        a();
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        a();
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        a();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean zE = true;
        try {
            if (this.f1463a != null) {
                zE = this.f1463a.e();
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
        if (zE) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.f1463a.a(i, i2, intent);
        } catch (Exception e) {
            aan.d("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.f1463a.a(com.google.android.gms.dynamic.b.a(configuration));
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }
}
