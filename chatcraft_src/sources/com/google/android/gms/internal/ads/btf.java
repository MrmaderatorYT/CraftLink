package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class btf {
    private Date g;
    private String h;
    private Location j;
    private String l;
    private String m;
    private boolean o;
    private String q;

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<String> f3012a = new HashSet<>();

    /* renamed from: b, reason: collision with root package name */
    private final Bundle f3013b = new Bundle();
    private final HashMap<Class<? extends Object>, Object> c = new HashMap<>();
    private final HashSet<String> d = new HashSet<>();
    private final Bundle e = new Bundle();
    private final HashSet<String> f = new HashSet<>();
    private int i = -1;
    private boolean k = false;
    private int n = -1;
    private int p = -1;

    public final void a(String str) {
        this.f3012a.add(str);
    }

    public final void a(Class<? extends com.google.android.gms.ads.mediation.b> cls, Bundle bundle) {
        this.f3013b.putBundle(cls.getName(), bundle);
    }

    public final void b(String str) {
        this.d.add(str);
    }

    public final void c(String str) {
        this.d.remove(str);
    }

    @Deprecated
    public final void a(Date date) {
        this.g = date;
    }

    @Deprecated
    public final void a(int i) {
        this.i = i;
    }

    public final void a(Location location) {
        this.j = location;
    }

    public final void a(boolean z) {
        this.n = z ? 1 : 0;
    }

    @Deprecated
    public final void b(boolean z) {
        this.o = z;
    }
}
