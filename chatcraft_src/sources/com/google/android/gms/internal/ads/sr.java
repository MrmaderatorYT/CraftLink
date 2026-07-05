package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class sr extends rr {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3453a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("sLock")
    private static sr f3454b;
    private final Context c;
    private final sq d;
    private final ScheduledExecutorService e = Executors.newSingleThreadScheduledExecutor();

    public static sr a(Context context, sq sqVar) {
        sr srVar;
        synchronized (f3453a) {
            if (f3454b == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                o.a(context);
                f3454b = new sr(context, sqVar);
                if (context.getApplicationContext() != null) {
                    com.google.android.gms.ads.internal.ax.e().c(context);
                }
                xc.a(context);
            }
            srVar = f3454b;
        }
        return srVar;
    }

    @Override // com.google.android.gms.internal.ads.rq
    public final void a(sc scVar, rw rwVar) {
        xe.a("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.rq
    public final void b(sc scVar, rw rwVar) {
        xe.a("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    private static rm a(Context context, sq sqVar, ri riVar, ScheduledExecutorService scheduledExecutorService) throws JSONException {
        String string;
        char c;
        String string2;
        xe.b("Starting ad request from service using: google.afma.request.getAdDictionary");
        ac acVar = new ac(((Boolean) bra.e().a(o.K)).booleanValue(), "load_ad", riVar.d.f2974a);
        if (riVar.f3422a > 10 && riVar.A != -1) {
            acVar.a(acVar.a(riVar.A), "cts");
        }
        z zVarA = acVar.a();
        abl ablVarA = aaz.a(sqVar.h.a(context), ((Long) bra.e().a(o.bT)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        abl<String> ablVarA2 = aaz.a((Object) null);
        if (((Boolean) bra.e().a(o.cH)).booleanValue()) {
            ablVarA2 = sqVar.c.a(riVar.g.packageName);
        }
        abl<String> ablVarB = sqVar.c.b(riVar.g.packageName);
        abl<String> ablVarA3 = sqVar.i.a(riVar.h, riVar.g);
        Future<ta> futureA = com.google.android.gms.ads.internal.ax.p().a(context);
        abl<Location> ablVarA4 = aaz.a((Object) null);
        Bundle bundle = riVar.c.c;
        boolean z = (bundle == null || bundle.getString("_ad") == null) ? false : true;
        if (riVar.G && !z) {
            ablVarA4 = sqVar.f.a(riVar.f);
        }
        abl ablVarA5 = aaz.a(ablVarA4, ((Long) bra.e().a(o.bK)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        Future futureA2 = aaz.a((Object) null);
        if (((Boolean) bra.e().a(o.aw)).booleanValue()) {
            futureA2 = aaz.a(sqVar.i.a(context), ((Long) bra.e().a(o.ax)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        }
        Bundle bundle2 = (riVar.f3422a < 4 || riVar.o == null) ? null : riVar.o;
        com.google.android.gms.ads.internal.ax.e();
        if (xn.a(context, "android.permission.ACCESS_NETWORK_STATE") && ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            xe.b("Device is offline.");
        }
        if (riVar.f3422a >= 7) {
            string = riVar.v;
        } else {
            string = UUID.randomUUID().toString();
        }
        if (riVar.c.c != null && (string2 = riVar.c.c.getString("_ad")) != null) {
            return sw.a(context, riVar, string2);
        }
        List<String> listA = sqVar.d.a(riVar.w);
        String str = string;
        Bundle bundle3 = (Bundle) aaz.a(ablVarA, (Object) null, ((Long) bra.e().a(o.bT)).longValue(), TimeUnit.MILLISECONDS);
        Location location = (Location) aaz.a(ablVarA5, (Object) null);
        AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) aaz.a((Future<Object>) futureA2, (Object) null);
        String str2 = (String) aaz.a(ablVarA3, (Object) null);
        String str3 = (String) aaz.a(ablVarA2, (Object) null);
        String str4 = (String) aaz.a(ablVarB, (Object) null);
        ta taVar = (ta) aaz.a(futureA, (Object) null);
        if (taVar == null) {
            xe.e("Error fetching device info. This is not recoverable.");
            return new rm(0);
        }
        sp spVar = new sp();
        spVar.i = riVar;
        spVar.j = taVar;
        spVar.d = location;
        spVar.f3450b = bundle3;
        spVar.g = str2;
        spVar.h = info;
        if (listA == null) {
            spVar.c.clear();
        }
        spVar.c = listA;
        spVar.f3449a = bundle2;
        spVar.e = str3;
        spVar.f = str4;
        spVar.k = sqVar.f3452b.a(context);
        spVar.l = sqVar.j;
        JSONObject jSONObjectA = sw.a(context, spVar);
        if (jSONObjectA == null) {
            return new rm(0);
        }
        if (riVar.f3422a < 7) {
            try {
                jSONObjectA.put("request_id", str);
            } catch (JSONException unused) {
            }
        }
        acVar.a(zVarA, "arc");
        abl ablVarA6 = aaz.a(aaz.a(sqVar.k.a().b(jSONObjectA), ss.f3455a, scheduledExecutorService), 10L, TimeUnit.SECONDS, scheduledExecutorService);
        abl<Void> ablVarA7 = sqVar.e.a();
        if (ablVarA7 != null) {
            aax.a(ablVarA7, "AdRequestServiceImpl.loadAd.flags");
        }
        sz szVar = (sz) aaz.a(ablVarA6, (Object) null);
        if (szVar == null) {
            return new rm(0);
        }
        if (szVar.a() != -2) {
            return new rm(szVar.a());
        }
        acVar.d();
        rm rmVarA = TextUtils.isEmpty(szVar.f()) ? null : sw.a(context, riVar, szVar.f());
        if (rmVarA == null && !TextUtils.isEmpty(szVar.d())) {
            rmVarA = a(riVar, context, riVar.k.f1790a, szVar.d(), str3, str4, szVar, acVar, sqVar);
        }
        if (rmVarA == null) {
            c = 0;
            rmVarA = new rm(0);
        } else {
            c = 0;
        }
        String[] strArr = new String[1];
        strArr[c] = "tts";
        acVar.a(zVarA, strArr);
        rmVarA.w = acVar.b();
        rmVarA.U = szVar.h();
        return rmVarA;
    }

    private static void a(String str, Map<String, List<String>> map, String str2, int i) {
        if (xe.a(2)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39);
            sb.append("Http Response: {\n  URL:\n    ");
            sb.append(str);
            sb.append("\n  Headers:");
            xe.a(sb.toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 5);
                    sb2.append("    ");
                    sb2.append(str3);
                    sb2.append(":");
                    xe.a(sb2.toString());
                    Iterator<String> it = map.get(str3).iterator();
                    while (it.hasNext()) {
                        String strValueOf = String.valueOf(it.next());
                        xe.a(strValueOf.length() != 0 ? "      ".concat(strValueOf) : new String("      "));
                    }
                }
            }
            xe.a("  Body:");
            if (str2 != null) {
                int i2 = 0;
                while (i2 < Math.min(str2.length(), 100000)) {
                    int i3 = i2 + 1000;
                    xe.a(str2.substring(i2, Math.min(str2.length(), i3)));
                    i2 = i3;
                }
            } else {
                xe.a("    null");
            }
            StringBuilder sb3 = new StringBuilder(34);
            sb3.append("  Response Code:\n    ");
            sb3.append(i);
            sb3.append("\n}");
            xe.a(sb3.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x01a5, code lost:
    
        r1 = new java.lang.StringBuilder(46);
        r1.append("Received error HTTP response code: ");
        r1.append(r10);
        com.google.android.gms.internal.ads.xe.e(r1.toString());
        r0 = new com.google.android.gms.internal.ads.rm(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01bf, code lost:
    
        r12.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c2, code lost:
    
        if (r26 == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c4, code lost:
    
        r26.g.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c9, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c A[Catch: all -> 0x01ca, TryCatch #4 {all -> 0x01ca, blocks: (B:14:0x0051, B:16:0x0062, B:18:0x0068, B:20:0x0072, B:22:0x0078, B:25:0x0084, B:27:0x008c, B:30:0x0099, B:32:0x00a3, B:35:0x00be, B:43:0x00ce, B:46:0x00eb, B:49:0x00ff, B:51:0x010d, B:52:0x0118, B:61:0x012e, B:62:0x0131, B:63:0x0132, B:67:0x0140, B:69:0x014c, B:74:0x0162, B:76:0x017b, B:81:0x0191, B:87:0x01a5, B:40:0x00c9, B:41:0x00cc), top: B:111:0x0051, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.rm a(com.google.android.gms.internal.ads.ri r18, android.content.Context r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, com.google.android.gms.internal.ads.sz r24, com.google.android.gms.internal.ads.ac r25, com.google.android.gms.internal.ads.sq r26) {
        /*
            Method dump skipped, instructions count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.sr.a(com.google.android.gms.internal.ads.ri, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.sz, com.google.android.gms.internal.ads.ac, com.google.android.gms.internal.ads.sq):com.google.android.gms.internal.ads.rm");
    }

    private sr(Context context, sq sqVar) {
        this.c = context;
        this.d = sqVar;
    }

    @Override // com.google.android.gms.internal.ads.rq
    public final rm a(ri riVar) {
        return a(this.c, this.d, riVar, this.e);
    }

    @Override // com.google.android.gms.internal.ads.rq
    public final void a(ri riVar, rt rtVar) {
        com.google.android.gms.ads.internal.ax.i().a(this.c, riVar.k);
        abl<?> ablVarA = xl.a(new st(this, riVar, rtVar));
        com.google.android.gms.ads.internal.ax.u().a();
        com.google.android.gms.ads.internal.ax.u().b().postDelayed(new su(this, ablVarA), 60000L);
    }
}
