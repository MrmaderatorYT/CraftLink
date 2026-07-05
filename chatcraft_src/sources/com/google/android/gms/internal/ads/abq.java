package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

@qj
/* loaded from: classes.dex */
public final class abq {

    /* renamed from: a, reason: collision with root package name */
    public static final Executor f1816a = new abr();

    /* renamed from: b, reason: collision with root package name */
    public static final Executor f1817b = new abs();
    private static final abp c = a(f1816a);
    private static final abp d = a(f1817b);

    public static abp a(Executor executor) {
        return new abt(executor, null);
    }
}
