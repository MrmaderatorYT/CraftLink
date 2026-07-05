package io.netty.handler.codec.http2;

import io.netty.util.a.j;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Http2Exception extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final d f4575a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4576b;

    public static final class ClosedStreamCreationException extends Http2Exception {
    }

    public static final class StreamException extends Http2Exception {
    }

    public enum a {
        NO_SHUTDOWN,
        GRACEFUL_SHUTDOWN,
        HARD_SHUTDOWN
    }

    public Http2Exception(d dVar, String str) {
        this(dVar, str, a.HARD_SHUTDOWN);
    }

    public Http2Exception(d dVar, String str, a aVar) {
        super(str);
        this.f4575a = (d) j.a(dVar, "error");
        this.f4576b = (a) j.a(aVar, "shutdownHint");
    }

    public static final class CompositeStreamException extends Http2Exception implements Iterable<StreamException> {

        /* renamed from: a, reason: collision with root package name */
        private final List<StreamException> f4577a;

        @Override // java.lang.Iterable
        public Iterator<StreamException> iterator() {
            return this.f4577a.iterator();
        }
    }
}
