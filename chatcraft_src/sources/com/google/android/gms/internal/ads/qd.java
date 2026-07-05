package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class qd implements qh {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3388a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static qh f3389b = null;
    private static qh c = null;
    private final Object d;
    private final Context e;
    private final WeakHashMap<Thread, Boolean> f;
    private final ExecutorService g;
    private final aar h;

    public static qh a(Context context) {
        synchronized (f3388a) {
            if (f3389b == null) {
                if (((Boolean) bra.e().a(o.c)).booleanValue()) {
                    f3389b = new qd(context);
                } else {
                    f3389b = new qi();
                }
            }
        }
        return f3389b;
    }

    public static qh a(Context context, aar aarVar) {
        synchronized (f3388a) {
            if (c == null) {
                if (((Boolean) bra.e().a(o.c)).booleanValue()) {
                    qd qdVar = new qd(context, aarVar);
                    Thread thread = Looper.getMainLooper().getThread();
                    if (thread != null) {
                        synchronized (qdVar.d) {
                            qdVar.f.put(thread, true);
                        }
                        thread.setUncaughtExceptionHandler(new qf(qdVar, thread.getUncaughtExceptionHandler()));
                    }
                    Thread.setDefaultUncaughtExceptionHandler(new qe(qdVar, Thread.getDefaultUncaughtExceptionHandler()));
                    c = qdVar;
                } else {
                    c = new qi();
                }
            }
        }
        return c;
    }

    private qd(Context context) {
        this(context, aar.a());
    }

    private qd(Context context, aar aarVar) {
        this.d = new Object();
        this.f = new WeakHashMap<>();
        this.g = Executors.newCachedThreadPool();
        this.e = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.h = aarVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void a(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L42
            r1 = r11
            r2 = 0
            r3 = 0
        L7:
            if (r1 == 0) goto L3d
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = r3
            r3 = r2
            r2 = 0
        L11:
            if (r2 >= r5) goto L36
            r7 = r4[r2]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.aac.b(r8)
            if (r8 == 0) goto L20
            r3 = 1
        L20:
            java.lang.Class r8 = r9.getClass()
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L33
            r6 = 1
        L33:
            int r2 = r2 + 1
            goto L11
        L36:
            java.lang.Throwable r1 = r1.getCause()
            r2 = r3
            r3 = r6
            goto L7
        L3d:
            if (r2 == 0) goto L42
            if (r3 != 0) goto L42
            goto L43
        L42:
            r10 = 0
        L43:
            if (r10 == 0) goto L4c
            java.lang.String r10 = ""
            r0 = 1065353216(0x3f800000, float:1.0)
            r9.a(r11, r10, r0)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.qd.a(java.lang.Thread, java.lang.Throwable):void");
    }

    @Override // com.google.android.gms.internal.ads.qh
    public final void a(Throwable th, String str) {
        a(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.qh
    public final void a(Throwable th, String str, float f) {
        if (aac.a(th) == null) {
            return;
        }
        String name = th.getClass().getName();
        StringWriter stringWriter = new StringWriter();
        aoy.a(th, new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        int i = 0;
        boolean z = Math.random() < ((double) f);
        int i2 = f > 0.0f ? (int) (1.0f / f) : 1;
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a(name, string, str, i2).toString());
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                this.g.submit(new qg(this, new aaq(), (String) obj));
            }
        }
    }

    private final Uri.Builder a(String str, String str2, String str3, int i) {
        boolean zA;
        try {
            zA = com.google.android.gms.common.b.c.a(this.e).a();
        } catch (Throwable th) {
            aan.b("Error fetching instant app info", th);
            zA = false;
        }
        String packageName = "unknown";
        try {
            packageName = this.e.getPackageName();
        } catch (Throwable unused) {
            aan.e("Cannot obtain package name, proceeding.");
        }
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(zA)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str4 = Build.MANUFACTURER;
        String string = Build.MODEL;
        if (!string.startsWith(str4)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + 1 + String.valueOf(string).length());
            sb.append(str4);
            sb.append(" ");
            sb.append(string);
            string = sb.toString();
        }
        return builderAppendQueryParameter.appendQueryParameter("device", string).appendQueryParameter("js", this.h.f1790a).appendQueryParameter("appid", packageName).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", o.a())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "220701481").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", bra.f()).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(bra.e().a(o.cJ)));
    }
}
