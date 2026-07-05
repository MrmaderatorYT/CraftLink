package com.google.android.gms.internal.ads;

import android.os.Handler;

/* loaded from: classes.dex */
public final class bar {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f2459a;

    /* renamed from: b, reason: collision with root package name */
    private final baq f2460b;

    public bar(Handler handler, baq baqVar) {
        this.f2459a = baqVar != null ? (Handler) bjq.a(handler) : null;
        this.f2460b = baqVar;
    }

    public final void a(bbr bbrVar) {
        if (this.f2460b != null) {
            this.f2459a.post(new bas(this, bbrVar));
        }
    }

    public final void a(String str, long j, long j2) {
        if (this.f2460b != null) {
            this.f2459a.post(new bat(this, str, j, j2));
        }
    }

    public final void a(bab babVar) {
        if (this.f2460b != null) {
            this.f2459a.post(new bau(this, babVar));
        }
    }

    public final void a(int i, long j, long j2) {
        if (this.f2460b != null) {
            this.f2459a.post(new bav(this, i, j, j2));
        }
    }

    public final void b(bbr bbrVar) {
        if (this.f2460b != null) {
            this.f2459a.post(new baw(this, bbrVar));
        }
    }

    public final void a(int i) {
        if (this.f2460b != null) {
            this.f2459a.post(new bax(this, i));
        }
    }
}
