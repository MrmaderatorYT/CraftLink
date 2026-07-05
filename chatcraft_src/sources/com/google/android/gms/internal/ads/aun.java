package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aun;

/* loaded from: classes.dex */
public abstract class aun<M extends aun<M>> extends aus {
    protected aup Z;

    @Override // com.google.android.gms.internal.ads.aus
    protected int a() {
        if (this.Z == null) {
            return 0;
        }
        int iA = 0;
        for (int i = 0; i < this.Z.a(); i++) {
            iA += this.Z.b(i).a();
        }
        return iA;
    }

    @Override // com.google.android.gms.internal.ads.aus
    public void a(aum aumVar) {
        if (this.Z == null) {
            return;
        }
        for (int i = 0; i < this.Z.a(); i++) {
            this.Z.b(i).a(aumVar);
        }
    }

    protected final boolean a(aul aulVar, int i) {
        int iJ = aulVar.j();
        if (!aulVar.b(i)) {
            return false;
        }
        int i2 = i >>> 3;
        auv auvVar = new auv(i, aulVar.a(iJ, aulVar.j() - iJ));
        auq auqVarA = null;
        if (this.Z == null) {
            this.Z = new aup();
        } else {
            auqVarA = this.Z.a(i2);
        }
        if (auqVarA == null) {
            auqVarA = new auq();
            this.Z.a(i2, auqVarA);
        }
        auqVarA.a(auvVar);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.aus
    /* renamed from: c */
    public final /* synthetic */ aus clone() {
        return (aun) clone();
    }

    @Override // com.google.android.gms.internal.ads.aus
    public /* synthetic */ Object clone() {
        aun aunVar = (aun) super.clone();
        aur.a(this, aunVar);
        return aunVar;
    }
}
