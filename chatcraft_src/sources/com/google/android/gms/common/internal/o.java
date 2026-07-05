package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class o implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Set<ServiceConnection> f1738a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private int f1739b = 2;
    private boolean c;
    private IBinder d;
    private final d.a e;
    private ComponentName f;
    private final /* synthetic */ n g;

    public o(n nVar, d.a aVar) {
        this.g = nVar;
        this.e = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.f1736a) {
            this.g.c.removeMessages(1, this.e);
            this.d = iBinder;
            this.f = componentName;
            Iterator<ServiceConnection> it = this.f1738a.iterator();
            while (it.hasNext()) {
                it.next().onServiceConnected(componentName, iBinder);
            }
            this.f1739b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.f1736a) {
            this.g.c.removeMessages(1, this.e);
            this.d = null;
            this.f = componentName;
            Iterator<ServiceConnection> it = this.f1738a.iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected(componentName);
            }
            this.f1739b = 2;
        }
    }

    public final void a(String str) {
        this.f1739b = 3;
        this.c = this.g.d.a(this.g.f1737b, str, this.e.a(this.g.f1737b), this, this.e.c());
        if (!this.c) {
            this.f1739b = 2;
            try {
                this.g.d.a(this.g.f1737b, this);
            } catch (IllegalArgumentException unused) {
            }
        } else {
            this.g.c.sendMessageDelayed(this.g.c.obtainMessage(1, this.e), this.g.f);
        }
    }

    public final void b(String str) {
        this.g.c.removeMessages(1, this.e);
        this.g.d.a(this.g.f1737b, this);
        this.c = false;
        this.f1739b = 2;
    }

    public final void a(ServiceConnection serviceConnection, String str) {
        com.google.android.gms.common.a.a unused = this.g.d;
        Context unused2 = this.g.f1737b;
        this.e.a(this.g.f1737b);
        this.f1738a.add(serviceConnection);
    }

    public final void b(ServiceConnection serviceConnection, String str) {
        com.google.android.gms.common.a.a unused = this.g.d;
        Context unused2 = this.g.f1737b;
        this.f1738a.remove(serviceConnection);
    }

    public final boolean a() {
        return this.c;
    }

    public final int b() {
        return this.f1739b;
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.f1738a.contains(serviceConnection);
    }

    public final boolean c() {
        return this.f1738a.isEmpty();
    }

    public final IBinder d() {
        return this.d;
    }

    public final ComponentName e() {
        return this.f;
    }
}
