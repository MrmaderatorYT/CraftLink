package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.b;
import java.io.IOException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
final class bom implements b.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bok f2903a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bod f2904b;
    private final /* synthetic */ abv c;

    bom(bok bokVar, bod bodVar, abv abvVar) {
        this.f2903a = bokVar;
        this.f2904b = bodVar;
        this.c = abvVar;
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void a(int i) {
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void a(Bundle bundle) {
        synchronized (this.f2903a.d) {
            if (this.f2903a.f2901b) {
                return;
            }
            bok.a(this.f2903a, true);
            final boc bocVar = this.f2903a.f2900a;
            if (bocVar == null) {
                return;
            }
            final bod bodVar = this.f2904b;
            final abv abvVar = this.c;
            final abl<?> ablVarA = xl.a(new Runnable(this, bocVar, bodVar, abvVar) { // from class: com.google.android.gms.internal.ads.bon

                /* renamed from: a, reason: collision with root package name */
                private final bom f2905a;

                /* renamed from: b, reason: collision with root package name */
                private final boc f2906b;
                private final bod c;
                private final abv d;

                {
                    this.f2905a = this;
                    this.f2906b = bocVar;
                    this.c = bodVar;
                    this.d = abvVar;
                }

                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    bom bomVar = this.f2905a;
                    boc bocVar2 = this.f2906b;
                    bod bodVar2 = this.c;
                    abv abvVar2 = this.d;
                    try {
                        boa boaVarA = bocVar2.t().a(bodVar2);
                        if (!boaVarA.a()) {
                            abvVar2.a(new RuntimeException("No entry contents."));
                            bomVar.f2903a.a();
                            return;
                        }
                        bop bopVar = new bop(bomVar, boaVarA.b(), 1);
                        int i = bopVar.read();
                        if (i == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        bopVar.unread(i);
                        abvVar2.b(bopVar);
                    } catch (RemoteException | IOException e) {
                        xe.b("Unable to obtain a cache service instance.", e);
                        abvVar2.a(e);
                        bomVar.f2903a.a();
                    }
                }
            });
            abv abvVar2 = this.c;
            final abv abvVar3 = this.c;
            abvVar2.a(new Runnable(abvVar3, ablVarA) { // from class: com.google.android.gms.internal.ads.boo

                /* renamed from: a, reason: collision with root package name */
                private final abv f2907a;

                /* renamed from: b, reason: collision with root package name */
                private final Future f2908b;

                {
                    this.f2907a = abvVar3;
                    this.f2908b = ablVarA;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    abv abvVar4 = this.f2907a;
                    Future future = this.f2908b;
                    if (abvVar4.isCancelled()) {
                        future.cancel(true);
                    }
                }
            }, abq.f1817b);
        }
    }
}
