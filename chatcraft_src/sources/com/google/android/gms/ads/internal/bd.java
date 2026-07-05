package com.google.android.gms.ads.internal;

import android.webkit.CookieManager;
import java.util.concurrent.Callable;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class bd implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ba f1544a;

    bd(ba baVar) {
        this.f1544a = baVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        CookieManager cookieManagerC = ax.g().c(this.f1544a.e.c);
        return cookieManagerC != null ? cookieManagerC.getCookie("googleads.g.doubleclick.net") : BuildConfig.FLAVOR;
    }
}
