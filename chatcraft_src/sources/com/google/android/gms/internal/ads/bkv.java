package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* loaded from: classes.dex */
final class bkv implements Handler.Callback, Choreographer.FrameCallback {

    /* renamed from: b, reason: collision with root package name */
    private static final bkv f2779b = new bkv();

    /* renamed from: a, reason: collision with root package name */
    public volatile long f2780a;
    private final Handler c;
    private final HandlerThread d = new HandlerThread("ChoreographerOwner:Handler");
    private Choreographer e;
    private int f;

    public static bkv a() {
        return f2779b;
    }

    private bkv() {
        this.d.start();
        this.c = new Handler(this.d.getLooper(), this);
        this.c.sendEmptyMessage(0);
    }

    public final void b() {
        this.c.sendEmptyMessage(1);
    }

    public final void c() {
        this.c.sendEmptyMessage(2);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.f2780a = j;
        this.e.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.e = Choreographer.getInstance();
                break;
            case 1:
                this.f++;
                if (this.f == 1) {
                    this.e.postFrameCallback(this);
                    break;
                }
                break;
            case 2:
                this.f--;
                if (this.f == 0) {
                    this.e.removeFrameCallback(this);
                    this.f2780a = 0L;
                    break;
                }
                break;
        }
        return true;
    }
}
