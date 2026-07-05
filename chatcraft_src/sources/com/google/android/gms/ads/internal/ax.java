package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.internal.ads.abw;
import com.google.android.gms.internal.ads.acd;
import com.google.android.gms.internal.ads.aew;
import com.google.android.gms.internal.ads.aga;
import com.google.android.gms.internal.ads.bmx;
import com.google.android.gms.internal.ads.bnu;
import com.google.android.gms.internal.ads.bnv;
import com.google.android.gms.internal.ads.bor;
import com.google.android.gms.internal.ads.gn;
import com.google.android.gms.internal.ads.hg;
import com.google.android.gms.internal.ads.iy;
import com.google.android.gms.internal.ads.kc;
import com.google.android.gms.internal.ads.nj;
import com.google.android.gms.internal.ads.oi;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.qk;
import com.google.android.gms.internal.ads.td;
import com.google.android.gms.internal.ads.wa;
import com.google.android.gms.internal.ads.wp;
import com.google.android.gms.internal.ads.xn;
import com.google.android.gms.internal.ads.xv;
import com.google.android.gms.internal.ads.ya;
import com.google.android.gms.internal.ads.yb;
import com.google.android.gms.internal.ads.yc;
import com.google.android.gms.internal.ads.yd;
import com.google.android.gms.internal.ads.ye;
import com.google.android.gms.internal.ads.yf;
import com.google.android.gms.internal.ads.yh;
import com.google.android.gms.internal.ads.yq;
import com.google.android.gms.internal.ads.zo;
import com.google.android.gms.internal.ads.zp;
import com.google.android.gms.internal.ads.zy;

@qj
/* loaded from: classes.dex */
public final class ax {

    /* renamed from: a, reason: collision with root package name */
    private static ax f1534a = new ax();
    private final zp A;
    private final nj B;
    private final bor C;
    private final wa D;
    private final zy E;
    private final aew F;
    private final acd G;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.overlay.a f1535b;
    private final qk c;
    private final com.google.android.gms.ads.internal.overlay.l d;
    private final oi e;
    private final xn f;
    private final aga g;
    private final xv h;
    private final bmx i;
    private final wp j;
    private final yh k;
    private final bnu l;
    private final bnv m;
    private final com.google.android.gms.common.util.c n;
    private final e o;
    private final com.google.android.gms.internal.ads.t p;
    private final yq q;
    private final td r;
    private final hg s;
    private final abw t;
    private final gn u;
    private final iy v;
    private final zo w;
    private final com.google.android.gms.ads.internal.overlay.u x;
    private final com.google.android.gms.ads.internal.overlay.v y;
    private final kc z;

    protected ax() {
        com.google.android.gms.ads.internal.overlay.a aVar = new com.google.android.gms.ads.internal.overlay.a();
        qk qkVar = new qk();
        com.google.android.gms.ads.internal.overlay.l lVar = new com.google.android.gms.ads.internal.overlay.l();
        oi oiVar = new oi();
        xn xnVar = new xn();
        aga agaVar = new aga();
        int i = Build.VERSION.SDK_INT;
        this(aVar, qkVar, lVar, oiVar, xnVar, agaVar, i >= 21 ? new yf() : i >= 19 ? new ye() : i >= 18 ? new yc() : i >= 17 ? new yb() : i >= 16 ? new yd() : new ya(), new bmx(), new wp(), new yh(), new bnu(), new bnv(), com.google.android.gms.common.util.f.d(), new e(), new com.google.android.gms.internal.ads.t(), new yq(), new td(), new hg(), new abw(), new iy(), new zo(), new com.google.android.gms.ads.internal.overlay.u(), new com.google.android.gms.ads.internal.overlay.v(), new kc(), new zp(), new nj(), new bor(), new wa(), new zy(), new aew(), new acd());
    }

    private ax(com.google.android.gms.ads.internal.overlay.a aVar, qk qkVar, com.google.android.gms.ads.internal.overlay.l lVar, oi oiVar, xn xnVar, aga agaVar, xv xvVar, bmx bmxVar, wp wpVar, yh yhVar, bnu bnuVar, bnv bnvVar, com.google.android.gms.common.util.c cVar, e eVar, com.google.android.gms.internal.ads.t tVar, yq yqVar, td tdVar, hg hgVar, abw abwVar, iy iyVar, zo zoVar, com.google.android.gms.ads.internal.overlay.u uVar, com.google.android.gms.ads.internal.overlay.v vVar, kc kcVar, zp zpVar, nj njVar, bor borVar, wa waVar, zy zyVar, aew aewVar, acd acdVar) {
        this.f1535b = aVar;
        this.c = qkVar;
        this.d = lVar;
        this.e = oiVar;
        this.f = xnVar;
        this.g = agaVar;
        this.h = xvVar;
        this.i = bmxVar;
        this.j = wpVar;
        this.k = yhVar;
        this.l = bnuVar;
        this.m = bnvVar;
        this.n = cVar;
        this.o = eVar;
        this.p = tVar;
        this.q = yqVar;
        this.r = tdVar;
        this.s = hgVar;
        this.t = abwVar;
        this.u = new gn();
        this.v = iyVar;
        this.w = zoVar;
        this.x = uVar;
        this.y = vVar;
        this.z = kcVar;
        this.A = zpVar;
        this.B = njVar;
        this.C = borVar;
        this.D = waVar;
        this.E = zyVar;
        this.F = aewVar;
        this.G = acdVar;
    }

    public static qk a() {
        return f1534a.c;
    }

    public static com.google.android.gms.ads.internal.overlay.a b() {
        return f1534a.f1535b;
    }

    public static com.google.android.gms.ads.internal.overlay.l c() {
        return f1534a.d;
    }

    public static oi d() {
        return f1534a.e;
    }

    public static xn e() {
        return f1534a.f;
    }

    public static aga f() {
        return f1534a.g;
    }

    public static xv g() {
        return f1534a.h;
    }

    public static bmx h() {
        return f1534a.i;
    }

    public static wp i() {
        return f1534a.j;
    }

    public static yh j() {
        return f1534a.k;
    }

    public static bnv k() {
        return f1534a.m;
    }

    public static com.google.android.gms.common.util.c l() {
        return f1534a.n;
    }

    public static e m() {
        return f1534a.o;
    }

    public static com.google.android.gms.internal.ads.t n() {
        return f1534a.p;
    }

    public static yq o() {
        return f1534a.q;
    }

    public static td p() {
        return f1534a.r;
    }

    public static hg q() {
        return f1534a.s;
    }

    public static abw r() {
        return f1534a.t;
    }

    public static gn s() {
        return f1534a.u;
    }

    public static iy t() {
        return f1534a.v;
    }

    public static zo u() {
        return f1534a.w;
    }

    public static nj v() {
        return f1534a.B;
    }

    public static com.google.android.gms.ads.internal.overlay.u w() {
        return f1534a.x;
    }

    public static com.google.android.gms.ads.internal.overlay.v x() {
        return f1534a.y;
    }

    public static kc y() {
        return f1534a.z;
    }

    public static zp z() {
        return f1534a.A;
    }

    public static bor A() {
        return f1534a.C;
    }

    public static zy B() {
        return f1534a.E;
    }

    public static aew C() {
        return f1534a.F;
    }

    public static acd D() {
        return f1534a.G;
    }

    public static wa E() {
        return f1534a.D;
    }
}
