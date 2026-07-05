package androidx.preference;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.preference.DialogPreference;

/* compiled from: PreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public abstract class f extends androidx.fragment.app.c implements DialogInterface.OnClickListener {
    private DialogPreference ag;
    private CharSequence ah;
    private CharSequence ai;
    private CharSequence aj;
    private CharSequence ak;
    private int al;
    private BitmapDrawable am;
    private int an;

    protected void a(b.a aVar) {
    }

    protected boolean ae() {
        return false;
    }

    public abstract void k(boolean z);

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        androidx.lifecycle.g gVarK = k();
        if (!(gVarK instanceof DialogPreference.a)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.a aVar = (DialogPreference.a) gVarK;
        String string = i().getString("key");
        if (bundle == null) {
            this.ag = (DialogPreference) aVar.a(string);
            this.ah = this.ag.b();
            this.ai = this.ag.e();
            this.aj = this.ag.f();
            this.ak = this.ag.c();
            this.al = this.ag.g();
            Drawable drawableD = this.ag.d();
            if (drawableD == null || (drawableD instanceof BitmapDrawable)) {
                this.am = (BitmapDrawable) drawableD;
                return;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableD.getIntrinsicWidth(), drawableD.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableD.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawableD.draw(canvas);
            this.am = new BitmapDrawable(o(), bitmapCreateBitmap);
            return;
        }
        this.ah = bundle.getCharSequence("PreferenceDialogFragment.title");
        this.ai = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
        this.aj = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
        this.ak = bundle.getCharSequence("PreferenceDialogFragment.message");
        this.al = bundle.getInt("PreferenceDialogFragment.layout", 0);
        Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
        if (bitmap != null) {
            this.am = new BitmapDrawable(o(), bitmap);
        }
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.ah);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.ai);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.aj);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.ak);
        bundle.putInt("PreferenceDialogFragment.layout", this.al);
        if (this.am != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", this.am.getBitmap());
        }
    }

    @Override // androidx.fragment.app.c
    public Dialog c(Bundle bundle) {
        androidx.fragment.app.d dVarN = n();
        this.an = -2;
        b.a aVarB = new b.a(dVarN).a(this.ah).a(this.am).a(this.ai, this).b(this.aj, this);
        View viewB = b(dVarN);
        if (viewB != null) {
            b(viewB);
            aVarB.b(viewB);
        } else {
            aVarB.b(this.ak);
        }
        a(aVarB);
        androidx.appcompat.app.b bVarB = aVarB.b();
        if (ae()) {
            a(bVarB);
        }
        return bVarB;
    }

    public DialogPreference af() {
        if (this.ag == null) {
            this.ag = (DialogPreference) ((DialogPreference.a) k()).a(i().getString("key"));
        }
        return this.ag;
    }

    private void a(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    protected View b(Context context) {
        int i = this.al;
        if (i == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(i, (ViewGroup) null);
    }

    protected void b(View view) {
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.ak;
            int i = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i = 0;
            }
            if (viewFindViewById.getVisibility() != i) {
                viewFindViewById.setVisibility(i);
            }
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.an = i;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        k(this.an == -1);
    }
}
