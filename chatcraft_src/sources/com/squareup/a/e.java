package com.squareup.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: EventProducer.java */
/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    final Object f4093a;

    /* renamed from: b, reason: collision with root package name */
    private final Method f4094b;
    private final int c;
    private boolean d = true;

    e(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventProducer target cannot be null.");
        }
        if (method == null) {
            throw new NullPointerException("EventProducer method cannot be null.");
        }
        this.f4093a = obj;
        this.f4094b = method;
        method.setAccessible(true);
        this.c = ((method.hashCode() + 31) * 31) + obj.hashCode();
    }

    public boolean a() {
        return this.d;
    }

    public void b() {
        this.d = false;
    }

    public Object c() throws InvocationTargetException {
        if (!this.d) {
            throw new IllegalStateException(toString() + " has been invalidated and can no longer produce events.");
        }
        try {
            return this.f4094b.invoke(this.f4093a, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof Error) {
                throw ((Error) e2.getCause());
            }
            throw e2;
        }
    }

    public String toString() {
        return "[EventProducer " + this.f4094b + "]";
    }

    public int hashCode() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f4094b.equals(eVar.f4094b) && this.f4093a == eVar.f4093a;
    }
}
