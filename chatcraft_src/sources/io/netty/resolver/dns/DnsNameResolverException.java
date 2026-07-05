package io.netty.resolver.dns;

import io.netty.util.a.b;

/* loaded from: classes.dex */
public final class DnsNameResolverException extends RuntimeException {
    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(b.f);
        return this;
    }
}
