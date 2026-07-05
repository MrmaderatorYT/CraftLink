package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class bhm {

    /* renamed from: a, reason: collision with root package name */
    public final bgj f2673a;

    /* renamed from: b, reason: collision with root package name */
    public bhu f2674b;
    public bhi c;
    private long d;
    private int e;

    public bhm(long j, bhu bhuVar, boolean z, boolean z2) {
        bcc bdnVar;
        this.d = j;
        this.f2674b = bhuVar;
        String str = bhuVar.f2689a.d;
        if (bjv.c(str) || "application/ttml+xml".equals(str)) {
            this.f2673a = null;
        } else {
            if ("application/x-rawcc".equals(str)) {
                bdnVar = new beb(bhuVar.f2689a);
            } else {
                if (str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm")) {
                    bdnVar = new bct(1);
                } else {
                    int i = z ? 4 : 0;
                    bdnVar = new bdn(z2 ? i | 8 : i);
                }
            }
            this.f2673a = new bgj(bdnVar, bhuVar.f2689a);
        }
        this.c = bhuVar.e();
    }

    public final void a(long j, bhu bhuVar) throws zzkz {
        int iA;
        bhi bhiVarE = this.f2674b.e();
        bhi bhiVarE2 = bhuVar.e();
        this.d = j;
        this.f2674b = bhuVar;
        if (bhiVarE == null) {
            return;
        }
        this.c = bhiVarE2;
        if (bhiVarE.b() && (iA = bhiVarE.a(this.d)) != 0) {
            int iA2 = (bhiVarE.a() + iA) - 1;
            long jA = bhiVarE.a(iA2) + bhiVarE.a(iA2, this.d);
            int iA3 = bhiVarE2.a();
            long jA2 = bhiVarE2.a(iA3);
            if (jA == jA2) {
                this.e += (iA2 + 1) - iA3;
            } else {
                if (jA < jA2) {
                    throw new zzkz();
                }
                this.e += bhiVarE.a(jA2, this.d) - iA3;
            }
        }
    }

    public final int a() {
        return this.c.a() + this.e;
    }

    public final int b() {
        return this.c.a(this.d);
    }

    public final long a(int i) {
        return this.c.a(i - this.e);
    }

    public final long b(int i) {
        return a(i) + this.c.a(i - this.e, this.d);
    }

    public final int a(long j) {
        return this.c.a(j, this.d) + this.e;
    }

    public final bht c(int i) {
        return this.c.b(i - this.e);
    }
}
