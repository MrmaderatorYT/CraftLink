package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class zy {
    private boolean d;
    private Context e;
    private boolean c = false;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private final Map<BroadcastReceiver, IntentFilter> f3651b = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private final BroadcastReceiver f3650a = new zz(this);

    public final synchronized void a(Context context) {
        if (this.c) {
            return;
        }
        this.e = context.getApplicationContext();
        if (this.e == null) {
            this.e = context;
        }
        o.a(this.e);
        this.d = ((Boolean) bra.e().a(o.bD)).booleanValue();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.e.registerReceiver(this.f3650a, intentFilter);
        this.c = true;
    }

    public final synchronized void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.d) {
            this.f3651b.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void a(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.d) {
            this.f3651b.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void a(Context context, Intent intent) {
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.f3651b.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                entry.getKey().onReceive(context, intent);
            }
        }
    }
}
