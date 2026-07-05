package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.measurement.m;
import java.util.HashMap;

/* loaded from: classes.dex */
final class n extends m.b {
    private final /* synthetic */ Context c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;
    private final /* synthetic */ Bundle f;
    private final /* synthetic */ m g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    n(m mVar, Context context, String str, String str2, Bundle bundle) {
        super(mVar);
        this.g = mVar;
        this.c = context;
        this.d = str;
        this.e = str2;
        this.f = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.m.b
    public final void b() {
        String str;
        String str2;
        String str3;
        try {
            this.g.f = new HashMap();
            this.g.j = this.g.a(this.c);
            if (this.g.j == null) {
                Log.w(this.g.c, "Failed to connect to measurement client.");
                return;
            }
            m mVar = this.g;
            if (m.b(this.d, this.e)) {
                String str4 = this.e;
                str2 = this.d;
                str3 = str4;
                str = this.g.c;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            int iF = m.f(this.c);
            this.g.j.a(com.google.android.gms.dynamic.b.a(this.c), new k(13001L, Math.max(iF, r3), m.e(this.c) < iF, str, str2, str3, this.f), this.f3700a);
        } catch (RemoteException e) {
            this.g.a((Exception) e, true, false);
        }
    }
}
