package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;

@TargetApi(23)
/* loaded from: classes.dex */
final class bkt implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bkq f2776a;

    private bkt(bkq bkqVar, MediaCodec mediaCodec) {
        this.f2776a = bkqVar;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        if (this != this.f2776a.f2773b) {
            return;
        }
        this.f2776a.v();
    }
}
