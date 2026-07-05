package com.google.android.gms.ads.internal.gmsg;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.adk;
import com.google.android.gms.internal.ads.aes;
import com.google.android.gms.internal.ads.aet;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.agq;
import com.google.android.gms.internal.ads.agy;
import com.google.android.gms.internal.ads.agz;
import com.google.android.gms.internal.ads.aha;
import com.google.android.gms.internal.ads.axe;
import com.google.android.gms.internal.ads.gv;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.wd;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.zq;
import com.google.android.gms.internal.ads.zzcv;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final ac<afu> f1602a = o.f1604a;

    /* renamed from: b, reason: collision with root package name */
    public static final ac<afu> f1603b = p.f1605a;
    public static final ac<afu> c = q.f1606a;
    public static final ac<afu> d = new t();
    public static final ac<afu> e = new u();
    public static final ac<afu> f = r.f1607a;
    public static final ac<Object> g = new v();
    public static final ac<afu> h = new w();
    public static final ac<afu> i = s.f1608a;
    public static final ac<afu> j = new x();
    public static final ac<afu> k = new y();
    public static final ac<adk> l = new aes();
    public static final ac<adk> m = new aet();
    public static final ac<afu> n = new m();
    public static final f o = new f();
    public static final ac<afu> p = new z();
    public static final ac<afu> q = new aa();
    public static final ac<afu> r = new ab();

    static final /* synthetic */ void a(agy agyVar, Map map) throws NumberFormatException {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int i2 = Integer.parseInt(str);
            int i3 = Integer.parseInt(str2);
            int i4 = Integer.parseInt(str3);
            axe axeVarZ = agyVar.z();
            if (axeVarZ != null) {
                axeVarZ.a().a(i2, i3, i4);
            }
        } catch (NumberFormatException unused) {
            xe.e("Could not parse touch parameters from gmsg.");
        }
    }

    static final /* synthetic */ void a(agq agqVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            xe.e("URL missing from httpTrack GMSG.");
        } else {
            new zq(agqVar.getContext(), ((agz) agqVar).k().f1790a, str).h();
        }
    }

    static final /* synthetic */ void a(gv gvVar, Map map) throws zzcv {
        String str = (String) map.get("u");
        if (str == null) {
            xe.e("URL missing from click GMSG.");
            return;
        }
        Uri uriA = Uri.parse(str);
        try {
            axe axeVarZ = ((agy) gvVar).z();
            if (axeVarZ != null && axeVarZ.a(uriA)) {
                uriA = axeVarZ.a(uriA, ((agq) gvVar).getContext(), ((aha) gvVar).getView(), ((agq) gvVar).d());
            }
        } catch (zzcv unused) {
            String strValueOf = String.valueOf(str);
            xe.e(strValueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(strValueOf) : new String("Unable to append parameter to URL: "));
        }
        agq agqVar = (agq) gvVar;
        new zq(agqVar.getContext(), ((agz) gvVar).k().f1790a, wd.a(uriA, agqVar.getContext())).h();
    }

    static final /* synthetic */ void b(agq agqVar, Map map) throws JSONException, URISyntaxException {
        PackageManager packageManager = agqVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String strOptString = jSONObject2.optString("id");
                        String strOptString2 = jSONObject2.optString("u");
                        String strOptString3 = jSONObject2.optString("i");
                        String strOptString4 = jSONObject2.optString("m");
                        String strOptString5 = jSONObject2.optString("p");
                        String strOptString6 = jSONObject2.optString("c");
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        String strOptString7 = jSONObject2.optString("intent_url");
                        Intent uri = null;
                        if (!TextUtils.isEmpty(strOptString7)) {
                            try {
                                uri = Intent.parseUri(strOptString7, 0);
                            } catch (URISyntaxException e2) {
                                String strValueOf = String.valueOf(strOptString7);
                                xe.b(strValueOf.length() != 0 ? "Error parsing the url: ".concat(strValueOf) : new String("Error parsing the url: "), e2);
                            }
                        }
                        if (uri == null) {
                            uri = new Intent();
                            if (!TextUtils.isEmpty(strOptString2)) {
                                uri.setData(Uri.parse(strOptString2));
                            }
                            if (!TextUtils.isEmpty(strOptString3)) {
                                uri.setAction(strOptString3);
                            }
                            if (!TextUtils.isEmpty(strOptString4)) {
                                uri.setType(strOptString4);
                            }
                            if (!TextUtils.isEmpty(strOptString5)) {
                                uri.setPackage(strOptString5);
                            }
                            if (!TextUtils.isEmpty(strOptString6)) {
                                String[] strArrSplit = strOptString6.split("/", 2);
                                if (strArrSplit.length == 2) {
                                    uri.setComponent(new ComponentName(strArrSplit[0], strArrSplit[1]));
                                }
                            }
                        }
                        try {
                            jSONObject.put(strOptString, packageManager.resolveActivity(uri, 65536) != null);
                        } catch (JSONException e3) {
                            xe.b("Error constructing openable urls response.", e3);
                        }
                    } catch (JSONException e4) {
                        xe.b("Error parsing the intent data.", e4);
                    }
                }
                ((gv) agqVar).a("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((gv) agqVar).a("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((gv) agqVar).a("openableIntents", new JSONObject());
        }
    }

    static final /* synthetic */ void c(agq agqVar, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            xe.e("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] strArrSplit = str.split(",");
        HashMap map2 = new HashMap();
        PackageManager packageManager = agqVar.getContext().getPackageManager();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), 65536) == null) {
                z = false;
            }
            map2.put(str2, Boolean.valueOf(z));
        }
        ((gv) agqVar).a("openableURLs", map2);
    }
}
