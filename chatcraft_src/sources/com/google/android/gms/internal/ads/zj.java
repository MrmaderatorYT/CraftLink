package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public final class zj extends blc<bje> {

    /* renamed from: a, reason: collision with root package name */
    private final abv<bje> f3632a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f3633b;
    private final aag c;

    public zj(String str, abv<bje> abvVar) {
        this(str, null, abvVar);
    }

    private zj(String str, Map<String, String> map, abv<bje> abvVar) throws IOException {
        super(0, str, new zk(abvVar));
        this.f3633b = null;
        this.f3632a = abvVar;
        this.c = new aag();
        this.c.a(str, "GET", null, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.blc
    protected final brg<bje> a(bje bjeVar) {
        return brg.a(bjeVar, nx.a(bjeVar));
    }

    @Override // com.google.android.gms.internal.ads.blc
    protected final /* synthetic */ void a(bje bjeVar) throws IOException {
        bje bjeVar2 = bjeVar;
        this.c.a(bjeVar2.c, bjeVar2.f2727a);
        aag aagVar = this.c;
        byte[] bArr = bjeVar2.f2728b;
        if (aag.c() && bArr != null) {
            aagVar.a(bArr);
        }
        this.f3632a.b(bjeVar2);
    }
}
