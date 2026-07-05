package com.google.gson.b.a;

import com.google.gson.p;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

/* compiled from: JsonTreeReader.java */
/* loaded from: classes.dex */
public final class e extends com.google.gson.stream.a {

    /* renamed from: b, reason: collision with root package name */
    private static final Reader f3916b = new Reader() { // from class: com.google.gson.b.a.e.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }
    };
    private static final Object c = new Object();
    private Object[] d;
    private int e;
    private String[] f;
    private int[] g;

    public e(com.google.gson.l lVar) {
        super(f3916b);
        this.d = new Object[32];
        this.e = 0;
        this.f = new String[32];
        this.g = new int[32];
        a(lVar);
    }

    @Override // com.google.gson.stream.a
    public void a() {
        a(com.google.gson.stream.b.BEGIN_ARRAY);
        a(((com.google.gson.i) t()).iterator());
        this.g[this.e - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public void b() {
        a(com.google.gson.stream.b.END_ARRAY);
        u();
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void c() {
        a(com.google.gson.stream.b.BEGIN_OBJECT);
        a(((com.google.gson.n) t()).a().iterator());
    }

    @Override // com.google.gson.stream.a
    public void d() {
        a(com.google.gson.stream.b.END_OBJECT);
        u();
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public boolean e() {
        com.google.gson.stream.b bVarF = f();
        return (bVarF == com.google.gson.stream.b.END_OBJECT || bVarF == com.google.gson.stream.b.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.b f() {
        if (this.e == 0) {
            return com.google.gson.stream.b.END_DOCUMENT;
        }
        Object objT = t();
        if (objT instanceof Iterator) {
            boolean z = this.d[this.e - 2] instanceof com.google.gson.n;
            Iterator it = (Iterator) objT;
            if (!it.hasNext()) {
                return z ? com.google.gson.stream.b.END_OBJECT : com.google.gson.stream.b.END_ARRAY;
            }
            if (z) {
                return com.google.gson.stream.b.NAME;
            }
            a(it.next());
            return f();
        }
        if (objT instanceof com.google.gson.n) {
            return com.google.gson.stream.b.BEGIN_OBJECT;
        }
        if (objT instanceof com.google.gson.i) {
            return com.google.gson.stream.b.BEGIN_ARRAY;
        }
        if (objT instanceof p) {
            p pVar = (p) objT;
            if (pVar.q()) {
                return com.google.gson.stream.b.STRING;
            }
            if (pVar.a()) {
                return com.google.gson.stream.b.BOOLEAN;
            }
            if (pVar.p()) {
                return com.google.gson.stream.b.NUMBER;
            }
            throw new AssertionError();
        }
        if (objT instanceof com.google.gson.m) {
            return com.google.gson.stream.b.NULL;
        }
        if (objT == c) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new AssertionError();
    }

    private Object t() {
        return this.d[this.e - 1];
    }

    private Object u() {
        Object[] objArr = this.d;
        int i = this.e - 1;
        this.e = i;
        Object obj = objArr[i];
        this.d[this.e] = null;
        return obj;
    }

    private void a(com.google.gson.stream.b bVar) {
        if (f() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + f() + v());
    }

    @Override // com.google.gson.stream.a
    public String g() {
        a(com.google.gson.stream.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        String str = (String) entry.getKey();
        this.f[this.e - 1] = str;
        a(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String h() {
        com.google.gson.stream.b bVarF = f();
        if (bVarF != com.google.gson.stream.b.STRING && bVarF != com.google.gson.stream.b.NUMBER) {
            throw new IllegalStateException("Expected " + com.google.gson.stream.b.STRING + " but was " + bVarF + v());
        }
        String strC = ((p) u()).c();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return strC;
    }

    @Override // com.google.gson.stream.a
    public boolean i() {
        a(com.google.gson.stream.b.BOOLEAN);
        boolean zG = ((p) u()).g();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return zG;
    }

    @Override // com.google.gson.stream.a
    public void j() {
        a(com.google.gson.stream.b.NULL);
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public double k() {
        com.google.gson.stream.b bVarF = f();
        if (bVarF != com.google.gson.stream.b.NUMBER && bVarF != com.google.gson.stream.b.STRING) {
            throw new IllegalStateException("Expected " + com.google.gson.stream.b.NUMBER + " but was " + bVarF + v());
        }
        double d = ((p) t()).d();
        if (!q() && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + d);
        }
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return d;
    }

    @Override // com.google.gson.stream.a
    public long l() {
        com.google.gson.stream.b bVarF = f();
        if (bVarF != com.google.gson.stream.b.NUMBER && bVarF != com.google.gson.stream.b.STRING) {
            throw new IllegalStateException("Expected " + com.google.gson.stream.b.NUMBER + " but was " + bVarF + v());
        }
        long jE = ((p) t()).e();
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return jE;
    }

    @Override // com.google.gson.stream.a
    public int m() {
        com.google.gson.stream.b bVarF = f();
        if (bVarF != com.google.gson.stream.b.NUMBER && bVarF != com.google.gson.stream.b.STRING) {
            throw new IllegalStateException("Expected " + com.google.gson.stream.b.NUMBER + " but was " + bVarF + v());
        }
        int iF = ((p) t()).f();
        u();
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
        return iF;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d = new Object[]{c};
        this.e = 1;
    }

    @Override // com.google.gson.stream.a
    public void n() {
        if (f() == com.google.gson.stream.b.NAME) {
            g();
            this.f[this.e - 2] = "null";
        } else {
            u();
            if (this.e > 0) {
                this.f[this.e - 1] = "null";
            }
        }
        if (this.e > 0) {
            int[] iArr = this.g;
            int i = this.e - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return getClass().getSimpleName();
    }

    public void o() {
        a(com.google.gson.stream.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        a(entry.getValue());
        a(new p((String) entry.getKey()));
    }

    private void a(Object obj) {
        if (this.e == this.d.length) {
            Object[] objArr = new Object[this.e * 2];
            int[] iArr = new int[this.e * 2];
            String[] strArr = new String[this.e * 2];
            System.arraycopy(this.d, 0, objArr, 0, this.e);
            System.arraycopy(this.g, 0, iArr, 0, this.e);
            System.arraycopy(this.f, 0, strArr, 0, this.e);
            this.d = objArr;
            this.g = iArr;
            this.f = strArr;
        }
        Object[] objArr2 = this.d;
        int i = this.e;
        this.e = i + 1;
        objArr2[i] = obj;
    }

    @Override // com.google.gson.stream.a
    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.e) {
            if (this.d[i] instanceof com.google.gson.i) {
                i++;
                if (this.d[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.g[i]);
                    sb.append(']');
                }
            } else if (this.d[i] instanceof com.google.gson.n) {
                i++;
                if (this.d[i] instanceof Iterator) {
                    sb.append('.');
                    if (this.f[i] != null) {
                        sb.append(this.f[i]);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    private String v() {
        return " at path " + p();
    }
}
