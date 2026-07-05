package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class g extends d<Long> {
    g(int i, String str, Long l) {
        super(i, str, l, null);
    }

    @Override // com.google.android.gms.internal.ads.d
    public final /* synthetic */ void a(SharedPreferences.Editor editor, Long l) {
        editor.putLong(a(), l.longValue());
    }

    @Override // com.google.android.gms.internal.ads.d
    public final /* synthetic */ Long a(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(a(), b().longValue()));
    }

    @Override // com.google.android.gms.internal.ads.d
    public final /* synthetic */ Long a(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(a(), b().longValue()));
    }
}
