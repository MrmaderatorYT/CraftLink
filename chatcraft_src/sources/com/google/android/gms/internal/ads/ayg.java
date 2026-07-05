package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class ayg extends azd {
    public ayg(axt axtVar, String str, String str2, akp akpVar, int i, int i2) {
        super(axtVar, str, str2, akpVar, i, 49);
    }

    @Override // com.google.android.gms.internal.ads.azd
    protected final void a() throws InvocationTargetException {
        this.f2415b.F = 2;
        try {
            this.f2415b.F = Integer.valueOf(((Boolean) this.c.invoke(null, this.f2414a.a())).booleanValue() ? 1 : 0);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
