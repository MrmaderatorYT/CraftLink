package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.bqn;
import com.google.android.gms.internal.ads.qj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bm {
    public static Object[] a(String str, bqj bqjVar, String str2, int i, bqn bqnVar) {
        HashSet hashSet = new HashSet(Arrays.asList(str.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (hashSet.contains("formatString")) {
            arrayList.add(null);
        }
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(bqjVar.f2970b));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(a(bqjVar.c));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(bqjVar.d));
        }
        if (hashSet.contains("keywords")) {
            if (bqjVar.e != null) {
                arrayList.add(bqjVar.e.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(bqjVar.f));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(bqjVar.g));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(bqjVar.h));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(bqjVar.i);
        }
        if (hashSet.contains("location")) {
            if (bqjVar.k != null) {
                arrayList.add(bqjVar.k.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(bqjVar.l);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(a(bqjVar.m));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(a(bqjVar.n));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (bqjVar.o != null) {
                arrayList.add(bqjVar.o.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(bqjVar.p);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(bqjVar.q);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(bqjVar.r));
        }
        return arrayList.toArray();
    }

    private static String a(Bundle bundle) {
        String string;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            if (obj == null) {
                string = "null";
            } else if (obj instanceof Bundle) {
                string = a((Bundle) obj);
            } else {
                string = obj.toString();
            }
            sb.append(string);
        }
        return sb.toString();
    }
}
