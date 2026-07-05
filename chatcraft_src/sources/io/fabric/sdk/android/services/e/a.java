package io.fabric.sdk.android.services.e;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Locale;

/* compiled from: AbstractAppSpiCall.java */
/* loaded from: classes.dex */
abstract class a extends io.fabric.sdk.android.services.b.a {
    public a(io.fabric.sdk.android.h hVar, String str, String str2, io.fabric.sdk.android.services.network.d dVar, io.fabric.sdk.android.services.network.c cVar) {
        super(hVar, str, str2, dVar, cVar);
    }

    public boolean a(d dVar) throws Throwable {
        HttpRequest httpRequestB = b(a(b(), dVar), dVar);
        io.fabric.sdk.android.c.g().a("Fabric", "Sending app info to " + a());
        if (dVar.j != null) {
            io.fabric.sdk.android.c.g().a("Fabric", "App icon hash is " + dVar.j.f4308a);
            io.fabric.sdk.android.c.g().a("Fabric", "App icon size is " + dVar.j.c + "x" + dVar.j.d);
        }
        int iB = httpRequestB.b();
        String str = "POST".equals(httpRequestB.o()) ? "Create" : "Update";
        io.fabric.sdk.android.c.g().a("Fabric", str + " app request ID: " + httpRequestB.b("X-REQUEST-ID"));
        io.fabric.sdk.android.c.g().a("Fabric", "Result was " + iB);
        return io.fabric.sdk.android.services.b.u.a(iB) == 0;
    }

