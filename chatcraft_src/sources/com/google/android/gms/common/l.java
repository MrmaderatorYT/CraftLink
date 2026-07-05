package com.google.android.gms.common;

import java.util.Arrays;

/* loaded from: classes.dex */
final class l extends k {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f1748a;

    l(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f1748a = bArr;
    }

    @Override // com.google.android.gms.common.k
    final byte[] c() {
        return this.f1748a;
    }
}
