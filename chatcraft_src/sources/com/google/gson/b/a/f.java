package com.google.gson.b.a;

import com.google.gson.p;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonTreeWriter.java */
/* loaded from: classes.dex */
public final class f extends com.google.gson.stream.c {

    /* renamed from: a, reason: collision with root package name */
    private static final Writer f3917a = new Writer() { // from class: com.google.gson.b.a.f.1
        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private static final p f3918b = new p("closed");
    private final List<com.google.gson.l> c;
    private String d;
    private com.google.gson.l e;

    @Override // com.google.gson.stream.c, java.io.Flushable
    public void flush() {
    }

    public f() {
        super(f3917a);
        this.c = new ArrayList();
        this.e = com.google.gson.m.f4033a;
    }

    public com.google.gson.l a() {
        if (!this.c.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.c);
        }
        return this.e;
    }

    private com.google.gson.l j() {
        return this.c.get(this.c.size() - 1);
    }

    private void a(com.google.gson.l lVar) {
        if (this.d != null) {
            if (!lVar.k() || i()) {
                ((com.google.gson.n) j()).a(this.d, lVar);
            }
            this.d = null;
            return;
        }
        if (this.c.isEmpty()) {
            this.e = lVar;
            return;
        }
        com.google.gson.l lVarJ = j();
        if (lVarJ instanceof com.google.gson.i) {
            ((com.google.gson.i) lVarJ).a(lVar);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c b() {
        com.google.gson.i iVar = new com.google.gson.i();
        a(iVar);
        this.c.add(iVar);
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c c() {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof com.google.gson.i) {
            this.c.remove(this.c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c d() {
        com.google.gson.n nVar = new com.google.gson.n();
        a(nVar);
        this.c.add(nVar);
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c e() {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof com.google.gson.n) {
            this.c.remove(this.c.size() - 1);
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c a(String str) {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (j() instanceof com.google.gson.n) {
            this.d = str;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c b(String str) {
        if (str == null) {
            return f();
        }
        a(new p(str));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c f() {
        a(com.google.gson.m.f4033a);
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c a(boolean z) {
        a(new p(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c a(Boolean bool) {
        if (bool == null) {
            return f();
        }
        a(new p(bool));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c a(long j) {
        a(new p((Number) Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c a(Number number) {
        if (number == null) {
            return f();
        }
        if (!g()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new p(number));
        return this;
    }

    @Override // com.google.gson.stream.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add(f3918b);
    }
}
