package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: classes.dex */
final class bme implements com.google.android.gms.ads.internal.gmsg.ac<iu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ blv f2833a;

    bme(blv blvVar) {
        this.f2833a = blvVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(iu iuVar, Map map) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        iu iuVar2 = iuVar;
        if (this.f2833a.f2820a.a((Map<String, String>) map)) {
            this.f2833a.c.zza(iuVar2, map);
        }
    }
}
