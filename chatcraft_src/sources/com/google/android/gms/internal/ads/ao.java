package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

@qj
/* loaded from: classes.dex */
public final class ao extends ca {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2106a = Color.rgb(12, 174, 206);

    /* renamed from: b, reason: collision with root package name */
    private static final int f2107b;
    private static final int c;
    private static final int d;
    private final String e;
    private final List<at> f = new ArrayList();
    private final List<cd> g = new ArrayList();
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final boolean m;

    public ao(String str, List<at> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.e = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                at atVar = list.get(i3);
                this.f.add(atVar);
                this.g.add(atVar);
            }
        }
        this.h = num != null ? num.intValue() : c;
        this.i = num2 != null ? num2.intValue() : d;
        this.j = num3 != null ? num3.intValue() : 12;
        this.k = i;
        this.l = i2;
        this.m = z;
    }

    @Override // com.google.android.gms.internal.ads.bz
    public final String a() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.bz
    public final List<cd> b() {
        return this.g;
    }

    public final List<at> c() {
        return this.f;
    }

    public final int d() {
        return this.h;
    }

    public final int e() {
        return this.i;
    }

    public final int f() {
        return this.j;
    }

    public final int g() {
        return this.k;
    }

    public final int h() {
        return this.l;
    }

    public final boolean i() {
        return this.m;
    }

    static {
        int iRgb = Color.rgb(204, 204, 204);
        f2107b = iRgb;
        c = iRgb;
        d = f2106a;
    }
}
