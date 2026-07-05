package org.xbill.DNS;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: APLRecord.java */
/* loaded from: classes.dex */
public class d extends bt {

    /* renamed from: a, reason: collision with root package name */
    private List f5398a;

    private static boolean b(int i, int i2) {
        if (i2 < 0 || i2 >= 256) {
            return false;
        }
        return (i != 1 || i2 <= 32) && (i != 2 || i2 <= 128);
    }

    static boolean a(int i, int i2) {
        return b(i, i2);
    }

    /* compiled from: APLRecord.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f5399a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f5400b;
        public final int c;
        public final Object d;

        a(int i, boolean z, Object obj, int i2, e eVar) {
            this(i, z, obj, i2);
        }

        private a(int i, boolean z, Object obj, int i2) {
            this.f5399a = i;
            this.f5400b = z;
            this.d = obj;
            this.c = i2;
            if (!d.a(i, i2)) {
                throw new IllegalArgumentException("invalid prefix length");
            }
        }

        public a(boolean z, InetAddress inetAddress, int i) {
            this(g.a(inetAddress), z, inetAddress, i);
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.f5400b) {
                stringBuffer.append("!");
            }
            stringBuffer.append(this.f5399a);
            stringBuffer.append(":");
            if (this.f5399a == 1 || this.f5399a == 2) {
                stringBuffer.append(((InetAddress) this.d).getHostAddress());
            } else {
                stringBuffer.append(org.xbill.DNS.a.a.a((byte[]) this.d));
            }
            stringBuffer.append("/");
            stringBuffer.append(this.c);
            return stringBuffer.toString();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5399a == aVar.f5399a && this.f5400b == aVar.f5400b && this.c == aVar.c && this.d.equals(aVar.d);
        }

        public int hashCode() {
            return this.d.hashCode() + this.c + (this.f5400b ? 1 : 0);
        }
    }

    d() {
    }

    @Override // org.xbill.DNS.bt
    bt a() {
        return new d();
    }

    private static byte[] a(byte[] bArr, int i) throws WireParseException {
        if (bArr.length > i) {
            throw new WireParseException("invalid address length");
        }
        if (bArr.length == i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Override // org.xbill.DNS.bt
    void a(t tVar) throws WireParseException {
        a aVar;
        this.f5398a = new ArrayList(1);
        while (tVar.b() != 0) {
            int iH = tVar.h();
            int iG = tVar.g();
            int iG2 = tVar.g();
            boolean z = (iG2 & 128) != 0;
            byte[] bArrD = tVar.d(iG2 & (-129));
            if (!b(iH, iG)) {
                throw new WireParseException("invalid prefix length");
            }
            if (iH == 1 || iH == 2) {
                aVar = new a(z, InetAddress.getByAddress(a(bArrD, g.a(iH))), iG);
            } else {
                aVar = new a(iH, z, bArrD, iG, null);
            }
            this.f5398a.add(aVar);
        }
    }

    @Override // org.xbill.DNS.bt
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.f5398a.iterator();
        while (it.hasNext()) {
            stringBuffer.append((a) it.next());
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private static int b(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length] != 0) {
                return length + 1;
            }
        }
        return 0;
    }

    @Override // org.xbill.DNS.bt
    void a(v vVar, n nVar, boolean z) {
        byte[] address;
        int iB;
        for (a aVar : this.f5398a) {
            if (aVar.f5399a == 1 || aVar.f5399a == 2) {
                address = ((InetAddress) aVar.d).getAddress();
                iB = b(address);
            } else {
                address = (byte[]) aVar.d;
                iB = address.length;
            }
            int i = aVar.f5400b ? iB | 128 : iB;
            vVar.c(aVar.f5399a);
            vVar.b(aVar.c);
            vVar.b(i);
            vVar.a(address, 0, iB);
        }
    }
}
