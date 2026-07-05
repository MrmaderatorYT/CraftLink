package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.b.c;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
public final class cg extends c.b {

    /* renamed from: a, reason: collision with root package name */
    private final cd f3045a;

    /* renamed from: b, reason: collision with root package name */
    private final Drawable f3046b;
    private final Uri c;
    private final double d;

    public cg(cd cdVar) {
        com.google.android.gms.dynamic.a aVarA;
        this.f3045a = cdVar;
        Uri uriB = null;
        try {
            aVarA = this.f3045a.a();
        } catch (RemoteException e) {
            aan.b(BuildConfig.FLAVOR, e);
        }
        Drawable drawable = aVarA != null ? (Drawable) com.google.android.gms.dynamic.b.a(aVarA) : null;
        this.f3046b = drawable;
        try {
            uriB = this.f3045a.b();
        } catch (RemoteException e2) {
            aan.b(BuildConfig.FLAVOR, e2);
        }
        this.c = uriB;
        double dC = 1.0d;
        try {
            dC = this.f3045a.c();
        } catch (RemoteException e3) {
            aan.b(BuildConfig.FLAVOR, e3);
        }
        this.d = dC;
    }

    @Override // com.google.android.gms.ads.b.c.b
    public final Drawable a() {
        return this.f3046b;
    }

    @Override // com.google.android.gms.ads.b.c.b
    public final Uri b() {
        return this.c;
    }

    @Override // com.google.android.gms.ads.b.c.b
    public final double c() {
        return this.d;
    }
}
