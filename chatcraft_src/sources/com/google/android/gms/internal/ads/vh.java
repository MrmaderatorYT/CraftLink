package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;

@qj
/* loaded from: classes.dex */
public final class vh extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<vh> CREATOR = new vi();

    /* renamed from: a, reason: collision with root package name */
    public final String f3518a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3519b;

    public vh(com.google.android.gms.ads.reward.b bVar) {
        this(bVar.a(), bVar.b());
    }

    public vh(String str, int i) {
        this.f3518a = str;
        this.f3519b = i;
    }

    public static vh a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new vh(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public static vh a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a(new JSONArray(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3518a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f3519b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof vh)) {
            return false;
        }
        vh vhVar = (vh) obj;
        return com.google.android.gms.common.internal.h.a(this.f3518a, vhVar.f3518a) && com.google.android.gms.common.internal.h.a(Integer.valueOf(this.f3519b), Integer.valueOf(vhVar.f3519b));
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.h.a(this.f3518a, Integer.valueOf(this.f3519b));
    }
}
