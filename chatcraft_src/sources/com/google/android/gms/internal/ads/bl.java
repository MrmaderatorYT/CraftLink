package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class bl {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<afu> f2787a;

    /* renamed from: b, reason: collision with root package name */
    private String f2788b;

    public bl(afu afuVar) {
        this.f2787a = new WeakReference<>(afuVar);
    }

    public final void a(pn pnVar) {
        pnVar.a("/loadHtml", new bm(this, pnVar));
        pnVar.a("/showOverlay", new bo(this, pnVar));
        pnVar.a("/hideOverlay", new bp(this, pnVar));
        afu afuVar = this.f2787a.get();
        if (afuVar != null) {
            afuVar.a("/sendMessageToSdk", new bq(this, pnVar));
        }
    }
}
