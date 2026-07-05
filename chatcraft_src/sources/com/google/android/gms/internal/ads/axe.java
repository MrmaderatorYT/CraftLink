package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public final class axe {
    private static final String[] e = {"/aclk", "/pcs/click"};

    /* renamed from: a, reason: collision with root package name */
    private String f2363a = "googleads.g.doubleclick.net";

    /* renamed from: b, reason: collision with root package name */
    private String f2364b = "/pagead/ads";
    private String c = "ad.doubleclick.net";
    private String[] d = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private axa f;

    public axe(axa axaVar) {
        this.f = axaVar;
    }

    private final boolean c(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.c);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final boolean a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String str : this.d) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final axa a() {
        return this.f;
    }

    public final Uri a(Uri uri, Context context) {
        return a(uri, context, null, false, null, null);
    }

    public final void a(MotionEvent motionEvent) {
        this.f.a(motionEvent);
    }

    public final Uri a(Uri uri, Context context, View view, Activity activity) throws zzcv {
        try {
            return a(uri, context, uri.getQueryParameter("ai"), true, view, activity);
        } catch (UnsupportedOperationException unused) {
            throw new zzcv("Provided Uri is not in a valid state");
        }
    }

    public final boolean b(Uri uri) {
        if (a(uri)) {
            for (String str : e) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Uri a(Uri uri, Context context, String str, boolean z, View view, Activity activity) throws zzcv {
        String strA;
        try {
            boolean zC = c(uri);
            if (zC) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzcv("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzcv("Query parameter already exists: ms");
            }
            if (z) {
                strA = this.f.a(context, str, view, activity);
            } else {
                strA = this.f.a(context);
            }
            if (zC) {
                String string = uri.toString();
                int iIndexOf = string.indexOf(";adurl");
                if (iIndexOf != -1) {
                    int i = iIndexOf + 1;
                    return Uri.parse(string.substring(0, i) + "dc_ms=" + strA + ";" + string.substring(i));
                }
                String encodedPath = uri.getEncodedPath();
                int iIndexOf2 = string.indexOf(encodedPath);
                return Uri.parse(string.substring(0, encodedPath.length() + iIndexOf2) + ";dc_ms=" + strA + ";" + string.substring(iIndexOf2 + encodedPath.length()));
            }
            String string2 = uri.toString();
            int iIndexOf3 = string2.indexOf("&adurl");
            if (iIndexOf3 == -1) {
                iIndexOf3 = string2.indexOf("?adurl");
            }
            if (iIndexOf3 != -1) {
                int i2 = iIndexOf3 + 1;
                return Uri.parse(string2.substring(0, i2) + "ms=" + strA + "&" + string2.substring(i2));
            }
            return uri.buildUpon().appendQueryParameter("ms", strA).build();
        } catch (UnsupportedOperationException unused) {
            throw new zzcv("Provided Uri is not in a valid state");
        }
    }
}
