package com.crashlytics.android.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DevicePowerStateListener.java */
/* loaded from: classes.dex */
class w {

    /* renamed from: a, reason: collision with root package name */
    private static final IntentFilter f1429a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: b, reason: collision with root package name */
    private static final IntentFilter f1430b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    private final Context e;
    private boolean h;
    private final BroadcastReceiver g = new BroadcastReceiver() { // from class: com.crashlytics.android.c.w.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            w.this.h = true;
        }
    };
    private final BroadcastReceiver f = new BroadcastReceiver() { // from class: com.crashlytics.android.c.w.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            w.this.h = false;
        }
    };
    private final AtomicBoolean d = new AtomicBoolean(false);

    public w(Context context) {
        this.e = context;
    }

    public void a() {
        boolean z = true;
        if (this.d.getAndSet(true)) {
            return;
        }
        Intent intentRegisterReceiver = this.e.registerReceiver(null, f1429a);
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
        if (intExtra != 2 && intExtra != 5) {
            z = false;
        }
        this.h = z;
        this.e.registerReceiver(this.g, f1430b);
        this.e.registerReceiver(this.f, c);
    }

    public boolean b() {
        return this.h;
    }

    public void c() {
        if (this.d.getAndSet(false)) {
            this.e.unregisterReceiver(this.g);
            this.e.unregisterReceiver(this.f);
        }
    }
}
