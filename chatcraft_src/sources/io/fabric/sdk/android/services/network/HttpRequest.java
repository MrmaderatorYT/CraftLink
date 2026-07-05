package io.fabric.sdk.android.services.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public class HttpRequest {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f4324b = new String[0];
    private static b c = b.f4330a;

    /* renamed from: a, reason: collision with root package name */
    public final URL f4325a;
    private final String e;
    private d f;
    private boolean g;
    private String k;
    private int l;
    private HttpURLConnection d = null;
    private boolean h = true;
    private boolean i = false;
    private int j = 8192;

    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f4330a = new b() { // from class: io.fabric.sdk.android.services.network.HttpRequest.b.1
            @Override // io.fabric.sdk.android.services.network.HttpRequest.b
            public HttpURLConnection a(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            @Override // io.fabric.sdk.android.services.network.HttpRequest.b
            public HttpURLConnection a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        };

        HttpURLConnection a(URL url);

        HttpURLConnection a(URL url, Proxy proxy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private static StringBuilder a(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        return sb;
    }

    private static StringBuilder b(String str, StringBuilder sb) {
        int iIndexOf = str.indexOf(63);
        int length = sb.length() - 1;
        if (iIndexOf == -1) {
            sb.append('?');
        } else if (iIndexOf < length && str.charAt(length) != '&') {
            sb.append('&');
        }
        return sb;
    }

    public static class HttpRequestException extends RuntimeException {
        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    protected static abstract class c<V> implements Callable<V> {
        protected abstract V b();

        protected abstract void c();

        protected c() {
        }

        @Override // java.util.concurrent.Callable
        public V call() throws Throwable {
            Throwable th;
            boolean z = true;
            try {
                try {
                    V vB = b();
                    try {
                        c();
                        return vB;
                    } catch (IOException e) {
                        throw new HttpRequestException(e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        c();
                    } catch (IOException e2) {
                        if (!z) {
                            throw new HttpRequestException(e2);
                        }
                    }
                    throw th;
                }
            } catch (HttpRequestException e3) {
                throw e3;
            } catch (IOException e4) {
                throw new HttpRequestException(e4);
            } catch (Throwable th3) {
                th = th3;
                z = false;
                c();
                throw th;
            }
        }
    }

    protected static abstract class a<V> extends c<V> {

        /* renamed from: a, reason: collision with root package name */
        private final Closeable f4328a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f4329b;

        protected a(Closeable closeable, boolean z) {
            this.f4328a = closeable;
            this.f4329b = z;
        }

        @Override // io.fabric.sdk.android.services.network.HttpRequest.c
        protected void c() throws IOException {
            if (this.f4328a instanceof Flushable) {
                ((Flushable) this.f4328a).flush();
            }
            if (this.f4329b) {
                try {
                    this.f4328a.close();
                } catch (IOException unused) {
                }
            } else {
                this.f4328a.close();
            }
        }
    }

    public static class d extends BufferedOutputStream {

        /* renamed from: a, reason: collision with root package name */
        private final CharsetEncoder f4331a;

        public d(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f4331a = Charset.forName(HttpRequest.f(str)).newEncoder();
        }

        public d a(String str) throws IOException {
            ByteBuffer byteBufferEncode = this.f4331a.encode(CharBuffer.wrap(str));
            super.write(byteBufferEncode.array(), 0, byteBufferEncode.limit());
            return this;
        }
    }

    public static String a(CharSequence charSequence) {
        int i;
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
                int iIndexOf = aSCIIString.indexOf(63);
                if (iIndexOf <= 0 || (i = iIndexOf + 1) >= aSCIIString.length()) {
                    return aSCIIString;
                }
                return aSCIIString.substring(0, i) + aSCIIString.substring(i).replace("+", "%2B").replace("#", "%23");
            } catch (URISyntaxException e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static String a(CharSequence charSequence, Map<?, ?> map) {
        String string = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return string;
        }
        StringBuilder sb = new StringBuilder(string);
        a(string, sb);
        b(string, sb);
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        Map.Entry<?, ?> next = it.next();
        sb.append(next.getKey().toString());
        sb.append('=');
        Object value = next.getValue();
        if (value != null) {
            sb.append(value);
        }
        while (it.hasNext()) {
            sb.append('&');
            Map.Entry<?, ?> next2 = it.next();
            sb.append(next2.getKey().toString());
            sb.append('=');
            Object value2 = next2.getValue();
            if (value2 != null) {
                sb.append(value2);
            }
        }
        return sb.toString();
    }

    public static HttpRequest b(CharSequence charSequence) {
        return new HttpRequest(charSequence, "GET");
    }

    public static HttpRequest a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String strA = a(charSequence, map);
        if (z) {
            strA = a((CharSequence) strA);
        }
        return b((CharSequence) strA);
    }

    public static HttpRequest c(CharSequence charSequence) {
        return new HttpRequest(charSequence, "POST");
    }

    public static HttpRequest b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String strA = a(charSequence, map);
        if (z) {
            strA = a((CharSequence) strA);
        }
        return c((CharSequence) strA);
    }

    public static HttpRequest d(CharSequence charSequence) {
        return new HttpRequest(charSequence, "PUT");
    }

    public static HttpRequest e(CharSequence charSequence) {
        return new HttpRequest(charSequence, "DELETE");
    }

    public HttpRequest(CharSequence charSequence, String str) {
        try {
            this.f4325a = new URL(charSequence.toString());
            this.e = str;
        } catch (MalformedURLException e) {
            throw new HttpRequestException(e);
        }
    }

    private Proxy p() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.k, this.l));
    }

    private HttpURLConnection q() throws ProtocolException {
        HttpURLConnection httpURLConnectionA;
        try {
            if (this.k != null) {
                httpURLConnectionA = c.a(this.f4325a, p());
            } else {
                httpURLConnectionA = c.a(this.f4325a);
            }
            httpURLConnectionA.setRequestMethod(this.e);
            return httpURLConnectionA;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String toString() {
        return o() + ' ' + n();
    }

    public HttpURLConnection a() {
        if (this.d == null) {
            this.d = q();
        }
        return this.d;
    }

    public int b() {
        try {
            j();
            return a().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected ByteArrayOutputStream c() {
        int i = i();
        if (i > 0) {
            return new ByteArrayOutputStream(i);
        }
        return new ByteArrayOutputStream();
    }

    public String a(String str) {
        ByteArrayOutputStream byteArrayOutputStreamC = c();
        try {
            a(e(), byteArrayOutputStreamC);
            return byteArrayOutputStreamC.toString(f(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String d() {
        return a(g());
    }

    public BufferedInputStream e() {
        return new BufferedInputStream(f(), this.j);
    }

    public InputStream f() {
        InputStream inputStream;
        if (b() < 400) {
            try {
                inputStream = a().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        } else {
            inputStream = a().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = a().getInputStream();
                } catch (IOException e2) {
                    throw new HttpRequestException(e2);
                }
            }
        }
        if (!this.i || !"gzip".equals(h())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e3) {
            throw new HttpRequestException(e3);
        }
    }

    public HttpRequest a(int i) {
        a().setConnectTimeout(i);
        return this;
    }

    public HttpRequest a(String str, String str2) {
        a().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest a(Map.Entry<String, String> entry) {
        return a(entry.getKey(), entry.getValue());
    }

    public String b(String str) {
        k();
        return a().getHeaderField(str);
    }

    public int c(String str) {
        return a(str, -1);
    }

    public int a(String str, int i) {
        k();
        return a().getHeaderFieldInt(str, i);
    }

    public String b(String str, String str2) {
        return c(b(str), str2);
    }

    protected String c(String str, String str2) {
        String strTrim;
        int length;
        if (str == null || str.length() == 0) {
            return null;
        }
        int length2 = str.length();
        int iIndexOf = str.indexOf(59) + 1;
        if (iIndexOf == 0 || iIndexOf == length2) {
            return null;
        }
        int iIndexOf2 = str.indexOf(59, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = length2;
        }
        while (iIndexOf < iIndexOf2) {
            int iIndexOf3 = str.indexOf(61, iIndexOf);
            if (iIndexOf3 != -1 && iIndexOf3 < iIndexOf2 && str2.equals(str.substring(iIndexOf, iIndexOf3).trim()) && (length = (strTrim = str.substring(iIndexOf3 + 1, iIndexOf2).trim()).length()) != 0) {
                if (length > 2 && '\"' == strTrim.charAt(0)) {
                    int i = length - 1;
                    if ('\"' == strTrim.charAt(i)) {
                        return strTrim.substring(1, i);
                    }
                }
                return strTrim;
            }
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(59, iIndexOf);
            if (iIndexOf2 == -1) {
                iIndexOf2 = length2;
            }
        }
        return null;
    }

    public String g() {
        return b("Content-Type", "charset");
    }

    public HttpRequest a(boolean z) {
        a().setUseCaches(z);
        return this;
    }

    public String h() {
        return b("Content-Encoding");
    }

    public HttpRequest d(String str) {
        return d(str, null);
    }

    public HttpRequest d(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            return a("Content-Type", str + "; charset=" + str2);
        }
        return a("Content-Type", str);
    }

    public int i() {
        return c("Content-Length");
    }

    protected HttpRequest a(final InputStream inputStream, final OutputStream outputStream) {
        return new a<HttpRequest>(inputStream, this.h) { // from class: io.fabric.sdk.android.services.network.HttpRequest.1
            @Override // io.fabric.sdk.android.services.network.HttpRequest.c
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public HttpRequest b() throws IOException {
                byte[] bArr = new byte[HttpRequest.this.j];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                    } else {
                        return HttpRequest.this;
                    }
                }
            }
        }.call();
    }

    protected HttpRequest j() throws IOException {
        if (this.f == null) {
            return this;
        }
        if (this.g) {
            this.f.a("\r\n--00content0boundary00--\r\n");
        }
        if (this.h) {
            try {
                this.f.close();
            } catch (IOException unused) {
            }
        } else {
            this.f.close();
        }
        this.f = null;
        return this;
    }

    protected HttpRequest k() {
        try {
            return j();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest l() {
        if (this.f != null) {
            return this;
        }
        a().setDoOutput(true);
        this.f = new d(a().getOutputStream(), c(a().getRequestProperty("Content-Type"), "charset"), this.j);
        return this;
    }

    protected HttpRequest m() throws IOException {
        if (!this.g) {
            this.g = true;
            d("multipart/form-data; boundary=00content0boundary00").l();
            this.f.a("--00content0boundary00\r\n");
        } else {
            this.f.a("\r\n--00content0boundary00\r\n");
        }
        return this;
    }

    protected HttpRequest a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"");
            sb.append(str2);
        }
        sb.append('\"');
        f("Content-Disposition", sb.toString());
        if (str3 != null) {
            f("Content-Type", str3);
        }
        return f("\r\n");
    }

    public HttpRequest e(String str, String str2) {
        return b(str, (String) null, str2);
    }

    public HttpRequest b(String str, String str2, String str3) {
        return a(str, str2, (String) null, str3);
    }

    public HttpRequest a(String str, String str2, String str3, String str4) {
        try {
            m();
            a(str, str2, str3);
            this.f.a(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest a(String str, Number number) {
        return a(str, (String) null, number);
    }

    public HttpRequest a(String str, String str2, Number number) {
        return b(str, str2, number != null ? number.toString() : null);
    }

    public HttpRequest a(String str, String str2, String str3, File file) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            HttpRequest httpRequestA = a(str, str2, str3, bufferedInputStream);
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
            }
            return httpRequestA;
        } catch (IOException e2) {
            e = e2;
            throw new HttpRequestException(e);
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public HttpRequest a(String str, String str2, String str3, InputStream inputStream) {
        try {
            m();
            a(str, str2, str3);
            a(inputStream, this.f);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest f(String str, String str2) {
        return f((CharSequence) str).f(": ").f((CharSequence) str2).f("\r\n");
    }

    public HttpRequest f(CharSequence charSequence) {
        try {
            l();
            this.f.a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public URL n() {
        return a().getURL();
    }

    public String o() {
        return a().getRequestMethod();
    }
}
