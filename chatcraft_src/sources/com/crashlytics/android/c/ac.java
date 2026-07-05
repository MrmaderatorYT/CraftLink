package com.crashlytics.android.c;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* compiled from: MetaDataStore.java */
/* loaded from: classes.dex */
class ac {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f1299a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private final File f1300b;

    public ac(File file) {
        this.f1300b = file;
    }

    public ax a(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileB = b(str);
        if (!fileB.exists()) {
            return ax.f1331a;
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(fileB);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            ax axVarD = d(io.fabric.sdk.android.services.b.i.a((InputStream) fileInputStream));
            io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream, "Failed to close user metadata file.");
            return axVarD;
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Error deserializing user metadata.", e);
            io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream2, "Failed to close user metadata file.");
            return ax.f1331a;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public File b(String str) {
        return new File(this.f1300b, str + "user.meta");
    }

    public File c(String str) {
        return new File(this.f1300b, str + "keys.meta");
    }

    private static ax d(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new ax(a(jSONObject, "userId"), a(jSONObject, "userName"), a(jSONObject, "userEmail"));
    }

    private static String a(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }
}
