package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
final class xm implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f3581a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f3582b;

    xm(String str) {
        this.f3582b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f3582b;
        int andIncrement = this.f3581a.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
