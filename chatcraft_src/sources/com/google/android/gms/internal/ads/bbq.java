package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

@TargetApi(24)
/* loaded from: classes.dex */
final class bbq {

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f2498a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaCodec.CryptoInfo.Pattern f2499b;

    private bbq(MediaCodec.CryptoInfo cryptoInfo) {
        this.f2498a = cryptoInfo;
        this.f2499b = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, int i2) {
        this.f2499b.set(i, i2);
        this.f2498a.setPattern(this.f2499b);
    }
}
