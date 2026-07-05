package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zd implements bsh {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f3628a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zg f3629b;

    zd(yz yzVar, String str, zg zgVar) {
        this.f3628a = str;
        this.f3629b = zgVar;
    }

    @Override // com.google.android.gms.internal.ads.bsh
    public final void a(zzae zzaeVar) {
        String str = this.f3628a;
        String string = zzaeVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(string).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(string);
        xe.e(sb.toString());
        this.f3629b.a((zg) null);
    }
}
