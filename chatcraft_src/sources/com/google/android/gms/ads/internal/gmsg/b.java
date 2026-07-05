package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.qj;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class b implements ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1591a;

    public b(Context context) {
        this.f1591a = context;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (ax.E().a(this.f1591a)) {
            ax.E().a(this.f1591a, map.get("eventName"), map.get("eventId"));
        }
    }
}
