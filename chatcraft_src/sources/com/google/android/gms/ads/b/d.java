package com.google.android.gms.ads.b;

import com.google.android.gms.internal.ads.qj;

@qj
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1470a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1471b;
    private final boolean c;
    private final int d;
    private final com.google.android.gms.ads.k e;
    private final boolean f;

    private d(a aVar) {
        this.f1470a = aVar.f1472a;
        this.f1471b = aVar.f1473b;
        this.c = aVar.c;
        this.d = aVar.e;
        this.e = aVar.d;
        this.f = aVar.f;
    }

    public static final class a {
        private com.google.android.gms.ads.k d;

        /* renamed from: a, reason: collision with root package name */
        private boolean f1472a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f1473b = -1;
        private boolean c = false;
        private int e = 1;
        private boolean f = false;

        public final a a(boolean z) {
            this.f1472a = z;
            return this;
        }

        public final a a(int i) {
            this.f1473b = i;
            return this;
        }

        public final a b(boolean z) {
            this.c = z;
            return this;
        }

        public final a b(int i) {
            this.e = i;
            return this;
        }

        public final a a(com.google.android.gms.ads.k kVar) {
            this.d = kVar;
            return this;
        }

        public final d a() {
            return new d(this);
        }
    }

    public final boolean a() {
        return this.f1470a;
    }

    public final int b() {
        return this.f1471b;
    }

    public final boolean c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final com.google.android.gms.ads.k e() {
        return this.e;
    }

    public final boolean f() {
        return this.f;
    }
}
