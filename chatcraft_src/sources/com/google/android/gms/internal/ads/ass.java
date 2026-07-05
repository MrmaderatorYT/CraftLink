package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
final class ass {

    /* renamed from: a, reason: collision with root package name */
    private static final ass f2234a = new ass();

    /* renamed from: b, reason: collision with root package name */
    private final asy f2235b;
    private final ConcurrentMap<Class<?>, asx<?>> c = new ConcurrentHashMap();

    public static ass a() {
        return f2234a;
    }

    public final <T> asx<T> a(Class<T> cls) {
        ara.a(cls, "messageType");
        asx<T> asxVar = (asx) this.c.get(cls);
        if (asxVar != null) {
            return asxVar;
        }
        asx<T> asxVarA = this.f2235b.a(cls);
        ara.a(cls, "messageType");
        ara.a(asxVarA, "schema");
        asx<T> asxVar2 = (asx) this.c.putIfAbsent(cls, asxVarA);
        return asxVar2 != null ? asxVar2 : asxVarA;
    }

    public final <T> asx<T> a(T t) {
        return a((Class) t.getClass());
    }

    private ass() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        asy asyVarA = null;
        for (int i = 0; i <= 0; i++) {
            asyVarA = a(strArr[0]);
            if (asyVarA != null) {
                break;
            }
        }
        this.f2235b = asyVarA == null ? new aru() : asyVarA;
    }

    private static asy a(String str) {
        try {
            return (asy) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }
}
