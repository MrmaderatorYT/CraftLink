package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class zl {

    /* renamed from: a, reason: collision with root package name */
    private static final zn<Map<String, ?>> f3635a = new zm();

    public static List<String> a(JSONArray jSONArray, List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static JSONObject a(JSONObject jSONObject, String... strArr) {
        int i = 0;
        while (true) {
            if (i >= strArr.length - 1) {
                break;
            }
            if (jSONObject == null) {
                jSONObject = null;
                break;
            }
            jSONObject = jSONObject.optJSONObject(strArr[i]);
            i++;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject(strArr[strArr.length - 1]);
    }
}
