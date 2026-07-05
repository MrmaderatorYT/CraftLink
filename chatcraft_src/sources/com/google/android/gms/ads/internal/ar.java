package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.aac;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.axe;
import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.brd;
import com.google.android.gms.internal.ads.brh;
import com.google.android.gms.internal.ads.brt;
import com.google.android.gms.internal.ads.brx;
import com.google.android.gms.internal.ads.bsa;
import com.google.android.gms.internal.ads.bsg;
import com.google.android.gms.internal.ads.bsw;
import com.google.android.gms.internal.ads.btc;
import com.google.android.gms.internal.ads.buc;
import com.google.android.gms.internal.ads.nt;
import com.google.android.gms.internal.ads.oa;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.ue;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xl;
import com.google.android.gms.internal.ads.zzcv;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ar extends brt {

    /* renamed from: a, reason: collision with root package name */
    private final aar f1526a;

    /* renamed from: b, reason: collision with root package name */
    private final bqn f1527b;
    private final Future<axe> c = xl.a(new au(this));
    private final Context d;
    private final aw e;
    private WebView f;
    private brh g;
    private axe h;
    private AsyncTask<Void, Void, String> i;

    public ar(Context context, bqn bqnVar, String str, aar aarVar) {
        this.d = context;
        this.f1526a = aarVar;
        this.f1527b = bqnVar;
        this.f = new WebView(this.d);
        this.e = new aw(str);
        a(0);
        this.f.setVerticalScrollBarEnabled(false);
        this.f.getSettings().setJavaScriptEnabled(true);
        this.f.setWebViewClient(new as(this));
        this.f.setOnTouchListener(new at(this));
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final String a() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void b(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final boolean m() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final String q_() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void r() {
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final boolean s() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final bsw t() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final com.google.android.gms.dynamic.a k() {
        com.google.android.gms.common.internal.i.b("getAdFrame must be called on the main UI thread.");
        return com.google.android.gms.dynamic.b.a(this.f);
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void j() {
        com.google.android.gms.common.internal.i.b("destroy must be called on the main UI thread.");
        this.i.cancel(true);
        this.c.cancel(true);
        this.f.destroy();
        this.f = null;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final boolean b(bqj bqjVar) {
        com.google.android.gms.common.internal.i.a(this.f, "This Search Ad has already been torn down");
        this.e.a(bqjVar, this.f1526a);
        this.i = new av(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void o() {
        com.google.android.gms.common.internal.i.b("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void p() {
        com.google.android.gms.common.internal.i.b("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brh brhVar) {
        this.g = brhVar;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bsa bsaVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brx brxVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final Bundle q() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void H() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void n() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final bqn l() {
        return this.f1527b;
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bqn bqnVar) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(nt ntVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(oa oaVar, String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final String D() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final bsa E() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final brh F() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(com.google.android.gms.internal.ads.ai aiVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(brd brdVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(bsg bsgVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(ue ueVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void b(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(buc bucVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void a(btc btcVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.brs
    public final void c(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    final int c(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            bra.a();
            return aac.a(this.d, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    final void a(int i) {
        if (this.f == null) {
            return;
        }
        this.f.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    final String c() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) bra.e().a(com.google.android.gms.internal.ads.o.bQ));
        builder.appendQueryParameter("query", this.e.b());
        builder.appendQueryParameter("pubId", this.e.c());
        Map<String, String> mapD = this.e.d();
        for (String str : mapD.keySet()) {
            builder.appendQueryParameter(str, mapD.get(str));
        }
        Uri uriBuild = builder.build();
        if (this.h != null) {
            try {
                uriBuild = this.h.a(uriBuild, this.d);
            } catch (zzcv e) {
                xe.c("Unable to process ad data", e);
            }
        }
        String strD = d();
        String encodedQuery = uriBuild.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(strD).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(strD);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    final String d() {
        String strA = this.e.a();
        if (TextUtils.isEmpty(strA)) {
            strA = "www.google.com";
        }
        String str = (String) bra.e().a(com.google.android.gms.internal.ads.o.bQ);
        StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 8 + String.valueOf(str).length());
        sb.append("https://");
        sb.append(strA);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(String str) throws zzcv {
        if (this.h == null) {
            return str;
        }
        Uri uriA = Uri.parse(str);
        try {
            uriA = this.h.a(uriA, this.d, null, null);
        } catch (zzcv e) {
            xe.c("Unable to process ad data", e);
        }
        return uriA.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.d.startActivity(intent);
    }
}
