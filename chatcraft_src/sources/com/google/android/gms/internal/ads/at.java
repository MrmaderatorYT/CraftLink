package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;

@qj
/* loaded from: classes.dex */
public final class at extends ce {

    /* renamed from: a, reason: collision with root package name */
    private final Drawable f2243a;

    /* renamed from: b, reason: collision with root package name */
    private final Uri f2244b;
    private final double c;

    public at(Drawable drawable, Uri uri, double d) {
        this.f2243a = drawable;
        this.f2244b = uri;
        this.c = d;
    }

    @Override // com.google.android.gms.internal.ads.cd
    public final com.google.android.gms.dynamic.a a() {
        return com.google.android.gms.dynamic.b.a(this.f2243a);
    }

    @Override // com.google.android.gms.internal.ads.cd
    public final Uri b() {
        return this.f2244b;
    }

    @Override // com.google.android.gms.internal.ads.cd
    public final double c() {
        return this.c;
    }
}
