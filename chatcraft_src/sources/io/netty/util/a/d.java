package io.netty.util.a;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: InternalThreadLocalMap.java */
/* loaded from: classes.dex */
public final class d extends u {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f4680a = new Object();

    public static d a() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof io.netty.util.concurrent.o) {
            return ((io.netty.util.concurrent.o) threadCurrentThread).a();
        }
        return f4706b.get();
    }

    public static d b() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof io.netty.util.concurrent.o) {
            return a((io.netty.util.concurrent.o) threadCurrentThread);
        }
        return l();
    }

    private static d a(io.netty.util.concurrent.o oVar) {
        d dVarA = oVar.a();
        if (dVarA != null) {
            return dVarA;
        }
        d dVar = new d();
        oVar.a(dVar);
        return dVar;
    }

    private static d l() {
        ThreadLocal<d> threadLocal = u.f4706b;
        d dVar = threadLocal.get();
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        threadLocal.set(dVar2);
        return dVar2;
    }

    public static void c() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof io.netty.util.concurrent.o) {
            ((io.netty.util.concurrent.o) threadCurrentThread).a(null);
        } else {
            f4706b.remove();
        }
    }

    public static int d() {
        int andIncrement = c.getAndIncrement();
        if (andIncrement >= 0) {
            return andIncrement;
        }
        c.decrementAndGet();
        throw new IllegalStateException("too many thread-local indexed variables");
    }

    private d() {
        super(m());
    }

    private static Object[] m() {
        Object[] objArr = new Object[32];
        Arrays.fill(objArr, f4680a);
        return objArr;
    }

    public Map<Charset, CharsetEncoder> e() {
        Map<Charset, CharsetEncoder> map = this.k;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.k = identityHashMap;
        return identityHashMap;
    }

    public int f() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public r g() {
        r rVar = this.h;
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r();
        this.h = rVar2;
        return rVar2;
    }

    public Map<Class<?>, t> h() {
        Map<Class<?>, t> map = this.i;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.i = identityHashMap;
        return identityHashMap;
    }

    public Map<Class<?>, Map<String, t>> i() {
        Map<Class<?>, Map<String, t>> map = this.j;
        if (map != null) {
            return map;
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        this.j = identityHashMap;
        return identityHashMap;
    }

    public c j() {
        return this.g;
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public Map<Class<?>, Boolean> k() {
        Map<Class<?>, Boolean> map = this.f;
        if (map != null) {
            return map;
        }
        WeakHashMap weakHashMap = new WeakHashMap(4);
        this.f = weakHashMap;
        return weakHashMap;
    }

    public Object b(int i) {
        Object[] objArr = this.d;
        return i < objArr.length ? objArr[i] : f4680a;
    }

    public boolean a(int i, Object obj) {
        Object[] objArr = this.d;
        if (i < objArr.length) {
            Object obj2 = objArr[i];
            objArr[i] = obj;
            return obj2 == f4680a;
        }
        b(i, obj);
        return true;
    }

    private void b(int i, Object obj) {
        Object[] objArr = this.d;
        int length = objArr.length;
        int i2 = (i >>> 1) | i;
        int i3 = i2 | (i2 >>> 2);
        int i4 = i3 | (i3 >>> 4);
        int i5 = i4 | (i4 >>> 8);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, (i5 | (i5 >>> 16)) + 1);
        Arrays.fill(objArrCopyOf, length, objArrCopyOf.length, f4680a);
        objArrCopyOf[i] = obj;
        this.d = objArrCopyOf;
    }

    public Object c(int i) {
        Object[] objArr = this.d;
        if (i < objArr.length) {
            Object obj = objArr[i];
            objArr[i] = f4680a;
            return obj;
        }
        return f4680a;
    }
}
