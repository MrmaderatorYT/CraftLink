package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
public final class bho {

    /* renamed from: a, reason: collision with root package name */
    public final long f2677a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2678b;
    public final long c;
    public final long d;
    public final long e;
    public final big f;
    public final Uri g;
    private final long h;
    private final long i;
    private final List<bhs> j;

    public bho(long j, long j2, long j3, boolean z, long j4, long j5, long j6, big bigVar, Uri uri, List<bhs> list) {
        this.f2677a = j;
        this.h = j2;
        this.i = j3;
        this.f2678b = z;
        this.c = j4;
        this.d = j5;
        this.e = j6;
        this.f = bigVar;
        this.g = uri;
        this.j = list;
    }

    public final int a() {
        return this.j.size();
    }

    public final bhs a(int i) {
        return this.j.get(i);
    }

    public final long b(int i) {
        long j;
        if (i == this.j.size() - 1) {
            j = this.h == -9223372036854775807L ? -9223372036854775807L : this.h - this.j.get(i).f2686b;
        } else {
            j = this.j.get(i + 1).f2686b - this.j.get(i).f2686b;
        }
        return azo.b(j);
    }
}
