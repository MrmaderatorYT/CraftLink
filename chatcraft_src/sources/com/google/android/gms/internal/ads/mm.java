package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class mm implements aie<aig, Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ mb f3267a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ kq f3268b;
    private final /* synthetic */ mj c;

    mm(mj mjVar, mb mbVar, kq kqVar) {
        this.c = mjVar;
        this.f3267a = mbVar;
        this.f3268b = kqVar;
    }

    @Override // com.google.android.gms.internal.ads.aie
    public final void a(String str) {
        try {
            this.f3267a.a(str);
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
        }
    }
}
