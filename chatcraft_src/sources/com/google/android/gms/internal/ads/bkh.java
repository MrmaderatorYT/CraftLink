package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
final class bkh implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2762a;

    bkh(String str) {
        this.f2762a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f2762a);
    }
}
