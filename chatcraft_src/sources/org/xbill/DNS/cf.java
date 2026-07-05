package org.xbill.DNS;

/* compiled from: Section.java */
/* loaded from: classes.dex */
public final class cf {

    /* renamed from: a, reason: collision with root package name */
    private static av f5372a = new av("Message Section", 3);

    /* renamed from: b, reason: collision with root package name */
    private static String[] f5373b = new String[4];
    private static String[] c = new String[4];

    static {
        f5372a.b(3);
        f5372a.a(true);
        f5372a.a(0, "qd");
        f5372a.a(1, "an");
        f5372a.a(2, "au");
        f5372a.a(3, "ad");
        f5373b[0] = "QUESTIONS";
        f5373b[1] = "ANSWERS";
        f5373b[2] = "AUTHORITY RECORDS";
        f5373b[3] = "ADDITIONAL RECORDS";
        c[0] = "ZONE";
        c[1] = "PREREQUISITES";
        c[2] = "UPDATE RECORDS";
        c[3] = "ADDITIONAL RECORDS";
    }

    public static String a(int i) {
        return f5372a.d(i);
    }

    public static String b(int i) {
        f5372a.a(i);
        return f5373b[i];
    }

    public static String c(int i) {
        f5372a.a(i);
        return c[i];
    }
}
