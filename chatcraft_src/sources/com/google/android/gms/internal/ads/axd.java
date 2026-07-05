package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class axd extends axc {
    public static axd a(String str, Context context, boolean z) {
        a(context, z);
        return new axd(context, str, z);
    }

    private axd(Context context, String str, boolean z) {
        super(context, str, z);
    }

    @Override // com.google.android.gms.internal.ads.axc
    protected final List<Callable<Void>> a(axt axtVar, Context context, akp akpVar, aho ahoVar) {
        if (axtVar.c() == null || !this.r) {
            return super.a(axtVar, context, akpVar, ahoVar);
        }
        int iN = axtVar.n();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.a(axtVar, context, akpVar, ahoVar));
        arrayList.add(new ayn(axtVar, "DPtJycwRqj/e0TdTHULzeUhZhWJ1IU3iwhH90sUbn4eYKEdB5HI7UC0PtJgg2RSN", "Ye7G7hL63+8nOBoyCAHdjfK62rvCOKz3+aC1KA/K9CI=", akpVar, iN, 24));
        return arrayList;
    }
}
