package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.b;

@qj
/* loaded from: classes.dex */
public final class ej extends com.google.android.gms.ads.internal.d<eq> {
    @Override // com.google.android.gms.common.internal.b
    protected final String a() {
        return "com.google.android.gms.ads.service.HTTP";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String c() {
        return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
    }

    ej(Context context, Looper looper, b.a aVar, b.InterfaceC0066b interfaceC0066b) {
        super(to.a(context), looper, 166, aVar, interfaceC0066b, null);
    }

    public final eq t() {
        return (eq) super.o();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
        if (iInterfaceQueryLocalInterface instanceof eq) {
            return (eq) iInterfaceQueryLocalInterface;
        }
        return new er(iBinder);
    }
}
