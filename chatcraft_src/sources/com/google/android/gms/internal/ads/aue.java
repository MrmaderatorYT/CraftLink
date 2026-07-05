package com.google.android.gms.internal.ads;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'i' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public class aue {

    /* renamed from: a, reason: collision with root package name */
    public static final aue f2272a = new aue("DOUBLE", 0, auj.DOUBLE, 1);

    /* renamed from: b, reason: collision with root package name */
    public static final aue f2273b = new aue("FLOAT", 1, auj.FLOAT, 5);
    public static final aue c = new aue("INT64", 2, auj.LONG, 0);
    public static final aue d = new aue("UINT64", 3, auj.LONG, 0);
    public static final aue e = new aue("INT32", 4, auj.INT, 0);
    public static final aue f = new aue("FIXED64", 5, auj.LONG, 1);
    public static final aue g = new aue("FIXED32", 6, auj.INT, 5);
    public static final aue h = new aue("BOOL", 7, auj.BOOLEAN, 0);
    public static final aue i;
    public static final aue j;
    public static final aue k;
    public static final aue l;
    public static final aue m;
    public static final aue n;
    public static final aue o;
    public static final aue p;
    public static final aue q;
    public static final aue r;
    private static final /* synthetic */ aue[] u;
    private final auj s;
    private final int t;

    public static aue[] values() {
        return (aue[]) u.clone();
    }

    private aue(String str, int i2, auj aujVar, int i3) {
        this.s = aujVar;
        this.t = i3;
    }

    public final auj a() {
        return this.s;
    }

    public final int b() {
        return this.t;
    }

    /* synthetic */ aue(String str, int i2, auj aujVar, int i3, aud audVar) {
        this(str, i2, aujVar, i3);
    }

    static {
        final int i2 = 2;
        final int i3 = 3;
        final String str = "STRING";
        final auj aujVar = auj.STRING;
        final int i4 = 8;
        i = new aue(str, i4, aujVar, i2) { // from class: com.google.android.gms.internal.ads.auf
            {
                int i5 = 8;
                int i6 = 2;
                aud audVar = null;
            }
        };
        final String str2 = "GROUP";
        final auj aujVar2 = auj.MESSAGE;
        final int i5 = 9;
        j = new aue(str2, i5, aujVar2, i3) { // from class: com.google.android.gms.internal.ads.aug
            {
                int i6 = 9;
                int i7 = 3;
                aud audVar = null;
            }
        };
        final String str3 = "MESSAGE";
        final auj aujVar3 = auj.MESSAGE;
        final int i6 = 10;
        k = new aue(str3, i6, aujVar3, i2) { // from class: com.google.android.gms.internal.ads.auh
            {
                int i7 = 10;
                int i8 = 2;
                aud audVar = null;
            }
        };
        final String str4 = "BYTES";
        final auj aujVar4 = auj.BYTE_STRING;
        final int i7 = 11;
        l = new aue(str4, i7, aujVar4, i2) { // from class: com.google.android.gms.internal.ads.aui
            {
                int i8 = 11;
                int i9 = 2;
                aud audVar = null;
            }
        };
        m = new aue("UINT32", 12, auj.INT, 0);
        n = new aue("ENUM", 13, auj.ENUM, 0);
        o = new aue("SFIXED32", 14, auj.INT, 5);
        p = new aue("SFIXED64", 15, auj.LONG, 1);
        q = new aue("SINT32", 16, auj.INT, 0);
        r = new aue("SINT64", 17, auj.LONG, 0);
        u = new aue[]{f2272a, f2273b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r};
    }
}
