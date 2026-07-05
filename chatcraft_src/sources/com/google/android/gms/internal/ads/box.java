package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

@qj
/* loaded from: classes.dex */
public final class box {

    /* renamed from: a, reason: collision with root package name */
    azk f2917a;

    /* renamed from: b, reason: collision with root package name */
    boolean f2918b;

    public final bpb a(byte[] bArr) {
        return new bpb(this, bArr);
    }

    public box(Context context, String str, String str2) {
        o.a(context);
        try {
            this.f2917a = (azk) aao.a(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", boy.f2919a);
            com.google.android.gms.dynamic.b.a(context);
            this.f2917a.a(com.google.android.gms.dynamic.b.a(context), str, null);
            this.f2918b = true;
        } catch (RemoteException | zzbbg | NullPointerException unused) {
            aan.b("Cannot dynamite load clearcut");
        }
    }

    public box(Context context) {
        o.a(context);
        if (((Boolean) bra.e().a(o.cu)).booleanValue()) {
            try {
                this.f2917a = (azk) aao.a(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", boz.f2920a);
                com.google.android.gms.dynamic.b.a(context);
                this.f2917a.a(com.google.android.gms.dynamic.b.a(context), "GMA_SDK");
                this.f2918b = true;
            } catch (RemoteException | zzbbg | NullPointerException unused) {
                aan.b("Cannot dynamite load clearcut");
            }
        }
    }

    public box() {
    }
}
