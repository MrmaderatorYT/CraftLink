package com.google.android.gms.internal.ads;

import java.security.interfaces.ECPrivateKey;

/* loaded from: classes.dex */
public final class anu implements ajf {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f2098a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private final ECPrivateKey f2099b;
    private final anw c;
    private final String d;
    private final byte[] e;
    private final aoc f;
    private final ant g;

    public anu(ECPrivateKey eCPrivateKey, byte[] bArr, String str, aoc aocVar, ant antVar) {
        this.f2099b = eCPrivateKey;
        this.c = new anw(eCPrivateKey);
        this.e = bArr;
        this.d = str;
        this.f = aocVar;
        this.g = antVar;
    }
}
