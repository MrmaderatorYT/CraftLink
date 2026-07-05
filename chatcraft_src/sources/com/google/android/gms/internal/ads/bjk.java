package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.bjl;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
final class bjk<T extends bjl> extends Handler implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final int f2737a;

    /* renamed from: b, reason: collision with root package name */
    private final T f2738b;
    private final bjj<T> c;
    private final long d;
    private IOException e;
    private int f;
    private volatile Thread g;
    private volatile boolean h;
    private final /* synthetic */ bji i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bjk(bji bjiVar, Looper looper, T t, bjj<T> bjjVar, int i, long j) {
        super(looper);
        this.i = bjiVar;
        this.f2738b = t;
        this.c = bjjVar;
        this.f2737a = i;
        this.d = j;
    }

    public final void a(int i) {
        if (this.e != null && this.f > i) {
            throw this.e;
        }
    }

    public final void a(long j) {
        bjq.b(this.i.f2736b == null);
        this.i.f2736b = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            a();
        }
    }

    public final void a(boolean z) {
        this.h = z;
        this.e = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.f2738b.a();
            if (this.g != null) {
                this.g.interrupt();
            }
        }
        if (z) {
            b();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.c.a((bjj<T>) this.f2738b, jElapsedRealtime, jElapsedRealtime - this.d, true);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.g = Thread.currentThread();
            if (!this.f2738b.b()) {
                String strValueOf = String.valueOf(this.f2738b.getClass().getSimpleName());
                bke.a(strValueOf.length() != 0 ? "load:".concat(strValueOf) : new String("load:"));
                try {
                    this.f2738b.c();
                    bke.a();
                } catch (Throwable th) {
                    bke.a();
                    throw th;
                }
            }
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.h) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (Error e2) {
            Log.e("LoadTask", "Unexpected error loading stream", e2);
            if (!this.h) {
                obtainMessage(4, e2).sendToTarget();
            }
            throw e2;
        } catch (InterruptedException unused) {
            bjq.b(this.f2738b.b());
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (Exception e3) {
            Log.e("LoadTask", "Unexpected exception loading stream", e3);
            if (this.h) {
                return;
            }
            obtainMessage(3, new zzpj(e3)).sendToTarget();
        } catch (OutOfMemoryError e4) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e4);
            if (this.h) {
                return;
            }
            obtainMessage(3, new zzpj(e4)).sendToTarget();
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.h) {
            return;
        }
        if (message.what == 0) {
            a();
            return;
        }
        if (message.what == 4) {
            throw ((Error) message.obj);
        }
        b();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.d;
        if (this.f2738b.b()) {
            this.c.a((bjj<T>) this.f2738b, jElapsedRealtime, j, false);
            return;
        }
        switch (message.what) {
            case 1:
                this.c.a((bjj<T>) this.f2738b, jElapsedRealtime, j, false);
                return;
            case 2:
                this.c.a(this.f2738b, jElapsedRealtime, j);
                return;
            case 3:
                this.e = (IOException) message.obj;
                int iA = this.c.a((bjj<T>) this.f2738b, jElapsedRealtime, j, this.e);
                if (iA == 3) {
                    this.i.c = this.e;
                    return;
                } else {
                    if (iA != 2) {
                        this.f = iA == 1 ? 1 : this.f + 1;
                        a(Math.min((this.f - 1) * 1000, 5000));
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    private final void a() {
        this.e = null;
        this.i.f2735a.execute(this.i.f2736b);
    }

    private final void b() {
        this.i.f2736b = null;
    }
}
