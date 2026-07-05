package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bmw {

    /* renamed from: b, reason: collision with root package name */
    private int f2854b;

    /* renamed from: a, reason: collision with root package name */
    private final Object f2853a = new Object();
    private List<bmv> c = new LinkedList();

    public final bmv a() {
        synchronized (this.f2853a) {
            bmv bmvVar = null;
            if (this.c.size() == 0) {
                xe.b("Queue empty");
                return null;
            }
            int i = 0;
            if (this.c.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                for (bmv bmvVar2 : this.c) {
                    int i4 = bmvVar2.i();
                    if (i4 > i2) {
                        i = i3;
                        bmvVar = bmvVar2;
                        i2 = i4;
                    }
                    i3++;
                }
                this.c.remove(i);
                return bmvVar;
            }
            bmv bmvVar3 = this.c.get(0);
            bmvVar3.e();
            return bmvVar3;
        }
    }

    public final boolean a(bmv bmvVar) {
        synchronized (this.f2853a) {
            return this.c.contains(bmvVar);
        }
    }

    public final boolean b(bmv bmvVar) {
        synchronized (this.f2853a) {
            Iterator<bmv> it = this.c.iterator();
            while (it.hasNext()) {
                bmv next = it.next();
                if (!com.google.android.gms.ads.internal.ax.i().k().b()) {
                    if (bmvVar != next && next.b().equals(bmvVar.b())) {
                        it.remove();
                        return true;
                    }
                } else if (!com.google.android.gms.ads.internal.ax.i().k().d() && bmvVar != next && next.d().equals(bmvVar.d())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void c(bmv bmvVar) {
        synchronized (this.f2853a) {
            if (this.c.size() >= 10) {
                int size = this.c.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                xe.b(sb.toString());
                this.c.remove(0);
            }
            int i = this.f2854b;
            this.f2854b = i + 1;
            bmvVar.a(i);
            this.c.add(bmvVar);
        }
    }
}
