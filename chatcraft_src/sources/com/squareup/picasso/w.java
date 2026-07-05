package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.t;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Request.java */
/* loaded from: classes.dex */
public final class w {
    private static final long u = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a, reason: collision with root package name */
    int f4167a;

    /* renamed from: b, reason: collision with root package name */
    long f4168b;
    int c;
    public final Uri d;
    public final int e;
    public final String f;
    public final List<ac> g;
    public final int h;
    public final int i;
    public final boolean j;
    public final int k;
    public final boolean l;
    public final boolean m;
    public final float n;
    public final float o;
    public final float p;
    public final boolean q;
    public final boolean r;
    public final Bitmap.Config s;
    public final t.e t;

    private w(Uri uri, int i, String str, List<ac> list, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, float f, float f2, float f3, boolean z4, boolean z5, Bitmap.Config config, t.e eVar) {
        this.d = uri;
        this.e = i;
        this.f = str;
        if (list == null) {
            this.g = null;
        } else {
            this.g = Collections.unmodifiableList(list);
        }
        this.h = i2;
        this.i = i3;
        this.j = z;
        this.l = z2;
        this.k = i4;
        this.m = z3;
        this.n = f;
        this.o = f2;
        this.p = f3;
        this.q = z4;
        this.r = z5;
        this.s = config;
        this.t = eVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        if (this.e > 0) {
            sb.append(this.e);
        } else {
            sb.append(this.d);
        }
        if (this.g != null && !this.g.isEmpty()) {
            for (ac acVar : this.g) {
                sb.append(' ');
                sb.append(acVar.a());
            }
        }
        if (this.f != null) {
            sb.append(" stableKey(");
            sb.append(this.f);
            sb.append(')');
        }
        if (this.h > 0) {
            sb.append(" resize(");
            sb.append(this.h);
            sb.append(',');
            sb.append(this.i);
            sb.append(')');
        }
        if (this.j) {
            sb.append(" centerCrop");
        }
        if (this.l) {
            sb.append(" centerInside");
        }
        if (this.n != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.n);
            if (this.q) {
                sb.append(" @ ");
                sb.append(this.o);
                sb.append(',');
                sb.append(this.p);
            }
            sb.append(')');
        }
        if (this.r) {
            sb.append(" purgeable");
        }
        if (this.s != null) {
            sb.append(' ');
            sb.append(this.s);
        }
        sb.append('}');
        return sb.toString();
    }

    String a() {
        long jNanoTime = System.nanoTime() - this.f4168b;
        if (jNanoTime > u) {
            return b() + '+' + TimeUnit.NANOSECONDS.toSeconds(jNanoTime) + 's';
        }
        return b() + '+' + TimeUnit.NANOSECONDS.toMillis(jNanoTime) + "ms";
    }

    String b() {
        return "[R" + this.f4167a + ']';
    }

    String c() {
        if (this.d != null) {
            return String.valueOf(this.d.getPath());
        }
        return Integer.toHexString(this.e);
    }

    public boolean d() {
        return (this.h == 0 && this.i == 0) ? false : true;
    }

    boolean e() {
        return f() || g();
    }

    boolean f() {
        return d() || this.n != 0.0f;
    }

    boolean g() {
        return this.g != null;
    }

    /* compiled from: Request.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Uri f4169a;

        /* renamed from: b, reason: collision with root package name */
        private int f4170b;
        private String c;
        private int d;
        private int e;
        private boolean f;
        private int g;
        private boolean h;
        private boolean i;
        private float j;
        private float k;
        private float l;
        private boolean m;
        private boolean n;
        private List<ac> o;
        private Bitmap.Config p;
        private t.e q;

        a(Uri uri, int i, Bitmap.Config config) {
            this.f4169a = uri;
            this.f4170b = i;
            this.p = config;
        }

        boolean a() {
            return (this.f4169a == null && this.f4170b == 0) ? false : true;
        }

        boolean b() {
            return (this.d == 0 && this.e == 0) ? false : true;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            }
            this.d = i;
            this.e = i2;
            return this;
        }

        public w c() {
            if (this.h && this.f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f && this.d == 0 && this.e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (this.h && this.d == 0 && this.e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (this.q == null) {
                this.q = t.e.NORMAL;
            }
            return new w(this.f4169a, this.f4170b, this.c, this.o, this.d, this.e, this.f, this.h, this.g, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q);
        }
    }
}
