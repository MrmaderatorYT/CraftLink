package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1725a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static d f1726b;

    protected abstract boolean a(a aVar, ServiceConnection serviceConnection, String str);

    protected abstract void b(a aVar, ServiceConnection serviceConnection, String str);

    public static d a(Context context) {
        synchronized (f1725a) {
            if (f1726b == null) {
                f1726b = new n(context.getApplicationContext());
            }
        }
        return f1726b;
    }

    protected static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f1727a;

        /* renamed from: b, reason: collision with root package name */
        private final String f1728b;
        private final ComponentName c = null;
        private final int d;

        public a(String str, String str2, int i) {
            this.f1727a = i.a(str);
            this.f1728b = i.a(str2);
            this.d = i;
        }

        public final String toString() {
            return this.f1727a == null ? this.c.flattenToString() : this.f1727a;
        }

        public final String a() {
            return this.f1728b;
        }

        public final ComponentName b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public final Intent a(Context context) {
            if (this.f1727a != null) {
                return new Intent(this.f1727a).setPackage(this.f1728b);
            }
            return new Intent().setComponent(this.c);
        }

        public final int hashCode() {
            return h.a(this.f1727a, this.f1728b, this.c, Integer.valueOf(this.d));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return h.a(this.f1727a, aVar.f1727a) && h.a(this.f1728b, aVar.f1728b) && h.a(this.c, aVar.c) && this.d == aVar.d;
        }
    }

    public final void a(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        b(new a(str, str2, i), serviceConnection, str3);
    }
}
