package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* loaded from: classes.dex */
public final class biz implements bja {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2719a;

    /* renamed from: b, reason: collision with root package name */
    private Uri f2720b;
    private int c;
    private int d;

    public biz(byte[] bArr) {
        bjq.a(bArr);
        bjq.a(bArr.length > 0);
        this.f2719a = bArr;
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final long a(bjd bjdVar) throws IOException {
        this.f2720b = bjdVar.f2725a;
        this.c = (int) bjdVar.d;
        this.d = (int) (bjdVar.e == -1 ? this.f2719a.length - bjdVar.d : bjdVar.e);
        if (this.d <= 0 || this.c + this.d > this.f2719a.length) {
            int i = this.c;
            long j = bjdVar.e;
            int length = this.f2719a.length;
            StringBuilder sb = new StringBuilder(77);
            sb.append("Unsatisfiable range: [");
            sb.append(i);
            sb.append(", ");
            sb.append(j);
            sb.append("], length: ");
            sb.append(length);
            throw new IOException(sb.toString());
        }
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.d == 0) {
            return -1;
        }
        int iMin = Math.min(i2, this.d);
        System.arraycopy(this.f2719a, this.c, bArr, i, iMin);
        this.c += iMin;
        this.d -= iMin;
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final Uri b() {
        return this.f2720b;
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final void a() {
        this.f2720b = null;
    }
}
