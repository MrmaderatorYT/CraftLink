package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.xe;
import java.util.List;

/* loaded from: classes.dex */
final class ah implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.internal.ads.bh f1509a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ int f1510b;
    private final /* synthetic */ List c;
    private final /* synthetic */ ad d;

    ah(ad adVar, com.google.android.gms.internal.ads.bh bhVar, int i, List list) {
        this.d = adVar;
        this.f1509a = bhVar;
        this.f1510b = i;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if ((this.f1509a instanceof com.google.android.gms.internal.ads.aw) && this.d.e.t != null) {
                this.d.c = this.f1510b != this.c.size() - 1;
                com.google.android.gms.internal.ads.bb bbVarB = ad.b(this.f1509a);
                this.d.e.t.a(bbVarB);
                this.d.a(bbVarB.q());
                return;
            }
            if ((this.f1509a instanceof com.google.android.gms.internal.ads.aw) && this.d.e.s != null) {
                this.d.c = this.f1510b != this.c.size() - 1;
                com.google.android.gms.internal.ads.aw awVar = (com.google.android.gms.internal.ads.aw) this.f1509a;
                this.d.e.s.a(awVar);
                this.d.a(awVar.n());
                return;
            }
            if ((this.f1509a instanceof com.google.android.gms.internal.ads.au) && this.d.e.t != null) {
                this.d.c = this.f1510b != this.c.size() - 1;
                com.google.android.gms.internal.ads.bb bbVarB2 = ad.b(this.f1509a);
                this.d.e.t.a(bbVarB2);
                this.d.a(bbVarB2.q());
                return;
            }
            if (!(this.f1509a instanceof com.google.android.gms.internal.ads.au) || this.d.e.r == null) {
                this.d.a(3, this.f1510b != this.c.size() - 1);
                return;
            }
            this.d.c = this.f1510b != this.c.size() - 1;
            com.google.android.gms.internal.ads.au auVar = (com.google.android.gms.internal.ads.au) this.f1509a;
            this.d.e.r.a(auVar);
            this.d.a(auVar.n());
        } catch (RemoteException e) {
            xe.d("#007 Could not call remote method.", e);
        }
    }
}
