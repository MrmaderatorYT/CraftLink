package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

/* loaded from: classes.dex */
public final class bkx {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f2781a;

    /* renamed from: b, reason: collision with root package name */
    private final bkw f2782b;

    public bkx(Handler handler, bkw bkwVar) {
        this.f2781a = bkwVar != null ? (Handler) bjq.a(handler) : null;
        this.f2782b = bkwVar;
    }

    public final void a(bbr bbrVar) {
        if (this.f2782b != null) {
            this.f2781a.post(new bky(this, bbrVar));
        }
    }

    public final void a(String str, long j, long j2) {
        if (this.f2782b != null) {
            this.f2781a.post(new bkz(this, str, j, j2));
        }
    }

    public final void a(bab babVar) {
        if (this.f2782b != null) {
            this.f2781a.post(new bla(this, babVar));
        }
    }

    public final void a(int i, long j) {
        if (this.f2782b != null) {
            this.f2781a.post(new blb(this, i, j));
        }
    }

    public final void a(int i, int i2, int i3, float f) {
        if (this.f2782b != null) {
            this.f2781a.post(new bld(this, i, i2, i3, f));
        }
    }

    public final void a(Surface surface) {
        if (this.f2782b != null) {
            this.f2781a.post(new ble(this, surface));
        }
    }

    public final void b(bbr bbrVar) {
        if (this.f2782b != null) {
            this.f2781a.post(new blf(this, bbrVar));
        }
    }
}
