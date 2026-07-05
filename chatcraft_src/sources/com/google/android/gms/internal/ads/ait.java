package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.b;

/* loaded from: classes.dex */
public final class ait extends com.google.android.gms.ads.internal.d<aiy> {
    public ait(Context context, Looper looper, b.a aVar, b.InterfaceC0066b interfaceC0066b) {
        super(context, looper, 116, aVar, interfaceC0066b, null);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String a() {
        return "com.google.android.gms.gass.START";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String c() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    public final aiy t() {
        return (aiy) super.o();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        if (iInterfaceQueryLocalInterface instanceof aiy) {
            return (aiy) iInterfaceQueryLocalInterface;
        }
        return new aiz(iBinder);
    }
}
