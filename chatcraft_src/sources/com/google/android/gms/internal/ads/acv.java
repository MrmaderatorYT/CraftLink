package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class acv extends FrameLayout implements acs {

    /* renamed from: a, reason: collision with root package name */
    private final adk f1846a;

    /* renamed from: b, reason: collision with root package name */
    private final FrameLayout f1847b;
    private final ac c;
    private final adn d;
    private final long e;
    private act f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private long l;
    private String m;
    private Bitmap n;
    private ImageView o;
    private boolean p;

    public static void a(adk adkVar) {
        HashMap map = new HashMap();
        map.put("event", "no_video_view");
        adkVar.a("onVideoEvent", map);
    }

    public static void a(adk adkVar, Map<String, List<Map<String, Object>>> map) {
        HashMap map2 = new HashMap();
        map2.put("event", "decoderProps");
        map2.put("mimeTypes", map);
        adkVar.a("onVideoEvent", map2);
    }

    public static void a(adk adkVar, String str) {
        HashMap map = new HashMap();
        map.put("event", "decoderProps");
        map.put("error", str);
        adkVar.a("onVideoEvent", map);
    }

    public acv(Context context, adk adkVar, int i, boolean z, ac acVar, adj adjVar) {
        super(context);
        this.f1846a = adkVar;
        this.c = acVar;
        this.f1847b = new FrameLayout(context);
        addView(this.f1847b, new FrameLayout.LayoutParams(-1, -1));
        com.google.android.gms.common.internal.i.a(adkVar.e());
        this.f = adkVar.e().f1566b.a(context, adkVar, i, z, acVar, adjVar);
        if (this.f != null) {
            this.f1847b.addView(this.f, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) bra.e().a(o.w)).booleanValue()) {
                m();
            }
        }
        this.o = new ImageView(context);
        this.e = ((Long) bra.e().a(o.A)).longValue();
        this.j = ((Boolean) bra.e().a(o.y)).booleanValue();
        if (this.c != null) {
            this.c.a("spinner_used", this.j ? "1" : "0");
        }
        this.d = new adn(this);
        if (this.f != null) {
            this.f.a(this);
        }
        if (this.f == null) {
            a("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.f1847b.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void a(String str) {
        this.m = str;
    }

    public final void a(float f, float f2) {
        if (this.f != null) {
            this.f.a(f, f2);
        }
    }

    public final void h() {
        if (this.f == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.m)) {
            this.f.setVideoPath(this.m);
        } else {
            a("no_src", new String[0]);
        }
    }

    public final void i() {
        if (this.f == null) {
            return;
        }
        this.f.d();
    }

    public final void j() {
        if (this.f == null) {
            return;
        }
        this.f.c();
    }

    public final void a(int i) {
        if (this.f == null) {
            return;
        }
        this.f.a(i);
    }

    public final void k() {
        if (this.f == null) {
            return;
        }
        act actVar = this.f;
        actVar.f1845b.a(true);
        actVar.e();
    }

    public final void l() {
        if (this.f == null) {
            return;
        }
        act actVar = this.f;
        actVar.f1845b.a(false);
        actVar.e();
    }

    public final void setVolume(float f) {
        if (this.f == null) {
            return;
        }
        act actVar = this.f;
        actVar.f1845b.a(f);
        actVar.e();
    }

    public final void b(int i) {
        this.f.c(i);
    }

    public final void c(int i) {
        this.f.d(i);
    }

    public final void d(int i) {
        this.f.e(i);
    }

    public final void e(int i) {
        this.f.f(i);
    }

    @TargetApi(14)
    public final void a(MotionEvent motionEvent) {
        if (this.f == null) {
            return;
        }
        this.f.dispatchTouchEvent(motionEvent);
    }

    @TargetApi(14)
    public final void m() {
        if (this.f == null) {
            return;
        }
        TextView textView = new TextView(this.f.getContext());
        String strValueOf = String.valueOf(this.f.a());
        textView.setText(strValueOf.length() != 0 ? "AdMob - ".concat(strValueOf) : new String("AdMob - "));
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        this.f1847b.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.f1847b.bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.acs
    public final void a() {
        this.d.b();
        xn.f3583a.post(new acy(this));
    }

    @Override // com.google.android.gms.internal.ads.acs
    public final void b() {
        if (this.f != null && this.l == 0) {
            a("canplaythrough", "duration", String.valueOf(this.f.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.f.getVideoWidth()), "videoHeight", String.valueOf(this.f.getVideoHeight()));
        }
    }

    @Override // com.google.android.gms.internal.ads.acs
    public final void c() {
        if (this.f1846a.d() != null && !this.h) {
            this.i = (this.f1846a.d().getWindow().getAttributes().flags & 128) != 0;
            if (!this.i) {
                this.f1846a.d().getWindow().addFlags(128);
                this.h = true;
            }
        }
        this.g = true;
    }

    @Override // com.google.android.gms.internal.ads.acs
    public final void d() {
        a("pause", new String[0]);
        q();
        this.g = false;
    }

    @Override // com.google.android.gms.internal.ads.acs
    public final void e() {
        a("ended", new String[0]);
        q();
    }

    @Override // com.google.android.gms.internal.ads.acs
    public final void a(String str, String str2) {
        a("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.acs
    public final void f() {
        if (this.p && this.n != null && !p()) {
            this.o.setImageBitmap(this.n);
            this.o.invalidate();
            this.f1847b.addView(this.o, new FrameLayout.LayoutParams(-1, -1));
            this.f1847b.bringChildToFront(this.o);
        }
        this.d.a();
        this.l = this.k;
        xn.f3583a.post(new acz(this));
    }

    public final void n() {
        this.d.a();
        if (this.f != null) {
            this.f.b();
        }
        q();
    }

    public final void finalize() throws Throwable {
        try {
            this.d.a();
            if (this.f != null) {
                act actVar = this.f;
                Executor executor = abq.f1816a;
                actVar.getClass();
                executor.execute(acw.a(actVar));
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    final void o() {
        if (this.f == null) {
            return;
        }
        long currentPosition = this.f.getCurrentPosition();
        if (this.k == currentPosition || currentPosition <= 0) {
            return;
        }
        a("timeupdate", "time", String.valueOf(currentPosition / 1000.0f));
        this.k = currentPosition;
    }

    @Override // com.google.android.gms.internal.ads.acs
    public final void g() {
        if (this.g && p()) {
            this.f1847b.removeView(this.o);
        }
        if (this.n != null) {
            long jB = com.google.android.gms.ads.internal.ax.l().b();
            if (this.f.getBitmap(this.n) != null) {
                this.p = true;
            }
            long jB2 = com.google.android.gms.ads.internal.ax.l().b() - jB;
            if (xe.a()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(jB2);
                sb.append("ms");
                xe.a(sb.toString());
            }
            if (jB2 > this.e) {
                xe.e("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.j = false;
                this.n = null;
                if (this.c != null) {
                    this.c.a("spinner_jank", Long.toString(jB2));
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.acs
    public final void a(int i, int i2) {
        if (this.j) {
            int iMax = Math.max(i / ((Integer) bra.e().a(o.z)).intValue(), 1);
            int iMax2 = Math.max(i2 / ((Integer) bra.e().a(o.z)).intValue(), 1);
            if (this.n != null && this.n.getWidth() == iMax && this.n.getHeight() == iMax2) {
                return;
            }
            this.n = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            this.p = false;
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.d.b();
        } else {
            this.d.a();
            this.l = this.k;
        }
        xn.f3583a.post(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.acx

            /* renamed from: a, reason: collision with root package name */
            private final acv f1849a;

            /* renamed from: b, reason: collision with root package name */
            private final boolean f1850b;

            {
                this.f1849a = this;
                this.f1850b = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1849a.a(this.f1850b);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.acs
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.d.b();
            z = true;
        } else {
            this.d.a();
            this.l = this.k;
            z = false;
        }
        xn.f3583a.post(new ada(this, z));
    }

    private final boolean p() {
        return this.o.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, String... strArr) {
        HashMap map = new HashMap();
        map.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                map.put(str2, str3);
                str2 = null;
            }
        }
        this.f1846a.a("onVideoEvent", map);
    }

    private final void q() {
        if (this.f1846a.d() == null || !this.h || this.i) {
            return;
        }
        this.f1846a.d().getWindow().clearFlags(128);
        this.h = false;
    }

    final /* synthetic */ void a(boolean z) {
        a("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }
}
