package io.netty.util.a;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UnpaddedInternalThreadLocalMap.java */
/* loaded from: classes.dex */
class u {

    /* renamed from: b, reason: collision with root package name */
    static final ThreadLocal<d> f4706b = new ThreadLocal<>();
    static final AtomicInteger c = new AtomicInteger();
    Object[] d;
    int e;
    Map<Class<?>, Boolean> f;
    c g;
    r h;
    Map<Class<?>, t> i;
    Map<Class<?>, Map<String, t>> j;
    Map<Charset, CharsetEncoder> k;

    u(Object[] objArr) {
        this.d = objArr;
    }
}
