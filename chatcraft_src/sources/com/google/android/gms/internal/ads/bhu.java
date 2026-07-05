package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class bhu {

    /* renamed from: a, reason: collision with root package name */
    public final bab f2689a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2690b;
    public final long c;
    public final List<bhr> d;
    private final String e;
    private final long f;
    private final bht g;

    private bhu(String str, long j, bab babVar, String str2, bhy bhyVar, List<bhr> list) {
        this.e = str;
        this.f = j;
        this.f2689a = babVar;
        this.f2690b = str2;
        this.d = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.g = bhyVar.a(this);
        this.c = bkg.a(bhyVar.c, 1000000L, bhyVar.f2692b);
    }

    public abstract bht d();

    public abstract bhi e();

    public abstract String f();

    public final bht c() {
        return this.g;
    }
}
