package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;

@qj
/* loaded from: classes.dex */
public final class a {
    public static boolean a(Context context, c cVar, t tVar) throws NumberFormatException {
        int i;
        if (cVar == null) {
            xe.e("No intent data for launcher overlay.");
            return false;
        }
        com.google.android.gms.internal.ads.o.a(context);
        if (cVar.f != null) {
            return a(context, cVar.f, tVar);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(cVar.f1624a)) {
            xe.e("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(cVar.f1625b)) {
            intent.setDataAndType(Uri.parse(cVar.f1624a), cVar.f1625b);
        } else {
            intent.setData(Uri.parse(cVar.f1624a));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(cVar.c)) {
            intent.setPackage(cVar.c);
        }
        if (!TextUtils.isEmpty(cVar.d)) {
            String[] strArrSplit = cVar.d.split("/", 2);
            if (strArrSplit.length < 2) {
                String strValueOf = String.valueOf(cVar.d);
                xe.e(strValueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(strValueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent.setClassName(strArrSplit[0], strArrSplit[1]);
        }
        String str = cVar.e;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                xe.e("Could not parse intent flags.");
                i = 0;
            }
            intent.addFlags(i);
        }
        if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.ch)).booleanValue()) {
            intent.addFlags(268435456);
            intent.putExtra("androidx.browser.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.cg)).booleanValue()) {
                ax.e();
                xn.b(context, intent);
            }
        }
        return a(context, intent, tVar);
    }

    private static boolean a(Context context, Intent intent, t tVar) {
        try {
            String strValueOf = String.valueOf(intent.toURI());
            xe.a(strValueOf.length() != 0 ? "Launching an intent: ".concat(strValueOf) : new String("Launching an intent: "));
            ax.e();
            xn.a(context, intent);
            if (tVar == null) {
                return true;
            }
            tVar.h();
            return true;
        } catch (ActivityNotFoundException e) {
            xe.e(e.getMessage());
            return false;
        }
    }
}
