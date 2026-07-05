package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Exception;

/* loaded from: classes.dex */
public class Http2NoMoreStreamIdsException extends Http2Exception {
    public Http2NoMoreStreamIdsException() {
        super(d.PROTOCOL_ERROR, "No more streams can be created on this connection", Http2Exception.a.GRACEFUL_SHUTDOWN);
    }
}
