package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class oo extends of {
    protected ka g;
    private kk h;
    private js i;
    private ju j;
    private final ac k;
    private final afu l;
    private boolean m;

    oo(Context context, wl wlVar, kk kkVar, oj ojVar, ac acVar, afu afuVar) {
        super(context, wlVar, ojVar);
        this.h = kkVar;
        this.j = wlVar.c;
        this.k = acVar;
        this.l = afuVar;
    }

    @Override // com.google.android.gms.internal.ads.of
    protected final wk a(int i) {
        String name;
        ju juVar;
        ro roVar;
        String str;
        boolean z;
        long j;
        String strSubstring;
        ju juVar2;
        Iterator<ka> it;
        String str2;
        boolean z2;
        long j2;
        int i2;
        ri riVar = this.e.f3545a;
        bqj bqjVar = riVar.c;
        afu afuVar = this.l;
        List<String> list = this.f.c;
        List<String> list2 = this.f.e;
        List<String> list3 = this.f.i;
        int i3 = this.f.k;
        long j3 = this.f.j;
        String str3 = riVar.i;
        boolean z3 = this.f.g;
        jt jtVar = this.g != null ? this.g.f3221b : null;
        kn knVar = this.g != null ? this.g.c : null;
        if (this.g != null) {
            name = this.g.d;
        } else {
            name = AdMobAdapter.class.getName();
        }
        String str4 = name;
        ju juVar3 = this.j;
        jw jwVar = this.g != null ? this.g.e : null;
        jt jtVar2 = jtVar;
        kn knVar2 = knVar;
        long j4 = this.f.h;
        bqn bqnVar = this.e.d;
        long j5 = this.f.f;
        long j6 = this.e.f;
        long j7 = this.f.m;
        String str5 = this.f.n;
        JSONObject jSONObject = this.e.h;
        vh vhVar = this.f.A;
        List<String> list4 = this.f.B;
        List<String> list5 = this.f.C;
        boolean z4 = this.j != null ? this.j.o : false;
        ro roVar2 = this.f.E;
        if (this.i != null) {
            List<ka> listB = this.i.b();
            if (listB == null) {
                juVar = juVar3;
                roVar = roVar2;
                strSubstring = BuildConfig.FLAVOR.toString();
                str = str3;
                z = z3;
                j = j7;
            } else {
                Iterator<ka> it2 = listB.iterator();
                String string = BuildConfig.FLAVOR;
                while (it2.hasNext()) {
                    ro roVar3 = roVar2;
                    ka next = it2.next();
                    if (next != null) {
                        it = it2;
                        if (next.f3221b == null || TextUtils.isEmpty(next.f3221b.d)) {
                            juVar2 = juVar3;
                        } else {
                            String strValueOf = String.valueOf(string);
                            j2 = j7;
                            String str6 = next.f3221b.d;
                            switch (next.f3220a) {
                                case -1:
                                    i2 = 4;
                                    juVar2 = juVar3;
                                    break;
                                case 0:
                                    juVar2 = juVar3;
                                    i2 = 0;
                                    break;
                                case 1:
                                    juVar2 = juVar3;
                                    i2 = 1;
                                    break;
                                case 2:
                                default:
                                    i2 = 6;
                                    juVar2 = juVar3;
                                    break;
                                case 3:
                                    i2 = 2;
                                    juVar2 = juVar3;
                                    break;
                                case 4:
                                    i2 = 3;
                                    juVar2 = juVar3;
                                    break;
                                case 5:
                                    i2 = 5;
                                    juVar2 = juVar3;
                                    break;
                            }
                            long j8 = next.g;
                            z2 = z3;
                            str2 = str3;
                            StringBuilder sb = new StringBuilder(String.valueOf(str6).length() + 33);
                            sb.append(str6);
                            sb.append(".");
                            sb.append(i2);
                            sb.append(".");
                            sb.append(j8);
                            String string2 = sb.toString();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(string2).length());
                            sb2.append(strValueOf);
                            sb2.append(string2);
                            sb2.append("_");
                            string = sb2.toString();
                            roVar2 = roVar3;
                            it2 = it;
                            j7 = j2;
                            juVar3 = juVar2;
                            z3 = z2;
                            str3 = str2;
                        }
                    } else {
                        juVar2 = juVar3;
                        it = it2;
                    }
                    str2 = str3;
                    z2 = z3;
                    j2 = j7;
                    roVar2 = roVar3;
                    it2 = it;
                    j7 = j2;
                    juVar3 = juVar2;
                    z3 = z2;
                    str3 = str2;
                }
                juVar = juVar3;
                roVar = roVar2;
                str = str3;
                z = z3;
                j = j7;
                strSubstring = string.substring(0, Math.max(0, string.length() - 1));
            }
        } else {
            juVar = juVar3;
            roVar = roVar2;
            str = str3;
            z = z3;
            j = j7;
            strSubstring = null;
        }
        return new wk(bqjVar, afuVar, list, i, list2, list3, i3, j3, str, z, jtVar2, knVar2, str4, juVar, jwVar, j4, bqnVar, j5, j6, j, str5, jSONObject, null, vhVar, list4, list5, z4, roVar, strSubstring, this.f.H, this.f.L, this.e.i, this.f.O, this.e.j, this.f.Q, this.f.R, this.f.S, this.f.T, this.f.V);
    }

    @Override // com.google.android.gms.internal.ads.of
    protected final void a(long j) throws InterruptedException, zzapk {
        js khVar;
        Bundle bundle;
        synchronized (this.d) {
            if (this.j.m != -1) {
                khVar = new ke(this.f3312b, this.e.f3545a, this.h, this.j, this.f.s, this.f.z, this.f.J, j, ((Long) bra.e().a(o.bc)).longValue(), 2, this.e.j);
            } else {
                khVar = new kh(this.f3312b, this.e.f3545a, this.h, this.j, this.f.s, this.f.z, this.f.J, j, ((Long) bra.e().a(o.bc)).longValue(), this.k, this.e.j);
            }
            this.i = khVar;
        }
        ArrayList arrayList = new ArrayList(this.j.f3211a);
        Bundle bundle2 = this.e.f3545a.c.m;
        if ((bundle2 == null || (bundle = bundle2.getBundle("com.google.ads.mediation.admob.AdMobAdapter")) == null) ? false : bundle.getBoolean("_skipMediation")) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((jt) listIterator.next()).c.contains("com.google.ads.mediation.admob.AdMobAdapter")) {
                    listIterator.remove();
                }
            }
        }
        this.g = this.i.a(arrayList);
        switch (this.g.f3220a) {
            case 0:
                if (this.g.f3221b == null || this.g.f3221b.o == null) {
                    return;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                xn.f3583a.post(new op(this, countDownLatch));
                try {
                    countDownLatch.await(10L, TimeUnit.SECONDS);
                    synchronized (this.d) {
                        if (!this.m) {
                            throw new zzapk("View could not be prepared", 0);
                        }
                        if (this.l.C()) {
                            throw new zzapk("Assets not loaded, web view is destroyed", 0);
                        }
                    }
                    return;
                } catch (InterruptedException e) {
                    String strValueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 38);
                    sb.append("Interrupted while waiting for latch : ");
                    sb.append(strValueOf);
                    throw new zzapk(sb.toString(), 0);
                }
            case 1:
                throw new zzapk("No fill from any mediation ad networks.", 3);
            default:
                int i = this.g.f3220a;
                StringBuilder sb2 = new StringBuilder(40);
                sb2.append("Unexpected mediation result: ");
                sb2.append(i);
                throw new zzapk(sb2.toString(), 0);
        }
    }

    @Override // com.google.android.gms.internal.ads.of, com.google.android.gms.internal.ads.xa
    public final void c_() {
        synchronized (this.d) {
            super.c_();
            if (this.i != null) {
                this.i.a();
            }
        }
    }
}
