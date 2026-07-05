package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@TargetApi(8)
/* loaded from: classes.dex */
public class xv {
    public int a() {
        return 0;
    }

    public String a(Context context) {
        return BuildConfig.FLAVOR;
    }

    public String a(SslError sslError) {
        return BuildConfig.FLAVOR;
    }

    public boolean a(DownloadManager.Request request) {
        return false;
    }

    public boolean a(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean a(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean a(Window window) {
        return false;
    }

    public int b() {
        return 1;
    }

    public void b(Context context) {
    }

    public boolean b(View view) {
        return false;
    }

    public int c() {
        return 5;
    }

    public boolean c(View view) {
        return false;
    }

    public int f() {
        return 0;
    }

    public static boolean a(afu afuVar) {
        if (afuVar == null) {
            return false;
        }
        afuVar.onPause();
        return true;
    }

    public static boolean b(afu afuVar) {
        if (afuVar == null) {
            return false;
        }
        afuVar.onResume();
        return true;
    }

    public afv a(afu afuVar, bos bosVar, boolean z) {
        return new afv(afuVar, bosVar, z);
    }

    public Set<String> a(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int iIndexOf = encodedQuery.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = encodedQuery.length();
            }
            int iIndexOf2 = encodedQuery.indexOf(61, i);
            if (iIndexOf2 > iIndexOf || iIndexOf2 == -1) {
                iIndexOf2 = iIndexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, iIndexOf2)));
            i = iIndexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public ViewGroup.LayoutParams d() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public void a(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public Drawable a(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static boolean e() {
        int iMyUid = Process.myUid();
        return iMyUid == 0 || iMyUid == 1000;
    }

    public CookieManager c(Context context) {
        if (e()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            xe.b("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.ax.i().a(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public WebResourceResponse a(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    private xv() {
    }
}
