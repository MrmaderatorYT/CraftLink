package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;

/* loaded from: classes.dex */
final class bfm {

    /* renamed from: a, reason: collision with root package name */
    private final bcc[] f2620a;

    /* renamed from: b, reason: collision with root package name */
    private final bcf f2621b;
    private bcc c;

    public bfm(bcc[] bccVarArr, bcf bcfVar) {
        this.f2620a = bccVarArr;
        this.f2621b = bcfVar;
    }

    public final bcc a(bce bceVar, Uri uri) throws zzmb {
        if (this.c != null) {
            return this.c;
        }
        bcc[] bccVarArr = this.f2620a;
        int length = bccVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            bcc bccVar = bccVarArr[i];
            try {
            } catch (EOFException unused) {
            } finally {
                bceVar.a();
            }
            if (bccVar.a(bceVar)) {
                this.c = bccVar;
                break;
            }
            i++;
        }
        if (this.c == null) {
            String strA = bkg.a(this.f2620a);
            StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 58);
            sb.append("None of the available extractors (");
            sb.append(strA);
            sb.append(") could read the stream.");
            throw new zzmb(sb.toString(), uri);
        }
        this.c.a(this.f2621b);
        return this.c;
    }

    public final void a() {
        if (this.c != null) {
            this.c.c();
            this.c = null;
        }
    }
}
