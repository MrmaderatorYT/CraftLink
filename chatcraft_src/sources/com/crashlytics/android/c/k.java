package com.crashlytics.android.c;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.crashlytics.android.c.aa;
import com.crashlytics.android.c.ap;
import com.crashlytics.android.c.i;
import com.crashlytics.android.c.r;
import io.fabric.sdk.android.services.b.j;
import io.fabric.sdk.android.services.b.r;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONObject;

/* compiled from: CrashlyticsController.java */
/* loaded from: classes.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    static final FilenameFilter f1362a = new d("BeginSession") { // from class: com.crashlytics.android.c.k.1
        @Override // com.crashlytics.android.c.k.d, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    };

    /* renamed from: b, reason: collision with root package name */
    static final FilenameFilter f1363b = new FilenameFilter() { // from class: com.crashlytics.android.c.k.10
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == ".cls".length() + 35 && str.endsWith(".cls");
        }
    };
    static final FileFilter c = new FileFilter() { // from class: com.crashlytics.android.c.k.17
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory() && file.getName().length() == 35;
        }
    };
    static final Comparator<File> d = new Comparator<File>() { // from class: com.crashlytics.android.c.k.18
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    };
    static final Comparator<File> e = new Comparator<File>() { // from class: com.crashlytics.android.c.k.19
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    };
    private static final Pattern f = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> g = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    private static final String[] h = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    private final AtomicInteger i = new AtomicInteger(0);
    private final com.crashlytics.android.c.l j;
    private final com.crashlytics.android.c.j k;
    private final io.fabric.sdk.android.services.network.d l;
    private final io.fabric.sdk.android.services.b.r m;
    private final aj n;
    private final io.fabric.sdk.android.services.d.a o;
    private final com.crashlytics.android.c.a p;
    private final g q;
    private final aa r;
    private final ap.c s;
    private final ap.b t;
    private final w u;
    private final au v;
    private final String w;
    private final com.crashlytics.android.c.b x;
    private final com.crashlytics.android.a.o y;
    private r z;

    /* compiled from: CrashlyticsController.java */
    private interface b {
        void a(com.crashlytics.android.c.g gVar);
    }

    /* compiled from: CrashlyticsController.java */
    private interface e {
        void a(FileOutputStream fileOutputStream);
    }

    /* compiled from: CrashlyticsController.java */
    static class d implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        private final String f1401a;

        public d(String str) {
            this.f1401a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f1401a) && !str.endsWith(".cls_temp");
        }
    }

    /* compiled from: CrashlyticsController.java */
    static class l implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        private final String f1412a;

        public l(String str) {
            this.f1412a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1412a);
            sb.append(".cls");
            return (str.equals(sb.toString()) || !str.contains(this.f1412a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    /* compiled from: CrashlyticsController.java */
    private static class a implements FilenameFilter {
        private a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !k.f1363b.accept(file, str) && k.f.matcher(str).matches();
        }
    }

    /* compiled from: CrashlyticsController.java */
    static class f implements FilenameFilter {
        f() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return com.crashlytics.android.c.f.f1342a.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    k(com.crashlytics.android.c.l lVar, com.crashlytics.android.c.j jVar, io.fabric.sdk.android.services.network.d dVar, io.fabric.sdk.android.services.b.r rVar, aj ajVar, io.fabric.sdk.android.services.d.a aVar, com.crashlytics.android.c.a aVar2, aw awVar, com.crashlytics.android.c.b bVar, com.crashlytics.android.a.o oVar) {
        this.j = lVar;
        this.k = jVar;
        this.l = dVar;
        this.m = rVar;
        this.n = ajVar;
        this.o = aVar;
        this.p = aVar2;
        this.w = awVar.a();
        this.x = bVar;
        this.y = oVar;
        Context contextR = lVar.r();
        this.q = new g(aVar);
        this.r = new aa(contextR, this.q);
        this.s = new i();
        this.t = new j();
        this.u = new w(contextR);
        this.v = new ad(1024, new an(10));
    }

    void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z) {
        a();
        this.z = new r(new r.a() { // from class: com.crashlytics.android.c.k.20
            @Override // com.crashlytics.android.c.r.a
            public void a(r.b bVar, Thread thread, Throwable th, boolean z2) {
                k.this.a(bVar, thread, th, z2);
            }
        }, new c(), z, uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.z);
    }

    synchronized void a(final r.b bVar, final Thread thread, final Throwable th, final boolean z) {
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        this.u.c();
        final Date date = new Date();
        this.k.a(new Callable<Void>() { // from class: com.crashlytics.android.c.k.21
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Throwable {
                io.fabric.sdk.android.services.e.p pVar;
                io.fabric.sdk.android.services.e.m mVar;
                k.this.j.o();
                k.this.a(date, thread, th);
                io.fabric.sdk.android.services.e.t tVarA = bVar.a();
                if (tVarA != null) {
                    pVar = tVarA.f4320b;
                    mVar = tVarA.d;
                } else {
                    pVar = null;
                    mVar = null;
                }
                boolean z2 = false;
                if ((mVar == null || mVar.e) || z) {
                    k.this.a(date.getTime());
                }
                k.this.b(pVar);
                k.this.o();
                if (pVar != null) {
                    k.this.a(pVar.g);
                }
                if (new io.fabric.sdk.android.services.b.q().f(k.this.j.r()) && !k.this.b(tVarA)) {
                    z2 = true;
                }
                if (z2) {
                    k.this.c(tVarA);
                }
                return null;
            }
        });
    }

    void a(float f2, io.fabric.sdk.android.services.e.t tVar) {
        if (tVar == null) {
            io.fabric.sdk.android.c.g().d("CrashlyticsCore", "Could not send reports. Settings are not available.");
        } else {
            new ap(this.p.f1293a, b(tVar.f4319a.d, tVar.f4319a.e), this.s, this.t).a(f2, b(tVar) ? new h(this.j, this.n, tVar.c) : new ap.a());
        }
    }

    void a(final long j2, final String str) {
        this.k.b(new Callable<Void>() { // from class: com.crashlytics.android.c.k.22
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                if (k.this.f()) {
                    return null;
                }
                k.this.r.a(j2, str);
                return null;
            }
        });
    }

    void a(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.k.a(new Runnable() { // from class: com.crashlytics.android.c.k.23
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (k.this.f()) {
                    return;
                }
                k.this.b(date, thread, th);
            }
        });
    }

    void a() {
        this.k.b(new Callable<Void>() { // from class: com.crashlytics.android.c.k.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Throwable {
                k.this.o();
                return null;
            }
        });
    }

    private String m() {
        File[] fileArrP = p();
        if (fileArrP.length > 0) {
            return a(fileArrP[0]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n() {
        File[] fileArrP = p();
        if (fileArrP.length > 1) {
            return a(fileArrP[1]);
        }
        return null;
    }

    static String a(File file) {
        return file.getName().substring(0, 35);
    }

    boolean a(final io.fabric.sdk.android.services.e.p pVar) {
        return ((Boolean) this.k.a(new Callable<Boolean>() { // from class: com.crashlytics.android.c.k.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Throwable {
                if (k.this.f()) {
                    io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Finalizing previously open sessions.");
                k.this.a(pVar, true);
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() throws Throwable {
        Date date = new Date();
        String string = new com.crashlytics.android.c.e(this.m).toString();
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Opening a new session with ID " + string);
        a(string, date);
        c(string);
        d(string);
        e(string);
        this.r.a(string);
    }

    void b(io.fabric.sdk.android.services.e.p pVar) throws Throwable {
        a(pVar, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(io.fabric.sdk.android.services.e.p pVar, boolean z) throws Throwable {
        b((z ? 1 : 0) + 8);
        File[] fileArrP = p();
        if (fileArrP.length <= z) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        f(a(fileArrP[z ? 1 : 0]));
        if (pVar == null) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
        } else {
            a(fileArrP, z ? 1 : 0, pVar.c);
        }
    }

    private void a(File[] fileArr, int i2, int i3) throws Throwable {
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Closing open sessions.");
        while (i2 < fileArr.length) {
            File file = fileArr[i2];
            String strA = a(file);
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Closing session: " + strA);
            a(file, strA, i3);
            i2++;
        }
    }

    private void a(com.crashlytics.android.c.f fVar) {
        if (fVar == null) {
            return;
        }
        try {
            fVar.a();
        } catch (IOException e2) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Set<File> set) {
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private void b(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                b(file2);
            }
        }
        file.delete();
    }

    private void a(String str) {
        for (File file : b(str)) {
            file.delete();
        }
    }

    private File[] b(String str) {
        return a(new l(str));
    }

    File[] b() {
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, a(h(), f1363b));
        Collections.addAll(linkedList, a(i(), f1363b));
        Collections.addAll(linkedList, a(g(), f1363b));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    File[] c() {
        return a(c);
    }

    File[] d() {
        return a(f1362a);
    }

    private File[] p() {
        File[] fileArrD = d();
        Arrays.sort(fileArrD, d);
        return fileArrD;
    }

    private File[] a(FileFilter fileFilter) {
        return b(g().listFiles(fileFilter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File[] a(FilenameFilter filenameFilter) {
        return a(g(), filenameFilter);
    }

    private File[] a(File file, FilenameFilter filenameFilter) {
        return b(file.listFiles(filenameFilter));
    }

    private File[] c(File file) {
        return b(file.listFiles());
    }

    private File[] b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void a(String str, int i2) {
        ay.a(g(), new d(str + "SessionEvent"), i2, e);
    }

    void a(int i2) {
        int iA = i2 - ay.a(h(), i2, e);
        ay.a(g(), f1363b, iA - ay.a(i(), iA, e), e);
    }

    private void b(int i2) {
        HashSet hashSet = new HashSet();
        File[] fileArrP = p();
        int iMin = Math.min(i2, fileArrP.length);
        for (int i3 = 0; i3 < iMin; i3++) {
            hashSet.add(a(fileArrP[i3]));
        }
        this.r.a(hashSet);
        a(a(new a()), hashSet);
    }

    private void a(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = f.matcher(name);
            if (!matcher.matches()) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Deleting unknown file: " + name);
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Trimming session file: " + name);
                file.delete();
            }
        }
    }

    private File[] a(String str, File[] fileArr, int i2) {
        if (fileArr.length <= i2) {
            return fileArr;
        }
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i2)));
        a(str, i2);
        return a(new d(str + "SessionEvent"));
    }

    void e() {
        this.k.a(new Runnable() { // from class: com.crashlytics.android.c.k.4
            @Override // java.lang.Runnable
            public void run() {
                k.this.a(k.this.a(new f()));
            }
        });
    }

    void a(File[] fileArr) {
        final HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Found invalid session part file: " + file);
            hashSet.add(a(file));
        }
        if (hashSet.isEmpty()) {
            return;
        }
        File fileJ = j();
        if (!fileJ.exists()) {
            fileJ.mkdir();
        }
        for (File file2 : a(new FilenameFilter() { // from class: com.crashlytics.android.c.k.5
            @Override // java.io.FilenameFilter
            public boolean accept(File file3, String str) {
                if (str.length() < 35) {
                    return false;
                }
                return hashSet.contains(str.substring(0, 35));
            }
        })) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Moving session file: " + file2);
            if (!file2.renameTo(new File(fileJ, file2.getName()))) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Could not move session file. Deleting " + file2);
                file2.delete();
            }
        }
        q();
    }

    private void q() {
        File fileJ = j();
        if (fileJ.exists()) {
            File[] fileArrA = a(fileJ, new f());
            Arrays.sort(fileArrA, Collections.reverseOrder());
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < fileArrA.length && hashSet.size() < 4; i2++) {
                hashSet.add(a(fileArrA[i2]));
            }
            a(c(fileJ), hashSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, File file, String str) throws Throwable {
        byte[] bArrB = ag.b(file);
        byte[] bArrC = ag.c(file);
        byte[] bArrA = ag.a(file, context);
        if (bArrB == null || bArrB.length == 0) {
            io.fabric.sdk.android.c.g().d("CrashlyticsCore", "No minidump data found in directory " + file);
            return;
        }
        d(str, "<native-crash: minidump>");
        byte[] bArrA2 = a(str, "BeginSession.json");
        byte[] bArrA3 = a(str, "SessionApp.json");
        byte[] bArrA4 = a(str, "SessionDevice.json");
        byte[] bArrA5 = a(str, "SessionOS.json");
        byte[] bArrA6 = ag.a(new ac(g()).b(str));
        aa aaVar = new aa(this.j.r(), this.q, str);
        byte[] bArrB2 = aaVar.b();
        aaVar.c();
        byte[] bArrA7 = ag.a(new ac(g()).c(str));
        File file2 = new File(this.o.a(), str);
        if (!file2.mkdir()) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Couldn't create native sessions directory");
            return;
        }
        a(bArrB, new File(file2, "minidump"));
        a(bArrC, new File(file2, "metadata"));
        a(bArrA, new File(file2, "binaryImages"));
        a(bArrA2, new File(file2, "session"));
        a(bArrA3, new File(file2, "app"));
        a(bArrA4, new File(file2, "device"));
        a(bArrA5, new File(file2, "os"));
        a(bArrA6, new File(file2, "user"));
        a(bArrB2, new File(file2, "logs"));
        a(bArrA7, new File(file2, "keys"));
    }

    boolean a(final o oVar) {
        if (oVar == null) {
            return true;
        }
        return ((Boolean) this.k.a(new Callable<Boolean>() { // from class: com.crashlytics.android.c.k.6
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Throwable {
                File fileFirst;
                TreeSet<File> treeSet = oVar.f1421a;
                String strN = k.this.n();
                if (strN != null && !treeSet.isEmpty() && (fileFirst = treeSet.first()) != null) {
                    k.this.a(k.this.j.r(), fileFirst, strN);
                }
                k.this.a(treeSet);
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    private void a(byte[] bArr, File file) throws Throwable {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        b(bArr, file);
    }

    private void b(byte[] bArr, File file) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.finish();
                io.fabric.sdk.android.services.b.i.a(gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                io.fabric.sdk.android.services.b.i.a(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Date date, Thread thread, Throwable th) throws Throwable {
        com.crashlytics.android.c.f fVar;
        String strM;
        com.crashlytics.android.c.g gVarA;
        com.crashlytics.android.c.g gVar = null;
        try {
            strM = m();
        } catch (Exception e2) {
            e = e2;
            fVar = null;
        } catch (Throwable th2) {
            th = th2;
            fVar = null;
        }
        if (strM == null) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
            io.fabric.sdk.android.services.b.i.a((Flushable) null, "Failed to flush to session begin file.");
            io.fabric.sdk.android.services.b.i.a((Closeable) null, "Failed to close fatal exception file output stream.");
            return;
        }
        d(strM, th.getClass().getName());
        fVar = new com.crashlytics.android.c.f(g(), strM + "SessionCrash");
        try {
            try {
                gVarA = com.crashlytics.android.c.g.a(fVar);
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            a(gVarA, date, thread, th, "crash", true);
            io.fabric.sdk.android.services.b.i.a(gVarA, "Failed to flush to session begin file.");
        } catch (Exception e4) {
            e = e4;
            gVar = gVarA;
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            io.fabric.sdk.android.services.b.i.a(gVar, "Failed to flush to session begin file.");
            io.fabric.sdk.android.services.b.i.a((Closeable) fVar, "Failed to close fatal exception file output stream.");
        } catch (Throwable th4) {
            th = th4;
            gVar = gVarA;
            io.fabric.sdk.android.services.b.i.a(gVar, "Failed to flush to session begin file.");
            io.fabric.sdk.android.services.b.i.a((Closeable) fVar, "Failed to close fatal exception file output stream.");
            throw th;
        }
        io.fabric.sdk.android.services.b.i.a((Closeable) fVar, "Failed to close fatal exception file output stream.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Date date, Thread thread, Throwable th) throws Throwable {
        com.crashlytics.android.c.f fVar;
        com.crashlytics.android.c.g gVarA;
        String strM = m();
        com.crashlytics.android.c.g gVar = null;
        if (strM == null) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        c(strM, th.getClass().getName());
        try {
            try {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
                fVar = new com.crashlytics.android.c.f(g(), strM + "SessionEvent" + io.fabric.sdk.android.services.b.i.a(this.i.getAndIncrement()));
                try {
                    gVarA = com.crashlytics.android.c.g.a(fVar);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                a(gVarA, date, thread, th, "error", false);
                io.fabric.sdk.android.services.b.i.a(gVarA, "Failed to flush to non-fatal file.");
            } catch (Exception e3) {
                e = e3;
                gVar = gVarA;
                io.fabric.sdk.android.c.g().e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                io.fabric.sdk.android.services.b.i.a(gVar, "Failed to flush to non-fatal file.");
                io.fabric.sdk.android.services.b.i.a((Closeable) fVar, "Failed to close non-fatal file output stream.");
                a(strM, 64);
            } catch (Throwable th3) {
                th = th3;
                gVar = gVarA;
                io.fabric.sdk.android.services.b.i.a(gVar, "Failed to flush to non-fatal file.");
                io.fabric.sdk.android.services.b.i.a((Closeable) fVar, "Failed to close non-fatal file output stream.");
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fVar = null;
        } catch (Throwable th4) {
            th = th4;
            fVar = null;
        }
        io.fabric.sdk.android.services.b.i.a((Closeable) fVar, "Failed to close non-fatal file output stream.");
        try {
            a(strM, 64);
        } catch (Exception e5) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "An error occurred when trimming non-fatal files.", e5);
        }
    }

    private void a(String str, String str2, b bVar) throws Throwable {
        com.crashlytics.android.c.f fVar;
        com.crashlytics.android.c.g gVar = null;
        try {
            fVar = new com.crashlytics.android.c.f(g(), str + str2);
            try {
                com.crashlytics.android.c.g gVarA = com.crashlytics.android.c.g.a(fVar);
                try {
                    bVar.a(gVarA);
                    io.fabric.sdk.android.services.b.i.a(gVarA, "Failed to flush to session " + str2 + " file.");
                    io.fabric.sdk.android.services.b.i.a((Closeable) fVar, "Failed to close session " + str2 + " file.");
                } catch (Throwable th) {
                    th = th;
                    gVar = gVarA;
                    io.fabric.sdk.android.services.b.i.a(gVar, "Failed to flush to session " + str2 + " file.");
                    io.fabric.sdk.android.services.b.i.a((Closeable) fVar, "Failed to close session " + str2 + " file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fVar = null;
        }
    }

    private void a(String str, String str2, e eVar) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(g(), str + str2));
            try {
                eVar.a(fileOutputStream2);
                io.fabric.sdk.android.services.b.i.a((Closeable) fileOutputStream2, "Failed to close " + str2 + " file.");
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                io.fabric.sdk.android.services.b.i.a((Closeable) fileOutputStream, "Failed to close " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private byte[] a(String str, String str2) {
        return ag.a(new File(g(), str + str2));
    }

    private void a(final String str, Date date) throws Throwable {
        final String str2 = String.format(Locale.US, "Crashlytics Android SDK/%s", this.j.a());
        final long time = date.getTime() / 1000;
        a(str, "BeginSession", new b() { // from class: com.crashlytics.android.c.k.7
            @Override // com.crashlytics.android.c.k.b
            public void a(com.crashlytics.android.c.g gVar) {
                ar.a(gVar, str, str2, time);
            }
        });
        a(str, "BeginSession.json", new e() { // from class: com.crashlytics.android.c.k.8
            @Override // com.crashlytics.android.c.k.e
            public void a(FileOutputStream fileOutputStream) throws IOException {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: com.crashlytics.android.c.k.8.1
                    {
                        put("session_id", str);
                        put("generator", str2);
                        put("started_at_seconds", Long.valueOf(time));
                    }
                }).toString().getBytes());
            }
        });
    }

    private void c(String str) throws Throwable {
        final String strC = this.m.c();
        final String str2 = this.p.e;
        final String str3 = this.p.f;
        final String strB = this.m.b();
        final int iA = io.fabric.sdk.android.services.b.l.a(this.p.c).a();
        a(str, "SessionApp", new b() { // from class: com.crashlytics.android.c.k.9
            @Override // com.crashlytics.android.c.k.b
            public void a(com.crashlytics.android.c.g gVar) {
                ar.a(gVar, strC, k.this.p.f1293a, str2, str3, strB, iA, k.this.w);
            }
        });
        a(str, "SessionApp.json", new e() { // from class: com.crashlytics.android.c.k.11
            @Override // com.crashlytics.android.c.k.e
            public void a(FileOutputStream fileOutputStream) throws IOException {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: com.crashlytics.android.c.k.11.1
                    {
                        put("app_identifier", strC);
                        put("api_key", k.this.p.f1293a);
                        put("version_code", str2);
                        put("version_name", str3);
                        put("install_uuid", strB);
                        put("delivery_mechanism", Integer.valueOf(iA));
                        put("unity_version", TextUtils.isEmpty(k.this.w) ? BuildConfig.FLAVOR : k.this.w);
                    }
                }).toString().getBytes());
            }
        });
    }

    private void d(String str) throws Throwable {
        final boolean zG = io.fabric.sdk.android.services.b.i.g(this.j.r());
        a(str, "SessionOS", new b() { // from class: com.crashlytics.android.c.k.12
            @Override // com.crashlytics.android.c.k.b
            public void a(com.crashlytics.android.c.g gVar) {
                ar.a(gVar, Build.VERSION.RELEASE, Build.VERSION.CODENAME, zG);
            }
        });
        a(str, "SessionOS.json", new e() { // from class: com.crashlytics.android.c.k.13
            @Override // com.crashlytics.android.c.k.e
            public void a(FileOutputStream fileOutputStream) throws IOException {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: com.crashlytics.android.c.k.13.1
                    {
                        put("version", Build.VERSION.RELEASE);
                        put("build_version", Build.VERSION.CODENAME);
                        put("is_rooted", Boolean.valueOf(zG));
                    }
                }).toString().getBytes());
            }
        });
    }

    private void e(String str) throws Throwable {
        Context contextR = this.j.r();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        final int iA = io.fabric.sdk.android.services.b.i.a();
        final int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        final long jB = io.fabric.sdk.android.services.b.i.b();
        final long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        final boolean zF = io.fabric.sdk.android.services.b.i.f(contextR);
        final Map<r.a, String> mapH = this.m.h();
        final int iH = io.fabric.sdk.android.services.b.i.h(contextR);
        a(str, "SessionDevice", new b() { // from class: com.crashlytics.android.c.k.14
            @Override // com.crashlytics.android.c.k.b
            public void a(com.crashlytics.android.c.g gVar) {
                ar.a(gVar, iA, Build.MODEL, iAvailableProcessors, jB, blockCount, zF, (Map<r.a, String>) mapH, iH, Build.MANUFACTURER, Build.PRODUCT);
            }
        });
        a(str, "SessionDevice.json", new e() { // from class: com.crashlytics.android.c.k.15
            @Override // com.crashlytics.android.c.k.e
            public void a(FileOutputStream fileOutputStream) throws IOException {
                fileOutputStream.write(new JSONObject(new HashMap<String, Object>() { // from class: com.crashlytics.android.c.k.15.1
                    {
                        put("arch", Integer.valueOf(iA));
                        put("build_model", Build.MODEL);
                        put("available_processors", Integer.valueOf(iAvailableProcessors));
                        put("total_ram", Long.valueOf(jB));
                        put("disk_space", Long.valueOf(blockCount));
                        put("is_emulator", Boolean.valueOf(zF));
                        put("ids", mapH);
                        put("state", Integer.valueOf(iH));
                        put("build_manufacturer", Build.MANUFACTURER);
                        put("build_product", Build.PRODUCT);
                    }
                }).toString().getBytes());
            }
        });
    }

    private void f(String str) throws Throwable {
        final ax axVarG = g(str);
        a(str, "SessionUser", new b() { // from class: com.crashlytics.android.c.k.16
            @Override // com.crashlytics.android.c.k.b
            public void a(com.crashlytics.android.c.g gVar) {
                ar.a(gVar, axVarG.f1332b, axVarG.c, axVarG.d);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5 */
    private void a(com.crashlytics.android.c.g gVar, Date date, Thread thread, Throwable th, String str, boolean z) {
        ?? r6;
        Thread[] threadArr;
        Map<String, String> mapG;
        Map<String, String> treeMap;
        av avVar = new av(th, this.v);
        Context contextR = this.j.r();
        long time = date.getTime() / 1000;
        Float fC = io.fabric.sdk.android.services.b.i.c(contextR);
        int iA = io.fabric.sdk.android.services.b.i.a(contextR, this.u.b());
        boolean zD = io.fabric.sdk.android.services.b.i.d(contextR);
        int i2 = contextR.getResources().getConfiguration().orientation;
        long jB = io.fabric.sdk.android.services.b.i.b() - io.fabric.sdk.android.services.b.i.b(contextR);
        long jC = io.fabric.sdk.android.services.b.i.c(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo runningAppProcessInfoA = io.fabric.sdk.android.services.b.i.a(contextR.getPackageName(), contextR);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = avVar.c;
        String str2 = this.p.f1294b;
        String strC = this.m.c();
        int i3 = 0;
        if (z) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i3] = entry.getKey();
                linkedList.add(this.v.a(entry.getValue()));
                i3++;
            }
            r6 = 1;
            threadArr = threadArr2;
        } else {
            r6 = 1;
            threadArr = new Thread[0];
        }
        if (!io.fabric.sdk.android.services.b.i.a(contextR, "com.crashlytics.CollectCustomKeys", (boolean) r6)) {
            mapG = new TreeMap<>();
        } else {
            mapG = this.j.g();
            if (mapG != null && mapG.size() > r6) {
                treeMap = new TreeMap(mapG);
            }
            ar.a(gVar, time, str, avVar, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.r, runningAppProcessInfoA, i2, strC, str2, fC, iA, zD, jB, jC);
        }
        treeMap = mapG;
        ar.a(gVar, time, str, avVar, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.r, runningAppProcessInfoA, i2, strC, str2, fC, iA, zD, jB, jC);
    }

    private void a(File file, String str, int i2) throws Throwable {
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Collecting session parts for ID " + str);
        File[] fileArrA = a(new d(str + "SessionCrash"));
        boolean z = fileArrA != null && fileArrA.length > 0;
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", str, Boolean.valueOf(z)));
        File[] fileArrA2 = a(new d(str + "SessionEvent"));
        boolean z2 = fileArrA2 != null && fileArrA2.length > 0;
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z2)));
        if (z || z2) {
            a(file, str, a(str, fileArrA2, i2), z ? fileArrA[0] : null);
        } else {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "No events present for session ID " + str);
        }
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Removing session part files for ID " + str);
        a(str);
    }

    private void a(File file, String str, File[] fileArr, File file2) throws Throwable {
        com.crashlytics.android.c.g gVarA;
        com.crashlytics.android.c.f fVar;
        boolean z = file2 != null;
        File fileH = z ? h() : i();
        if (!fileH.exists()) {
            fileH.mkdirs();
        }
        com.crashlytics.android.c.g gVar = null;
        try {
            fVar = new com.crashlytics.android.c.f(fileH, str);
            try {
                try {
                    gVarA = com.crashlytics.android.c.g.a(fVar);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
                gVarA = gVar;
            }
            try {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Collecting SessionStart data for session ID " + str);
                a(gVarA, file);
                gVarA.a(4, new Date().getTime() / 1000);
                gVarA.a(5, z);
                gVarA.a(11, 1);
                gVarA.b(12, 3);
                a(gVarA, str);
                a(gVarA, fileArr, str);
                if (z) {
                    a(gVarA, file2);
                }
                io.fabric.sdk.android.services.b.i.a(gVarA, "Error flushing session file stream");
                io.fabric.sdk.android.services.b.i.a((Closeable) fVar, "Failed to close CLS file");
            } catch (Exception e3) {
                e = e3;
                gVar = gVarA;
                io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                io.fabric.sdk.android.services.b.i.a(gVar, "Error flushing session file stream");
                a(fVar);
            } catch (Throwable th2) {
                th = th2;
                io.fabric.sdk.android.services.b.i.a(gVarA, "Error flushing session file stream");
                io.fabric.sdk.android.services.b.i.a((Closeable) fVar, "Failed to close CLS file");
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fVar = null;
        } catch (Throwable th3) {
            th = th3;
            gVarA = null;
            fVar = null;
        }
    }

    private static void a(com.crashlytics.android.c.g gVar, File[] fileArr, String str) throws Throwable {
        Arrays.sort(fileArr, io.fabric.sdk.android.services.b.i.f4213a);
        for (File file : fileArr) {
            try {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                a(gVar, file);
            } catch (Exception e2) {
                io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Error writting non-fatal to session.", e2);
            }
        }
    }

    private void a(com.crashlytics.android.c.g gVar, String str) throws Throwable {
        for (String str2 : h) {
            File[] fileArrA = a(new d(str + str2 + ".cls"));
            if (fileArrA.length == 0) {
                io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                a(gVar, fileArrA[0]);
            }
        }
    }

    private static void a(com.crashlytics.android.c.g gVar, File file) throws Throwable {
        FileInputStream fileInputStream;
        if (!file.exists()) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                a(fileInputStream, gVar, (int) file.length());
                io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    private static void a(InputStream inputStream, com.crashlytics.android.c.g gVar, int i2) throws IOException {
        int i3;
        byte[] bArr = new byte[i2];
        int i4 = 0;
        while (i4 < bArr.length && (i3 = inputStream.read(bArr, i4, bArr.length - i4)) >= 0) {
            i4 += i3;
        }
        gVar.a(bArr);
    }

    private ax g(String str) {
        if (f()) {
            return new ax(this.j.h(), this.j.j(), this.j.i());
        }
        return new ac(g()).a(str);
    }

    boolean f() {
        return this.z != null && this.z.a();
    }

    File g() {
        return this.o.a();
    }

    File h() {
        return new File(g(), "fatal-sessions");
    }

    File i() {
        return new File(g(), "nonfatal-sessions");
    }

    File j() {
        return new File(g(), "invalidClsFiles");
    }

    void a(io.fabric.sdk.android.services.e.t tVar) {
        if (tVar.d.e && this.x.a()) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Registered Firebase Analytics event listener");
        }
    }

    void k() {
        this.u.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(io.fabric.sdk.android.services.e.t tVar) {
        return (tVar == null || !tVar.d.f4306a || this.n.a()) ? false : true;
    }

    private t b(String str, String str2) {
        String strB = io.fabric.sdk.android.services.b.i.b(this.j.r(), "com.crashlytics.ApiEndpoint");
        return new com.crashlytics.android.c.h(new v(this.j, strB, str, this.l), new af(this.j, strB, str2, this.l));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(io.fabric.sdk.android.services.e.t tVar) {
        if (tVar == null) {
            io.fabric.sdk.android.c.g().d("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context contextR = this.j.r();
        ap apVar = new ap(this.p.f1293a, b(tVar.f4319a.d, tVar.f4319a.e), this.s, this.t);
        for (File file : b()) {
            this.k.a(new RunnableC0063k(contextR, new as(file, g), apVar));
        }
    }

    private static void c(String str, String str2) {
        com.crashlytics.android.a.b bVar = (com.crashlytics.android.a.b) io.fabric.sdk.android.c.a(com.crashlytics.android.a.b.class);
        if (bVar == null) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Answers is not available");
        } else {
            bVar.a(new j.b(str, str2));
        }
    }

    private static void d(String str, String str2) {
        com.crashlytics.android.a.b bVar = (com.crashlytics.android.a.b) io.fabric.sdk.android.c.a(com.crashlytics.android.a.b.class);
        if (bVar == null) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Answers is not available");
        } else {
            bVar.a(new j.a(str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        if (r()) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return;
        }
        if (this.y != null) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Logging Crashlytics event to Firebase");
            Bundle bundle = new Bundle();
            bundle.putInt("_r", 1);
            bundle.putInt("fatal", 1);
            bundle.putLong("timestamp", j2);
            this.y.a("clx", "_ae", bundle);
            return;
        }
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
    }

    private boolean r() throws ClassNotFoundException {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* compiled from: CrashlyticsController.java */
    private final class j implements ap.b {
        private j() {
        }

        @Override // com.crashlytics.android.c.ap.b
        public boolean a() {
            return k.this.f();
        }
    }

    /* compiled from: CrashlyticsController.java */
    private final class i implements ap.c {
        private i() {
        }

        @Override // com.crashlytics.android.c.ap.c
        public File[] a() {
            return k.this.b();
        }

        @Override // com.crashlytics.android.c.ap.c
        public File[] b() {
            return k.this.j().listFiles();
        }

        @Override // com.crashlytics.android.c.ap.c
        public File[] c() {
            return k.this.c();
        }
    }

    /* compiled from: CrashlyticsController.java */
    private static final class h implements ap.d {

        /* renamed from: a, reason: collision with root package name */
        private final io.fabric.sdk.android.h f1403a;

        /* renamed from: b, reason: collision with root package name */
        private final aj f1404b;
        private final io.fabric.sdk.android.services.e.o c;

        public h(io.fabric.sdk.android.h hVar, aj ajVar, io.fabric.sdk.android.services.e.o oVar) {
            this.f1403a = hVar;
            this.f1404b = ajVar;
            this.c = oVar;
        }

        @Override // com.crashlytics.android.c.ap.d
        public boolean a() throws InterruptedException {
            Activity activityB = this.f1403a.s().b();
            if (activityB == null || activityB.isFinishing()) {
                return true;
            }
            final com.crashlytics.android.c.i iVarA = com.crashlytics.android.c.i.a(activityB, this.c, new i.a() { // from class: com.crashlytics.android.c.k.h.1
                @Override // com.crashlytics.android.c.i.a
                public void a(boolean z) {
                    h.this.f1404b.a(z);
                }
            });
            activityB.runOnUiThread(new Runnable() { // from class: com.crashlytics.android.c.k.h.2
                @Override // java.lang.Runnable
                public void run() {
                    iVarA.a();
                }
            });
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Waiting for user opt-in.");
            iVarA.b();
            return iVarA.c();
        }
    }

    /* compiled from: CrashlyticsController.java */
    /* renamed from: com.crashlytics.android.c.k$k, reason: collision with other inner class name */
    private static final class RunnableC0063k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Context f1410a;

        /* renamed from: b, reason: collision with root package name */
        private final ao f1411b;
        private final ap c;

        public RunnableC0063k(Context context, ao aoVar, ap apVar) {
            this.f1410a = context;
            this.f1411b = aoVar;
            this.c = apVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (io.fabric.sdk.android.services.b.i.o(this.f1410a)) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                this.c.a(this.f1411b);
            }
        }
    }

    /* compiled from: CrashlyticsController.java */
    private static final class g implements aa.a {

        /* renamed from: a, reason: collision with root package name */
        private final io.fabric.sdk.android.services.d.a f1402a;

        public g(io.fabric.sdk.android.services.d.a aVar) {
            this.f1402a = aVar;
        }

        @Override // com.crashlytics.android.c.aa.a
        public File a() {
            File file = new File(this.f1402a.a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* compiled from: CrashlyticsController.java */
    private static final class c implements r.b {
        private c() {
        }

        @Override // com.crashlytics.android.c.r.b
        public io.fabric.sdk.android.services.e.t a() {
            return io.fabric.sdk.android.services.e.q.a().b();
        }
    }
}
