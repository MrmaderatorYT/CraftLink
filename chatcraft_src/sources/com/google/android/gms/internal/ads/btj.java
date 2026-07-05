package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;

@qj
/* loaded from: classes.dex */
public final class btj {

    /* renamed from: a, reason: collision with root package name */
    private final kj f3017a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3018b;
    private final bqm c;
    private com.google.android.gms.ads.a d;
    private bqa e;
    private brs f;
    private String g;
    private com.google.android.gms.ads.reward.a h;
    private com.google.android.gms.ads.a.a i;
    private com.google.android.gms.ads.a.c j;
    private com.google.android.gms.ads.f k;
    private com.google.android.gms.ads.reward.d l;
    private boolean m;
    private boolean n;

    public btj(Context context) {
        this(context, bqm.f2973a, null);
    }

    private btj(Context context, bqm bqmVar, com.google.android.gms.ads.a.e eVar) {
        this.f3017a = new kj();
        this.f3018b = context;
        this.c = bqmVar;
    }

    public final boolean a() {
        try {
            if (this.f == null) {
                return false;
            }
            return this.f.m();
        } catch (RemoteException e) {
            aan.d("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    public final boolean b() {
        try {
            if (this.f == null) {
                return false;
            }
            return this.f.s();
        } catch (RemoteException e) {
            aan.d("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    public final void a(bte bteVar) {
        try {
            if (this.f == null) {
                if (this.g == null) {
                    b("loadAd");
                }
                bqn bqnVarA = this.m ? bqn.a() : new bqn();
                bqr bqrVarB = bra.b();
                Context context = this.f3018b;
                this.f = new bqv(bqrVarB, context, bqnVarA, this.g, this.f3017a).a(context, false);
                if (this.d != null) {
                    this.f.a(new bqe(this.d));
                }
                if (this.e != null) {
                    this.f.a(new bqb(this.e));
                }
                if (this.h != null) {
                    this.f.a(new bqi(this.h));
                }
                if (this.i != null) {
                    this.f.a(new bqp(this.i));
                }
                if (this.j != null) {
                    this.f.a(new al(this.j));
                }
                if (this.k != null) {
                    this.f.a(this.k.a());
                }
                if (this.l != null) {
                    this.f.a(new uj(this.l));
                }
                this.f.c(this.n);
            }
            if (this.f.b(bqm.a(this.f3018b, bteVar))) {
                this.f3017a.a(bteVar.j());
            }
        } catch (RemoteException e) {
            aan.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void a(com.google.android.gms.ads.a aVar) {
        try {
            this.d = aVar;
            if (this.f != null) {
                this.f.a(aVar != null ? new bqe(aVar) : null);
            }
        } catch (RemoteException e) {
            aan.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void a(bqa bqaVar) {
        try {
            this.e = bqaVar;
            if (this.f != null) {
                this.f.a(bqaVar != null ? new bqb(bqaVar) : null);
            }
        } catch (RemoteException e) {
            aan.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void a(String str) {
        if (this.g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.g = str;
    }

    public final void a(com.google.android.gms.ads.reward.a aVar) {
        try {
            this.h = aVar;
            if (this.f != null) {
                this.f.a(aVar != null ? new bqi(aVar) : null);
            }
        } catch (RemoteException e) {
            aan.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final Bundle c() {
        try {
            if (this.f != null) {
                return this.f.q();
            }
        } catch (RemoteException e) {
            aan.d("#008 Must be called on the main UI thread.", e);
        }
        return new Bundle();
    }

    public final void a(com.google.android.gms.ads.reward.d dVar) {
        try {
            this.l = dVar;
            if (this.f != null) {
                this.f.a(dVar != null ? new uj(dVar) : null);
            }
        } catch (RemoteException e) {
            aan.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void a(boolean z) {
        this.m = true;
    }

    public final void d() {
        try {
            b("show");
            this.f.H();
        } catch (RemoteException e) {
            aan.d("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void b(boolean z) {
        try {
            this.n = z;
            if (this.f != null) {
                this.f.c(z);
            }
        } catch (RemoteException e) {
            aan.d("#008 Must be called on the main UI thread.", e);
        }
    }

    private final void b(String str) {
        if (this.f != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
        sb.append("The ad unit ID must be set on InterstitialAd before ");
        sb.append(str);
        sb.append(" is called.");
        throw new IllegalStateException(sb.toString());
    }
}
