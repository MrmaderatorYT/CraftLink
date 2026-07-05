package io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: FabricKitsFinder.java */
/* loaded from: classes.dex */
class e implements Callable<Map<String, j>> {

    /* renamed from: a, reason: collision with root package name */
    final String f4192a;

    e(String str) {
        this.f4192a = str;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<String, j> call() {
        HashMap map = new HashMap();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        map.putAll(c());
        map.putAll(d());
        c.g().b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return map;
    }

    private Map<String, j> c() throws ClassNotFoundException {
        HashMap map = new HashMap();
        try {
            Class.forName("com.google.android.gms.ads.AdView");
            j jVar = new j("com.google.firebase.firebase-ads", "0.0.0", "binary");
            map.put(jVar.a(), jVar);
            c.g().b("Fabric", "Found kit: com.google.firebase.firebase-ads");
        } catch (Exception unused) {
        }
        return map;
    }

    private Map<String, j> d() throws IOException {
        j jVarA;
        HashMap map = new HashMap();
        ZipFile zipFileB = b();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFileB.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (zipEntryNextElement.getName().startsWith("fabric/") && zipEntryNextElement.getName().length() > "fabric/".length() && (jVarA = a(zipEntryNextElement, zipFileB)) != null) {
                map.put(jVarA.a(), jVarA);
                c.g().b("Fabric", String.format("Found kit:[%s] version:[%s]", jVarA.a(), jVarA.b()));
            }
        }
        if (zipFileB != null) {
            try {
                zipFileB.close();
            } catch (IOException unused) {
            }
        }
        return map;
    }

    private j a(ZipEntry zipEntry, ZipFile zipFile) throws Throwable {
        InputStream inputStream;
        try {
            try {
                inputStream = zipFile.getInputStream(zipEntry);
                try {
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    String property = properties.getProperty("fabric-identifier");
                    String property2 = properties.getProperty("fabric-version");
                    String property3 = properties.getProperty("fabric-build-type");
                    if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                        throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                    }
                    j jVar = new j(property, property2, property3);
                    io.fabric.sdk.android.services.b.i.a((Closeable) inputStream);
                    return jVar;
                } catch (IOException e) {
                    e = e;
                    c.g().e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    io.fabric.sdk.android.services.b.i.a((Closeable) inputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                io.fabric.sdk.android.services.b.i.a(zipFile);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            zipFile = null;
            io.fabric.sdk.android.services.b.i.a(zipFile);
            throw th;
        }
    }

    protected ZipFile b() {
        return new ZipFile(this.f4192a);
    }
}
