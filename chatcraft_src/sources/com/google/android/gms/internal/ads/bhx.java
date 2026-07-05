package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
public final class bhx extends bhu {
    private final Uri e;
    private final long f;
    private final String g;
    private final bht h;
    private final bie i;

    public bhx(String str, long j, bab babVar, String str2, bid bidVar, List<bhr> list, String str3, long j2) {
        String string;
        super(str, -1L, babVar, str2, bidVar, list);
        this.e = Uri.parse(str2);
        this.h = bidVar.e <= 0 ? null : new bht(null, bidVar.d, bidVar.e);
        if (str != null) {
            String str4 = babVar.f2442a;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(str4).length());
            sb.append(str);
            sb.append(".");
            sb.append(str4);
            sb.append(".-1");
            string = sb.toString();
        } else {
            string = null;
        }
        this.g = string;
        this.f = -1L;
        this.i = this.h == null ? new bie(new bht(null, 0L, -1L)) : null;
    }

    @Override // com.google.android.gms.internal.ads.bhu
    public final bht d() {
        return this.h;
    }

    @Override // com.google.android.gms.internal.ads.bhu
    public final bhi e() {
        return this.i;
    }

    @Override // com.google.android.gms.internal.ads.bhu
    public final String f() {
        return this.g;
    }
}
