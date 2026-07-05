package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.bu;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.mt;
import com.google.android.gms.internal.ads.mx;
import com.google.android.gms.internal.ads.mz;
import com.google.android.gms.internal.ads.na;
import com.google.android.gms.internal.ads.ni;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import java.util.Map;
import org.json.JSONException;

@qj
/* loaded from: classes.dex */
public final class c implements ac<afu> {
    private static final Map<String, Integer> d = com.google.android.gms.common.util.d.a(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});

    /* renamed from: a, reason: collision with root package name */
    private final bu f1592a;

    /* renamed from: b, reason: collision with root package name */
    private final mx f1593b;
    private final ni c;

    public c(bu buVar, mx mxVar, ni niVar) {
        this.f1592a = buVar;
        this.f1593b = mxVar;
        this.c = niVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) throws JSONException {
        afu afuVar2 = afuVar;
        int iIntValue = d.get((String) map.get("a")).intValue();
        if (iIntValue != 5 && iIntValue != 7 && this.f1592a != null && !this.f1592a.b()) {
            this.f1592a.a(null);
        }
        if (iIntValue == 1) {
            this.f1593b.a((Map<String, String>) map);
            return;
        }
        switch (iIntValue) {
            case 3:
                new na(afuVar2, map).a();
                break;
            case 4:
                new mt(afuVar2, map).a();
                break;
            case 5:
                new mz(afuVar2, map).a();
                break;
            case 6:
                this.f1593b.a(true);
                break;
            case 7:
                if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.J)).booleanValue()) {
                    this.c.J();
                    break;
                }
                break;
            default:
                xe.d("Unknown MRAID command called.");
                break;
        }
    }
}
