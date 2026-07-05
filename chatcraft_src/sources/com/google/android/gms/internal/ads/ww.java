package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class ww {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private BigInteger f3563a = BigInteger.ONE;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private String f3564b = "0";

    public final synchronized String a() {
        String string;
        string = this.f3563a.toString();
        this.f3563a = this.f3563a.add(BigInteger.ONE);
        this.f3564b = string;
        return string;
    }

    public final synchronized String b() {
        return this.f3564b;
    }
}
