package io.netty.handler.codec.http2;

import io.netty.channel.z;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class StreamBufferingEncoder extends io.netty.handler.codec.http2.a {

    /* renamed from: a, reason: collision with root package name */
    private final TreeMap<Integer, b> f4580a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4581b;

    public static final class Http2GoAwayException extends Http2Exception {
    }

    public static final class Http2ChannelClosedException extends Http2Exception {
        public Http2ChannelClosedException() {
            super(d.REFUSED_STREAM, "Connection closed");
        }
    }

    @Override // io.netty.handler.codec.http2.b, io.netty.handler.codec.http2.e, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (!this.f4581b) {
                this.f4581b = true;
                Http2ChannelClosedException http2ChannelClosedException = new Http2ChannelClosedException();
                while (!this.f4580a.isEmpty()) {
                    this.f4580a.pollFirstEntry().getValue().a(http2ChannelClosedException);
                }
            }
        } finally {
            super.close();
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Queue<a> f4583a;

        void a(Throwable th) {
            Iterator<a> it = this.f4583a.iterator();
            while (it.hasNext()) {
                it.next().a(th);
            }
        }
    }

    private static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        final z f4582a;

        void a(Throwable th) {
            if (th == null) {
                this.f4582a.v_();
            } else {
                this.f4582a.a(th);
            }
        }
    }
}
