package com.google.android.gms.internal.ads;

@qj
/* loaded from: classes.dex */
public class brc extends com.google.android.gms.ads.a {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3001a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private com.google.android.gms.ads.a f3002b;

    public final void a(com.google.android.gms.ads.a aVar) {
        synchronized (this.f3001a) {
            this.f3002b = aVar;
        }
    }

    @Override // com.google.android.gms.ads.a
    public void c() {
        synchronized (this.f3001a) {
            if (this.f3002b != null) {
                this.f3002b.c();
            }
        }
    }

    @Override // com.google.android.gms.ads.a
    public void a(int i) {
        synchronized (this.f3001a) {
            if (this.f3002b != null) {
                this.f3002b.a(i);
            }
        }
    }

    @Override // com.google.android.gms.ads.a
    public void d() {
        synchronized (this.f3001a) {
            if (this.f3002b != null) {
                this.f3002b.d();
            }
        }
    }

    @Override // com.google.android.gms.ads.a
    public void b() {
        synchronized (this.f3001a) {
            if (this.f3002b != null) {
                this.f3002b.b();
            }
        }
    }

    @Override // com.google.android.gms.ads.a
    public void a() {
        synchronized (this.f3001a) {
            if (this.f3002b != null) {
                this.f3002b.a();
            }
        }
    }
}
