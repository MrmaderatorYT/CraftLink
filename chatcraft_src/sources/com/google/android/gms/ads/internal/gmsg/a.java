package com.google.android.gms.ads.internal.gmsg;

import android.os.Bundle;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import java.util.Iterator;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class a implements ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final j f1584a;

    public a(j jVar) {
        this.f1584a = jVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) throws JSONException {
        if (this.f1584a == null) {
            return;
        }
        String str = map.get("name");
        if (str == null) {
            xe.d("Ad metadata with no name parameter.");
            str = BuildConfig.FLAVOR;
        }
        Bundle bundleA = a(map.get("info"));
        if (bundleA == null) {
            xe.c("Failed to convert ad metadata to Bundle.");
        } else {
            this.f1584a.a(str, bundleA);
        }
    }

    private static Bundle a(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            Bundle bundle = new Bundle();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (obj != null) {
                    if (obj instanceof Boolean) {
                        bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(next, ((Double) obj).doubleValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(next, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(next, ((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        bundle.putString(next, (String) obj);
                    } else {
                        String strValueOf = String.valueOf(next);
                        xe.e(strValueOf.length() != 0 ? "Unsupported type for key:".concat(strValueOf) : new String("Unsupported type for key:"));
                    }
                }
            }
            return bundle;
        } catch (JSONException e) {
            xe.b("Failed to convert ad metadata to JSON.", e);
            return null;
        }
    }
}
