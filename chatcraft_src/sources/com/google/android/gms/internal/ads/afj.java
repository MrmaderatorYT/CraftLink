package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import java.io.IOException;

@qj
@TargetApi(16)
/* loaded from: classes.dex */
public final class afj extends aex implements ael {
    private aee d;
    private String e;
    private boolean f;
    private Exception g;
    private boolean h;

    public afj(adk adkVar, adj adjVar) {
        super(adkVar);
        this.d = new aee(adkVar.getContext(), adjVar);
        this.d.a((ael) this);
    }

    @Override // com.google.android.gms.internal.ads.ael
    public final void a(int i, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.ael
    public final void b(int i) {
    }

    @Override // com.google.android.gms.internal.ads.ael
    public final void a(final boolean z, final long j) {
        final adk adkVar = this.c.get();
        if (adkVar != null) {
            abq.f1816a.execute(new Runnable(adkVar, z, j) { // from class: com.google.android.gms.internal.ads.afk

                /* renamed from: a, reason: collision with root package name */
                private final adk f1929a;

                /* renamed from: b, reason: collision with root package name */
                private final boolean f1930b;
                private final long c;

                {
                    this.f1929a = adkVar;
                    this.f1930b = z;
                    this.c = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f1929a.a(this.f1930b, this.c);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.ael
    public final void a(String str, Exception exc) {
        this.g = exc;
        xe.c("Precache error", exc);
        c(str);
    }

    @Override // com.google.android.gms.internal.ads.aex
    public final void a(int i) {
        this.d.d().b(i);
    }

    @Override // com.google.android.gms.internal.ads.aex
    public final void c(int i) {
        this.d.d().a(i);
    }

    @Override // com.google.android.gms.internal.ads.aex
    public final void d(int i) {
        this.d.d().c(i);
    }

    @Override // com.google.android.gms.internal.ads.aex
    public final void e(int i) {
        this.d.d().d(i);
    }

    @Override // com.google.android.gms.internal.ads.aex
    public final void b() {
        if (this.d != null) {
            this.d.a((ael) null);
            this.d.e();
        }
        super.b();
    }

    @Override // com.google.android.gms.internal.ads.aex
    protected final String b(String str) {
        String strValueOf = String.valueOf("cache:");
        String strValueOf2 = String.valueOf(super.b(str));
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22, types: [long] */
    /* JADX WARN: Type inference failed for: r1v26 */
    @Override // com.google.android.gms.internal.ads.aex
    public final boolean a(String str) throws Throwable {
        String str2;
        long j;
        long j2;
        long j3;
        ?? r1;
        long j4;
        this.e = str;
        String strB = b(str);
        String str3 = "error";
        try {
            this.d.a(Uri.parse(str), this.f1916b);
            adk adkVar = this.c.get();
            if (adkVar != null) {
                try {
                    adkVar.a(strB, this);
                } catch (Exception e) {
                    e = e;
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
                    sb.append("Failed to preload url ");
                    sb.append(str);
                    sb.append(" Exception: ");
                    sb.append(message);
                    xe.e(sb.toString());
                    b();
                    a(str, strB, str3, b(str3, e));
                    return false;
                }
            }
            com.google.android.gms.common.util.c cVarL = com.google.android.gms.ads.internal.ax.l();
            long jA = cVarL.a();
            long jLongValue = ((Long) bra.e().a(o.r)).longValue();
            long jLongValue2 = ((Long) bra.e().a(o.q)).longValue() * 1000;
            long jIntValue = ((Integer) bra.e().a(o.p)).intValue();
            long j5 = -1;
            while (true) {
                try {
                    synchronized (this) {
                        try {
                            if (cVarL.a() - jA > jLongValue2) {
                                long j6 = jLongValue2;
                                StringBuilder sb2 = new StringBuilder(47);
                                sb2.append("Timeout reached. Limit: ");
                                sb2.append(j6);
                                sb2.append(" ms");
                                throw new IOException(sb2.toString());
                            }
                            if (this.f) {
                                if (this.g != null) {
                                    throw this.g;
                                }
                                throw new IOException("Abort requested before buffering finished. ");
                            }
                            if (!this.h) {
                                azp azpVarA = this.d.a();
                                if (azpVarA == null) {
                                    throw new IOException("ExoPlayer was released during preloading.");
                                }
                                str2 = str3;
                                try {
                                    long jF = azpVarA.f();
                                    if (jF > 0) {
                                        long jH = azpVarA.h();
                                        if (jH != j5) {
                                            j = jIntValue;
                                            j2 = jLongValue2;
                                            j4 = jLongValue;
                                            a(str, strB, jH, jF, jH > 0, aee.b(), aee.c());
                                            j5 = jH;
                                        } else {
                                            j = jIntValue;
                                            j2 = jLongValue2;
                                            j4 = jLongValue;
                                        }
                                        if (jH >= jF) {
                                            a(str, strB, jF);
                                        } else if (this.d.f() < j || jH <= 0) {
                                            j3 = j5;
                                            r1 = j4;
                                        }
                                    } else {
                                        j = jIntValue;
                                        j2 = jLongValue2;
                                        j3 = j5;
                                        r1 = jLongValue;
                                    }
                                    try {
                                        try {
                                            wait(r1);
                                        } catch (InterruptedException unused) {
                                            throw new IOException("Wait interrupted.");
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        str3 = r1;
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    str3 = str2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    jLongValue = r1;
                    j5 = j3;
                    str3 = str2;
                    jIntValue = j;
                    jLongValue2 = j2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            return true;
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.google.android.gms.internal.ads.aex
    public final void a() {
        c((String) null);
    }

    private final void c(String str) {
        synchronized (this) {
            this.f = true;
            notify();
            b();
        }
        if (this.e != null) {
            String strB = b(this.e);
            if (this.g != null) {
                a(this.e, strB, "badUrl", b(str, this.g));
            } else {
                a(this.e, strB, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final aee c() {
        synchronized (this) {
            this.h = true;
            notify();
        }
        this.d.a((ael) null);
        aee aeeVar = this.d;
        this.d = null;
        return aeeVar;
    }

    private static String b(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }
}
