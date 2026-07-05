package io.netty.util.a.b;

import java.util.logging.Logger;

/* compiled from: JdkLoggerFactory.java */
/* loaded from: classes.dex */
public class f extends d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f4651a = new f();

    @Deprecated
    public f() {
    }

    @Override // io.netty.util.a.b.d
    public c b(String str) {
        return new e(Logger.getLogger(str));
    }
}
