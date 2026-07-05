package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.a.a.c;
import androidx.core.a.a.f;
import androidx.core.d.b;

/* compiled from: TypefaceCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final h f658a;

    /* renamed from: b, reason: collision with root package name */
    private static final androidx.b.e<String, Typeface> f659b;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            f658a = new g();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f658a = new f();
        } else if (Build.VERSION.SDK_INT >= 24 && e.a()) {
            f658a = new e();
        } else if (Build.VERSION.SDK_INT >= 21) {
            f658a = new d();
        } else {
            f658a = new h();
        }
        f659b = new androidx.b.e<>(16);
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return f659b.a((androidx.b.e<String, Typeface>) b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i, int i2, f.a aVar2, Handler handler, boolean z) {
        Typeface typefaceA;
        if (aVar instanceof c.d) {
            c.d dVar = (c.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.b() == 0) {
                z2 = true;
            }
            typefaceA = androidx.core.d.b.a(context, dVar.a(), aVar2, handler, z2, z ? dVar.c() : -1, i2);
        } else {
            typefaceA = f658a.a(context, (c.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typefaceA != null) {
                    aVar2.a(typefaceA, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            f659b.a(b(resources, i, i2), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceA = f658a.a(context, resources, i, str, i2);
        if (typefaceA != null) {
            f659b.a(b(resources, i, i2), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.C0036b[] c0036bArr, int i) {
        return f658a.a(context, cancellationSignal, c0036bArr, i);
    }
}
