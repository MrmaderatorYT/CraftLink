package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class vs extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<vs> CREATOR = new vt();

    /* renamed from: a, reason: collision with root package name */
    public final String f3528a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3529b;
    public final boolean c;
    public final boolean d;
    public final List<String> e;
    public final boolean f;
    public final boolean g;
    public final List<String> h;

    public vs(String str, String str2, boolean z, boolean z2, List<String> list, boolean z3, boolean z4, List<String> list2) {
        this.f3528a = str;
        this.f3529b = str2;
        this.c = z;
        this.d = z2;
        this.e = list;
        this.f = z3;
        this.g = z4;
        this.h = list2 == null ? new ArrayList<>() : list2;
    }

    public static vs a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new vs(jSONObject.optString("click_string", BuildConfig.FLAVOR), jSONObject.optString("report_url", BuildConfig.FLAVOR), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zl.a(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zl.a(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3528a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.f3529b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.d);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 6, this.e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.f);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.g);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 9, this.h, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
