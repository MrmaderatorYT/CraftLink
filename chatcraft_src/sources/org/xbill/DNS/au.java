package org.xbill.DNS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Message.java */
/* loaded from: classes.dex */
public class au implements Cloneable {
    private static bt[] j = new bt[0];
    private static bq[] k = new bq[0];

    /* renamed from: a, reason: collision with root package name */
    int f5326a;

    /* renamed from: b, reason: collision with root package name */
    int f5327b;
    int c;
    private af d;
    private List[] e;
    private int f;
    private co g;
    private cp h;
    private int i;

    private au(af afVar) {
        this.e = new List[4];
        this.d = afVar;
    }

    public au(int i) {
        this(new af(i));
    }

    public au() {
        this(new af());
    }

    public static au a(bt btVar) {
        au auVar = new au();
        auVar.d.d(0);
        auVar.d.a(7);
        auVar.a(btVar, 0);
        return auVar;
    }

    au(t tVar) throws WireParseException {
        this(new af(tVar));
        boolean z = this.d.d() == 5;
        boolean zB = this.d.b(6);
        for (int i = 0; i < 4; i++) {
            try {
                int iG = this.d.g(i);
                if (iG > 0) {
                    this.e[i] = new ArrayList(iG);
                }
                for (int i2 = 0; i2 < iG; i2++) {
                    int iA = tVar.a();
                    bt btVarA = bt.a(tVar, i, z);
                    this.e[i].add(btVarA);
                    if (i == 3) {
                        if (btVarA.k() == 250) {
                            this.f5326a = iA;
                        }
                        if (btVarA.k() == 24 && ((bz) btVarA).d() == 0) {
                            this.c = iA;
                        }
                    }
                }
            } catch (WireParseException e) {
                if (!zB) {
                    throw e;
                }
            }
        }
        this.f = tVar.a();
    }

    public au(byte[] bArr) {
        this(new t(bArr));
    }

    public af a() {
        return this.d;
    }

    public void a(bt btVar, int i) {
        if (this.e[i] == null) {
            this.e[i] = new LinkedList();
        }
        this.d.e(i);
        this.e[i].add(btVar);
    }

