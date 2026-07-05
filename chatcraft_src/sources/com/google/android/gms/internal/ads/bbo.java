package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* loaded from: classes.dex */
public final class bbo {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f2496a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f2497b;
    public int[] c;
    private byte[] d;
    private int e;
    private int f;
    private int g;
    private int h;
    private final MediaCodec.CryptoInfo i;
    private final bbq j;

    public bbo() {
        this.i = bkg.f2760a >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.j = bkg.f2760a >= 24 ? new bbq(this.i) : null;
    }

    public final void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.f = i;
        this.f2497b = iArr;
        this.c = iArr2;
        this.d = bArr;
        this.f2496a = bArr2;
        this.e = i2;
        this.g = 0;
        this.h = 0;
        if (bkg.f2760a >= 16) {
            this.i.numSubSamples = this.f;
            this.i.numBytesOfClearData = this.f2497b;
            this.i.numBytesOfEncryptedData = this.c;
            this.i.key = this.d;
            this.i.iv = this.f2496a;
            this.i.mode = this.e;
            if (bkg.f2760a >= 24) {
                this.j.a(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo a() {
        return this.i;
    }
}
