package androidx.browser.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.a.a;
import android.text.TextUtils;

/* compiled from: CustomTabsClient.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final android.support.a.b f475a;

    /* renamed from: b, reason: collision with root package name */
    private final ComponentName f476b;

    b(android.support.a.b bVar, ComponentName componentName) {
        this.f475a = bVar;
        this.f476b = componentName;
    }

    public static boolean a(Context context, String str, d dVar) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, dVar, 33);
    }

    public boolean a(long j) {
        try {
            return this.f475a.a(j);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public e a(final a aVar) {
        a.AbstractBinderC0003a abstractBinderC0003a = new a.AbstractBinderC0003a() { // from class: androidx.browser.a.b.1
            private Handler c = new Handler(Looper.getMainLooper());

            @Override // android.support.a.a
            public void a(final int i, final Bundle bundle) {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.a.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(i, bundle);
                    }
                });
            }

            @Override // android.support.a.a
            public void a(final String str, final Bundle bundle) {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.a.b.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(str, bundle);
                    }
                });
            }

            @Override // android.support.a.a
            public void a(final Bundle bundle) {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.a.b.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(bundle);
                    }
                });
            }

            @Override // android.support.a.a
            public void b(final String str, final Bundle bundle) {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.a.b.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.b(str, bundle);
                    }
                });
            }

            @Override // android.support.a.a
            public void a(final int i, final Uri uri, final boolean z, final Bundle bundle) {
                if (aVar == null) {
                    return;
                }
                this.c.post(new Runnable() { // from class: androidx.browser.a.b.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(i, uri, z, bundle);
                    }
                });
            }
        };
        try {
            if (this.f475a.a(abstractBinderC0003a)) {
                return new e(this.f475a, abstractBinderC0003a, this.f476b);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }
}
