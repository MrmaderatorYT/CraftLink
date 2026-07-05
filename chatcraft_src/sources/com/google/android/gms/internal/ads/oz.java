package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
final class oz implements aav<List<at>, ao> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3337a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Integer f3338b;
    private final /* synthetic */ Integer c;
    private final /* synthetic */ int d;
    private final /* synthetic */ int e;
    private final /* synthetic */ int f;
    private final /* synthetic */ int g;
    private final /* synthetic */ boolean h;

    oz(ot otVar, String str, Integer num, Integer num2, int i, int i2, int i3, int i4, boolean z) {
        this.f3337a = str;
        this.f3338b = num;
        this.c = num2;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = z;
    }

    @Override // com.google.android.gms.internal.ads.aav
    public final /* synthetic */ ao a(List<at> list) {
        List<at> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        return new ao(this.f3337a, list2, this.f3338b, this.c, this.d > 0 ? Integer.valueOf(this.d) : null, this.e + this.f, this.g, this.h);
    }
}
