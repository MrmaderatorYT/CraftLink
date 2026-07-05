package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import java.nio.ByteBuffer;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@TargetApi(16)
/* loaded from: classes.dex */
public final class adq extends act implements TextureView.SurfaceTextureListener, ael {
    private final adk c;
    private final adm d;
    private final boolean e;
    private final adj f;
    private acs g;
    private Surface h;
    private aee i;
    private String j;
    private boolean k;
    private int l;
    private adi m;
    private final boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private int t;
    private float u;

    public adq(Context context, adm admVar, adk adkVar, boolean z, boolean z2, adj adjVar) {
        super(context);
        this.l = 1;
        this.e = z2;
        this.c = adkVar;
        this.d = admVar;
        this.n = z;
        this.f = adjVar;
        setSurfaceTextureListener(this);
        this.d.a(this);
    }

    private final aee l() {
        return new aee(this.c.getContext(), this.f);
    }

    private final String m() {
        return com.google.android.gms.ads.internal.ax.e().b(this.c.getContext(), this.c.k().f1790a);
    }

    private final boolean n() {
        return (this.i == null || this.k) ? false : true;
    }

    private final boolean o() {
        return n() && this.l != 1;
    }

    private final void p() {
        if (this.i != null || this.j == null || this.h == null) {
            return;
        }
        if (this.j.startsWith("cache:")) {
            aex aexVarA = this.c.a(this.j);
            if (aexVarA instanceof afj) {
                this.i = ((afj) aexVarA).c();
            } else if (aexVarA instanceof afi) {
                afi afiVar = (afi) aexVarA;
                String strM = m();
                ByteBuffer byteBufferE = afiVar.e();
                boolean zD = afiVar.d();
                String strC = afiVar.c();
                if (strC == null) {
                    xe.e("Stream cache URL is null.");
                    return;
                } else {
                    this.i = l();
                    this.i.a(Uri.parse(strC), strM, byteBufferE, zD);
                }
            } else {
                String strValueOf = String.valueOf(this.j);
                xe.e(strValueOf.length() != 0 ? "Stream cache miss: ".concat(strValueOf) : new String("Stream cache miss: "));
                return;
            }
        } else {
            this.i = l();
            this.i.a(Uri.parse(this.j), m());
        }
        this.i.a((ael) this);
        a(this.h, false);
        this.l = this.i.a().a();
        if (this.l == 3) {
            q();
        }
    }

    private final void a(Surface surface, boolean z) {
        if (this.i != null) {
            this.i.a(surface, z);
        } else {
            xe.e("Trying to set surface before player is initalized.");
        }
    }

    private final void a(float f, boolean z) {
        if (this.i != null) {
            this.i.a(f, z);
        } else {
            xe.e("Trying to set volume before player is initalized.");
        }
    }

    @Override // com.google.android.gms.internal.ads.act, com.google.android.gms.internal.ads.adp
    public final void e() {
        a(this.f1845b.a(), false);
    }

