package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager.java */
/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f3864a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f3865b = new Object();
    private final Handler c = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.a((C0086b) message.obj);
            return true;
        }
    });
    private C0086b d;
    private C0086b e;

    /* compiled from: SnackbarManager.java */
    interface a {
        void a();

        void a(int i);
    }

    static b a() {
        if (f3864a == null) {
            f3864a = new b();
        }
        return f3864a;
    }

    private b() {
    }

    public void a(int i, a aVar) {
        synchronized (this.f3865b) {
            if (f(aVar)) {
                this.d.f3868b = i;
                this.c.removeCallbacksAndMessages(this.d);
                b(this.d);
                return;
            }
            if (g(aVar)) {
                this.e.f3868b = i;
            } else {
                this.e = new C0086b(i, aVar);
            }
            if (this.d == null || !a(this.d, 4)) {
                this.d = null;
                b();
            }
        }
    }

    public void a(a aVar, int i) {
        synchronized (this.f3865b) {
            if (f(aVar)) {
                a(this.d, i);
            } else if (g(aVar)) {
                a(this.e, i);
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.f3865b) {
            if (f(aVar)) {
                this.d = null;
                if (this.e != null) {
                    b();
                }
            }
        }
    }

    public void b(a aVar) {
        synchronized (this.f3865b) {
            if (f(aVar)) {
                b(this.d);
            }
        }
    }

    public void c(a aVar) {
        synchronized (this.f3865b) {
            if (f(aVar) && !this.d.c) {
                this.d.c = true;
                this.c.removeCallbacksAndMessages(this.d);
            }
        }
    }

    public void d(a aVar) {
        synchronized (this.f3865b) {
            if (f(aVar) && this.d.c) {
                this.d.c = false;
                b(this.d);
            }
        }
    }

    public boolean e(a aVar) {
        boolean z;
        synchronized (this.f3865b) {
            z = f(aVar) || g(aVar);
        }
        return z;
    }

    /* compiled from: SnackbarManager.java */
    /* renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    private static class C0086b {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<a> f3867a;

        /* renamed from: b, reason: collision with root package name */
        int f3868b;
        boolean c;

        C0086b(int i, a aVar) {
            this.f3867a = new WeakReference<>(aVar);
            this.f3868b = i;
        }

        boolean a(a aVar) {
            return aVar != null && this.f3867a.get() == aVar;
        }
    }

    private void b() {
        if (this.e != null) {
            this.d = this.e;
            this.e = null;
            a aVar = this.d.f3867a.get();
            if (aVar != null) {
                aVar.a();
            } else {
                this.d = null;
            }
        }
    }

    private boolean a(C0086b c0086b, int i) {
        a aVar = c0086b.f3867a.get();
        if (aVar == null) {
            return false;
        }
        this.c.removeCallbacksAndMessages(c0086b);
        aVar.a(i);
        return true;
    }

    private boolean f(a aVar) {
        return this.d != null && this.d.a(aVar);
    }

    private boolean g(a aVar) {
        return this.e != null && this.e.a(aVar);
    }

    private void b(C0086b c0086b) {
        if (c0086b.f3868b == -2) {
            return;
        }
        int i = 2750;
        if (c0086b.f3868b > 0) {
            i = c0086b.f3868b;
        } else if (c0086b.f3868b == -1) {
            i = 1500;
        }
        this.c.removeCallbacksAndMessages(c0086b);
        this.c.sendMessageDelayed(Message.obtain(this.c, 0, c0086b), i);
    }

    void a(C0086b c0086b) {
        synchronized (this.f3865b) {
            if (this.d == c0086b || this.e == c0086b) {
                a(c0086b, 2);
            }
        }
    }
}
