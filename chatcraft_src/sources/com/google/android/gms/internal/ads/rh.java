package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.b;

@qj
/* loaded from: classes.dex */
public final class rh extends com.google.android.gms.ads.internal.d<rq> {
    @Override // com.google.android.gms.common.internal.b
    protected final String a() {
        return "com.google.android.gms.ads.service.START";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String c() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public rh(Context context, Looper looper, b.a aVar, b.InterfaceC0066b interfaceC0066b) {
        super(to.a(context), looper, 8, aVar, interfaceC0066b, null);
    }

    public final rq t() {
        return (rq) super.o();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (iInterfaceQueryLocalInterface instanceof rq) {
            return (rq) iInterfaceQueryLocalInterface;
        }
        return new rs(iBinder);
    }
}
