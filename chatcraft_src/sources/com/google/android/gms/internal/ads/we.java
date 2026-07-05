package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public abstract class we implements yg {

    /* renamed from: a, reason: collision with root package name */
    private static Logger f3539a = Logger.getLogger(we.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private ThreadLocal<ByteBuffer> f3540b = new xf(this);

    public abstract abj a(String str, byte[] bArr, String str2);

    @Override // com.google.android.gms.internal.ads.yg
    public final abj a(avv avvVar, ack ackVar) throws EOFException {
        int iA;
        long jA;
        long jB = avvVar.b();
        this.f3540b.get().rewind().limit(8);
        do {
            iA = avvVar.a(this.f3540b.get());
            if (iA == 8) {
                this.f3540b.get().rewind();
                long jA2 = aaj.a(this.f3540b.get());
                byte[] bArr = null;
                if (jA2 < 8 && jA2 > 1) {
                    Logger logger = f3539a;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(jA2);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                String strF = aaj.f(this.f3540b.get());
                if (jA2 == 1) {
                    this.f3540b.get().limit(16);
                    avvVar.a(this.f3540b.get());
                    this.f3540b.get().position(8);
                    jA = aaj.c(this.f3540b.get()) - 16;
                } else {
                    jA = jA2 == 0 ? avvVar.a() - avvVar.b() : jA2 - 8;
                }
                if ("uuid".equals(strF)) {
                    this.f3540b.get().limit(this.f3540b.get().limit() + 16);
                    avvVar.a(this.f3540b.get());
                    bArr = new byte[16];
                    for (int iPosition = this.f3540b.get().position() - 16; iPosition < this.f3540b.get().position(); iPosition++) {
                        bArr[iPosition - (this.f3540b.get().position() - 16)] = this.f3540b.get().get(iPosition);
                    }
                    jA -= 16;
                }
                long j = jA;
                abj abjVarA = a(strF, bArr, ackVar instanceof abj ? ((abj) ackVar).a() : BuildConfig.FLAVOR);
                abjVarA.a(ackVar);
                this.f3540b.get().rewind();
                abjVarA.a(avvVar, this.f3540b.get(), j, this);
                return abjVarA;
            }
        } while (iA >= 0);
        avvVar.a(jB);
        throw new EOFException();
    }
}
