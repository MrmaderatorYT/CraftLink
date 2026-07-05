package com.google.android.gms.ads.internal.gmsg;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bu;
import com.google.android.gms.internal.ads.agq;
import com.google.android.gms.internal.ads.agr;
import com.google.android.gms.internal.ads.agv;
import com.google.android.gms.internal.ads.agy;
import com.google.android.gms.internal.ads.aha;
import com.google.android.gms.internal.ads.axe;
import com.google.android.gms.internal.ads.mx;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.wd;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.zzcv;
import java.net.URISyntaxException;
import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class d<T extends agq & agr & agv & agy & aha> implements ac<T> {

    /* renamed from: a, reason: collision with root package name */
    private final bu f1594a;

    /* renamed from: b, reason: collision with root package name */
    private final mx f1595b;

    public d(bu buVar, mx mxVar) {
        this.f1594a = buVar;
        this.f1595b = mxVar;
    }

    private static boolean a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int b(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return ax.g().b();
        }
        if ("l".equalsIgnoreCase(str)) {
            return ax.g().a();
        }
        if ("c".equalsIgnoreCase(str)) {
            return ax.g().c();
        }
        return -1;
    }

    private final void a(boolean z) {
        if (this.f1595b != null) {
            this.f1595b.a(z);
        }
    }

    static String a(Context context, axe axeVar, String str, View view, Activity activity) {
        if (axeVar == null) {
            return str;
        }
        try {
            Uri uriA = Uri.parse(str);
            if (axeVar.b(uriA)) {
                uriA = axeVar.a(uriA, context, view, activity);
            }
            return uriA.toString();
        } catch (zzcv unused) {
            return str;
        } catch (Exception e) {
            ax.i().a(e, "OpenGmsgHandler.maybeAddClickSignalsToUrl");
            return str;
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(Object obj, Map map) throws URISyntaxException {
        agq agqVar = (agq) obj;
        String strA = wd.a((String) map.get("u"), agqVar.getContext(), true);
        String str = (String) map.get("a");
        if (str == null) {
            xe.e("Action missing from an open GMSG.");
            return;
        }
        if (this.f1594a != null && !this.f1594a.b()) {
            this.f1594a.a(strA);
            return;
        }
        if ("expand".equalsIgnoreCase(str)) {
            if (((agr) agqVar).B()) {
                xe.e("Cannot expand WebView that is already expanded.");
                return;
            } else {
                a(false);
                ((agv) agqVar).a(a((Map<String, String>) map), b(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str)) {
            a(false);
            if (strA != null) {
                ((agv) agqVar).a(a((Map<String, String>) map), b(map), strA);
                return;
            } else {
                ((agv) agqVar).a(a((Map<String, String>) map), b(map), (String) map.get("html"), (String) map.get("baseurl"));
                return;
            }
        }
        if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
            a(true);
            agqVar.getContext();
            if (TextUtils.isEmpty(strA)) {
                xe.e("Destination url cannot be empty.");
                return;
            }
            try {
                ((agv) agqVar).a(new com.google.android.gms.ads.internal.overlay.c(new e(agqVar.getContext(), ((agy) agqVar).z(), ((aha) agqVar).getView()).a((Map<String, String>) map)));
                return;
            } catch (ActivityNotFoundException e) {
                xe.e(e.getMessage());
                return;
            }
        }
        a(true);
        String str2 = (String) map.get("intent_url");
        Intent uri = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                uri = Intent.parseUri(str2, 0);
            } catch (URISyntaxException e2) {
                String strValueOf = String.valueOf(str2);
                xe.b(strValueOf.length() != 0 ? "Error parsing the url: ".concat(strValueOf) : new String("Error parsing the url: "), e2);
            }
        }
        if (uri != null && uri.getData() != null) {
            Uri data = uri.getData();
            String string = data.toString();
            if (!TextUtils.isEmpty(string)) {
                try {
                    string = a(agqVar.getContext(), ((agy) agqVar).z(), string, ((aha) agqVar).getView(), agqVar.d());
                } catch (Exception e3) {
                    xe.b("Error occurred while adding signals.", e3);
                    ax.i().a(e3, "OpenGmsgHandler.onGmsg");
                }
                try {
                    data = Uri.parse(string);
                } catch (Exception e4) {
                    String strValueOf2 = String.valueOf(string);
                    xe.b(strValueOf2.length() != 0 ? "Error parsing the uri: ".concat(strValueOf2) : new String("Error parsing the uri: "), e4);
                    ax.i().a(e4, "OpenGmsgHandler.onGmsg");
                }
            }
            uri.setData(data);
        }
        if (uri != null) {
            ((agv) agqVar).a(new com.google.android.gms.ads.internal.overlay.c(uri));
            return;
        }
        if (!TextUtils.isEmpty(strA)) {
            strA = a(agqVar.getContext(), ((agy) agqVar).z(), strA, ((aha) agqVar).getView(), agqVar.d());
        }
        ((agv) agqVar).a(new com.google.android.gms.ads.internal.overlay.c((String) map.get("i"), strA, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
    }
}
