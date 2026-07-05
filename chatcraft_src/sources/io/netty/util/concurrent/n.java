package io.netty.util.concurrent;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* compiled from: FastThreadLocal.java */
/* loaded from: classes.dex */
public class n<V> {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4745a = io.netty.util.a.d.d();

    /* renamed from: b, reason: collision with root package name */
    private final int f4746b = io.netty.util.a.d.d();

    protected void a(V v) {
    }

    protected V b() {
        return null;
    }

    public static void c() {
        io.netty.util.a.d dVarA = io.netty.util.a.d.a();
        if (dVarA == null) {
            return;
        }
        try {
            Object objB = dVarA.b(f4745a);
            if (objB != null && objB != io.netty.util.a.d.f4680a) {
                Set set = (Set) objB;
                for (n nVar : (n[]) set.toArray(new n[set.size()])) {
                    nVar.b(dVarA);
                }
            }
        } finally {
            io.netty.util.a.d.c();
        }
    }

    private static void a(io.netty.util.a.d dVar, n<?> nVar) {
        Set setNewSetFromMap;
        Object objB = dVar.b(f4745a);
        if (objB == io.netty.util.a.d.f4680a || objB == null) {
            setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
            dVar.a(f4745a, setNewSetFromMap);
        } else {
            setNewSetFromMap = (Set) objB;
        }
        setNewSetFromMap.add(nVar);
    }

    private static void b(io.netty.util.a.d dVar, n<?> nVar) {
        Object objB = dVar.b(f4745a);
        if (objB == io.netty.util.a.d.f4680a || objB == null) {
            return;
        }
        ((Set) objB).remove(nVar);
    }

    public final V d() {
        return a(io.netty.util.a.d.b());
    }

    public final V a(io.netty.util.a.d dVar) {
        V v = (V) dVar.b(this.f4746b);
        return v != io.netty.util.a.d.f4680a ? v : c(dVar);
    }

    private V c(io.netty.util.a.d dVar) throws Throwable {
        V vB;
        try {
            vB = b();
        } catch (Exception e) {
            io.netty.util.a.l.a(e);
            vB = null;
        }
        dVar.a(this.f4746b, vB);
        a(dVar, (n<?>) this);
        return vB;
    }

    public final void a(io.netty.util.a.d dVar, V v) throws Throwable {
        if (v != io.netty.util.a.d.f4680a) {
            if (dVar.a(this.f4746b, v)) {
                a(dVar, (n<?>) this);
                return;
            }
            return;
        }
        b(dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(io.netty.util.a.d dVar) throws Throwable {
        if (dVar == null) {
            return;
        }
        Object objC = dVar.c(this.f4746b);
        b(dVar, this);
        if (objC != io.netty.util.a.d.f4680a) {
            try {
                a((n<V>) objC);
            } catch (Exception e) {
                io.netty.util.a.l.a(e);
            }
        }
    }
}
