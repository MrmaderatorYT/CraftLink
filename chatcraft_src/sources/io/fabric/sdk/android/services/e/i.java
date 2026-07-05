package io.fabric.sdk.android.services.e;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

/* compiled from: DefaultCachedSettingsIo.java */
/* loaded from: classes.dex */
class i implements g {

    /* renamed from: a, reason: collision with root package name */
    private final io.fabric.sdk.android.h f4303a;

    public i(io.fabric.sdk.android.h hVar) {
        this.f4303a = hVar;
    }

    @Override // io.fabric.sdk.android.services.e.g
    public JSONObject a() throws Throwable {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        io.fabric.sdk.android.c.g().a("Fabric", "Reading cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(new io.fabric.sdk.android.services.d.b(this.f4303a).a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        jSONObject = new JSONObject(io.fabric.sdk.android.services.b.i.a((InputStream) fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e) {
                        e = e;
                        io.fabric.sdk.android.c.g().e("Fabric", "Failed to fetch cached settings", e);
                        io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream2, "Error while closing settings cache file.");
                    throw th;
                }
            } else {
                io.fabric.sdk.android.c.g().a("Fabric", "No cached settings found.");
                jSONObject = null;
            }
            io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream2, "Error while closing settings cache file.");
            throw th;
        }
    }

    @Override // io.fabric.sdk.android.services.e.g
    public void a(long j, JSONObject jSONObject) throws Throwable {
        FileWriter fileWriter;
        io.fabric.sdk.android.c.g().a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    jSONObject.put("expires_at", j);
                    fileWriter = new FileWriter(new File(new io.fabric.sdk.android.services.d.b(this.f4303a).a(), "com.crashlytics.settings.json"));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                io.fabric.sdk.android.services.b.i.a((Closeable) fileWriter, "Failed to close settings writer.");
            } catch (Exception e2) {
                e = e2;
                fileWriter2 = fileWriter;
                io.fabric.sdk.android.c.g().e("Fabric", "Failed to cache settings", e);
                io.fabric.sdk.android.services.b.i.a((Closeable) fileWriter2, "Failed to close settings writer.");
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                io.fabric.sdk.android.services.b.i.a((Closeable) fileWriter2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
