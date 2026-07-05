package io.fabric.sdk.android.services.concurrency.a;

/* compiled from: RetryState.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final int f4272a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4273b;
    private final d c;

    public e(a aVar, d dVar) {
        this(0, aVar, dVar);
    }

    public e(int i, a aVar, d dVar) {
        this.f4272a = i;
        this.f4273b = aVar;
        this.c = dVar;
    }

    public long a() {
        return this.f4273b.a(this.f4272a);
    }

    public e b() {
        return new e(this.f4272a + 1, this.f4273b, this.c);
    }

    public e c() {
        return new e(this.f4273b, this.c);
    }
}
