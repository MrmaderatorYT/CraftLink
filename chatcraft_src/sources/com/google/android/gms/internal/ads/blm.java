package com.google.android.gms.internal.ads;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes.dex */
final class blm extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ blj f2809a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public blm(blj bljVar, Handler handler) {
        super(handler);
        this.f2809a = bljVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        this.f2809a.a();
    }
}
