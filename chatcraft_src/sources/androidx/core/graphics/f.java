package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import androidx.core.a.a.c;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* compiled from: TypefaceCompatApi26Impl.java */
/* loaded from: classes.dex */
public class f extends d {

    /* renamed from: a, reason: collision with root package name */
    protected final Class f670a;

    /* renamed from: b, reason: collision with root package name */
    protected final Constructor f671b;
    protected final Method c;
    protected final Method d;
    protected final Method e;
    protected final Method f;
    protected final Method g;

    public f() {
        Constructor constructorA;
        Method methodB;
        Method methodC;
        Method methodD;
        Method methodE;
        Method methodF;
        Class cls = null;
        try {
            Class clsA = a();
            constructorA = a(clsA);
            methodB = b(clsA);
            methodC = c(clsA);
            methodD = d(clsA);
            methodE = e(clsA);
            methodF = f(clsA);
            cls = clsA;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            constructorA = null;
            methodB = null;
            methodC = null;
            methodD = null;
            methodE = null;
            methodF = null;
        }
        this.f670a = cls;
        this.f671b = constructorA;
        this.c = methodB;
        this.d = methodC;
        this.e = methodD;
        this.f = methodE;
        this.g = methodF;
    }

    private boolean b() {
        if (this.c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.c != null;
    }

    private Object c() {
        try {
            return this.f671b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Typeface a(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f670a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.g.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean b(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void c(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // androidx.core.graphics.h
    public Typeface a(Context context, c.b bVar, Resources resources, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!b()) {
            return super.a(context, bVar, resources, i);
        }
        Object objC = c();
        for (c.C0034c c0034c : bVar.a()) {
            if (!a(context, objC, c0034c.a(), c0034c.e(), c0034c.b(), c0034c.c() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0034c.d()))) {
                c(objC);
                return null;
            }
        }
        if (b(objC)) {
            return a(objC);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[Catch: IOException -> 0x0063, SYNTHETIC, TRY_LEAVE, TryCatch #2 {IOException -> 0x0063, blocks: (B:8:0x0014, B:11:0x0022, B:15:0x0045, B:25:0x0056, B:29:0x005f, B:28:0x005b, B:30:0x0062), top: B:53:0x0014, inners: #0 }] */
    @Override // androidx.core.graphics.d, androidx.core.graphics.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface a(android.content.Context r12, android.os.CancellationSignal r13, androidx.core.d.b.C0036b[] r14, int r15) throws java.lang.Throwable {
        /*
            r11 = this;
            int r0 = r14.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L6
            return r2
        L6:
            boolean r0 = r11.b()
            if (r0 != 0) goto L64
            androidx.core.d.b$b r14 = r11.a(r14, r15)
            android.content.ContentResolver r12 = r12.getContentResolver()
            android.net.Uri r15 = r14.a()     // Catch: java.io.IOException -> L63
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r12 = r12.openFileDescriptor(r15, r0, r13)     // Catch: java.io.IOException -> L63
            if (r12 != 0) goto L26
            if (r12 == 0) goto L25
            r12.close()     // Catch: java.io.IOException -> L63
        L25:
            return r2
        L26:
            android.graphics.Typeface$Builder r13 = new android.graphics.Typeface$Builder     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            java.io.FileDescriptor r15 = r12.getFileDescriptor()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            r13.<init>(r15)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            int r15 = r14.c()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface$Builder r13 = r13.setWeight(r15)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            boolean r14 = r14.d()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface$Builder r13 = r13.setItalic(r14)     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            android.graphics.Typeface r13 = r13.build()     // Catch: java.lang.Throwable -> L49 java.lang.Throwable -> L4c
            if (r12 == 0) goto L48
            r12.close()     // Catch: java.io.IOException -> L63
        L48:
            return r13
        L49:
            r13 = move-exception
            r14 = r2
            goto L52
        L4c:
            r13 = move-exception
            throw r13     // Catch: java.lang.Throwable -> L4e
        L4e:
            r14 = move-exception
            r10 = r14
            r14 = r13
            r13 = r10
        L52:
            if (r12 == 0) goto L62
            if (r14 == 0) goto L5f
            r12.close()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L63
            goto L62
        L5a:
            r12 = move-exception
            r14.addSuppressed(r12)     // Catch: java.io.IOException -> L63
            goto L62
        L5f:
            r12.close()     // Catch: java.io.IOException -> L63
        L62:
            throw r13     // Catch: java.io.IOException -> L63
        L63:
            return r2
        L64:
            java.util.Map r12 = androidx.core.d.b.a(r12, r14, r13)
            java.lang.Object r13 = r11.c()
            int r0 = r14.length
            r3 = 0
            r9 = 0
        L6f:
            if (r9 >= r0) goto L9c
            r4 = r14[r9]
            android.net.Uri r5 = r4.a()
            java.lang.Object r5 = r12.get(r5)
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            if (r5 != 0) goto L80
            goto L99
        L80:
            int r6 = r4.b()
            int r7 = r4.c()
            boolean r8 = r4.d()
            r3 = r11
            r4 = r13
            boolean r3 = r3.a(r4, r5, r6, r7, r8)
            if (r3 != 0) goto L98
            r11.c(r13)
            return r2
        L98:
            r3 = 1
        L99:
            int r9 = r9 + 1
            goto L6f
        L9c:
            if (r3 != 0) goto La2
            r11.c(r13)
            return r2
        La2:
            boolean r12 = r11.b(r13)
            if (r12 != 0) goto La9
            return r2
        La9:
            android.graphics.Typeface r12 = r11.a(r13)
            android.graphics.Typeface r12 = android.graphics.Typeface.create(r12, r15)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.f.a(android.content.Context, android.os.CancellationSignal, androidx.core.d.b$b[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.graphics.h
    public Typeface a(Context context, Resources resources, int i, String str, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!b()) {
            return super.a(context, resources, i, str, i2);
        }
        Object objC = c();
        if (!a(context, objC, str, 0, -1, -1, null)) {
            c(objC);
            return null;
        }
        if (b(objC)) {
            return a(objC);
        }
        return null;
    }

    protected Class a() {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor a(Class cls) {
        return cls.getConstructor(new Class[0]);
    }

    protected Method b(Class cls) {
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method c(Class cls) {
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method d(Class cls) {
        return cls.getMethod("freeze", new Class[0]);
    }

    protected Method e(Class cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method f(Class cls) throws NoSuchMethodException, SecurityException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
