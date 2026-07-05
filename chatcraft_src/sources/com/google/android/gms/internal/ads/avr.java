package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class avr extends avp implements abj {

    /* renamed from: b, reason: collision with root package name */
    private int f2324b;
    private int c;

    protected avr(String str) {
        super(str);
    }

    public final int e() {
        if (!this.f2323a) {
            d();
        }
        return this.f2324b;
    }

    protected final long b(ByteBuffer byteBuffer) {
        this.f2324b = aaj.a(byteBuffer.get());
        this.c = (aaj.b(byteBuffer) << 8) + 0 + aaj.a(byteBuffer.get());
        return 4L;
    }
}
