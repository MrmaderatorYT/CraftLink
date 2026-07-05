package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public final class jc {
    private static final Comparator<byte[]> e = new kd();

    /* renamed from: a, reason: collision with root package name */
    private final List<byte[]> f3189a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<byte[]> f3190b = new ArrayList(64);
    private int c = 0;
    private final int d = 4096;

    public jc(int i) {
    }

    public final synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f3190b.size(); i2++) {
            byte[] bArr = this.f3190b.get(i2);
            if (bArr.length >= i) {
                this.c -= bArr.length;
                this.f3190b.remove(i2);
                this.f3189a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public final synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.d) {
                this.f3189a.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f3190b, bArr, e);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f3190b.add(iBinarySearch, bArr);
                this.c += bArr.length;
                a();
            }
        }
    }

    private final synchronized void a() {
        while (this.c > this.d) {
            byte[] bArrRemove = this.f3189a.remove(0);
            this.f3190b.remove(bArrRemove);
            this.c -= bArrRemove.length;
        }
    }
}
