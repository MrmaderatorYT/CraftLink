package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.b;

@qj
/* loaded from: classes.dex */
public final class boc extends com.google.android.gms.ads.internal.d<boh> {
    @Override // com.google.android.gms.common.internal.b
    protected final String a() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String c() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    boc(Context context, Looper looper, b.a aVar, b.InterfaceC0066b interfaceC0066b) {
        super(to.a(context), looper, 123, aVar, interfaceC0066b, null);
    }

    public final boh t() {
        return (boh) super.o();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
        if (iInterfaceQueryLocalInterface instanceof boh) {
            return (boh) iInterfaceQueryLocalInterface;
        }
        return new boi(iBinder);
    }
}
