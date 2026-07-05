package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class c implements DynamiteModule.a {
    c() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.b a(Context context, String str, DynamiteModule.a.InterfaceC0071a interfaceC0071a) {
        DynamiteModule.a.b bVar = new DynamiteModule.a.b();
        bVar.f1763a = interfaceC0071a.a(context, str);
        if (bVar.f1763a != 0) {
            bVar.c = -1;
        } else {
            bVar.f1764b = interfaceC0071a.a(context, str, true);
            if (bVar.f1764b != 0) {
                bVar.c = 1;
            }
        }
        return bVar;
    }
}