    private final void q() {
        if (this.o) {
            return;
        }
        this.o = true;
        xn.f3583a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.adr

            /* renamed from: a, reason: collision with root package name */
            private final adq f1874a;

            {
                this.f1874a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1874a.k();
            }
        });
        e();
        this.d.a();
        if (this.p) {
            c();
        }
    }

    @Override // com.google.android.gms.internal.ads.act
    public final String a() {
        String strValueOf = String.valueOf("ExoPlayer/3");
        String strValueOf2 = String.valueOf(this.n ? " spherical" : BuildConfig.FLAVOR);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void a(acs acsVar) {
        this.g = acsVar;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void setVideoPath(String str) {
        if (str != null) {
            this.j = str;
            p();
        }
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void c() {
        if (o()) {
            if (this.f.f1866a) {
                s();
            }
            this.i.a().a(true);
            this.d.c();
            this.f1845b.b();
            this.f1844a.a();
            xn.f3583a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.adu

                /* renamed from: a, reason: collision with root package name */
                private final adq f1878a;

                {
                    this.f1878a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f1878a.i();
                }
            });
            return;
        }
        this.p = true;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void b() {
        if (n()) {
            this.i.a().c();
            if (this.i != null) {
                a((Surface) null, true);
                if (this.i != null) {
                    this.i.a((ael) null);
                    this.i.e();
                    this.i = null;
                }
                this.l = 1;
                this.k = false;
                this.o = false;
                this.p = false;
            }
        }
        this.d.d();
        this.f1845b.c();
        this.d.b();
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void d() {
        if (o()) {
            if (this.f.f1866a) {
                t();
            }
            this.i.a().a(false);
            this.d.d();
            this.f1845b.c();
            xn.f3583a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.adv

                /* renamed from: a, reason: collision with root package name */
                private final adq f1879a;

                {
                    this.f1879a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f1879a.h();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void a(int i) {
        if (o()) {
            this.i.a().a(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void c(int i) {
        if (this.i != null) {
            this.i.d().a(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void d(int i) {
        if (this.i != null) {
            this.i.d().b(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void e(int i) {
        if (this.i != null) {
            this.i.d().c(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void f(int i) {
        if (this.i != null) {
            this.i.d().d(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.act
    public final void a(float f, float f2) {
        if (this.m != null) {
            this.m.a(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.act
    public final int getCurrentPosition() {
        if (o()) {
            return (int) this.i.a().g();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final int getDuration() {
        if (o()) {
            return (int) this.i.a().f();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final int getVideoWidth() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.act
    public final int getVideoHeight() {
        return this.r;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.u != 0.0f && this.m == null) {
            float f = measuredWidth;
            float f2 = f / measuredHeight;
            if (this.u > f2) {
                measuredHeight = (int) (f / this.u);
            }
            if (this.u < f2) {
                measuredWidth = (int) (measuredHeight * this.u);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        if (this.m != null) {
            this.m.a(measuredWidth, measuredHeight);
        }
        if (Build.VERSION.SDK_INT == 16) {
            if (((this.s > 0 && this.s != measuredWidth) || (this.t > 0 && this.t != measuredHeight)) && this.e && n()) {
                azp azpVarA = this.i.a();
                if (azpVarA.g() > 0 && !azpVarA.b()) {
                    a(0.0f, true);
                    azpVarA.a(true);
                    long jG = azpVarA.g();
                    long jA = com.google.android.gms.ads.internal.ax.l().a();
                    while (n() && azpVarA.g() == jG && com.google.android.gms.ads.internal.ax.l().a() - jA <= 250) {
                    }
                    azpVarA.a(false);
                    e();
                }
            }
            this.s = measuredWidth;
            this.t = measuredHeight;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) throws InterruptedException {
        if (this.n) {
            this.m = new adi(getContext());
            this.m.a(surfaceTexture, i, i2);
            this.m.start();
            SurfaceTexture surfaceTextureC = this.m.c();
            if (surfaceTextureC != null) {
                surfaceTexture = surfaceTextureC;
            } else {
                this.m.b();
                this.m = null;
            }
        }
        this.h = new Surface(surfaceTexture);
        if (this.i == null) {
            p();
        } else {
            a(this.h, true);
            if (!this.f.f1866a) {
                s();
            }
        }
        r();
        xn.f3583a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.adw

            /* renamed from: a, reason: collision with root package name */
            private final adq f1880a;

            {
                this.f1880a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1880a.g();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        if (this.m != null) {
            this.m.a(i, i2);
        }
        xn.f3583a.post(new Runnable(this, i, i2) { // from class: com.google.android.gms.internal.ads.adx

            /* renamed from: a, reason: collision with root package name */
            private final adq f1881a;

            /* renamed from: b, reason: collision with root package name */
            private final int f1882b;
            private final int c;

            {
                this.f1881a = this;
                this.f1882b = i;
                this.c = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1881a.b(this.f1882b, this.c);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.d.b(this);
        this.f1844a.a(surfaceTexture, this.g);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        d();
        if (this.m != null) {
            this.m.b();
            this.m = null;
        }
        if (this.i != null) {
            t();
            if (this.h != null) {
                this.h.release();
            }
            this.h = null;
            a((Surface) null, true);
        }
        xn.f3583a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ady

            /* renamed from: a, reason: collision with root package name */
            private final adq f1883a;

            {
                this.f1883a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1883a.f();
            }
        });
        return true;
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        xe.a(sb.toString());
        xn.f3583a.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.adz

            /* renamed from: a, reason: collision with root package name */
            private final adq f1884a;

            /* renamed from: b, reason: collision with root package name */
            private final int f1885b;

            {
                this.f1884a = this;
                this.f1885b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1884a.g(this.f1885b);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.ael
    public final void a(final boolean z, final long j) {
        if (this.c != null) {
            abq.f1816a.execute(new Runnable(this, z, j) { // from class: com.google.android.gms.internal.ads.aea

                /* renamed from: a, reason: collision with root package name */
                private final adq f1887a;

                /* renamed from: b, reason: collision with root package name */
                private final boolean f1888b;
                private final long c;

                {
                    this.f1887a = this;
                    this.f1888b = z;
                    this.c = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f1887a.b(this.f1888b, this.c);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.ael
    public final void b(int i) {
        if (this.l != i) {
            this.l = i;
            switch (i) {
                case 3:
                    q();
                    break;
                case 4:
                    if (this.f.f1866a) {
                        t();
                    }
                    this.d.d();
                    this.f1845b.c();
                    xn.f3583a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ads

                        /* renamed from: a, reason: collision with root package name */
                        private final adq f1875a;

                        {
                            this.f1875a = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1875a.j();
                        }
                    });
                    break;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.ael
    public final void a(int i, int i2) {
        this.q = i;
        this.r = i2;
        r();
    }

    @Override // com.google.android.gms.internal.ads.ael
    public final void a(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        final String string = sb.toString();
        String strValueOf = String.valueOf(string);
        xe.e(strValueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(strValueOf) : new String("ExoPlayerAdapter error: "));
        this.k = true;
        if (this.f.f1866a) {
            t();
        }
        xn.f3583a.post(new Runnable(this, string) { // from class: com.google.android.gms.internal.ads.adt

            /* renamed from: a, reason: collision with root package name */
            private final adq f1876a;

            /* renamed from: b, reason: collision with root package name */
            private final String f1877b;

            {
                this.f1876a = this;
                this.f1877b = string;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1876a.a(this.f1877b);
            }
        });
    }

    private final void r() {
        float f = this.r > 0 ? this.q / this.r : 1.0f;
        if (this.u != f) {
            this.u = f;
            requestLayout();
        }
    }

    private final void s() {
        if (this.i != null) {
            this.i.b(true);
        }
    }

    private final void t() {
        if (this.i != null) {
            this.i.b(false);
        }
    }

    final /* synthetic */ void b(boolean z, long j) {
        this.c.a(z, j);
    }

    final /* synthetic */ void g(int i) {
        if (this.g != null) {
            this.g.onWindowVisibilityChanged(i);
        }
    }

    final /* synthetic */ void f() {
        if (this.g != null) {
            this.g.f();
        }
    }

    final /* synthetic */ void b(int i, int i2) {
        if (this.g != null) {
            this.g.a(i, i2);
        }
    }

    final /* synthetic */ void g() {
        if (this.g != null) {
            this.g.a();
        }
    }

    final /* synthetic */ void h() {
        if (this.g != null) {
            this.g.d();
        }
    }

    final /* synthetic */ void i() {
        if (this.g != null) {
            this.g.c();
        }
    }

    final /* synthetic */ void a(String str) {
        if (this.g != null) {
            this.g.a("ExoPlayerAdapter error", str);
        }
    }

    final /* synthetic */ void j() {
        if (this.g != null) {
            this.g.e();
        }
    }

    final /* synthetic */ void k() {
        if (this.g != null) {
            this.g.b();
        }
    }
}
