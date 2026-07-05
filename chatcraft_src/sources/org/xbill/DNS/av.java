package org.xbill.DNS;

import java.util.HashMap;

/* compiled from: Mnemonic.java */
/* loaded from: classes.dex */
class av {

    /* renamed from: a, reason: collision with root package name */
    private static Integer[] f5328a = new Integer[64];
    private String d;
    private int e;
    private String f;
    private boolean h;

    /* renamed from: b, reason: collision with root package name */
    private HashMap f5329b = new HashMap();
    private HashMap c = new HashMap();
    private int g = Integer.MAX_VALUE;

    static {
        for (int i = 0; i < f5328a.length; i++) {
            f5328a[i] = new Integer(i);
        }
    }

    public av(String str, int i) {
        this.d = str;
        this.e = i;
    }

    public void b(int i) {
        this.g = i;
    }

    public void a(String str) {
        this.f = b(str);
    }

    public void a(boolean z) {
        this.h = z;
    }

    public static Integer c(int i) {
        if (i >= 0 && i < f5328a.length) {
            return f5328a[i];
        }
        return new Integer(i);
    }

    public void a(int i) {
        if (i < 0 || i > this.g) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.d);
            stringBuffer.append(" ");
            stringBuffer.append(i);
            stringBuffer.append("is out of range");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    private String b(String str) {
        if (this.e == 2) {
            return str.toUpperCase();
        }
        return this.e == 3 ? str.toLowerCase() : str;
    }

    public void a(int i, String str) {
        a(i);
        Integer numC = c(i);
        String strB = b(str);
        this.f5329b.put(strB, numC);
        this.c.put(numC, strB);
    }

    public void b(int i, String str) {
        a(i);
        Integer numC = c(i);
        this.f5329b.put(b(str), numC);
    }

    public void a(av avVar) {
        if (this.e != avVar.e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(avVar.d);
            stringBuffer.append(": wordcases do not match");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        this.f5329b.putAll(avVar.f5329b);
        this.c.putAll(avVar.c);
    }

    public String d(int i) {
        a(i);
        String str = (String) this.c.get(c(i));
        if (str != null) {
            return str;
        }
        String string = Integer.toString(i);
        if (this.f == null) {
            return string;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f);
        stringBuffer.append(string);
        return stringBuffer.toString();
    }
}
