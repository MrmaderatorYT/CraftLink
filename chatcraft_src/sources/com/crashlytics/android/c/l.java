package com.crashlytics.android.c;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: CrashlyticsCore.java */
@io.fabric.sdk.android.services.concurrency.d(a = {p.class})
/* loaded from: classes.dex */
public class l extends io.fabric.sdk.android.h<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final long f1413a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f1414b;
    private m c;
    private m d;
    private n k;
    private k l;
    private String m;
    private String n;
    private String o;
    private float p;
    private boolean q;
    private final ai r;
    private io.fabric.sdk.android.services.network.d s;
    private j t;
    private p u;

    @Override // io.fabric.sdk.android.h
    public String a() {
        return "2.6.5.28";
    }

    @Override // io.fabric.sdk.android.h
    public String b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public l() {
        this(1.0f, null, null, false);
    }

    l(float f, n nVar, ai aiVar, boolean z) {
        this(f, nVar, aiVar, z, io.fabric.sdk.android.services.b.n.a("Crashlytics Exception Handler"));
    }

    l(float f, n nVar, ai aiVar, boolean z, ExecutorService executorService) {
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = f;
        this.k = nVar == null ? new b() : nVar;
        this.r = aiVar;
        this.q = z;
        this.t = new j(executorService);
        this.f1414b = new ConcurrentHashMap<>();
        this.f1413a = System.currentTimeMillis();
    }

    @Override // io.fabric.sdk.android.h
    protected boolean b_() {
        return a(super.r());
    }

    boolean a(Context context) throws Resources.NotFoundException {
        String strA;
        if (!new io.fabric.sdk.android.services.b.q().f(context)) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Crashlytics is disabled, because data collection is disabled by Firebase.");
            this.q = true;
        }
        if (this.q || (strA = new io.fabric.sdk.android.services.b.g().a(context)) == null) {
            return false;
        }
        String strM = io.fabric.sdk.android.services.b.i.m(context);
        if (!a(strM, io.fabric.sdk.android.services.b.i.a(context, "com.crashlytics.RequireBuildId", true))) {
            throw new UnmetDependencyException("This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
        }
        try {
            io.fabric.sdk.android.c.g().c("CrashlyticsCore", "Initializing Crashlytics " + a());
            io.fabric.sdk.android.services.d.b bVar = new io.fabric.sdk.android.services.d.b(this);
            this.d = new m("crash_marker", bVar);
            this.c = new m("initialization_marker", bVar);
            aj ajVarA = aj.a(new io.fabric.sdk.android.services.d.d(r(), "com.crashlytics.android.core.CrashlyticsCore"), this);
            q qVar = this.r != null ? new q(this.r) : null;
            this.s = new io.fabric.sdk.android.services.network.b(io.fabric.sdk.android.c.g());
            this.s.a(qVar);
            io.fabric.sdk.android.services.b.r rVarQ = q();
            com.crashlytics.android.c.a aVarA = com.crashlytics.android.c.a.a(context, rVarQ, strA, strM);
            aq aqVar = new aq(context, new ab(context, aVarA.d));
            com.crashlytics.android.c.b bVarA = u.a(this);
            com.crashlytics.android.a.o oVarA = com.crashlytics.android.a.j.a(context);
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Installer package name is: " + aVarA.c);
            this.l = new k(this, this.t, this.s, rVarQ, ajVarA, bVar, aVarA, aqVar, bVarA, oVarA);
            boolean zM = m();
            x();
            this.l.a(Thread.getDefaultUncaughtExceptionHandler(), new io.fabric.sdk.android.services.b.q().b(context));
            if (zM && io.fabric.sdk.android.services.b.i.o(context)) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                w();
                return false;
            }
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Exception handling initialization successful");
            return true;
        } catch (Exception e) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e);
            this.l = null;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.h
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Void f() {
        io.fabric.sdk.android.services.e.t tVarB;
        k();
        this.l.e();
        try {
            try {
                this.l.k();
                tVarB = io.fabric.sdk.android.services.e.q.a().b();
            } catch (Exception e) {
                io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
            }
            if (tVarB == null) {
                io.fabric.sdk.android.c.g().d("CrashlyticsCore", "Received null settings, skipping report submission!");
                return null;
            }
            this.l.a(tVarB);
            if (!tVarB.d.c) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                return null;
            }
            if (!new io.fabric.sdk.android.services.b.q().f(r())) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Automatic collection of crash reports disabled by Firebase settings.");
                return null;
            }
            o oVarN = n();
            if (oVarN != null && !this.l.a(oVarN)) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Could not finalize previous NDK sessions.");
            }
            if (!this.l.a(tVarB.f4320b)) {
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Could not finalize previous sessions.");
            }
            this.l.a(this.p, tVarB);
            return null;
        } finally {
            l();
        }
    }

    public static l e() {
        return (l) io.fabric.sdk.android.c.a(l.class);
    }

    public void a(Throwable th) {
        if (!this.q && b("prior to logging exceptions.")) {
            if (th == null) {
                io.fabric.sdk.android.c.g().a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
            } else {
                this.l.a(Thread.currentThread(), th);
            }
        }
    }

    public void a(String str) {
        a(3, "CrashlyticsCore", str);
    }

    private void a(int i, String str, String str2) {
        if (!this.q && b("prior to logging messages.")) {
            this.l.a(System.currentTimeMillis() - this.f1413a, b(i, str, str2));
        }
    }

    Map<String, String> g() {
        return Collections.unmodifiableMap(this.f1414b);
    }

    String h() {
        if (q().a()) {
            return this.m;
        }
        return null;
    }

    String i() {
        if (q().a()) {
            return this.n;
        }
        return null;
    }

    String j() {
        if (q().a()) {
            return this.o;
        }
        return null;
    }

    private void w() throws ExecutionException, InterruptedException, TimeoutException {
        io.fabric.sdk.android.services.concurrency.g<Void> gVar = new io.fabric.sdk.android.services.concurrency.g<Void>() { // from class: com.crashlytics.android.c.l.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                return l.this.f();
            }

            @Override // io.fabric.sdk.android.services.concurrency.j, io.fabric.sdk.android.services.concurrency.i
            public io.fabric.sdk.android.services.concurrency.e b() {
                return io.fabric.sdk.android.services.concurrency.e.IMMEDIATE;
            }
        };
        Iterator<io.fabric.sdk.android.services.concurrency.l> it = v().iterator();
        while (it.hasNext()) {
            gVar.c(it.next());
        }
        Future futureSubmit = s().e().submit(gVar);
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Crashlytics timed out during initialization.", e3);
        }
    }

    void k() {
        this.t.a(new Callable<Void>() { // from class: com.crashlytics.android.c.l.2
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                l.this.c.a();
                io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Initialization marker file created.");
                return null;
            }
        });
    }

    void l() {
        this.t.b(new Callable<Boolean>() { // from class: com.crashlytics.android.c.l.3
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() {
                try {
                    boolean zC = l.this.c.c();
                    io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Initialization marker file removed: " + zC);
                    return Boolean.valueOf(zC);
                } catch (Exception e) {
                    io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
                    return false;
                }
            }
        });
    }

    boolean m() {
        return this.c.b();
    }

    o n() {
        if (this.u != null) {
            return this.u.a();
        }
        return null;
    }

    private void x() {
        if (Boolean.TRUE.equals((Boolean) this.t.a(new a(this.d)))) {
            try {
                this.k.a();
            } catch (Exception e) {
                io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    void o() {
        this.d.a();
    }

    private static String b(int i, String str, String str2) {
        return io.fabric.sdk.android.services.b.i.b(i) + "/" + str + " " + str2;
    }

    private static boolean b(String str) {
        l lVarE = e();
        if (lVarE != null && lVarE.l != null) {
            return true;
        }
        io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
        return false;
    }

    /* compiled from: CrashlyticsCore.java */
    private static final class a implements Callable<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        private final m f1418a;

        public a(m mVar) {
            this.f1418a = mVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            if (!this.f1418a.b()) {
                return Boolean.FALSE;
            }
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Found previous crash marker.");
            this.f1418a.c();
            return Boolean.TRUE;
        }
    }

    /* compiled from: CrashlyticsCore.java */
    private static final class b implements n {
        @Override // com.crashlytics.android.c.n
        public void a() {
        }

        private b() {
        }
    }

    static boolean a(String str, boolean z) {
        if (!z) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Configured not to require a build ID.");
            return true;
        }
        if (!io.fabric.sdk.android.services.b.i.d(str)) {
            return true;
        }
        Log.e("CrashlyticsCore", ".");
        Log.e("CrashlyticsCore", ".     |  | ");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".   \\ |  | /");
        Log.e("CrashlyticsCore", ".    \\    /");
        Log.e("CrashlyticsCore", ".     \\  /");
        Log.e("CrashlyticsCore", ".      \\/");
        Log.e("CrashlyticsCore", ".");
        Log.e("CrashlyticsCore", "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
        Log.e("CrashlyticsCore", ".");
        Log.e("CrashlyticsCore", ".      /\\");
        Log.e("CrashlyticsCore", ".     /  \\");
        Log.e("CrashlyticsCore", ".    /    \\");
        Log.e("CrashlyticsCore", ".   / |  | \\");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".");
        return false;
    }
}
