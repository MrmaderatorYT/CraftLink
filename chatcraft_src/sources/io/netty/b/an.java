package io.netty.b;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: UnsafeByteBufUtil.java */
/* loaded from: classes.dex */
final class an {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f4375a = io.netty.util.a.l.g();

    static byte a(long j) {
        return io.netty.util.a.l.a(j);
    }

    static short b(long j) {
        if (!f4375a) {
            return (short) ((io.netty.util.a.l.a(j + 1) & Constants.DimensionIds.NETHER) | (io.netty.util.a.l.a(j) << 8));
        }
        short sB = io.netty.util.a.l.b(j);
        return io.netty.util.a.l.f4686a ? sB : Short.reverseBytes(sB);
    }

    static short c(long j) {
        if (!f4375a) {
            return (short) ((io.netty.util.a.l.a(j + 1) << 8) | (io.netty.util.a.l.a(j) & Constants.DimensionIds.NETHER));
        }
        short sB = io.netty.util.a.l.b(j);
        return io.netty.util.a.l.f4686a ? Short.reverseBytes(sB) : sB;
    }

    static int d(long j) {
        if (!f4375a) {
            return (io.netty.util.a.l.a(j + 3) & Constants.DimensionIds.NETHER) | (io.netty.util.a.l.a(j) << 24) | ((io.netty.util.a.l.a(1 + j) & Constants.DimensionIds.NETHER) << 16) | ((io.netty.util.a.l.a(2 + j) & Constants.DimensionIds.NETHER) << 8);
        }
        int iC = io.netty.util.a.l.c(j);
        return io.netty.util.a.l.f4686a ? iC : Integer.reverseBytes(iC);
    }

    static int e(long j) {
        if (!f4375a) {
            return (io.netty.util.a.l.a(j + 3) << 24) | (io.netty.util.a.l.a(j) & Constants.DimensionIds.NETHER) | ((io.netty.util.a.l.a(1 + j) & Constants.DimensionIds.NETHER) << 8) | ((io.netty.util.a.l.a(2 + j) & Constants.DimensionIds.NETHER) << 16);
        }
        int iC = io.netty.util.a.l.c(j);
        return io.netty.util.a.l.f4686a ? Integer.reverseBytes(iC) : iC;
    }

    static long f(long j) {
        if (!f4375a) {
            return (io.netty.util.a.l.a(j + 7) & 255) | (io.netty.util.a.l.a(j) << 56) | ((io.netty.util.a.l.a(1 + j) & 255) << 48) | ((io.netty.util.a.l.a(2 + j) & 255) << 40) | ((io.netty.util.a.l.a(3 + j) & 255) << 32) | ((io.netty.util.a.l.a(4 + j) & 255) << 24) | ((io.netty.util.a.l.a(5 + j) & 255) << 16) | ((io.netty.util.a.l.a(6 + j) & 255) << 8);
        }
        long jD = io.netty.util.a.l.d(j);
        return io.netty.util.a.l.f4686a ? jD : Long.reverseBytes(jD);
    }

    static void a(long j, int i) {
        io.netty.util.a.l.a(j, (byte) i);
    }

    static void b(long j, int i) {
        if (f4375a) {
            io.netty.util.a.l.a(j, io.netty.util.a.l.f4686a ? (short) i : Short.reverseBytes((short) i));
        } else {
            io.netty.util.a.l.a(j, (byte) (i >>> 8));
            io.netty.util.a.l.a(j + 1, (byte) i);
        }
    }

    static void c(long j, int i) {
        if (f4375a) {
            if (!io.netty.util.a.l.f4686a) {
                i = Integer.reverseBytes(i);
            }
            io.netty.util.a.l.a(j, i);
        } else {
            io.netty.util.a.l.a(j, (byte) (i >>> 24));
            io.netty.util.a.l.a(1 + j, (byte) (i >>> 16));
            io.netty.util.a.l.a(2 + j, (byte) (i >>> 8));
            io.netty.util.a.l.a(j + 3, (byte) i);
        }
    }

