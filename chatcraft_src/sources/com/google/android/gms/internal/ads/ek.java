package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class ek extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<ek> CREATOR = new el();

    /* renamed from: a, reason: collision with root package name */
    private final String f3066a;

    /* renamed from: b, reason: collision with root package name */
    private final String[] f3067b;
    private final String[] c;

    ek(String str, String[] strArr, String[] strArr2) {
        this.f3066a = str;
        this.f3067b = strArr;
        this.c = strArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f3066a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3067b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.c, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }

    public static ek a(blc blcVar) {
        Map<String, String> mapB = blcVar.b();
        int size = mapB.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry<String, String> entry : mapB.entrySet()) {
            strArr[i] = entry.getKey();
            strArr2[i] = entry.getValue();
            i++;
        }
        return new ek(blcVar.e(), strArr, strArr2);
    }
}
