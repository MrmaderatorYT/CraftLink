package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class afn extends avp {

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f1933b;

    public afn(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.avp
    public final void a(ByteBuffer byteBuffer) {
        this.f1933b = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
