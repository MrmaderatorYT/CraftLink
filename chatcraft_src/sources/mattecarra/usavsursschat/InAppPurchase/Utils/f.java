package mattecarra.usavsursschat.InAppPurchase.Utils;

import org.json.JSONObject;

/* compiled from: SkuDetails.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f4827a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4828b;
    private final String c;
    private final String d;
    private final long e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;

    public f(String str, String str2) {
        this.f4827a = str;
        this.i = str2;
        JSONObject jSONObject = new JSONObject(this.i);
        this.f4828b = jSONObject.optString("productId");
        this.c = jSONObject.optString("type");
        this.d = jSONObject.optString("price");
        this.e = jSONObject.optLong("price_amount_micros");
        this.f = jSONObject.optString("price_currency_code");
        this.g = jSONObject.optString("title");
        this.h = jSONObject.optString("description");
    }

    public String a() {
        return this.f4828b;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public String toString() {
        return "SkuDetails:" + this.i;
    }
}
