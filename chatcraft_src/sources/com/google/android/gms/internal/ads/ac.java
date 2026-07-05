package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1823a;

    /* renamed from: b, reason: collision with root package name */
    private final List<z> f1824b = new LinkedList();
    private final Map<String, String> c = new LinkedHashMap();
    private final Object d = new Object();
    private String e;
    private ac f;

    public ac(boolean z, String str, String str2) {
        this.f1823a = z;
        this.c.put("action", str);
        this.c.put("ad_format", str2);
    }

    public final void a(ac acVar) {
        synchronized (this.d) {
            this.f = acVar;
        }
    }

    public final z a() {
        return a(com.google.android.gms.ads.internal.ax.l().b());
    }

    public final z a(long j) {
        if (this.f1823a) {
            return new z(j, null, null);
        }
        return null;
    }

    public final boolean a(z zVar, String... strArr) {
        if (!this.f1823a || zVar == null) {
            return false;
        }
        return a(zVar, com.google.android.gms.ads.internal.ax.l().b(), strArr);
    }

    public final boolean a(z zVar, long j, String... strArr) {
        synchronized (this.d) {
            for (String str : strArr) {
                this.f1824b.add(new z(j, str, zVar));
            }
        }
        return true;
    }

    public final String b() {
        String string;
        StringBuilder sb = new StringBuilder();
        synchronized (this.d) {
            for (z zVar : this.f1824b) {
                long jA = zVar.a();
                String strB = zVar.b();
                z zVarC = zVar.c();
                if (zVarC != null && jA > 0) {
                    long jA2 = jA - zVarC.a();
                    sb.append(strB);
                    sb.append('.');
                    sb.append(jA2);
                    sb.append(',');
                }
            }
            this.f1824b.clear();
            if (!TextUtils.isEmpty(this.e)) {
                sb.append(this.e);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            string = sb.toString();
        }
        return string;
    }

    public final void a(String str) {
        if (this.f1823a) {
            synchronized (this.d) {
                this.e = str;
            }
        }
    }

    public final void a(String str, String str2) {
        r rVarA;
        if (!this.f1823a || TextUtils.isEmpty(str2) || (rVarA = com.google.android.gms.ads.internal.ax.i().a()) == null) {
            return;
        }
        synchronized (this.d) {
            v vVarA = rVarA.a(str);
            Map<String, String> map = this.c;
            map.put(str, vVarA.a(map.get(str), str2));
        }
    }

    final Map<String, String> c() {
        synchronized (this.d) {
            r rVarA = com.google.android.gms.ads.internal.ax.i().a();
            if (rVarA != null && this.f != null) {
                return rVarA.a(this.c, this.f.c());
            }
            return this.c;
        }
    }

    public final z d() {
        synchronized (this.d) {
        }
        return null;
    }
}
