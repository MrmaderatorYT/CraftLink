package mattecarra.usavsursschat.InAppPurchase.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Inventory.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    Map<String, f> f4823a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    Map<String, d> f4824b = new HashMap();

    c() {
    }

    public f a(String str) {
        return this.f4823a.get(str);
    }

    public d b(String str) {
        return this.f4824b.get(str);
    }

    List<String> c(String str) {
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.f4824b.values()) {
            if (dVar.a().equals(str)) {
                arrayList.add(dVar.b());
            }
        }
        return arrayList;
    }

    void a(f fVar) {
        this.f4823a.put(fVar.a(), fVar);
    }

    void a(d dVar) {
        this.f4824b.put(dVar.b(), dVar);
    }
}
