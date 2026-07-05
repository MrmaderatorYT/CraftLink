package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicBoolean;

@qj
/* loaded from: classes.dex */
public final class btg {

    /* renamed from: a, reason: collision with root package name */
    private final kj f3014a;

    /* renamed from: b, reason: collision with root package name */
    private final bqm f3015b;
    private final AtomicBoolean c;
    private final com.google.android.gms.ads.j d;
    private final brc e;
    private bqa f;
    private com.google.android.gms.ads.a g;
    private com.google.android.gms.ads.d[] h;
    private com.google.android.gms.ads.a.a i;
    private com.google.android.gms.ads.f j;
    private brs k;
    private com.google.android.gms.ads.a.c l;
    private com.google.android.gms.ads.k m;
    private String n;
    private ViewGroup o;
    private int p;
    private boolean q;

    private static boolean a(int i) {
        return i == 1;
    }

    public btg(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, bqm.f2973a, i);
    }

    public btg(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, bqm.f2973a, i);
    }

    private btg(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, bqm bqmVar, brs brsVar, int i) {
        this.f3014a = new kj();
        this.d = new com.google.android.gms.ads.j();
        this.e = new bti(this);
        this.o = viewGroup;
        this.f3015b = bqmVar;
        this.k = null;
        this.c = new AtomicBoolean(false);
        this.p = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                bqq bqqVar = new bqq(context, attributeSet);
                this.h = bqqVar.a(z);
                this.n = bqqVar.a();
                if (viewGroup.isInEditMode()) {
                    aac aacVarA = bra.a();
                    com.google.android.gms.ads.d dVar = this.h[0];
                    int i2 = this.p;
                    bqn bqnVar = new bqn(context, dVar);
                    bqnVar.j = a(i2);
                    aacVarA.a(viewGroup, bqnVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                bra.a().a(viewGroup, new bqn(context, com.google.android.gms.ads.d.f1484a), e.getMessage(), e.getMessage());
            }
        }
    }

    private btg(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, bqm bqmVar, int i) {
        this(viewGroup, attributeSet, z, bqmVar, null, i);
    }

    public final void a() {
        try {
            if (this.k != null) {
                this.k.j();
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    public final com.google.android.gms.ads.a b() {
        return this.g;
    }

    public final com.google.android.gms.ads.d c() {
        bqn bqnVarL;
        try {
            if (this.k != null && (bqnVarL = this.k.l()) != null) {
                return bqnVarL.b();
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
        if (this.h != null) {
            return this.h[0];
        }
        return null;
    }

    public final com.google.android.gms.ads.d[] d() {
        return this.h;
    }

    public final String e() {
        if (this.n == null && this.k != null) {
            try {
                this.n = this.k.D();
            } catch (RemoteException e) {
                aan.d("#007 Could not call remote method.", e);
            }
        }
        return this.n;
    }

    public final com.google.android.gms.ads.a.a f() {
        return this.i;
    }

    public final com.google.android.gms.ads.a.c g() {
        return this.l;
    }

    public final void a(bte bteVar) {
        brs brsVarA;
        try {
            if (this.k == null) {
                if ((this.h == null || this.n == null) && this.k == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.o.getContext();
                bqn bqnVarA = a(context, this.h, this.p);
                if ("search_v2".equals(bqnVarA.f2974a)) {
                    brsVarA = new bqu(bra.b(), context, bqnVarA, this.n).a(context, false);
                } else {
                    brsVarA = new bqs(bra.b(), context, bqnVarA, this.n, this.f3014a).a(context, false);
                }
                this.k = brsVarA;
                this.k.a(new bqe(this.e));
                if (this.f != null) {
                    this.k.a(new bqb(this.f));
                }
                if (this.i != null) {
                    this.k.a(new bqp(this.i));
                }
                if (this.l != null) {
                    this.k.a(new al(this.l));
                }
                if (this.j != null) {
                    this.k.a(this.j.a());
                }
                if (this.m != null) {
                    this.k.a(new buc(this.m));
                }
                this.k.b(this.q);
                try {
                    com.google.android.gms.dynamic.a aVarK = this.k.k();
                    if (aVarK != null) {
                        this.o.addView((View) com.google.android.gms.dynamic.b.a(aVarK));
                    }
                } catch (RemoteException e) {
                    aan.d("#007 Could not call remote method.", e);
                }
            }
            if (this.k.b(bqm.a(this.o.getContext(), bteVar))) {
                this.f3014a.a(bteVar.j());
            }
        } catch (RemoteException e2) {
            aan.d("#007 Could not call remote method.", e2);
        }
    }

    public final void h() {
        try {
            if (this.k != null) {
                this.k.o();
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    public final void i() {
        try {
            if (this.k != null) {
                this.k.p();
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(com.google.android.gms.ads.a aVar) {
        this.g = aVar;
        this.e.a(aVar);
    }

    public final void a(bqa bqaVar) {
        try {
            this.f = bqaVar;
            if (this.k != null) {
                this.k.a(bqaVar != null ? new bqb(bqaVar) : null);
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(com.google.android.gms.ads.d... dVarArr) {
        if (this.h != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        b(dVarArr);
    }

    public final void b(com.google.android.gms.ads.d... dVarArr) {
        this.h = dVarArr;
        try {
            if (this.k != null) {
                this.k.a(a(this.o.getContext(), this.h, this.p));
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
        this.o.requestLayout();
    }

    public final void a(String str) {
        if (this.n != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.n = str;
    }

    public final void a(com.google.android.gms.ads.a.a aVar) {
        try {
            this.i = aVar;
            if (this.k != null) {
                this.k.a(aVar != null ? new bqp(aVar) : null);
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(com.google.android.gms.ads.a.c cVar) {
        this.l = cVar;
        try {
            if (this.k != null) {
                this.k.a(cVar != null ? new al(cVar) : null);
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(boolean z) {
        this.q = z;
        try {
            if (this.k != null) {
                this.k.b(this.q);
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    public final void a(com.google.android.gms.ads.f fVar) {
        this.j = fVar;
        try {
            if (this.k != null) {
                this.k.a(this.j == null ? null : this.j.a());
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    public final String j() {
        try {
            if (this.k != null) {
                return this.k.q_();
            }
            return null;
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final com.google.android.gms.ads.j k() {
        return this.d;
    }

    public final bsw l() {
        if (this.k == null) {
            return null;
        }
        try {
            return this.k.t();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void a(com.google.android.gms.ads.k kVar) {
        this.m = kVar;
        try {
            if (this.k != null) {
                this.k.a(kVar == null ? null : new buc(kVar));
            }
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    public final com.google.android.gms.ads.k m() {
        return this.m;
    }

    private static bqn a(Context context, com.google.android.gms.ads.d[] dVarArr, int i) {
        bqn bqnVar = new bqn(context, dVarArr);
        bqnVar.j = a(i);
        return bqnVar;
    }
}
