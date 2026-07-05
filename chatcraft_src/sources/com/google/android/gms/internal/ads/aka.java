package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class aka implements aja {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f2027a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private final ams f2028b;
    private final aja c;

    public aka(ams amsVar, aja ajaVar) {
        this.f2028b = amsVar;
        this.c = ajaVar;
    }

    @Override // com.google.android.gms.internal.ads.aja
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArrI = ajq.b(this.f2028b).i();
        byte[] bArrA = this.c.a(bArrI, f2027a);
        byte[] bArrA2 = ((aja) ajq.a(this.f2028b.a(), bArrI)).a(bArr, bArr2);
        return ByteBuffer.allocate(bArrA.length + 4 + bArrA2.length).putInt(bArrA.length).put(bArrA).put(bArrA2).array();
    }
}
