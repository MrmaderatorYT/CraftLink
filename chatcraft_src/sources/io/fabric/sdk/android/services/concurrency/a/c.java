package io.fabric.sdk.android.services.concurrency.a;

/* compiled from: ExponentialBackoff.java */
/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final long f4264a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4265b;

    public c(long j, int i) {
        this.f4264a = j;
        this.f4265b = i;
    }

    @Override // io.fabric.sdk.android.services.concurrency.a.a
    public long a(int i) {
        double d = this.f4264a;
        double dPow = Math.pow(this.f4265b, i);
        Double.isNaN(d);
        return (long) (d * dPow);
    }
}
