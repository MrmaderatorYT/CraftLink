package io.netty.channel.unix;

import java.io.IOException;

/* loaded from: classes.dex */
public final class Errors {

    /* renamed from: a, reason: collision with root package name */
    public static final int f4564a = -ErrorsStaticallyReferencedJniMethods.errnoENOTCONN();

    /* renamed from: b, reason: collision with root package name */
    public static final int f4565b = -ErrorsStaticallyReferencedJniMethods.errnoEBADF();
    public static final int c = -ErrorsStaticallyReferencedJniMethods.errnoEPIPE();
    public static final int d = -ErrorsStaticallyReferencedJniMethods.errnoECONNRESET();
    public static final int e = -ErrorsStaticallyReferencedJniMethods.errnoEAGAIN();
    public static final int f = -ErrorsStaticallyReferencedJniMethods.errnoEWOULDBLOCK();
    public static final int g = -ErrorsStaticallyReferencedJniMethods.errnoEINPROGRESS();
    public static final int h = -ErrorsStaticallyReferencedJniMethods.errorECONNREFUSED();
    public static final int i = -ErrorsStaticallyReferencedJniMethods.errorEISCONN();
    public static final int j = -ErrorsStaticallyReferencedJniMethods.errorEALREADY();
    public static final int k = -ErrorsStaticallyReferencedJniMethods.errorENETUNREACH();
    private static final String[] l = new String[512];

    public static final class NativeIoException extends IOException {
    }

    static {
        for (int i2 = 0; i2 < l.length; i2++) {
            l[i2] = ErrorsStaticallyReferencedJniMethods.strError(i2);
        }
    }
}
