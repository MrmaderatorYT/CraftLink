package com.heinrichreimersoftware.singleinputform.a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import com.heinrichreimersoftware.singleinputform.a;
import com.heinrichreimersoftware.singleinputform.a.d;

/* compiled from: CheckBoxStep.java */
/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: a, reason: collision with root package name */
    private int f4046a;

    /* renamed from: b, reason: collision with root package name */
    private String f4047b;
    private b c;
    private int d;

    /* compiled from: CheckBoxStep.java */
    /* renamed from: com.heinrichreimersoftware.singleinputform.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0090a {
        boolean a(boolean z);
    }

    /* compiled from: CheckBoxStep.java */
    public interface b {
        void a(boolean z, d.a aVar);
    }

    public a(Context context, String str, int i, int i2, int i3, int i4, b bVar) {
        super(context, str, i2, i3, i4);
        this.f4046a = i;
        this.c = bVar;
    }

    public a(Context context, String str, int i, int i2, int i3, int i4, final InterfaceC0090a interfaceC0090a) {
        this(context, str, i, i2, i3, i4, new b() { // from class: com.heinrichreimersoftware.singleinputform.a.a.1
            @Override // com.heinrichreimersoftware.singleinputform.a.a.b
            public void a(boolean z, d.a aVar) {
                if (interfaceC0090a.a(z)) {
                    aVar.a();
                } else {
                    aVar.b();
                }
            }
        });
    }

    public static boolean a(Bundle bundle, String str) {
        Bundle bundle2;
        if (bundle == null || !bundle.containsKey(str) || (bundle2 = bundle.getBundle(str)) == null) {
            return false;
        }
        return bundle2.getBoolean("data_checked");
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FrameLayout f() {
        m();
        FrameLayout frameLayout = (FrameLayout) View.inflate(g(), a.e.view_check_box, null);
        ((CheckBox) frameLayout.getChildAt(0)).setTextColor(this.d);
        return frameLayout;
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    public void a(boolean z) {
        if (this.f4046a != 0) {
            l().setText(g().getString(this.f4046a));
        } else {
            l().setText(this.f4047b);
        }
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout e() {
        if (super.e() instanceof FrameLayout) {
            return (FrameLayout) super.e();
        }
        throw new ClassCastException("Input view must be FrameLayout");
    }

    private CheckBox l() {
        return (CheckBox) e().getChildAt(0);
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    public void a(d.a aVar) {
        this.c.a(l().isChecked(), aVar);
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    protected void c() {
        k().putBoolean("data_checked", l().isChecked());
    }

    @Override // com.heinrichreimersoftware.singleinputform.a.d
    protected void d() {
        l().setChecked(k().getBoolean("data_checked", false));
    }

    private void m() {
        TypedArray typedArrayObtainStyledAttributes = g().obtainStyledAttributes(new int[]{R.attr.textColorPrimaryInverse});
        this.d = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
