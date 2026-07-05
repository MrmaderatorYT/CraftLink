package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
@TargetApi(14)
/* loaded from: classes.dex */
public final class bnb extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2862a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2863b;
    private boolean c;
    private final Object d;
    private final bmw e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final String n;
    private final boolean o;

    public bnb() {
        this(new bmw());
    }

    private bnb(bmw bmwVar) {
        this.f2862a = false;
        this.f2863b = false;
        this.c = false;
        this.e = bmwVar;
        this.d = new Object();
        this.g = ((Integer) bra.e().a(o.O)).intValue();
        this.h = ((Integer) bra.e().a(o.P)).intValue();
        this.i = ((Integer) bra.e().a(o.Q)).intValue();
        this.j = ((Integer) bra.e().a(o.R)).intValue();
        this.k = ((Integer) bra.e().a(o.T)).intValue();
        this.l = ((Integer) bra.e().a(o.U)).intValue();
        this.m = ((Integer) bra.e().a(o.V)).intValue();
        this.f = ((Integer) bra.e().a(o.S)).intValue();
        this.n = (String) bra.e().a(o.X);
        this.o = ((Boolean) bra.e().a(o.Y)).booleanValue();
        setName("ContentFetchTask");
    }

    public final void a() {
        synchronized (this.d) {
            if (this.f2862a) {
                xe.b("Content hash thread already started, quiting...");
            } else {
                this.f2862a = true;
                start();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws InterruptedException {
        while (true) {
            try {
                try {
                    if (e()) {
                        Activity activityA = com.google.android.gms.ads.internal.ax.h().a();
                        if (activityA == null) {
                            xe.b("ContentFetchThread: no activity. Sleeping.");
                            f();
                        } else if (activityA != null) {
                            View viewFindViewById = null;
                            try {
                                if (activityA.getWindow() != null && activityA.getWindow().getDecorView() != null) {
                                    viewFindViewById = activityA.getWindow().getDecorView().findViewById(R.id.content);
                                }
                            } catch (Exception e) {
                                com.google.android.gms.ads.internal.ax.i().a(e, "ContentFetchTask.extractContent");
                                xe.b("Failed getting root view of activity. Content not extracted.");
                            }
                            if (viewFindViewById != null && viewFindViewById != null) {
                                viewFindViewById.post(new bnc(this, viewFindViewById));
                            }
                        }
                    } else {
                        xe.b("ContentFetchTask: sleeping");
                        f();
                    }
                    Thread.sleep(this.f * 1000);
                } catch (Exception e2) {
                    xe.b("Error in ContentFetchTask", e2);
                    com.google.android.gms.ads.internal.ax.i().a(e2, "ContentFetchTask.run");
                }
            } catch (InterruptedException e3) {
                xe.b("Error in ContentFetchTask", e3);
            }
            synchronized (this.d) {
                while (this.f2863b) {
                    try {
                        xe.b("ContentFetchTask: waiting");
                        this.d.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    final void a(View view) {
        try {
            bmv bmvVar = new bmv(this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            Context contextB = com.google.android.gms.ads.internal.ax.h().b();
            if (contextB != null && !TextUtils.isEmpty(this.n)) {
                String str = (String) view.getTag(contextB.getResources().getIdentifier((String) bra.e().a(o.W), "id", contextB.getPackageName()));
                if (str != null && str.equals(this.n)) {
                    return;
                }
            }
            bng bngVarA = a(view, bmvVar);
            bmvVar.h();
            if (bngVarA.f2869a == 0 && bngVarA.f2870b == 0) {
                return;
            }
            if (bngVarA.f2870b == 0 && bmvVar.j() == 0) {
                return;
            }
            if (bngVarA.f2870b == 0 && this.e.a(bmvVar)) {
                return;
            }
            this.e.c(bmvVar);
        } catch (Exception e) {
            xe.b("Exception in fetchContentOnUIThread", e);
            com.google.android.gms.ads.internal.ax.i().a(e, "ContentFetchTask.fetchContent");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        if (r4.importance != 100) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        if (r3.inKeyguardRestrictedInputMode() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        r1 = (android.os.PowerManager) r1.getSystemService("power");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        if (r1 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r1 = r1.isScreenOn();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        if (r1 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean e() {
        /*
            r0 = 0
            com.google.android.gms.internal.ads.bmx r1 = com.google.android.gms.ads.internal.ax.h()     // Catch: java.lang.Throwable -> L62
            android.content.Context r1 = r1.b()     // Catch: java.lang.Throwable -> L62
            if (r1 != 0) goto Lc
            return r0
        Lc:
            java.lang.String r2 = "activity"
            java.lang.Object r2 = r1.getSystemService(r2)     // Catch: java.lang.Throwable -> L62
            android.app.ActivityManager r2 = (android.app.ActivityManager) r2     // Catch: java.lang.Throwable -> L62
            java.lang.String r3 = "keyguard"
            java.lang.Object r3 = r1.getSystemService(r3)     // Catch: java.lang.Throwable -> L62
            android.app.KeyguardManager r3 = (android.app.KeyguardManager) r3     // Catch: java.lang.Throwable -> L62
            if (r2 == 0) goto L61
            if (r3 != 0) goto L21
            goto L61
        L21:
            java.util.List r2 = r2.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L28
            return r0
        L28:
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L62
        L2c:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Throwable -> L62
            if (r4 == 0) goto L60
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Throwable -> L62
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4     // Catch: java.lang.Throwable -> L62
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L62
            int r6 = r4.pid     // Catch: java.lang.Throwable -> L62
            if (r5 != r6) goto L2c
            int r2 = r4.importance     // Catch: java.lang.Throwable -> L62
            r4 = 100
            if (r2 != r4) goto L60
            boolean r2 = r3.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L60
            java.lang.String r2 = "power"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Throwable -> L62
            android.os.PowerManager r1 = (android.os.PowerManager) r1     // Catch: java.lang.Throwable -> L62
            if (r1 != 0) goto L58
            r1 = 0
            goto L5c
        L58:
            boolean r1 = r1.isScreenOn()     // Catch: java.lang.Throwable -> L62
        L5c:
            if (r1 == 0) goto L60
            r0 = 1
            return r0
        L60:
            return r0
        L61:
            return r0
        L62:
            r1 = move-exception
            com.google.android.gms.internal.ads.wp r2 = com.google.android.gms.ads.internal.ax.i()
            java.lang.String r3 = "ContentFetchTask.isInForeground"
            r2.a(r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bnb.e():boolean");
    }

    private final bng a(View view, bmv bmvVar) {
        boolean z;
        if (view == null) {
            return new bng(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (!TextUtils.isEmpty(text)) {
                bmvVar.b(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
                return new bng(this, 1, 0);
            }
            return new bng(this, 0, 0);
        }
        if ((view instanceof WebView) && !(view instanceof afu)) {
            bmvVar.g();
            WebView webView = (WebView) view;
            if (com.google.android.gms.common.util.j.f()) {
                bmvVar.g();
                webView.post(new bnd(this, bmvVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return new bng(this, 0, 1);
            }
            return new bng(this, 0, 0);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                bng bngVarA = a(viewGroup.getChildAt(i3), bmvVar);
                i += bngVarA.f2869a;
                i2 += bngVarA.f2870b;
            }
            return new bng(this, i, i2);
        }
        return new bng(this, 0, 0);
    }

    final void a(bmv bmvVar, WebView webView, String str, boolean z) {
        bmvVar.f();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("text");
                if (!this.o && !TextUtils.isEmpty(webView.getTitle())) {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(strOptString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(strOptString);
                    bmvVar.a(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    bmvVar.a(strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (bmvVar.a()) {
                this.e.b(bmvVar);
            }
        } catch (JSONException unused) {
            xe.b("Json string may be malformed.");
        } catch (Throwable th) {
            xe.a("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.ax.i().a(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final bmv b() {
        return this.e.a();
    }

    public final void c() {
        synchronized (this.d) {
            this.f2863b = false;
            this.d.notifyAll();
            xe.b("ContentFetchThread: wakeup");
        }
    }

    private final void f() {
        synchronized (this.d) {
            this.f2863b = true;
            boolean z = this.f2863b;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            xe.b(sb.toString());
        }
    }

    public final boolean d() {
        return this.f2863b;
    }
}
