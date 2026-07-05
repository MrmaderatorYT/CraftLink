package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

@qj
/* loaded from: classes.dex */
final class aeo implements avv {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f1907a;

    aeo(ByteBuffer byteBuffer) {
        this.f1907a = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.avv, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.google.android.gms.internal.ads.avv
    public final int a(ByteBuffer byteBuffer) {
        if (this.f1907a.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), this.f1907a.remaining());
        byte[] bArr = new byte[iMin];
        this.f1907a.get(bArr);
        byteBuffer.put(bArr);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.avv
    public final long a() {
        return this.f1907a.limit();
    }

    @Override // com.google.android.gms.internal.ads.avv
    public final long b() {
        return this.f1907a.position();
    }

    @Override // com.google.android.gms.internal.ads.avv
    public final void a(long j) {
        this.f1907a.position((int) j);
    }

    @Override // com.google.android.gms.internal.ads.avv
    public final ByteBuffer a(long j, long j2) {
        int iPosition = this.f1907a.position();
        this.f1907a.position((int) j);
        ByteBuffer byteBufferSlice = this.f1907a.slice();
        byteBufferSlice.limit((int) j2);
        this.f1907a.position(iPosition);
        return byteBufferSlice;
    }
}
