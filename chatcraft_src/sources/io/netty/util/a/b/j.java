package io.netty.util.a.b;

import org.slf4j.Logger;

/* compiled from: Slf4JLogger.java */
/* loaded from: classes.dex */
class j extends a {

    /* renamed from: a, reason: collision with root package name */
    private final transient Logger f4655a;

    j(Logger logger) {
        super(logger.getName());
        this.f4655a = logger;
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Object obj) {
        this.f4655a.trace(str, obj);
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Object obj, Object obj2) {
        this.f4655a.trace(str, obj, obj2);
    }

    @Override // io.netty.util.a.b.c
    public boolean b() {
        return this.f4655a.isDebugEnabled();
    }

    @Override // io.netty.util.a.b.c
    public void a(String str) {
        this.f4655a.debug(str);
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Object obj) {
        this.f4655a.debug(str, obj);
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Object obj, Object obj2) {
        this.f4655a.debug(str, obj, obj2);
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Object... objArr) {
        this.f4655a.debug(str, objArr);
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Throwable th) {
        this.f4655a.debug(str, th);
    }

    @Override // io.netty.util.a.b.c
    public void b(String str) {
        this.f4655a.info(str);
    }

    @Override // io.netty.util.a.b.c
    public boolean c() {
        return this.f4655a.isWarnEnabled();
    }

    @Override // io.netty.util.a.b.c
    public void c(String str) {
        this.f4655a.warn(str);
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Object obj) {
        this.f4655a.warn(str, obj);
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Object... objArr) {
        this.f4655a.warn(str, objArr);
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Object obj, Object obj2) {
        this.f4655a.warn(str, obj, obj2);
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Throwable th) {
        this.f4655a.warn(str, th);
    }

    @Override // io.netty.util.a.b.c
    public boolean d() {
        return this.f4655a.isErrorEnabled();
    }

    @Override // io.netty.util.a.b.c
    public void d(String str) {
        this.f4655a.error(str);
    }

    @Override // io.netty.util.a.b.c
    public void d(String str, Object obj) {
        this.f4655a.error(str, obj);
    }

    @Override // io.netty.util.a.b.c
    public void d(String str, Object obj, Object obj2) {
        this.f4655a.error(str, obj, obj2);
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Object... objArr) {
        this.f4655a.error(str, objArr);
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Throwable th) {
        this.f4655a.error(str, th);
    }
}
