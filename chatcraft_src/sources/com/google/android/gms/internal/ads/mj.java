package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class mj extends me {

    /* renamed from: a, reason: collision with root package name */
    private final aii f3262a;

    public mj(aii aiiVar) {
        this.f3262a = aiiVar;
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(String str, String str2, Bundle bundle, com.google.android.gms.dynamic.a aVar, lu luVar, kq kqVar, bqn bqnVar) throws RemoteException {
        try {
            mk mkVar = new mk(this, luVar, kqVar);
            aii aiiVar = this.f3262a;
            new aih((Context) com.google.android.gms.dynamic.b.a(aVar), str, b(str2), bundle);
            com.google.android.gms.ads.n.a(bqnVar.e, bqnVar.f2975b, bqnVar.f2974a);
            mkVar.a(String.valueOf(aiiVar.getClass().getSimpleName()).concat(" does not support banner ads."));
        } catch (Throwable th) {
            aan.b("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(String str, String str2, Bundle bundle, com.google.android.gms.dynamic.a aVar, lx lxVar, kq kqVar) throws RemoteException {
        try {
            ml mlVar = new ml(this, lxVar, kqVar);
            aii aiiVar = this.f3262a;
            new aih((Context) com.google.android.gms.dynamic.b.a(aVar), str, b(str2), bundle);
            mlVar.a(String.valueOf(aiiVar.getClass().getSimpleName()).concat(" does not support interstitial ads."));
        } catch (Throwable th) {
            aan.b("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(String str, String str2, Bundle bundle, com.google.android.gms.dynamic.a aVar, mb mbVar, kq kqVar) throws RemoteException {
        try {
            mm mmVar = new mm(this, mbVar, kqVar);
            aii aiiVar = this.f3262a;
            new aih((Context) com.google.android.gms.dynamic.b.a(aVar), str, b(str2), bundle);
            mmVar.a(String.valueOf(aiiVar.getClass().getSimpleName()).concat(" does not support rewarded ads."));
        } catch (Throwable th) {
            aan.b("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(String str, String str2, Bundle bundle, com.google.android.gms.dynamic.a aVar, lz lzVar, kq kqVar) throws RemoteException {
        try {
            mn mnVar = new mn(this, lzVar, kqVar);
            aii aiiVar = this.f3262a;
            new aih((Context) com.google.android.gms.dynamic.b.a(aVar), str, b(str2), bundle);
            mnVar.a(String.valueOf(aiiVar.getClass().getSimpleName()).concat(" does not support native ads."));
        } catch (Throwable th) {
            aan.b("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void d() throws RemoteException {
        aif aifVar = null;
        try {
            aifVar.a();
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void e() throws RemoteException {
        aig aigVar = null;
        try {
            aigVar.a();
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.md
    public final bsw c() {
        if (!(this.f3262a instanceof com.google.android.gms.ads.mediation.n)) {
            return null;
        }
        try {
            return ((com.google.android.gms.ads.mediation.n) this.f3262a).getVideoController();
        } catch (Throwable th) {
            aan.b(BuildConfig.FLAVOR, th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.aik, com.google.android.gms.internal.ads.mo] */
    @Override // com.google.android.gms.internal.ads.md
    public final void a(com.google.android.gms.dynamic.a aVar, String str, Bundle bundle, Bundle bundle2, bqn bqnVar, mg mgVar) throws RemoteException {
        try {
            ?? moVar = new mo(this, mgVar);
            this.f3262a.a(new aij((Context) com.google.android.gms.dynamic.b.a(aVar), new com.google.android.gms.ads.mediation.m(a(str), bundle2), bundle, com.google.android.gms.ads.n.a(bqnVar.e, bqnVar.f2975b, bqnVar.f2974a)), moVar);
        } catch (Throwable th) {
            aan.b("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.md
    public final mp a() {
        return mp.a(this.f3262a.b());
    }

    @Override // com.google.android.gms.internal.ads.md
    public final mp b() {
        return mp.a(this.f3262a.a());
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(com.google.android.gms.dynamic.a aVar) {
        this.f3262a.a((Context) com.google.android.gms.dynamic.b.a(aVar));
    }

    @Override // com.google.android.gms.internal.ads.md
    public final void a(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            try {
                arrayList.add(new com.google.android.gms.ads.mediation.m(a(strArr[i]), bundleArr[i]));
            } catch (IndexOutOfBoundsException unused) {
                throw new RemoteException();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int a(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            r1 = -1396342996(0xffffffffacc57f2c, float:-5.6131957E-12)
            if (r0 == r1) goto L37
            r1 = -1052618729(0xffffffffc1425017, float:-12.144553)
            if (r0 == r1) goto L2d
            r1 = -239580146(0xfffffffff1b84c0e, float:-1.82519E30)
            if (r0 == r1) goto L23
            r1 = 604727084(0x240b672c, float:3.022821E-17)
            if (r0 == r1) goto L19
            goto L41
        L19:
            java.lang.String r0 = "interstitial"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L41
            r2 = 1
            goto L42
        L23:
            java.lang.String r0 = "rewarded"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L41
            r2 = 2
            goto L42
        L2d:
            java.lang.String r0 = "native"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L41
            r2 = 3
            goto L42
        L37:
            java.lang.String r0 = "banner"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L41
            r2 = 0
            goto L42
        L41:
            r2 = -1
        L42:
            switch(r2) {
                case 0: goto L56;
                case 1: goto L53;
                case 2: goto L50;
                case 3: goto L4d;
                default: goto L45;
            }
        L45:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Internal Error"
            r2.<init>(r0)
            throw r2
        L4d:
            int r2 = com.google.android.gms.ads.l.d
            return r2
        L50:
            int r2 = com.google.android.gms.ads.l.c
            return r2
        L53:
            int r2 = com.google.android.gms.ads.l.f1664b
            return r2
        L56:
            int r2 = com.google.android.gms.ads.l.f1663a
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.mj.a(java.lang.String):int");
    }

    private static Bundle b(String str) throws RemoteException {
        String strValueOf = String.valueOf(str);
        aan.e(strValueOf.length() != 0 ? "Server parameters: ".concat(strValueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            aan.b(BuildConfig.FLAVOR, e);
            throw new RemoteException();
        }
    }
}
