package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.axd;
import com.google.android.gms.internal.ads.axe;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class au implements Callable<axe> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ar f1530a;

    au(ar arVar) {
        this.f1530a = arVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ axe call() {
        return new axe(axd.a(this.f1530a.f1526a.f1790a, this.f1530a.d, false));
    }
}
