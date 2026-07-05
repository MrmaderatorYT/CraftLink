package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
final class gt {

    /* renamed from: a, reason: collision with root package name */
    final bqj f3113a;

    /* renamed from: b, reason: collision with root package name */
    final String f3114b;
    final int c;

    static gt a(String str) {
        String[] strArrSplit = str.split("\u0000");
        if (strArrSplit.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                String str2 = new String(Base64.decode(strArrSplit[0], 0), "UTF-8");
                int i = Integer.parseInt(strArrSplit[1]);
                byte[] bArrDecode = Base64.decode(strArrSplit[2], 0);
                parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
                parcelObtain.setDataPosition(0);
                return new gt(bqj.CREATOR.createFromParcel(parcelObtain), str2, i);
            } catch (SafeParcelReader.ParseException | IllegalArgumentException | IllegalStateException e) {
                com.google.android.gms.ads.internal.ax.i().a(e, "QueueSeed.decode");
                throw new IOException("Malformed QueueSeed encoding.", e);
            }
        } finally {
            parcelObtain.recycle();
        }
    }

    gt(gp gpVar) {
        this(gpVar.a(), gpVar.c(), gpVar.b());
    }

    private gt(bqj bqjVar, String str, int i) {
        this.f3113a = bqjVar;
        this.f3114b = str;
        this.c = i;
    }

    final String a() {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                String strEncodeToString = Base64.encodeToString(this.f3114b.getBytes("UTF-8"), 0);
                String string = Integer.toString(this.c);
                this.f3113a.writeToParcel(parcelObtain, 0);
                String strEncodeToString2 = Base64.encodeToString(parcelObtain.marshall(), 0);
                StringBuilder sb = new StringBuilder(String.valueOf(strEncodeToString).length() + 2 + String.valueOf(string).length() + String.valueOf(strEncodeToString2).length());
                sb.append(strEncodeToString);
                sb.append("\u0000");
                sb.append(string);
                sb.append("\u0000");
                sb.append(strEncodeToString2);
                return sb.toString();
            } catch (UnsupportedEncodingException unused) {
                xe.c("QueueSeed encode failed because UTF-8 is not available.");
                parcelObtain.recycle();
                return BuildConfig.FLAVOR;
            }
        } finally {
            parcelObtain.recycle();
        }
    }
}
