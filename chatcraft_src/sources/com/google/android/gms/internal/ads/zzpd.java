package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzpd extends zzpc {

    /* renamed from: a, reason: collision with root package name */
    public final int f3678a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<String>> f3679b;

    public zzpd(int i, Map<String, List<String>> map, bjd bjdVar) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("Response code: ");
        sb.append(i);
        super(sb.toString(), bjdVar, 1);
        this.f3678a = i;
        this.f3679b = map;
    }
}
