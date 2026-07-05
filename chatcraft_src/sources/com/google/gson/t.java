package com.google.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: TypeAdapter.java */
/* loaded from: classes.dex */
public abstract class t<T> {
    public abstract T read(com.google.gson.stream.a aVar);

    public abstract void write(com.google.gson.stream.c cVar, T t);

    public final void toJson(Writer writer, T t) {
        write(new com.google.gson.stream.c(writer), t);
    }

    public final t<T> nullSafe() {
        return new t<T>() { // from class: com.google.gson.t.1
            @Override // com.google.gson.t
            public void write(com.google.gson.stream.c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.f();
                } else {
                    t.this.write(cVar, t);
                }
            }

            @Override // com.google.gson.t
            public T read(com.google.gson.stream.a aVar) throws IOException {
                if (aVar.f() == com.google.gson.stream.b.NULL) {
                    aVar.j();
                    return null;
                }
                return (T) t.this.read(aVar);
            }
        };
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final l toJsonTree(T t) {
        try {
            com.google.gson.b.a.f fVar = new com.google.gson.b.a.f();
            write(fVar, t);
            return fVar.a();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public final T fromJson(Reader reader) {
        return read(new com.google.gson.stream.a(reader));
    }

    public final T fromJson(String str) {
        return fromJson(new StringReader(str));
    }

    public final T fromJsonTree(l lVar) {
        try {
            return read(new com.google.gson.b.a.e(lVar));
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
