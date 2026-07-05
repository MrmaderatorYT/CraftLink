package io.netty.util.a.b;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* compiled from: JdkLogger.java */
/* loaded from: classes.dex */
class e extends a {

    /* renamed from: b, reason: collision with root package name */
    static final String f4649b = "io.netty.util.a.b.e";
    static final String c = a.class.getName();

    /* renamed from: a, reason: collision with root package name */
    final transient Logger f4650a;

    e(Logger logger) {
        super(logger.getName());
        this.f4650a = logger;
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Object obj) {
        if (this.f4650a.isLoggable(Level.FINEST)) {
            b bVarA = i.a(str, obj);
            a(f4649b, Level.FINEST, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Object obj, Object obj2) {
        if (this.f4650a.isLoggable(Level.FINEST)) {
            b bVarA = i.a(str, obj, obj2);
            a(f4649b, Level.FINEST, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public boolean b() {
        return this.f4650a.isLoggable(Level.FINE);
    }

    @Override // io.netty.util.a.b.c
    public void a(String str) {
        if (this.f4650a.isLoggable(Level.FINE)) {
            a(f4649b, Level.FINE, str, null);
        }
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Object obj) {
        if (this.f4650a.isLoggable(Level.FINE)) {
            b bVarA = i.a(str, obj);
            a(f4649b, Level.FINE, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Object obj, Object obj2) {
        if (this.f4650a.isLoggable(Level.FINE)) {
            b bVarA = i.a(str, obj, obj2);
            a(f4649b, Level.FINE, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Object... objArr) {
        if (this.f4650a.isLoggable(Level.FINE)) {
            b bVarA = i.a(str, objArr);
            a(f4649b, Level.FINE, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void a(String str, Throwable th) {
        if (this.f4650a.isLoggable(Level.FINE)) {
            a(f4649b, Level.FINE, str, th);
        }
    }

    @Override // io.netty.util.a.b.c
    public void b(String str) {
        if (this.f4650a.isLoggable(Level.INFO)) {
            a(f4649b, Level.INFO, str, null);
        }
    }

    @Override // io.netty.util.a.b.c
    public boolean c() {
        return this.f4650a.isLoggable(Level.WARNING);
    }

    @Override // io.netty.util.a.b.c
    public void c(String str) {
        if (this.f4650a.isLoggable(Level.WARNING)) {
            a(f4649b, Level.WARNING, str, null);
        }
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Object obj) {
        if (this.f4650a.isLoggable(Level.WARNING)) {
            b bVarA = i.a(str, obj);
            a(f4649b, Level.WARNING, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Object obj, Object obj2) {
        if (this.f4650a.isLoggable(Level.WARNING)) {
            b bVarA = i.a(str, obj, obj2);
            a(f4649b, Level.WARNING, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Object... objArr) {
        if (this.f4650a.isLoggable(Level.WARNING)) {
            b bVarA = i.a(str, objArr);
            a(f4649b, Level.WARNING, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void b(String str, Throwable th) {
        if (this.f4650a.isLoggable(Level.WARNING)) {
            a(f4649b, Level.WARNING, str, th);
        }
    }

    @Override // io.netty.util.a.b.c
    public boolean d() {
        return this.f4650a.isLoggable(Level.SEVERE);
    }

    @Override // io.netty.util.a.b.c
    public void d(String str) {
        if (this.f4650a.isLoggable(Level.SEVERE)) {
            a(f4649b, Level.SEVERE, str, null);
        }
    }

    @Override // io.netty.util.a.b.c
    public void d(String str, Object obj) {
        if (this.f4650a.isLoggable(Level.SEVERE)) {
            b bVarA = i.a(str, obj);
            a(f4649b, Level.SEVERE, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void d(String str, Object obj, Object obj2) {
        if (this.f4650a.isLoggable(Level.SEVERE)) {
            b bVarA = i.a(str, obj, obj2);
            a(f4649b, Level.SEVERE, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Object... objArr) {
        if (this.f4650a.isLoggable(Level.SEVERE)) {
            b bVarA = i.a(str, objArr);
            a(f4649b, Level.SEVERE, bVarA.a(), bVarA.b());
        }
    }

    @Override // io.netty.util.a.b.c
    public void c(String str, Throwable th) {
        if (this.f4650a.isLoggable(Level.SEVERE)) {
            a(f4649b, Level.SEVERE, str, th);
        }
    }

    private void a(String str, Level level, String str2, Throwable th) {
        LogRecord logRecord = new LogRecord(level, str2);
        logRecord.setLoggerName(a());
        logRecord.setThrown(th);
        a(str, logRecord);
        this.f4650a.log(logRecord);
    }

    private static void a(String str, LogRecord logRecord) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int i = 0;
        while (true) {
            if (i >= stackTrace.length) {
                i = -1;
                break;
            }
            String className = stackTrace[i].getClassName();
            if (className.equals(str) || className.equals(c)) {
                break;
            } else {
                i++;
            }
        }
        while (true) {
            i++;
            if (i >= stackTrace.length) {
                i = -1;
                break;
            }
            String className2 = stackTrace[i].getClassName();
            if (!className2.equals(str) && !className2.equals(c)) {
                break;
            }
        }
        if (i != -1) {
            StackTraceElement stackTraceElement = stackTrace[i];
            logRecord.setSourceClassName(stackTraceElement.getClassName());
            logRecord.setSourceMethodName(stackTraceElement.getMethodName());
        }
    }
}
