package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class jj<I, O> implements ix<I, O> {

    /* renamed from: a, reason: collision with root package name */
    private final iz<O> f3196a;

    /* renamed from: b, reason: collision with root package name */
    private final ja<I> f3197b;
    private final hv c;
    private final String d;

    jj(hv hvVar, String str, ja<I> jaVar, iz<O> izVar) {
        this.c = hvVar;
        this.d = str;
        this.f3197b = jaVar;
        this.f3196a = izVar;
    }

    @Override // com.google.android.gms.internal.ads.ix
    public final abl<O> b(I i) {
        abv abvVar = new abv();
        il ilVarB = this.c.b((axe) null);
        ilVarB.a(new jk(this, ilVarB, i, abvVar), new jl(this, abvVar, ilVarB));
        return abvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(il ilVar, iu iuVar, I i, abv<O> abvVar) throws JSONException {
        try {
            com.google.android.gms.ads.internal.ax.e();
            String strA = xn.a();
            com.google.android.gms.ads.internal.gmsg.n.o.a(strA, new jm(this, ilVar, abvVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", strA);
            jSONObject.put("args", this.f3197b.a(i));
            iuVar.b(this.d, jSONObject);
        } catch (Exception e) {
            try {
                abvVar.a(e);
                xe.b("Unable to invokeJavaScript", e);
            } finally {
                ilVar.a();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.aau
    public final abl<O> a(@Nullable I i) {
        return b(i);
    }
}
