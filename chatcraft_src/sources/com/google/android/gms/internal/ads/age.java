package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.c.a;
import java.util.Map;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class age extends FrameLayout implements afu {

    /* renamed from: a, reason: collision with root package name */
    private final afu f1955a;

    /* renamed from: b, reason: collision with root package name */
    private final adb f1956b;

    public age(afu afuVar) {
        super(afuVar.getContext());
        this.f1955a = afuVar;
        this.f1956b = new adb(afuVar.r(), this, this);
        addView(this.f1955a.getView());
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.aha
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final adb a() {
        return this.f1956b;
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void onPause() {
        this.f1956b.b();
        this.f1955a.onPause();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void D() {
        this.f1956b.c();
        this.f1955a.D();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void K() {
        setBackgroundColor(0);
        this.f1955a.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final int l() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final int m() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final void n() {
        this.f1955a.n();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final WebView getWebView() {
        return this.f1955a.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.gv
    public final void a(String str, Map<String, ?> map) {
        this.f1955a.a(str, map);
    }

    @Override // com.google.android.gms.internal.ads.gv
    public final void a(String str, JSONObject jSONObject) {
        this.f1955a.a(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        this.f1955a.a(str, acVar);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void b(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar) {
        this.f1955a.b(str, acVar);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(String str, com.google.android.gms.common.util.k<com.google.android.gms.ads.internal.gmsg.ac<? super afu>> kVar) {
        this.f1955a.a(str, kVar);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void o() {
        this.f1955a.o();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(int i) {
        this.f1955a.a(i);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void p() {
        this.f1955a.p();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void q() {
        this.f1955a.q();
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final void a(boolean z, long j) {
        this.f1955a.a(z, j);
    }

    @Override // com.google.android.gms.internal.ads.hu
    public final void d(String str) {
        this.f1955a.d(str);
    }

    @Override // com.google.android.gms.internal.ads.hu
    public final void b(String str, JSONObject jSONObject) {
        this.f1955a.b(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk, com.google.android.gms.internal.ads.agq
    public final Activity d() {
        return this.f1955a.d();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final Context r() {
        return this.f1955a.r();
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final com.google.android.gms.ads.internal.bt e() {
        return this.f1955a.e();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final com.google.android.gms.ads.internal.overlay.d s() {
        return this.f1955a.s();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final com.google.android.gms.dynamic.a A() {
        return this.f1955a.A();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final com.google.android.gms.ads.internal.overlay.d t() {
        return this.f1955a.t();
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.agx
    public final ahh u() {
        return this.f1955a.u();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final String v() {
        return this.f1955a.v();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final ahb w() {
        return this.f1955a.w();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final WebViewClient x() {
        return this.f1955a.x();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final boolean y() {
        return this.f1955a.y();
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.agy
    public final axe z() {
        return this.f1955a.z();
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk, com.google.android.gms.internal.ads.agz
    public final aar k() {
        return this.f1955a.k();
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.agr
    public final boolean B() {
        return this.f1955a.B();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final int getRequestedOrientation() {
        return this.f1955a.getRequestedOrientation();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final boolean C() {
        return this.f1955a.C();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final boolean E() {
        return this.f1955a.E();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final boolean F() {
        return this.f1955a.F();
    }

    @Override // com.google.android.gms.ads.internal.aq
    public final void i_() {
        this.f1955a.i_();
    }

    @Override // com.google.android.gms.ads.internal.aq
    public final void h_() {
        this.f1955a.h_();
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final String g() {
        return this.f1955a.g();
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final z c() {
        return this.f1955a.c();
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final aa j() {
        return this.f1955a.j();
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final agj b() {
        return this.f1955a.b();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(com.google.android.gms.ads.internal.overlay.d dVar) {
        this.f1955a.a(dVar);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(com.google.android.gms.dynamic.a aVar) {
        this.f1955a.a(aVar);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(ahh ahhVar) {
        this.f1955a.a(ahhVar);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void b(boolean z) {
        this.f1955a.b(z);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void H() {
        this.f1955a.H();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(Context context) {
        this.f1955a.a(context);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void c(boolean z) {
        this.f1955a.c(z);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void setRequestedOrientation(int i) {
        this.f1955a.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void b(com.google.android.gms.ads.internal.overlay.d dVar) {
        this.f1955a.b(dVar);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void d(boolean z) {
        this.f1955a.d(z);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void b(String str) {
        this.f1955a.b(str);
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final void a(String str, aex aexVar) {
        this.f1955a.a(str, aexVar);
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final aex a(String str) {
        return this.f1955a.a(str);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void I() {
        this.f1955a.I();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void destroy() {
        com.google.android.gms.dynamic.a aVarA = A();
        if (aVarA != null) {
            com.google.android.gms.ads.internal.ax.v().b(aVarA);
            xn.f3583a.postDelayed(new agf(this), ((Integer) bra.e().a(o.cD)).intValue());
            return;
        }
        this.f1955a.destroy();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void loadData(String str, String str2, String str3) {
        this.f1955a.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f1955a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void loadUrl(String str) {
        this.f1955a.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(String str, String str2, String str3) {
        this.f1955a.a(str, str2, str3);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.afu
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1955a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.afu
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f1955a.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f1955a.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.f1955a.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void stopLoading() {
        this.f1955a.stopLoading();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void onResume() {
        this.f1955a.onResume();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void L() {
        TextView textView = new TextView(getContext());
        Resources resourcesG = com.google.android.gms.ads.internal.ax.i().g();
        textView.setText(resourcesG != null ? resourcesG.getString(a.C0065a.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void f(boolean z) {
        this.f1955a.f(z);
    }

    @Override // com.google.android.gms.internal.ads.bmk
    public final void a(bmj bmjVar) {
        this.f1955a.a(bmjVar);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final View.OnClickListener getOnClickListener() {
        return this.f1955a.getOnClickListener();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void a(bd bdVar) {
        this.f1955a.a(bdVar);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final bd J() {
        return this.f1955a.J();
    }

    @Override // com.google.android.gms.internal.ads.afu, com.google.android.gms.internal.ads.adk
    public final void a(agj agjVar) {
        this.f1955a.a(agjVar);
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final boolean G() {
        return this.f1955a.G();
    }

    @Override // com.google.android.gms.internal.ads.afu
    public final void e(boolean z) {
        this.f1955a.e(z);
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final void a(boolean z) {
        this.f1955a.a(z);
    }

    @Override // com.google.android.gms.internal.ads.adk
    public final void f() {
        this.f1955a.f();
    }

    @Override // com.google.android.gms.internal.ads.agv
    public final void a(com.google.android.gms.ads.internal.overlay.c cVar) {
        this.f1955a.a(cVar);
    }

    @Override // com.google.android.gms.internal.ads.agv
    public final void a(boolean z, int i) {
        this.f1955a.a(z, i);
    }

    @Override // com.google.android.gms.internal.ads.agv
    public final void a(boolean z, int i, String str) {
        this.f1955a.a(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.agv
    public final void a(boolean z, int i, String str, String str2) {
        this.f1955a.a(z, i, str, str2);
    }
}
