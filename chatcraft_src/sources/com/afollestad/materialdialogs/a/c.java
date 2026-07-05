package com.afollestad.materialdialogs.a;

import android.content.Context;
import android.graphics.Typeface;
import androidx.b.g;

/* compiled from: TypefaceHelper.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final g<String, Typeface> f1201a = new g<>();

    public static Typeface a(Context context, String str) {
        synchronized (f1201a) {
            if (!f1201a.containsKey(str)) {
                try {
                    Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s", str));
                    f1201a.put(str, typefaceCreateFromAsset);
                    return typefaceCreateFromAsset;
                } catch (RuntimeException unused) {
                    return null;
                }
            }
            return f1201a.get(str);
        }
    }
}
