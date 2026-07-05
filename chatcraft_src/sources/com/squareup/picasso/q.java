package com.squareup.picasso;

/* compiled from: NetworkPolicy.java */
/* loaded from: classes.dex */
public enum q {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);

    final int d;

    public static boolean a(int i) {
        return (i & NO_CACHE.d) == 0;
    }

    public static boolean b(int i) {
        return (i & NO_STORE.d) == 0;
    }

    public static boolean c(int i) {
        return (i & OFFLINE.d) != 0;
    }

    q(int i) {
        this.d = i;
    }
}
