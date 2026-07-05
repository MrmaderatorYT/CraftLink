package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@qj
/* loaded from: classes.dex */
final class afh {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<bjg> f1927a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private long f1928b;

    afh() {
    }

    final long a() throws NumberFormatException {
        Iterator<bjg> it = this.f1927a.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> mapC = it.next().c();
            if (mapC != null) {
                for (Map.Entry<String, List<String>> entry : mapC.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase(entry.getKey())) {
                            this.f1928b = Math.max(this.f1928b, Long.parseLong(entry.getValue().get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.f1928b;
    }

    final void a(bjg bjgVar) {
        this.f1927a.add(bjgVar);
    }
}
