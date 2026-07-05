package com.google.android.gms.internal.ads;

import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class mz {

    /* renamed from: a, reason: collision with root package name */
    private final afu f3286a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3287b;
    private final String c;

    public mz(afu afuVar, Map<String, String> map) {
        this.f3286a = afuVar;
        this.c = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.f3287b = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.f3287b = true;
        }
    }

    public final void a() {
        int iC;
        if (this.f3286a == null) {
            xe.e("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.c)) {
            iC = com.google.android.gms.ads.internal.ax.g().b();
        } else if ("landscape".equalsIgnoreCase(this.c)) {
            iC = com.google.android.gms.ads.internal.ax.g().a();
        } else {
            iC = this.f3287b ? -1 : com.google.android.gms.ads.internal.ax.g().c();
        }
        this.f3286a.setRequestedOrientation(iC);
    }
}
