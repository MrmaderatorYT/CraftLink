package io.netty.util.a;

/* compiled from: StringUtil.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f4697b = !p.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    public static final String f4696a = System.getProperty("line.separator");
    private static final String[] c = new String[256];
    private static final String[] d = new String[256];

    static {
        int i = 0;
        while (i < 10) {
            c[i] = "0" + i;
            d[i] = String.valueOf(i);
            i++;
        }
        while (i < 16) {
            char c2 = (char) ((i + 97) - 10);
            c[i] = "0" + c2;
            d[i] = String.valueOf(c2);
            i++;
        }
        while (i < c.length) {
            String hexString = Integer.toHexString(i);
            c[i] = hexString;
            d[i] = hexString;
            i++;
        }
    }

    private p() {
    }

    public static String a(int i) {
        return c[i & 255];
    }

    public static String a(Object obj) {
        return obj == null ? "null_object" : a(obj.getClass());
    }

    public static String a(Class<?> cls) {
        String name = ((Class) j.a(cls, "clazz")).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf > -1 ? name.substring(iLastIndexOf + 1) : name;
    }

    public static boolean a(String str) {
        return str == null || str.isEmpty();
    }
}
