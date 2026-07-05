package io.netty.channel;

import io.netty.channel.ap;

/* compiled from: DefaultMessageSizeEstimator.java */
/* loaded from: classes.dex */
public final class ah implements ap {

    /* renamed from: a, reason: collision with root package name */
    public static final ap f4477a = new ah(8);

    /* renamed from: b, reason: collision with root package name */
    private final ap.a f4478b;

    /* compiled from: DefaultMessageSizeEstimator.java */
    private static final class a implements ap.a {

        /* renamed from: a, reason: collision with root package name */
        private final int f4479a;

        private a(int i) {
            this.f4479a = i;
        }

        @Override // io.netty.channel.ap.a
        public int a(Object obj) {
            if (obj instanceof io.netty.b.i) {
                return ((io.netty.b.i) obj).g();
            }
            if (obj instanceof io.netty.b.k) {
                return ((io.netty.b.k) obj).a().g();
            }
            if (obj instanceof an) {
                return 0;
            }
            return this.f4479a;
        }
    }

    public ah(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("unknownSize: " + i + " (expected: >= 0)");
        }
        this.f4478b = new a(i);
    }

    @Override // io.netty.channel.ap
    public ap.a a() {
        return this.f4478b;
    }
}
