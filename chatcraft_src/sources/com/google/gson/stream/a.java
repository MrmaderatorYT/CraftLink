package com.google.gson.stream;

import com.google.gson.b.a.e;
import com.google.gson.b.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f4039b = ")]}'\n".toCharArray();
    private final Reader c;
    private long j;
    private int k;
    private String l;
    private int n;
    private String[] o;
    private int[] p;
    private boolean d = false;
    private final char[] e = new char[1024];
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;

    /* renamed from: a, reason: collision with root package name */
    int f4040a = 0;
    private int[] m = new int[32];

    static {
        f.f3997a = new f() { // from class: com.google.gson.stream.a.1
            @Override // com.google.gson.b.f
            public void a(a aVar) throws IOException {
                if (aVar instanceof e) {
                    ((e) aVar).o();
                    return;
                }
                int iR = aVar.f4040a;
                if (iR == 0) {
                    iR = aVar.r();
                }
                if (iR == 13) {
                    aVar.f4040a = 9;
                    return;
                }
                if (iR == 12) {
                    aVar.f4040a = 8;
                    return;
                }
                if (iR == 14) {
                    aVar.f4040a = 10;
                    return;
                }
                throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.s());
            }
        };
    }

    public a(Reader reader) {
        this.n = 0;
        int[] iArr = this.m;
        int i = this.n;
        this.n = i + 1;
        iArr[i] = 6;
        this.o = new String[32];
        this.p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.c = reader;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final boolean q() {
        return this.d;
    }

    public void a() throws IOException {
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 3) {
            a(1);
            this.p[this.n - 1] = 0;
            this.f4040a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + s());
        }
    }

    public void b() throws IOException {
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 4) {
            this.n--;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            this.f4040a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + s());
    }

    public void c() throws IOException {
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 1) {
            a(3);
            this.f4040a = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + s());
        }
    }

    public void d() throws IOException {
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 2) {
            this.n--;
            this.o[this.n] = null;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            this.f4040a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + s());
    }

    public boolean e() throws IOException {
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        return (iR == 2 || iR == 4) ? false : true;
    }

    public b f() throws IOException {
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        switch (iR) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    int r() throws IOException {
        int iB;
        int i = this.m[this.n - 1];
        if (i == 1) {
            this.m[this.n - 1] = 2;
        } else if (i == 2) {
            int iB2 = b(true);
            if (iB2 != 44) {
                if (iB2 != 59) {
                    if (iB2 == 93) {
                        this.f4040a = 4;
                        return 4;
                    }
                    throw b("Unterminated array");
                }
                w();
            }
        } else {
            if (i == 3 || i == 5) {
                this.m[this.n - 1] = 4;
                if (i == 5 && (iB = b(true)) != 44) {
                    if (iB != 59) {
                        if (iB == 125) {
                            this.f4040a = 2;
                            return 2;
                        }
                        throw b("Unterminated object");
                    }
                    w();
                }
                int iB3 = b(true);
                if (iB3 == 34) {
                    this.f4040a = 13;
                    return 13;
                }
                if (iB3 == 39) {
                    w();
                    this.f4040a = 12;
                    return 12;
                }
                if (iB3 == 125) {
                    if (i != 5) {
                        this.f4040a = 2;
                        return 2;
                    }
                    throw b("Expected name");
                }
                w();
                this.f--;
                if (a((char) iB3)) {
                    this.f4040a = 14;
                    return 14;
                }
                throw b("Expected name");
            }
            if (i == 4) {
                this.m[this.n - 1] = 5;
                int iB4 = b(true);
                if (iB4 != 58) {
                    if (iB4 == 61) {
                        w();
                        if ((this.f < this.g || b(1)) && this.e[this.f] == '>') {
                            this.f++;
                        }
                    } else {
                        throw b("Expected ':'");
                    }
                }
            } else if (i == 6) {
                if (this.d) {
                    z();
                }
                this.m[this.n - 1] = 7;
            } else if (i == 7) {
                if (b(false) == -1) {
                    this.f4040a = 17;
                    return 17;
                }
                w();
                this.f--;
            } else if (i == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iB5 = b(true);
        if (iB5 == 34) {
            this.f4040a = 9;
            return 9;
        }
        if (iB5 == 39) {
            w();
            this.f4040a = 8;
            return 8;
        }
        if (iB5 != 44 && iB5 != 59) {
            if (iB5 == 91) {
                this.f4040a = 3;
                return 3;
            }
            if (iB5 != 93) {
                if (iB5 == 123) {
                    this.f4040a = 1;
                    return 1;
                }
                this.f--;
                int iO = o();
                if (iO != 0) {
                    return iO;
                }
                int iT = t();
                if (iT != 0) {
                    return iT;
                }
                if (!a(this.e[this.f])) {
                    throw b("Expected value");
                }
                w();
                this.f4040a = 10;
                return 10;
            }
            if (i == 1) {
                this.f4040a = 4;
                return 4;
            }
        }
        if (i == 1 || i == 2) {
            w();
            this.f--;
            this.f4040a = 7;
            return 7;
        }
        throw b("Unexpected value");
    }

    private int o() {
        String str;
        String str2;
        int i;
        char c = this.e[this.f];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f + i2 >= this.g && !b(i2 + 1)) {
                return 0;
            }
            char c2 = this.e[this.f + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f + length < this.g || b(length + 1)) && a(this.e[this.f + length])) {
            return 0;
        }
        this.f += length;
        this.f4040a = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
    
        if (a(r14) != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0097, code lost:
    
        if (r9 != 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0099, code lost:
    
        if (r10 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009f, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a1, code lost:
    
        if (r13 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a7, code lost:
    
        if (r11 != 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a9, code lost:
    
        if (r13 != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ab, code lost:
    
        if (r13 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ae, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00af, code lost:
    
        r18.j = r11;
        r18.f += r3;
        r18.f4040a = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ba, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00bb, code lost:
    
        if (r9 == 2) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00be, code lost:
    
        if (r9 == 4) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c1, code lost:
    
        if (r9 != 7) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c4, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c6, code lost:
    
        r18.k = r3;
        r18.f4040a = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00cc, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00cd, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int t() {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.t():int");
    }

    private boolean a(char c) throws IOException {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                return false;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                w();
                return false;
            default:
                return true;
        }
    }

    public String g() throws IOException {
        String strB;
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 14) {
            strB = u();
        } else if (iR == 12) {
            strB = b('\'');
        } else if (iR == 13) {
            strB = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + s());
        }
        this.f4040a = 0;
        this.o[this.n - 1] = strB;
        return strB;
    }

    public String h() throws IOException {
        String str;
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 10) {
            str = u();
        } else if (iR == 8) {
            str = b('\'');
        } else if (iR == 9) {
            str = b('\"');
        } else if (iR == 11) {
            str = this.l;
            this.l = null;
        } else if (iR == 15) {
            str = Long.toString(this.j);
        } else if (iR == 16) {
            str = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + s());
        }
        this.f4040a = 0;
        int[] iArr = this.p;
        int i = this.n - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 5) {
            this.f4040a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iR == 6) {
            this.f4040a = 0;
            int[] iArr2 = this.p;
            int i2 = this.n - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + f() + s());
    }

    public void j() throws IOException {
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 7) {
            this.f4040a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + s());
    }

    public double k() throws IOException, NumberFormatException {
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 15) {
            this.f4040a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return this.j;
        }
        if (iR == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else if (iR == 8 || iR == 9) {
            this.l = b(iR == 8 ? '\'' : '\"');
        } else if (iR == 10) {
            this.l = u();
        } else if (iR != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + s());
        }
        this.f4040a = 11;
        double d = Double.parseDouble(this.l);
        if (!this.d && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + s());
        }
        this.l = null;
        this.f4040a = 0;
        int[] iArr2 = this.p;
        int i2 = this.n - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }

    public long l() throws IOException, NumberFormatException {
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 15) {
            this.f4040a = 0;
            int[] iArr = this.p;
            int i = this.n - 1;
            iArr[i] = iArr[i] + 1;
            return this.j;
        }
        if (iR == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else if (iR == 8 || iR == 9 || iR == 10) {
            if (iR == 10) {
                this.l = u();
            } else {
                this.l = b(iR == 8 ? '\'' : '\"');
            }
            try {
                long j = Long.parseLong(this.l);
                this.f4040a = 0;
                int[] iArr2 = this.p;
                int i2 = this.n - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + f() + s());
        }
        this.f4040a = 11;
        double d = Double.parseDouble(this.l);
        long j2 = (long) d;
        if (j2 != d) {
            throw new NumberFormatException("Expected a long but was " + this.l + s());
        }
        this.l = null;
        this.f4040a = 0;
        int[] iArr3 = this.p;
        int i3 = this.n - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r4) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        r1.append(r0, r4, r2 - r4);
        r9.f = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.e
            r1 = 0
        L3:
            int r2 = r9.f
            int r3 = r9.g
        L7:
            r4 = r2
        L8:
            r5 = 16
            r6 = 1
            if (r2 >= r3) goto L5b
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L27
            r9.f = r7
            int r7 = r7 - r4
            int r7 = r7 - r6
            if (r1 != 0) goto L1f
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r4, r7)
            return r10
        L1f:
            r1.append(r0, r4, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L27:
            r8 = 92
            if (r2 != r8) goto L4e
            r9.f = r7
            int r7 = r7 - r4
            int r7 = r7 - r6
            if (r1 != 0) goto L3f
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L3f:
            r1.append(r0, r4, r7)
            char r2 = r9.y()
            r1.append(r2)
            int r2 = r9.f
            int r3 = r9.g
            goto L7
        L4e:
            r5 = 10
            if (r2 != r5) goto L59
            int r2 = r9.h
            int r2 = r2 + r6
            r9.h = r2
            r9.i = r7
        L59:
            r2 = r7
            goto L8
        L5b:
            if (r1 != 0) goto L6b
            int r1 = r2 - r4
            int r1 = r1 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r3.<init>(r1)
            r1 = r3
        L6b:
            int r3 = r2 - r4
            r1.append(r0, r4, r3)
            r9.f = r2
            boolean r2 = r9.b(r6)
            if (r2 == 0) goto L79
            goto L3
        L79:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.b(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.b(char):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0012. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String u() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            r2 = r1
        L3:
            r1 = 0
        L4:
            int r3 = r5.f
            int r3 = r3 + r1
            int r4 = r5.g
            if (r3 >= r4) goto L1c
            char[] r3 = r5.e
            int r4 = r5.f
            int r4 = r4 + r1
            char r3 = r3[r4]
            switch(r3) {
                case 9: goto L2a;
                case 10: goto L2a;
                case 12: goto L2a;
                case 13: goto L2a;
                case 32: goto L2a;
                case 35: goto L18;
                case 44: goto L2a;
                case 47: goto L18;
                case 58: goto L2a;
                case 59: goto L18;
                case 61: goto L18;
                case 91: goto L2a;
                case 92: goto L18;
                case 93: goto L2a;
                case 123: goto L2a;
                case 125: goto L2a;
                default: goto L15;
            }
        L15:
            int r1 = r1 + 1
            goto L4
        L18:
            r5.w()
            goto L2a
        L1c:
            char[] r3 = r5.e
            int r3 = r3.length
            if (r1 >= r3) goto L2c
            int r3 = r1 + 1
            boolean r3 = r5.b(r3)
            if (r3 == 0) goto L2a
            goto L4
        L2a:
            r0 = r1
            goto L4c
        L2c:
            if (r2 != 0) goto L39
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r1, r3)
            r2.<init>(r3)
        L39:
            char[] r3 = r5.e
            int r4 = r5.f
            r2.append(r3, r4, r1)
            int r3 = r5.f
            int r3 = r3 + r1
            r5.f = r3
            r1 = 1
            boolean r1 = r5.b(r1)
            if (r1 != 0) goto L3
        L4c:
            if (r2 != 0) goto L58
            java.lang.String r1 = new java.lang.String
            char[] r2 = r5.e
            int r3 = r5.f
            r1.<init>(r2, r3, r0)
            goto L63
        L58:
            char[] r1 = r5.e
            int r3 = r5.f
            r2.append(r1, r3, r0)
            java.lang.String r1 = r2.toString()
        L63:
            int r2 = r5.f
            int r2 = r2 + r0
            r5.f = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.u():java.lang.String");
    }

    private void c(char c) throws IOException {
        char[] cArr = this.e;
        do {
            int i = this.f;
            int i2 = this.g;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.f = i3;
                    return;
                }
                if (c2 == '\\') {
                    this.f = i3;
                    y();
                    i = this.f;
                    i2 = this.g;
                } else {
                    if (c2 == '\n') {
                        this.h++;
                        this.i = i3;
                    }
                    i = i3;
                }
            }
            this.f = i;
        } while (b(1));
        throw b("Unterminated string");
    }

    private void v() throws IOException {
        do {
            int i = 0;
            while (this.f + i < this.g) {
                switch (this.e[this.f + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        w();
                        break;
                    default:
                        i++;
                }
                this.f += i;
                return;
            }
            this.f += i;
        } while (b(1));
    }

    public int m() throws IOException, NumberFormatException {
        int iR = this.f4040a;
        if (iR == 0) {
            iR = r();
        }
        if (iR == 15) {
            int i = (int) this.j;
            if (this.j != i) {
                throw new NumberFormatException("Expected an int but was " + this.j + s());
            }
            this.f4040a = 0;
            int[] iArr = this.p;
            int i2 = this.n - 1;
            iArr[i2] = iArr[i2] + 1;
            return i;
        }
        if (iR == 16) {
            this.l = new String(this.e, this.f, this.k);
            this.f += this.k;
        } else if (iR == 8 || iR == 9 || iR == 10) {
            if (iR == 10) {
                this.l = u();
            } else {
                this.l = b(iR == 8 ? '\'' : '\"');
            }
            try {
                int i3 = Integer.parseInt(this.l);
                this.f4040a = 0;
                int[] iArr2 = this.p;
                int i4 = this.n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + f() + s());
        }
        this.f4040a = 11;
        double d = Double.parseDouble(this.l);
        int i5 = (int) d;
        if (i5 != d) {
            throw new NumberFormatException("Expected an int but was " + this.l + s());
        }
        this.l = null;
        this.f4040a = 0;
        int[] iArr3 = this.p;
        int i6 = this.n - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4040a = 0;
        this.m[0] = 8;
        this.n = 1;
        this.c.close();
    }

    public void n() throws IOException {
        int i = 0;
        do {
            int iR = this.f4040a;
            if (iR == 0) {
                iR = r();
            }
            if (iR == 3) {
                a(1);
                i++;
            } else if (iR == 1) {
                a(3);
                i++;
            } else if (iR == 4 || iR == 2) {
                this.n--;
                i--;
            } else if (iR == 14 || iR == 10) {
                v();
            } else if (iR == 8 || iR == 12) {
                c('\'');
            } else if (iR == 9 || iR == 13) {
                c('\"');
            } else if (iR == 16) {
                this.f += this.k;
            }
            this.f4040a = 0;
        } while (i != 0);
        int[] iArr = this.p;
        int i2 = this.n - 1;
        iArr[i2] = iArr[i2] + 1;
        this.o[this.n - 1] = "null";
    }

    private void a(int i) {
        if (this.n == this.m.length) {
            int[] iArr = new int[this.n * 2];
            int[] iArr2 = new int[this.n * 2];
            String[] strArr = new String[this.n * 2];
            System.arraycopy(this.m, 0, iArr, 0, this.n);
            System.arraycopy(this.p, 0, iArr2, 0, this.n);
            System.arraycopy(this.o, 0, strArr, 0, this.n);
            this.m = iArr;
            this.p = iArr2;
            this.o = strArr;
        }
        int[] iArr3 = this.m;
        int i2 = this.n;
        this.n = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean b(int i) throws IOException {
        char[] cArr = this.e;
        this.i -= this.f;
        if (this.g != this.f) {
            this.g -= this.f;
            System.arraycopy(cArr, this.f, cArr, 0, this.g);
        } else {
            this.g = 0;
        }
        this.f = 0;
        do {
            int i2 = this.c.read(cArr, this.g, cArr.length - this.g);
            if (i2 == -1) {
                return false;
            }
            this.g += i2;
            if (this.h == 0 && this.i == 0 && this.g > 0 && cArr[0] == 65279) {
                this.f++;
                this.i++;
                i++;
            }
        } while (this.g < i);
        return true;
    }

    private int b(boolean z) throws IOException {
        char[] cArr = this.e;
        int i = this.f;
        int i2 = this.g;
        while (true) {
            if (i == i2) {
                this.f = i;
                if (!b(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + s());
                }
                i = this.f;
                i2 = this.g;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.h++;
                this.i = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.f = i3;
                    if (i3 == i2) {
                        this.f--;
                        boolean zB = b(2);
                        this.f++;
                        if (!zB) {
                            return c;
                        }
                    }
                    w();
                    char c2 = cArr[this.f];
                    if (c2 == '*') {
                        this.f++;
                        if (!a("*/")) {
                            throw b("Unterminated comment");
                        }
                        i = this.f + 2;
                        i2 = this.g;
                    } else {
                        if (c2 != '/') {
                            return c;
                        }
                        this.f++;
                        x();
                        i = this.f;
                        i2 = this.g;
                    }
                } else if (c == '#') {
                    this.f = i3;
                    w();
                    x();
                    i = this.f;
                    i2 = this.g;
                } else {
                    this.f = i3;
                    return c;
                }
            }
            i = i3;
        }
    }

    private void w() throws IOException {
        if (!this.d) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void x() {
        char c;
        do {
            if (this.f >= this.g && !b(1)) {
                return;
            }
            char[] cArr = this.e;
            int i = this.f;
            this.f = i + 1;
            c = cArr[i];
            if (c == '\n') {
                this.h++;
                this.i = this.f;
                return;
            }
        } while (c != '\r');
    }

    private boolean a(String str) {
        int length = str.length();
        while (true) {
            if (this.f + length > this.g && !b(length)) {
                return false;
            }
            if (this.e[this.f] != '\n') {
                for (int i = 0; i < length; i++) {
                    if (this.e[this.f + i] != str.charAt(i)) {
                        break;
                    }
                }
                return true;
            }
            this.h++;
            this.i = this.f + 1;
            this.f++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + s();
    }

    String s() {
        return " at line " + (this.h + 1) + " column " + ((this.f - this.i) + 1) + " path " + p();
    }

    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = this.n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.m[i2]) {
                case 1:
                case 2:
                    sb.append('[');
                    sb.append(this.p[i2]);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    if (this.o[i2] != null) {
                        sb.append(this.o[i2]);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return sb.toString();
    }

    private char y() throws IOException {
        int i;
        if (this.f == this.g && !b(1)) {
            throw b("Unterminated escape sequence");
        }
        char[] cArr = this.e;
        int i2 = this.f;
        this.f = i2 + 1;
        char c = cArr[i2];
        if (c == '\n') {
            this.h++;
            this.i = this.f;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c == 'b') {
                return '\b';
            }
            if (c == 'f') {
                return '\f';
            }
            if (c == 'n') {
                return '\n';
            }
            if (c == 'r') {
                return '\r';
            }
            switch (c) {
                case 't':
                    return '\t';
                case 'u':
                    if (this.f + 4 > this.g && !b(4)) {
                        throw b("Unterminated escape sequence");
                    }
                    char c2 = 0;
                    int i3 = this.f;
                    int i4 = i3 + 4;
                    while (i3 < i4) {
                        char c3 = this.e[i3];
                        char c4 = (char) (c2 << 4);
                        if (c3 >= '0' && c3 <= '9') {
                            i = c3 - '0';
                        } else if (c3 >= 'a' && c3 <= 'f') {
                            i = (c3 - 'a') + 10;
                        } else {
                            if (c3 < 'A' || c3 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.e, this.f, 4));
                            }
                            i = (c3 - 'A') + 10;
                        }
                        c2 = (char) (c4 + i);
                        i3++;
                    }
                    this.f += 4;
                    return c2;
                default:
                    throw b("Invalid escape sequence");
            }
        }
        return c;
    }

    private IOException b(String str) throws MalformedJsonException {
        throw new MalformedJsonException(str + s());
    }

    private void z() throws IOException {
        b(true);
        this.f--;
        if (this.f + f4039b.length <= this.g || b(f4039b.length)) {
            for (int i = 0; i < f4039b.length; i++) {
                if (this.e[this.f + i] != f4039b[i]) {
                    return;
                }
            }
            this.f += f4039b.length;
        }
    }
}
