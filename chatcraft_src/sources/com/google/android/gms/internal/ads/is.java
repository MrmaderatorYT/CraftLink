package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class is implements aca<hk> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ip f3180a;

    is(ip ipVar) {
        this.f3180a = ipVar;
    }

    @Override // com.google.android.gms.internal.ads.aca
    public final /* synthetic */ void a(hk hkVar) {
        final hk hkVar2 = hkVar;
        abq.f1816a.execute(new Runnable(this, hkVar2) { // from class: com.google.android.gms.internal.ads.it

            /* renamed from: a, reason: collision with root package name */
            private final is f3181a;

            /* renamed from: b, reason: collision with root package name */
            private final hk f3182b;

            {
                this.f3181a = this;
                this.f3182b = hkVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                is isVar = this.f3181a;
                hk hkVar3 = this.f3182b;
                isVar.f3180a.f3177b.a(hkVar3);
                hkVar3.a();
            }
        });
    }
}
