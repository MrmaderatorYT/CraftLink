package com.google.android.gms.common.a;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.b;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f1685b;
    private final List<String> d = Collections.EMPTY_LIST;
    private final List<String> e = Collections.EMPTY_LIST;
    private final List<String> f = Collections.EMPTY_LIST;
    private final List<String> g = Collections.EMPTY_LIST;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1684a = new Object();
    private static boolean c = false;

    public static a a() {
        if (f1685b == null) {
            synchronized (f1684a) {
                if (f1685b == null) {
                    f1685b = new a();
                }
            }
        }
        return f1685b;
    }

    private a() {
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : b.a(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        return context.bindService(intent, serviceConnection, i);
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }
}
