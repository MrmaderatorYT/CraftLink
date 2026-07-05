package com.google.android.gms.internal.ads;

import java.util.Iterator;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class bmz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bmy f2859a;

    bmz(bmy bmyVar) {
        this.f2859a = bmyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f2859a.c) {
            if (this.f2859a.d && this.f2859a.e) {
                bmy.a(this.f2859a, false);
                xe.b("App went background");
                Iterator it = this.f2859a.f.iterator();
                while (it.hasNext()) {
                    try {
                        ((bna) it.next()).a(false);
                    } catch (Exception e) {
                        aan.b(BuildConfig.FLAVOR, e);
                    }
                }
            } else {
                xe.b("App is still foreground");
            }
        }
    }
}
