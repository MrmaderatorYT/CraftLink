package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/* compiled from: DialogFragment.java */
/* loaded from: classes.dex */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    int f720a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f721b = 0;
    boolean c = true;
    boolean d = true;
    int e = -1;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    public void a(h hVar, String str) {
        this.h = false;
        this.i = true;
        n nVarA = hVar.a();
        nVarA.a(this, str);
        nVarA.c();
    }

    void a(boolean z) {
        if (this.h) {
            return;
        }
        this.h = true;
        this.i = false;
        if (this.f != null) {
            this.f.dismiss();
        }
        this.g = true;
        if (this.e >= 0) {
            p().a(this.e, 1);
            this.e = -1;
            return;
        }
        n nVarA = p().a();
        nVarA.a(this);
        if (z) {
            nVarA.d();
        } else {
            nVarA.c();
        }
    }

    public int a() {
        return this.f721b;
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Context context) {
        super.a(context);
        if (this.i) {
            return;
        }
        this.h = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void b() {
        super.b();
        if (this.i || this.h) {
            return;
        }
        this.h = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.d = this.I == 0;
        if (bundle != null) {
            this.f720a = bundle.getInt("android:style", 0);
            this.f721b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater b(Bundle bundle) {
        if (!this.d) {
            return super.b(bundle);
        }
        this.f = c(bundle);
        if (this.f != null) {
            a(this.f, this.f720a);
            return (LayoutInflater) this.f.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) this.C.g().getSystemService("layout_inflater");
    }

    public void a(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public Dialog c(Bundle bundle) {
        return new Dialog(n(), a());
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.g) {
            return;
        }
        a(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void d(Bundle bundle) {
        Bundle bundle2;
        super.d(bundle);
        if (this.d) {
            View viewU = u();
            if (viewU != null) {
                if (viewU.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f.setContentView(viewU);
            }
            d dVarN = n();
            if (dVarN != null) {
                this.f.setOwnerActivity(dVarN);
            }
            this.f.setCancelable(this.c);
            this.f.setOnCancelListener(this);
            this.f.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.f.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void c() {
        super.c();
        if (this.f != null) {
            this.g = false;
            this.f.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void e(Bundle bundle) {
        Bundle bundleOnSaveInstanceState;
        super.e(bundle);
        if (this.f != null && (bundleOnSaveInstanceState = this.f.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        if (this.f720a != 0) {
            bundle.putInt("android:style", this.f720a);
        }
        if (this.f721b != 0) {
            bundle.putInt("android:theme", this.f721b);
        }
        if (!this.c) {
            bundle.putBoolean("android:cancelable", this.c);
        }
        if (!this.d) {
            bundle.putBoolean("android:showsDialog", this.d);
        }
        if (this.e != -1) {
            bundle.putInt("android:backStackId", this.e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void d() {
        super.d();
        if (this.f != null) {
            this.f.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void e() {
        super.e();
        if (this.f != null) {
            this.g = true;
            this.f.dismiss();
            this.f = null;
        }
    }
}
