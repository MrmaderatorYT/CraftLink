package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.squareup.picasso.a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: Picasso.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    static final Handler f4151a = new Handler(Looper.getMainLooper()) { // from class: com.squareup.picasso.t.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 3) {
                com.squareup.picasso.a aVar = (com.squareup.picasso.a) message.obj;
                if (aVar.i().l) {
                    ad.a("Main", "canceled", aVar.f4100b.a(), "target got garbage collected");
                }
                aVar.f4099a.a(aVar.c());
                return;
            }
            int i2 = 0;
            if (i == 8) {
                List list = (List) message.obj;
                int size = list.size();
                while (i2 < size) {
                    com.squareup.picasso.c cVar = (com.squareup.picasso.c) list.get(i2);
                    cVar.f4114b.a(cVar);
                    i2++;
                }
                return;
            }
            if (i == 13) {
                List list2 = (List) message.obj;
                int size2 = list2.size();
                while (i2 < size2) {
                    com.squareup.picasso.a aVar2 = (com.squareup.picasso.a) list2.get(i2);
                    aVar2.f4099a.c(aVar2);
                    i2++;
                }
                return;
            }
            throw new AssertionError("Unknown handler message received: " + message.what);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    static volatile t f4152b = null;
    final Context c;
    final i d;
    final com.squareup.picasso.d e;
    final aa f;
    final Map<Object, com.squareup.picasso.a> g;
    final Map<ImageView, h> h;
    final ReferenceQueue<Object> i;
    final Bitmap.Config j;
    boolean k;
    volatile boolean l;
    boolean m;
    private final c n;
    private final f o;
    private final b p;
    private final List<y> q;

    /* compiled from: Picasso.java */
    public interface c {
        void a(t tVar, Uri uri, Exception exc);
    }

    /* compiled from: Picasso.java */
    public enum e {
        LOW,
        NORMAL,
        HIGH
    }

    /* compiled from: Picasso.java */
    public interface f {

        /* renamed from: a, reason: collision with root package name */
        public static final f f4163a = new f() { // from class: com.squareup.picasso.t.f.1
            @Override // com.squareup.picasso.t.f
            public w a(w wVar) {
                return wVar;
            }
        };

        w a(w wVar);
    }

    t(Context context, i iVar, com.squareup.picasso.d dVar, c cVar, f fVar, List<y> list, aa aaVar, Bitmap.Config config, boolean z, boolean z2) {
        this.c = context;
        this.d = iVar;
        this.e = dVar;
        this.n = cVar;
        this.o = fVar;
        this.j = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new z(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new com.squareup.picasso.f(context));
        arrayList.add(new o(context));
        arrayList.add(new g(context));
        arrayList.add(new com.squareup.picasso.b(context));
        arrayList.add(new k(context));
        arrayList.add(new r(iVar.d, aaVar));
        this.q = Collections.unmodifiableList(arrayList);
        this.f = aaVar;
        this.g = new WeakHashMap();
        this.h = new WeakHashMap();
        this.k = z;
        this.l = z2;
        this.i = new ReferenceQueue<>();
        this.p = new b(this.i, f4151a);
        this.p.start();
    }

    public void a(ImageView imageView) {
        if (imageView == null) {
            throw new IllegalArgumentException("view cannot be null.");
        }
        a((Object) imageView);
    }

    public x a(Uri uri) {
        return new x(this, uri, 0);
    }

    public x a(String str) {
        if (str == null) {
            return new x(this, null, 0);
        }
        if (str.trim().length() == 0) {
            throw new IllegalArgumentException("Path must not be empty.");
        }
        return a(Uri.parse(str));
    }

    List<y> a() {
        return this.q;
    }

    w a(w wVar) {
        w wVarA = this.o.a(wVar);
        if (wVarA != null) {
            return wVarA;
        }
        throw new IllegalStateException("Request transformer " + this.o.getClass().getCanonicalName() + " returned null for " + wVar);
    }

    void a(ImageView imageView, h hVar) {
        if (this.h.containsKey(imageView)) {
            a((Object) imageView);
        }
        this.h.put(imageView, hVar);
    }

    void a(com.squareup.picasso.a aVar) {
        Object objC = aVar.c();
        if (objC != null && this.g.get(objC) != aVar) {
            a(objC);
            this.g.put(objC, aVar);
        }
        b(aVar);
    }

    void b(com.squareup.picasso.a aVar) {
        this.d.a(aVar);
    }

    Bitmap b(String str) {
        Bitmap bitmapA = this.e.a(str);
        if (bitmapA != null) {
            this.f.a();
        } else {
            this.f.b();
        }
        return bitmapA;
    }

    void a(com.squareup.picasso.c cVar) {
        com.squareup.picasso.a aVarI = cVar.i();
        List<com.squareup.picasso.a> listK = cVar.k();
        boolean z = true;
        boolean z2 = (listK == null || listK.isEmpty()) ? false : true;
        if (aVarI == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = cVar.h().d;
            Exception excL = cVar.l();
            Bitmap bitmapE = cVar.e();
            d dVarM = cVar.m();
            if (aVarI != null) {
                a(bitmapE, dVarM, aVarI, excL);
            }
            if (z2) {
                int size = listK.size();
                for (int i = 0; i < size; i++) {
                    a(bitmapE, dVarM, listK.get(i), excL);
                }
            }
            if (this.n == null || excL == null) {
                return;
            }
            this.n.a(this, uri, excL);
        }
    }

    void c(com.squareup.picasso.a aVar) {
        Bitmap bitmapB = p.a(aVar.e) ? b(aVar.d()) : null;
        if (bitmapB != null) {
            a(bitmapB, d.MEMORY, aVar, null);
            if (this.l) {
                ad.a("Main", "completed", aVar.f4100b.a(), "from " + d.MEMORY);
                return;
            }
            return;
        }
        a(aVar);
        if (this.l) {
            ad.a("Main", "resumed", aVar.f4100b.a());
        }
    }

    private void a(Bitmap bitmap, d dVar, com.squareup.picasso.a aVar, Exception exc) {
        if (aVar.e()) {
            return;
        }
        if (!aVar.f()) {
            this.g.remove(aVar.c());
        }
        if (bitmap == null) {
            aVar.a(exc);
            if (this.l) {
                ad.a("Main", "errored", aVar.f4100b.a(), exc.getMessage());
                return;
            }
            return;
        }
        if (dVar == null) {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        aVar.a(bitmap, dVar);
        if (this.l) {
            ad.a("Main", "completed", aVar.f4100b.a(), "from " + dVar);
        }
    }

    void a(Object obj) {
        ad.a();
        com.squareup.picasso.a aVarRemove = this.g.remove(obj);
        if (aVarRemove != null) {
            aVarRemove.a();
            this.d.b(aVarRemove);
        }
        if (obj instanceof ImageView) {
            h hVarRemove = this.h.remove((ImageView) obj);
            if (hVarRemove != null) {
                hVarRemove.a();
            }
        }
    }

    /* compiled from: Picasso.java */
    private static class b extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private final ReferenceQueue<Object> f4155a;

        /* renamed from: b, reason: collision with root package name */
        private final Handler f4156b;

        b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.f4155a = referenceQueue;
            this.f4156b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a.C0093a c0093a = (a.C0093a) this.f4155a.remove(1000L);
                    Message messageObtainMessage = this.f4156b.obtainMessage();
                    if (c0093a != null) {
                        messageObtainMessage.what = 3;
                        messageObtainMessage.obj = c0093a.f4101a;
                        this.f4156b.sendMessage(messageObtainMessage);
                    } else {
                        messageObtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.f4156b.post(new Runnable() { // from class: com.squareup.picasso.t.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new RuntimeException(e);
                        }
                    });
                    return;
                }
            }
        }
    }

    public static t b() {
        if (f4152b == null) {
            synchronized (t.class) {
                if (f4152b == null) {
                    if (PicassoProvider.f4098a == null) {
                        throw new IllegalStateException("context == null");
                    }
                    f4152b = new a(PicassoProvider.f4098a).a();
                }
            }
        }
        return f4152b;
    }

    /* compiled from: Picasso.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f4153a;

        /* renamed from: b, reason: collision with root package name */
        private j f4154b;
        private ExecutorService c;
        private com.squareup.picasso.d d;
        private c e;
        private f f;
        private List<y> g;
        private Bitmap.Config h;
        private boolean i;
        private boolean j;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f4153a = context.getApplicationContext();
        }

        public t a() {
            Context context = this.f4153a;
            if (this.f4154b == null) {
                this.f4154b = new s(context);
            }
            if (this.d == null) {
                this.d = new m(context);
            }
            if (this.c == null) {
                this.c = new v();
            }
            if (this.f == null) {
                this.f = f.f4163a;
            }
            aa aaVar = new aa(this.d);
            return new t(context, new i(context, this.c, t.f4151a, this.f4154b, this.d, aaVar), this.d, this.e, this.f, this.g, aaVar, this.h, this.i, this.j);
        }
    }

    /* compiled from: Picasso.java */
    public enum d {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);

        final int d;

        d(int i) {
            this.d = i;
        }
    }
}
