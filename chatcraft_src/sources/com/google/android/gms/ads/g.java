package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.ads.bqa;
import com.google.android.gms.internal.ads.btj;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final btj f1490a;

    public g(Context context) {
        this.f1490a = new btj(context);
        com.google.android.gms.common.internal.i.a(context, "Context cannot be null");
    }

    public final boolean a() {
        return this.f1490a.a();
    }

    public final boolean b() {
        return this.f1490a.b();
    }

    public final void a(c cVar) {
        this.f1490a.a(cVar.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(a aVar) {
        this.f1490a.a(aVar);
        if (aVar != 0 && (aVar instanceof bqa)) {
            this.f1490a.a((bqa) aVar);
        } else if (aVar == 0) {
            this.f1490a.a((bqa) null);
        }
    }

    public final void a(String str) {
        this.f1490a.a(str);
    }

    public final void c() {
        this.f1490a.d();
    }

    public final void a(com.google.android.gms.ads.reward.d dVar) {
        this.f1490a.a(dVar);
    }

    public final void a(com.google.android.gms.ads.reward.a aVar) {
        this.f1490a.a(aVar);
    }

    public final Bundle d() {
        return this.f1490a.c();
    }

    public final void a(boolean z) {
        this.f1490a.a(true);
    }

    public final void b(boolean z) {
        this.f1490a.b(z);
    }
}
