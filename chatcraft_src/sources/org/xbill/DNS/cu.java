package org.xbill.DNS;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: TypeBitmap.java */
/* loaded from: classes.dex */
final class cu implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private TreeSet f5392a;

    private cu() {
        this.f5392a = new TreeSet();
    }

    public cu(t tVar) throws WireParseException {
        this();
        while (tVar.b() > 0) {
            if (tVar.b() < 2) {
                throw new WireParseException("invalid bitmap descriptor");
            }
            int iG = tVar.g();
            if (iG < -1) {
                throw new WireParseException("invalid ordering");
            }
            int iG2 = tVar.g();
            if (iG2 > tVar.b()) {
                throw new WireParseException("invalid bitmap");
            }
            for (int i = 0; i < iG2; i++) {
                int iG3 = tVar.g();
                if (iG3 != 0) {
                    for (int i2 = 0; i2 < 8; i2++) {
                        if (((1 << (7 - i2)) & iG3) != 0) {
                            this.f5392a.add(av.c((iG * 256) + (i * 8) + i2));
                        }
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.f5392a.iterator();
        while (it.hasNext()) {
            stringBuffer.append(ct.b(((Integer) it.next()).intValue()));
            if (it.hasNext()) {
                stringBuffer.append(' ');
            }
        }
        return stringBuffer.toString();
    }

    private static void a(v vVar, TreeSet treeSet, int i) {
        int iIntValue = ((((Integer) treeSet.last()).intValue() & 255) / 8) + 1;
        int[] iArr = new int[iIntValue];
        vVar.b(i);
        vVar.b(iIntValue);
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            int iIntValue2 = ((Integer) it.next()).intValue();
            int i2 = (iIntValue2 & 255) / 8;
            iArr[i2] = (1 << (7 - (iIntValue2 % 8))) | iArr[i2];
        }
        for (int i3 = 0; i3 < iIntValue; i3++) {
            vVar.b(iArr[i3]);
        }
    }

    public void a(v vVar) {
        if (this.f5392a.size() == 0) {
            return;
        }
        int i = -1;
        TreeSet treeSet = new TreeSet();
        Iterator it = this.f5392a.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            int i2 = iIntValue >> 8;
            if (i2 != i) {
                if (treeSet.size() > 0) {
                    a(vVar, treeSet, i);
                    treeSet.clear();
                }
                i = i2;
            }
            treeSet.add(new Integer(iIntValue));
        }
        a(vVar, treeSet, i);
    }

    public boolean a() {
        return this.f5392a.isEmpty();
    }
}
