package mattecarra.usavsursschat.InAppPurchase.Utils;

/* compiled from: IabResult.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    int f4821a;

    /* renamed from: b, reason: collision with root package name */
    String f4822b;

    public b(int i, String str) {
        this.f4821a = i;
        if (str == null || str.trim().length() == 0) {
            this.f4822b = IabHelper.a(i);
            return;
        }
        this.f4822b = str + " (response: " + IabHelper.a(i) + ")";
    }

    public String a() {
        return this.f4822b;
    }

    public boolean b() {
        return this.f4821a == 0;
    }

    public boolean c() {
        return !b();
    }

    public String toString() {
        return "IabResult: " + a();
    }
}
