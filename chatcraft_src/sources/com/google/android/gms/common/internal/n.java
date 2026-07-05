package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.d;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
final class n extends d implements Handler.Callback {

    /* renamed from: b, reason: collision with root package name */
    private final Context f1737b;
    private final Handler c;

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("mConnectionStatus")
    private final HashMap<d.a, o> f1736a = new HashMap<>();
    private final com.google.android.gms.common.a.a d = com.google.android.gms.common.a.a.a();
    private final long e = 5000;
    private final long f = 300000;

    n(Context context) {
        this.f1737b = context.getApplicationContext();
        this.c = new com.google.android.gms.internal.b.e(context.getMainLooper(), this);
    }

    @Override // com.google.android.gms.common.internal.d
    protected final boolean a(d.a aVar, ServiceConnection serviceConnection, String str) {
        boolean zA;
        i.a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1736a) {
            o oVar = this.f1736a.get(aVar);
            if (oVar == null) {
                oVar = new o(this, aVar);
                oVar.a(serviceConnection, str);
                oVar.a(str);
                this.f1736a.put(aVar, oVar);
            } else {
                this.c.removeMessages(0, aVar);
                if (oVar.a(serviceConnection)) {
                    String strValueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(strValueOf);
                    throw new IllegalStateException(sb.toString());
                }
                oVar.a(serviceConnection, str);
                switch (oVar.b()) {
                    case 1:
                        serviceConnection.onServiceConnected(oVar.e(), oVar.d());
                        break;
                    case 2:
                        oVar.a(str);
                        break;
                }
            }
            zA = oVar.a();
        }
        return zA;
    }

    @Override // com.google.android.gms.common.internal.d
    protected final void b(d.a aVar, ServiceConnection serviceConnection, String str) {
        i.a(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1736a) {
            o oVar = this.f1736a.get(aVar);
            if (oVar == null) {
                String strValueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(strValueOf);
                throw new IllegalStateException(sb.toString());
            }
            if (!oVar.a(serviceConnection)) {
                String strValueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(strValueOf2);
                throw new IllegalStateException(sb2.toString());
            }
            oVar.b(serviceConnection, str);
            if (oVar.c()) {
                this.c.sendMessageDelayed(this.c.obtainMessage(0, aVar), this.e);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                synchronized (this.f1736a) {
                    d.a aVar = (d.a) message.obj;
                    o oVar = this.f1736a.get(aVar);
                    if (oVar != null && oVar.c()) {
                        if (oVar.a()) {
                            oVar.b("GmsClientSupervisor");
                        }
                        this.f1736a.remove(aVar);
                    }
                }
                return true;
            case 1:
                synchronized (this.f1736a) {
                    d.a aVar2 = (d.a) message.obj;
                    o oVar2 = this.f1736a.get(aVar2);
                    if (oVar2 != null && oVar2.b() == 3) {
                        String strValueOf = String.valueOf(aVar2);
                        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 47);
                        sb.append("Timeout waiting for ServiceConnection callback ");
                        sb.append(strValueOf);
                        Log.wtf("GmsClientSupervisor", sb.toString(), new Exception());
                        ComponentName componentNameE = oVar2.e();
                        if (componentNameE == null) {
                            componentNameE = aVar2.b();
                        }
                        if (componentNameE == null) {
                            componentNameE = new ComponentName(aVar2.a(), "unknown");
                        }
                        oVar2.onServiceDisconnected(componentNameE);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
