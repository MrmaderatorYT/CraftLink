package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.WeakHashMap;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
public final class dc implements com.google.android.gms.ads.b.i {

    /* renamed from: a, reason: collision with root package name */
    private static WeakHashMap<IBinder, dc> f3053a = new WeakHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final cz f3054b;
    private final com.google.android.gms.ads.b.b c;
    private final com.google.android.gms.ads.j d = new com.google.android.gms.ads.j();

    private dc(cz czVar) {
        Context context;
        this.f3054b = czVar;
        com.google.android.gms.ads.b.b bVar = null;
        try {
            context = (Context) com.google.android.gms.dynamic.b.a(czVar.i());
        } catch (RemoteException | NullPointerException e) {
            aan.b(BuildConfig.FLAVOR, e);
            context = null;
        }
        if (context != null) {
            com.google.android.gms.ads.b.b bVar2 = new com.google.android.gms.ads.b.b(context);
            try {
                if (this.f3054b.a(com.google.android.gms.dynamic.b.a(bVar2))) {
                    bVar = bVar2;
                }
            } catch (RemoteException e2) {
                aan.b(BuildConfig.FLAVOR, e2);
            }
        }
        this.c = bVar;
    }

    public static dc a(cz czVar) {
        synchronized (f3053a) {
            dc dcVar = f3053a.get(czVar.asBinder());
            if (dcVar != null) {
                return dcVar;
            }
            dc dcVar2 = new dc(czVar);
            f3053a.put(czVar.asBinder(), dcVar2);
            return dcVar2;
        }
    }

    public final cz b() {
        return this.f3054b;
    }

    @Override // com.google.android.gms.ads.b.i
    public final String a() {
        try {
            return this.f3054b.b();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            return null;
        }
    }
}
