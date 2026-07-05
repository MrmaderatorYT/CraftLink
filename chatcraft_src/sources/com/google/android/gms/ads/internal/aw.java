package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.bra;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
final class aw {

    /* renamed from: a, reason: collision with root package name */
    private final String f1532a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f1533b = new TreeMap();
    private String c;
    private String d;

    public aw(String str) {
        this.f1532a = str;
    }

    public final String a() {
        return this.d;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.f1532a;
    }

    public final Map<String, String> d() {
        return this.f1533b;
    }

    public final void a(bqj bqjVar, aar aarVar) {
        this.c = bqjVar.j.f3030a;
        Bundle bundle = bqjVar.m != null ? bqjVar.m.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle == null) {
            return;
        }
        String str = (String) bra.e().a(com.google.android.gms.internal.ads.o.bR);
        for (String str2 : bundle.keySet()) {
            if (str.equals(str2)) {
                this.d = bundle.getString(str2);
            } else if (str2.startsWith("csa_")) {
                this.f1533b.put(str2.substring(4), bundle.getString(str2));
            }
        }
        this.f1533b.put("SDKVersion", aarVar.f1790a);
    }
}
