package io.netty.util.a.c.a.a.b;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: UnsafeAccess.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f4676a;

    /* renamed from: b, reason: collision with root package name */
    public static final Unsafe f4677b;

    static {
        boolean z = false;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            f4677b = (Unsafe) declaredField.get(null);
            try {
                Unsafe.class.getMethod("getAndSetObject", Object.class, Long.TYPE, Object.class);
                z = true;
            } catch (Exception unused) {
            }
            f4676a = z;
        } catch (Exception e) {
            f4676a = false;
            throw new RuntimeException(e);
        }
    }
}
