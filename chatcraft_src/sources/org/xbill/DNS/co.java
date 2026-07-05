package org.xbill.DNS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;

/* compiled from: TSIG.java */
/* loaded from: classes.dex */
public class co {

    /* renamed from: a, reason: collision with root package name */
    public static final bg f5383a = bg.b("HMAC-MD5.SIG-ALG.REG.INT.");

    /* renamed from: b, reason: collision with root package name */
    public static final bg f5384b = f5383a;
    public static final bg c = bg.b("hmac-sha1.");
    public static final bg d = bg.b("hmac-sha224.");
    public static final bg e = bg.b("hmac-sha256.");
    public static final bg f = bg.b("hmac-sha384.");
    public static final bg g = bg.b("hmac-sha512.");
    private static Map h;
    private bg i;
    private bg j;
    private Mac k;

    static Mac a(co coVar) {
        return coVar.k;
    }

    static boolean a(Mac mac, byte[] bArr) {
        return b(mac, bArr);
    }

    static bg b(co coVar) {
        return coVar.i;
    }

    static bg c(co coVar) {
        return coVar.j;
    }

    static {
        HashMap map = new HashMap();
        map.put(f5383a, "HmacMD5");
        map.put(c, "HmacSHA1");
        map.put(d, "HmacSHA224");
        map.put(e, "HmacSHA256");
        map.put(f, "HmacSHA384");
        map.put(g, "HmacSHA512");
        h = Collections.unmodifiableMap(map);
    }

    private static boolean b(Mac mac, byte[] bArr) {
        return a(mac, bArr, false);
    }

