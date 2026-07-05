package io.netty.util.a;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* compiled from: Cleaner0.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final long f4625b;
    private static final Method c;
    private static final boolean d;

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f4624a = !a.class.desiredAssertionStatus();
    private static final io.netty.util.a.b.c e = io.netty.util.a.b.d.a((Class<?>) a.class);

    static {
        long jA;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(1);
        Method method = null;
        boolean z = false;
        if (m.b()) {
            try {
                Field declaredField = byteBufferAllocateDirect.getClass().getDeclaredField("cleaner");
                declaredField.setAccessible(true);
                jA = m.a(declaredField);
                Object obj = declaredField.get(byteBufferAllocateDirect);
                try {
                    ((Runnable) obj).run();
                    z = true;
                } catch (ClassCastException unused) {
                    Method declaredMethod = obj.getClass().getDeclaredMethod("clean", new Class[0]);
                    declaredMethod.invoke(obj, new Object[0]);
                    method = declaredMethod;
                }
            } catch (Throwable unused2) {
            }
        } else {
            jA = -1;
        }
        e.b("java.nio.ByteBuffer.cleaner(): {}", jA != -1 ? "available" : "unavailable");
        f4625b = jA;
        c = method;
        d = z;
        a(byteBufferAllocateDirect);
    }

    static void a(ByteBuffer byteBuffer) {
        if (f4625b == -1 || !byteBuffer.isDirect()) {
            return;
        }
        if (!f4624a && c == null && !d) {
            throw new AssertionError("CLEANER_FIELD_OFFSET != -1 implies CLEAN_METHOD != null or CLEANER_IS_RUNNABLE == true");
        }
        try {
            Object objA = m.a(byteBuffer, f4625b);
            if (objA != null) {
                if (d) {
                    ((Runnable) objA).run();
                } else {
                    c.invoke(objA, new Object[0]);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private a() {
    }
}
