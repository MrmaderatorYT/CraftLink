package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

@qj
/* loaded from: classes.dex */
public final class td {

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap<Context, tf> f3467a = new WeakHashMap<>();

    public final Future<ta> a(Context context) {
        return xl.a(new te(this, context));
    }
}
