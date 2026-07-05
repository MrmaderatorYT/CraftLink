package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.util.Collections;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class as extends fc implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, bh {

    /* renamed from: a, reason: collision with root package name */
    private afu f2223a;

    /* renamed from: b, reason: collision with root package name */
    private bf f2224b;
    private boolean c = false;
    private boolean d = false;

    public as(afu afuVar) {
        this.f2223a = afuVar;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final String a() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final String b() {
        return BuildConfig.FLAVOR;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final ao c() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final void a(bf bfVar) {
        this.f2224b = bfVar;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final View d() {
        if (this.f2223a == null) {
            return null;
        }
        return this.f2223a.getView();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        h();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        h();
    }

    @Override // com.google.android.gms.internal.ads.fb
    public final void a(com.google.android.gms.dynamic.a aVar, fd fdVar) {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        if (this.c) {
            xe.c("Instream ad is destroyed already.");
            a(fdVar, 2);
            return;
        }
        if (this.f2223a.b() == null) {
            xe.c("Instream internal error: can not get video controller.");
            a(fdVar, 0);
            return;
        }
        if (this.d) {
            xe.c("Instream ad should not be used again.");
            a(fdVar, 1);
            return;
        }
        this.d = true;
        g();
        ((ViewGroup) com.google.android.gms.dynamic.b.a(aVar)).addView(this.f2223a.getView(), new ViewGroup.LayoutParams(-1, -1));
        com.google.android.gms.ads.internal.ax.D();
        acd.a(this.f2223a.getView(), (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.ax.D();
        acd.a(this.f2223a.getView(), (ViewTreeObserver.OnScrollChangedListener) this);
        h();
        try {
            fdVar.a();
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.fb
    public final bsw e() {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        if (this.c) {
            xe.c("Instream ad is destroyed already.");
            return null;
        }
        if (this.f2223a == null) {
            return null;
        }
        return this.f2223a.b();
    }

    @Override // com.google.android.gms.internal.ads.fb
    public final void f() {
        com.google.android.gms.common.internal.i.b("#008 Must be called on the main UI thread.");
        if (this.c) {
            return;
        }
        g();
        if (this.f2224b != null) {
            this.f2224b.l();
            this.f2224b.k();
        }
        this.f2224b = null;
        this.f2223a = null;
        this.c = true;
    }

    private final void g() {
        if (this.f2223a == null) {
            return;
        }
        ViewParent parent = this.f2223a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView((View) this.f2223a);
        }
    }

    private final void h() {
        if (this.f2224b == null || this.f2223a == null) {
            return;
        }
        this.f2224b.c(this.f2223a.getView(), Collections.emptyMap());
    }

    private static void a(fd fdVar, int i) {
        try {
            fdVar.a(i);
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }
}
