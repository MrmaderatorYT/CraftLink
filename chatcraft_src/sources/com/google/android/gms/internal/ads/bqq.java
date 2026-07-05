package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.i;

@qj
/* loaded from: classes.dex */
public final class bqq {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.ads.d[] f2977a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2978b;

    private static com.google.android.gms.ads.d[] a(String str) {
        String[] strArrSplit = str.split("\\s*,\\s*");
        com.google.android.gms.ads.d[] dVarArr = new com.google.android.gms.ads.d[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            String strTrim = strArrSplit[i].trim();
            if (strTrim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] strArrSplit2 = strTrim.split("[xX]");
                strArrSplit2[0] = strArrSplit2[0].trim();
                strArrSplit2[1] = strArrSplit2[1].trim();
                try {
                    dVarArr[i] = new com.google.android.gms.ads.d("FULL_WIDTH".equals(strArrSplit2[0]) ? -1 : Integer.parseInt(strArrSplit2[0]), "AUTO_HEIGHT".equals(strArrSplit2[1]) ? -2 : Integer.parseInt(strArrSplit2[1]));
                } catch (NumberFormatException unused) {
                    String strValueOf = String.valueOf(strTrim);
                    throw new IllegalArgumentException(strValueOf.length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(strValueOf) : new String("Could not parse XML attribute \"adSize\": "));
                }
            } else if ("BANNER".equals(strTrim)) {
                dVarArr[i] = com.google.android.gms.ads.d.f1484a;
            } else if ("LARGE_BANNER".equals(strTrim)) {
                dVarArr[i] = com.google.android.gms.ads.d.c;
            } else if ("FULL_BANNER".equals(strTrim)) {
                dVarArr[i] = com.google.android.gms.ads.d.f1485b;
            } else if ("LEADERBOARD".equals(strTrim)) {
                dVarArr[i] = com.google.android.gms.ads.d.d;
            } else if ("MEDIUM_RECTANGLE".equals(strTrim)) {
                dVarArr[i] = com.google.android.gms.ads.d.e;
            } else if ("SMART_BANNER".equals(strTrim)) {
                dVarArr[i] = com.google.android.gms.ads.d.g;
            } else if ("WIDE_SKYSCRAPER".equals(strTrim)) {
                dVarArr[i] = com.google.android.gms.ads.d.f;
            } else if ("FLUID".equals(strTrim)) {
                dVarArr[i] = com.google.android.gms.ads.d.h;
            } else {
                if (!"ICON".equals(strTrim)) {
                    String strValueOf2 = String.valueOf(strTrim);
                    throw new IllegalArgumentException(strValueOf2.length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(strValueOf2) : new String("Could not parse XML attribute \"adSize\": "));
                }
                dVarArr[i] = com.google.android.gms.ads.d.i;
            }
        }
        if (dVarArr.length != 0) {
            return dVarArr;
        }
        String strValueOf3 = String.valueOf(str);
        throw new IllegalArgumentException(strValueOf3.length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(strValueOf3) : new String("Could not parse XML attribute \"adSize\": "));
    }

    public bqq(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, i.a.AdsAttrs);
        String string = typedArrayObtainAttributes.getString(i.a.AdsAttrs_adSize);
        String string2 = typedArrayObtainAttributes.getString(i.a.AdsAttrs_adSizes);
        boolean z = !TextUtils.isEmpty(string);
        boolean z2 = !TextUtils.isEmpty(string2);
        if (z && !z2) {
            this.f2977a = a(string);
        } else {
            if (z || !z2) {
                if (z) {
                    throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
                }
                throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
            }
            this.f2977a = a(string2);
        }
        this.f2978b = typedArrayObtainAttributes.getString(i.a.AdsAttrs_adUnitId);
        if (TextUtils.isEmpty(this.f2978b)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    public final com.google.android.gms.ads.d[] a(boolean z) {
        if (!z && this.f2977a.length != 1) {
            throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
        }
        return this.f2977a;
    }

    public final String a() {
        return this.f2978b;
    }
}
