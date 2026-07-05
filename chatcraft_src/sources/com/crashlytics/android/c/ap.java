package com.crashlytics.android.c;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ReportUploader.java */
/* loaded from: classes.dex */
class ap {

    /* renamed from: a, reason: collision with root package name */
    static final Map<String, String> f1319a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");

    /* renamed from: b, reason: collision with root package name */
    private static final short[] f1320b = {10, 20, 30, 60, 120, 300};
    private final Object c = new Object();
    private final t d;
    private final String e;
    private final c f;
    private final b g;
    private Thread h;

    /* compiled from: ReportUploader.java */
    interface b {
        boolean a();
    }

    /* compiled from: ReportUploader.java */
    interface c {
        File[] a();

        File[] b();

        File[] c();
    }

    /* compiled from: ReportUploader.java */
    interface d {
        boolean a();
    }

    /* compiled from: ReportUploader.java */
    static final class a implements d {
        @Override // com.crashlytics.android.c.ap.d
        public boolean a() {
            return true;
        }

        a() {
        }
    }

    public ap(String str, t tVar, c cVar, b bVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.d = tVar;
        this.e = str;
        this.f = cVar;
        this.g = bVar;
    }

    public synchronized void a(float f, d dVar) {
        if (this.h != null) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Report upload has already been started.");
        } else {
            this.h = new Thread(new e(f, dVar), "Crashlytics Report Uploader");
            this.h.start();
        }
    }

    boolean a(ao aoVar) {
        boolean z;
        boolean zA;
        synchronized (this.c) {
            z = false;
            try {
                zA = this.d.a(new s(this.e, aoVar));
                io.fabric.sdk.android.k kVarG = io.fabric.sdk.android.c.g();
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics report upload ");
                sb.append(zA ? "complete: " : "FAILED: ");
                sb.append(aoVar.b());
                kVarG.c("CrashlyticsCore", sb.toString());
            } catch (Exception e2) {
                io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Error occurred sending report " + aoVar, e2);
            }
            if (zA) {
                aoVar.f();
                z = true;
            }
        }
        return z;
    }

    List<ao> a() {
        File[] fileArrA;
        File[] fileArrB;
        File[] fileArrC;
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.c) {
            fileArrA = this.f.a();
            fileArrB = this.f.b();
            fileArrC = this.f.c();
        }
        LinkedList linkedList = new LinkedList();
        if (fileArrA != null) {
            for (File file : fileArrA) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Found crash report " + file.getPath());
                linkedList.add(new as(file));
            }
        }
        HashMap map = new HashMap();
        if (fileArrB != null) {
            for (File file2 : fileArrB) {
                String strA = k.a(file2);
                if (!map.containsKey(strA)) {
                    map.put(strA, new LinkedList());
                }
                ((List) map.get(strA)).add(file2);
            }
        }
        for (String str : map.keySet()) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Found invalid session: " + str);
            List list = (List) map.get(str);
            linkedList.add(new z(str, (File[]) list.toArray(new File[list.size()])));
        }
        if (fileArrC != null) {
            for (File file3 : fileArrC) {
                linkedList.add(new ah(file3));
            }
        }
        if (linkedList.isEmpty()) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }

    /* compiled from: ReportUploader.java */
    private class e extends io.fabric.sdk.android.services.b.h {

        /* renamed from: b, reason: collision with root package name */
        private final float f1322b;
        private final d c;

        e(float f, d dVar) {
            this.f1322b = f;
            this.c = dVar;
        }

        @Override // io.fabric.sdk.android.services.b.h
        public void a() {
            try {
                b();
            } catch (Exception e) {
                io.fabric.sdk.android.c.g().e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ap.this.h = null;
        }

        private void b() throws InterruptedException {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Starting report processing in " + this.f1322b + " second(s)...");
            if (this.f1322b > 0.0f) {
                try {
                    Thread.sleep((long) (this.f1322b * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<ao> listA = ap.this.a();
            if (ap.this.g.a()) {
                return;
            }
            if (!listA.isEmpty() && !this.c.a()) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "User declined to send. Removing " + listA.size() + " Report(s).");
                Iterator<ao> it = listA.iterator();
                while (it.hasNext()) {
                    it.next().f();
                }
                return;
            }
            int i = 0;
            while (!listA.isEmpty() && !ap.this.g.a()) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Attempting to send " + listA.size() + " report(s)");
                Iterator<ao> it2 = listA.iterator();
                while (it2.hasNext()) {
                    ap.this.a(it2.next());
                }
                listA = ap.this.a();
                if (!listA.isEmpty()) {
                    int i2 = i + 1;
                    long j = ap.f1320b[Math.min(i, ap.f1320b.length - 1)];
                    io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                    try {
                        Thread.sleep(j * 1000);
                        i = i2;
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }
}
