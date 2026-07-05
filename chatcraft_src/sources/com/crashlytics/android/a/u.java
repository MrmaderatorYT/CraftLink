package com.crashlytics.android.a;

import java.util.Random;

/* compiled from: RandomBackoff.java */
/* loaded from: classes.dex */
class u implements io.fabric.sdk.android.services.concurrency.a.a {

    /* renamed from: a, reason: collision with root package name */
    final io.fabric.sdk.android.services.concurrency.a.a f1284a;

    /* renamed from: b, reason: collision with root package name */
    final Random f1285b;
    final double c;

    public u(io.fabric.sdk.android.services.concurrency.a.a aVar, double d) {
        this(aVar, d, new Random());
    }

    public u(io.fabric.sdk.android.services.concurrency.a.a aVar, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        if (aVar == null) {
            throw new NullPointerException("backoff must not be null");
        }
        if (random == null) {
            throw new NullPointerException("random must not be null");
        }
        this.f1284a = aVar;
        this.c = d;
        this.f1285b = random;
    }

    @Override // io.fabric.sdk.android.services.concurrency.a.a
    public long a(int i) {
        double dA = a();
        double dA2 = this.f1284a.a(i);
        Double.isNaN(dA2);
        return (long) (dA * dA2);
    }

    double a() {
        double d = 1.0d - this.c;
        return d + (((this.c + 1.0d) - d) * this.f1285b.nextDouble());
    }
}
