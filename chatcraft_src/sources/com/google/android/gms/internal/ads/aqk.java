package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class aqk {

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f2169b = false;
    private static volatile aqk d;
    private final Map<a, aqy.d<?, ?>> e;
    private static final Class<?> c = d();

    /* renamed from: a, reason: collision with root package name */
    static final aqk f2168a = new aqk(true);

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f2170a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2171b;

        a(Object obj, int i) {
            this.f2170a = obj;
            this.f2171b = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f2170a) * 65535) + this.f2171b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2170a == aVar.f2170a && this.f2171b == aVar.f2171b;
        }
    }

    public static aqk a() {
        return aqj.a();
    }

    public static aqk b() {
        aqk aqkVarB = d;
        if (aqkVarB == null) {
            synchronized (aqk.class) {
                aqkVarB = d;
                if (aqkVarB == null) {
                    aqkVarB = aqj.b();
                    d = aqkVarB;
                }
            }
        }
        return aqkVarB;
    }

    static aqk c() {
        return aqw.a(aqk.class);
    }

    public final <ContainingType extends asf> aqy.d<ContainingType, ?> a(ContainingType containingtype, int i) {
        return (aqy.d) this.e.get(new a(containingtype, i));
    }

    aqk() {
        this.e = new HashMap();
    }

    private aqk(boolean z) {
        this.e = Collections.emptyMap();
    }
}
