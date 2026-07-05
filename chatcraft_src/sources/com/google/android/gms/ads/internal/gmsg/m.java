package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class m implements ac<afu> {
    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) throws NumberFormatException {
        afu afuVar2 = afuVar;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                xe.e("No label given for CSI tick.");
                return;
            }
            if (TextUtils.isEmpty(str4)) {
                xe.e("No timestamp given for CSI tick.");
                return;
            }
            try {
                long jB = ax.l().b() + (Long.parseLong(str4) - ax.l().a());
                if (TextUtils.isEmpty(str3)) {
                    str3 = "native:view_load";
                }
                afuVar2.j().a(str2, str3, jB);
                return;
            } catch (NumberFormatException e) {
                xe.c("Malformed timestamp for CSI tick.", e);
                return;
            }
        }
        if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                xe.e("No value given for CSI experiment.");
                return;
            }
            com.google.android.gms.internal.ads.ac acVarA = afuVar2.j().a();
            if (acVarA == null) {
                xe.e("No ticker for WebView, dropping experiment ID.");
                return;
            } else {
                acVarA.a("e", str5);
                return;
            }
        }
        if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                xe.e("No value given for CSI extra.");
                return;
            }
            if (TextUtils.isEmpty(str6)) {
                xe.e("No name given for CSI extra.");
                return;
            }
            com.google.android.gms.internal.ads.ac acVarA2 = afuVar2.j().a();
            if (acVarA2 == null) {
                xe.e("No ticker for WebView, dropping extra parameter.");
            } else {
                acVarA2.a(str6, str7);
            }
        }
    }
}
