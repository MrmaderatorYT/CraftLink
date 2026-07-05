package com.crashlytics.android.a;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.List;

/* compiled from: SessionAnalyticsFilesSender.java */
/* loaded from: classes.dex */
class y extends io.fabric.sdk.android.services.b.a implements io.fabric.sdk.android.services.c.f {

    /* renamed from: b, reason: collision with root package name */
    private final String f1290b;

    public y(io.fabric.sdk.android.h hVar, String str, String str2, io.fabric.sdk.android.services.network.d dVar, String str3) {
        super(hVar, str, str2, dVar, io.fabric.sdk.android.services.network.c.POST);
        this.f1290b = str3;
    }

    @Override // io.fabric.sdk.android.services.c.f
    public boolean a(List<File> list) throws Throwable {
        HttpRequest httpRequestA = b().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f4201a.a()).a("X-CRASHLYTICS-API-KEY", this.f1290b);
        int i = 0;
        for (File file : list) {
            httpRequestA.a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        io.fabric.sdk.android.c.g().a("Answers", "Sending " + list.size() + " analytics files to " + a());
        int iB = httpRequestA.b();
        io.fabric.sdk.android.c.g().a("Answers", "Response code for analytics file send is " + iB);
        return io.fabric.sdk.android.services.b.u.a(iB) == 0;
    }
}
