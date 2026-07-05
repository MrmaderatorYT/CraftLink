package com.squareup.picasso;

/* compiled from: MemoryPolicy.java */
/* loaded from: classes.dex */
public enum p {
    NO_CACHE(1),
    NO_STORE(2);

    final int c;

    static boolean a(int i) {
        return (i & NO_CACHE.c) == 0;
    }

    static boolean b(int i) {
        return (i & NO_STORE.c) == 0;
    }

    p(int i) {
        this.c = i;
    }
}
