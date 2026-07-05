package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: Stats.java */
/* loaded from: classes.dex */
class aa {

    /* renamed from: a, reason: collision with root package name */
    final HandlerThread f4102a = new HandlerThread("Picasso-Stats", 10);

    /* renamed from: b, reason: collision with root package name */
    final d f4103b;
    final Handler c;
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    aa(d dVar) {
        this.f4103b = dVar;
        this.f4102a.start();
        ad.a(this.f4102a.getLooper());
        this.c = new a(this.f4102a.getLooper(), this);
    }

    void a(Bitmap bitmap) {
        a(bitmap, 2);
    }

    void b(Bitmap bitmap) {
        a(bitmap, 3);
    }

    void a(long j) {
        this.c.sendMessage(this.c.obtainMessage(4, Long.valueOf(j)));
    }

    void a() {
        this.c.sendEmptyMessage(0);
    }

    void b() {
        this.c.sendEmptyMessage(1);
    }

    void c() {
        this.d++;
    }

    void d() {
        this.e++;
    }

    void a(Long l) {
        this.l++;
        this.f += l.longValue();
        this.i = a(this.l, this.f);
    }

    void b(long j) {
        this.m++;
        this.g += j;
        this.j = a(this.m, this.g);
    }

    void c(long j) {
        this.n++;
        this.h += j;
        this.k = a(this.m, this.h);
    }

    ab e() {
        return new ab(this.f4103b.b(), this.f4103b.a(), this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }

    private void a(Bitmap bitmap, int i) {
        this.c.sendMessage(this.c.obtainMessage(i, ad.a(bitmap), 0));
    }

    private static long a(int i, long j) {
        return j / i;
    }

    /* compiled from: Stats.java */
    private static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final aa f4104a;

        a(Looper looper, aa aaVar) {
            super(looper);
            this.f4104a = aaVar;
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            switch (message.what) {
                case 0:
                    this.f4104a.c();
                    break;
                case 1:
                    this.f4104a.d();
                    break;
                case 2:
                    this.f4104a.b(message.arg1);
                    break;
                case 3:
                    this.f4104a.c(message.arg1);
                    break;
                case 4:
                    this.f4104a.a((Long) message.obj);
                    break;
                default:
                    t.f4151a.post(new Runnable() { // from class: com.squareup.picasso.aa.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new AssertionError("Unhandled stats message." + message.what);
                        }
                    });
                    break;
            }
        }
    }
}
