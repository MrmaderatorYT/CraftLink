package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* loaded from: classes.dex */
public class zi extends avs implements Closeable {
    private static awb f = awb.a(zi.class);

    public zi(avv avvVar, yg ygVar) {
        a(avvVar, avvVar.a(), ygVar);
    }

    @Override // com.google.android.gms.internal.ads.avs, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2326b.close();
    }

    @Override // com.google.android.gms.internal.ads.avs
    public String toString() {
        String string = this.f2326b.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 7);
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }
}
