package org.xbill.DNS;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

/* compiled from: SimpleResolver.java */
/* loaded from: classes.dex */
public class ci implements bv {
    private static String h = "localhost";
    private static int i;

    /* renamed from: a, reason: collision with root package name */
    private InetSocketAddress f5376a;

    /* renamed from: b, reason: collision with root package name */
    private InetSocketAddress f5377b;
    private boolean c;
    private boolean d;
    private bi e;
    private co f;
    private long g;

    public ci(String str) throws UnknownHostException {
        InetAddress byName;
        this.g = 10000L;
        if (str == null && (str = bw.e().b()) == null) {
            str = h;
        }
        if (str.equals("0")) {
            byName = InetAddress.getLocalHost();
        } else {
            byName = InetAddress.getByName(str);
        }
        this.f5376a = new InetSocketAddress(byName, 53);
    }

    public ci() {
        this(null);
    }

    @Override // org.xbill.DNS.bv
    public void a(int i2, int i3) {
        this.g = (i2 * 1000) + i3;
    }

    @Override // org.xbill.DNS.bv
    public void a(int i2) {
        a(i2, 0);
    }

    long a() {
        return this.g;
    }

    private au a(byte[] bArr) throws WireParseException {
        try {
            return new au(bArr);
        } catch (IOException e) {
            e = e;
            if (bk.b("verbose")) {
                e.printStackTrace();
            }
            if (!(e instanceof WireParseException)) {
                e = new WireParseException("Error parsing message");
            }
            throw ((WireParseException) e);
        }
    }

    private void a(au auVar, au auVar2, byte[] bArr, co coVar) {
        if (coVar == null) {
            return;
        }
        int iA = coVar.a(auVar2, bArr, auVar.c());
        if (bk.b("verbose")) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("TSIG verify: ");
            stringBuffer.append(bs.b(iA));
            printStream.println(stringBuffer.toString());
        }
    }

    private void b(au auVar) {
        if (this.e == null || auVar.f() != null) {
            return;
        }
        auVar.a(this.e, 3);
    }

    private int c(au auVar) {
        bi biVarF = auVar.f();
        if (biVarF == null) {
            return 512;
        }
        return biVarF.d();
    }

    @Override // org.xbill.DNS.bv
    public au a(au auVar) throws WireParseException {
        byte[] bArrA;
        au auVarA;
        bt btVarB;
        if (bk.b("verbose")) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Sending to ");
            stringBuffer.append(this.f5376a.getAddress().getHostAddress());
            stringBuffer.append(":");
            stringBuffer.append(this.f5376a.getPort());
            printStream.println(stringBuffer.toString());
        }
        if (auVar.a().d() == 0 && (btVarB = auVar.b()) != null && btVarB.k() == 252) {
            return d(auVar);
        }
        au auVar2 = (au) auVar.clone();
        b(auVar2);
        if (this.f != null) {
            this.f.a(auVar2, (cp) null);
        }
        byte[] bArrC = auVar2.c(65535);
        int iC = c(auVar2);
        long jCurrentTimeMillis = System.currentTimeMillis() + this.g;
        boolean z = false;
        while (true) {
            boolean z2 = (this.c || bArrC.length > iC) ? true : z;
            if (z2) {
                bArrA = cl.a(this.f5377b, this.f5376a, bArrC, jCurrentTimeMillis);
            } else {
                bArrA = cw.a(this.f5377b, this.f5376a, bArrC, iC, jCurrentTimeMillis);
            }
            if (bArrA.length < 12) {
                throw new WireParseException("invalid DNS header - too short");
            }
            int i2 = ((bArrA[0] & Constants.DimensionIds.NETHER) << 8) + (bArrA[1] & Constants.DimensionIds.NETHER);
            int iB = auVar2.a().b();
            if (i2 != iB) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("invalid message id: expected ");
                stringBuffer2.append(iB);
                stringBuffer2.append("; got id ");
                stringBuffer2.append(i2);
                String string = stringBuffer2.toString();
                if (z2) {
                    throw new WireParseException(string);
                }
                if (bk.b("verbose")) {
                    System.err.println(string);
                }
                z = z2;
            } else {
                auVarA = a(bArrA);
                a(auVar2, auVarA, bArrA, this.f);
                if (z2 || this.d || !auVarA.a().b(6)) {
                    break;
                }
                z = true;
            }
        }
        return auVarA;
    }

    @Override // org.xbill.DNS.bv
    public Object a(au auVar, bx bxVar) {
        Integer num;
        synchronized (this) {
            int i2 = i;
            i = i2 + 1;
            num = new Integer(i2);
        }
        bt btVarB = auVar.b();
        String string = btVarB != null ? btVarB.j().toString() : "(none)";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass());
        stringBuffer.append(": ");
        stringBuffer.append(string);
        String string2 = stringBuffer.toString();
        bu buVar = new bu(this, auVar, num, bxVar);
        buVar.setName(string2);
        buVar.setDaemon(true);
        buVar.start();
        return num;
    }

    private au d(au auVar) throws WireParseException {
        dc dcVarA = dc.a(auVar.b().j(), this.f5376a, this.f);
        dcVarA.a((int) (a() / 1000));
        dcVarA.a(this.f5377b);
        try {
            dcVarA.a();
            List listB = dcVarA.b();
            au auVar2 = new au(auVar.a().b());
            auVar2.a().a(5);
            auVar2.a().a(0);
            auVar2.a(auVar.b(), 0);
            Iterator it = listB.iterator();
            while (it.hasNext()) {
                auVar2.a((bt) it.next(), 1);
            }
            return auVar2;
        } catch (ZoneTransferException e) {
            throw new WireParseException(e.getMessage());
        }
    }
}
