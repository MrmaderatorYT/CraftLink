package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@qj
/* loaded from: classes.dex */
public final class aao {
    public static <T> T a(Context context, String str, aap<IBinder, T> aapVar) throws zzbbg {
        try {
            return aapVar.a(b(context).a(str));
        } catch (Exception e) {
            throw new zzbbg(e);
        }
    }

    public static Context a(Context context) {
        return b(context).a();
    }

    private static DynamiteModule b(Context context) throws zzbbg {
        try {
            return DynamiteModule.a(context, DynamiteModule.f1761a, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzbbg(e);
        }
    }
}
