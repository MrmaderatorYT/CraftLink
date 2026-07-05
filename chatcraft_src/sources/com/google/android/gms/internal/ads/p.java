package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class p implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f3339a;

    p(Context context) {
        this.f3339a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() {
        bra.e().a(this.f3339a);
        return null;
    }
}
