package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* loaded from: classes.dex */
public final class anv implements ajg {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f2100a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private final anx f2101b;
    private final String c;
    private final byte[] d;
    private final aoc e;
    private final ant f;

    public anv(ECPublicKey eCPublicKey, byte[] bArr, String str, aoc aocVar, ant antVar) throws GeneralSecurityException {
        anz.a(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.f2101b = new anx(eCPublicKey);
        this.d = bArr;
        this.c = str;
        this.e = aocVar;
        this.f = antVar;
    }

    @Override // com.google.android.gms.internal.ads.ajg
    public final byte[] a(byte[] bArr, byte[] bArr2) throws IllegalStateException, GeneralSecurityException {
        any anyVarA = this.f2101b.a(this.c, this.d, bArr2, this.f.a(), this.e);
        byte[] bArrA = this.f.a(anyVarA.b()).a(bArr, f2100a);
        byte[] bArrA2 = anyVarA.a();
        return ByteBuffer.allocate(bArrA2.length + bArrA.length).put(bArrA2).put(bArrA).array();
    }
}
