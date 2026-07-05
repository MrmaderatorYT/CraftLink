package org.xbill.DNS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: OPTRecord.java */
/* loaded from: classes.dex */
public class bi extends bt {

    /* renamed from: a, reason: collision with root package name */
    private List f5346a;

    bi() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new bi();
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) throws WireParseException {
        if (tVar.b() > 0) {
            this.f5346a = new ArrayList();
        }
        while (tVar.b() > 0) {
            this.f5346a.add(x.b(tVar));
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f5346a != null) {
            stringBuffer.append(this.f5346a);
            stringBuffer.append(" ");
        }
        stringBuffer.append(" ; payload ");
        stringBuffer.append(d());
        stringBuffer.append(", xrcode ");
        stringBuffer.append(e());
        stringBuffer.append(", version ");
        stringBuffer.append(f());
        stringBuffer.append(", flags ");
        stringBuffer.append(g());
        return stringBuffer.toString();
    }

    public int d() {
        return this.i;
    }

    public int e() {
        return (int) (this.j >>> 24);
    }

    public int f() {
        return (int) ((this.j >>> 16) & 255);
    }

    public int g() {
        return (int) (this.j & 65535);
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        if (this.f5346a == null) {
            return;
        }
        Iterator it = this.f5346a.iterator();
        while (it.hasNext()) {
            ((x) it.next()).b(vVar);
        }
    }

    @Override // org.xbill.DNS.bt
    public boolean equals(Object obj) {
        return super.equals(obj) && this.j == ((bi) obj).j;
    }
}
