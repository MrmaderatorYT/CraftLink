package com.squareup.picasso;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.TypedValue;
import android.widget.ImageView;
import com.squareup.picasso.t;
import com.squareup.picasso.w;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestCreator.java */
/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f4171a = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    private final t f4172b;
    private final w.a c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private Drawable k;
    private Drawable l;
    private Object m;

    x(t tVar, Uri uri, int i) {
        this.f = true;
        if (tVar.m) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f4172b = tVar;
        this.c = new w.a(uri, i, tVar.j);
    }

    x() {
        this.f = true;
        this.f4172b = null;
        this.c = new w.a(null, 0, null);
    }

    public x a(int i) {
        if (!this.f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        }
        if (i == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        }
        if (this.k != null) {
            throw new IllegalStateException("Placeholder image already set.");
        }
        this.g = i;
        return this;
    }

    x a() {
        this.e = false;
        return this;
    }

    x b() {
        this.m = null;
        return this;
    }

    public x a(int i, int i2) {
        this.c.a(i, i2);
        return this;
    }

    public x a(String str) {
        this.c.a(str);
        return this;
    }

    public void a(ImageView imageView) {
        a(imageView, (e) null);
    }

    public void a(ImageView imageView, e eVar) {
        Bitmap bitmapB;
        long jNanoTime = System.nanoTime();
        ad.a();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (!this.c.a()) {
            this.f4172b.a(imageView);
            if (this.f) {
                u.a(imageView, c());
                return;
            }
            return;
        }
        if (this.e) {
            if (this.c.b()) {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                if (this.f) {
                    u.a(imageView, c());
                }
                this.f4172b.a(imageView, new h(this, imageView, eVar));
                return;
            }
            this.c.a(width, height);
        }
        w wVarA = a(jNanoTime);
        String strA = ad.a(wVarA);
        if (p.a(this.i) && (bitmapB = this.f4172b.b(strA)) != null) {
            this.f4172b.a(imageView);
            u.a(imageView, this.f4172b.c, bitmapB, t.d.MEMORY, this.d, this.f4172b.k);
            if (this.f4172b.l) {
                ad.a("Main", "completed", wVarA.b(), "from " + t.d.MEMORY);
            }
            if (eVar != null) {
                eVar.a();
                return;
            }
            return;
        }
        if (this.f) {
            u.a(imageView, c());
        }
        this.f4172b.a((a) new l(this.f4172b, imageView, wVarA, this.i, this.j, this.h, this.l, strA, this.m, eVar, this.d));
    }

    private Drawable c() throws Resources.NotFoundException {
        if (this.g != 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.f4172b.c.getDrawable(this.g);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return this.f4172b.c.getResources().getDrawable(this.g);
            }
            TypedValue typedValue = new TypedValue();
            this.f4172b.c.getResources().getValue(this.g, typedValue, true);
            return this.f4172b.c.getResources().getDrawable(typedValue.resourceId);
        }
        return this.k;
    }

    private w a(long j) {
        int andIncrement = f4171a.getAndIncrement();
        w wVarC = this.c.c();
        wVarC.f4167a = andIncrement;
        wVarC.f4168b = j;
        boolean z = this.f4172b.l;
        if (z) {
            ad.a("Main", "created", wVarC.b(), wVarC.toString());
        }
        w wVarA = this.f4172b.a(wVarC);
        if (wVarA != wVarC) {
            wVarA.f4167a = andIncrement;
            wVarA.f4168b = j;
            if (z) {
                ad.a("Main", "changed", wVarA.a(), "into " + wVarA);
            }
        }
        return wVarA;
    }
}
