package org.xbill.DNS;

import java.io.PrintStream;

/* compiled from: Compression.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: b, reason: collision with root package name */
    private boolean f5427b = bk.b("verbosecompression");

    /* renamed from: a, reason: collision with root package name */
    private a[] f5426a = new a[17];

    /* compiled from: Compression.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        bg f5428a;

        /* renamed from: b, reason: collision with root package name */
        int f5429b;
        a c;

        private a() {
        }

        a(o oVar) {
            this();
        }
    }

    public void a(int i, bg bgVar) {
        if (i > 16383) {
            return;
        }
        int iHashCode = (bgVar.hashCode() & Integer.MAX_VALUE) % 17;
        a aVar = new a(null);
        aVar.f5428a = bgVar;
        aVar.f5429b = i;
        aVar.c = this.f5426a[iHashCode];
        this.f5426a[iHashCode] = aVar;
        if (this.f5427b) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Adding ");
            stringBuffer.append(bgVar);
            stringBuffer.append(" at ");
            stringBuffer.append(i);
            printStream.println(stringBuffer.toString());
        }
    }

    public int a(bg bgVar) {
        int i = -1;
        for (a aVar = this.f5426a[(bgVar.hashCode() & Integer.MAX_VALUE) % 17]; aVar != null; aVar = aVar.c) {
            if (aVar.f5428a.equals(bgVar)) {
                i = aVar.f5429b;
            }
        }
        if (this.f5427b) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Looking for ");
            stringBuffer.append(bgVar);
            stringBuffer.append(", found ");
            stringBuffer.append(i);
            printStream.println(stringBuffer.toString());
        }
        return i;
    }
}
