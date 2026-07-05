package io.fabric.sdk.android.services.b;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: QueueFile.java */
/* loaded from: classes.dex */
public class t implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f4236b = Logger.getLogger(t.class.getName());

    /* renamed from: a, reason: collision with root package name */
    int f4237a;
    private final RandomAccessFile c;
    private int d;
    private a e;
    private a f;
    private final byte[] g = new byte[16];

    /* compiled from: QueueFile.java */
    public interface c {
        void a(InputStream inputStream, int i);
    }

    public t(File file) throws IOException {
        if (!file.exists()) {
            a(file);
        }
        this.c = b(file);
        e();
    }

    private static void b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            b(bArr, i, i2);
            i += 4;
        }
    }

    private static int a(byte[] bArr, int i) {
        return ((bArr[i] & Constants.DimensionIds.NETHER) << 24) + ((bArr[i + 1] & Constants.DimensionIds.NETHER) << 16) + ((bArr[i + 2] & Constants.DimensionIds.NETHER) << 8) + (bArr[i + 3] & Constants.DimensionIds.NETHER);
    }

    private void e() throws IOException {
        this.c.seek(0L);
        this.c.readFully(this.g);
        this.f4237a = a(this.g, 0);
        if (this.f4237a > this.c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f4237a + ", Actual length: " + this.c.length());
        }
        this.d = a(this.g, 4);
        int iA = a(this.g, 8);
        int iA2 = a(this.g, 12);
        this.e = a(iA);
        this.f = a(iA2);
    }

    private void a(int i, int i2, int i3, int i4) throws IOException {
        a(this.g, i, i2, i3, i4);
        this.c.seek(0L);
        this.c.write(this.g);
    }

    private a a(int i) throws IOException {
        if (i == 0) {
            return a.f4240a;
        }
        this.c.seek(i);
        return new a(i, this.c.readInt());
    }

    private static void a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileB = b(file2);
        try {
            randomAccessFileB.setLength(4096L);
            randomAccessFileB.seek(0L);
            byte[] bArr = new byte[16];
            a(bArr, 4096, 0, 0, 0);
            randomAccessFileB.write(bArr);
            randomAccessFileB.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileB.close();
            throw th;
        }
    }

    private static RandomAccessFile b(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i) {
        return i < this.f4237a ? i : (i + 16) - this.f4237a;
    }

    private void a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int iB = b(i);
        if (iB + i3 <= this.f4237a) {
            this.c.seek(iB);
            this.c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f4237a - iB;
        this.c.seek(iB);
        this.c.write(bArr, i2, i4);
        this.c.seek(16L);
        this.c.write(bArr, i2 + i4, i3 - i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int iB = b(i);
        if (iB + i3 <= this.f4237a) {
            this.c.seek(iB);
            this.c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f4237a - iB;
        this.c.seek(iB);
        this.c.readFully(bArr, i2, i4);
        this.c.seek(16L);
        this.c.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public synchronized void a(byte[] bArr, int i, int i2) {
        b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        c(i2);
        boolean zB = b();
        a aVar = new a(zB ? 16 : b(this.f.f4241b + 4 + this.f.c), i2);
        b(this.g, 0, i2);
        a(aVar.f4241b, this.g, 0, 4);
        a(aVar.f4241b + 4, bArr, i, i2);
        a(this.f4237a, this.d + 1, zB ? aVar.f4241b : this.e.f4241b, aVar.f4241b);
        this.f = aVar;
        this.d++;
        if (zB) {
            this.e = this.f;
        }
    }

    public int a() {
        if (this.d == 0) {
            return 16;
        }
        if (this.f.f4241b >= this.e.f4241b) {
            return (this.f.f4241b - this.e.f4241b) + 4 + this.f.c + 16;
        }
        return (((this.f.f4241b + 4) + this.f.c) + this.f4237a) - this.e.f4241b;
    }

    private int f() {
        return this.f4237a - a();
    }

    public synchronized boolean b() {
        return this.d == 0;
    }

    private void c(int i) throws IOException {
        int i2 = i + 4;
        int iF = f();
        if (iF >= i2) {
            return;
        }
        int i3 = this.f4237a;
        do {
            iF += i3;
            i3 <<= 1;
        } while (iF < i2);
        d(i3);
        int iB = b(this.f.f4241b + 4 + this.f.c);
        if (iB < this.e.f4241b) {
            FileChannel channel = this.c.getChannel();
            channel.position(this.f4237a);
            long j = iB - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        if (this.f.f4241b < this.e.f4241b) {
            int i4 = (this.f4237a + this.f.f4241b) - 16;
            a(i3, this.d, this.e.f4241b, i4);
            this.f = new a(i4, this.f.c);
        } else {
            a(i3, this.d, this.e.f4241b, this.f.f4241b);
        }
        this.f4237a = i3;
    }

    private void d(int i) throws IOException {
        this.c.setLength(i);
        this.c.getChannel().force(true);
    }

    public synchronized void a(c cVar) {
        int iB = this.e.f4241b;
        for (int i = 0; i < this.d; i++) {
            a aVarA = a(iB);
            cVar.a(new b(aVarA), aVarA.c);
            iB = b(aVarA.f4241b + 4 + aVarA.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* compiled from: QueueFile.java */
    private final class b extends InputStream {

        /* renamed from: b, reason: collision with root package name */
        private int f4243b;
        private int c;

        private b(a aVar) {
            this.f4243b = t.this.b(aVar.f4241b + 4);
            this.c = aVar.c;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            t.b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (this.c <= 0) {
                return -1;
            }
            if (i2 > this.c) {
                i2 = this.c;
            }
            t.this.b(this.f4243b, bArr, i, i2);
            this.f4243b = t.this.b(this.f4243b + i2);
            this.c -= i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.c == 0) {
                return -1;
            }
            t.this.c.seek(this.f4243b);
            int i = t.this.c.read();
            this.f4243b = t.this.b(this.f4243b + 1);
            this.c--;
            return i;
        }
    }

    public synchronized void c() {
        if (b()) {
            throw new NoSuchElementException();
        }
        if (this.d == 1) {
            d();
        } else {
            int iB = b(this.e.f4241b + 4 + this.e.c);
            b(iB, this.g, 0, 4);
            int iA = a(this.g, 0);
            a(this.f4237a, this.d - 1, iB, this.f.f4241b);
            this.d--;
            this.e = new a(iB, iA);
        }
    }

    public synchronized void d() {
        a(4096, 0, 0, 0);
        this.d = 0;
        this.e = a.f4240a;
        this.f = a.f4240a;
        if (this.f4237a > 4096) {
            d(4096);
        }
        this.f4237a = 4096;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.c.close();
    }

    public boolean a(int i, int i2) {
        return (a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f4237a);
        sb.append(", size=");
        sb.append(this.d);
        sb.append(", first=");
        sb.append(this.e);
        sb.append(", last=");
        sb.append(this.f);
        sb.append(", element lengths=[");
        try {
            a(new c() { // from class: io.fabric.sdk.android.services.b.t.1

                /* renamed from: a, reason: collision with root package name */
                boolean f4238a = true;

                @Override // io.fabric.sdk.android.services.b.t.c
                public void a(InputStream inputStream, int i) {
                    if (this.f4238a) {
                        this.f4238a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e) {
            f4236b.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    /* compiled from: QueueFile.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        static final a f4240a = new a(0, 0);

        /* renamed from: b, reason: collision with root package name */
        final int f4241b;
        final int c;

        a(int i, int i2) {
            this.f4241b = i;
            this.c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f4241b + ", length = " + this.c + "]";
        }
    }
}
