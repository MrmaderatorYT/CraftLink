package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.aau;
import com.google.android.gms.internal.ads.aaz;
import com.google.android.gms.internal.ads.abl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final /* synthetic */ class f implements aau {

    /* renamed from: a, reason: collision with root package name */
    static final aau f1575a = new f();

    private f() {
    }

    @Override // com.google.android.gms.internal.ads.aau
    public final abl a(Object obj) throws JSONException {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            ax.i().k().f(jSONObject.getString("appSettingsJson"));
        }
        return aaz.a((Object) null);
    }
}
