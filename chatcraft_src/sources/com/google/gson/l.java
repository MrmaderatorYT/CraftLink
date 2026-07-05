package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;

/* compiled from: JsonElement.java */
/* loaded from: classes.dex */
public abstract class l {
    public boolean h() {
        return this instanceof i;
    }

    public boolean i() {
        return this instanceof n;
    }

    public boolean j() {
        return this instanceof p;
    }

    public boolean k() {
        return this instanceof m;
    }

    public n l() {
        if (i()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public i m() {
        if (h()) {
            return (i) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public p n() {
        if (j()) {
            return (p) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean o() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.c cVar = new com.google.gson.stream.c(stringWriter);
            cVar.b(true);
            com.google.gson.b.l.a(this, cVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
