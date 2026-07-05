package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class mk implements aie<Object, Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ lu f3263a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ kq f3264b;

    mk(mj mjVar, lu luVar, kq kqVar) {
        this.f3263a = luVar;
        this.f3264b = kqVar;
    }

    @Override // com.google.android.gms.internal.ads.aie
    public final void a(String str) {
        try {
            this.f3263a.a(str);
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
        }
    }
}
