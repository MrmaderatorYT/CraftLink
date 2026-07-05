package com.google.gson.b;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.b.a.n;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* compiled from: Streams.java */
/* loaded from: classes.dex */
public final class l {
    public static com.google.gson.l a(com.google.gson.stream.a aVar) {
        boolean z;
        try {
            try {
                aVar.f();
                z = false;
            } catch (EOFException e) {
                e = e;
                z = true;
            }
            try {
                return n.X.read(aVar);
            } catch (EOFException e2) {
                e = e2;
                if (z) {
                    return com.google.gson.m.f4033a;
                }
                throw new JsonSyntaxException(e);
            }
        } catch (MalformedJsonException e3) {
            throw new JsonSyntaxException(e3);
        } catch (IOException e4) {
            throw new JsonIOException(e4);
        } catch (NumberFormatException e5) {
            throw new JsonSyntaxException(e5);
        }
    }

    public static void a(com.google.gson.l lVar, com.google.gson.stream.c cVar) {
        n.X.write(cVar, lVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* compiled from: Streams.java */
    private static final class a extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private final Appendable f4010a;

        /* renamed from: b, reason: collision with root package name */
        private final C0088a f4011b = new C0088a();

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        a(Appendable appendable) {
            this.f4010a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.f4011b.f4012a = cArr;
            this.f4010a.append(this.f4011b, i, i2 + i);
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.f4010a.append((char) i);
        }

        /* compiled from: Streams.java */
        /* renamed from: com.google.gson.b.l$a$a, reason: collision with other inner class name */
        static class C0088a implements CharSequence {

            /* renamed from: a, reason: collision with root package name */
            char[] f4012a;

            C0088a() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f4012a.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f4012a[i];
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f4012a, i, i2 - i);
            }
        }
    }
}
