package androidx.core.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.a.a;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: NotificationManagerCompat.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    private static String f556b;
    private static c g;
    private final Context d;
    private final NotificationManager e;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f555a = new Object();
    private static Set<String> c = new HashSet();
    private static final Object f = new Object();

    /* compiled from: NotificationManagerCompat.java */
    private interface d {
        void a(android.support.v4.a.a aVar);
    }

    public static j a(Context context) {
        return new j(context);
    }

    private j(Context context) {
        this.d = context;
        this.e = (NotificationManager) this.d.getSystemService("notification");
    }

    public void a(int i, Notification notification) {
        a(null, i, notification);
    }

    public void a(String str, int i, Notification notification) {
        if (a(notification)) {
            a(new a(this.d.getPackageName(), i, str, notification));
            this.e.cancel(str, i);
        } else {
            this.e.notify(str, i, notification);
        }
    }

    public static Set<String> b(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f555a) {
            if (string != null) {
                try {
                    if (!string.equals(f556b)) {
                        String[] strArrSplit = string.split(":", -1);
                        HashSet hashSet = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        c = hashSet;
                        f556b = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            set = c;
        }
        return set;
    }

    private static boolean a(Notification notification) {
        Bundle bundleA = g.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    private void a(d dVar) {
        synchronized (f) {
            if (g == null) {
                g = new c(this.d.getApplicationContext());
            }
            g.a(dVar);
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    private static class c implements ServiceConnection, Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        private final Context f561a;
        private final Handler c;
        private final Map<ComponentName, a> d = new HashMap();
        private Set<String> e = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        private final HandlerThread f562b = new HandlerThread("NotificationManagerCompat");

        c(Context context) {
            this.f561a = context;
            this.f562b.start();
            this.c = new Handler(this.f562b.getLooper(), this);
        }

        public void a(d dVar) {
            this.c.obtainMessage(0, dVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    b((d) message.obj);
                    break;
                case 1:
                    b bVar = (b) message.obj;
                    a(bVar.f559a, bVar.f560b);
                    break;
                case 2:
                    a((ComponentName) message.obj);
                    break;
                case 3:
                    b((ComponentName) message.obj);
                    break;
            }
            return true;
        }

        private void b(d dVar) {
            a();
            for (a aVar : this.d.values()) {
                aVar.d.add(dVar);
                d(aVar);
            }
        }

        private void a(ComponentName componentName, IBinder iBinder) {
            a aVar = this.d.get(componentName);
            if (aVar != null) {
                aVar.c = a.AbstractBinderC0006a.a(iBinder);
                aVar.e = 0;
                d(aVar);
            }
        }

        private void a(ComponentName componentName) {
            a aVar = this.d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void b(ComponentName componentName) {
            a aVar = this.d.get(componentName);
            if (aVar != null) {
                d(aVar);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.c.obtainMessage(1, new b(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.c.obtainMessage(2, componentName).sendToTarget();
        }

        private void a() {
            Set<String> setB = j.b(this.f561a);
            if (setB.equals(this.e)) {
                return;
            }
            this.e = setB;
            List<ResolveInfo> listQueryIntentServices = this.f561a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setB.contains(resolveInfo.serviceInfo.packageName)) {
                    ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        private boolean a(a aVar) {
            if (aVar.f564b) {
                return true;
            }
            aVar.f564b = this.f561a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f563a), this, 33);
            if (aVar.f564b) {
                aVar.e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f563a);
                this.f561a.unbindService(this);
            }
            return aVar.f564b;
        }

        private void b(a aVar) {
            if (aVar.f564b) {
                this.f561a.unbindService(this);
                aVar.f564b = false;
            }
            aVar.c = null;
        }

        private void c(a aVar) {
            if (this.c.hasMessages(3, aVar.f563a)) {
                return;
            }
            aVar.e++;
            if (aVar.e > 6) {
                Log.w("NotifManCompat", "Giving up on delivering " + aVar.d.size() + " tasks to " + aVar.f563a + " after " + aVar.e + " retries");
                aVar.d.clear();
                return;
            }
            int i = (1 << (aVar.e - 1)) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i + " ms");
            }
            this.c.sendMessageDelayed(this.c.obtainMessage(3, aVar.f563a), i);
        }

        private void d(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f563a + ", " + aVar.d.size() + " queued tasks");
            }
            if (aVar.d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.c == null) {
                c(aVar);
                return;
            }
            while (true) {
                d dVarPeek = aVar.d.peek();
                if (dVarPeek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + dVarPeek);
                    }
                    dVarPeek.a(aVar.c);
                    aVar.d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f563a);
                    }
                } catch (RemoteException e) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f563a, e);
                }
            }
            if (aVar.d.isEmpty()) {
                return;
            }
            c(aVar);
        }

        /* compiled from: NotificationManagerCompat.java */
        private static class a {

            /* renamed from: a, reason: collision with root package name */
            final ComponentName f563a;
            android.support.v4.a.a c;

            /* renamed from: b, reason: collision with root package name */
            boolean f564b = false;
            ArrayDeque<d> d = new ArrayDeque<>();
            int e = 0;

            a(ComponentName componentName) {
                this.f563a = componentName;
            }
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f559a;

        /* renamed from: b, reason: collision with root package name */
        final IBinder f560b;

        b(ComponentName componentName, IBinder iBinder) {
            this.f559a = componentName;
            this.f560b = iBinder;
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    private static class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final String f557a;

        /* renamed from: b, reason: collision with root package name */
        final int f558b;
        final String c;
        final Notification d;

        a(String str, int i, String str2, Notification notification) {
            this.f557a = str;
            this.f558b = i;
            this.c = str2;
            this.d = notification;
        }

        @Override // androidx.core.app.j.d
        public void a(android.support.v4.a.a aVar) {
            aVar.a(this.f557a, this.f558b, this.c, this.d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f557a + ", id:" + this.f558b + ", tag:" + this.c + "]";
        }
    }
}
