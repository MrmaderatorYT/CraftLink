package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class bjg implements bja {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f2731a = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicReference<byte[]> f2732b = new AtomicReference<>();
    private final boolean c;
    private final int d;
    private final int e;
    private final String f;
    private final bkb<String> g;
    private final bjh h;
    private final bjh i;
    private final bjp<? super bjg> j;
    private bjd k;
    private HttpURLConnection l;
    private InputStream m;
    private boolean n;
    private long o;
    private long p;
    private long q;
    private long r;

    public bjg(String str, bkb<String> bkbVar, bjp<? super bjg> bjpVar, int i, int i2, boolean z, bjh bjhVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.f = str;
        this.g = null;
        this.j = bjpVar;
        this.i = new bjh();
        this.d = i;
        this.e = i2;
        this.c = true;
        this.h = null;
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final Uri b() {
        if (this.l == null) {
            return null;
        }
        return Uri.parse(this.l.getURL().toString());
    }

    public final Map<String, List<String>> c() {
        if (this.l == null) {
            return null;
        }
        return this.l.getHeaderFields();
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final long a(bjd bjdVar) throws IOException, NumberFormatException {
        HttpURLConnection httpURLConnectionA;
        HttpURLConnection httpURLConnectionA2;
        this.k = bjdVar;
        long j = 0;
        this.r = 0L;
        this.q = 0L;
        try {
            URL url = new URL(bjdVar.f2725a.toString());
            byte[] bArr = bjdVar.f2726b;
            long j2 = bjdVar.d;
            long j3 = bjdVar.e;
            boolean zA = bjdVar.a(1);
            if (this.c) {
                URL url2 = url;
                byte[] bArr2 = bArr;
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        URL url3 = url2;
                        long j4 = j3;
                        long j5 = j2;
                        httpURLConnectionA = a(url2, bArr2, j2, j3, zA, false);
                        int responseCode = httpURLConnectionA.getResponseCode();
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr2 != null || (responseCode != 307 && responseCode != 308))) {
                            break;
                        }
                        bArr2 = null;
                        String headerField = httpURLConnectionA.getHeaderField("Location");
                        httpURLConnectionA.disconnect();
                        if (headerField == null) {
                            throw new ProtocolException("Null location redirect");
                        }
                        url2 = new URL(url3, headerField);
                        String protocol = url2.getProtocol();
                        if (!"https".equals(protocol) && !"http".equals(protocol)) {
                            String strValueOf = String.valueOf(protocol);
                            throw new ProtocolException(strValueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(strValueOf) : new String("Unsupported protocol redirect: "));
                        }
                        i = i2;
                        j3 = j4;
                        j2 = j5;
                    } else {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("Too many redirects: ");
                        sb.append(i2);
                        throw new NoRouteToHostException(sb.toString());
                    }
                }
                httpURLConnectionA2 = httpURLConnectionA;
            } else {
                httpURLConnectionA2 = a(url, bArr, j2, j3, zA, true);
            }
            this.l = httpURLConnectionA2;
            try {
                int responseCode2 = this.l.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map<String, List<String>> headerFields = this.l.getHeaderFields();
                    d();
                    zzpd zzpdVar = new zzpd(responseCode2, headerFields, bjdVar);
                    if (responseCode2 == 416) {
                        zzpdVar.initCause(new zzox(0));
                        throw zzpdVar;
                    }
                    throw zzpdVar;
                }
                this.l.getContentType();
                if (responseCode2 == 200 && bjdVar.d != 0) {
                    j = bjdVar.d;
                }
                this.o = j;
                if (bjdVar.a(1)) {
                    this.p = bjdVar.e;
                } else {
                    if (bjdVar.e != -1) {
                        this.p = bjdVar.e;
                    } else {
                        long jA = a(this.l);
                        this.p = jA != -1 ? jA - this.o : -1L;
                    }
                }
                try {
                    this.m = this.l.getInputStream();
                    this.n = true;
                    if (this.j != null) {
                        this.j.a((bjp<? super bjg>) this, bjdVar);
                    }
                    return this.p;
                } catch (IOException e) {
                    d();
                    throw new zzpc(e, bjdVar, 1);
                }
            } catch (IOException e2) {
                d();
                String strValueOf2 = String.valueOf(bjdVar.f2725a.toString());
                throw new zzpc(strValueOf2.length() != 0 ? "Unable to connect to ".concat(strValueOf2) : new String("Unable to connect to "), e2, bjdVar, 1);
            }
        } catch (IOException e3) {
            String strValueOf3 = String.valueOf(bjdVar.f2725a.toString());
            throw new zzpc(strValueOf3.length() != 0 ? "Unable to connect to ".concat(strValueOf3) : new String("Unable to connect to "), e3, bjdVar, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        try {
            if (this.q != this.o) {
                byte[] andSet = f2732b.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.q != this.o) {
                    int i3 = this.m.read(andSet, 0, (int) Math.min(this.o - this.q, andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i3 == -1) {
                        throw new EOFException();
                    }
                    this.q += i3;
                    if (this.j != null) {
                        this.j.a((bjp<? super bjg>) this, i3);
                    }
                }
                f2732b.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.p != -1) {
                long j = this.p - this.r;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j);
            }
            int i4 = this.m.read(bArr, i, i2);
            if (i4 == -1) {
                if (this.p == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.r += i4;
            if (this.j != null) {
                this.j.a((bjp<? super bjg>) this, i4);
            }
            return i4;
        } catch (IOException e) {
            throw new zzpc(e, this.k, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003b A[Catch: Exception -> 0x006c, all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x0010, B:9:0x0019, B:11:0x001f, B:26:0x006c, B:29:0x0073, B:30:0x007b, B:14:0x0025, B:16:0x002d, B:21:0x003b, B:23:0x004b, B:25:0x0053, B:8:0x0013), top: B:46:0x0002, inners: #2 }] */
    @Override // com.google.android.gms.internal.ads.bja
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r10.m     // Catch: java.lang.Throwable -> L92
            if (r2 == 0) goto L7c
            java.net.HttpURLConnection r2 = r10.l     // Catch: java.lang.Throwable -> L92
            long r3 = r10.p     // Catch: java.lang.Throwable -> L92
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L13
            long r3 = r10.p     // Catch: java.lang.Throwable -> L92
            goto L19
        L13:
            long r3 = r10.p     // Catch: java.lang.Throwable -> L92
            long r7 = r10.r     // Catch: java.lang.Throwable -> L92
            r9 = 0
            long r3 = r3 - r7
        L19:
            int r7 = com.google.android.gms.internal.ads.bkg.f2760a     // Catch: java.lang.Throwable -> L92
            r8 = 19
            if (r7 == r8) goto L25
            int r7 = com.google.android.gms.internal.ads.bkg.f2760a     // Catch: java.lang.Throwable -> L92
            r8 = 20
            if (r7 != r8) goto L6c
        L25:
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L35
            int r3 = r2.read()     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            r4 = -1
            if (r3 != r4) goto L3b
            goto L6c
        L35:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L6c
        L3b:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            if (r4 != 0) goto L53
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            if (r3 == 0) goto L6c
        L53:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L6c java.lang.Throwable -> L92
        L6c:
            java.io.InputStream r2 = r10.m     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L92
            r2.close()     // Catch: java.io.IOException -> L72 java.lang.Throwable -> L92
            goto L7c
        L72:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzpc r3 = new com.google.android.gms.internal.ads.zzpc     // Catch: java.lang.Throwable -> L92
            com.google.android.gms.internal.ads.bjd r4 = r10.k     // Catch: java.lang.Throwable -> L92
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L92
            throw r3     // Catch: java.lang.Throwable -> L92
        L7c:
            r10.m = r0
            r10.d()
            boolean r0 = r10.n
            if (r0 == 0) goto L91
            r10.n = r1
            com.google.android.gms.internal.ads.bjp<? super com.google.android.gms.internal.ads.bjg> r0 = r10.j
            if (r0 == 0) goto L91
            com.google.android.gms.internal.ads.bjp<? super com.google.android.gms.internal.ads.bjg> r0 = r10.j
            r0.a(r10)
            return
        L91:
            return
        L92:
            r2 = move-exception
            r10.m = r0
            r10.d()
            boolean r0 = r10.n
            if (r0 == 0) goto La7
            r10.n = r1
            com.google.android.gms.internal.ads.bjp<? super com.google.android.gms.internal.ads.bjg> r0 = r10.j
            if (r0 == 0) goto La7
            com.google.android.gms.internal.ads.bjp<? super com.google.android.gms.internal.ads.bjg> r0 = r10.j
            r0.a(r10)
        La7:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bjg.a():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.net.HttpURLConnection a(java.net.URL r6, byte[] r7, long r8, long r10, boolean r12, boolean r13) throws java.io.IOException {
        /*
            r5 = this;
            java.net.URLConnection r6 = r6.openConnection()
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6
            int r0 = r5.d
            r6.setConnectTimeout(r0)
            int r0 = r5.e
            r6.setReadTimeout(r0)
            com.google.android.gms.internal.ads.bjh r0 = r5.i
            java.util.Map r0 = r0.a()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L1e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r6.setRequestProperty(r2, r1)
            goto L1e
        L3a:
            r0 = 0
            r2 = -1
            int r4 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r4 != 0) goto L46
            int r0 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r0 == 0) goto L88
        L46:
            r0 = 27
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "bytes="
            r1.append(r0)
            r1.append(r8)
            java.lang.String r0 = "-"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            int r1 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r1 == 0) goto L83
            java.lang.String r0 = java.lang.String.valueOf(r0)
            long r8 = r8 + r10
            r10 = 1
            long r8 = r8 - r10
            java.lang.String r10 = java.lang.String.valueOf(r0)
            int r10 = r10.length()
            int r10 = r10 + 20
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r10)
            r11.append(r0)
            r11.append(r8)
            java.lang.String r0 = r11.toString()
        L83:
            java.lang.String r8 = "Range"
            r6.setRequestProperty(r8, r0)
        L88:
            java.lang.String r8 = "User-Agent"
            java.lang.String r9 = r5.f
            r6.setRequestProperty(r8, r9)
            if (r12 != 0) goto L98
            java.lang.String r8 = "Accept-Encoding"
            java.lang.String r9 = "identity"
            r6.setRequestProperty(r8, r9)
        L98:
            r6.setInstanceFollowRedirects(r13)
            if (r7 == 0) goto L9f
            r8 = 1
            goto La0
        L9f:
            r8 = 0
        La0:
            r6.setDoOutput(r8)
            if (r7 == 0) goto Lbf
            java.lang.String r8 = "POST"
            r6.setRequestMethod(r8)
            int r8 = r7.length
            if (r8 == 0) goto Lbf
            int r8 = r7.length
            r6.setFixedLengthStreamingMode(r8)
            r6.connect()
            java.io.OutputStream r8 = r6.getOutputStream()
            r8.write(r7)
            r8.close()
            goto Lc2
        Lbf:
            r6.connect()
        Lc2:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bjg.a(java.net.URL, byte[], long, long, boolean, boolean):java.net.HttpURLConnection");
    }

    private static long a(HttpURLConnection httpURLConnection) throws NumberFormatException {
        long j;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (TextUtils.isEmpty(headerField)) {
            j = -1;
        } else {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(headerField).length() + 28);
                sb.append("Unexpected Content-Length [");
                sb.append(headerField);
                sb.append("]");
                Log.e("DefaultHttpDataSource", sb.toString());
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = f2731a.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long j2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return j2;
            }
            if (j == j2) {
                return j;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(headerField).length() + 26 + String.valueOf(headerField2).length());
            sb2.append("Inconsistent headers [");
            sb2.append(headerField);
            sb2.append("] [");
            sb2.append(headerField2);
            sb2.append("]");
            Log.w("DefaultHttpDataSource", sb2.toString());
            return Math.max(j, j2);
        } catch (NumberFormatException unused2) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(headerField2).length() + 27);
            sb3.append("Unexpected Content-Range [");
            sb3.append(headerField2);
            sb3.append("]");
            Log.e("DefaultHttpDataSource", sb3.toString());
            return j;
        }
    }

    private final void d() {
        if (this.l != null) {
            try {
                this.l.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.l = null;
        }
    }
}
