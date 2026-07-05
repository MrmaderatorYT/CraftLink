package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public interface afu extends com.google.android.gms.ads.internal.aq, adk, agq, agr, agv, agy, agz, aha, bmk, gv, hu {
    com.google.android.gms.dynamic.a A();

    @Override // com.google.android.gms.internal.ads.agr
    boolean B();

    boolean C();

    void D();

    boolean E();

    boolean F();

    boolean G();

    void H();

    void I();

    bd J();

    void K();

    void L();

    void a(int i);

    void a(Context context);

    void a(com.google.android.gms.ads.internal.overlay.d dVar);

    void a(com.google.android.gms.dynamic.a aVar);

    @Override // com.google.android.gms.internal.ads.adk
    void a(agj agjVar);

    void a(ahh ahhVar);

    void a(bd bdVar);

    void a(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar);

    void a(String str, com.google.android.gms.common.util.k<com.google.android.gms.ads.internal.gmsg.ac<? super afu>> kVar);

    @Override // com.google.android.gms.internal.ads.adk
    void a(String str, aex aexVar);

    void a(String str, String str2, String str3);

    @Override // com.google.android.gms.internal.ads.adk
    agj b();

    void b(com.google.android.gms.ads.internal.overlay.d dVar);

    void b(String str);

    void b(String str, com.google.android.gms.ads.internal.gmsg.ac<? super afu> acVar);

    void b(boolean z);

    void c(boolean z);

    @Override // com.google.android.gms.internal.ads.adk, com.google.android.gms.internal.ads.agq
    Activity d();

    void d(boolean z);

    void destroy();

    @Override // com.google.android.gms.internal.ads.adk
    com.google.android.gms.ads.internal.bt e();

    void e(boolean z);

    void f(boolean z);

    @Override // com.google.android.gms.internal.ads.adk, com.google.android.gms.internal.ads.agq
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    View.OnClickListener getOnClickListener();

    ViewParent getParent();

    int getRequestedOrientation();

    @Override // com.google.android.gms.internal.ads.aha
    View getView();

    WebView getWebView();

    int getWidth();

    @Override // com.google.android.gms.internal.ads.adk
    aa j();

    @Override // com.google.android.gms.internal.ads.adk, com.google.android.gms.internal.ads.agz
    aar k();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void o();

    void onPause();

    void onResume();

    void p();

    void q();

    Context r();

    com.google.android.gms.ads.internal.overlay.d s();

    @Override // com.google.android.gms.internal.ads.adk
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    com.google.android.gms.ads.internal.overlay.d t();

    @Override // com.google.android.gms.internal.ads.agx
    ahh u();

    String v();

    ahb w();

    WebViewClient x();

    boolean y();

    @Override // com.google.android.gms.internal.ads.agy
    axe z();
}