    public bt b() {
        List list = this.e[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (bt) list.get(0);
    }

    public cp c() {
        int iG = this.d.g(3);
        if (iG == 0) {
            return null;
        }
        bt btVar = (bt) this.e[3].get(iG - 1);
        if (btVar.h != 250) {
            return null;
        }
        return (cp) btVar;
    }

    public boolean d() {
        return this.f5327b == 3 || this.f5327b == 1 || this.f5327b == 4;
    }

    public boolean e() {
        return this.f5327b == 1;
    }

    public bi f() {
        bt[] btVarArrA = a(3);
        for (int i = 0; i < btVarArrA.length; i++) {
            if (btVarArrA[i] instanceof bi) {
                return (bi) btVarArrA[i];
            }
        }
        return null;
    }

    public int g() {
        int iC = this.d.c();
        bi biVarF = f();
        return biVarF != null ? iC + (biVarF.e() << 4) : iC;
    }

    public bt[] a(int i) {
        if (this.e[i] == null) {
            return j;
        }
        List list = this.e[i];
        return (bt[]) list.toArray(new bt[list.size()]);
    }

    private static boolean a(bt btVar, bt btVar2) {
        return btVar.l() == btVar2.l() && btVar.m() == btVar2.m() && btVar.j().equals(btVar2.j());
    }

    public bq[] b(int i) {
        if (this.e[i] == null) {
            return k;
        }
        LinkedList linkedList = new LinkedList();
        bt[] btVarArrA = a(i);
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < btVarArrA.length; i2++) {
            bg bgVarJ = btVarArrA[i2].j();
            boolean z = true;
            if (hashSet.contains(bgVarJ)) {
                int size = linkedList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    bq bqVar = (bq) linkedList.get(size);
                    if (bqVar.b() == btVarArrA[i2].l() && bqVar.e() == btVarArrA[i2].m() && bqVar.d().equals(bgVarJ)) {
                        bqVar.a(btVarArrA[i2]);
                        z = false;
                        break;
                    }
                    size--;
                }
            }
            if (z) {
                linkedList.add(new bq(btVarArrA[i2]));
                hashSet.add(bgVarJ);
            }
        }
        return (bq[]) linkedList.toArray(new bq[linkedList.size()]);
    }

    void a(v vVar) {
        this.d.a(vVar);
        n nVar = new n();
        for (int i = 0; i < 4; i++) {
            if (this.e[i] != null) {
                for (int i2 = 0; i2 < this.e[i].size(); i2++) {
                    ((bt) this.e[i].get(i2)).a(vVar, i, nVar);
                }
            }
        }
    }

    private int a(v vVar, int i, n nVar, int i2) {
        int size = this.e[i].size();
        bt btVar = null;
        int iA = vVar.a();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            bt btVar2 = (bt) this.e[i].get(i5);
            if (i == 3 && (btVar2 instanceof bi)) {
                i3++;
            } else {
                if (btVar != null && !a(btVar2, btVar)) {
                    iA = vVar.a();
                    i4 = i5;
                }
                btVar2.a(vVar, i, nVar);
                if (vVar.a() > i2) {
                    vVar.a(iA);
                    return (size - i4) + i3;
                }
                btVar = btVar2;
            }
        }
        return i3;
    }

    private boolean a(v vVar, int i) {
        if (i < 12) {
            return false;
        }
        if (this.g != null) {
            i -= this.g.a();
        }
        bi biVarF = f();
        byte[] bArrA = null;
        if (biVarF != null) {
            bArrA = biVarF.a(3);
            i -= bArrA.length;
        }
        int iA = vVar.a();
        this.d.a(vVar);
        n nVar = new n();
        int iE = this.d.e();
        int i2 = 0;
        int iG = 0;
        while (true) {
            if (i2 >= 4) {
                break;
            }
            if (this.e[i2] != null) {
                int iA2 = a(vVar, i2, nVar, i);
                if (iA2 != 0 && i2 != 3) {
                    iE = af.a(iE, 6, true);
                    int iG2 = this.d.g(i2) - iA2;
                    int i3 = iA + 4;
                    vVar.a(iG2, (i2 * 2) + i3);
                    for (int i4 = i2 + 1; i4 < 3; i4++) {
                        vVar.a(0, (i4 * 2) + i3);
                    }
                } else if (i2 == 3) {
                    iG = this.d.g(i2) - iA2;
                }
            }
            i2++;
        }
        if (bArrA != null) {
            vVar.a(bArrA);
            iG++;
        }
        if (iE != this.d.e()) {
            vVar.a(iE, iA + 2);
        }
        if (iG != this.d.g(3)) {
            vVar.a(iG, iA + 10);
        }
        if (this.g != null) {
            this.g.a(this, vVar.b(), this.i, this.h).a(vVar, 3, nVar);
            vVar.a(iG + 1, iA + 10);
        }
        return true;
    }

    public byte[] h() {
        v vVar = new v();
        a(vVar);
        this.f = vVar.a();
        return vVar.b();
    }

    public byte[] c(int i) {
        v vVar = new v();
        a(vVar, i);
        this.f = vVar.a();
        return vVar.b();
    }

    public int i() {
        return this.f;
    }

    public String d(int i) {
        if (i > 3) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (bt btVar : a(i)) {
            if (i == 0) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(";;\t");
                stringBuffer2.append(btVar.g);
                stringBuffer.append(stringBuffer2.toString());
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(", type = ");
                stringBuffer3.append(ct.b(btVar.h));
                stringBuffer.append(stringBuffer3.toString());
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(", class = ");
                stringBuffer4.append(p.b(btVar.i));
                stringBuffer.append(stringBuffer4.toString());
            } else {
                stringBuffer.append(btVar);
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (f() != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(this.d.h(g()));
            stringBuffer2.append("\n");
            stringBuffer.append(stringBuffer2.toString());
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(this.d);
            stringBuffer3.append("\n");
            stringBuffer.append(stringBuffer3.toString());
        }
        if (d()) {
            stringBuffer.append(";; TSIG ");
            if (e()) {
                stringBuffer.append("ok");
            } else {
                stringBuffer.append("invalid");
            }
            stringBuffer.append('\n');
        }
        for (int i = 0; i < 4; i++) {
            if (this.d.d() != 5) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(";; ");
                stringBuffer4.append(cf.b(i));
                stringBuffer4.append(":\n");
                stringBuffer.append(stringBuffer4.toString());
            } else {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append(";; ");
                stringBuffer5.append(cf.c(i));
                stringBuffer5.append(":\n");
                stringBuffer.append(stringBuffer5.toString());
            }
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append(d(i));
            stringBuffer6.append("\n");
            stringBuffer.append(stringBuffer6.toString());
        }
        StringBuffer stringBuffer7 = new StringBuffer();
        stringBuffer7.append(";; Message size: ");
        stringBuffer7.append(i());
        stringBuffer7.append(" bytes");
        stringBuffer.append(stringBuffer7.toString());
        return stringBuffer.toString();
    }

    public Object clone() {
        au auVar = new au();
        for (int i = 0; i < this.e.length; i++) {
            if (this.e[i] != null) {
                auVar.e[i] = new LinkedList(this.e[i]);
            }
        }
        auVar.d = (af) this.d.clone();
        auVar.f = this.f;
        return auVar;
    }
}
