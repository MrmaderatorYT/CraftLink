package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class jy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ jw f3217a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ jx f3218b;

    jy(jx jxVar, jw jwVar) {
        this.f3218b = jxVar;
        this.f3217a = jwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f3218b.i) {
            if (this.f3218b.s != -2) {
                return;
            }
            this.f3218b.r = this.f3218b.d();
            if (this.f3218b.r == null) {
                this.f3218b.a(4);
                return;
            }
            if (!this.f3218b.e() || this.f3218b.b(1)) {
                this.f3217a.a(this.f3218b);
                this.f3218b.a(this.f3217a);
                return;
            }
            String str = this.f3218b.f3215a;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
            sb.append("Ignoring adapter ");
            sb.append(str);
            sb.append(" as delayed impression is not supported");
            xe.e(sb.toString());
            this.f3218b.a(2);
        }
    }
}
