package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class ml implements aie<aif, Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ lx f3265a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ kq f3266b;
    private final /* synthetic */ mj c;

    ml(mj mjVar, lx lxVar, kq kqVar) {
        this.c = mjVar;
        this.f3265a = lxVar;
        this.f3266b = kqVar;
    }

    @Override // com.google.android.gms.internal.ads.aie
    public final void a(String str) {
        try {
            this.f3265a.a(str);
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
        }
    }
}
