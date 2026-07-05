package okhttp3.internal.http2;

import java.io.IOException;

/* loaded from: classes.dex */
public final class StreamResetException extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final a f5169a;

    public StreamResetException(a aVar) {
        super("stream was reset: " + aVar);
        this.f5169a = aVar;
    }
}
