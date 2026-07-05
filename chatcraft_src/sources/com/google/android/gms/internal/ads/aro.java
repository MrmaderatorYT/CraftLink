package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
abstract class aro {

    /* renamed from: a, reason: collision with root package name */
    private static final aro f2209a;

    /* renamed from: b, reason: collision with root package name */
    private static final aro f2210b;

    private aro() {
    }

    abstract <L> List<L> a(Object obj, long j);

    abstract <L> void a(Object obj, Object obj2, long j);

    abstract void b(Object obj, long j);

    static aro a() {
        return f2209a;
    }

    static aro b() {
        return f2210b;
    }

    static {
        arp arpVar = null;
        f2209a = new arq();
        f2210b = new arr();
    }
}
