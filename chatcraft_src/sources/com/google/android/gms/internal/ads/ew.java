package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.b;

/* loaded from: classes.dex */
final class ew implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ abv f3075a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ es f3076b;

    ew(es esVar, abv abvVar) {
        this.f3076b = esVar;
        this.f3075a = abvVar;
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void a(Bundle bundle) {
        try {
            this.f3075a.b(this.f3076b.f3070a.t());
        } catch (DeadObjectException e) {
            this.f3075a.a(e);
        }
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void a(int i) {
        abv abvVar = this.f3075a;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        abvVar.a(new RuntimeException(sb.toString()));
    }
}
