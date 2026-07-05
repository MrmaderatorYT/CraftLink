package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    private static volatile m f3696b;

    /* renamed from: a, reason: collision with root package name */
    protected final com.google.android.gms.common.util.c f3697a;
    private final String c;
    private final ExecutorService d;
    private final com.google.android.gms.a.a.a e;
    private Map<Object, Object> f;
    private int g;
    private boolean h;
    private String i;
    private com.google.android.gms.internal.measurement.a j;

    class c implements Application.ActivityLifecycleCallbacks {
        c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            m.this.a(new af(this, activity, bundle));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            m.this.a(new ag(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            m.this.a(new ah(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            m.this.a(new ai(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            m.this.a(new aj(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            a aVar = m.this.new a();
            m.this.a(new ak(this, activity, aVar));
            Bundle bundleE = aVar.e(50L);
            if (bundleE != null) {
                bundle.putAll(bundleE);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            m.this.a(new al(this, activity));
        }
    }

    public static m a(Context context, String str, String str2, String str3, Bundle bundle) {
        com.google.android.gms.common.internal.i.a(context);
        if (f3696b == null) {
            synchronized (m.class) {
                if (f3696b == null) {
                    f3696b = new m(context, str, str2, str3, bundle);
                }
            }
        }
        return f3696b;
    }

    class a extends e {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicReference<Bundle> f3698a = new AtomicReference<>();

        /* renamed from: b, reason: collision with root package name */
        private boolean f3699b;

        a() {
        }

        @Override // com.google.android.gms.internal.measurement.d
        public final void a(Bundle bundle) {
            synchronized (this.f3698a) {
                try {
                    this.f3698a.set(bundle);
                    this.f3699b = true;
                } finally {
                    this.f3698a.notify();
                }
            }
        }

        final String a(long j) {
            return (String) a(f(j), String.class);
        }

        final <T extends Parcelable> List<T> b(long j) {
            return (List) a(f(5000L), List.class);
        }

        final Long c(long j) {
            return (Long) a(f(500L), Long.class);
        }

        final Integer d(long j) {
            return (Integer) a(f(10000L), Integer.class);
        }

        final Bundle e(long j) {
            return f(j);
        }

        private final Bundle f(long j) {
            Bundle bundle;
            synchronized (this.f3698a) {
                if (!this.f3699b) {
                    try {
                        this.f3698a.wait(j);
                    } catch (InterruptedException unused) {
                        return null;
                    }
                }
                bundle = this.f3698a.get();
            }
            return bundle;
        }

        private final <T> T a(Bundle bundle, Class<T> cls) {
            Object obj;
            if (bundle == null || (obj = bundle.get("r")) == null) {
                return null;
            }
            try {
                return cls.cast(obj);
            } catch (ClassCastException e) {
                String canonicalName = cls.getCanonicalName();
                String canonicalName2 = obj.getClass().getCanonicalName();
                m.this.a(5, "Unexpected object type. Expected, Received", canonicalName, canonicalName2, e);
                Log.w(m.this.c, String.format(String.valueOf("Unexpected object type. Expected, Received").concat(": %s, %s"), canonicalName, canonicalName2), e);
                throw e;
            }
        }
    }

    abstract class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final long f3700a;

        /* renamed from: b, reason: collision with root package name */
        final long f3701b;
        private final boolean c;

        b(m mVar) {
            this(true);
        }

        protected void a() {
        }

        abstract void b();

        b(boolean z) {
            this.f3700a = m.this.f3697a.a();
            this.f3701b = m.this.f3697a.b();
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.h) {
                a();
                return;
            }
            try {
                b();
            } catch (Exception e) {
                m.this.a(e, false, this.c);
                a();
            }
        }
    }

    public final com.google.android.gms.a.a.a a() {
        return this.e;
    }

    private m(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !b(str2, str3)) {
            this.c = "FA";
        } else {
            this.c = str;
        }
        this.f3697a = com.google.android.gms.common.util.f.d();
        this.d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.c, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new c());
        }
        this.e = new com.google.android.gms.a.a.a(this);
        if (!(!d(context) || h())) {
            this.i = null;
            this.h = true;
            Log.w(this.c, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!b(str2, str3)) {
            this.i = "fa";
            if (str2 != null && str3 != null) {
                Log.v(this.c, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                this.h = true;
                return;
            } else {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.c, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            }
        } else {
            this.i = str2;
        }
        a(new n(this, context, str2, str3, bundle));
    }

    private static boolean d(Context context) {
        try {
            com.google.android.gms.common.api.internal.a.a(context);
            return com.google.android.gms.common.api.internal.a.a() != null;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        return (str2 == null || str == null || h()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(b bVar) {
        this.d.execute(bVar);
    }

    protected final com.google.android.gms.internal.measurement.a a(Context context) {
        try {
            return com.google.android.gms.internal.measurement.b.a(DynamiteModule.a(context, DynamiteModule.f1761a, "com.google.android.gms.measurement.dynamite").a("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            a((Exception) e, true, false);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(Context context) {
        return DynamiteModule.b(context, "com.google.android.gms.measurement.dynamite");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(Context context) {
        return DynamiteModule.a(context, "com.google.android.gms.measurement.dynamite");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Exception exc, boolean z, boolean z2) {
        this.h |= z;
        if (z) {
            Log.w(this.c, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            a(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.c, "Error with data collection. Data lost.", exc);
    }

    private static boolean h() throws ClassNotFoundException {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void a(String str, String str2, Bundle bundle) {
        a(str, str2, bundle, true, true, null);
    }

    private final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        a(new ac(this, l, str, str2, bundle, true, z2));
    }

    public final void a(String str, String str2, Object obj, boolean z) {
        a(new ad(this, str, str2, obj, true));
    }

    public final void a(Bundle bundle) {
        a(new ae(this, bundle));
    }

    public final void b(String str, String str2, Bundle bundle) {
        a(new o(this, str, str2, bundle));
    }

    public final List<Bundle> a(String str, String str2) {
        a aVar = new a();
        a(new p(this, str, str2, aVar));
        List<Bundle> listB = aVar.b(5000L);
        return listB == null ? Collections.emptyList() : listB;
    }

    public final void a(Activity activity, String str, String str2) {
        a(new q(this, activity, str, str2));
    }

    public final void a(String str) {
        a(new r(this, str));
    }

    public final void b(String str) {
        a(new s(this, str));
    }

    public final String b() {
        a aVar = new a();
        a(new t(this, aVar));
        return aVar.a(500L);
    }

    public final String c() {
        a aVar = new a();
        a(new u(this, aVar));
        return aVar.a(50L);
    }

    public final long d() {
        a aVar = new a();
        a(new v(this, aVar));
        Long lC = aVar.c(500L);
        if (lC == null) {
            long jNextLong = new Random(System.nanoTime() ^ this.f3697a.a()).nextLong();
            int i = this.g + 1;
            this.g = i;
            return jNextLong + i;
        }
        return lC.longValue();
    }

    public final String e() {
        a aVar = new a();
        a(new w(this, aVar));
        return aVar.a(500L);
    }

    public final String f() {
        a aVar = new a();
        a(new x(this, aVar));
        return aVar.a(500L);
    }

    public final Map<String, Object> a(String str, String str2, boolean z) {
        a aVar = new a();
        a(new y(this, str, str2, z, aVar));
        Bundle bundleE = aVar.e(5000L);
        if (bundleE == null || bundleE.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundleE.size());
        for (String str3 : bundleE.keySet()) {
            Object obj = bundleE.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    public final void a(int i, String str, Object obj, Object obj2, Object obj3) {
        a(new z(this, false, 5, str, obj, obj2, obj3));
    }

    public final Bundle a(Bundle bundle, boolean z) {
        a aVar = new a();
        a(new aa(this, bundle, aVar));
        if (z) {
            return aVar.e(5000L);
        }
        return null;
    }

    public final int c(String str) {
        a aVar = new a();
        a(new ab(this, str, aVar));
        Integer numD = aVar.d(10000L);
        if (numD == null) {
            return 25;
        }
        return numD.intValue();
    }

    public final String g() {
        return this.i;
    }
}