    private static boolean a(Mac mac, byte[] bArr, boolean z) throws IllegalStateException {
        byte[] bArrDoFinal = mac.doFinal();
        if (z && bArr.length < bArrDoFinal.length) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArrDoFinal, 0, bArr2, 0, bArr2.length);
            bArrDoFinal = bArr2;
        }
        return Arrays.equals(bArr, bArrDoFinal);
    }

    public cp a(au auVar, byte[] bArr, int i, cp cpVar) throws IllegalStateException, NumberFormatException {
        Date dateE;
        boolean z;
        byte[] bArrDoFinal;
        byte[] bArrB;
        if (i != 18) {
            dateE = new Date();
        } else {
            dateE = cpVar.e();
        }
        Date date = dateE;
        if (i == 0 || i == 18) {
            z = true;
            this.k.reset();
        } else {
            z = false;
        }
        int iD = bk.d("tsigfudge");
        int i2 = (iD < 0 || iD > 32767) ? 300 : iD;
        if (cpVar != null) {
            v vVar = new v();
            vVar.c(cpVar.g().length);
            if (z) {
                this.k.update(vVar.b());
                this.k.update(cpVar.g());
            }
        }
        if (z) {
            this.k.update(bArr);
        }
        v vVar2 = new v();
        this.i.a(vVar2);
        vVar2.c(255);
        vVar2.a(0L);
        this.j.a(vVar2);
        long time = date.getTime() / 1000;
        vVar2.c((int) (time >> 32));
        vVar2.a(time & 4294967295L);
        vVar2.c(i2);
        vVar2.c(i);
        vVar2.c(0);
        if (z) {
            this.k.update(vVar2.b());
        }
        if (z) {
            bArrDoFinal = this.k.doFinal();
        } else {
            bArrDoFinal = new byte[0];
        }
        byte[] bArr2 = bArrDoFinal;
        if (i == 18) {
            v vVar3 = new v();
            long time2 = new Date().getTime() / 1000;
            vVar3.c((int) (time2 >> 32));
            vVar3.a(time2 & 4294967295L);
            bArrB = vVar3.b();
        } else {
            bArrB = null;
        }
        return new cp(this.i, 255, 0L, this.j, date, i2, bArr2, auVar.a().b(), i, bArrB);
    }

    public void a(au auVar, int i, cp cpVar) {
        auVar.a(a(auVar, auVar.h(), i, cpVar), 3);
        auVar.f5327b = 3;
    }

    public void a(au auVar, cp cpVar) {
        a(auVar, 0, cpVar);
    }

    public byte b(au auVar, byte[] bArr, int i, cp cpVar) throws IllegalStateException {
        auVar.f5327b = 4;
        cp cpVarC = auVar.c();
        this.k.reset();
        if (cpVarC == null) {
            return (byte) 1;
        }
        if (!cpVarC.j().equals(this.i) || !cpVarC.d().equals(this.j)) {
            if (bk.b("verbose")) {
                System.err.println("BADKEY failure");
            }
            return (byte) 17;
        }
        if (Math.abs(System.currentTimeMillis() - cpVarC.e().getTime()) > cpVarC.f() * 1000) {
            if (!bk.b("verbose")) {
                return (byte) 18;
            }
            System.err.println("BADTIME failure");
            return (byte) 18;
        }
        if (cpVar != null && cpVarC.p() != 17 && cpVarC.p() != 16) {
            v vVar = new v();
            vVar.c(cpVar.g().length);
            this.k.update(vVar.b());
            this.k.update(cpVar.g());
        }
        auVar.a().f(3);
        byte[] bArrA = auVar.a().a();
        auVar.a().e(3);
        this.k.update(bArrA);
        this.k.update(bArr, bArrA.length, auVar.f5326a - bArrA.length);
        v vVar2 = new v();
        cpVarC.j().a(vVar2);
        vVar2.c(cpVarC.i);
        vVar2.a(cpVarC.j);
        cpVarC.d().a(vVar2);
        long time = cpVarC.e().getTime() / 1000;
        vVar2.c((int) (time >> 32));
        vVar2.a(time & 4294967295L);
        vVar2.c(cpVarC.f());
        vVar2.c(cpVarC.p());
        if (cpVarC.q() != null) {
            vVar2.c(cpVarC.q().length);
            vVar2.a(cpVarC.q());
        } else {
            vVar2.c(0);
        }
        this.k.update(vVar2.b());
        byte[] bArrG = cpVarC.g();
        int macLength = this.k.getMacLength();
        int i2 = this.k.getAlgorithm().toLowerCase().contains("md5") ? 10 : macLength / 2;
        if (bArrG.length > macLength) {
            if (bk.b("verbose")) {
                System.err.println("BADSIG: signature too long");
            }
            return (byte) 16;
        }
        if (bArrG.length < i2) {
            if (bk.b("verbose")) {
                System.err.println("BADSIG: signature too short");
            }
            return (byte) 16;
        }
        if (!a(this.k, bArrG, true)) {
            if (bk.b("verbose")) {
                System.err.println("BADSIG: signature verification");
            }
            return (byte) 16;
        }
        auVar.f5327b = 1;
        return (byte) 0;
    }

    public int a(au auVar, byte[] bArr, cp cpVar) {
        return b(auVar, bArr, bArr.length, cpVar);
    }

    public int a() {
        return this.i.b() + 10 + this.j.b() + 8 + 18 + 4 + 8;
    }

    /* compiled from: TSIG.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private co f5385a;

        /* renamed from: b, reason: collision with root package name */
        private Mac f5386b;
        private int c = 0;
        private int d;
        private cp e;

        public a(co coVar, cp cpVar) {
            this.f5385a = coVar;
            this.f5386b = co.a(coVar);
            this.e = cpVar;
        }

        public int a(au auVar, byte[] bArr) throws IllegalStateException {
            int length;
            cp cpVarC = auVar.c();
            this.c++;
            if (this.c == 1) {
                int iA = this.f5385a.a(auVar, bArr, this.e);
                if (iA == 0) {
                    byte[] bArrG = cpVarC.g();
                    v vVar = new v();
                    vVar.c(bArrG.length);
                    this.f5386b.update(vVar.b());
                    this.f5386b.update(bArrG);
                }
                this.e = cpVarC;
                return iA;
            }
            if (cpVarC != null) {
                auVar.a().f(3);
            }
            byte[] bArrA = auVar.a().a();
            if (cpVarC != null) {
                auVar.a().e(3);
            }
            this.f5386b.update(bArrA);
            if (cpVarC == null) {
                length = bArr.length - bArrA.length;
            } else {
                length = auVar.f5326a - bArrA.length;
            }
            this.f5386b.update(bArr, bArrA.length, length);
            if (cpVarC != null) {
                this.d = this.c;
                this.e = cpVarC;
                if (!cpVarC.j().equals(co.b(this.f5385a)) || !cpVarC.d().equals(co.c(this.f5385a))) {
                    if (bk.b("verbose")) {
                        System.err.println("BADKEY failure");
                    }
                    auVar.f5327b = 4;
                    return 17;
                }
                v vVar2 = new v();
                long time = cpVarC.e().getTime() / 1000;
                vVar2.c((int) (time >> 32));
                vVar2.a(time & 4294967295L);
                vVar2.c(cpVarC.f());
                this.f5386b.update(vVar2.b());
                if (!co.a(this.f5386b, cpVarC.g())) {
                    if (bk.b("verbose")) {
                        System.err.println("BADSIG failure");
                    }
                    auVar.f5327b = 4;
                    return 16;
                }
                this.f5386b.reset();
                v vVar3 = new v();
                vVar3.c(cpVarC.g().length);
                this.f5386b.update(vVar3.b());
                this.f5386b.update(cpVarC.g());
                auVar.f5327b = 1;
                return 0;
            }
            if (this.c - this.d >= 100) {
                auVar.f5327b = 4;
                return 1;
            }
            auVar.f5327b = 2;
            return 0;
        }
    }
}
