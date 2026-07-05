package com.crashlytics.android.c;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;

/* compiled from: NativeCreateReportSpiCall.java */
/* loaded from: classes.dex */
class af extends io.fabric.sdk.android.services.b.a implements t {
    public af(io.fabric.sdk.android.h hVar, String str, String str2, io.fabric.sdk.android.services.network.d dVar) {
        super(hVar, str, str2, dVar, io.fabric.sdk.android.services.network.c.POST);
    }

    @Override // com.crashlytics.android.c.t
    public boolean a(s sVar) throws Throwable {
        HttpRequest httpRequestA = a(a(b(), sVar.f1425a), sVar.f1426b);
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Sending report to: " + a());
        int iB = httpRequestA.b();
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Result was: " + iB);
        return io.fabric.sdk.android.services.b.u.a(iB) == 0;
    }

    private HttpRequest a(HttpRequest httpRequest, String str) {
        httpRequest.a("User-Agent", "Crashlytics Android SDK/" + this.f4201a.a()).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f4201a.a()).a("X-CRASHLYTICS-API-KEY", str);
        return httpRequest;
    }

    private HttpRequest a(HttpRequest httpRequest, ao aoVar) throws Throwable {
        httpRequest.e("report_id", aoVar.b());
        for (File file : aoVar.d()) {
            if (file.getName().equals("minidump")) {
                httpRequest.a("minidump_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("metadata")) {
                httpRequest.a("crash_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("binaryImages")) {
                httpRequest.a("binary_images_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("session")) {
                httpRequest.a("session_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("app")) {
                httpRequest.a("app_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("device")) {
                httpRequest.a("device_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("os")) {
                httpRequest.a("os_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("user")) {
                httpRequest.a("user_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("logs")) {
                httpRequest.a("logs_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("keys")) {
                httpRequest.a("keys_file", file.getName(), "application/octet-stream", file);
            }
        }
        return httpRequest;
    }
}
