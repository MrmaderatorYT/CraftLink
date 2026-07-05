package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
final class ze extends vd {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ byte[] f3630a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Map f3631b;
    private final /* synthetic */ aag c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ze(yz yzVar, int i, String str, bth bthVar, bsh bshVar, byte[] bArr, Map map, aag aagVar) {
        super(i, str, bthVar, bshVar);
        this.f3630a = bArr;
        this.f3631b = map;
        this.c = aagVar;
    }

    @Override // com.google.android.gms.internal.ads.blc
    public final byte[] a() {
        return this.f3630a == null ? super.a() : this.f3630a;
    }

    @Override // com.google.android.gms.internal.ads.blc
    public final Map<String, String> b() {
        return this.f3631b == null ? super.b() : this.f3631b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.vd
    public final void a(String str) throws IOException {
        this.c.a(str);
        super.a(str);
    }

    @Override // com.google.android.gms.internal.ads.vd, com.google.android.gms.internal.ads.blc
    protected final /* synthetic */ void a(String str) {
        a(str);
    }
}
