package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: classes.dex */
public final class aem extends avr {

    /* renamed from: b, reason: collision with root package name */
    private Date f1904b;
    private Date c;
    private long d;
    private long e;
    private double f;
    private float g;
    private awc h;
    private long i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;

    public aem() {
        super("mvhd");
        this.f = 1.0d;
        this.g = 1.0f;
        this.h = awc.f2337a;
    }

    public final long b() {
        return this.d;
    }

    public final long c() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.avp
    public final void a(ByteBuffer byteBuffer) {
        b(byteBuffer);
        if (e() == 1) {
            this.f1904b = avx.a(aaj.c(byteBuffer));
            this.c = avx.a(aaj.c(byteBuffer));
            this.d = aaj.a(byteBuffer);
            this.e = aaj.c(byteBuffer);
        } else {
            this.f1904b = avx.a(aaj.a(byteBuffer));
            this.c = avx.a(aaj.a(byteBuffer));
            this.d = aaj.a(byteBuffer);
            this.e = aaj.a(byteBuffer);
        }
        this.f = aaj.d(byteBuffer);
        byteBuffer.get(new byte[2]);
        this.g = ((short) ((r0[1] & Constants.DimensionIds.NETHER) | ((short) (0 | ((r0[0] << 8) & 65280))))) / 256.0f;
        aaj.b(byteBuffer);
        aaj.a(byteBuffer);
        aaj.a(byteBuffer);
        this.h = awc.a(byteBuffer);
        this.j = byteBuffer.getInt();
        this.k = byteBuffer.getInt();
        this.l = byteBuffer.getInt();
        this.m = byteBuffer.getInt();
        this.n = byteBuffer.getInt();
        this.o = byteBuffer.getInt();
        this.i = aaj.a(byteBuffer);
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.f1904b + ";modificationTime=" + this.c + ";timescale=" + this.d + ";duration=" + this.e + ";rate=" + this.f + ";volume=" + this.g + ";matrix=" + this.h + ";nextTrackId=" + this.i + "]";
    }
}
