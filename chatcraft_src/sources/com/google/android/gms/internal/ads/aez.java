package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class aez implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1919a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f1920b;
    private final /* synthetic */ long c;
    private final /* synthetic */ long d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ int f;
    private final /* synthetic */ int g;
    private final /* synthetic */ aex h;

    aez(aex aexVar, String str, String str2, long j, long j2, boolean z, int i, int i2) {
        this.h = aexVar;
        this.f1919a = str;
        this.f1920b = str2;
        this.c = j;
        this.d = j2;
        this.e = z;
        this.f = i;
        this.g = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.f1919a);
        map.put("cachedSrc", this.f1920b);
        map.put("bufferedDuration", Long.toString(this.c));
        map.put("totalDuration", Long.toString(this.d));
        map.put("cacheReady", this.e ? "1" : "0");
        map.put("playerCount", Integer.toString(this.f));
        map.put("playerPreparedCount", Integer.toString(this.g));
        this.h.a("onPrecacheEvent", (Map<String, String>) map);
    }
}
