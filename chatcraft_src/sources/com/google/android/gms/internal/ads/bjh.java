package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class bjh {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f2733a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f2734b;

    public final synchronized Map<String, String> a() {
        if (this.f2734b == null) {
            this.f2734b = Collections.unmodifiableMap(new HashMap(this.f2733a));
        }
        return this.f2734b;
    }
}
