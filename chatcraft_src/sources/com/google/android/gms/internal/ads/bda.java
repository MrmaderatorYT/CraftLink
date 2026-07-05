package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
final class bda extends bcz {
    public final long aP;
    public final List<bdb> aQ;
    public final List<bda> aR;

    public bda(int i, long j) {
        super(i);
        this.aP = j;
        this.aQ = new ArrayList();
        this.aR = new ArrayList();
    }

    public final void a(bdb bdbVar) {
        this.aQ.add(bdbVar);
    }

    public final void a(bda bdaVar) {
        this.aR.add(bdaVar);
    }

    public final bdb d(int i) {
        int size = this.aQ.size();
        for (int i2 = 0; i2 < size; i2++) {
            bdb bdbVar = this.aQ.get(i2);
            if (bdbVar.aO == i) {
                return bdbVar;
            }
        }
        return null;
    }

    public final bda e(int i) {
        int size = this.aR.size();
        for (int i2 = 0; i2 < size; i2++) {
            bda bdaVar = this.aR.get(i2);
            if (bdaVar.aO == i) {
                return bdaVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bcz
    public final String toString() {
        String strC = c(this.aO);
        String string = Arrays.toString(this.aQ.toArray());
        String string2 = Arrays.toString(this.aR.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 22 + String.valueOf(string).length() + String.valueOf(string2).length());
        sb.append(strC);
        sb.append(" leaves: ");
        sb.append(string);
        sb.append(" containers: ");
        sb.append(string2);
        return sb.toString();
    }
}
