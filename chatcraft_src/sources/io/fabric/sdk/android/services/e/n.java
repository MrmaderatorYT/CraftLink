package io.fabric.sdk.android.services.e;

import android.content.Context;
import android.graphics.BitmapFactory;

/* compiled from: IconRequest.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f4308a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4309b;
    public final int c;
    public final int d;

    public n(String str, int i, int i2, int i3) {
        this.f4308a = str;
        this.f4309b = i;
        this.c = i2;
        this.d = i3;
    }

    public static n a(Context context, String str) {
        if (str != null) {
            try {
                int iL = io.fabric.sdk.android.services.b.i.l(context);
                io.fabric.sdk.android.c.g().a("Fabric", "App icon resource ID is " + iL);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), iL, options);
                return new n(str, iL, options.outWidth, options.outHeight);
            } catch (Exception e) {
                io.fabric.sdk.android.c.g().e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
