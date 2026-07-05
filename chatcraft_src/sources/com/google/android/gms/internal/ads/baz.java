package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* loaded from: classes.dex */
final class baz extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AudioTrack f2475a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bay f2476b;

    baz(bay bayVar, AudioTrack audioTrack) {
        this.f2476b = bayVar;
        this.f2475a = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.f2475a.flush();
            this.f2475a.release();
        } finally {
            this.f2476b.h.open();
        }
    }
}