    private HttpRequest a(HttpRequest httpRequest, d dVar) {
        return httpRequest.a("X-CRASHLYTICS-API-KEY", dVar.f4297a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f4201a.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private io.fabric.sdk.android.services.network.HttpRequest b(io.fabric.sdk.android.services.network.HttpRequest r8, io.fabric.sdk.android.services.e.d r9) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "app[identifier]"
            java.lang.String r1 = r9.f4298b
            io.fabric.sdk.android.services.network.HttpRequest r8 = r8.e(r0, r1)
            java.lang.String r0 = "app[name]"
            java.lang.String r1 = r9.f
            io.fabric.sdk.android.services.network.HttpRequest r8 = r8.e(r0, r1)
            java.lang.String r0 = "app[display_version]"
            java.lang.String r1 = r9.c
            io.fabric.sdk.android.services.network.HttpRequest r8 = r8.e(r0, r1)
            java.lang.String r0 = "app[build_version]"
            java.lang.String r1 = r9.d
            io.fabric.sdk.android.services.network.HttpRequest r8 = r8.e(r0, r1)
            java.lang.String r0 = "app[source]"
            int r1 = r9.g
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            io.fabric.sdk.android.services.network.HttpRequest r8 = r8.a(r0, r1)
            java.lang.String r0 = "app[minimum_sdk_version]"
            java.lang.String r1 = r9.h
            io.fabric.sdk.android.services.network.HttpRequest r8 = r8.e(r0, r1)
            java.lang.String r0 = "app[built_sdk_version]"
            java.lang.String r1 = r9.i
            io.fabric.sdk.android.services.network.HttpRequest r8 = r8.e(r0, r1)
            java.lang.String r0 = r9.e
            boolean r0 = io.fabric.sdk.android.services.b.i.d(r0)
            if (r0 != 0) goto L4b
            java.lang.String r0 = "app[instance_identifier]"
            java.lang.String r1 = r9.e
            r8.e(r0, r1)
        L4b:
            io.fabric.sdk.android.services.e.n r0 = r9.j
            if (r0 == 0) goto Lc6
            r0 = 0
            io.fabric.sdk.android.h r1 = r7.f4201a     // Catch: java.lang.Throwable -> L94 android.content.res.Resources.NotFoundException -> L97
            android.content.Context r1 = r1.r()     // Catch: java.lang.Throwable -> L94 android.content.res.Resources.NotFoundException -> L97
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Throwable -> L94 android.content.res.Resources.NotFoundException -> L97
            io.fabric.sdk.android.services.e.n r2 = r9.j     // Catch: java.lang.Throwable -> L94 android.content.res.Resources.NotFoundException -> L97
            int r2 = r2.f4309b     // Catch: java.lang.Throwable -> L94 android.content.res.Resources.NotFoundException -> L97
            java.io.InputStream r1 = r1.openRawResource(r2)     // Catch: java.lang.Throwable -> L94 android.content.res.Resources.NotFoundException -> L97
            java.lang.String r0 = "app[icon][hash]"
            io.fabric.sdk.android.services.e.n r2 = r9.j     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            java.lang.String r2 = r2.f4308a     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            io.fabric.sdk.android.services.network.HttpRequest r0 = r8.e(r0, r2)     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            java.lang.String r2 = "app[icon][data]"
            java.lang.String r3 = "icon.png"
            java.lang.String r4 = "application/octet-stream"
            io.fabric.sdk.android.services.network.HttpRequest r0 = r0.a(r2, r3, r4, r1)     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            java.lang.String r2 = "app[icon][width]"
            io.fabric.sdk.android.services.e.n r3 = r9.j     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            int r3 = r3.c     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            io.fabric.sdk.android.services.network.HttpRequest r0 = r0.a(r2, r3)     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            java.lang.String r2 = "app[icon][height]"
            io.fabric.sdk.android.services.e.n r3 = r9.j     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            int r3 = r3.d     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            r0.a(r2, r3)     // Catch: android.content.res.Resources.NotFoundException -> L92 java.lang.Throwable -> Lbf
            goto Lb9
        L92:
            r0 = move-exception
            goto L9b
        L94:
            r8 = move-exception
            r1 = r0
            goto Lc0
        L97:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L9b:
            io.fabric.sdk.android.k r2 = io.fabric.sdk.android.c.g()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r3 = "Fabric"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r4.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r5 = "Failed to find app icon with resource ID: "
            r4.append(r5)     // Catch: java.lang.Throwable -> Lbf
            io.fabric.sdk.android.services.e.n r5 = r9.j     // Catch: java.lang.Throwable -> Lbf
            int r5 = r5.f4309b     // Catch: java.lang.Throwable -> Lbf
            r4.append(r5)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> Lbf
            r2.e(r3, r4, r0)     // Catch: java.lang.Throwable -> Lbf
        Lb9:
            java.lang.String r0 = "Failed to close app icon InputStream."
            io.fabric.sdk.android.services.b.i.a(r1, r0)
            goto Lc6
        Lbf:
            r8 = move-exception
        Lc0:
            java.lang.String r9 = "Failed to close app icon InputStream."
            io.fabric.sdk.android.services.b.i.a(r1, r9)
            throw r8
        Lc6:
            java.util.Collection<io.fabric.sdk.android.j> r0 = r9.k
            if (r0 == 0) goto Lf3
            java.util.Collection<io.fabric.sdk.android.j> r9 = r9.k
            java.util.Iterator r9 = r9.iterator()
        Ld0:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto Lf3
            java.lang.Object r0 = r9.next()
            io.fabric.sdk.android.j r0 = (io.fabric.sdk.android.j) r0
            java.lang.String r1 = r7.a(r0)
            java.lang.String r2 = r0.b()
            r8.e(r1, r2)
            java.lang.String r1 = r7.b(r0)
            java.lang.String r0 = r0.c()
            r8.e(r1, r0)
            goto Ld0
        Lf3:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.e.a.b(io.fabric.sdk.android.services.network.HttpRequest, io.fabric.sdk.android.services.e.d):io.fabric.sdk.android.services.network.HttpRequest");
    }

    String a(io.fabric.sdk.android.j jVar) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", jVar.a());
    }

    String b(io.fabric.sdk.android.j jVar) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", jVar.a());
    }
}
