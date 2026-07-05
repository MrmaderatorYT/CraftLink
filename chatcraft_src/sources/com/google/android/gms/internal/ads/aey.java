package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class aey implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1917a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f1918b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    private final /* synthetic */ boolean e = false;
    private final /* synthetic */ aex f;

    aey(aex aexVar, String str, String str2, int i, int i2, boolean z) {
        this.f = aexVar;
        this.f1917a = str;
        this.f1918b = str2;
        this.c = i;
        this.d = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.f1917a);
        map.put("cachedSrc", this.f1918b);
        map.put("bytesLoaded", Integer.toString(this.c));
        map.put("totalBytes", Integer.toString(this.d));
        map.put("cacheReady", this.e ? "1" : "0");
        this.f.a("onPrecacheEvent", (Map<String, String>) map);
    }
}
