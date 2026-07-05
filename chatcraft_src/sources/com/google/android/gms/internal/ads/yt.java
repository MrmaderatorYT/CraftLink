package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

@qj
/* loaded from: classes.dex */
public final class yt extends ic {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3615a;

    public static bpg a(Context context) {
        bpg bpgVar = new bpg(new le(new File(context.getCacheDir(), "admob_volley"), 20971520), new yt(context, new qz()));
        bpgVar.a();
        return bpgVar;
    }

    private yt(Context context, py pyVar) {
        super(pyVar);
        this.f3615a = context;
    }

    @Override // com.google.android.gms.internal.ads.ic, com.google.android.gms.internal.ads.bge
    public final bje a(blc<?> blcVar) throws zzae {
        if (blcVar.i() && blcVar.c() == 0) {
            if (Pattern.matches((String) bra.e().a(o.ce), blcVar.e())) {
                bra.a();
                if (aac.c(this.f3615a, 13400000)) {
                    bje bjeVarA = new es(this.f3615a).a(blcVar);
                    if (bjeVarA != null) {
                        String strValueOf = String.valueOf(blcVar.e());
                        xe.a(strValueOf.length() != 0 ? "Got gmscore asset response: ".concat(strValueOf) : new String("Got gmscore asset response: "));
                        return bjeVarA;
                    }
                    String strValueOf2 = String.valueOf(blcVar.e());
                    xe.a(strValueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(strValueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.a(blcVar);
    }
}
