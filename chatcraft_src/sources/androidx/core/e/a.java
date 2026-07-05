package androidx.core.e;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f593a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f594b;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                f594b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                return;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f593a = cls.getMethod("getScript", String.class);
                f594b = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e2) {
            f593a = null;
            f594b = null;
            Log.w("ICUCompat", e2);
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f594b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            } catch (InvocationTargetException e2) {
                Log.w("ICUCompat", e2);
                return locale.getScript();
            }
        }
        String strB = b(locale);
        if (strB != null) {
            return a(strB);
        }
        return null;
    }

    private static String a(String str) {
        try {
            if (f593a != null) {
                return (String) f593a.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return null;
    }

    private static String b(Locale locale) {
        String string = locale.toString();
        try {
            if (f594b != null) {
                return (String) f594b.invoke(null, string);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
        }
        return string;
    }
}
