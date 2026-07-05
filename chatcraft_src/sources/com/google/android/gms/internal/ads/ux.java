package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class ux extends xa implements uw {

    /* renamed from: a, reason: collision with root package name */
    private final wl f3505a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3506b;
    private final ArrayList<un> c;
    private final List<uq> d;
    private final HashSet<String> e;
    private final Object f;
    private final tm g;
    private final long h;

    public ux(Context context, wl wlVar, tm tmVar) {
        this(context, wlVar, tmVar, ((Long) bra.e().a(o.ar)).longValue());
    }

    @Override // com.google.android.gms.internal.ads.uw
    public final void a(String str, int i) {
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void c_() {
    }

    private ux(Context context, wl wlVar, tm tmVar, long j) {
        this.c = new ArrayList<>();
        this.d = new ArrayList();
        this.e = new HashSet<>();
        this.f = new Object();
        this.f3506b = context;
        this.f3505a = wlVar;
        this.g = tmVar;
        this.h = j;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:? -> B:37:0x00b7). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.xa
    public final void a() throws Throwable {
        Object obj;
        for (jt jtVar : this.f3505a.c.f3211a) {
            String str = jtVar.k;
            for (String string : jtVar.c) {
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(string) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(string)) {
                    try {
                        string = new JSONObject(str).getString("class_name");
                    } catch (JSONException e) {
                        xe.b("Unable to determine custom event class name, skipping...", e);
                    }
                }
                String str2 = string;
                Object obj2 = this.f;
                synchronized (obj2) {
                    try {
                        vb vbVarA = this.g.a(str2);
                        if (vbVarA == null || vbVarA.b() == null || vbVarA.a() == null) {
                            this.d.add(new us().b(jtVar.d).a(str2).a(0L).a(7).a());
                        } else {
                            obj = obj2;
                            try {
                                un unVar = new un(this.f3506b, str2, str, jtVar, this.f3505a, vbVarA, this, this.h);
                                unVar.a(this.g.a());
                                this.c.add(unVar);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj = obj2;
                        throw th;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList<un> arrayList = this.c;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            un unVar2 = arrayList.get(i2);
            i2++;
            un unVar3 = unVar2;
            if (hashSet.add(unVar3.f3493a)) {
                unVar3.d();
            }
        }
        ArrayList<un> arrayList2 = this.c;
        int size2 = arrayList2.size();
        while (i < size2) {
            un unVar4 = arrayList2.get(i);
            i++;
            un unVar5 = unVar4;
            try {
                try {
                    try {
                        unVar5.d().get();
                        synchronized (this.f) {
                            if (!TextUtils.isEmpty(unVar5.f3493a)) {
                                this.d.add(unVar5.e());
                            }
                        }
                        synchronized (this.f) {
                            if (this.e.contains(unVar5.f3493a)) {
                                final wk wkVarA = a(-2, unVar5.f3493a, unVar5.f());
                                aac.f1778a.post(new Runnable(this, wkVarA) { // from class: com.google.android.gms.internal.ads.uy

                                    /* renamed from: a, reason: collision with root package name */
                                    private final ux f3507a;

                                    /* renamed from: b, reason: collision with root package name */
                                    private final wk f3508b;

                                    {
                                        this.f3507a = this;
                                        this.f3508b = wkVarA;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f3507a.b(this.f3508b);
                                    }
                                });
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        synchronized (this.f) {
                            if (!TextUtils.isEmpty(unVar5.f3493a)) {
                                this.d.add(unVar5.e());
                            }
                            throw th3;
                        }
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    synchronized (this.f) {
                        if (!TextUtils.isEmpty(unVar5.f3493a)) {
                            this.d.add(unVar5.e());
                        }
                    }
                }
            } catch (Exception e2) {
                xe.c("Unable to resolve rewarded adapter.", e2);
                synchronized (this.f) {
                    if (!TextUtils.isEmpty(unVar5.f3493a)) {
                        this.d.add(unVar5.e());
                    }
                }
            }
        }
        final wk wkVarA2 = a(3, null, null);
        aac.f1778a.post(new Runnable(this, wkVarA2) { // from class: com.google.android.gms.internal.ads.uz

            /* renamed from: a, reason: collision with root package name */
            private final ux f3509a;

            /* renamed from: b, reason: collision with root package name */
            private final wk f3510b;

            {
                this.f3509a = this;
                this.f3510b = wkVarA2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3509a.a(this.f3510b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.uw
    public final void a(String str) {
        synchronized (this.f) {
            this.e.add(str);
        }
    }

    private final wk a(int i, String str, jt jtVar) {
        bqn bqnVar;
        boolean z;
        String str2;
        long j;
        String strSubstring;
        long j2;
        int i2;
        bqj bqjVar = this.f3505a.f3545a.c;
        List<String> list = this.f3505a.f3546b.c;
        List<String> list2 = this.f3505a.f3546b.e;
        List<String> list3 = this.f3505a.f3546b.i;
        int i3 = this.f3505a.f3546b.k;
        long j3 = this.f3505a.f3546b.j;
        String str3 = this.f3505a.f3545a.i;
        boolean z2 = this.f3505a.f3546b.g;
        ju juVar = this.f3505a.c;
        long j4 = this.f3505a.f3546b.h;
        bqn bqnVar2 = this.f3505a.d;
        long j5 = this.f3505a.f3546b.f;
        long j6 = this.f3505a.f;
        long j7 = this.f3505a.f3546b.m;
        String str4 = this.f3505a.f3546b.n;
        JSONObject jSONObject = this.f3505a.h;
        vh vhVar = this.f3505a.f3546b.A;
        List<String> list4 = this.f3505a.f3546b.B;
        List<String> list5 = this.f3505a.f3546b.C;
        boolean z3 = this.f3505a.f3546b.D;
        ro roVar = this.f3505a.f3546b.E;
        StringBuilder sb = new StringBuilder(BuildConfig.FLAVOR);
        if (this.d == null) {
            strSubstring = sb.toString();
            bqnVar = bqnVar2;
            z = z2;
            str2 = str4;
            j = j7;
        } else {
            Iterator<uq> it = this.d.iterator();
            while (true) {
                bqnVar = bqnVar2;
                if (it.hasNext()) {
                    uq next = it.next();
                    if (next != null) {
                        Iterator<uq> it2 = it;
                        if (TextUtils.isEmpty(next.f3499a)) {
                            bqnVar2 = bqnVar;
                            it = it2;
                        } else {
                            String str5 = next.f3499a;
                            String str6 = str4;
                            switch (next.f3500b) {
                                case 3:
                                    j2 = j7;
                                    i2 = 1;
                                    break;
                                case 4:
                                    j2 = j7;
                                    i2 = 2;
                                    break;
                                case 5:
                                    j2 = j7;
                                    i2 = 4;
                                    break;
                                case 6:
                                    j2 = j7;
                                    i2 = 0;
                                    break;
                                case 7:
                                    j2 = j7;
                                    i2 = 3;
                                    break;
                                default:
                                    j2 = j7;
                                    i2 = 6;
                                    break;
                            }
                            long j8 = next.c;
                            boolean z4 = z2;
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str5).length() + 33);
                            sb2.append(str5);
                            sb2.append(".");
                            sb2.append(i2);
                            sb2.append(".");
                            sb2.append(j8);
                            sb.append(String.valueOf(sb2.toString()).concat("_"));
                            bqnVar2 = bqnVar;
                            it = it2;
                            str4 = str6;
                            j7 = j2;
                            z2 = z4;
                        }
                    } else {
                        bqnVar2 = bqnVar;
                    }
                } else {
                    z = z2;
                    str2 = str4;
                    j = j7;
                    strSubstring = sb.substring(0, Math.max(0, sb.length() - 1));
                }
            }
        }
        return new wk(bqjVar, null, list, i, list2, list3, i3, j3, str3, z, jtVar, null, str, juVar, null, j4, bqnVar, j5, j6, j, str2, jSONObject, null, vhVar, list4, list5, z3, roVar, strSubstring, this.f3505a.f3546b.H, this.f3505a.f3546b.L, this.f3505a.i, this.f3505a.f3546b.O, this.f3505a.j, this.f3505a.f3546b.Q, this.f3505a.f3546b.R, this.f3505a.f3546b.S, this.f3505a.f3546b.T, this.f3505a.f3546b.V);
    }

    final /* synthetic */ void a(wk wkVar) {
        this.g.b().b(wkVar);
    }

    final /* synthetic */ void b(wk wkVar) {
        this.g.b().b(wkVar);
    }
}
