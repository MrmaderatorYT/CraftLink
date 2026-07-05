package com.heinrichreimersoftware.singleinputform.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.heinrichreimersoftware.singleinputform.a.e;

/* compiled from: OptionStep.java */
/* loaded from: classes.dex */
public class b extends e {

    /* renamed from: a, reason: collision with root package name */
    private String[] f4049a;

    /* renamed from: b, reason: collision with root package name */
    private int f4050b;

    public b(final Context context, String str, String[] strArr, final int i, int i2, int i3, e.b bVar) {
        super(context, str, 0, i, i2, i3, bVar);
        this.f4050b = -1;
        this.f4049a = strArr;
        a(new View.OnClickListener() { // from class: com.heinrichreimersoftware.singleinputform.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(i).setItems(b.this.f4049a, new DialogInterface.OnClickListener() { // from class: com.heinrichreimersoftware.singleinputform.a.b.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i4) {
                        b.this.f4050b = i4;
                        b.this.l();
                    }
                });
                builder.show();
            }
        });
    }

    public static int a(Bundle bundle, String str) {
        Bundle bundle2;
        if (bundle == null || !bundle.containsKey(str) || (bundle2 = bundle.getBundle(str)) == null) {
            return -1;
        }
        return bundle2.getInt("data_selected_option", -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f4050b < 0 || this.f4050b >= this.f4049a.length) {
            return;
        }
        a((CharSequence) this.f4049a[this.f4050b]);
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.e, com.heinrichreimersoftware.singleinputform.a.d
    protected void c() {
        k().putInt("data_selected_option", this.f4050b);
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.e, com.heinrichreimersoftware.singleinputform.a.d
    protected void d() {
        int i = k().getInt("data_selected_option", -1);
        if (i >= 0) {
            this.f4050b = i;
            l();
        }
    }
}
