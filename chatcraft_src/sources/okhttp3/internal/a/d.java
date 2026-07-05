package okhttp3.internal.a;

import b.l;
import b.r;
import b.s;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class d implements Closeable, Flushable {

    /* renamed from: b, reason: collision with root package name */
    final okhttp3.internal.d.a f5093b;
    final File c;
    final int d;
    b.d e;
    int g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    private final File n;
    private final File o;
    private final File p;
    private final int q;
    private long r;
    private final Executor u;
    static final /* synthetic */ boolean m = !d.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    static final Pattern f5092a = Pattern.compile("[a-z0-9_-]{1,120}");
    private long s = 0;
    final LinkedHashMap<String, b> f = new LinkedHashMap<>(0, 0.75f, true);
    private long t = 0;
    private final Runnable v = new Runnable() { // from class: okhttp3.internal.a.d.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this) {
                if ((!d.this.i) || d.this.j) {
                    return;
                }
                try {
                    d.this.e();
                } catch (IOException unused) {
                    d.this.k = true;
                }
                try {
                    if (d.this.c()) {
                        d.this.b();
                        d.this.g = 0;
                    }
                } catch (IOException unused2) {
                    d.this.l = true;
                    d.this.e = l.a(l.a());
                }
            }
        }
    };

    d(okhttp3.internal.d.a aVar, File file, int i, int i2, long j, Executor executor) {
        this.f5093b = aVar;
        this.c = file;
        this.q = i;
        this.n = new File(file, "journal");
        this.o = new File(file, "journal.tmp");
        this.p = new File(file, "journal.bkp");
        this.d = i2;
        this.r = j;
        this.u = executor;
    }

    public synchronized void a() {
        if (!m && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.i) {
            return;
        }
        if (this.f5093b.e(this.p)) {
            if (this.f5093b.e(this.n)) {
                this.f5093b.d(this.p);
            } else {
                this.f5093b.a(this.p, this.n);
            }
        }
        if (this.f5093b.e(this.n)) {
            try {
                g();
                i();
                this.i = true;
                return;
            } catch (IOException e) {
                okhttp3.internal.e.f.c().a(5, "DiskLruCache " + this.c + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    f();
                    this.j = false;
                } catch (Throwable th) {
                    this.j = false;
                    throw th;
                }
            }
        }
        b();
        this.i = true;
    }

    public static d a(okhttp3.internal.d.a aVar, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        return new d(aVar, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.c.a("OkHttp DiskLruCache", true)));
    }

    private void g() throws IOException {
        b.e eVarA = l.a(this.f5093b.a(this.n));
        try {
            String strQ = eVarA.q();
            String strQ2 = eVarA.q();
            String strQ3 = eVarA.q();
            String strQ4 = eVarA.q();
            String strQ5 = eVarA.q();
            if (!"libcore.io.DiskLruCache".equals(strQ) || !"1".equals(strQ2) || !Integer.toString(this.q).equals(strQ3) || !Integer.toString(this.d).equals(strQ4) || !BuildConfig.FLAVOR.equals(strQ5)) {
                throw new IOException("unexpected journal header: [" + strQ + ", " + strQ2 + ", " + strQ4 + ", " + strQ5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(eVarA.q());
                    i++;
                } catch (EOFException unused) {
                    this.g = i - this.f.size();
                    if (!eVarA.e()) {
                        b();
                    } else {
                        this.e = h();
                    }
                    okhttp3.internal.c.a(eVarA);
                    return;
                }
            }
        } catch (Throwable th) {
            okhttp3.internal.c.a(eVarA);
            throw th;
        }
    }

    private b.d h() {
        return l.a(new e(this.f5093b.c(this.n)) { // from class: okhttp3.internal.a.d.2

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ boolean f5095a = !d.class.desiredAssertionStatus();

            @Override // okhttp3.internal.a.e
            protected void a(IOException iOException) {
                if (!f5095a && !Thread.holdsLock(d.this)) {
                    throw new AssertionError();
                }
                d.this.h = true;
            }
        });
    }

    private void d(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.f.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.f.get(strSubstring);
        if (bVar == null) {
            bVar = new b(strSubstring);
            this.f.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            bVar.e = true;
            bVar.f = null;
            bVar.a(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            bVar.f = new a(bVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == "READ".length() && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void i() {
        this.f5093b.d(this.o);
        Iterator<b> it = this.f.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.d) {
                    this.s += next.f5101b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.d) {
                    this.f5093b.d(next.c[i]);
                    this.f5093b.d(next.d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    synchronized void b() {
        if (this.e != null) {
            this.e.close();
        }
        b.d dVarA = l.a(this.f5093b.b(this.o));
        try {
            dVarA.b("libcore.io.DiskLruCache").i(10);
            dVarA.b("1").i(10);
            dVarA.l(this.q).i(10);
            dVarA.l(this.d).i(10);
            dVarA.i(10);
            for (b bVar : this.f.values()) {
                if (bVar.f != null) {
                    dVarA.b("DIRTY").i(32);
                    dVarA.b(bVar.f5100a);
                    dVarA.i(10);
                } else {
                    dVarA.b("CLEAN").i(32);
                    dVarA.b(bVar.f5100a);
                    bVar.a(dVarA);
                    dVarA.i(10);
                }
            }
            dVarA.close();
            if (this.f5093b.e(this.n)) {
                this.f5093b.a(this.n, this.p);
            }
            this.f5093b.a(this.o, this.n);
            this.f5093b.d(this.p);
            this.e = h();
            this.h = false;
            this.l = false;
        } catch (Throwable th) {
            dVarA.close();
            throw th;
        }
    }

    public synchronized c a(String str) {
        a();
        j();
        e(str);
        b bVar = this.f.get(str);
        if (bVar != null && bVar.e) {
            c cVarA = bVar.a();
            if (cVarA == null) {
                return null;
            }
            this.g++;
            this.e.b("READ").i(32).b(str).i(10);
            if (c()) {
                this.u.execute(this.v);
            }
            return cVarA;
        }
        return null;
    }

    @Nullable
    public a b(String str) {
        return a(str, -1L);
    }

    synchronized a a(String str, long j) {
        a();
        j();
        e(str);
        b bVar = this.f.get(str);
        if (j != -1 && (bVar == null || bVar.g != j)) {
            return null;
        }
        if (bVar != null && bVar.f != null) {
            return null;
        }
        if (!this.k && !this.l) {
            this.e.b("DIRTY").i(32).b(str).i(10);
            this.e.flush();
            if (this.h) {
                return null;
            }
            if (bVar == null) {
                bVar = new b(str);
                this.f.put(str, bVar);
            }
            a aVar = new a(bVar);
            bVar.f = aVar;
            return aVar;
        }
        this.u.execute(this.v);
        return null;
    }

    synchronized void a(a aVar, boolean z) {
        b bVar = aVar.f5097a;
        if (bVar.f != aVar) {
            throw new IllegalStateException();
        }
        if (z && !bVar.e) {
            for (int i = 0; i < this.d; i++) {
                if (!aVar.f5098b[i]) {
                    aVar.c();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!this.f5093b.e(bVar.d[i])) {
                    aVar.c();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.d; i2++) {
            File file = bVar.d[i2];
            if (z) {
                if (this.f5093b.e(file)) {
                    File file2 = bVar.c[i2];
                    this.f5093b.a(file, file2);
                    long j = bVar.f5101b[i2];
                    long jF = this.f5093b.f(file2);
                    bVar.f5101b[i2] = jF;
                    this.s = (this.s - j) + jF;
                }
            } else {
                this.f5093b.d(file);
            }
        }
        this.g++;
        bVar.f = null;
        if (bVar.e | z) {
            bVar.e = true;
            this.e.b("CLEAN").i(32);
            this.e.b(bVar.f5100a);
            bVar.a(this.e);
            this.e.i(10);
            if (z) {
                long j2 = this.t;
                this.t = 1 + j2;
                bVar.g = j2;
            }
        } else {
            this.f.remove(bVar.f5100a);
            this.e.b("REMOVE").i(32);
            this.e.b(bVar.f5100a);
            this.e.i(10);
        }
        this.e.flush();
        if (this.s > this.r || c()) {
            this.u.execute(this.v);
        }
    }

    boolean c() {
        return this.g >= 2000 && this.g >= this.f.size();
    }

    public synchronized boolean c(String str) {
        a();
        j();
        e(str);
        b bVar = this.f.get(str);
        if (bVar == null) {
            return false;
        }
        boolean zA = a(bVar);
        if (zA && this.s <= this.r) {
            this.k = false;
        }
        return zA;
    }

    boolean a(b bVar) {
        if (bVar.f != null) {
            bVar.f.a();
        }
        for (int i = 0; i < this.d; i++) {
            this.f5093b.d(bVar.c[i]);
            this.s -= bVar.f5101b[i];
            bVar.f5101b[i] = 0;
        }
        this.g++;
        this.e.b("REMOVE").i(32).b(bVar.f5100a).i(10);
        this.f.remove(bVar.f5100a);
        if (c()) {
            this.u.execute(this.v);
        }
        return true;
    }

    public synchronized boolean d() {
        return this.j;
    }

    private synchronized void j() {
        if (d()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.i) {
            j();
            e();
            this.e.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.i && !this.j) {
            for (b bVar : (b[]) this.f.values().toArray(new b[this.f.size()])) {
                if (bVar.f != null) {
                    bVar.f.c();
                }
            }
            e();
            this.e.close();
            this.e = null;
            this.j = true;
            return;
        }
        this.j = true;
    }

    void e() {
        while (this.s > this.r) {
            a(this.f.values().iterator().next());
        }
        this.k = false;
    }

    public void f() {
        close();
        this.f5093b.g(this.c);
    }

    private void e(String str) {
        if (f5092a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    /* compiled from: DiskLruCache.java */
    public final class c implements Closeable {

        /* renamed from: b, reason: collision with root package name */
        private final String f5103b;
        private final long c;
        private final s[] d;
        private final long[] e;

        c(String str, long j, s[] sVarArr, long[] jArr) {
            this.f5103b = str;
            this.c = j;
            this.d = sVarArr;
            this.e = jArr;
        }

        @Nullable
        public a a() {
            return d.this.a(this.f5103b, this.c);
        }

        public s a(int i) {
            return this.d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            for (s sVar : this.d) {
                okhttp3.internal.c.a(sVar);
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        final b f5097a;

        /* renamed from: b, reason: collision with root package name */
        final boolean[] f5098b;
        private boolean d;

        a(b bVar) {
            this.f5097a = bVar;
            this.f5098b = bVar.e ? null : new boolean[d.this.d];
        }

        void a() {
            if (this.f5097a.f == this) {
                for (int i = 0; i < d.this.d; i++) {
                    try {
                        d.this.f5093b.d(this.f5097a.d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.f5097a.f = null;
            }
        }

        public r a(int i) {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f5097a.f != this) {
                    return l.a();
                }
                if (!this.f5097a.e) {
                    this.f5098b[i] = true;
                }
                try {
                    return new e(d.this.f5093b.b(this.f5097a.d[i])) { // from class: okhttp3.internal.a.d.a.1
                        @Override // okhttp3.internal.a.e
                        protected void a(IOException iOException) {
                            synchronized (d.this) {
                                a.this.a();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return l.a();
                }
            }
        }

        public void b() {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f5097a.f == this) {
                    d.this.a(this, true);
                }
                this.d = true;
            }
        }

        public void c() {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f5097a.f == this) {
                    d.this.a(this, false);
                }
                this.d = true;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    private final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f5100a;

        /* renamed from: b, reason: collision with root package name */
        final long[] f5101b;
        final File[] c;
        final File[] d;
        boolean e;
        a f;
        long g;

        b(String str) {
            this.f5100a = str;
            this.f5101b = new long[d.this.d];
            this.c = new File[d.this.d];
            this.d = new File[d.this.d];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < d.this.d; i++) {
                sb.append(i);
                this.c[i] = new File(d.this.c, sb.toString());
                sb.append(".tmp");
                this.d[i] = new File(d.this.c, sb.toString());
                sb.setLength(length);
            }
        }

        void a(String[] strArr) throws IOException {
            if (strArr.length != d.this.d) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f5101b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        void a(b.d dVar) {
            for (long j : this.f5101b) {
                dVar.i(32).l(j);
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        c a() throws IOException {
            if (!Thread.holdsLock(d.this)) {
                throw new AssertionError();
            }
            s[] sVarArr = new s[d.this.d];
            long[] jArr = (long[]) this.f5101b.clone();
            for (int i = 0; i < d.this.d; i++) {
                try {
                    sVarArr[i] = d.this.f5093b.a(this.c[i]);
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < d.this.d && sVarArr[i2] != null; i2++) {
                        okhttp3.internal.c.a(sVarArr[i2]);
                    }
                    try {
                        d.this.a(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
            return d.this.new c(this.f5100a, this.g, sVarArr, jArr);
        }
    }
}
