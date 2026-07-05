package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes.dex */
public final class bjn<T> implements bjl {

    /* renamed from: a, reason: collision with root package name */
    public final bjd f2739a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2740b;
    private final bja c;
    private final bjo<? extends T> d;
    private volatile T e;
    private volatile boolean f;
    private volatile long g;

    public bjn(bja bjaVar, Uri uri, int i, bjo<? extends T> bjoVar) {
        this.c = bjaVar;
        this.f2739a = new bjd(uri, 1);
        this.f2740b = i;
        this.d = bjoVar;
    }

    public final T d() {
        return this.e;
    }

    public final long e() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final void a() {
        this.f = true;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final boolean b() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.bjl
    public final void c() throws IOException {
        bjc bjcVar = new bjc(this.c, this.f2739a);
        try {
            bjcVar.b();
            this.e = this.d.a(this.c.b(), bjcVar);
        } finally {
            this.g = bjcVar.a();
            bkg.a(bjcVar);
        }
    }
}
