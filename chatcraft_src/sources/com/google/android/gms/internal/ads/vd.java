package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class vd extends blc<String> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3515a;

    /* renamed from: b, reason: collision with root package name */
    private bth<String> f3516b;

    public vd(int i, String str, bth<String> bthVar, bsh bshVar) {
        super(i, str, bshVar);
        this.f3515a = new Object();
        this.f3516b = bthVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.blc
    public void a(String str) {
        bth<String> bthVar;
        synchronized (this.f3515a) {
            bthVar = this.f3516b;
        }
        if (bthVar != null) {
            bthVar.a(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.blc
    protected final brg<String> a(bje bjeVar) {
        String str;
        try {
            byte[] bArr = bjeVar.f2728b;
            String str2 = "ISO-8859-1";
            String str3 = bjeVar.c.get("Content-Type");
            if (str3 != null) {
                String[] strArrSplit = str3.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= strArrSplit.length) {
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str2 = strArrSplit2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(bjeVar.f2728b);
        }
        return brg.a(str, nx.a(bjeVar));
    }
}
