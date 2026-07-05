package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class wk {
    public final String A;
    public final String B;
    public final bh C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public final List<String> J;
    public final bos K;
    public final boolean L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    public final boolean P;
    private final ro Q;
    private final long R;
    private final long S;
    private final String T;

    /* renamed from: a, reason: collision with root package name */
    public final bqj f3543a;

    /* renamed from: b, reason: collision with root package name */
    public final afu f3544b;
    public final List<String> c;
    public final int d;
    public final List<String> e;
    public final List<String> f;
    public final List<String> g;
    public final int h;
    public final long i;
    public final String j;
    public final JSONObject k;
    public final boolean l;
    public boolean m;
    public final boolean n;
    public final jt o;
    public final kn p;
    public final String q;
    public final ju r;
    public final jw s;
    public final String t;
    public final bqn u;
    public final vh v;
    public final List<String> w;
    public final List<String> x;
    public final long y;
    public final long z;

    public wk(bqj bqjVar, afu afuVar, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, jt jtVar, kn knVar, String str2, ju juVar, jw jwVar, long j2, bqn bqnVar, long j3, long j4, long j5, String str3, JSONObject jSONObject, bh bhVar, vh vhVar, List<String> list4, List<String> list5, boolean z2, ro roVar, String str4, List<String> list6, String str5, bos bosVar, boolean z3, boolean z4, boolean z5, List<String> list7, boolean z6, String str6, boolean z7) {
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.f3543a = bqjVar;
        this.f3544b = afuVar;
        this.c = a(list);
        this.d = i;
        this.e = a(list2);
        this.g = a(list3);
        this.h = i2;
        this.i = j;
        this.j = str;
        this.n = z;
        this.o = jtVar;
        this.p = knVar;
        this.q = str2;
        this.r = juVar;
        this.s = jwVar;
        this.R = j2;
        this.u = bqnVar;
        this.S = j3;
        this.y = j4;
        this.z = j5;
        this.A = str3;
        this.k = jSONObject;
        this.C = bhVar;
        this.v = vhVar;
        this.w = a(list4);
        this.x = a(list5);
        this.l = z2;
        this.Q = roVar;
        this.t = str4;
        this.J = a(list6);
        this.B = str5;
        this.K = bosVar;
        this.L = z3;
        this.M = z4;
        this.N = z5;
        this.f = a(list7);
        this.O = z6;
        this.T = str6;
        this.P = z7;
    }

    public wk(wl wlVar, afu afuVar, jt jtVar, kn knVar, String str, jw jwVar, bh bhVar, String str2) {
        this(wlVar.f3545a.c, null, wlVar.f3546b.c, wlVar.e, wlVar.f3546b.e, wlVar.f3546b.i, wlVar.f3546b.k, wlVar.f3546b.j, wlVar.f3545a.i, wlVar.f3546b.g, null, null, null, wlVar.c, null, wlVar.f3546b.h, wlVar.d, wlVar.f3546b.f, wlVar.f, wlVar.g, wlVar.f3546b.n, wlVar.h, null, wlVar.f3546b.A, wlVar.f3546b.B, wlVar.f3546b.B, wlVar.f3546b.D, wlVar.f3546b.E, null, wlVar.f3546b.H, wlVar.f3546b.L, wlVar.i, wlVar.f3546b.O, wlVar.j, wlVar.f3546b.Q, wlVar.f3546b.R, wlVar.f3546b.S, wlVar.f3546b.T, wlVar.f3546b.V);
    }

    public final boolean a() {
        if (this.f3544b == null || this.f3544b.w() == null) {
            return false;
        }
        return this.f3544b.w().b();
    }

    private static <T> List<T> a(List<T> list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }
}
