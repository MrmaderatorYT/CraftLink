package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.util.Arrays;

/* compiled from: EDNSOption.java */
/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    private final int f5440a;

    abstract String a();

    abstract void a(t tVar);

    abstract void a(v vVar);

    /* compiled from: EDNSOption.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static av f5441a = new av("EDNS Option Codes", 2);

        static {
            f5441a.b(65535);
            f5441a.a("CODE");
            f5441a.a(true);
            f5441a.a(3, "NSID");
            f5441a.a(8, "CLIENT_SUBNET");
        }

        public static String a(int i) {
            return f5441a.d(i);
        }
    }

    public x(int i) {
        this.f5440a = bt.a("code", i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append(a.a(this.f5440a));
        stringBuffer.append(": ");
        stringBuffer.append(a());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    byte[] b() {
        v vVar = new v();
        a(vVar);
        return vVar.b();
    }

    static x b(t tVar) throws WireParseException {
        x bcVar;
        int iH = tVar.h();
        int iH2 = tVar.h();
        if (tVar.b() < iH2) {
            throw new WireParseException("truncated option");
        }
        int iD = tVar.d();
        tVar.a(iH2);
        if (iH == 3) {
            bcVar = new bc();
        } else if (iH == 8) {
            bcVar = new m();
        } else {
            bcVar = new ad(iH);
        }
        bcVar.a(tVar);
        tVar.b(iD);
        return bcVar;
    }

    void b(v vVar) {
        vVar.c(this.f5440a);
        int iA = vVar.a();
        vVar.c(0);
        a(vVar);
        vVar.a((vVar.a() - iA) - 2, iA);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (this.f5440a != xVar.f5440a) {
            return false;
        }
        return Arrays.equals(b(), xVar.b());
    }

    public int hashCode() {
        int i = 0;
        for (byte b2 : b()) {
            i += (i << 3) + (b2 & Constants.DimensionIds.NETHER);
        }
        return i;
    }
}