    static void a(long j, long j2) {
        if (f4375a) {
            if (!io.netty.util.a.l.f4686a) {
                j2 = Long.reverseBytes(j2);
            }
            io.netty.util.a.l.a(j, j2);
            return;
        }
        io.netty.util.a.l.a(j, (byte) (j2 >>> 56));
        io.netty.util.a.l.a(1 + j, (byte) (j2 >>> 48));
        io.netty.util.a.l.a(2 + j, (byte) (j2 >>> 40));
        io.netty.util.a.l.a(3 + j, (byte) (j2 >>> 32));
        io.netty.util.a.l.a(4 + j, (byte) (j2 >>> 24));
        io.netty.util.a.l.a(5 + j, (byte) (j2 >>> 16));
        io.netty.util.a.l.a(6 + j, (byte) (j2 >>> 8));
        io.netty.util.a.l.a(j + 7, (byte) j2);
    }

    static byte a(byte[] bArr, int i) {
        return io.netty.util.a.l.a(bArr, i);
    }

    static short b(byte[] bArr, int i) {
        if (!f4375a) {
            return (short) ((io.netty.util.a.l.a(bArr, i + 1) & Constants.DimensionIds.NETHER) | (io.netty.util.a.l.a(bArr, i) << 8));
        }
        short sB = io.netty.util.a.l.b(bArr, i);
        return io.netty.util.a.l.f4686a ? sB : Short.reverseBytes(sB);
    }

    static short c(byte[] bArr, int i) {
        if (f4375a) {
            short sB = io.netty.util.a.l.b(bArr, i);
            return io.netty.util.a.l.f4686a ? Short.reverseBytes(sB) : sB;
        }
        return (short) ((io.netty.util.a.l.a(i) & Constants.DimensionIds.NETHER) | (io.netty.util.a.l.a(i + 1) << 8));
    }

    static int d(byte[] bArr, int i) {
        if (!f4375a) {
            return (io.netty.util.a.l.a(bArr, i + 3) & Constants.DimensionIds.NETHER) | (io.netty.util.a.l.a(bArr, i) << 24) | ((io.netty.util.a.l.a(bArr, i + 1) & Constants.DimensionIds.NETHER) << 16) | ((io.netty.util.a.l.a(bArr, i + 2) & Constants.DimensionIds.NETHER) << 8);
        }
        int iC = io.netty.util.a.l.c(bArr, i);
        return io.netty.util.a.l.f4686a ? iC : Integer.reverseBytes(iC);
    }

    static int e(byte[] bArr, int i) {
        if (!f4375a) {
            return (io.netty.util.a.l.a(bArr, i + 3) << 24) | (io.netty.util.a.l.a(bArr, i) & Constants.DimensionIds.NETHER) | ((io.netty.util.a.l.a(bArr, i + 1) & Constants.DimensionIds.NETHER) << 8) | ((io.netty.util.a.l.a(bArr, i + 2) & Constants.DimensionIds.NETHER) << 16);
        }
        int iC = io.netty.util.a.l.c(bArr, i);
        return io.netty.util.a.l.f4686a ? Integer.reverseBytes(iC) : iC;
    }

    static long f(byte[] bArr, int i) {
        if (!f4375a) {
            return (io.netty.util.a.l.a(bArr, i + 7) & 255) | (io.netty.util.a.l.a(bArr, i) << 56) | ((io.netty.util.a.l.a(bArr, i + 1) & 255) << 48) | ((io.netty.util.a.l.a(bArr, i + 2) & 255) << 40) | ((io.netty.util.a.l.a(bArr, i + 3) & 255) << 32) | ((io.netty.util.a.l.a(bArr, i + 4) & 255) << 24) | ((io.netty.util.a.l.a(bArr, i + 5) & 255) << 16) | ((io.netty.util.a.l.a(bArr, i + 6) & 255) << 8);
        }
        long jD = io.netty.util.a.l.d(bArr, i);
        return io.netty.util.a.l.f4686a ? jD : Long.reverseBytes(jD);
    }

    static void a(byte[] bArr, int i, int i2) {
        io.netty.util.a.l.a(bArr, i, (byte) i2);
    }

    static void b(byte[] bArr, int i, int i2) {
        if (f4375a) {
            io.netty.util.a.l.a(bArr, i, io.netty.util.a.l.f4686a ? (short) i2 : Short.reverseBytes((short) i2));
        } else {
            io.netty.util.a.l.a(bArr, i, (byte) (i2 >>> 8));
            io.netty.util.a.l.a(bArr, i + 1, (byte) i2);
        }
    }

