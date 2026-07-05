package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.a.a.c;
import androidx.core.d.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl.java */
/* loaded from: classes.dex */
class e extends h {

    /* renamed from: a, reason: collision with root package name */
    private static final Class f668a;

    /* renamed from: b, reason: collision with root package name */
    private static final Constructor f669b;
    private static final Method c;
    private static final Method d;

    e() {
    }

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        f669b = constructor;
        f668a = cls;
        c = method2;
        d = method;
    }

    public static boolean a() {
        if (c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return c != null;
    }

    private static Object b() {
        try {
            return f669b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface a(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f668a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) d.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // androidx.core.graphics.h
    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0036b[] c0036bArr, int i) throws Throwable {
        Object objB = b();
        androidx.b.g gVar = new androidx.b.g();
        for (b.C0036b c0036b : c0036bArr) {
            Uri uriA = c0036b.a();
            ByteBuffer byteBufferA = (ByteBuffer) gVar.get(uriA);
            if (byteBufferA == null) {
                byteBufferA = i.a(context, cancellationSignal, uriA);
                gVar.put(uriA, byteBufferA);
            }
            if (!a(objB, byteBufferA, c0036b.b(), c0036b.c(), c0036b.d())) {
                return null;
            }
        }
        return Typeface.create(a(objB), i);
    }

    @Override // androidx.core.graphics.h
    public Typeface a(Context context, c.b bVar, Resources resources, int i) {
        Object objB = b();
        for (c.C0034c c0034c : bVar.a()) {
            ByteBuffer byteBufferA = i.a(context, resources, c0034c.f());
            if (byteBufferA == null || !a(objB, byteBufferA, c0034c.e(), c0034c.b(), c0034c.c())) {
                return null;
            }
        }
        return a(objB);
    }
}
