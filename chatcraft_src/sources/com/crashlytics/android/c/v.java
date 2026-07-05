package com.crashlytics.android.c;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DefaultCreateReportSpiCall.java */
/* loaded from: classes.dex */
class v extends io.fabric.sdk.android.services.b.a implements t {
    public v(io.fabric.sdk.android.h hVar, String str, String str2, io.fabric.sdk.android.services.network.d dVar) {
        super(hVar, str, str2, dVar, io.fabric.sdk.android.services.network.c.POST);
    }

    @Override // com.crashlytics.android.c.t
    public boolean a(s sVar) throws Throwable {
        HttpRequest httpRequestA = a(a(b(), sVar), sVar.f1426b);
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Sending report to: " + a());
        int iB = httpRequestA.b();
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Create report request ID: " + httpRequestA.b("X-REQUEST-ID"));
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Result was: " + iB);
        return io.fabric.sdk.android.services.b.u.a(iB) == 0;
    }

    private HttpRequest a(HttpRequest httpRequest, s sVar) {
        HttpRequest httpRequestA = httpRequest.a("X-CRASHLYTICS-API-KEY", sVar.f1425a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f4201a.a());
        Iterator<Map.Entry<String, String>> it = sVar.f1426b.e().entrySet().iterator();
        while (it.hasNext()) {
            httpRequestA = httpRequestA.a(it.next());
        }
        return httpRequestA;
    }

    private HttpRequest a(HttpRequest httpRequest, ao aoVar) throws Throwable {
        httpRequest.e("report[identifier]", aoVar.b());
        if (aoVar.d().length == 1) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Adding single file " + aoVar.a() + " to report " + aoVar.b());
            return httpRequest.a("report[file]", aoVar.a(), "application/octet-stream", aoVar.c());
        }
        int i = 0;
        for (File file : aoVar.d()) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Adding file " + file.getName() + " to report " + aoVar.b());
            StringBuilder sb = new StringBuilder();
            sb.append("report[file");
            sb.append(i);
            sb.append("]");
            httpRequest.a(sb.toString(), file.getName(), "application/octet-stream", file);
            i++;
        }
        return httpRequest;
    }
}
