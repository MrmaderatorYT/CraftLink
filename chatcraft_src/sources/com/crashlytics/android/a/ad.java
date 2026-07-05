package com.crashlytics.android.a;

import android.annotation.TargetApi;
import android.os.Build;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SessionEventTransform.java */
/* loaded from: classes.dex */
class ad implements io.fabric.sdk.android.services.c.a<ab> {
    ad() {
    }

    @Override // io.fabric.sdk.android.services.c.a
    public byte[] a(ab abVar) {
        return b(abVar).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    public JSONObject b(ab abVar) throws JSONException, IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            ac acVar = abVar.f1241a;
            jSONObject.put("appBundleId", acVar.f1247a);
            jSONObject.put("executionId", acVar.f1248b);
            jSONObject.put("installationId", acVar.c);
            jSONObject.put("limitAdTrackingEnabled", acVar.d);
            jSONObject.put("betaDeviceToken", acVar.e);
            jSONObject.put("buildId", acVar.f);
            jSONObject.put("osVersion", acVar.g);
            jSONObject.put("deviceModel", acVar.h);
            jSONObject.put("appVersionCode", acVar.i);
            jSONObject.put("appVersionName", acVar.j);
            jSONObject.put("timestamp", abVar.f1242b);
            jSONObject.put("type", abVar.c.toString());
            if (abVar.d != null) {
                jSONObject.put("details", new JSONObject(abVar.d));
            }
            jSONObject.put("customType", abVar.e);
            if (abVar.f != null) {
                jSONObject.put("customAttributes", new JSONObject(abVar.f));
            }
            jSONObject.put("predefinedType", abVar.g);
            if (abVar.h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(abVar.h));
            }
            return jSONObject;
        } catch (JSONException e) {
            if (Build.VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
