package com.google.android.gms.internal.ads;

import java.util.Random;

@qj
/* loaded from: classes.dex */
public final class bra {

    /* renamed from: a, reason: collision with root package name */
    private static bra f2998a = new bra();

    /* renamed from: b, reason: collision with root package name */
    private final aac f2999b;
    private final bqr c;
    private final String d;
    private final j e;
    private final k f;
    private final l g;
    private final aar h;
    private final Random i;

    protected bra() {
        this(new aac(), new bqr(new bqg(), new bqf(), new bto(), new ec(), new ui(), new vj(), new nl(), new ed()), new j(), new k(), new l(), aac.c(), new aar(0, 14300000, true), new Random());
    }

    private bra(aac aacVar, bqr bqrVar, j jVar, k kVar, l lVar, String str, aar aarVar, Random random) {
        this.f2999b = aacVar;
        this.c = bqrVar;
        this.e = jVar;
        this.f = kVar;
        this.g = lVar;
        this.d = str;
        this.h = aarVar;
        this.i = random;
    }

    public static aac a() {
        return f2998a.f2999b;
    }

    public static bqr b() {
        return f2998a.c;
    }

    public static k c() {
        return f2998a.f;
    }

    public static j d() {
        return f2998a.e;
    }

    public static l e() {
        return f2998a.g;
    }

    public static String f() {
        return f2998a.d;
    }

    public static aar g() {
        return f2998a.h;
    }

    public static Random h() {
        return f2998a.i;
    }
}
