package okhttp3.internal.a;

import b.g;
import b.r;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: FaultHidingSink.java */
/* loaded from: classes.dex */
class e extends g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5104a;

    protected void a(IOException iOException) {
    }

    e(r rVar) {
        super(rVar);
    }

    @Override // b.g, b.r
    public void a_(b.c cVar, long j) throws EOFException {
        if (this.f5104a) {
            cVar.h(j);
            return;
        }
        try {
            super.a_(cVar, j);
        } catch (IOException e) {
            this.f5104a = true;
            a(e);
        }
    }

    @Override // b.g, b.r, java.io.Flushable
    public void flush() {
        if (this.f5104a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.f5104a = true;
            a(e);
        }
    }

    @Override // b.g, b.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f5104a) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.f5104a = true;
            a(e);
        }
    }
}
