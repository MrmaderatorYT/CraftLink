package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class aay implements aaw {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1792a;

    aay(String str) {
        this.f1792a = str;
    }

    @Override // com.google.android.gms.internal.ads.aaw
    public final void a(@Nullable Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.aaw
    public final void a(Throwable th) {
        com.google.android.gms.ads.internal.ax.i().a(th, this.f1792a);
    }
}
