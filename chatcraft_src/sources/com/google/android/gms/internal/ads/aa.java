package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, z> f1772a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final ac f1773b;

    public aa(ac acVar) {
        this.f1773b = acVar;
    }

    public final void a(String str, z zVar) {
        this.f1772a.put(str, zVar);
    }

    public final void a(String str, String str2, long j) {
        ac acVar = this.f1773b;
        z zVar = this.f1772a.get(str2);
        String[] strArr = {str};
        if (acVar != null && zVar != null) {
            acVar.a(zVar, j, strArr);
        }
        Map<String, z> map = this.f1772a;
        ac acVar2 = this.f1773b;
        map.put(str, acVar2 == null ? null : acVar2.a(j));
    }

    public final ac a() {
        return this.f1773b;
    }
}
