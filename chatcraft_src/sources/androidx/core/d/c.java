package androidx.core.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SelfDestructiveThread.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f585b;
    private Handler c;
    private final int f;
    private final int g;
    private final String h;

    /* renamed from: a, reason: collision with root package name */
    private final Object f584a = new Object();
    private Handler.Callback e = new Handler.Callback() { // from class: androidx.core.d.c.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    c.this.a();
                    break;
                case 1:
                    c.this.a((Runnable) message.obj);
                    break;
            }
            return true;
        }
    };
    private int d = 0;

    /* compiled from: SelfDestructiveThread.java */
    public interface a<T> {
        void a(T t);
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
    }

    private void b(Runnable runnable) {
        synchronized (this.f584a) {
            if (this.f585b == null) {
                this.f585b = new HandlerThread(this.h, this.g);
                this.f585b.start();
                this.c = new Handler(this.f585b.getLooper(), this.e);
                this.d++;
            }
            this.c.removeMessages(0);
            this.c.sendMessage(this.c.obtainMessage(1, runnable));
        }
    }

    public <T> void a(final Callable<T> callable, final a<T> aVar) {
        final Handler handler = new Handler();
        b(new Runnable() { // from class: androidx.core.d.c.2
            @Override // java.lang.Runnable
            public void run() throws Exception {
                final Object objCall;
                try {
                    objCall = callable.call();
                } catch (Exception unused) {
                    objCall = null;
                }
                handler.post(new Runnable() { // from class: androidx.core.d.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(objCall);
                    }
                });
            }
        });
    }

    public <T> T a(final Callable<T> callable, int i) throws InterruptedException {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition conditionNewCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        b(new Runnable() { // from class: androidx.core.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception unused) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    conditionNewCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }

    void a(Runnable runnable) {
        runnable.run();
        synchronized (this.f584a) {
            this.c.removeMessages(0);
            this.c.sendMessageDelayed(this.c.obtainMessage(0), this.f);
        }
    }

    void a() {
        synchronized (this.f584a) {
            if (this.c.hasMessages(1)) {
                return;
            }
            this.f585b.quit();
            this.f585b = null;
            this.c = null;
        }
    }
}
