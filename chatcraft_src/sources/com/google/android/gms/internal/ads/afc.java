package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class afc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1925a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f1926b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ aex e;

    afc(aex aexVar, String str, String str2, String str3, String str4) {
        this.e = aexVar;
        this.f1925a = str;
        this.f1926b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheCanceled");
        map.put("src", this.f1925a);
        if (!TextUtils.isEmpty(this.f1926b)) {
            map.put("cachedSrc", this.f1926b);
        }
        aex aexVar = this.e;
        map.put("type", aex.c(this.c));
        map.put("reason", this.c);
        if (!TextUtils.isEmpty(this.d)) {
            map.put("message", this.d);
        }
        this.e.a("onPrecacheEvent", (Map<String, String>) map);
    }
}
