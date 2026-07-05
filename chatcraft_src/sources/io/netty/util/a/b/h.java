package io.netty.util.a.b;

import org.apache.log4j.Logger;

/* compiled from: Log4JLoggerFactory.java */
/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f4654a = new h();

    @Deprecated
    public h() {
    }

    @Override // io.netty.util.a.b.d
    public c b(String str) {
        return new g(Logger.getLogger(str));
    }
}
