package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@qj
/* loaded from: classes.dex */
public final class aeb implements bja {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f1889a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1890b;
    private final Context c;
    private final bja d;
    private final bjp<bja> e;
    private final aec f;
    private Uri g;

    public aeb(Context context, bja bjaVar, bjp<bja> bjpVar, aec aecVar) {
        this.c = context;
        this.d = bjaVar;
        this.e = bjpVar;
        this.f = aecVar;
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final void a() throws IOException {
        if (!this.f1890b) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.f1890b = false;
        this.g = null;
        if (this.f1889a != null) {
            com.google.android.gms.common.util.h.a(this.f1889a);
            this.f1889a = null;
        } else {
            this.d.a();
        }
        if (this.e != null) {
            this.e.a(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final long a(bjd bjdVar) throws IOException {
        Long l;
        bjd bjdVar2 = bjdVar;
        if (this.f1890b) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        this.f1890b = true;
        this.g = bjdVar2.f2725a;
        if (this.e != null) {
            this.e.a((bjp<bja>) this, bjdVar2);
        }
        bod bodVarA = bod.a(bjdVar2.f2725a);
        if (!((Boolean) bra.e().a(o.ca)).booleanValue()) {
            boa boaVarA = null;
            if (bodVarA != null) {
                bodVarA.c = bjdVar2.d;
                boaVarA = com.google.android.gms.ads.internal.ax.k().a(bodVarA);
            }
            if (boaVarA != null && boaVarA.a()) {
                this.f1889a = boaVarA.b();
                return -1L;
            }
        } else if (bodVarA != null) {
            bodVarA.c = bjdVar2.d;
            if (bodVarA.f2897b) {
                l = (Long) bra.e().a(o.cc);
            } else {
                l = (Long) bra.e().a(o.cb);
            }
            long jLongValue = l.longValue();
            long jB = com.google.android.gms.ads.internal.ax.l().b();
            com.google.android.gms.ads.internal.ax.A();
            Future<InputStream> futureA = bor.a(this.c, bodVarA);
            try {
                try {
                    this.f1889a = futureA.get(jLongValue, TimeUnit.MILLISECONDS);
                    long jB2 = com.google.android.gms.ads.internal.ax.l().b() - jB;
                    this.f.a(true, jB2);
                    StringBuilder sb = new StringBuilder(44);
                    sb.append("Cache connection took ");
                    sb.append(jB2);
                    sb.append("ms");
                    xe.a(sb.toString());
                    return -1L;
                } catch (InterruptedException unused) {
                    futureA.cancel(true);
                    Thread.currentThread().interrupt();
                    long jB3 = com.google.android.gms.ads.internal.ax.l().b() - jB;
                    this.f.a(false, jB3);
                    StringBuilder sb2 = new StringBuilder(44);
                    sb2.append("Cache connection took ");
                    sb2.append(jB3);
                    sb2.append("ms");
                    xe.a(sb2.toString());
                } catch (ExecutionException | TimeoutException unused2) {
                    futureA.cancel(true);
                    long jB4 = com.google.android.gms.ads.internal.ax.l().b() - jB;
                    this.f.a(false, jB4);
                    StringBuilder sb3 = new StringBuilder(44);
                    sb3.append("Cache connection took ");
                    sb3.append(jB4);
                    sb3.append("ms");
                    xe.a(sb3.toString());
                }
            } catch (Throwable th) {
                long jB5 = com.google.android.gms.ads.internal.ax.l().b() - jB;
                this.f.a(false, jB5);
                StringBuilder sb4 = new StringBuilder(44);
                sb4.append("Cache connection took ");
                sb4.append(jB5);
                sb4.append("ms");
                xe.a(sb4.toString());
                throw th;
            }
        }
        if (bodVarA != null) {
            bjdVar2 = new bjd(Uri.parse(bodVarA.f2896a), bjdVar2.f2726b, bjdVar2.c, bjdVar2.d, bjdVar2.e, bjdVar2.f, bjdVar2.g);
        }
        return this.d.a(bjdVar2);
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final int a(byte[] bArr, int i, int i2) throws IOException {
        int iA;
        if (!this.f1890b) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        if (this.f1889a != null) {
            iA = this.f1889a.read(bArr, i, i2);
        } else {
            iA = this.d.a(bArr, i, i2);
        }
        if (this.e != null) {
            this.e.a((bjp<bja>) this, iA);
        }
        return iA;
    }

    @Override // com.google.android.gms.internal.ads.bja
    public final Uri b() {
        return this.g;
    }
}
