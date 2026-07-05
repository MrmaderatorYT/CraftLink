package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

@qj
@TargetApi(14)
/* loaded from: classes.dex */
public final class add {

    /* renamed from: b, reason: collision with root package name */
    private long f1860b;

    /* renamed from: a, reason: collision with root package name */
    private final long f1859a = TimeUnit.MILLISECONDS.toNanos(((Long) bra.e().a(o.x)).longValue());
    private boolean c = true;

    add() {
    }

    public final void a() {
        this.c = true;
    }

    public final void a(SurfaceTexture surfaceTexture, acs acsVar) {
        if (acsVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.c || Math.abs(timestamp - this.f1860b) >= this.f1859a) {
            this.c = false;
            this.f1860b = timestamp;
            xn.f3583a.post(new ade(this, acsVar));
        }
    }
}
