package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class mn implements aie<com.google.android.gms.ads.mediation.l, Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ lz f3269a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ kq f3270b;

    mn(mj mjVar, lz lzVar, kq kqVar) {
        this.f3269a = lzVar;
        this.f3270b = kqVar;
    }

    @Override // com.google.android.gms.internal.ads.aie
    public final void a(String str) {
        try {
            this.f3269a.a(str);
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
        }
    }
}
