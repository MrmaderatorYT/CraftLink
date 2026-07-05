package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

@qj
/* loaded from: classes.dex */
public final class aep {

    /* renamed from: a, reason: collision with root package name */
    private long f1908a;

    public final long a(ByteBuffer byteBuffer) {
        aem aemVar;
        adl adlVar;
        if (this.f1908a > 0) {
            return this.f1908a;
        }
        try {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.flip();
            Iterator<abj> it = new zi(new aeo(byteBufferDuplicate), aer.f1909a).b().iterator();
            while (true) {
                aemVar = null;
                if (!it.hasNext()) {
                    adlVar = null;
                    break;
                }
                abj next = it.next();
                if (next instanceof adl) {
                    adlVar = (adl) next;
                    break;
                }
            }
            Iterator<abj> it2 = adlVar.b().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                abj next2 = it2.next();
                if (next2 instanceof aem) {
                    aemVar = (aem) next2;
                    break;
                }
            }
            this.f1908a = (aemVar.c() * 1000) / aemVar.b();
            return this.f1908a;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
