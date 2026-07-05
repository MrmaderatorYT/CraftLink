package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.t;

/* compiled from: RequestHandler.java */
/* loaded from: classes.dex */
public abstract class y {
    int a() {
        return 0;
    }

    public abstract a a(w wVar, int i);

    public abstract boolean a(w wVar);

    boolean a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    boolean b() {
        return false;
    }

    /* compiled from: RequestHandler.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final t.d f4173a;

        /* renamed from: b, reason: collision with root package name */
        private final Bitmap f4174b;
        private final b.s c;
        private final int d;

        public a(Bitmap bitmap, t.d dVar) {
            this((Bitmap) ad.a(bitmap, "bitmap == null"), null, dVar, 0);
        }

        public a(b.s sVar, t.d dVar) {
            this(null, (b.s) ad.a(sVar, "source == null"), dVar, 0);
        }

        a(Bitmap bitmap, b.s sVar, t.d dVar, int i) {
            if ((bitmap != null) == (sVar != null)) {
                throw new AssertionError();
            }
            this.f4174b = bitmap;
            this.c = sVar;
            this.f4173a = (t.d) ad.a(dVar, "loadedFrom == null");
            this.d = i;
        }

        public Bitmap a() {
            return this.f4174b;
        }

        public b.s b() {
            return this.c;
        }

        public t.d c() {
            return this.f4173a;
        }

        int d() {
            return this.d;
        }
    }

    static BitmapFactory.Options c(w wVar) {
        boolean zD = wVar.d();
        boolean z = wVar.s != null;
        BitmapFactory.Options options = null;
        if (zD || z || wVar.r) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = zD;
            options.inInputShareable = wVar.r;
            options.inPurgeable = wVar.r;
            if (z) {
                options.inPreferredConfig = wVar.s;
            }
        }
        return options;
    }

    static boolean a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static void a(int i, int i2, BitmapFactory.Options options, w wVar) {
        a(i, i2, options.outWidth, options.outHeight, options, wVar);
    }

    static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options, w wVar) {
        int iMin;
        if (i4 <= i2 && i3 <= i) {
            iMin = 1;
        } else if (i2 == 0) {
            iMin = (int) Math.floor(i3 / i);
        } else if (i == 0) {
            iMin = (int) Math.floor(i4 / i2);
        } else {
            int iFloor = (int) Math.floor(i4 / i2);
            int iFloor2 = (int) Math.floor(i3 / i);
            if (wVar.l) {
                iMin = Math.max(iFloor, iFloor2);
            } else {
                iMin = Math.min(iFloor, iFloor2);
            }
        }
        options.inSampleSize = iMin;
        options.inJustDecodeBounds = false;
    }
}