    static void c(byte[] bArr, int i, int i2) {
        if (f4375a) {
            if (!io.netty.util.a.l.f4686a) {
                i2 = Integer.reverseBytes(i2);
            }
            io.netty.util.a.l.a(bArr, i, i2);
        } else {
            io.netty.util.a.l.a(bArr, i, (byte) (i2 >>> 24));
            io.netty.util.a.l.a(bArr, i + 1, (byte) (i2 >>> 16));
            io.netty.util.a.l.a(bArr, i + 2, (byte) (i2 >>> 8));
            io.netty.util.a.l.a(bArr, i + 3, (byte) i2);
        }
    }

    static void a(byte[] bArr, int i, long j) {
        if (f4375a) {
            if (!io.netty.util.a.l.f4686a) {
                j = Long.reverseBytes(j);
            }
            io.netty.util.a.l.a(bArr, i, j);
            return;
        }
        io.netty.util.a.l.a(bArr, i, (byte) (j >>> 56));
        io.netty.util.a.l.a(bArr, i + 1, (byte) (j >>> 48));
        io.netty.util.a.l.a(bArr, i + 2, (byte) (j >>> 40));
        io.netty.util.a.l.a(bArr, i + 3, (byte) (j >>> 32));
        io.netty.util.a.l.a(bArr, i + 4, (byte) (j >>> 24));
        io.netty.util.a.l.a(bArr, i + 5, (byte) (j >>> 16));
        io.netty.util.a.l.a(bArr, i + 6, (byte) (j >>> 8));
        io.netty.util.a.l.a(bArr, i + 7, (byte) j);
    }

    static int a(a aVar, long j, int i, InputStream inputStream, int i2) {
        aVar.i(i, i2);
        i iVarC = aVar.F().c(i2);
        try {
            byte[] bArrJ = iVarC.J();
            int iK = iVarC.K();
            int i3 = inputStream.read(bArrJ, iK, i2);
            if (i3 > 0) {
                io.netty.util.a.l.a(bArrJ, iK, j, i3);
            }
            return i3;
        } finally {
            iVarC.D();
        }
    }

    static void a(a aVar, long j, int i, i iVar, int i2, int i3) {
        aVar.i(i, i3);
        io.netty.util.a.j.a(iVar, "dst");
        if (io.netty.util.a.h.a(i2, i3, iVar.Q())) {
            throw new IndexOutOfBoundsException("dstIndex: " + i2);
        }
        if (iVar.L()) {
            io.netty.util.a.l.a(j, iVar.M() + i2, i3);
        } else if (iVar.I()) {
            io.netty.util.a.l.a(j, iVar.J(), iVar.K() + i2, i3);
        } else {
            iVar.b(i2, aVar, i, i3);
        }
    }

    static void a(a aVar, long j, int i, byte[] bArr, int i2, int i3) {
        aVar.i(i, i3);
        io.netty.util.a.j.a(bArr, "dst");
        if (io.netty.util.a.h.a(i2, i3, bArr.length)) {
            throw new IndexOutOfBoundsException("dstIndex: " + i2);
        }
        if (i3 != 0) {
            io.netty.util.a.l.a(j, bArr, i2, i3);
        }
    }

    static void b(a aVar, long j, int i, i iVar, int i2, int i3) {
        aVar.i(i, i3);
        io.netty.util.a.j.a(iVar, "src");
        if (io.netty.util.a.h.a(i2, i3, iVar.Q())) {
            throw new IndexOutOfBoundsException("srcIndex: " + i2);
        }
        if (i3 != 0) {
            if (iVar.L()) {
                io.netty.util.a.l.a(iVar.M() + i2, j, i3);
            } else if (iVar.I()) {
                io.netty.util.a.l.a(iVar.J(), iVar.K() + i2, j, i3);
            } else {
                iVar.a(i2, aVar, i, i3);
            }
        }
    }

    static void b(a aVar, long j, int i, byte[] bArr, int i2, int i3) {
        aVar.i(i, i3);
        if (i3 != 0) {
            io.netty.util.a.l.a(bArr, i2, j, i3);
        }
    }

    static void a(a aVar, long j, int i, OutputStream outputStream, int i2) {
        aVar.i(i, i2);
        if (i2 != 0) {
            i iVarC = aVar.F().c(i2);
            try {
                byte[] bArrJ = iVarC.J();
                int iK = iVarC.K();
                io.netty.util.a.l.a(j, bArrJ, iK, i2);
                outputStream.write(bArrJ, iK, i2);
            } finally {
                iVarC.D();
            }
        }
    }

    static ak a(j jVar, int i, int i2) {
        if (io.netty.util.a.l.m()) {
            return new am(jVar, i, i2);
        }
        return new ak(jVar, i, i2);
    }
}
