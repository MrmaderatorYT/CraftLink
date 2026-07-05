package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
final class azv extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ azu f2430a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    azv(azu azuVar, Looper looper) {
        super(looper);
        this.f2430a = azuVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f2430a.a(message);
    }
}
