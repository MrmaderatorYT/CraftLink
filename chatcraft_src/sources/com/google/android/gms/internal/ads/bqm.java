package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@qj
/* loaded from: classes.dex */
public final class bqm {

    /* renamed from: a, reason: collision with root package name */
    public static final bqm f2973a = new bqm();

    protected bqm() {
    }

    public static bqj a(Context context, bte bteVar) {
        Context context2;
        List listUnmodifiableList;
        String strA;
        Date dateA = bteVar.a();
        long time = dateA != null ? dateA.getTime() : -1L;
        String strB = bteVar.b();
        int iC = bteVar.c();
        Set<String> setD = bteVar.d();
        if (setD.isEmpty()) {
            context2 = context;
            listUnmodifiableList = null;
        } else {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(setD));
            context2 = context;
        }
        boolean zA = bteVar.a(context2);
        int iL = bteVar.l();
        Location locationE = bteVar.e();
        Bundle bundleA = bteVar.a(AdMobAdapter.class);
        boolean zF = bteVar.f();
        String strG = bteVar.g();
        com.google.android.gms.ads.d.a aVarI = bteVar.i();
        bty btyVar = aVarI != null ? new bty(aVarI) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            bra.a();
            strA = aac.a(Thread.currentThread().getStackTrace(), packageName);
        } else {
            strA = null;
        }
        return new bqj(8, time, bundleA, iC, listUnmodifiableList, zA, iL, zF, strG, btyVar, locationE, strB, bteVar.k(), bteVar.m(), Collections.unmodifiableList(new ArrayList(bteVar.n())), bteVar.h(), strA, bteVar.o(), null, bteVar.p(), bteVar.q());
    }
}
