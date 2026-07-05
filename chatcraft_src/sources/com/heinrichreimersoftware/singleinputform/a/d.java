package com.heinrichreimersoftware.singleinputform.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Step.java */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private Context f4054a;

    /* renamed from: b, reason: collision with root package name */
    private String f4055b;
    private int e;
    private int f;
    private int g;
    private String h;
    private String i;
    private String j;
    private Bundle d = new Bundle();
    private View c = f();

    /* compiled from: Step.java */
    public interface a {
        void a();

        void a(String str);

        void b();
    }

    public abstract void a(a aVar);

    public abstract void a(boolean z);

    protected abstract void c();

    protected abstract void d();

    public abstract View f();

    public d(Context context, String str, int i, int i2, int i3) {
        this.f4054a = context;
        this.f4055b = str;
        this.e = i;
        this.f = i2;
        this.g = i3;
    }

    public void a(Context context) {
        this.f4054a = context;
    }

    public Context g() {
        return this.f4054a;
    }

    public String h() {
        if (this.h != null && !this.h.equals(BuildConfig.FLAVOR)) {
            return this.h;
        }
        return g().getString(this.e);
    }

    public String i() {
        if (this.i != null && !this.i.equals(BuildConfig.FLAVOR)) {
            return this.i;
        }
        return g().getString(this.f);
    }

    public String j() {
        if (this.j != null && !this.j.equals(BuildConfig.FLAVOR)) {
            return this.j;
        }
        return g().getString(this.g);
    }

    public View e() {
        return this.c;
    }

    public Bundle k() {
        return this.d;
    }

    public Bundle a(Bundle bundle) {
        c();
        if (bundle != null) {
            bundle.putBundle(this.f4055b, this.d);
        }
        return bundle;
    }

    public void b(Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && (bundle2 = bundle.getBundle(this.f4055b)) != null) {
            this.d = bundle2;
        }
        d();
    }
}
