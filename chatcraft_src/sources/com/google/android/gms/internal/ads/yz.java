package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class yz {

    /* renamed from: a, reason: collision with root package name */
    private static bpg f3622a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f3623b = new Object();

    @Deprecated
    private static final zf<Void> c = new za();

    public yz(Context context) {
        a(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    @Deprecated
    public final <T> abl<T> a(String str, zf<T> zfVar) {
        abv abvVar = new abv();
        f3622a.a(new zj(str, abvVar));
        return aaz.a(aaz.a(abvVar, new zc(this, zfVar), xl.f3579a), Throwable.class, new zb(this, zfVar), abq.f1817b);
    }

    public final abl<String> a(int i, String str, Map<String, String> map, byte[] bArr) throws IOException {
        zg zgVar = new zg(null);
        zd zdVar = new zd(this, str, zgVar);
        aag aagVar = new aag(null);
        ze zeVar = new ze(this, i, str, zgVar, zdVar, bArr, map, aagVar);
        if (aag.c()) {
            try {
                aagVar.a(str, "GET", zeVar.b(), zeVar.a());
            } catch (zza e) {
                xe.e(e.getMessage());
            }
        }
        f3622a.a(zeVar);
        return zgVar;
    }

    public final abl<String> a(String str, Map<String, String> map) {
        return a(0, str, map, null);
    }

    private static bpg a(Context context) {
        bpg bpgVar;
        bpg bpgVar2;
        synchronized (f3623b) {
            if (f3622a == null) {
                o.a(context);
                if (((Boolean) bra.e().a(o.cd)).booleanValue()) {
                    bpgVar2 = yt.a(context);
                } else {
                    bpgVar2 = new bpg(new le(new File(context.getCacheDir(), "volley")), new ic((hb) new qz()));
                    bpgVar2.a();
                }
                f3622a = bpgVar2;
            }
            bpgVar = f3622a;
        }
        return bpgVar;
    }
}
