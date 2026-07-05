package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.vh;
import com.google.android.gms.internal.ads.xe;
import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class h implements ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final i f1600a;

    public h(i iVar) {
        this.f1600a = iVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) throws NumberFormatException {
        String str = map.get("action");
        if ("grant".equals(str)) {
            vh vhVar = null;
            try {
                int i = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    vhVar = new vh(str2, i);
                }
            } catch (NumberFormatException e) {
                xe.c("Unable to parse reward amount.", e);
            }
            this.f1600a.a(vhVar);
            return;
        }
        if ("video_start".equals(str)) {
            this.f1600a.d_();
        } else if ("video_complete".equals(str)) {
            this.f1600a.e_();
        }
    }
}
