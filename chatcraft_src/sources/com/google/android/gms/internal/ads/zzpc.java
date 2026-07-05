package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
public class zzpc extends IOException {

    /* renamed from: a, reason: collision with root package name */
    private final int f3676a;

    /* renamed from: b, reason: collision with root package name */
    private final bjd f3677b;

    public zzpc(String str, bjd bjdVar, int i) {
        super(str);
        this.f3677b = bjdVar;
        this.f3676a = 1;
    }

    public zzpc(IOException iOException, bjd bjdVar, int i) {
        super(iOException);
        this.f3677b = bjdVar;
        this.f3676a = i;
    }

    public zzpc(String str, IOException iOException, bjd bjdVar, int i) {
        super(str, iOException);
        this.f3677b = bjdVar;
        this.f3676a = 1;
    }
}
