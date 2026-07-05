package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
/* loaded from: classes.dex */
final class bbb extends bba {

    /* renamed from: b, reason: collision with root package name */
    private final AudioTimestamp f2481b;
    private long c;
    private long d;
    private long e;

    public bbb() {
        super(null);
        this.f2481b = new AudioTimestamp();
    }

    @Override // com.google.android.gms.internal.ads.bba
    public final void a(AudioTrack audioTrack, boolean z) {
        super.a(audioTrack, z);
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
    }

    @Override // com.google.android.gms.internal.ads.bba
    public final boolean d() {
        boolean timestamp = this.f2479a.getTimestamp(this.f2481b);
        if (timestamp) {
            long j = this.f2481b.framePosition;
            if (this.d > j) {
                this.c++;
            }
            this.d = j;
            this.e = j + (this.c << 32);
        }
        return timestamp;
    }

    @Override // com.google.android.gms.internal.ads.bba
    public final long e() {
        return this.f2481b.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.bba
    public final long f() {
        return this.e;
    }
}
