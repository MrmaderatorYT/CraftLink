package androidx.browser.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.a.b;

/* compiled from: CustomTabsServiceConnection.java */
/* loaded from: classes.dex */
public abstract class d implements ServiceConnection {
    public abstract void a(ComponentName componentName, b bVar);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a(componentName, new b(b.a.a(iBinder), componentName) { // from class: androidx.browser.a.d.1
        });
    }
}
