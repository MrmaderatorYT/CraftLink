package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.a;
import io.fabric.sdk.android.services.b.q;
import io.fabric.sdk.android.services.b.r;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Fabric.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    static volatile c f4183a;

    /* renamed from: b, reason: collision with root package name */
    static final k f4184b = new b();
    final k c;
    final boolean d;
    private final Context e;
    private final Map<Class<? extends h>, h> f;
    private final ExecutorService g;
    private final Handler h;
    private final f<c> i;
    private final f<?> j;
    private final r k;
    private io.fabric.sdk.android.a l;
    private WeakReference<Activity> m;
    private AtomicBoolean n = new AtomicBoolean(false);

    public String c() {
        return "1.4.5.28";
    }

    public String d() {
        return "io.fabric.sdk.android:fabric";
    }

    /* compiled from: Fabric.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f4188a;

        /* renamed from: b, reason: collision with root package name */
        private h[] f4189b;
        private io.fabric.sdk.android.services.concurrency.k c;
        private Handler d;
        private k e;
        private boolean f;
        private String g;
        private String h;
        private f<c> i;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f4188a = context;
        }

        public a a(h... hVarArr) {
            if (this.f4189b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            if (!new q().f(this.f4188a)) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (h hVar : hVarArr) {
                    String strB = hVar.b();
                    char c = 65535;
                    int iHashCode = strB.hashCode();
                    if (iHashCode != 607220212) {
                        if (iHashCode == 1830452504 && strB.equals("com.crashlytics.sdk.android:crashlytics")) {
                            c = 0;
                        }
                    } else if (strB.equals("com.crashlytics.sdk.android:answers")) {
                        c = 1;
                    }
                    switch (c) {
                        case 0:
                        case 1:
                            arrayList.add(hVar);
                            break;
                        default:
                            if (z) {
                                break;
                            } else {
                                c.g().d("Fabric", "Fabric will not initialize any kits when Firebase automatic data collection is disabled; to use Third-party kits with automatic data collection disabled, initialize these kits via non-Fabric means.");
                                z = true;
                                break;
                            }
                    }
                }
                hVarArr = (h[]) arrayList.toArray(new h[0]);
            }
            this.f4189b = hVarArr;
            return this;
        }

        public c a() {
            Map mapB;
            if (this.c == null) {
                this.c = io.fabric.sdk.android.services.concurrency.k.a();
            }
            if (this.d == null) {
                this.d = new Handler(Looper.getMainLooper());
            }
            if (this.e == null) {
                if (this.f) {
                    this.e = new b(3);
                } else {
                    this.e = new b();
                }
            }
            if (this.h == null) {
                this.h = this.f4188a.getPackageName();
            }
            if (this.i == null) {
                this.i = f.d;
            }
            if (this.f4189b != null) {
                mapB = c.b(Arrays.asList(this.f4189b));
            } else {
                mapB = new HashMap();
            }
            Map map = mapB;
            Context applicationContext = this.f4188a.getApplicationContext();
            return new c(applicationContext, map, this.c, this.d, this.e, this.f, this.i, new r(applicationContext, this.h, this.g, map.values()), c.d(this.f4188a));
        }
    }

    static c a() {
        if (f4183a == null) {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        }
        return f4183a;
    }

    c(Context context, Map<Class<? extends h>, h> map, io.fabric.sdk.android.services.concurrency.k kVar, Handler handler, k kVar2, boolean z, f fVar, r rVar, Activity activity) {
        this.e = context;
        this.f = map;
        this.g = kVar;
        this.h = handler;
        this.c = kVar2;
        this.d = z;
        this.i = fVar;
        this.j = a(map.size());
        this.k = rVar;
        a(activity);
    }

    public static c a(Context context, h... hVarArr) {
        if (f4183a == null) {
            synchronized (c.class) {
                if (f4183a == null) {
                    c(new a(context).a(hVarArr).a());
                }
            }
        }
        return f4183a;
    }

    private static void c(c cVar) {
        f4183a = cVar;
        cVar.i();
    }

    public c a(Activity activity) {
        this.m = new WeakReference<>(activity);
        return this;
    }

    public Activity b() {
        if (this.m != null) {
            return this.m.get();
        }
        return null;
    }

    private void i() {
        this.l = new io.fabric.sdk.android.a(this.e);
        this.l.a(new a.b() { // from class: io.fabric.sdk.android.c.1
            @Override // io.fabric.sdk.android.a.b
            public void a(Activity activity, Bundle bundle) {
                c.this.a(activity);
            }

            @Override // io.fabric.sdk.android.a.b
            public void a(Activity activity) {
                c.this.a(activity);
            }

            @Override // io.fabric.sdk.android.a.b
            public void b(Activity activity) {
                c.this.a(activity);
            }
        });
        a(this.e);
    }

    void a(Context context) {
        StringBuilder sb;
        Future<Map<String, j>> futureB = b(context);
        Collection<h> collectionF = f();
        l lVar = new l(futureB, collectionF);
        ArrayList<h> arrayList = new ArrayList(collectionF);
        Collections.sort(arrayList);
        lVar.a(context, this, f.d, this.k);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(context, this, this.j, this.k);
        }
        lVar.p();
        if (g().a("Fabric", 3)) {
            sb = new StringBuilder("Initializing ");
            sb.append(d());
            sb.append(" [Version: ");
            sb.append(c());
            sb.append("], with the following kits:\n");
        } else {
            sb = null;
        }
        for (h hVar : arrayList) {
            hVar.f.c(lVar.f);
            a(this.f, hVar);
            hVar.p();
            if (sb != null) {
                sb.append(hVar.b());
                sb.append(" [Version: ");
                sb.append(hVar.a());
                sb.append("]\n");
            }
        }
        if (sb != null) {
            g().a("Fabric", sb.toString());
        }
    }

    void a(Map<Class<? extends h>, h> map, h hVar) {
        io.fabric.sdk.android.services.concurrency.d dVar = hVar.j;
        if (dVar != null) {
            for (Class<?> cls : dVar.a()) {
                if (cls.isInterface()) {
                    for (h hVar2 : map.values()) {
                        if (cls.isAssignableFrom(hVar2.getClass())) {
                            hVar.f.c(hVar2.f);
                        }
                    }
                } else {
                    if (map.get(cls) == null) {
                        throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                    }
                    hVar.f.c(map.get(cls).f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Activity d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public ExecutorService e() {
        return this.g;
    }

    public Collection<h> f() {
        return this.f.values();
    }

    public static <T extends h> T a(Class<T> cls) {
        return (T) a().f.get(cls);
    }

    public static k g() {
        if (f4183a == null) {
            return f4184b;
        }
        return f4183a.c;
    }

    public static boolean h() {
        if (f4183a == null) {
            return false;
        }
        return f4183a.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Class<? extends h>, h> b(Collection<? extends h> collection) {
        HashMap map = new HashMap(collection.size());
        a(map, collection);
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(Map<Class<? extends h>, h> map, Collection<? extends h> collection) {
        for (Object obj : collection) {
            map.put(obj.getClass(), obj);
            if (obj instanceof i) {
                a(map, ((i) obj).c());
            }
        }
    }

    f<?> a(final int i) {
        return new f() { // from class: io.fabric.sdk.android.c.2

            /* renamed from: a, reason: collision with root package name */
            final CountDownLatch f4186a;

            {
                this.f4186a = new CountDownLatch(i);
            }

            @Override // io.fabric.sdk.android.f
            public void a(Object obj) {
                this.f4186a.countDown();
                if (this.f4186a.getCount() == 0) {
                    c.this.n.set(true);
                    c.this.i.a((f) c.this);
                }
            }

            @Override // io.fabric.sdk.android.f
            public void a(Exception exc) {
                c.this.i.a(exc);
            }
        };
    }

    Future<Map<String, j>> b(Context context) {
        return e().submit(new e(context.getPackageCodePath()));
    }
}
