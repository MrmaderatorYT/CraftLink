package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.b;

/* loaded from: classes.dex */
final class bny implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bnv f2891a;

    bny(bnv bnvVar) {
        this.f2891a = bnvVar;
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void a(Bundle bundle) {
        synchronized (this.f2891a.f2888b) {
            try {
            } catch (DeadObjectException e) {
                xe.b("Unable to obtain a cache service instance.", e);
                this.f2891a.c();
            }
            if (this.f2891a.c != null) {
                this.f2891a.e = this.f2891a.c.t();
                this.f2891a.f2888b.notifyAll();
            } else {
                this.f2891a.f2888b.notifyAll();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void a(int i) {
        synchronized (this.f2891a.f2888b) {
            this.f2891a.e = null;
            this.f2891a.f2888b.notifyAll();
        }
    }
}
