package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class aex {

    /* renamed from: a, reason: collision with root package name */
    protected Context f1915a;

    /* renamed from: b, reason: collision with root package name */
    protected String f1916b;
    protected WeakReference<adk> c;

    public aex(adk adkVar) {
        this.f1915a = adkVar.getContext();
        this.f1916b = com.google.android.gms.ads.internal.ax.e().b(this.f1915a, adkVar.k().f1790a);
        this.c = new WeakReference<>(adkVar);
    }

    public abstract void a();

    protected void a(int i) {
    }

    public abstract boolean a(String str);

    public void b() {
    }

    protected void c(int i) {
    }

    protected void d(int i) {
    }

    protected void e(int i) {
    }

    public final void a(String str, String str2, long j, long j2, boolean z, int i, int i2) {
        aac.f1778a.post(new aez(this, str, str2, j, j2, z, i, i2));
    }

    protected final void a(String str, String str2, int i) {
        aac.f1778a.post(new afa(this, str, str2, i));
    }

    public final void a(String str, String str2, long j) {
        aac.f1778a.post(new afb(this, str, str2, j));
    }

    public final void a(String str, String str2, String str3, String str4) {
        aac.f1778a.post(new afc(this, str, str2, str3, str4));
    }

    protected String b(String str) {
        bra.a();
        return aac.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(java.lang.String r2) {
        /*
            java.lang.String r0 = "internal"
            int r1 = r2.hashCode()
            switch(r1) {
                case -1947652542: goto L7f;
                case -1396664534: goto L74;
                case -1347010958: goto L6a;
                case -918817863: goto L5f;
                case -659376217: goto L55;
                case -642208130: goto L4b;
                case -354048396: goto L40;
                case -32082395: goto L35;
                case 3387234: goto L2b;
                case 96784904: goto L21;
                case 580119100: goto L16;
                case 725497484: goto Lb;
                default: goto L9;
            }
        L9:
            goto L89
        Lb:
            java.lang.String r1 = "noCacheDir"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 7
            goto L8a
        L16:
            java.lang.String r1 = "expireFailed"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 6
            goto L8a
        L21:
            java.lang.String r1 = "error"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 1
            goto L8a
        L2b:
            java.lang.String r1 = "noop"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 4
            goto L8a
        L35:
            java.lang.String r1 = "externalAbort"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 10
            goto L8a
        L40:
            java.lang.String r1 = "sizeExceeded"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 11
            goto L8a
        L4b:
            java.lang.String r1 = "playerFailed"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 5
            goto L8a
        L55:
            java.lang.String r1 = "contentLengthMissing"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 0
            goto L8a
        L5f:
            java.lang.String r1 = "downloadTimeout"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 9
            goto L8a
        L6a:
            java.lang.String r1 = "inProgress"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 2
            goto L8a
        L74:
            java.lang.String r1 = "badUrl"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 8
            goto L8a
        L7f:
            java.lang.String r1 = "interrupted"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L89
            r2 = 3
            goto L8a
        L89:
            r2 = -1
        L8a:
            switch(r2) {
                case 0: goto L97;
                case 1: goto L97;
                case 2: goto L97;
                case 3: goto L97;
                case 4: goto L97;
                case 5: goto L97;
                case 6: goto L94;
                case 7: goto L94;
                case 8: goto L91;
                case 9: goto L91;
                case 10: goto L8e;
                case 11: goto L8e;
                default: goto L8d;
            }
        L8d:
            goto L99
        L8e:
            java.lang.String r0 = "policy"
            goto L99
        L91:
            java.lang.String r0 = "network"
            goto L99
        L94:
            java.lang.String r0 = "io"
            goto L99
        L97:
            java.lang.String r0 = "internal"
        L99:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aex.c(java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, Map<String, String> map) {
        adk adkVar = this.c.get();
        if (adkVar != null) {
            adkVar.a(str, map);
        }
    }
}
