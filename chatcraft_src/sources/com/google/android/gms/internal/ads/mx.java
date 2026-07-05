package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import java.util.Set;
import org.json.JSONException;

@qj
/* loaded from: classes.dex */
public final class mx extends nh {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f3283a = com.google.android.gms.common.util.d.a("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");

    /* renamed from: b, reason: collision with root package name */
    private String f3284b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Object j;
    private final afu k;
    private final Activity l;
    private ahh m;
    private ImageView n;
    private LinearLayout o;
    private ni p;
    private PopupWindow q;
    private RelativeLayout r;
    private ViewGroup s;

    public mx(afu afuVar, ni niVar) {
        super(afuVar, "resize");
        this.f3284b = "top-right";
        this.c = true;
        this.d = 0;
        this.e = 0;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.j = new Object();
        this.k = afuVar;
        this.l = afuVar.d();
        this.p = niVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.util.Map<java.lang.String, java.lang.String> r14) {
        /*
            Method dump skipped, instructions count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.mx.a(java.util.Map):void");
    }

    public final void a(boolean z) {
        synchronized (this.j) {
            if (this.q != null) {
                this.q.dismiss();
                this.r.removeView(this.k.getView());
                if (this.s != null) {
                    this.s.removeView(this.n);
                    this.s.addView(this.k.getView());
                    this.k.a(this.m);
                }
                if (z) {
                    c("default");
                    if (this.p != null) {
                        this.p.L();
                    }
                }
                this.q = null;
                this.r = null;
                this.s = null;
                this.o = null;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0126 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int[] b() {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.mx.b():int[]");
    }

    public final void a(int i, int i2, boolean z) {
        synchronized (this.j) {
            this.d = i;
            this.e = i2;
            if (this.q != null && z) {
                int[] iArrB = b();
                if (iArrB != null) {
                    PopupWindow popupWindow = this.q;
                    bra.a();
                    int iA = aac.a(this.l, iArrB[0]);
                    bra.a();
                    popupWindow.update(iA, aac.a(this.l, iArrB[1]), this.q.getWidth(), this.q.getHeight());
                    b(iArrB[0], iArrB[1]);
                } else {
                    a(true);
                }
            }
        }
    }

    private final void b(int i, int i2) throws JSONException {
        a(i, i2 - com.google.android.gms.ads.internal.ax.e().c(this.l)[0], this.i, this.f);
    }

    public final boolean a() {
        boolean z;
        synchronized (this.j) {
            z = this.q != null;
        }
        return z;
    }

    public final void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }
}
