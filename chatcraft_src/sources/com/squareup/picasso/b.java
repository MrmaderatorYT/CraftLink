package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.t;
import com.squareup.picasso.y;

/* compiled from: AssetRequestHandler.java */
/* loaded from: classes.dex */
class b extends y {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4111a = "file:///android_asset/".length();

    /* renamed from: b, reason: collision with root package name */
    private final Context f4112b;
    private final Object c = new Object();
    private AssetManager d;

    b(Context context) {
        this.f4112b = context;
    }

    @Override // com.squareup.picasso.y
    public boolean a(w wVar) {
        Uri uri = wVar.d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // com.squareup.picasso.y
    public y.a a(w wVar, int i) {
        if (this.d == null) {
            synchronized (this.c) {
                if (this.d == null) {
                    this.d = this.f4112b.getAssets();
                }
            }
        }
        return new y.a(b.l.a(this.d.open(b(wVar))), t.d.DISK);
    }

    static String b(w wVar) {
        return wVar.d.toString().substring(f4111a);
    }
}
