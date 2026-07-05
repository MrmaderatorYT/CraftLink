package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public abstract class b<T extends IInterface> {
    private com.google.android.gms.common.b A;
    private boolean B;
    private volatile com.google.android.gms.common.internal.k C;

    /* renamed from: a, reason: collision with root package name */
    final Handler f1708a;

    /* renamed from: b, reason: collision with root package name */
    protected c f1709b;
    protected AtomicInteger c;
    private int f;
    private long g;
    private long h;
    private int i;
    private long j;
    private p k;
    private final Context l;
    private final Looper m;
    private final com.google.android.gms.common.internal.d n;
    private final com.google.android.gms.common.d o;
    private final Object p;
    private final Object q;

    @GuardedBy("mServiceBrokerLock")
    private com.google.android.gms.common.internal.g r;

    @GuardedBy("mLock")
    private T s;
    private final ArrayList<g<?>> t;

    @GuardedBy("mLock")
    private i u;

    @GuardedBy("mLock")
    private int v;
    private final a w;
    private final InterfaceC0066b x;
    private final int y;
    private final String z;
    private static final com.google.android.gms.common.c[] e = new com.google.android.gms.common.c[0];
    public static final String[] d = {"service_esmobile", "service_googleme"};

    public interface a {
        void a(int i);

        void a(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.common.internal.b$b, reason: collision with other inner class name */
    public interface InterfaceC0066b {
        void a(com.google.android.gms.common.b bVar);
    }

    public interface c {
        void a(com.google.android.gms.common.b bVar);
    }

    protected class d implements c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.b.c
        public void a(com.google.android.gms.common.b bVar) {
            if (bVar.a()) {
                b.this.a((com.google.android.gms.common.internal.e) null, b.this.r());
            } else if (b.this.x != null) {
                b.this.x.a(bVar);
            }
        }
    }

    protected abstract T a(IBinder iBinder);

    protected abstract String a();

    void a(int i2, T t) {
    }

    protected String b() {
        return "com.google.android.gms";
    }

    protected abstract String c();

    protected String d() {
        return null;
    }

    public Account j() {
        return null;
    }

    public Bundle n() {
        return null;
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    protected b(Context context, Looper looper, int i2, a aVar, InterfaceC0066b interfaceC0066b, String str) {
        this(context, looper, com.google.android.gms.common.internal.d.a(context), com.google.android.gms.common.d.a(), i2, (a) com.google.android.gms.common.internal.i.a(aVar), (InterfaceC0066b) com.google.android.gms.common.internal.i.a(interfaceC0066b), str);
    }

    final class f extends com.google.android.gms.internal.b.e {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            com.google.android.gms.common.b bVar;
            com.google.android.gms.common.b bVar2;
            if (b.this.c.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                    return;
                }
                return;
            }
            if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !b.this.g()) {
                a(message);
                return;
            }
            if (message.what != 4) {
                if (message.what != 5) {
                    if (message.what == 3) {
                        com.google.android.gms.common.b bVar3 = new com.google.android.gms.common.b(message.arg2, message.obj instanceof PendingIntent ? (PendingIntent) message.obj : null);
                        b.this.f1709b.a(bVar3);
                        b.this.a(bVar3);
                        return;
                    }
                    if (message.what != 6) {
                        if (message.what == 2 && !b.this.f()) {
                            a(message);
                            return;
                        }
                        if (b(message)) {
                            ((g) message.obj).c();
                            return;
                        }
                        int i = message.what;
                        StringBuilder sb = new StringBuilder(45);
                        sb.append("Don't know how to handle message: ");
                        sb.append(i);
                        Log.wtf("GmsClient", sb.toString(), new Exception());
                        return;
                    }
                    b.this.b(5, null);
                    if (b.this.w != null) {
                        b.this.w.a(message.arg2);
                    }
                    b.this.a(message.arg2);
                    b.this.a(5, 1, (int) null);
                    return;
                }
                if (b.this.A == null) {
                    bVar = new com.google.android.gms.common.b(8);
                } else {
                    bVar = b.this.A;
                }
                b.this.f1709b.a(bVar);
                b.this.a(bVar);
                return;
            }
            b.this.A = new com.google.android.gms.common.b(message.arg2);
            if (b.this.v() && !b.this.B) {
                b.this.b(3, null);
                return;
            }
            if (b.this.A == null) {
                bVar2 = new com.google.android.gms.common.b(8);
            } else {
                bVar2 = b.this.A;
            }
            b.this.f1709b.a(bVar2);
            b.this.a(bVar2);
        }

        private static void a(Message message) {
            g gVar = (g) message.obj;
            gVar.b();
            gVar.d();
        }

        private static boolean b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 7;
        }
    }

    protected final class k extends e {
        public k(int i, Bundle bundle) {
            super(i, null);
        }

        @Override // com.google.android.gms.common.internal.b.e
        protected final void a(com.google.android.gms.common.b bVar) {
            b.this.f1709b.a(bVar);
            b.this.a(bVar);
        }

        @Override // com.google.android.gms.common.internal.b.e
        protected final boolean a() {
            b.this.f1709b.a(com.google.android.gms.common.b.f1693a);
            return true;
        }
    }

    protected abstract class g<TListener> {

        /* renamed from: a, reason: collision with root package name */
        private TListener f1714a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f1715b = false;

        public g(TListener tlistener) {
            this.f1714a = tlistener;
        }

        protected abstract void a(TListener tlistener);

        protected abstract void b();

        public final void c() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f1714a;
                if (this.f1715b) {
                    String strValueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(strValueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e) {
                    b();
                    throw e;
                }
            } else {
                b();
            }
            synchronized (this) {
                this.f1715b = true;
            }
            d();
        }

        public final void d() {
            e();
            synchronized (b.this.t) {
                b.this.t.remove(this);
            }
        }

        public final void e() {
            synchronized (this) {
                this.f1714a = null;
            }
        }
    }

    public static final class h extends f.a {

        /* renamed from: a, reason: collision with root package name */
        private b f1716a;

        /* renamed from: b, reason: collision with root package name */
        private final int f1717b;

        public h(b bVar, int i) {
            this.f1716a = bVar;
            this.f1717b = i;
        }

        @Override // com.google.android.gms.common.internal.f
        public final void a(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.f
        public final void a(int i, IBinder iBinder, Bundle bundle) {
            com.google.android.gms.common.internal.i.a(this.f1716a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f1716a.a(i, iBinder, bundle, this.f1717b);
            this.f1716a = null;
        }

        @Override // com.google.android.gms.common.internal.f
        public final void a(int i, IBinder iBinder, com.google.android.gms.common.internal.k kVar) {
            com.google.android.gms.common.internal.i.a(this.f1716a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            com.google.android.gms.common.internal.i.a(kVar);
            this.f1716a.a(kVar);
            a(i, iBinder, kVar.f1734a);
        }
    }

    public final class i implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final int f1718a;

        public i(int i) {
            this.f1718a = i;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.google.android.gms.common.internal.g c0068a;
            if (iBinder == null) {
                b.this.c(16);
                return;
            }
            synchronized (b.this.q) {
                b bVar = b.this;
                if (iBinder == null) {
                    c0068a = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.google.android.gms.common.internal.g)) {
                        c0068a = (com.google.android.gms.common.internal.g) iInterfaceQueryLocalInterface;
                    } else {
                        c0068a = new g.a.C0068a(iBinder);
                    }
                }
                bVar.r = c0068a;
            }
            b.this.a(0, (Bundle) null, this.f1718a);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (b.this.q) {
                b.this.r = null;
            }
            b.this.f1708a.sendMessage(b.this.f1708a.obtainMessage(6, this.f1718a, 1));
        }
    }

    protected final class j extends e {

        /* renamed from: a, reason: collision with root package name */
        private final IBinder f1720a;

        public j(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.f1720a = iBinder;
        }

        @Override // com.google.android.gms.common.internal.b.e
        protected final void a(com.google.android.gms.common.b bVar) {
            if (b.this.x != null) {
                b.this.x.a(bVar);
            }
            b.this.a(bVar);
        }

        @Override // com.google.android.gms.common.internal.b.e
        protected final boolean a() throws RemoteException {
            try {
                String interfaceDescriptor = this.f1720a.getInterfaceDescriptor();
                if (!b.this.c().equals(interfaceDescriptor)) {
                    String strC = b.this.c();
                    StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(strC);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface iInterfaceA = b.this.a(this.f1720a);
                if (iInterfaceA == null || !(b.this.a(2, 4, (int) iInterfaceA) || b.this.a(3, 4, (int) iInterfaceA))) {
                    return false;
                }
                b.this.A = null;
                Bundle bundleN = b.this.n();
                if (b.this.w == null) {
                    return true;
                }
                b.this.w.a(bundleN);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    private abstract class e extends g<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        private final int f1711a;

        /* renamed from: b, reason: collision with root package name */
        private final Bundle f1712b;

        protected e(int i, Bundle bundle) {
            super(true);
            this.f1711a = i;
            this.f1712b = bundle;
        }

        protected abstract void a(com.google.android.gms.common.b bVar);

        protected abstract boolean a();

        @Override // com.google.android.gms.common.internal.b.g
        protected final void b() {
        }

        @Override // com.google.android.gms.common.internal.b.g
        protected final /* synthetic */ void a(Boolean bool) {
            if (bool != null) {
                int i = this.f1711a;
                if (i == 0) {
                    if (a()) {
                        return;
                    }
                    b.this.b(1, null);
                    a(new com.google.android.gms.common.b(8, null));
                    return;
                }
                if (i != 10) {
                    b.this.b(1, null);
                    a(new com.google.android.gms.common.b(this.f1711a, this.f1712b != null ? (PendingIntent) this.f1712b.getParcelable("pendingIntent") : null));
                    return;
                } else {
                    b.this.b(1, null);
                    throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), b.this.a(), b.this.c()));
                }
            }
            b.this.b(1, null);
        }
    }

    protected b(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, com.google.android.gms.common.d dVar2, int i2, a aVar, InterfaceC0066b interfaceC0066b, String str) {
        this.p = new Object();
        this.q = new Object();
        this.t = new ArrayList<>();
        this.v = 1;
        this.A = null;
        this.B = false;
        this.C = null;
        this.c = new AtomicInteger(0);
        this.l = (Context) com.google.android.gms.common.internal.i.a(context, "Context must not be null");
        this.m = (Looper) com.google.android.gms.common.internal.i.a(looper, "Looper must not be null");
        this.n = (com.google.android.gms.common.internal.d) com.google.android.gms.common.internal.i.a(dVar, "Supervisor must not be null");
        this.o = (com.google.android.gms.common.d) com.google.android.gms.common.internal.i.a(dVar2, "API availability must not be null");
        this.f1708a = new f(looper);
        this.y = i2;
        this.w = aVar;
        this.x = interfaceC0066b;
        this.z = str;
    }

    private final String t() {
        return this.z == null ? this.l.getClass().getName() : this.z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.google.android.gms.common.internal.k kVar) {
        this.C = kVar;
    }

    protected void a(T t) {
        this.h = System.currentTimeMillis();
    }

    protected void a(int i2) {
        this.f = i2;
        this.g = System.currentTimeMillis();
    }

    protected void a(com.google.android.gms.common.b bVar) {
        this.i = bVar.b();
        this.j = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i2, T t) {
        p pVar;
        com.google.android.gms.common.internal.i.b((i2 == 4) == (t != null));
        synchronized (this.p) {
            this.v = i2;
            this.s = t;
            a(i2, (int) t);
            switch (i2) {
                case 1:
                    if (this.u != null) {
                        this.n.a(a(), b(), 129, this.u, t());
                        this.u = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    if (this.u != null && this.k != null) {
                        String strA = this.k.a();
                        String strB = this.k.b();
                        StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 70 + String.valueOf(strB).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(strA);
                        sb.append(" on ");
                        sb.append(strB);
                        Log.e("GmsClient", sb.toString());
                        this.n.a(this.k.a(), this.k.b(), this.k.c(), this.u, t());
                        this.c.incrementAndGet();
                    }
                    this.u = new i(this.c.get());
                    if (this.v == 3 && d() != null) {
                        pVar = new p(i().getPackageName(), d(), true, 129);
                    } else {
                        pVar = new p(b(), a(), false, 129);
                    }
                    this.k = pVar;
                    if (!this.n.a(new d.a(this.k.a(), this.k.b(), this.k.c()), this.u, t())) {
                        String strA2 = this.k.a();
                        String strB2 = this.k.b();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(strA2).length() + 34 + String.valueOf(strB2).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(strA2);
                        sb2.append(" on ");
                        sb2.append(strB2);
                        Log.e("GmsClient", sb2.toString());
                        a(16, (Bundle) null, this.c.get());
                        break;
                    }
                    break;
                case 4:
                    a((b<T>) t);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(int i2, int i3, T t) {
        synchronized (this.p) {
            if (this.v != i2) {
                return false;
            }
            b(i3, t);
            return true;
        }
    }

    public void e() {
        int iA = this.o.a(this.l, s());
        if (iA != 0) {
            b(1, null);
            a(new d(), iA, (PendingIntent) null);
        } else {
            a(new d());
        }
    }

    public void a(c cVar) {
        this.f1709b = (c) com.google.android.gms.common.internal.i.a(cVar, "Connection progress callbacks cannot be null.");
        b(2, null);
    }

    public boolean f() {
        boolean z;
        synchronized (this.p) {
            z = this.v == 4;
        }
        return z;
    }

    public boolean g() {
        boolean z;
        synchronized (this.p) {
            z = this.v == 2 || this.v == 3;
        }
        return z;
    }

    private final boolean u() {
        boolean z;
        synchronized (this.p) {
            z = this.v == 3;
        }
        return z;
    }

    public void h() {
        this.c.incrementAndGet();
        synchronized (this.t) {
            int size = this.t.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.t.get(i2).e();
            }
            this.t.clear();
        }
        synchronized (this.q) {
            this.r = null;
        }
        b(1, null);
    }

    public void b(int i2) {
        this.f1708a.sendMessage(this.f1708a.obtainMessage(6, this.c.get(), i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int i2) {
        int i3;
        if (u()) {
            i3 = 5;
            this.B = true;
        } else {
            i3 = 4;
        }
        this.f1708a.sendMessage(this.f1708a.obtainMessage(i3, this.c.get(), 16));
    }

    protected void a(c cVar, int i2, PendingIntent pendingIntent) {
        this.f1709b = (c) com.google.android.gms.common.internal.i.a(cVar, "Connection progress callbacks cannot be null.");
        this.f1708a.sendMessage(this.f1708a.obtainMessage(3, this.c.get(), i2, pendingIntent));
    }

    public final Context i() {
        return this.l;
    }

    public com.google.android.gms.common.c[] k() {
        return e;
    }

    protected Bundle l() {
        return new Bundle();
    }

    protected void a(int i2, IBinder iBinder, Bundle bundle, int i3) {
        this.f1708a.sendMessage(this.f1708a.obtainMessage(1, i3, -1, new j(i2, iBinder, bundle)));
    }

    protected final void a(int i2, Bundle bundle, int i3) {
        this.f1708a.sendMessage(this.f1708a.obtainMessage(7, i3, -1, new k(i2, null)));
    }

    protected final void m() {
        if (!f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T o() {
        T t;
        synchronized (this.p) {
            if (this.v == 5) {
                throw new DeadObjectException();
            }
            m();
            com.google.android.gms.common.internal.i.a(this.s != null, "Client is connected but service is null");
            t = this.s;
        }
        return t;
    }

    public void a(com.google.android.gms.common.internal.e eVar, Set<Scope> set) {
        Bundle bundleL = l();
        com.google.android.gms.common.internal.c cVar = new com.google.android.gms.common.internal.c(this.y);
        cVar.f1723a = this.l.getPackageName();
        cVar.d = bundleL;
        if (set != null) {
            cVar.c = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (p()) {
            cVar.e = j() != null ? j() : new Account("<<default account>>", "com.google");
            if (eVar != null) {
                cVar.f1724b = eVar.asBinder();
            }
        } else if (q()) {
            cVar.e = j();
        }
        cVar.f = e;
        cVar.g = k();
        try {
            try {
                synchronized (this.q) {
                    if (this.r != null) {
                        this.r.a(new h(this, this.c.get()), cVar);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                }
            } catch (RemoteException | RuntimeException e2) {
                Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
                a(8, (IBinder) null, (Bundle) null, this.c.get());
            }
        } catch (DeadObjectException e3) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
            b(1);
        } catch (SecurityException e4) {
            throw e4;
        }
    }

    protected Set<Scope> r() {
        return Collections.EMPTY_SET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean v() throws ClassNotFoundException {
        if (this.B || TextUtils.isEmpty(c()) || TextUtils.isEmpty(d())) {
            return false;
        }
        try {
            Class.forName(c());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public int s() {
        return com.google.android.gms.common.d.f1702a;
    }
}
