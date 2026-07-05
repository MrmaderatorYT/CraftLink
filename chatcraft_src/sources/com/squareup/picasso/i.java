package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.squareup.picasso.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Dispatcher.java */
/* loaded from: classes.dex */
class i {

    /* renamed from: a, reason: collision with root package name */
    final b f4126a = new b();

    /* renamed from: b, reason: collision with root package name */
    final Context f4127b;
    final ExecutorService c;
    final j d;
    final Map<String, com.squareup.picasso.c> e;
    final Map<Object, com.squareup.picasso.a> f;
    final Map<Object, com.squareup.picasso.a> g;
    final Set<Object> h;
    final Handler i;
    final Handler j;
    final d k;
    final aa l;
    final List<com.squareup.picasso.c> m;
    final c n;
    final boolean o;
    boolean p;

    i(Context context, ExecutorService executorService, Handler handler, j jVar, d dVar, aa aaVar) {
        this.f4126a.start();
        ad.a(this.f4126a.getLooper());
        this.f4127b = context;
        this.c = executorService;
        this.e = new LinkedHashMap();
        this.f = new WeakHashMap();
        this.g = new WeakHashMap();
        this.h = new LinkedHashSet();
        this.i = new a(this.f4126a.getLooper(), this);
        this.d = jVar;
        this.j = handler;
        this.k = dVar;
        this.l = aaVar;
        this.m = new ArrayList(4);
        this.p = ad.c(this.f4127b);
        this.o = ad.b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.n = new c(this);
        this.n.a();
    }

    void a(com.squareup.picasso.a aVar) {
        this.i.sendMessage(this.i.obtainMessage(1, aVar));
    }

    void b(com.squareup.picasso.a aVar) {
        this.i.sendMessage(this.i.obtainMessage(2, aVar));
    }

    void a(com.squareup.picasso.c cVar) {
        this.i.sendMessage(this.i.obtainMessage(4, cVar));
    }

    void b(com.squareup.picasso.c cVar) {
        this.i.sendMessageDelayed(this.i.obtainMessage(5, cVar), 500L);
    }

    void c(com.squareup.picasso.c cVar) {
        this.i.sendMessage(this.i.obtainMessage(6, cVar));
    }

    void a(NetworkInfo networkInfo) {
        this.i.sendMessage(this.i.obtainMessage(9, networkInfo));
    }

    void a(boolean z) {
        this.i.sendMessage(this.i.obtainMessage(10, z ? 1 : 0, 0));
    }

    void c(com.squareup.picasso.a aVar) {
        a(aVar, true);
    }

    void a(com.squareup.picasso.a aVar, boolean z) {
        if (this.h.contains(aVar.k())) {
            this.g.put(aVar.c(), aVar);
            if (aVar.i().l) {
                ad.a("Dispatcher", "paused", aVar.f4100b.a(), "because tag '" + aVar.k() + "' is paused");
                return;
            }
            return;
        }
        com.squareup.picasso.c cVar = this.e.get(aVar.d());
        if (cVar != null) {
            cVar.a(aVar);
            return;
        }
        if (this.c.isShutdown()) {
            if (aVar.i().l) {
                ad.a("Dispatcher", "ignored", aVar.f4100b.a(), "because shut down");
                return;
            }
            return;
        }
        com.squareup.picasso.c cVarA = com.squareup.picasso.c.a(aVar.i(), this, this.k, this.l, aVar);
        cVarA.n = this.c.submit(cVarA);
        this.e.put(aVar.d(), cVarA);
        if (z) {
            this.f.remove(aVar.c());
        }
        if (aVar.i().l) {
            ad.a("Dispatcher", "enqueued", aVar.f4100b.a());
        }
    }

    void d(com.squareup.picasso.a aVar) {
        String strD = aVar.d();
        com.squareup.picasso.c cVar = this.e.get(strD);
        if (cVar != null) {
            cVar.b(aVar);
            if (cVar.b()) {
                this.e.remove(strD);
                if (aVar.i().l) {
                    ad.a("Dispatcher", "canceled", aVar.b().a());
                }
            }
        }
        if (this.h.contains(aVar.k())) {
            this.g.remove(aVar.c());
            if (aVar.i().l) {
                ad.a("Dispatcher", "canceled", aVar.b().a(), "because paused request got canceled");
            }
        }
        com.squareup.picasso.a aVarRemove = this.f.remove(aVar.c());
        if (aVarRemove == null || !aVarRemove.i().l) {
            return;
        }
        ad.a("Dispatcher", "canceled", aVarRemove.b().a(), "from replaying");
    }

