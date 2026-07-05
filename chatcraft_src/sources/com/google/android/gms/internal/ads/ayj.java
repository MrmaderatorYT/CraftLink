package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class ayj extends azd {
    private static final aze<aut> d = new aze<>();
    private final Context e;
    private aho f;

    public ayj(axt axtVar, String str, String str2, akp akpVar, int i, int i2, Context context, aho ahoVar) {
        super(axtVar, str, str2, akpVar, i, 27);
        this.f = null;
        this.e = context;
        this.f = ahoVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    @Override // com.google.android.gms.internal.ads.azd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void a() {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ayj.a():void");
    }

    private final String c() throws ExecutionException, InterruptedException {
        try {
            if (this.f2414a.l() != null) {
                this.f2414a.l().get();
            }
            akp akpVarK = this.f2414a.k();
            if (akpVarK == null || akpVarK.n == null) {
                return null;
            }
            return akpVarK.n;
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }
}
