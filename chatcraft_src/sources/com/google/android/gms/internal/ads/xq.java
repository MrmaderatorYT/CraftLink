package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
final class xq implements an {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ List f3589a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ am f3590b;
    private final /* synthetic */ Context c;

    xq(xn xnVar, List list, am amVar, Context context) {
        this.f3589a = list;
        this.f3590b = amVar;
        this.c = context;
    }

    @Override // com.google.android.gms.internal.ads.an
    public final void b() {
    }

    @Override // com.google.android.gms.internal.ads.an
    public final void a() {
        for (String str : this.f3589a) {
            String strValueOf = String.valueOf(str);
            xe.d(strValueOf.length() != 0 ? "Pinging url: ".concat(strValueOf) : new String("Pinging url: "));
            this.f3590b.a(Uri.parse(str), null, null);
        }
        this.f3590b.a((Activity) this.c);
    }
}
