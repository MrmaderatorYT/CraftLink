package org.xbill.DNS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TXTBase.java */
/* loaded from: classes.dex */
abstract class cr extends bt {

    /* renamed from: a, reason: collision with root package name */
    protected List f5389a;

    protected cr() {
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) {
        this.f5389a = new ArrayList(2);
        while (tVar.b() > 0) {
            this.f5389a.add(tVar.k());
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.f5389a.iterator();
        while (it.hasNext()) {
            stringBuffer.append(a((byte[]) it.next(), true));
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        Iterator it = this.f5389a.iterator();
        while (it.hasNext()) {
            vVar.b((byte[]) it.next());
        }
    }
}
