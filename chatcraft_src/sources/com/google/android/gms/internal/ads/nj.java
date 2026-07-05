package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class nj {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3303a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("sLock")
    private static boolean f3304b = false;

    @GuardedBy("sLock")
    private static boolean c = false;
    private aim d;

    public final boolean a(Context context) {
        synchronized (f3303a) {
            if (!((Boolean) bra.e().a(o.cC)).booleanValue()) {
                return false;
            }
            if (f3304b) {
                return true;
            }
            try {
                c(context);
                boolean zA = this.d.a(com.google.android.gms.dynamic.b.a(context));
                f3304b = zA;
                return zA;
            } catch (RemoteException | NullPointerException e) {
                aan.d("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    private final void c(Context context) {
        synchronized (f3303a) {
            if (((Boolean) bra.e().a(o.cC)).booleanValue() && !c) {
                try {
                    c = true;
                    this.d = (aim) aao.a(context, "com.google.android.gms.ads.omid.DynamiteOmid", nk.f3305a);
                } catch (zzbbg e) {
                    aan.d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final String b(Context context) {
        if (!((Boolean) bra.e().a(o.cC)).booleanValue()) {
            return null;
        }
        try {
            c(context);
            String strValueOf = String.valueOf(this.d.a());
            return strValueOf.length() != 0 ? "a.".concat(strValueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            aan.d("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final com.google.android.gms.dynamic.a a(String str, WebView webView, String str2, String str3, String str4) {
        return a(str, webView, str2, str3, str4, "Google");
    }

    public final com.google.android.gms.dynamic.a a(String str, WebView webView, String str2, String str3, String str4, String str5) throws Throwable {
        synchronized (f3303a) {
            try {
                try {
                    if (((Boolean) bra.e().a(o.cC)).booleanValue() && f3304b) {
                        try {
                            return this.d.a(str, com.google.android.gms.dynamic.b.a(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e) {
                            aan.d("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void a(com.google.android.gms.dynamic.a aVar) {
        synchronized (f3303a) {
            if (((Boolean) bra.e().a(o.cC)).booleanValue() && f3304b) {
                try {
                    this.d.b(aVar);
                } catch (RemoteException | NullPointerException e) {
                    aan.d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void b(com.google.android.gms.dynamic.a aVar) {
        synchronized (f3303a) {
            if (((Boolean) bra.e().a(o.cC)).booleanValue() && f3304b) {
                try {
                    this.d.c(aVar);
                } catch (RemoteException | NullPointerException e) {
                    aan.d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void a(com.google.android.gms.dynamic.a aVar, View view) {
        synchronized (f3303a) {
            if (((Boolean) bra.e().a(o.cC)).booleanValue() && f3304b) {
                try {
                    this.d.a(aVar, com.google.android.gms.dynamic.b.a(view));
                } catch (RemoteException | NullPointerException e) {
                    aan.d("#007 Could not call remote method.", e);
                }
            }
        }
    }
}
