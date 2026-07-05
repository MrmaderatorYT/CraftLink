package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class aod implements aja {

    /* renamed from: a, reason: collision with root package name */
    private final aoo f2114a;

    /* renamed from: b, reason: collision with root package name */
    private final ajl f2115b;
    private final int c;

    public aod(aoo aooVar, ajl ajlVar, int i) {
        this.f2114a = aooVar;
        this.f2115b = ajlVar;
        this.c = i;
    }

    @Override // com.google.android.gms.internal.ads.aja
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArrA = this.f2114a.a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return anp.a(bArrA, this.f2115b.a(anp.a(bArr2, bArrA, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }
}
