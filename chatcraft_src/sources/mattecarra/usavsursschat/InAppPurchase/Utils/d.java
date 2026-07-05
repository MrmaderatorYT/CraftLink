package mattecarra.usavsursschat.InAppPurchase.Utils;

import org.json.JSONObject;

/* compiled from: Purchase.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    String f4825a;

    /* renamed from: b, reason: collision with root package name */
    String f4826b;
    String c;
    String d;
    long e;
    int f;
    String g;
    String h;
    String i;
    String j;
    boolean k;

    public d(String str, String str2, String str3) {
        this.f4825a = str;
        this.i = str2;
        JSONObject jSONObject = new JSONObject(this.i);
        this.f4826b = jSONObject.optString("orderId");
        this.c = jSONObject.optString("packageName");
        this.d = jSONObject.optString("productId");
        this.e = jSONObject.optLong("purchaseTime");
        this.f = jSONObject.optInt("purchaseState");
        this.g = jSONObject.optString("developerPayload");
        this.h = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.k = jSONObject.optBoolean("autoRenewing");
        this.j = str3;
    }

    public String a() {
        return this.f4825a;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.h;
    }

    public String toString() {
        return "PurchaseInfo(type:" + this.f4825a + "):" + this.i;
    }
}
