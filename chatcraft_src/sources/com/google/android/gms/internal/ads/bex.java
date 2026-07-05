package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;

/* loaded from: classes.dex */
public final class bex {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f2595a;

    /* renamed from: b, reason: collision with root package name */
    private final bew f2596b;
    private final long c;

    public bex(Handler handler, bew bewVar) {
        this(handler, bewVar, 0L);
    }

    private bex(Handler handler, bew bewVar, long j) {
        this.f2595a = bewVar != null ? (Handler) bjq.a(handler) : null;
        this.f2596b = bewVar;
        this.c = j;
    }

    public final bex a(long j) {
        return new bex(this.f2595a, this.f2596b, j);
    }

    public final void a(bjd bjdVar, int i, long j) {
        a(bjdVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j);
    }

    public final void a(bjd bjdVar, int i, int i2, bab babVar, int i3, Object obj, long j, long j2, long j3) {
        if (this.f2596b != null) {
            this.f2595a.post(new bey(this, bjdVar, i, i2, babVar, i3, obj, j, j2, j3));
        }
    }

    public final void a(bjd bjdVar, int i, long j, long j2, long j3) {
        a(bjdVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
    }

    public final void a(bjd bjdVar, int i, int i2, bab babVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        if (this.f2596b != null) {
            this.f2595a.post(new bez(this, bjdVar, i, i2, babVar, i3, obj, j, j2, j3, j4, j5));
        }
    }

    public final void b(bjd bjdVar, int i, long j, long j2, long j3) {
        b(bjdVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
    }

    public final void b(bjd bjdVar, int i, int i2, bab babVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
        if (this.f2596b != null) {
            this.f2595a.post(new bfa(this, bjdVar, i, i2, babVar, i3, obj, j, j2, j3, j4, j5));
        }
    }

    public final void a(bjd bjdVar, int i, long j, long j2, long j3, IOException iOException, boolean z) {
        a(bjdVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
    }

    public final void a(bjd bjdVar, int i, int i2, bab babVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        if (this.f2596b != null) {
            this.f2595a.post(new bfb(this, bjdVar, i, i2, babVar, i3, obj, j, j2, j3, j4, j5, iOException, z));
        }
    }

    public final void a(int i, bab babVar, int i2, Object obj, long j) {
        if (this.f2596b != null) {
            this.f2595a.post(new bfc(this, i, babVar, i2, obj, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long b(long j) {
        long jA = azo.a(j);
        if (jA == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.c + jA;
    }
}
