package io.netty.channel;

import io.netty.channel.ar;

/* compiled from: DefaultMaxMessagesRecvByteBufAllocator.java */
/* loaded from: classes.dex */
public abstract class ag implements ao {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f4474a;

    public ag() {
        this(1);
    }

    public ag(int i) {
        b(i);
    }

    @Override // io.netty.channel.ao
    public int c() {
        return this.f4474a;
    }

    @Override // io.netty.channel.ao
    public ao b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxMessagesPerRead: " + i + " (expected: > 0)");
        }
        this.f4474a = i;
        return this;
    }

    /* compiled from: DefaultMaxMessagesRecvByteBufAllocator.java */
    public abstract class a implements ar.a {

        /* renamed from: a, reason: collision with root package name */
        private e f4475a;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;

        @Override // io.netty.channel.ar.a
        public void b() {
        }

        public a() {
        }

        @Override // io.netty.channel.ar.a
        public void a(e eVar) {
            this.f4475a = eVar;
            this.c = ag.this.c();
            this.e = 0;
            this.d = 0;
        }

        @Override // io.netty.channel.ar.a
        public io.netty.b.i a(io.netty.b.j jVar) {
            return jVar.b(a());
        }

        @Override // io.netty.channel.ar.a
        public final void a(int i) {
            this.d += i;
        }

        @Override // io.netty.channel.ar.a
        public final void b(int i) {
            this.g = i;
            this.e += i;
            if (this.e < 0) {
                this.e = Integer.MAX_VALUE;
            }
        }

        @Override // io.netty.channel.ar.a
        public final int c() {
            return this.g;
        }

        @Override // io.netty.channel.ar.a
        public boolean d() {
            return this.f4475a.e() && this.f == this.g && this.d < this.c && this.e < Integer.MAX_VALUE;
        }

        @Override // io.netty.channel.ar.a
        public int e() {
            return this.f;
        }

        @Override // io.netty.channel.ar.a
        public void c(int i) {
            this.f = i;
        }

        protected final int f() {
            return this.e;
        }
    }
}
