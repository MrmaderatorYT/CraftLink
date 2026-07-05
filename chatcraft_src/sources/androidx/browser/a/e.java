package androidx.browser.a;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

/* compiled from: CustomTabsSession.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f494a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final android.support.a.b f495b;
    private final android.support.a.a c;
    private final ComponentName d;

    e(android.support.a.b bVar, android.support.a.a aVar, ComponentName componentName) {
        this.f495b = bVar;
        this.c = aVar;
        this.d = componentName;
    }

    public boolean a(Uri uri, Bundle bundle, List<Bundle> list) {
        try {
            return this.f495b.a(this.c, uri, bundle, list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    IBinder a() {
        return this.c.asBinder();
    }

    ComponentName b() {
        return this.d;
    }
}
