package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class afa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1921a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f1922b;
    private final /* synthetic */ int c;
    private final /* synthetic */ aex d;

    afa(aex aexVar, String str, String str2, int i) {
        this.d = aexVar;
        this.f1921a = str;
        this.f1922b = str2;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheComplete");
        map.put("src", this.f1921a);
        map.put("cachedSrc", this.f1922b);
        map.put("totalBytes", Integer.toString(this.c));
        this.d.a("onPrecacheEvent", (Map<String, String>) map);
    }
}
