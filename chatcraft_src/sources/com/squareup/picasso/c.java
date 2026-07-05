package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.os.Build;
import com.squareup.picasso.r;
import com.squareup.picasso.t;
import com.squareup.picasso.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BitmapHunter.java */
/* loaded from: classes.dex */
class c implements Runnable {
    private static final Object t = new Object();
    private static final ThreadLocal<StringBuilder> u = new ThreadLocal<StringBuilder>() { // from class: com.squareup.picasso.c.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };
    private static final AtomicInteger v = new AtomicInteger();
    private static final y w = new y() { // from class: com.squareup.picasso.c.2
        @Override // com.squareup.picasso.y
        public boolean a(w wVar) {
            return true;
        }

        @Override // com.squareup.picasso.y
        public y.a a(w wVar, int i) {
            throw new IllegalStateException("Unrecognized type of request: " + wVar);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    final int f4113a = v.incrementAndGet();

    /* renamed from: b, reason: collision with root package name */
    final t f4114b;
    final i c;
    final d d;
    final aa e;
    final String f;
    final w g;
    final int h;
    int i;
    final y j;
    a k;
    List<a> l;
    Bitmap m;
    Future<?> n;
    t.d o;
    Exception p;
    int q;
    int r;
    t.e s;

    static int a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    private static boolean a(boolean z, int i, int i2, int i3, int i4) {
        return !z || (i3 != 0 && i > i3) || (i4 != 0 && i2 > i4);
    }

    static int b(int i) {
        if (i != 2 && i != 7) {
            switch (i) {
                case 4:
                case 5:
                    break;
                default:
                    return 1;
            }
        }
        return -1;
    }

    c(t tVar, i iVar, d dVar, aa aaVar, a aVar, y yVar) {
        this.f4114b = tVar;
        this.c = iVar;
        this.d = dVar;
        this.e = aaVar;
        this.k = aVar;
        this.f = aVar.d();
        this.g = aVar.b();
        this.s = aVar.j();
        this.h = aVar.g();
        this.i = aVar.h();
        this.j = yVar;
        this.r = yVar.a();
    }

    static Bitmap a(b.s sVar, w wVar) throws IOException {
        b.e eVarA = b.l.a(sVar);
        boolean zA = ad.a(eVarA);
        boolean z = wVar.r && Build.VERSION.SDK_INT < 21;
        BitmapFactory.Options optionsC = y.c(wVar);
        boolean zA2 = y.a(optionsC);
        if (zA || z) {
            byte[] bArrR = eVarA.r();
            if (zA2) {
                BitmapFactory.decodeByteArray(bArrR, 0, bArrR.length, optionsC);
                y.a(wVar.h, wVar.i, optionsC, wVar);
            }
            return BitmapFactory.decodeByteArray(bArrR, 0, bArrR.length, optionsC);
        }
        InputStream inputStreamF = eVarA.f();
        if (zA2) {
            n nVar = new n(inputStreamF);
            nVar.a(false);
            long jA = nVar.a(1024);
            BitmapFactory.decodeStream(nVar, null, optionsC);
            y.a(wVar.h, wVar.i, optionsC, wVar);
            nVar.a(jA);
            nVar.a(true);
            inputStreamF = nVar;
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamF, null, optionsC);
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    a(this.g);
                    if (this.f4114b.l) {
                        ad.a("Hunter", "executing", ad.a(this));
                    }
                    this.m = a();
                    if (this.m == null) {
                        this.c.c(this);
                    } else {
                        this.c.a(this);
                    }
                } catch (r.b e) {
                    if (!q.c(e.f4148b) || e.f4147a != 504) {
                        this.p = e;
                    }
                    this.c.c(this);
                } catch (Exception e2) {
                    this.p = e2;
                    this.c.c(this);
                }
            } catch (IOException e3) {
                this.p = e3;
                this.c.b(this);
            } catch (OutOfMemoryError e4) {
                StringWriter stringWriter = new StringWriter();
                this.e.e().a(new PrintWriter(stringWriter));
                this.p = new RuntimeException(stringWriter.toString(), e4);
                this.c.c(this);
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }

    Bitmap a() throws IOException {
        Bitmap bitmapA;
        if (p.a(this.h)) {
            bitmapA = this.d.a(this.f);
            if (bitmapA != null) {
                this.e.a();
                this.o = t.d.MEMORY;
                if (this.f4114b.l) {
                    ad.a("Hunter", "decoded", this.g.a(), "from cache");
                }
                return bitmapA;
            }
        } else {
            bitmapA = null;
        }
        this.i = this.r == 0 ? q.OFFLINE.d : this.i;
        y.a aVarA = this.j.a(this.g, this.i);
        if (aVarA != null) {
            this.o = aVarA.c();
            this.q = aVarA.d();
            bitmapA = aVarA.a();
            if (bitmapA == null) {
                b.s sVarB = aVarA.b();
                try {
                    bitmapA = a(sVarB, this.g);
                } finally {
                    try {
                        sVarB.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (bitmapA != null) {
            if (this.f4114b.l) {
                ad.a("Hunter", "decoded", this.g.a());
            }
            this.e.a(bitmapA);
            if (this.g.e() || this.q != 0) {
                synchronized (t) {
                    if (this.g.f() || this.q != 0) {
                        bitmapA = a(this.g, bitmapA, this.q);
                        if (this.f4114b.l) {
                            ad.a("Hunter", "transformed", this.g.a());
                        }
                    }
                    if (this.g.g()) {
                        bitmapA = a(this.g.g, bitmapA);
                        if (this.f4114b.l) {
                            ad.a("Hunter", "transformed", this.g.a(), "from custom transformations");
                        }
                    }
                }
                if (bitmapA != null) {
                    this.e.b(bitmapA);
                }
            }
        }
        return bitmapA;
    }

    void a(a aVar) {
        boolean z = this.f4114b.l;
        w wVar = aVar.f4100b;
        if (this.k == null) {
            this.k = aVar;
            if (z) {
                if (this.l == null || this.l.isEmpty()) {
                    ad.a("Hunter", "joined", wVar.a(), "to empty hunter");
                    return;
                } else {
                    ad.a("Hunter", "joined", wVar.a(), ad.a(this, "to "));
                    return;
                }
            }
            return;
        }
        if (this.l == null) {
            this.l = new ArrayList(3);
        }
        this.l.add(aVar);
        if (z) {
            ad.a("Hunter", "joined", wVar.a(), ad.a(this, "to "));
        }
        t.e eVarJ = aVar.j();
        if (eVarJ.ordinal() > this.s.ordinal()) {
            this.s = eVarJ;
        }
    }

    void b(a aVar) {
        boolean zRemove;
        if (this.k == aVar) {
            this.k = null;
            zRemove = true;
        } else {
            zRemove = this.l != null ? this.l.remove(aVar) : false;
        }
        if (zRemove && aVar.j() == this.s) {
            this.s = o();
        }
        if (this.f4114b.l) {
            ad.a("Hunter", "removed", aVar.f4100b.a(), ad.a(this, "from "));
        }
    }

    private t.e o() {
        t.e eVarJ = t.e.LOW;
        boolean z = true;
        boolean z2 = (this.l == null || this.l.isEmpty()) ? false : true;
        if (this.k == null && !z2) {
            z = false;
        }
        if (!z) {
            return eVarJ;
        }
        if (this.k != null) {
            eVarJ = this.k.j();
        }
        if (z2) {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                t.e eVarJ2 = this.l.get(i).j();
                if (eVarJ2.ordinal() > eVarJ.ordinal()) {
                    eVarJ = eVarJ2;
                }
            }
        }
        return eVarJ;
    }

    boolean b() {
        if (this.k == null) {
            return (this.l == null || this.l.isEmpty()) && this.n != null && this.n.cancel(false);
        }
        return false;
    }

    boolean c() {
        return this.n != null && this.n.isCancelled();
    }

    boolean a(boolean z, NetworkInfo networkInfo) {
        if (!(this.r > 0)) {
            return false;
        }
        this.r--;
        return this.j.a(z, networkInfo);
    }

    boolean d() {
        return this.j.b();
    }

    Bitmap e() {
        return this.m;
    }

    String f() {
        return this.f;
    }

    int g() {
        return this.h;
    }

    w h() {
        return this.g;
    }

    a i() {
        return this.k;
    }

    t j() {
        return this.f4114b;
    }

    List<a> k() {
        return this.l;
    }

    Exception l() {
        return this.p;
    }

    t.d m() {
        return this.o;
    }

    t.e n() {
        return this.s;
    }

    static void a(w wVar) {
        String strC = wVar.c();
        StringBuilder sb = u.get();
        sb.ensureCapacity("Picasso-".length() + strC.length());
        sb.replace("Picasso-".length(), sb.length(), strC);
        Thread.currentThread().setName(sb.toString());
    }

    static c a(t tVar, i iVar, d dVar, aa aaVar, a aVar) {
        w wVarB = aVar.b();
        List<y> listA = tVar.a();
        int size = listA.size();
        for (int i = 0; i < size; i++) {
            y yVar = listA.get(i);
            if (yVar.a(wVarB)) {
                return new c(tVar, iVar, dVar, aaVar, aVar, yVar);
            }
        }
        return new c(tVar, iVar, dVar, aaVar, aVar, w);
    }

    static Bitmap a(List<ac> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            final ac acVar = list.get(i);
            try {
                Bitmap bitmapA = acVar.a(bitmap);
                if (bitmapA == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(acVar.a());
                    sb.append(" returned null after ");
                    sb.append(i);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator<ac> it = list.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().a());
                        sb.append('\n');
                    }
                    t.f4151a.post(new Runnable() { // from class: com.squareup.picasso.c.4
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new NullPointerException(sb.toString());
                        }
                    });
                    return null;
                }
                if (bitmapA == bitmap && bitmap.isRecycled()) {
                    t.f4151a.post(new Runnable() { // from class: com.squareup.picasso.c.5
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new IllegalStateException("Transformation " + acVar.a() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                }
                if (bitmapA != bitmap && !bitmap.isRecycled()) {
                    t.f4151a.post(new Runnable() { // from class: com.squareup.picasso.c.6
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new IllegalStateException("Transformation " + acVar.a() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
                i++;
                bitmap = bitmapA;
            } catch (RuntimeException e) {
                t.f4151a.post(new Runnable() { // from class: com.squareup.picasso.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        throw new RuntimeException("Transformation " + acVar.a() + " crashed with exception.", e);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static android.graphics.Bitmap a(com.squareup.picasso.w r33, android.graphics.Bitmap r34, int r35) {
        /*
            Method dump skipped, instructions count: 710
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.c.a(com.squareup.picasso.w, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
