package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import androidx.appcompat.a;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertDialog.java */
/* loaded from: classes.dex */
public class b extends g implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    final AlertController f116a;

    protected b(Context context, int i) {
        super(context, a(context, i));
        this.f116a = new AlertController(getContext(), this, getWindow());
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.C0018a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.g, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f116a.a(charSequence);
    }

    @Override // androidx.appcompat.app.g, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f116a.a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f116a.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f116a.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* compiled from: AlertDialog.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final AlertController.a f117a;

        /* renamed from: b, reason: collision with root package name */
        private final int f118b;

        public a(Context context) {
            this(context, b.a(context, 0));
        }

        public a(Context context, int i) {
            this.f117a = new AlertController.a(new ContextThemeWrapper(context, b.a(context, i)));
            this.f118b = i;
        }

        public Context a() {
            return this.f117a.f102a;
        }

        public a a(CharSequence charSequence) {
            this.f117a.f = charSequence;
            return this;
        }

        public a a(View view) {
            this.f117a.g = view;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.f117a.h = charSequence;
            return this;
        }

        public a a(Drawable drawable) {
            this.f117a.d = drawable;
            return this;
        }

        public a a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f117a.i = charSequence;
            this.f117a.k = onClickListener;
            return this;
        }

        public a b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f117a.l = charSequence;
            this.f117a.n = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f117a.u = onKeyListener;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f117a.w = listAdapter;
            this.f117a.x = onClickListener;
            return this;
        }

        public a a(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f117a.v = charSequenceArr;
            this.f117a.J = onMultiChoiceClickListener;
            this.f117a.F = zArr;
            this.f117a.G = true;
            return this;
        }

        public a a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            this.f117a.v = charSequenceArr;
            this.f117a.x = onClickListener;
            this.f117a.I = i;
            this.f117a.H = true;
            return this;
        }

        public a b(View view) {
            this.f117a.z = view;
            this.f117a.y = 0;
            this.f117a.E = false;
            return this;
        }

        public b b() {
            b bVar = new b(this.f117a.f102a, this.f118b);
            this.f117a.a(bVar.f116a);
            bVar.setCancelable(this.f117a.r);
            if (this.f117a.r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f117a.s);
            bVar.setOnDismissListener(this.f117a.t);
            if (this.f117a.u != null) {
                bVar.setOnKeyListener(this.f117a.u);
            }
            return bVar;
        }
    }
}
