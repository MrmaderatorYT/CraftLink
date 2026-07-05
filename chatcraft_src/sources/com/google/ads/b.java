package com.google.ads;

import com.google.android.gms.ads.d;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@Deprecated
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1441a = new b(-1, -2, "mb");

    /* renamed from: b, reason: collision with root package name */
    public static final b f1442b = new b(ModuleDescriptor.MODULE_VERSION, 50, "mb");
    public static final b c = new b(300, 250, "as");
    public static final b d = new b(468, 60, "as");
    public static final b e = new b(728, 90, "as");
    public static final b f = new b(160, 600, "as");
    private final d g;

    public b(d dVar) {
        this.g = dVar;
    }

    private b(int i, int i2, String str) {
        this(new d(i, i2));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.g.equals(((b) obj).g);
        }
        return false;
    }

    public final int hashCode() {
        return this.g.hashCode();
    }

    public final int a() {
        return this.g.b();
    }

    public final int b() {
        return this.g.a();
    }

    public final String toString() {
        return this.g.toString();
    }
}
