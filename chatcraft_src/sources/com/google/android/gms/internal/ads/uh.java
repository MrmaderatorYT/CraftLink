package com.google.android.gms.internal.ads;

import android.os.RemoteException;

@qj
/* loaded from: classes.dex */
public final class uh implements com.google.android.gms.ads.reward.b {

    /* renamed from: a, reason: collision with root package name */
    private final tt f3487a;

    public uh(tt ttVar) {
        this.f3487a = ttVar;
    }

    @Override // com.google.android.gms.ads.reward.b
    public final String a() {
        if (this.f3487a == null) {
            return null;
        }
        try {
            return this.f3487a.a();
        } catch (RemoteException e) {
            aan.c("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.b
    public final int b() {
        if (this.f3487a == null) {
            return 0;
        }
        try {
            return this.f3487a.b();
        } catch (RemoteException e) {
            aan.c("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
