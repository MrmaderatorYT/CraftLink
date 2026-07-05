package io.netty.util.a.b;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

/* compiled from: Slf4JLoggerFactory.java */
/* loaded from: classes.dex */
public class k extends d {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f4657b = !k.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    public static final d f4656a = new k();

    @Deprecated
    public k() {
    }

    k(boolean z) {
        if (!f4657b && !z) {
            throw new AssertionError();
        }
        final StringBuffer stringBuffer = new StringBuffer();
        PrintStream printStream = System.err;
        try {
            System.setErr(new PrintStream(new OutputStream() { // from class: io.netty.util.a.b.k.1
                @Override // java.io.OutputStream
                public void write(int i) {
                    stringBuffer.append((char) i);
                }
            }, true, "US-ASCII"));
            try {
                if (LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory) {
                    throw new NoClassDefFoundError(stringBuffer.toString());
                }
                printStream.print(stringBuffer);
                printStream.flush();
            } finally {
                System.setErr(printStream);
            }
        } catch (UnsupportedEncodingException e) {
            throw new Error(e);
        }
    }

    @Override // io.netty.util.a.b.d
    public c b(String str) {
        return new j(LoggerFactory.getLogger(str));
    }
}
