package org.xbill.DNS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: RRset.java */
/* loaded from: classes.dex */
public class bq implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private List f5353a;

    /* renamed from: b, reason: collision with root package name */
    private short f5354b;
    private short c;

    public bq() {
        this.f5353a = new ArrayList(1);
        this.f5354b = (short) 0;
        this.c = (short) 0;
    }

    public bq(bt btVar) {
        this();
        b(btVar);
    }

    public bq(bq bqVar) {
        synchronized (bqVar) {
            this.f5353a = (List) ((ArrayList) bqVar.f5353a).clone();
            this.f5354b = bqVar.f5354b;
            this.c = bqVar.c;
        }
    }

    private void b(bt btVar) {
        if (!(btVar instanceof bp)) {
            if (this.f5354b == 0) {
                this.f5353a.add(btVar);
                return;
            } else {
                this.f5353a.add(this.f5353a.size() - this.f5354b, btVar);
                return;
            }
        }
        this.f5353a.add(btVar);
        this.f5354b = (short) (this.f5354b + 1);
    }

    public synchronized void a(bt btVar) {
        if (this.f5353a.size() == 0) {
            b(btVar);
            return;
        }
        bt btVarG = g();
        if (!btVar.a(btVarG)) {
            throw new IllegalArgumentException("record does not match rrset");
        }
        if (btVar.n() != btVarG.n()) {
            if (btVar.n() > btVarG.n()) {
                btVar = btVar.o();
                btVar.a(btVarG.n());
            } else {
                for (int i = 0; i < this.f5353a.size(); i++) {
                    bt btVarO = ((bt) this.f5353a.get(i)).o();
                    btVarO.a(btVar.n());
                    this.f5353a.set(i, btVarO);
                }
            }
        }
        if (!this.f5353a.contains(btVar)) {
            b(btVar);
        }
    }

    private synchronized Iterator a(boolean z, boolean z2) {
        int i;
        int i2;
        int size = this.f5353a.size();
        if (z) {
            i = size - this.f5354b;
        } else {
            i = this.f5354b;
        }
        if (i == 0) {
            return Collections.EMPTY_LIST.iterator();
        }
        if (!z) {
            i2 = size - this.f5354b;
        } else if (z2) {
            if (this.c >= i) {
                this.c = (short) 0;
            }
            i2 = this.c;
            this.c = (short) (i2 + 1);
        } else {
            i2 = 0;
        }
        ArrayList arrayList = new ArrayList(i);
        if (z) {
            arrayList.addAll(this.f5353a.subList(i2, i));
            if (i2 != 0) {
                arrayList.addAll(this.f5353a.subList(0, i2));
            }
        } else {
            arrayList.addAll(this.f5353a.subList(i2, size));
        }
        return arrayList.iterator();
    }

    public synchronized Iterator c() {
        return a(true, true);
    }

    public bg d() {
        return g().j();
    }

    public int b() {
        return g().l();
    }

    public int e() {
        return g().m();
    }

    public synchronized long f() {
        return g().n();
    }

    public synchronized bt g() {
        if (this.f5353a.size() == 0) {
            throw new IllegalStateException("rrset is empty");
        }
        return (bt) this.f5353a.get(0);
    }

    private String a(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            bt btVar = (bt) it.next();
            stringBuffer.append("[");
            stringBuffer.append(btVar.i());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    public String toString() {
        if (this.f5353a.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(d());
        stringBuffer2.append(" ");
        stringBuffer.append(stringBuffer2.toString());
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(f());
        stringBuffer3.append(" ");
        stringBuffer.append(stringBuffer3.toString());
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append(p.b(e()));
        stringBuffer4.append(" ");
        stringBuffer.append(stringBuffer4.toString());
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append(ct.b(b()));
        stringBuffer5.append(" ");
        stringBuffer.append(stringBuffer5.toString());
        stringBuffer.append(a(a(true, false)));
        if (this.f5354b > 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(a(a(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }
}
