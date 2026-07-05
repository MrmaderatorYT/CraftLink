package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@qj
@TargetApi(14)
/* loaded from: classes.dex */
public abstract class act extends TextureView implements adp {

    /* renamed from: a, reason: collision with root package name */
    protected final add f1844a;

    /* renamed from: b, reason: collision with root package name */
    protected final ado f1845b;

    public act(Context context) {
        super(context);
        this.f1844a = new add();
        this.f1845b = new ado(context, this);
    }

    public abstract String a();

    public abstract void a(float f, float f2);

    public abstract void a(int i);

    public abstract void a(acs acsVar);

    public abstract void b();

    public abstract void c();

    public void c(int i) {
    }

    public abstract void d();

    public void d(int i) {
    }

    public abstract void e();

    public void e(int i) {
    }

    public void f(int i) {
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void setVideoPath(String str);
}
