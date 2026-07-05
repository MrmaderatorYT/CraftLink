package com.google.android.gms.ads.internal;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.ads.aac;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.axa;
import com.google.android.gms.internal.ads.axe;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.brd;
import com.google.android.gms.internal.ads.brh;
import com.google.android.gms.internal.ads.brx;
import com.google.android.gms.internal.ads.bsa;
import com.google.android.gms.internal.ads.bsg;
import com.google.android.gms.internal.ads.btc;
import com.google.android.gms.internal.ads.buc;
import com.google.android.gms.internal.ads.dd;
import com.google.android.gms.internal.ads.dg;
import com.google.android.gms.internal.ads.dj;
import com.google.android.gms.internal.ads.dm;
import com.google.android.gms.internal.ads.dp;
import com.google.android.gms.internal.ads.ds;
import com.google.android.gms.internal.ads.ey;
import com.google.android.gms.internal.ads.ff;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.tw;
import com.google.android.gms.internal.ads.ue;
import com.google.android.gms.internal.ads.wk;
import com.google.android.gms.internal.ads.wl;
import com.google.android.gms.internal.ads.wm;
import com.google.android.gms.internal.ads.wx;
import com.google.android.gms.internal.ads.xa;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.yi;
import com.google.android.gms.internal.ads.zr;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ay implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    btc A;
    dp B;
    List<Integer> C;
    com.google.android.gms.internal.ads.ai D;
    ue E;
    tw F;
    public String G;
    public String H;
    List<String> I;
    public wx J;
    View K;
    public int L;
    boolean M;
    private HashSet<wm> N;
    private int O;
    private int P;
    private zr Q;
    private boolean R;
    private boolean S;
    private boolean T;

    /* renamed from: a, reason: collision with root package name */
    final String f1536a;

    /* renamed from: b, reason: collision with root package name */
    public String f1537b;
    public final Context c;
    final axe d;
    public final aar e;
    az f;
    public xa g;
    public yi h;
    public bqn i;
    public wk j;
    public wl k;
    public wm l;
    brd m;
    brh n;
    bsa o;
    brx p;
    bsg q;
    dd r;
    dg s;
    ds t;
    ff u;
    androidx.b.g<String, dj> v;
    androidx.b.g<String, dm> w;
    com.google.android.gms.internal.ads.br x;
    buc y;
    ey z;

    public ay(Context context, bqn bqnVar, String str, aar aarVar) {
        this(context, bqnVar, str, aarVar, null);
    }

    private ay(Context context, bqn bqnVar, String str, aar aarVar, axe axeVar) {
        this.J = null;
        this.K = null;
        this.L = 0;
        this.M = false;
        this.N = null;
        this.O = -1;
        this.P = -1;
        this.R = true;
        this.S = true;
        this.T = false;
        com.google.android.gms.internal.ads.o.a(context);
        if (ax.i().a() != null) {
            List<String> listB = com.google.android.gms.internal.ads.o.b();
            if (aarVar.f1791b != 0) {
                listB.add(Integer.toString(aarVar.f1791b));
            }
            ax.i().a().a(listB);
        }
        this.f1536a = UUID.randomUUID().toString();
        if (bqnVar.d || bqnVar.h) {
            this.f = null;
        } else {
            this.f = new az(context, str, aarVar.f1790a, this, this);
            this.f.setMinimumWidth(bqnVar.f);
            this.f.setMinimumHeight(bqnVar.c);
            this.f.setVisibility(4);
        }
        this.i = bqnVar;
        this.f1537b = str;
        this.c = context;
        this.e = aarVar;
        this.d = new axe(new h(this));
        this.Q = new zr(200L);
        this.w = new androidx.b.g<>();
    }

    final void a(View view) {
        axa axaVarA;
        if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.bh)).booleanValue() && (axaVarA = this.d.a()) != null) {
            axaVarA.a(view);
        }
    }

    public final void a(HashSet<wm> hashSet) {
        this.N = hashSet;
    }

    public final HashSet<wm> a() {
        return this.N;
    }

    public final void b() {
        if (this.j == null || this.j.f3544b == null) {
            return;
        }
        this.j.f3544b.destroy();
    }

    public final void c() {
        if (this.j == null || this.j.p == null) {
            return;
        }
        try {
            this.j.p.c();
        } catch (RemoteException unused) {
            xe.e("Could not destroy mediation adapter.");
        }
    }

    public final boolean d() {
        return this.L == 0;
    }

    public final boolean e() {
        return this.L == 1;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        b(false);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        b(true);
        this.T = true;
    }

    private final void b(boolean z) {
        View viewFindViewById;
        if (this.f == null || this.j == null || this.j.f3544b == null || this.j.f3544b.w() == null) {
            return;
        }
        if (!z || this.Q.a()) {
            if (this.j.f3544b.w().b()) {
                int[] iArr = new int[2];
                this.f.getLocationOnScreen(iArr);
                bra.a();
                int iB = aac.b(this.c, iArr[0]);
                bra.a();
                int iB2 = aac.b(this.c, iArr[1]);
                if (iB != this.O || iB2 != this.P) {
                    this.O = iB;
                    this.P = iB2;
                    this.j.f3544b.w().a(this.O, this.P, !z);
                }
            }
            if (this.f == null || (viewFindViewById = this.f.getRootView().findViewById(R.id.content)) == null) {
                return;
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            this.f.getGlobalVisibleRect(rect);
            viewFindViewById.getGlobalVisibleRect(rect2);
            if (rect.top != rect2.top) {
                this.R = false;
            }
            if (rect.bottom != rect2.bottom) {
                this.S = false;
            }
        }
    }

    public final String f() {
        return (this.R && this.S) ? BuildConfig.FLAVOR : this.R ? this.T ? "top-scrollable" : "top-locked" : this.S ? this.T ? "bottom-scrollable" : "bottom-locked" : BuildConfig.FLAVOR;
    }

    public final void a(boolean z) {
        if (this.L == 0 && this.j != null && this.j.f3544b != null) {
            this.j.f3544b.stopLoading();
        }
        if (this.g != null) {
            this.g.b();
        }
        if (this.h != null) {
            this.h.b();
        }
        if (z) {
            this.j = null;
        }
    }
}
