package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.gv;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ gv f1585a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Map f1586b;
    private final /* synthetic */ HttpClient c;

    ad(HttpClient httpClient, Map map, gv gvVar) {
        this.c = httpClient;
        this.f1586b = map;
        this.f1585a = gvVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        xe.b("Received Http request.");
        try {
            JSONObject jSONObjectSend = this.c.send(new JSONObject((String) this.f1586b.get("http_request")));
            if (jSONObjectSend == null) {
                xe.c("Response should not be null.");
            } else {
                xn.f3583a.post(new ae(this, jSONObjectSend));
            }
        } catch (Exception e) {
            xe.b("Error converting request to json.", e);
        }
    }
}
