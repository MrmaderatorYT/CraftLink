package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

@qj
/* loaded from: classes.dex */
public final class afi extends aex implements bjp<bja> {
    private String d;
    private final adj e;
    private boolean f;
    private final afh g;
    private final aep h;
    private ByteBuffer i;
    private boolean j;
    private final Object k;
    private boolean l;

    public afi(adk adkVar, adj adjVar) {
        super(adkVar);
        this.e = adjVar;
        this.g = new afh();
        this.h = new aep();
        this.k = new Object();
    }

    @Override // com.google.android.gms.internal.ads.bjp
    public final /* bridge */ /* synthetic */ void a(bja bjaVar) {
    }

    @Override // com.google.android.gms.internal.ads.bjp
    public final /* bridge */ /* synthetic */ void a(bja bjaVar, int i) {
    }

    public final String c() {
        return this.d;
    }

    public final boolean d() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.aex
    protected final String b(String str) {
        String strValueOf = String.valueOf("cache:");
        String strValueOf2 = String.valueOf(super.b(str));
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    private final void f() {
        int iA = (int) this.g.a();
        int iA2 = (int) this.h.a(this.i);
        int iRound = Math.round(iA2 * (this.i.position() / iA));
        a(this.d, b(this.d), iRound, iA2, iRound > 0, aee.b(), aee.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004b A[Catch: Exception -> 0x0032, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0032, blocks: (B:5:0x0028, B:11:0x004b, B:17:0x0098, B:42:0x00f1, B:43:0x010c, B:45:0x010f, B:46:0x0132), top: B:66:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9 A[Catch: Exception -> 0x013e, TRY_ENTER, TryCatch #0 {Exception -> 0x013e, blocks: (B:3:0x000d, B:9:0x0035, B:12:0x004e, B:13:0x0086, B:19:0x00a9, B:20:0x00ab), top: B:59:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:? -> B:53:0x013c). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.aex
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.afi.a(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.aex
    public final void a() {
        this.f = true;
    }

    public final ByteBuffer e() {
        synchronized (this.k) {
            if (this.i != null && !this.j) {
                this.i.flip();
                this.j = true;
            }
            this.f = true;
        }
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.bjp
    public final /* synthetic */ void a(bja bjaVar, bjd bjdVar) {
        bja bjaVar2 = bjaVar;
        if (bjaVar2 instanceof bjg) {
            this.g.a((bjg) bjaVar2);
        }
    }
}
