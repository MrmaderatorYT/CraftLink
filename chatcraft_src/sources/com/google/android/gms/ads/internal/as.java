package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.zzcv;

/* loaded from: classes.dex */
final class as extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ar f1528a;

    as(ar arVar) {
        this.f1528a = arVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) throws zzcv {
        if (str.startsWith(this.f1528a.d())) {
            return false;
        }
        if (str.startsWith((String) bra.e().a(com.google.android.gms.internal.ads.o.bN))) {
            if (this.f1528a.g != null) {
                try {
                    this.f1528a.g.a(3);
                } catch (RemoteException e) {
                    xe.d("#007 Could not call remote method.", e);
                }
            }
            this.f1528a.a(0);
            return true;
        }
        if (str.startsWith((String) bra.e().a(com.google.android.gms.internal.ads.o.bO))) {
            if (this.f1528a.g != null) {
                try {
                    this.f1528a.g.a(0);
                } catch (RemoteException e2) {
                    xe.d("#007 Could not call remote method.", e2);
                }
            }
            this.f1528a.a(0);
            return true;
        }
        if (str.startsWith((String) bra.e().a(com.google.android.gms.internal.ads.o.bP))) {
            if (this.f1528a.g != null) {
                try {
                    this.f1528a.g.c();
                } catch (RemoteException e3) {
                    xe.d("#007 Could not call remote method.", e3);
                }
            }
            this.f1528a.a(this.f1528a.c(str));
            return true;
        }
        if (str.startsWith("gmsg://")) {
            return true;
        }
        if (this.f1528a.g != null) {
            try {
                this.f1528a.g.b();
            } catch (RemoteException e4) {
                xe.d("#007 Could not call remote method.", e4);
            }
        }
        this.f1528a.e(this.f1528a.d(str));
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.f1528a.g != null) {
            try {
                this.f1528a.g.a(0);
            } catch (RemoteException e) {
                xe.d("#007 Could not call remote method.", e);
            }
        }
    }
}
