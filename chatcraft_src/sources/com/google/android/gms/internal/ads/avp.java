package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class avp implements abj {

    /* renamed from: b, reason: collision with root package name */
    private static awb f2322b = awb.a(avp.class);
    private String c;
    private ack d;
    private ByteBuffer f;
    private long g;
    private long h;
    private avv j;
    private long i = -1;
    private ByteBuffer k = null;
    private boolean e = true;

    /* renamed from: a, reason: collision with root package name */
    boolean f2323a = true;

    private final synchronized void b() {
        if (!this.e) {
            try {
                awb awbVar = f2322b;
                String strValueOf = String.valueOf(this.c);
                awbVar.a(strValueOf.length() != 0 ? "mem mapping ".concat(strValueOf) : new String("mem mapping "));
                this.f = this.j.a(this.g, this.i);
                this.e = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected abstract void a(ByteBuffer byteBuffer);

    protected avp(String str) {
        this.c = str;
    }

    @Override // com.google.android.gms.internal.ads.abj
    public final void a(avv avvVar, ByteBuffer byteBuffer, long j, yg ygVar) {
        this.g = avvVar.b();
        this.h = this.g - byteBuffer.remaining();
        this.i = j;
        this.j = avvVar;
        avvVar.a(avvVar.b() + j);
        this.e = false;
        this.f2323a = false;
        d();
    }

    public final synchronized void d() {
        b();
        awb awbVar = f2322b;
        String strValueOf = String.valueOf(this.c);
        awbVar.a(strValueOf.length() != 0 ? "parsing details of ".concat(strValueOf) : new String("parsing details of "));
        if (this.f != null) {
            ByteBuffer byteBuffer = this.f;
            this.f2323a = true;
            byteBuffer.rewind();
            a(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.k = byteBuffer.slice();
            }
            this.f = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.abj
    public final String a() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.abj
    public final void a(ack ackVar) {
        this.d = ackVar;
    }
}
