package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

@TargetApi(21)
/* loaded from: classes.dex */
final class bel implements bej {

    /* renamed from: a, reason: collision with root package name */
    private final int f2586a;

    /* renamed from: b, reason: collision with root package name */
    private MediaCodecInfo[] f2587b;

    public bel(boolean z) {
        this.f2586a = z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.bej
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bej
    public final int a() {
        c();
        return this.f2587b.length;
    }

    @Override // com.google.android.gms.internal.ads.bej
    public final MediaCodecInfo a(int i) {
        c();
        return this.f2587b[i];
    }

    @Override // com.google.android.gms.internal.ads.bej
    public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private final void c() {
        if (this.f2587b == null) {
            this.f2587b = new MediaCodecList(this.f2586a).getCodecInfos();
        }
    }
}
