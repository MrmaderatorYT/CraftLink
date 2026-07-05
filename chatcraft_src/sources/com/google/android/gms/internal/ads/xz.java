package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class xz implements Callable<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f3596a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ WebSettings f3597b;

    xz(xy xyVar, Context context, WebSettings webSettings) {
        this.f3596a = context;
        this.f3597b = webSettings;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() {
        if (this.f3596a.getCacheDir() != null) {
            this.f3597b.setAppCachePath(this.f3596a.getCacheDir().getAbsolutePath());
            this.f3597b.setAppCacheMaxSize(0L);
            this.f3597b.setAppCacheEnabled(true);
        }
        this.f3597b.setDatabasePath(this.f3596a.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        this.f3597b.setDatabaseEnabled(true);
        this.f3597b.setDomStorageEnabled(true);
        this.f3597b.setDisplayZoomControls(false);
        this.f3597b.setBuiltInZoomControls(true);
        this.f3597b.setSupportZoom(true);
        this.f3597b.setAllowContentAccess(false);
        return true;
    }
}
