package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class hi<ReferenceT> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, CopyOnWriteArrayList<com.google.android.gms.ads.internal.gmsg.ac<? super ReferenceT>>> f3128a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private ReferenceT f3129b;

    public final void a(ReferenceT referencet) {
        this.f3129b = referencet;
    }

    public final boolean a(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        String path = uri.getPath();
        com.google.android.gms.ads.internal.ax.e();
        a(path, xn.a(uri));
        return true;
    }

    private final synchronized void a(String str, final Map<String, String> map) {
        if (xe.a(2)) {
            String strValueOf = String.valueOf(str);
            xe.a(strValueOf.length() != 0 ? "Received GMSG: ".concat(strValueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                xe.a(sb.toString());
            }
        }
        CopyOnWriteArrayList<com.google.android.gms.ads.internal.gmsg.ac<? super ReferenceT>> copyOnWriteArrayList = this.f3128a.get(str);
        if (copyOnWriteArrayList != null) {
            Iterator<com.google.android.gms.ads.internal.gmsg.ac<? super ReferenceT>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                final com.google.android.gms.ads.internal.gmsg.ac<? super ReferenceT> next = it.next();
                abq.f1816a.execute(new Runnable(this, next, map) { // from class: com.google.android.gms.internal.ads.hj

                    /* renamed from: a, reason: collision with root package name */
                    private final hi f3130a;

                    /* renamed from: b, reason: collision with root package name */
                    private final com.google.android.gms.ads.internal.gmsg.ac f3131b;
                    private final Map c;

                    {
                        this.f3130a = this;
                        this.f3131b = next;
                        this.c = map;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f3130a.a(this.f3131b, this.c);
                    }
                });
            }
        }
    }

    public final synchronized void a(String str, com.google.android.gms.ads.internal.gmsg.ac<? super ReferenceT> acVar) {
        CopyOnWriteArrayList<com.google.android.gms.ads.internal.gmsg.ac<? super ReferenceT>> copyOnWriteArrayList = this.f3128a.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f3128a.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(acVar);
    }

    public final synchronized void b(String str, com.google.android.gms.ads.internal.gmsg.ac<? super ReferenceT> acVar) {
        CopyOnWriteArrayList<com.google.android.gms.ads.internal.gmsg.ac<? super ReferenceT>> copyOnWriteArrayList = this.f3128a.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(acVar);
    }

    public final synchronized void a(String str, com.google.android.gms.common.util.k<com.google.android.gms.ads.internal.gmsg.ac<? super ReferenceT>> kVar) {
        CopyOnWriteArrayList<com.google.android.gms.ads.internal.gmsg.ac<? super ReferenceT>> copyOnWriteArrayList = this.f3128a.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            com.google.android.gms.ads.internal.gmsg.ac<? super ReferenceT> acVar = (com.google.android.gms.ads.internal.gmsg.ac) it.next();
            if (kVar.a(acVar)) {
                arrayList.add(acVar);
            }
        }
        copyOnWriteArrayList.removeAll(arrayList);
    }

    public final synchronized void d() {
        this.f3128a.clear();
    }

    final /* synthetic */ void a(com.google.android.gms.ads.internal.gmsg.ac acVar, Map map) {
        acVar.zza(this.f3129b, map);
    }
}
