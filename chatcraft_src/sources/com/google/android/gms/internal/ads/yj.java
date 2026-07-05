package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
public final class yj {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3600a;

    /* renamed from: b, reason: collision with root package name */
    private String f3601b;
    private String c;
    private String d;
    private String e;
    private final float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private float l;
    private float m;
    private float n;
    private float o;
    private Handler p;
    private Runnable q;

    public yj(Context context) {
        this.j = 0;
        this.q = new Runnable(this) { // from class: com.google.android.gms.internal.ads.yk

            /* renamed from: a, reason: collision with root package name */
            private final yj f3602a;

            {
                this.f3602a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3602a.d();
            }
        };
        this.f3600a = context;
        this.f = context.getResources().getDisplayMetrics().density;
        this.k = ViewConfiguration.get(this.f3600a).getScaledTouchSlop();
        com.google.android.gms.ads.internal.ax.u().a();
        this.p = com.google.android.gms.ads.internal.ax.u().b();
    }

    public yj(Context context, String str) {
        this(context);
        this.f3601b = str;
    }

    public final void a(MotionEvent motionEvent) {
        if (((Boolean) bra.e().a(o.ci)).booleanValue()) {
            int actionMasked = motionEvent.getActionMasked();
            int historySize = motionEvent.getHistorySize();
            int pointerCount = motionEvent.getPointerCount();
            if (actionMasked == 0) {
                this.j = 0;
                this.l = motionEvent.getX();
                this.m = motionEvent.getY();
                return;
            }
            if (this.j != -1) {
                boolean z = true;
                if (this.j == 0 && actionMasked == 5) {
                    this.j = 5;
                    this.n = motionEvent.getX(1);
                    this.o = motionEvent.getY(1);
                    this.p.postDelayed(this.q, ((Long) bra.e().a(o.cj)).longValue());
                    return;
                }
                if (this.j == 5) {
                    if (pointerCount == 2) {
                        if (actionMasked == 2) {
                            boolean z2 = false;
                            for (int i = 0; i < historySize; i++) {
                                if (!a(motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i), motionEvent.getHistoricalX(1, i), motionEvent.getHistoricalY(1, i))) {
                                    z2 = true;
                                }
                            }
                            if (a(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                                z = z2;
                            }
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        this.j = -1;
                        this.p.removeCallbacks(this.q);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        int historySize2 = motionEvent.getHistorySize();
        for (int i2 = 0; i2 < historySize2; i2++) {
            a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2));
        }
        a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }

    private final boolean a(float f, float f2, float f3, float f4) {
        return Math.abs(this.l - f) < ((float) this.k) && Math.abs(this.m - f2) < ((float) this.k) && Math.abs(this.n - f3) < ((float) this.k) && Math.abs(this.o - f4) < ((float) this.k);
    }

    private final void a(int i, float f, float f2) {
        if (i == 0) {
            this.j = 0;
            this.g = f;
            this.h = f2;
            this.i = f2;
            return;
        }
        if (this.j == -1) {
            return;
        }
        if (i != 2) {
            if (i == 1 && this.j == 4) {
                a();
                return;
            }
            return;
        }
        if (f2 > this.h) {
            this.h = f2;
        } else if (f2 < this.i) {
            this.i = f2;
        }
        if (this.h - this.i > this.f * 30.0f) {
            this.j = -1;
            return;
        }
        if (this.j == 0 || this.j == 2) {
            if (f - this.g >= this.f * 50.0f) {
                this.g = f;
                this.j++;
            }
        } else if ((this.j == 1 || this.j == 3) && f - this.g <= this.f * (-50.0f)) {
            this.g = f;
            this.j++;
        }
        if (this.j == 1 || this.j == 3) {
            if (f > this.g) {
                this.g = f;
            }
        } else {
            if (this.j != 2 || f >= this.g) {
                return;
            }
            this.g = f;
        }
    }

    public final void a() {
        try {
            if (!(this.f3600a instanceof Activity)) {
                xe.d("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(com.google.android.gms.ads.internal.ax.o().a()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = com.google.android.gms.ads.internal.ax.o().b() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            final int iA = a((List<String>) arrayList, "Ad Information", true);
            final int iA2 = a((List<String>) arrayList, str, true);
            final int iA3 = a((List<String>) arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f3600a, com.google.android.gms.ads.internal.ax.g().f());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener(this, iA, iA2, iA3) { // from class: com.google.android.gms.internal.ads.yl

                /* renamed from: a, reason: collision with root package name */
                private final yj f3603a;

                /* renamed from: b, reason: collision with root package name */
                private final int f3604b;
                private final int c;
                private final int d;

                {
                    this.f3603a = this;
                    this.f3604b = iA;
                    this.c = iA2;
                    this.d = iA3;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f3603a.a(this.f3604b, this.c, this.d, dialogInterface, i);
                }
            });
            builder.create().show();
        } catch (WindowManager.BadTokenException e) {
            if (xe.a()) {
                Log.v("Ads", BuildConfig.FLAVOR, e);
            }
        }
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final void c(String str) {
        this.f3601b = str;
    }

    public final void d(String str) {
        this.e = str;
    }

    private static int a(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    final /* synthetic */ void b() {
        com.google.android.gms.ads.internal.ax.o().a(this.f3600a, this.c, this.d, this.e);
    }

    final /* synthetic */ void c() {
        com.google.android.gms.ads.internal.ax.o().a(this.f3600a, this.c, this.d);
    }

    final /* synthetic */ void a(String str, DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.ax.e();
        xn.a(this.f3600a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ void a(int r1, int r2, int r3, android.content.DialogInterface r4, int r5) {
        /*
            r0 = this;
            if (r5 != r1) goto L9b
            android.content.Context r1 = r0.f3600a
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 != 0) goto Le
            java.lang.String r1 = "Can not create dialog without Activity Context"
            com.google.android.gms.internal.ads.xe.d(r1)
            return
        Le:
            java.lang.String r1 = r0.f3601b
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            java.lang.String r2 = "\\+"
            java.lang.String r3 = "%20"
            java.lang.String r1 = r1.replaceAll(r2, r3)
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r1 = r2.encodedQuery(r1)
            android.net.Uri r1 = r1.build()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.ads.internal.ax.e()
            java.util.Map r1 = com.google.android.gms.internal.ads.xn.a(r1)
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L3f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L62
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r5 = " = "
            r2.append(r5)
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r4 = "\n\n"
            r2.append(r4)
            goto L3f
        L62:
            java.lang.String r1 = r2.toString()
            java.lang.String r1 = r1.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L71
            goto L73
        L71:
            java.lang.String r1 = "No debug information"
        L73:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r3 = r0.f3600a
            r2.<init>(r3)
            r2.setMessage(r1)
            java.lang.String r3 = "Ad Information"
            r2.setTitle(r3)
            java.lang.String r3 = "Share"
            com.google.android.gms.internal.ads.ym r4 = new com.google.android.gms.internal.ads.ym
            r4.<init>(r0, r1)
            r2.setPositiveButton(r3, r4)
            java.lang.String r1 = "Close"
            android.content.DialogInterface$OnClickListener r3 = com.google.android.gms.internal.ads.yn.f3607a
            r2.setNegativeButton(r1, r3)
            android.app.AlertDialog r1 = r2.create()
            r1.show()
            return
        L9b:
            if (r5 != r2) goto Lab
            java.lang.String r1 = "Debug mode [Creative Preview] selected."
            com.google.android.gms.internal.ads.xe.b(r1)
            com.google.android.gms.internal.ads.yo r1 = new com.google.android.gms.internal.ads.yo
            r1.<init>(r0)
            com.google.android.gms.internal.ads.xl.a(r1)
            return
        Lab:
            if (r5 != r3) goto Lba
            java.lang.String r1 = "Debug mode [Troubleshooting] selected."
            com.google.android.gms.internal.ads.xe.b(r1)
            com.google.android.gms.internal.ads.yp r1 = new com.google.android.gms.internal.ads.yp
            r1.<init>(r0)
            com.google.android.gms.internal.ads.xl.a(r1)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.yj.a(int, int, int, android.content.DialogInterface, int):void");
    }

    final /* synthetic */ void d() {
        this.j = 4;
        a();
    }
}
