package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class m extends k {

    /* renamed from: b, reason: collision with root package name */
    private static final WeakReference<byte[]> f1749b = new WeakReference<>(null);

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<byte[]> f1750a;

    m(byte[] bArr) {
        super(bArr);
        this.f1750a = f1749b;
    }

    protected abstract byte[] d();

    @Override // com.google.android.gms.common.k
    final byte[] c() {
        byte[] bArrD;
        synchronized (this) {
            bArrD = this.f1750a.get();
            if (bArrD == null) {
                bArrD = d();
                this.f1750a = new WeakReference<>(bArrD);
            }
        }
        return bArrD;
    }
}
