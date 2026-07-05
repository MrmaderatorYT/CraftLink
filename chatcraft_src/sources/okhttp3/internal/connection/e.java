package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.ac;
import okhttp3.p;
import okhttp3.s;

/* compiled from: RouteSelector.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final okhttp3.a f5140a;

    /* renamed from: b, reason: collision with root package name */
    private final d f5141b;
    private final okhttp3.e c;
    private final p d;
    private int f;
    private List<Proxy> e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<ac> h = new ArrayList();

    public e(okhttp3.a aVar, d dVar, okhttp3.e eVar, p pVar) {
        this.f5140a = aVar;
        this.f5141b = dVar;
        this.c = eVar;
        this.d = pVar;
        a(aVar.a(), aVar.h());
    }

    public boolean a() {
        return c() || !this.h.isEmpty();
    }

    public a b() throws SocketException, UnknownHostException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            Proxy proxyD = d();
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                ac acVar = new ac(this.f5140a, proxyD, this.g.get(i));
                if (this.f5141b.c(acVar)) {
                    this.h.add(acVar);
                } else {
                    arrayList.add(acVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.h);
            this.h.clear();
        }
        return new a(arrayList);
    }

    public void a(ac acVar, IOException iOException) {
        if (acVar.b().type() != Proxy.Type.DIRECT && this.f5140a.g() != null) {
            this.f5140a.g().connectFailed(this.f5140a.a().a(), acVar.b().address(), iOException);
        }
        this.f5141b.a(acVar);
    }

    private void a(s sVar, Proxy proxy) {
        List<Proxy> listA;
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.f5140a.g().select(sVar.a());
            if (listSelect != null && !listSelect.isEmpty()) {
                listA = okhttp3.internal.c.a(listSelect);
            } else {
                listA = okhttp3.internal.c.a(Proxy.NO_PROXY);
            }
            this.e = listA;
        }
        this.f = 0;
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy d() throws SocketException, UnknownHostException {
        if (!c()) {
            throw new SocketException("No route to " + this.f5140a.a().f() + "; exhausted proxy configurations: " + this.e);
        }
        List<Proxy> list = this.e;
        int i = this.f;
        this.f = i + 1;
        Proxy proxy = list.get(i);
        a(proxy);
        return proxy;
    }

    private void a(Proxy proxy) throws SocketException, UnknownHostException {
        String strF;
        int iG;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strF = this.f5140a.a().f();
            iG = this.f5140a.a().g();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strF = a(inetSocketAddress);
            iG = inetSocketAddress.getPort();
        }
        if (iG < 1 || iG > 65535) {
            throw new SocketException("No route to " + strF + ":" + iG + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(strF, iG));
            return;
        }
        this.d.a(this.c, strF);
        List<InetAddress> listA = this.f5140a.b().a(strF);
        if (listA.isEmpty()) {
            throw new UnknownHostException(this.f5140a.b() + " returned no addresses for " + strF);
        }
        this.d.a(this.c, strF, listA);
        int size = listA.size();
        for (int i = 0; i < size; i++) {
            this.g.add(new InetSocketAddress(listA.get(i), iG));
        }
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* compiled from: RouteSelector.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<ac> f5142a;

        /* renamed from: b, reason: collision with root package name */
        private int f5143b = 0;

        a(List<ac> list) {
            this.f5142a = list;
        }

        public boolean a() {
            return this.f5143b < this.f5142a.size();
        }

        public ac b() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            List<ac> list = this.f5142a;
            int i = this.f5143b;
            this.f5143b = i + 1;
            return list.get(i);
        }

        public List<ac> c() {
            return new ArrayList(this.f5142a);
        }
    }
}
