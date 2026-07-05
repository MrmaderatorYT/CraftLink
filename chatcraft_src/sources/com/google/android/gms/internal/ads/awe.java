package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class awe extends androidx.browser.a.d {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<awf> f2340a;

    public awe(awf awfVar) {
        this.f2340a = new WeakReference<>(awfVar);
    }

    @Override // androidx.browser.a.d
    public final void a(ComponentName componentName, androidx.browser.a.b bVar) {
        awf awfVar = this.f2340a.get();
        if (awfVar != null) {
            awfVar.a(bVar);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        awf awfVar = this.f2340a.get();
        if (awfVar != null) {
            awfVar.a();
        }
    }
}
