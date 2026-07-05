package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ro extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<ro> CREATOR = new rp();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3429a;

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f3430b;

    public ro() {
        this(false, Collections.emptyList());
    }

    public ro(boolean z, List<String> list) {
        this.f3429a = z;
        this.f3430b = list;
    }

    public static ro a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new ro();
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("reporting_urls");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    arrayList.add(jSONArrayOptJSONArray.getString(i));
                } catch (JSONException e) {
                    xe.c("Error grabbing url from json.", e);
                }
            }
        }
        return new ro(jSONObject.optBoolean("enable_protection"), arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f3429a);
        com.google.android.gms.common.internal.safeparcel.b.b(parcel, 3, this.f3430b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
