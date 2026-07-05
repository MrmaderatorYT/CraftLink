package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.abv;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class ah implements ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, abv<JSONObject>> f1590a = new HashMap<>();

    public final Future<JSONObject> a(String str) {
        abv<JSONObject> abvVar = new abv<>();
        this.f1590a.put(str, abvVar);
        return abvVar;
    }

    public final void b(String str) {
        abv<JSONObject> abvVar = this.f1590a.get(str);
        if (abvVar == null) {
            xe.c("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!abvVar.isDone()) {
            abvVar.cancel(true);
        }
        this.f1590a.remove(str);
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("request_id");
        String str2 = map.get("fetched_ad");
        xe.b("Received ad from the cache.");
        abv<JSONObject> abvVar = this.f1590a.get(str);
        try {
            if (abvVar == null) {
                xe.c("Could not find the ad request for the corresponding ad response.");
            } else {
                abvVar.b(new JSONObject(str2));
            }
        } catch (JSONException e) {
            xe.b("Failed constructing JSON object from value passed from javascript", e);
            abvVar.b(null);
        } finally {
            this.f1590a.remove(str);
        }
    }
}
