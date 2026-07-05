package b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource.java */
/* loaded from: classes.dex */
public final class k implements s {

    /* renamed from: a, reason: collision with root package name */
    private final e f1174a;

    /* renamed from: b, reason: collision with root package name */
    private final Inflater f1175b;
    private int c;
    private boolean d;

    k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f1174a = eVar;
        this.f1175b = inflater;
    }

    @Override // b.s
    public long a(c cVar, long j) throws DataFormatException, IOException {
        boolean zB;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zB = b();
            try {
                o oVarE = cVar.e(1);
                int iInflate = this.f1175b.inflate(oVarE.f1187a, oVarE.c, (int) Math.min(j, 8192 - oVarE.c));
                if (iInflate > 0) {
                    oVarE.c += iInflate;
                    long j2 = iInflate;
                    cVar.f1165b += j2;
                    return j2;
                }
                if (!this.f1175b.finished() && !this.f1175b.needsDictionary()) {
                }
                c();
                if (oVarE.f1188b != oVarE.c) {
                    return -1L;
                }
                cVar.f1164a = oVarE.b();
                p.a(oVarE);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zB);
        throw new EOFException("source exhausted prematurely");
    }

    public boolean b() {
        if (!this.f1175b.needsInput()) {
            return false;
        }
        c();
        if (this.f1175b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f1174a.e()) {
            return true;
        }
        o oVar = this.f1174a.c().f1164a;
        this.c = oVar.c - oVar.f1188b;
        this.f1175b.setInput(oVar.f1187a, oVar.f1188b, this.c);
        return false;
    }

    private void c() {
        if (this.c == 0) {
            return;
        }
        int remaining = this.c - this.f1175b.getRemaining();
        this.c -= remaining;
        this.f1174a.h(remaining);
    }

    @Override // b.s
    public t a() {
        return this.f1174a.a();
    }

    @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.d) {
            return;
        }
        this.f1175b.end();
        this.d = true;
        this.f1174a.close();
    }
}
