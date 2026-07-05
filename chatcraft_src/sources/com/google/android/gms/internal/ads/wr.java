package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class wr extends xa {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ wp f3556a;

    wr(wp wpVar) {
        this.f3556a = wpVar;
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void c_() {
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void a() {
        q qVar = new q(this.f3556a.f, this.f3556a.g.f1790a);
        synchronized (this.f3556a.f3553a) {
            try {
                com.google.android.gms.ads.internal.ax.n();
                t.a(this.f3556a.h, qVar);
            } catch (IllegalArgumentException e) {
                xe.c("Cannot config CSI reporter.", e);
            }
        }
    }
}
