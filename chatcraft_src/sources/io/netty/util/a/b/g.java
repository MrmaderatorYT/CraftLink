package io.netty.util.a.b;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/* compiled from: Log4JLogger.java */
/* loaded from: classes.dex */
class g extends a {

    /* renamed from: b, reason: collision with root package name */
    static final String f4652b = "io.netty.util.a.b.g";

    /* renamed from: a, reason: collision with root package name */
    final transient Logger f4653a;
    final boolean c;

    g(Logger logger) {
        super(logger.getName());
        this.f4653a = logger;
        this.c = f();
    }

    private boolean f() {
        try {
            this.f4653a.isTraceEnabled();
            return true;
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    public boolean e() {
        if (this.c) {
            return this.f4653a.isTraceEnabled();
        }
        return this.f4653a.isDebugEnabled();
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Object obj) {
        if (e()) {
            b bVarA = i.a(str, obj);
            this.f4653a.log(f4652b, this.c ? Level.TRACE : Level.DEBUG, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Object obj, Object obj2) {
        if (e()) {
            b bVarA = i.a(str, obj, obj2);
            this.f4653a.log(f4652b, this.c ? Level.TRACE : Level.DEBUG, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public boolean b() {
        return this.f4653a.isDebugEnabled();
    }

    @Override // io.netty.util.a.b.c
    public void a(String str) {
        this.f4653a.log(f4652b, Level.DEBUG, str, (Throwable) null);
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Object obj) {
        if (this.f4653a.isDebugEnabled()) {
            b bVarA = i.a(str, obj);
            this.f4653a.log(f4652b, Level.DEBUG, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Object obj, Object obj2) {
        if (this.f4653a.isDebugEnabled()) {
            b bVarA = i.a(str, obj, obj2);
            this.f4653a.log(f4652b, Level.DEBUG, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Object... objArr) {
        if (this.f4653a.isDebugEnabled()) {
            b bVarA = i.a(str, objArr);
            this.f4653a.log(f4652b, Level.DEBUG, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Throwable th) {
        this.f4653a.log(f4652b, Level.DEBUG, str, th);
    }

    @Override // io.netty.util.a.b.c
    public void b(String str) {
        this.f4653a.log(f4652b, Level.INFO, str, (Throwable) null);
    }

    @Override // io.netty.util.a.b.c
    public boolean c() {
        return this.f4653a.isEnabledFor(Level.WARN);
    }

    @Override // io.netty.util.a.b.c
    public void c(String str) {
        this.f4653a.log(f4652b, Level.WARN, str, (Throwable) null);
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Object obj) {
        if (this.f4653a.isEnabledFor(Level.WARN)) {
            b bVarA = i.a(str, obj);
            this.f4653a.log(f4652b, Level.WARN, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Object obj, Object obj2) {
        if (this.f4653a.isEnabledFor(Level.WARN)) {
            b bVarA = i.a(str, obj, obj2);
            this.f4653a.log(f4652b, Level.WARN, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Object... objArr) {
        if (this.f4653a.isEnabledFor(Level.WARN)) {
            b bVarA = i.a(str, objArr);
            this.f4653a.log(f4652b, Level.WARN, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Throwable th) {
        this.f4653a.log(f4652b, Level.WARN, str, th);
    }

    @Override // io.netty.util.a.b.c
    public boolean d() {
        return this.f4653a.isEnabledFor(Level.ERROR);
    }

    @Override // io.netty.util.a.b.c
    public void d(String str) {
        this.f4653a.log(f4652b, Level.ERROR, str, (Throwable) null);
    }

    @Override // io.netty.util.a.b.c
    public void d(String str, Object obj) {
        if (this.f4653a.isEnabledFor(Level.ERROR)) {
            b bVarA = i.a(str, obj);
            this.f4653a.log(f4652b, Level.ERROR, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void d(String str, Object obj, Object obj2) {
        if (this.f4653a.isEnabledFor(Level.ERROR)) {
            b bVarA = i.a(str, obj, obj2);
            this.f4653a.log(f4652b, Level.ERROR, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Object... objArr) {
        if (this.f4653a.isEnabledFor(Level.ERROR)) {
            b bVarA = i.a(str, objArr);
            this.f4653a.log(f4652b, Level.ERROR, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Throwable th) {
        this.f4653a.log(f4652b, Level.ERROR, str, th);
    }
}
