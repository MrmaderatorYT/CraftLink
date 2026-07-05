package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ox {

    /* renamed from: a, reason: collision with root package name */
    private final int f3333a;

    /* renamed from: b, reason: collision with root package name */
    private final List<bfd> f3334b;
    private final int c;
    private final InputStream d;

    public ox(int i, List<bfd> list) {
        this(i, list, -1, null);
    }

    public ox(int i, List<bfd> list, int i2, InputStream inputStream) {
        this.f3333a = i;
        this.f3334b = list;
        this.c = i2;
        this.d = inputStream;
    }

    public final int a() {
        return this.f3333a;
    }

    public final List<bfd> b() {
        return Collections.unmodifiableList(this.f3334b);
    }

    public final int c() {
        return this.c;
    }

    public final InputStream d() {
        return this.d;
    }
}
