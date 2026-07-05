package org.xbill.DNS;

/* compiled from: SRVRecord.java */
/* loaded from: classes.dex */
public class cd extends bt {

    /* renamed from: a, reason: collision with root package name */
    private int f5368a;

    /* renamed from: b, reason: collision with root package name */
    private int f5369b;
    private int c;
    private bg d;

    cd() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new cd();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5368a = tVar.h();
        this.f5369b = tVar.h();
        this.c = tVar.h();
        this.d = new bg(tVar);
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(this.f5368a);
        stringBuffer2.append(" ");
        stringBuffer.append(stringBuffer2.toString());
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(this.f5369b);
        stringBuffer3.append(" ");
        stringBuffer.append(stringBuffer3.toString());
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append(this.c);
        stringBuffer4.append(" ");
        stringBuffer.append(stringBuffer4.toString());
        stringBuffer.append(this.d);
        return stringBuffer.toString();
    }

    public int d() {
        return this.c;
    }

    public bg e() {
        return this.d;
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        vVar.c(this.f5368a);
        vVar.c(this.f5369b);
        vVar.c(this.c);
        this.d.a(vVar, (n) null, z);
    }

    @Override // org.xbill.DNS.bt
    public bg c() {
        return this.d;
    }
}
