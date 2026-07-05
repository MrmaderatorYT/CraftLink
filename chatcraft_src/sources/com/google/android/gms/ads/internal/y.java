package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.kw;
import com.google.android.gms.internal.ads.kz;
import com.google.android.gms.internal.ads.xe;
import java.util.Map;

/* loaded from: classes.dex */
final class y implements com.google.android.gms.ads.internal.gmsg.ac<afu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ kw f1655a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ c f1656b;
    private final /* synthetic */ kz c;

    y(kw kwVar, c cVar, kz kzVar) {
        this.f1655a = kwVar;
        this.f1656b = cVar;
        this.c = kzVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) {
        afu afuVar2 = afuVar;
        View view = afuVar2.getView();
        if (view != null) {
            try {
                if (this.f1655a != null) {
                    if (this.f1655a.k()) {
                        t.b(afuVar2);
                        return;
                    } else {
                        this.f1655a.a(com.google.android.gms.dynamic.b.a(view));
                        this.f1656b.f1572a.e();
                        return;
                    }
                }
                if (this.c != null) {
                    if (this.c.i()) {
                        t.b(afuVar2);
                    } else {
                        this.c.a(com.google.android.gms.dynamic.b.a(view));
                        this.f1656b.f1572a.e();
                    }
                }
            } catch (RemoteException e) {
                xe.c("Unable to call handleClick on mapper", e);
            }
        }
    }
}
