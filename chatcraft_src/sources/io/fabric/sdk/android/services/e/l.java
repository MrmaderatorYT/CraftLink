package io.fabric.sdk.android.services.e;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DefaultSettingsSpiCall.java */
/* loaded from: classes.dex */
class l extends io.fabric.sdk.android.services.b.a implements x {
    boolean a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    public l(io.fabric.sdk.android.h hVar, String str, String str2, io.fabric.sdk.android.services.network.d dVar) {
        this(hVar, str, str2, dVar, io.fabric.sdk.android.services.network.c.GET);
    }

    l(io.fabric.sdk.android.h hVar, String str, String str2, io.fabric.sdk.android.services.network.d dVar, io.fabric.sdk.android.services.network.c cVar) {
        super(hVar, str, str2, dVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad  */
    @Override // io.fabric.sdk.android.services.e.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject a(io.fabric.sdk.android.services.e.w r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            java.util.Map r1 = r7.b(r8)     // Catch: java.lang.Throwable -> L75 io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L7a
            io.fabric.sdk.android.services.network.HttpRequest r2 = r7.a(r1)     // Catch: java.lang.Throwable -> L75 io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L7a
            io.fabric.sdk.android.services.network.HttpRequest r8 = r7.a(r2, r8)     // Catch: java.lang.Throwable -> L6f io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L72
            io.fabric.sdk.android.k r2 = io.fabric.sdk.android.c.g()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            java.lang.String r3 = "Fabric"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            r4.<init>()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            java.lang.String r5 = "Requesting settings from "
            r4.append(r5)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            java.lang.String r5 = r7.a()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            r4.append(r5)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            java.lang.String r4 = r4.toString()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            r2.a(r3, r4)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            io.fabric.sdk.android.k r2 = io.fabric.sdk.android.c.g()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            java.lang.String r3 = "Fabric"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            r4.<init>()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            java.lang.String r5 = "Settings query params were: "
            r4.append(r5)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            r4.append(r1)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            java.lang.String r1 = r4.toString()     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            r2.a(r3, r1)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            org.json.JSONObject r1 = r7.a(r8)     // Catch: io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException -> L6d java.lang.Throwable -> Laa
            if (r8 == 0) goto L6b
            io.fabric.sdk.android.k r0 = io.fabric.sdk.android.c.g()
            java.lang.String r2 = "Fabric"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Settings request ID: "
            r3.append(r4)
            java.lang.String r4 = "X-REQUEST-ID"
            java.lang.String r8 = r8.b(r4)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r0.a(r2, r8)
        L6b:
            r0 = r1
            goto La9
        L6d:
            r1 = move-exception
            goto L7c
        L6f:
            r0 = move-exception
            r8 = r2
            goto Lab
        L72:
            r1 = move-exception
            r8 = r2
            goto L7c
        L75:
            r8 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
            goto Lab
        L7a:
            r1 = move-exception
            r8 = r0
        L7c:
            io.fabric.sdk.android.k r2 = io.fabric.sdk.android.c.g()     // Catch: java.lang.Throwable -> Laa
            java.lang.String r3 = "Fabric"
            java.lang.String r4 = "Settings request failed."
            r2.e(r3, r4, r1)     // Catch: java.lang.Throwable -> Laa
            if (r8 == 0) goto La9
            io.fabric.sdk.android.k r1 = io.fabric.sdk.android.c.g()
            java.lang.String r2 = "Fabric"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Settings request ID: "
            r3.append(r4)
            java.lang.String r4 = "X-REQUEST-ID"
            java.lang.String r8 = r8.b(r4)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            r1.a(r2, r8)
        La9:
            return r0
        Laa:
            r0 = move-exception
        Lab:
            if (r8 == 0) goto Lcd
            io.fabric.sdk.android.k r1 = io.fabric.sdk.android.c.g()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Settings request ID: "
            r2.append(r3)
            java.lang.String r3 = "X-REQUEST-ID"
            java.lang.String r8 = r8.b(r3)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            java.lang.String r2 = "Fabric"
            r1.a(r2, r8)
        Lcd:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.e.l.a(io.fabric.sdk.android.services.e.w):org.json.JSONObject");
    }

    JSONObject a(HttpRequest httpRequest) {
        int iB = httpRequest.b();
        io.fabric.sdk.android.c.g().a("Fabric", "Settings result was: " + iB);
        if (a(iB)) {
            return a(httpRequest.d());
        }
        io.fabric.sdk.android.c.g().e("Fabric", "Failed to retrieve settings from " + a());
        return null;
    }

    private JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            io.fabric.sdk.android.c.g().a("Fabric", "Failed to parse settings JSON from " + a(), e);
            io.fabric.sdk.android.c.g().a("Fabric", "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> b(w wVar) {
        HashMap map = new HashMap();
        map.put("build_version", wVar.h);
        map.put("display_version", wVar.g);
        map.put("source", Integer.toString(wVar.i));
        if (wVar.j != null) {
            map.put("icon_hash", wVar.j);
        }
        String str = wVar.f;
        if (!io.fabric.sdk.android.services.b.i.d(str)) {
            map.put("instance", str);
        }
        return map;
    }

    private HttpRequest a(HttpRequest httpRequest, w wVar) {
        a(httpRequest, "X-CRASHLYTICS-API-KEY", wVar.f4322a);
        a(httpRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        a(httpRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", this.f4201a.a());
        a(httpRequest, "Accept", "application/json");
        a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", wVar.f4323b);
        a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", wVar.c);
        a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", wVar.d);
        a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", wVar.e);
        return httpRequest;
    }

    private void a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.a(str, str2);
        }
    }
}
