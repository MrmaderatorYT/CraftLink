package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public final class zzjz extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final String f3672a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3673b;
    private final String c;
    private final String d;

    public zzjz(bab babVar, Throwable th, boolean z, int i) {
        String strValueOf = String.valueOf(babVar);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 36);
        sb.append("Decoder init failed: [");
        sb.append(i);
        sb.append("], ");
        sb.append(strValueOf);
        super(sb.toString(), th);
        this.f3672a = babVar.e;
        this.f3673b = false;
        this.c = null;
        String str = i < 0 ? "neg_" : BuildConfig.FLAVOR;
        int iAbs = Math.abs(i);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 64);
        sb2.append("com.google.android.exoplayer.MediaCodecTrackRenderer_");
        sb2.append(str);
        sb2.append(iAbs);
        this.d = sb2.toString();
    }

    public zzjz(bab babVar, Throwable th, boolean z, String str) {
        String strValueOf = String.valueOf(babVar);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23 + String.valueOf(strValueOf).length());
        sb.append("Decoder init failed: ");
        sb.append(str);
        sb.append(", ");
        sb.append(strValueOf);
        super(sb.toString(), th);
        this.f3672a = babVar.e;
        this.f3673b = false;
        this.c = str;
        String diagnosticInfo = null;
        if (bkg.f2760a >= 21 && (th instanceof MediaCodec.CodecException)) {
            diagnosticInfo = ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.d = diagnosticInfo;
    }
}
