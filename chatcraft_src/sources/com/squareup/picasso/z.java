package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import java.io.FileNotFoundException;

/* compiled from: ResourceRequestHandler.java */
/* loaded from: classes.dex */
class z extends y {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4175a;

    z(Context context) {
        this.f4175a = context;
    }

    @Override // com.squareup.picasso.y
    public boolean a(w wVar) {
        if (wVar.e != 0) {
            return true;
        }
        return "android.resource".equals(wVar.d.getScheme());
    }

    @Override // com.squareup.picasso.y
    public y.a a(w wVar, int i) throws FileNotFoundException {
        Resources resourcesA = ad.a(this.f4175a, wVar);
        return new y.a(a(resourcesA, ad.a(resourcesA, wVar), wVar), t.d.DISK);
    }

    private static Bitmap a(Resources resources, int i, w wVar) {
        BitmapFactory.Options optionsC = c(wVar);
        if (a(optionsC)) {
            BitmapFactory.decodeResource(resources, i, optionsC);
            a(wVar.h, wVar.i, optionsC, wVar);
        }
        return BitmapFactory.decodeResource(resources, i, optionsC);
    }
}
