package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.afu;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
final class w implements com.google.android.gms.ads.internal.gmsg.ac<afu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ CountDownLatch f1653a;

    w(CountDownLatch countDownLatch) {
        this.f1653a = countDownLatch;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) {
        this.f1653a.countDown();
        afuVar.getView().setVisibility(0);
    }
}
