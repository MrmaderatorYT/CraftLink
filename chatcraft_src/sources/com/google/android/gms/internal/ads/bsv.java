package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
public final class bsv {

    /* renamed from: a, reason: collision with root package name */
    private final String f3005a;

    /* renamed from: b, reason: collision with root package name */
    private bss f3006b;

    public bsv(bss bssVar) {
        String strA;
        this.f3006b = bssVar;
        try {
            strA = bssVar.a();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
            strA = null;
        }
        this.f3005a = strA;
    }
}
