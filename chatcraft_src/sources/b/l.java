package b;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: Okio.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f1176a = Logger.getLogger(l.class.getName());

    private l() {
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    public static r a(OutputStream outputStream) {
        return a(outputStream, new t());
    }

    private static r a(final OutputStream outputStream, final t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (tVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new r() { // from class: b.l.1
            @Override // b.r
            public void a_(c cVar, long j) throws IOException {
                u.a(cVar.f1165b, 0L, j);
                while (j > 0) {
                    tVar.g();
                    o oVar = cVar.f1164a;
                    int iMin = (int) Math.min(j, oVar.c - oVar.f1188b);
                    outputStream.write(oVar.f1187a, oVar.f1188b, iMin);
                    oVar.f1188b += iMin;
                    long j2 = iMin;
                    j -= j2;
                    cVar.f1165b -= j2;
                    if (oVar.f1188b == oVar.c) {
                        cVar.f1164a = oVar.b();
                        p.a(oVar);
                    }
                }
            }

            @Override // b.r, java.io.Flushable
            public void flush() throws IOException {
                outputStream.flush();
            }

            @Override // b.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                outputStream.close();
            }

            @Override // b.r
            public t a() {
                return tVar;
            }

            public String toString() {
                return "sink(" + outputStream + ")";
            }
        };
    }

    public static r a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        a aVarC = c(socket);
        return aVarC.a(a(socket.getOutputStream(), aVarC));
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(final InputStream inputStream, final t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (tVar == null) {
            throw new IllegalArgumentException("timeout == null");
        }
        return new s() { // from class: b.l.2
            @Override // b.s
            public long a(c cVar, long j) throws IOException {
                if (j < 0) {
                    throw new IllegalArgumentException("byteCount < 0: " + j);
                }
                if (j == 0) {
                    return 0L;
                }
                try {
                    tVar.g();
                    o oVarE = cVar.e(1);
                    int i = inputStream.read(oVarE.f1187a, oVarE.c, (int) Math.min(j, 8192 - oVarE.c));
                    if (i == -1) {
                        return -1L;
                    }
                    oVarE.c += i;
                    long j2 = i;
                    cVar.f1165b += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (l.a(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            }

            @Override // b.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                inputStream.close();
            }

            @Override // b.s
            public t a() {
                return tVar;
            }

            public String toString() {
                return "source(" + inputStream + ")";
            }
        };
    }

    public static s a(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileInputStream(file));
    }

    public static r b(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file));
    }

    public static r c(File file) {
        if (file == null) {
            throw new IllegalArgumentException("file == null");
        }
        return a(new FileOutputStream(file, true));
    }

    public static r a() {
        return new r() { // from class: b.l.3
            @Override // b.r, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // b.r, java.io.Flushable
            public void flush() {
            }

            @Override // b.r
            public void a_(c cVar, long j) throws EOFException {
                cVar.h(j);
            }

            @Override // b.r
            public t a() {
                return t.c;
            }
        };
    }

    public static s b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        a aVarC = c(socket);
        return aVarC.a(a(socket.getInputStream(), aVarC));
    }

    private static a c(final Socket socket) {
        return new a() { // from class: b.l.4
            @Override // b.a
            protected IOException a(@Nullable IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override // b.a
            protected void a() throws IOException {
                try {
                    socket.close();
                } catch (AssertionError e) {
                    if (l.a(e)) {
                        l.f1176a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
                        return;
                    }
                    throw e;
                } catch (Exception e2) {
                    l.f1176a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                }
            }
        };
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
