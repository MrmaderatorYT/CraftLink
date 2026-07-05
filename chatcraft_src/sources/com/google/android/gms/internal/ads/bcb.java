package com.google.android.gms.internal.ads;

import java.io.EOFException;

/* loaded from: classes.dex */
public final class bcb implements bcm {
    @Override // com.google.android.gms.internal.ads.bcm
    public final void a(long j, int i, int i2, int i3, bcn bcnVar) {
    }

    @Override // com.google.android.gms.internal.ads.bcm
    public final void a(bab babVar) {
    }

    @Override // com.google.android.gms.internal.ads.bcm
    public final int a(bce bceVar, int i, boolean z) throws EOFException {
        int iA = bceVar.a(i);
        if (iA != -1) {
            return iA;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.bcm
    public final void a(bjz bjzVar, int i) {
        bjzVar.d(i);
    }
}
