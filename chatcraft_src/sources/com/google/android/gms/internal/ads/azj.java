package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class azj implements bne {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, List<blc<?>>> f2420a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final axi f2421b;

    azj(axi axiVar) {
        this.f2421b = axiVar;
    }

    @Override // com.google.android.gms.internal.ads.bne
    public final void a(blc<?> blcVar, brg<?> brgVar) {
        List<blc<?>> listRemove;
        if (brgVar.f3004b == null || brgVar.f3004b.a()) {
            a(blcVar);
            return;
        }
        String strF = blcVar.f();
        synchronized (this) {
            listRemove = this.f2420a.remove(strF);
        }
        if (listRemove != null) {
            if (eb.f3057a) {
                eb.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(listRemove.size()), strF);
            }
            Iterator<blc<?>> it = listRemove.iterator();
            while (it.hasNext()) {
                this.f2421b.e.a(it.next(), brgVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bne
    public final synchronized void a(blc<?> blcVar) {
        String strF = blcVar.f();
        List<blc<?>> listRemove = this.f2420a.remove(strF);
        if (listRemove != null && !listRemove.isEmpty()) {
            if (eb.f3057a) {
                eb.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(listRemove.size()), strF);
            }
            blc<?> blcVarRemove = listRemove.remove(0);
            this.f2420a.put(strF, listRemove);
            blcVarRemove.a((bne) this);
            try {
                this.f2421b.c.put(blcVarRemove);
            } catch (InterruptedException e) {
                eb.c("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.f2421b.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean b(blc<?> blcVar) {
        String strF = blcVar.f();
        if (this.f2420a.containsKey(strF)) {
            List<blc<?>> arrayList = this.f2420a.get(strF);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            blcVar.b("waiting-for-response");
            arrayList.add(blcVar);
            this.f2420a.put(strF, arrayList);
            if (eb.f3057a) {
                eb.b("Request for cacheKey=%s is in flight, putting on hold.", strF);
            }
            return true;
        }
        this.f2420a.put(strF, null);
        blcVar.a((bne) this);
        if (eb.f3057a) {
            eb.b("new request, sending to network %s", strF);
        }
        return false;
    }
}
