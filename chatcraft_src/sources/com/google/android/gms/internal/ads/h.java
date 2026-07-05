package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class h extends d<Float> {
    h(int i, String str, Float f) {
        super(i, str, f, null);
    }

    @Override // com.google.android.gms.internal.ads.d
    public final /* synthetic */ void a(SharedPreferences.Editor editor, Float f) {
        editor.putFloat(a(), f.floatValue());
    }

    @Override // com.google.android.gms.internal.ads.d
    public final /* synthetic */ Float a(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(a(), b().floatValue()));
    }

    @Override // com.google.android.gms.internal.ads.d
    public final /* synthetic */ Float a(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(a(), b().floatValue()));
    }
}
