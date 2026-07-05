package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class avq extends avs implements abj {
    private ack f;
    private String g;
    private boolean h;
    private long i;

    public avq(String str) {
        this.g = str;
    }

    @Override // com.google.android.gms.internal.ads.abj
    public final void a(ack ackVar) {
        this.f = ackVar;
    }

    @Override // com.google.android.gms.internal.ads.abj
    public final String a() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.ads.abj
    public final void a(avv avvVar, ByteBuffer byteBuffer, long j, yg ygVar) {
        this.i = avvVar.b() - byteBuffer.remaining();
        this.h = byteBuffer.remaining() == 16;
        a(avvVar, j, ygVar);
    }

    @Override // com.google.android.gms.internal.ads.avs
    public final void a(avv avvVar, long j, yg ygVar) {
        this.f2326b = avvVar;
        this.c = avvVar.b();
        this.d = this.c - ((this.h || 8 + j >= 4294967296L) ? 16 : 8);
        avvVar.a(avvVar.b() + j);
        this.e = avvVar.b();
        this.f2325a = ygVar;
    }
}
