package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class afb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1923a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f1924b;
    private final /* synthetic */ long c;
    private final /* synthetic */ aex d;

    afb(aex aexVar, String str, String str2, long j) {
        this.d = aexVar;
        this.f1923a = str;
        this.f1924b = str2;
        this.c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheComplete");
        map.put("src", this.f1923a);
        map.put("cachedSrc", this.f1924b);
        map.put("totalDuration", Long.toString(this.c));
        this.d.a("onPrecacheEvent", (Map<String, String>) map);
    }
}
