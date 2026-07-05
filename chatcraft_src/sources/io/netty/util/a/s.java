package io.netty.util.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/* compiled from: ThrowableUtil.java */
/* loaded from: classes.dex */
public final class s {
    public static <T extends Throwable> T a(T t, Class<?> cls, String str) {
        t.setStackTrace(new StackTraceElement[]{new StackTraceElement(cls.getName(), str, null, -1)});
        return t;
    }

    public static String a(Throwable th) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        try {
            return new String(byteArrayOutputStream.toByteArray());
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }
}
