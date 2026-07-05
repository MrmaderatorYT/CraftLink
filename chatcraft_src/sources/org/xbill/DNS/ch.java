package org.xbill.DNS;

import java.util.ArrayList;
import java.util.List;

/* compiled from: SetResponse.java */
/* loaded from: classes.dex */
public class ch {

    /* renamed from: a, reason: collision with root package name */
    private static final ch f5374a = new ch(0);

    /* renamed from: b, reason: collision with root package name */
    private static final ch f5375b = new ch(1);
    private static final ch c = new ch(2);
    private int d;
    private Object e;

    private ch() {
    }

    ch(int i, bq bqVar) {
        if (i < 0 || i > 6) {
            throw new IllegalArgumentException("invalid type");
        }
        this.d = i;
        this.e = bqVar;
    }

    ch(int i) {
        if (i < 0 || i > 6) {
            throw new IllegalArgumentException("invalid type");
        }
        this.d = i;
        this.e = null;
    }

    static ch a(int i) {
        switch (i) {
            case 0:
                return f5374a;
            case 1:
                return f5375b;
            case 2:
                return c;
            case 3:
            case 4:
            case 5:
            case 6:
                ch chVar = new ch();
                chVar.d = i;
                chVar.e = null;
                return chVar;
            default:
                throw new IllegalArgumentException("invalid type");
        }
    }

    void a(bq bqVar) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        ((List) this.e).add(bqVar);
    }

    public boolean a() {
        return this.d == 1;
    }

    public boolean b() {
        return this.d == 2;
    }

    public boolean c() {
        return this.d == 3;
    }

    public boolean d() {
        return this.d == 4;
    }

    public boolean e() {
        return this.d == 5;
    }

    public boolean f() {
        return this.d == 6;
    }

    public bq[] g() {
        if (this.d != 6) {
            return null;
        }
        List list = (List) this.e;
        return (bq[]) list.toArray(new bq[list.size()]);
    }

    public j h() {
        return (j) ((bq) this.e).g();
    }

    public s i() {
        return (s) ((bq) this.e).g();
    }

    public String toString() {
        switch (this.d) {
            case 0:
                return "unknown";
            case 1:
                return "NXDOMAIN";
            case 2:
                return "NXRRSET";
            case 3:
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("delegation: ");
                stringBuffer.append(this.e);
                return stringBuffer.toString();
            case 4:
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("CNAME: ");
                stringBuffer2.append(this.e);
                return stringBuffer2.toString();
            case 5:
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("DNAME: ");
                stringBuffer3.append(this.e);
                return stringBuffer3.toString();
            case 6:
                return "successful";
            default:
                throw new IllegalStateException();
        }
    }
}
