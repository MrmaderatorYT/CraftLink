package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.xe;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class ao implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ WeakReference f1523a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ an f1524b;

    ao(an anVar, WeakReference weakReference) {
        this.f1524b = anVar;
        this.f1523a = weakReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        an.a(this.f1524b, false);
        a aVar = (a) this.f1523a.get();
        if (aVar != null) {
            bqj bqjVar = this.f1524b.c;
            if (aVar.c(bqjVar)) {
                aVar.b(bqjVar);
            } else {
                xe.d("Ad is not visible. Not refreshing ad.");
                aVar.d.b(bqjVar);
            }
        }
    }
}
