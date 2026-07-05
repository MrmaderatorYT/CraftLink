package com.google.android.gms.internal.ads;

import com.google.ads.a;
import java.util.Date;
import java.util.HashSet;

@qj
/* loaded from: classes.dex */
public final class lr {
    public static int a(a.EnumC0064a enumC0064a) {
        switch (enumC0064a) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    public static com.google.ads.mediation.a a(bqj bqjVar, boolean z) {
        a.b bVar;
        HashSet hashSet = bqjVar.e != null ? new HashSet(bqjVar.e) : null;
        Date date = new Date(bqjVar.f2970b);
        switch (bqjVar.d) {
            case 1:
                bVar = a.b.MALE;
                break;
            case 2:
                bVar = a.b.FEMALE;
                break;
            default:
                bVar = a.b.UNKNOWN;
                break;
        }
        return new com.google.ads.mediation.a(date, bVar, hashSet, z, bqjVar.k);
    }
}
