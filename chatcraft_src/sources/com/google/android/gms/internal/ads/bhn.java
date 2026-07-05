package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class bhn {

    /* renamed from: a, reason: collision with root package name */
    public final int f2675a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2676b;
    public final List<bhu> c;
    public final List<bhr> d;
    public final List<bhr> e;

    public bhn(int i, int i2, List<bhu> list, List<bhr> list2, List<bhr> list3) {
        this.f2675a = i;
        this.f2676b = i2;
        this.c = Collections.unmodifiableList(list);
        this.d = Collections.unmodifiableList(list2);
        this.e = Collections.unmodifiableList(list3);
    }
}
