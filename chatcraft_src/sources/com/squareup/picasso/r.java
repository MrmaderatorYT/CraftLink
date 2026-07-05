package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import java.io.IOException;
import okhttp3.d;
import okhttp3.y;

/* compiled from: NetworkRequestHandler.java */
/* loaded from: classes.dex */
class r extends y {

    /* renamed from: a, reason: collision with root package name */
    private final j f4145a;

    /* renamed from: b, reason: collision with root package name */
    private final aa f4146b;

    @Override // com.squareup.picasso.y
    int a() {
        return 2;
    }

    @Override // com.squareup.picasso.y
    boolean b() {
        return true;
    }

    r(j jVar, aa aaVar) {
        this.f4145a = jVar;
        this.f4146b = aaVar;
    }

    @Override // com.squareup.picasso.y
    public boolean a(w wVar) {
        String scheme = wVar.d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    @Override // com.squareup.picasso.y
    public y.a a(w wVar, int i) throws IOException {
        okhttp3.aa aaVarA = this.f4145a.a(b(wVar, i));
        okhttp3.ab abVarH = aaVarA.h();
        if (!aaVarA.d()) {
            abVarH.close();
            throw new b(aaVarA.c(), wVar.c);
        }
        t.d dVar = aaVarA.k() == null ? t.d.NETWORK : t.d.DISK;
        if (dVar == t.d.DISK && abVarH.a() == 0) {
            abVarH.close();
            throw new a("Received response with 0 content-length header.");
        }
        if (dVar == t.d.NETWORK && abVarH.a() > 0) {
            this.f4146b.a(abVarH.a());
        }
        return new y.a(abVarH.b(), dVar);
    }

    @Override // com.squareup.picasso.y
    boolean a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    private static okhttp3.y b(w wVar, int i) {
        okhttp3.d dVarD;
        if (i == 0) {
            dVarD = null;
        } else if (q.c(i)) {
            dVarD = okhttp3.d.f5074b;
        } else {
            d.a aVar = new d.a();
            if (!q.a(i)) {
                aVar.a();
            }
            if (!q.b(i)) {
                aVar.b();
            }
            dVarD = aVar.d();
        }
        y.a aVarA = new y.a().a(wVar.d.toString());
        if (dVarD != null) {
            aVarA.a(dVarD);
        }
        return aVarA.a();
    }

    /* compiled from: NetworkRequestHandler.java */
    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    /* compiled from: NetworkRequestHandler.java */
    static final class b extends IOException {

        /* renamed from: a, reason: collision with root package name */
        final int f4147a;

        /* renamed from: b, reason: collision with root package name */
        final int f4148b;

        b(int i, int i2) {
            super("HTTP " + i);
            this.f4147a = i;
            this.f4148b = i2;
        }
    }
}
