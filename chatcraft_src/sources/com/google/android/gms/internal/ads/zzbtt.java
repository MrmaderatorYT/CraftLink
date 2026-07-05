package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
public final class zzbtt extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f3665a;

    public zzbtt(asf asfVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f3665a = null;
    }

    public final zzbrl a() {
        return new zzbrl(getMessage());
    }
}
