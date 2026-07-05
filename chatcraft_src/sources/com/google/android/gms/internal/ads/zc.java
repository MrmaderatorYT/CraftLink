package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
final class zc<T> implements aav<bje, T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zf f3627a;

    zc(yz yzVar, zf zfVar) {
        this.f3627a = zfVar;
    }

    @Override // com.google.android.gms.internal.ads.aav
    public final /* synthetic */ Object a(bje bjeVar) {
        return this.f3627a.a(new ByteArrayInputStream(bjeVar.f2728b));
    }
}
