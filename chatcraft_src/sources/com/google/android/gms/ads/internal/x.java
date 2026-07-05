package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.xe;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
final class x implements com.google.android.gms.ads.internal.gmsg.ac<afu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ CountDownLatch f1654a;

    x(CountDownLatch countDownLatch) {
        this.f1654a = countDownLatch;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) {
        xe.e("Adapter returned an ad, but assets substitution failed");
        this.f1654a.countDown();
        afuVar.destroy();
    }
}
