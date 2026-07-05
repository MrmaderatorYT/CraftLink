package com.heinrichreimersoftware.singleinputform.a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.heinrichreimersoftware.singleinputform.a;
import com.heinrichreimersoftware.singleinputform.a.d;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: TextStep.java */
/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: a, reason: collision with root package name */
    private int f4056a;

    /* renamed from: b, reason: collision with root package name */
    private b f4057b;
    private int c;

    /* compiled from: TextStep.java */
    public interface a {
        boolean a(String str);
    }

    /* compiled from: TextStep.java */
    public interface b {
        void a(String str, d.a aVar);
    }

    public e(Context context, String str, int i, int i2, int i3, int i4, b bVar, TextView.OnEditorActionListener onEditorActionListener) {
        super(context, str, i2, i3, i4);
        this.f4056a = i;
        this.f4057b = bVar;
        e().setOnEditorActionListener(onEditorActionListener);
    }

    public e(Context context, String str, int i, int i2, int i3, int i4, b bVar) {
        this(context, str, i, i2, i3, i4, bVar, null);
    }

    public e(Context context, String str, int i, int i2, int i3, int i4, final a aVar) {
        this(context, str, i, i2, i3, i4, new b() { // from class: com.heinrichreimersoftware.singleinputform.a.e.1
            @Override // com.heinrichreimersoftware.singleinputform.a.e.b
            public void a(String str2, d.a aVar2) {
                if (aVar.a(str2)) {
                    aVar2.a();
                } else {
                    aVar2.b();
                }
            }
        });
    }

    public static String b(Bundle bundle, String str) {
        Bundle bundle2;
        if (bundle == null || !bundle.containsKey(str) || (bundle2 = bundle.getBundle(str)) == null) {
            return null;
        }
        return bundle2.getString("data_text");
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    public View f() {
        n();
        EditText editText = (EditText) View.inflate(g(), a.e.view_input, null);
        editText.setTextColor(this.c);
        return editText;
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    public void a(boolean z) {
        Log.d("sif", "updateView(" + z + ")");
        if (z) {
            a(268435462);
        } else {
            a(268435461);
        }
        e().setInputType(this.f4056a);
        if (this.f4056a == 0) {
            l();
            Log.d("sif", "hideSoftInput()");
        } else {
            l();
            m();
            Log.d("sif", "showSoftInput()");
        }
    }

    public void a(String str) {
        k().putString("data_text", str);
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TextView e() {
        if (super.e() instanceof TextView) {
            return (TextView) super.e();
        }
        throw new ClassCastException("Input view must be TextView");
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    public void a(d.a aVar) {
        String string = BuildConfig.FLAVOR;
        CharSequence text = e().getText();
        if (text != null) {
            string = text.toString();
        }
        this.f4057b.a(string, aVar);
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    protected void c() {
        k().putString("data_text", b().toString());
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    protected void d() {
        String string = k().getString("data_text");
        if (string != null && !string.equals(BuildConfig.FLAVOR)) {
            a((CharSequence) string);
        } else {
            a(BuildConfig.FLAVOR);
        }
    }

    public CharSequence b() {
        return e().getText();
    }

    public void a(CharSequence charSequence) {
        e().setText(charSequence);
        TextView textViewE = e();
        if (textViewE instanceof EditText) {
            ((EditText) textViewE).setSelection(textViewE.getText().length());
        }
    }

    public void a(int i) {
        e().setImeOptions(i);
    }

    private void l() {
        Context contextG = g();
        if (contextG != null) {
            ((InputMethodManager) contextG.getSystemService("input_method")).hideSoftInputFromWindow(e().getWindowToken(), 0);
        }
    }

    private void m() {
        Context contextG = g();
        if (contextG != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) contextG.getSystemService("input_method");
            e().requestFocus();
            inputMethodManager.toggleSoftInput(2, 1);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        e().setOnClickListener(onClickListener);
    }

    private void n() {
        TypedArray typedArrayObtainStyledAttributes = g().obtainStyledAttributes(new int[]{R.attr.textColorPrimaryInverse});
        this.c = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
