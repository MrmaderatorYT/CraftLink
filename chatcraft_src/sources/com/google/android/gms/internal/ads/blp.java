package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class blp implements bmu {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<View> f2813a;

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<wk> f2814b;

    public blp(View view, wk wkVar) {
        this.f2813a = new WeakReference<>(view);
        this.f2814b = new WeakReference<>(wkVar);
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final View a() {
        return this.f2813a.get();
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final boolean b() {
        return this.f2813a.get() == null || this.f2814b.get() == null;
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final bmu c() {
        return new blo(this.f2813a.get(), this.f2814b.get());
    }
}
