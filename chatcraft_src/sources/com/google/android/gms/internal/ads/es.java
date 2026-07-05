package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@qj
/* loaded from: classes.dex */
public final class es implements bge {

    /* renamed from: a, reason: collision with root package name */
    private volatile ej f3070a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3071b;

    public es(Context context) {
        this.f3071b = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.bge
    public final bje a(blc<?> blcVar) throws zzae {
        ek ekVarA = ek.a(blcVar);
        long jB = com.google.android.gms.ads.internal.ax.l().b();
        try {
            abv abvVar = new abv();
            this.f3070a = new ej(this.f3071b, com.google.android.gms.ads.internal.ax.u().a(), new ew(this, abvVar), new ex(this, abvVar));
            this.f3070a.e();
            abl ablVarA = aaz.a(aaz.a(abvVar, new et(this, ekVarA), xl.f3579a), ((Integer) bra.e().a(o.cf)).intValue(), TimeUnit.MILLISECONDS, xl.c);
            ablVarA.a(new ev(this), xl.f3579a);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ablVarA.get();
            long jB2 = com.google.android.gms.ads.internal.ax.l().b() - jB;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(jB2);
            sb.append("ms");
            xe.a(sb.toString());
            em emVar = (em) new ry(parcelFileDescriptor).a(em.CREATOR);
            if (emVar == null) {
                return null;
            }
            if (emVar.f3068a) {
                throw new zzae(emVar.f3069b);
            }
            if (emVar.e.length != emVar.f.length) {
                return null;
            }
            HashMap map = new HashMap();
            for (int i = 0; i < emVar.e.length; i++) {
                map.put(emVar.e[i], emVar.f[i]);
            }
            return new bje(emVar.c, emVar.d, map, emVar.g, emVar.h);
        } catch (InterruptedException | ExecutionException unused) {
            long jB3 = com.google.android.gms.ads.internal.ax.l().b() - jB;
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(jB3);
            sb2.append("ms");
            xe.a(sb2.toString());
            return null;
        } catch (Throwable th) {
            long jB4 = com.google.android.gms.ads.internal.ax.l().b() - jB;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(jB4);
            sb3.append("ms");
            xe.a(sb3.toString());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        if (this.f3070a == null) {
            return;
        }
        this.f3070a.h();
        Binder.flushPendingCommands();
    }
}
