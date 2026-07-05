package androidx.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* compiled from: ViewModelStore.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, p> f928a = new HashMap<>();

    final void a(String str, p pVar) {
        p pVarPut = this.f928a.put(str, pVar);
        if (pVarPut != null) {
            pVarPut.a();
        }
    }

    final p a(String str) {
        return this.f928a.get(str);
    }

    public final void a() {
        Iterator<p> it = this.f928a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f928a.clear();
    }
}
