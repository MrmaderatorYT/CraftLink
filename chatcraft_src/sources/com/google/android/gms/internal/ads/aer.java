package com.google.android.gms.internal.ads;

@qj
/* loaded from: classes.dex */
final class aer extends we {

    /* renamed from: a, reason: collision with root package name */
    static final aer f1909a = new aer();

    aer() {
    }

    @Override // com.google.android.gms.internal.ads.we
    public final abj a(String str, byte[] bArr, String str2) {
        return "moov".equals(str) ? new adl() : "mvhd".equals(str) ? new aem() : new afn(str);
    }
}
