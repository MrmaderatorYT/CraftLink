package okhttp3.internal.http2;

import b.s;
import b.t;
import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.c;

/* compiled from: Http2Reader.java */
/* loaded from: classes.dex */
final class g implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f5201a = Logger.getLogger(d.class.getName());

    /* renamed from: b, reason: collision with root package name */
    final c.a f5202b;
    private final b.e c;
    private final a d;
    private final boolean e;

    /* compiled from: Http2Reader.java */
    interface b {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<okhttp3.internal.http2.b> list);

        void a(int i, long j);

        void a(int i, okhttp3.internal.http2.a aVar);

        void a(int i, okhttp3.internal.http2.a aVar, b.f fVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<okhttp3.internal.http2.b> list);

        void a(boolean z, int i, b.e eVar, int i2);

        void a(boolean z, l lVar);
    }

    g(b.e eVar, boolean z) {
        this.c = eVar;
        this.e = z;
        this.d = new a(this.c);
        this.f5202b = new c.a(4096, this.d);
    }

    public void a(b bVar) throws IOException {
        if (this.e) {
            if (!a(true, bVar)) {
                throw d.b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        b.f fVarC = this.c.c(d.f5180a.h());
        if (f5201a.isLoggable(Level.FINE)) {
            f5201a.fine(okhttp3.internal.c.a("<< CONNECTION %s", fVarC.f()));
        }
        if (!d.f5180a.equals(fVarC)) {
            throw d.b("Expected a connection header but was %s", fVarC.a());
        }
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.c.a(9L);
            int iA = a(this.c);
            if (iA < 0 || iA > 16384) {
                throw d.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(iA));
            }
            byte bH = (byte) (this.c.h() & Constants.DimensionIds.NETHER);
            if (z && bH != 4) {
                throw d.b("Expected a SETTINGS frame but was %s", Byte.valueOf(bH));
            }
            byte bH2 = (byte) (this.c.h() & Constants.DimensionIds.NETHER);
            int iJ = this.c.j() & Integer.MAX_VALUE;
            if (f5201a.isLoggable(Level.FINE)) {
                f5201a.fine(d.a(true, iJ, iA, bH, bH2));
            }
            switch (bH) {
                case 0:
                    b(bVar, iA, bH2, iJ);
                    return true;
                case 1:
                    a(bVar, iA, bH2, iJ);
                    return true;
                case 2:
                    c(bVar, iA, bH2, iJ);
                    return true;
                case 3:
                    d(bVar, iA, bH2, iJ);
                    return true;
                case 4:
                    e(bVar, iA, bH2, iJ);
                    return true;
                case 5:
                    f(bVar, iA, bH2, iJ);
                    return true;
                case 6:
                    g(bVar, iA, bH2, iJ);
                    return true;
                case 7:
                    h(bVar, iA, bH2, iJ);
                    return true;
                case 8:
                    i(bVar, iA, bH2, iJ);
                    return true;
                default:
                    this.c.h(iA);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw d.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        short sH = (b2 & 8) != 0 ? (short) (this.c.h() & Constants.DimensionIds.NETHER) : (short) 0;
        if ((b2 & 32) != 0) {
            a(bVar, i2);
            i -= 5;
        }
        bVar.a(z, i2, -1, a(a(i, b2, sH), sH, b2, i2));
    }

    private List<okhttp3.internal.http2.b> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.d;
        this.d.d = i;
        aVar.f5203a = i;
        this.d.e = s;
        this.d.f5204b = b2;
        this.d.c = i2;
        this.f5202b.a();
        return this.f5202b.b();
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw d.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            throw d.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sH = (b2 & 8) != 0 ? (short) (this.c.h() & Constants.DimensionIds.NETHER) : (short) 0;
        bVar.a(z, i2, this.c, a(i, b2, sH));
        this.c.h(sH);
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 5) {
            throw d.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw d.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        a(bVar, i2);
    }

    private void a(b bVar, int i) {
        int iJ = this.c.j();
        bVar.a(i, iJ & Integer.MAX_VALUE, (this.c.h() & Constants.DimensionIds.NETHER) + 1, (Integer.MIN_VALUE & iJ) != 0);
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw d.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw d.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iJ = this.c.j();
        okhttp3.internal.http2.a aVarA = okhttp3.internal.http2.a.a(iJ);
        if (aVarA == null) {
            throw d.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iJ));
        }
        bVar.a(i2, aVarA);
    }

    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            throw d.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i != 0) {
                throw d.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.a();
            return;
        }
        if (i % 6 != 0) {
            throw d.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        l lVar = new l();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int i4 = this.c.i() & 65535;
            int iJ = this.c.j();
            switch (i4) {
                case 2:
                    if (iJ != 0 && iJ != 1) {
                        throw d.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                    break;
                case 3:
                    i4 = 4;
                    break;
                case 4:
                    i4 = 7;
                    if (iJ < 0) {
                        throw d.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    break;
                case 5:
                    if (iJ < 16384 || iJ > 16777215) {
                        throw d.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iJ));
                    }
                    break;
                    break;
            }
            lVar.a(i4, iJ);
        }
        bVar.a(false, lVar);
    }

    private void f(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw d.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sH = (b2 & 8) != 0 ? (short) (this.c.h() & Constants.DimensionIds.NETHER) : (short) 0;
        bVar.a(i2, this.c.j() & Integer.MAX_VALUE, a(a(i - 4, b2, sH), sH, b2, i2));
    }

    private void g(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            throw d.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw d.b("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.a((b2 & 1) != 0, this.c.j(), this.c.j());
    }

    private void h(b bVar, int i, byte b2, int i2) throws IOException {
        if (i < 8) {
            throw d.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw d.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iJ = this.c.j();
        int iJ2 = this.c.j();
        int i3 = i - 8;
        okhttp3.internal.http2.a aVarA = okhttp3.internal.http2.a.a(iJ2);
        if (aVarA == null) {
            throw d.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iJ2));
        }
        b.f fVarC = b.f.f1168b;
        if (i3 > 0) {
            fVarC = this.c.c(i3);
        }
        bVar.a(iJ, aVarA, fVarC);
    }

    private void i(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw d.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long j = this.c.j() & 2147483647L;
        if (j == 0) {
            throw d.b("windowSizeIncrement was 0", Long.valueOf(j));
        }
        bVar.a(i2, j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.close();
    }

    /* compiled from: Http2Reader.java */
    static final class a implements s {

        /* renamed from: a, reason: collision with root package name */
        int f5203a;

        /* renamed from: b, reason: collision with root package name */
        byte f5204b;
        int c;
        int d;
        short e;
        private final b.e f;

        @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        a(b.e eVar) {
            this.f = eVar;
        }

        @Override // b.s
        public long a(b.c cVar, long j) throws IOException {
            while (this.d == 0) {
                this.f.h(this.e);
                this.e = (short) 0;
                if ((this.f5204b & 4) != 0) {
                    return -1L;
                }
                b();
            }
            long jA = this.f.a(cVar, Math.min(j, this.d));
            if (jA == -1) {
                return -1L;
            }
            this.d = (int) (this.d - jA);
            return jA;
        }

        @Override // b.s
        public t a() {
            return this.f.a();
        }

        private void b() throws IOException {
            int i = this.c;
            int iA = g.a(this.f);
            this.d = iA;
            this.f5203a = iA;
            byte bH = (byte) (this.f.h() & Constants.DimensionIds.NETHER);
            this.f5204b = (byte) (this.f.h() & Constants.DimensionIds.NETHER);
            if (g.f5201a.isLoggable(Level.FINE)) {
                g.f5201a.fine(d.a(true, this.c, this.f5203a, bH, this.f5204b));
            }
            this.c = this.f.j() & Integer.MAX_VALUE;
            if (bH != 9) {
                throw d.b("%s != TYPE_CONTINUATION", Byte.valueOf(bH));
            }
            if (this.c != i) {
                throw d.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int a(b.e eVar) {
        return (eVar.h() & Constants.DimensionIds.NETHER) | ((eVar.h() & Constants.DimensionIds.NETHER) << 16) | ((eVar.h() & Constants.DimensionIds.NETHER) << 8);
    }

    static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw d.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
