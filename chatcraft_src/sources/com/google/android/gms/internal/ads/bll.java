package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class bll implements bmu {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<bf> f2808a;

    public bll(bf bfVar) {
        this.f2808a = new WeakReference<>(bfVar);
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final View a() {
        bf bfVar = this.f2808a.get();
        if (bfVar != null) {
            return bfVar.o();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final boolean b() {
        return this.f2808a.get() == null;
    }

    @Override // com.google.android.gms.internal.ads.bmu
    public final bmu c() {
        return new bln(this.f2808a.get());
    }
}
