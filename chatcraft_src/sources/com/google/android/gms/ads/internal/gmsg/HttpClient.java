package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.gv;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xl;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@Keep
@KeepName
/* loaded from: classes.dex */
public class HttpClient implements ac<gv> {
    private final Context mContext;
    private final aar zzbob;

    public HttpClient(Context context, aar aarVar) {
        this.mContext = context;
        this.zzbob = aarVar;
    }

    @qj
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f1576a;

        /* renamed from: b, reason: collision with root package name */
        private final String f1577b;

        public a(String str, String str2) {
            this.f1576a = str;
            this.f1577b = str2;
        }

        public final String a() {
            return this.f1576a;
        }

        public final String b() {
            return this.f1577b;
        }
    }

    @qj
    class c {

        /* renamed from: a, reason: collision with root package name */
        private final d f1580a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f1581b;
        private final String c;

        public c(HttpClient httpClient, boolean z, d dVar, String str) {
            this.f1581b = z;
            this.f1580a = dVar;
            this.c = str;
        }

        public final String a() {
            return this.c;
        }

        public final d b() {
            return this.f1580a;
        }

        public final boolean c() {
            return this.f1581b;
        }
    }

    private static b zzc(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("http_request_id");
        String strOptString2 = jSONObject.optString("url");
        URL url = null;
        String strOptString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(strOptString2);
        } catch (MalformedURLException e) {
            xe.b("Error constructing http request.", e);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("headers");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(new a(jSONObjectOptJSONObject.optString("key"), jSONObjectOptJSONObject.optString("value")));
            }
        }
        return new b(strOptString, url, arrayList, strOptString3);
    }

    @qj
    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f1578a;

        /* renamed from: b, reason: collision with root package name */
        private final URL f1579b;
        private final ArrayList<a> c;
        private final String d;

        b(String str, URL url, ArrayList<a> arrayList, String str2) {
            this.f1578a = str;
            this.f1579b = url;
            this.c = arrayList;
            this.d = str2;
        }

        public final String a() {
            return this.f1578a;
        }

        public final URL b() {
            return this.f1579b;
        }

        public final ArrayList<a> c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }
    }

    @qj
    static class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f1582a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1583b;
        private final List<a> c;
        private final String d;

        d(String str, int i, List<a> list, String str2) {
            this.f1582a = str;
            this.f1583b = i;
            this.c = list;
            this.d = str2;
        }

        public final String a() {
            return this.f1582a;
        }

        public final int b() {
            return this.f1583b;
        }

        public final Iterable<a> c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }
    }

    private static JSONObject zza(d dVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", dVar.a());
            if (dVar.d() != null) {
                jSONObject.put("body", dVar.d());
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar : dVar.c()) {
                jSONArray.put(new JSONObject().put("key", aVar.a()).put("value", aVar.b()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", dVar.b());
        } catch (JSONException e) {
            xe.b("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.ads.internal.gmsg.HttpClient.c zza(com.google.android.gms.ads.internal.gmsg.HttpClient.b r13) throws java.lang.Throwable {
        /*
            r12 = this;
            r0 = 0
            r1 = 0
            java.net.URL r2 = r13.b()     // Catch: java.lang.Throwable -> Led java.lang.Exception -> Lf0
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> Led java.lang.Exception -> Lf0
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Throwable -> Led java.lang.Exception -> Lf0
            com.google.android.gms.internal.ads.xn r3 = com.google.android.gms.ads.internal.ax.e()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            android.content.Context r4 = r12.mContext     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            com.google.android.gms.internal.ads.aar r5 = r12.zzbob     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.lang.String r5 = r5.f1790a     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r3.a(r4, r5, r0, r2)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.util.ArrayList r3 = r13.c()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            int r4 = r3.size()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r5 = 0
        L24:
            if (r5 >= r4) goto L3a
            java.lang.Object r6 = r3.get(r5)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            int r5 = r5 + 1
            com.google.android.gms.ads.internal.gmsg.HttpClient$a r6 = (com.google.android.gms.ads.internal.gmsg.HttpClient.a) r6     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.lang.String r7 = r6.a()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.lang.String r6 = r6.b()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r2.addRequestProperty(r7, r6)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            goto L24
        L3a:
            java.lang.String r3 = r13.d()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r4 = 1
            if (r3 != 0) goto L64
            r2.setDoOutput(r4)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.lang.String r3 = r13.d()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            int r5 = r3.length     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r2.setFixedLengthStreamingMode(r5)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.io.OutputStream r6 = r2.getOutputStream()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r5.<init>(r6)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r5.write(r3)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r5.close()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            goto L65
        L64:
            r3 = r1
        L65:
            com.google.android.gms.internal.ads.aag r5 = new com.google.android.gms.internal.ads.aag     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r5.<init>()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r5.a(r2, r3)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r3.<init>()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.util.Map r6 = r2.getHeaderFields()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            if (r6 == 0) goto Lb5
            java.util.Map r6 = r2.getHeaderFields()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.util.Set r6 = r6.entrySet()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
        L84:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            if (r7 == 0) goto Lb5
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.lang.Object r8 = r7.getValue()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
        L9a:
            boolean r9 = r8.hasNext()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            if (r9 == 0) goto L84
            java.lang.Object r9 = r8.next()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            com.google.android.gms.ads.internal.gmsg.HttpClient$a r10 = new com.google.android.gms.ads.internal.gmsg.HttpClient$a     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.lang.Object r11 = r7.getKey()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r10.<init>(r11, r9)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r3.add(r10)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            goto L9a
        Lb5:
            com.google.android.gms.ads.internal.gmsg.HttpClient$d r6 = new com.google.android.gms.ads.internal.gmsg.HttpClient$d     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.lang.String r13 = r13.a()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            int r7 = r2.getResponseCode()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            com.google.android.gms.ads.internal.ax.e()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.io.InputStream r9 = r2.getInputStream()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r8.<init>(r9)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.lang.String r8 = com.google.android.gms.internal.ads.xn.a(r8)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r6.<init>(r13, r7, r3, r8)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            int r13 = r6.b()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r5.a(r2, r13)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            java.lang.String r13 = r6.d()     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r5.a(r13)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            com.google.android.gms.ads.internal.gmsg.HttpClient$c r13 = new com.google.android.gms.ads.internal.gmsg.HttpClient$c     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            r13.<init>(r12, r4, r6, r1)     // Catch: java.lang.Exception -> Leb java.lang.Throwable -> L101
            if (r2 == 0) goto Lea
            r2.disconnect()
        Lea:
            return r13
        Leb:
            r13 = move-exception
            goto Lf2
        Led:
            r13 = move-exception
            r2 = r1
            goto L102
        Lf0:
            r13 = move-exception
            r2 = r1
        Lf2:
            com.google.android.gms.ads.internal.gmsg.HttpClient$c r3 = new com.google.android.gms.ads.internal.gmsg.HttpClient$c     // Catch: java.lang.Throwable -> L101
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L101
            r3.<init>(r12, r0, r1, r13)     // Catch: java.lang.Throwable -> L101
            if (r2 == 0) goto L100
            r2.disconnect()
        L100:
            return r3
        L101:
            r13 = move-exception
        L102:
            if (r2 == 0) goto L107
            r2.disconnect()
        L107:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.HttpClient.zza(com.google.android.gms.ads.internal.gmsg.HttpClient$b):com.google.android.gms.ads.internal.gmsg.HttpClient$c");
    }

    @Keep
    @KeepName
    public JSONObject send(JSONObject jSONObject) throws Throwable {
        String strOptString;
        JSONObject jSONObject2 = new JSONObject();
        try {
            strOptString = jSONObject.optString("http_request_id");
            try {
                c cVarZza = zza(zzc(jSONObject));
                if (cVarZza.c()) {
                    jSONObject2.put("response", zza(cVarZza.b()));
                    jSONObject2.put("success", true);
                } else {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", strOptString));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", cVarZza.a());
                }
            } catch (Exception e) {
                e = e;
                xe.b("Error executing http request.", e);
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", strOptString));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                } catch (JSONException e2) {
                    xe.b("Error executing http request.", e2);
                }
                return jSONObject2;
            }
        } catch (Exception e3) {
            e = e3;
            strOptString = BuildConfig.FLAVOR;
        }
        return jSONObject2;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(gv gvVar, Map map) {
        xl.a(new ad(this, map, gvVar));
    }
}