    void a(Object obj) {
        if (this.h.add(obj)) {
            Iterator<com.squareup.picasso.c> it = this.e.values().iterator();
            while (it.hasNext()) {
                com.squareup.picasso.c next = it.next();
                boolean z = next.j().l;
                com.squareup.picasso.a aVarI = next.i();
                List<com.squareup.picasso.a> listK = next.k();
                boolean z2 = (listK == null || listK.isEmpty()) ? false : true;
                if (aVarI != null || z2) {
                    if (aVarI != null && aVarI.k().equals(obj)) {
                        next.b(aVarI);
                        this.g.put(aVarI.c(), aVarI);
                        if (z) {
                            ad.a("Dispatcher", "paused", aVarI.f4100b.a(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = listK.size() - 1; size >= 0; size--) {
                            com.squareup.picasso.a aVar = listK.get(size);
                            if (aVar.k().equals(obj)) {
                                next.b(aVar);
                                this.g.put(aVar.c(), aVar);
                                if (z) {
                                    ad.a("Dispatcher", "paused", aVar.f4100b.a(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.b()) {
                        it.remove();
                        if (z) {
                            ad.a("Dispatcher", "canceled", ad.a(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    void b(Object obj) {
        if (this.h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<com.squareup.picasso.a> it = this.g.values().iterator();
            while (it.hasNext()) {
                com.squareup.picasso.a next = it.next();
                if (next.k().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (arrayList != null) {
                this.j.sendMessage(this.j.obtainMessage(13, arrayList));
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    void d(com.squareup.picasso.c cVar) {
        if (cVar.c()) {
            return;
        }
        boolean z = false;
        if (this.c.isShutdown()) {
            a(cVar, false);
            return;
        }
        if (cVar.a(this.p, this.o ? ((ConnectivityManager) ad.a(this.f4127b, "connectivity")).getActiveNetworkInfo() : null)) {
            if (cVar.j().l) {
                ad.a("Dispatcher", "retrying", ad.a(cVar));
            }
            if (cVar.l() instanceof r.a) {
                cVar.i |= q.NO_CACHE.d;
            }
            cVar.n = this.c.submit(cVar);
            return;
        }
        if (this.o && cVar.d()) {
            z = true;
        }
        a(cVar, z);
        if (z) {
            f(cVar);
        }
    }

    void e(com.squareup.picasso.c cVar) {
        if (p.b(cVar.g())) {
            this.k.a(cVar.f(), cVar.e());
        }
        this.e.remove(cVar.f());
        g(cVar);
        if (cVar.j().l) {
            ad.a("Dispatcher", "batched", ad.a(cVar), "for completion");
        }
    }

    void a() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        this.j.sendMessage(this.j.obtainMessage(8, arrayList));
        a((List<com.squareup.picasso.c>) arrayList);
    }

    void a(com.squareup.picasso.c cVar, boolean z) {
        if (cVar.j().l) {
            String strA = ad.a(cVar);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : BuildConfig.FLAVOR);
            ad.a("Dispatcher", "batched", strA, sb.toString());
        }
        this.e.remove(cVar.f());
        g(cVar);
    }

    void b(boolean z) {
        this.p = z;
    }

    void b(NetworkInfo networkInfo) {
        if (this.c instanceof v) {
            ((v) this.c).a(networkInfo);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return;
        }
        b();
    }

    private void b() {
        if (this.f.isEmpty()) {
            return;
        }
        Iterator<com.squareup.picasso.a> it = this.f.values().iterator();
        while (it.hasNext()) {
            com.squareup.picasso.a next = it.next();
            it.remove();
            if (next.i().l) {
                ad.a("Dispatcher", "replaying", next.b().a());
            }
            a(next, false);
        }
    }

    private void f(com.squareup.picasso.c cVar) {
        com.squareup.picasso.a aVarI = cVar.i();
        if (aVarI != null) {
            e(aVarI);
        }
        List<com.squareup.picasso.a> listK = cVar.k();
        if (listK != null) {
            int size = listK.size();
            for (int i = 0; i < size; i++) {
                e(listK.get(i));
            }
        }
    }

    private void e(com.squareup.picasso.a aVar) {
        Object objC = aVar.c();
        if (objC != null) {
            aVar.k = true;
            this.f.put(objC, aVar);
        }
    }

    private void g(com.squareup.picasso.c cVar) {
        if (cVar.c()) {
            return;
        }
        if (cVar.m != null) {
            cVar.m.prepareToDraw();
        }
        this.m.add(cVar);
        if (this.i.hasMessages(7)) {
            return;
        }
        this.i.sendEmptyMessageDelayed(7, 200L);
    }

    private void a(List<com.squareup.picasso.c> list) {
        if (list == null || list.isEmpty() || !list.get(0).j().l) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (com.squareup.picasso.c cVar : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(ad.a(cVar));
        }
        ad.a("Dispatcher", "delivered", sb.toString());
    }

    /* compiled from: Dispatcher.java */
    private static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final i f4128a;

        a(Looper looper, i iVar) {
            super(looper);
            this.f4128a = iVar;
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            switch (message.what) {
                case 1:
                    this.f4128a.c((com.squareup.picasso.a) message.obj);
                    break;
                case 2:
                    this.f4128a.d((com.squareup.picasso.a) message.obj);
                    break;
                case 3:
                case 8:
                default:
                    t.f4151a.post(new Runnable() { // from class: com.squareup.picasso.i.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new AssertionError("Unknown handler message received: " + message.what);
                        }
                    });
                    break;
                case 4:
                    this.f4128a.e((com.squareup.picasso.c) message.obj);
                    break;
                case 5:
                    this.f4128a.d((com.squareup.picasso.c) message.obj);
                    break;
                case 6:
                    this.f4128a.a((com.squareup.picasso.c) message.obj, false);
                    break;
                case 7:
                    this.f4128a.a();
                    break;
                case 9:
                    this.f4128a.b((NetworkInfo) message.obj);
                    break;
                case 10:
                    this.f4128a.b(message.arg1 == 1);
                    break;
                case 11:
                    this.f4128a.a(message.obj);
                    break;
                case 12:
                    this.f4128a.b(message.obj);
                    break;
            }
        }
    }

    /* compiled from: Dispatcher.java */
    static class b extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* compiled from: Dispatcher.java */
    static class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final i f4131a;

        c(i iVar) {
            this.f4131a = iVar;
        }

        void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f4131a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f4131a.f4127b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    this.f4131a.a(intent.getBooleanExtra("state", false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.f4131a.a(((ConnectivityManager) ad.a(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }
}
