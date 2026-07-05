package org.xbill.DNS;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: Options.java */
/* loaded from: classes.dex */
public final class bk {

    /* renamed from: a, reason: collision with root package name */
    private static Map f5348a;

    static {
        try {
            a();
        } catch (SecurityException unused) {
        }
    }

    public static void a() {
        String property = System.getProperty("dnsjava.options");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(61);
                if (iIndexOf == -1) {
                    a(strNextToken);
                } else {
                    a(strNextToken.substring(0, iIndexOf), strNextToken.substring(iIndexOf + 1));
                }
            }
        }
    }

    public static void a(String str) {
        if (f5348a == null) {
            f5348a = new HashMap();
        }
        f5348a.put(str.toLowerCase(), "true");
    }

    public static void a(String str, String str2) {
        if (f5348a == null) {
            f5348a = new HashMap();
        }
        f5348a.put(str.toLowerCase(), str2.toLowerCase());
    }

    public static boolean b(String str) {
        return (f5348a == null || f5348a.get(str.toLowerCase()) == null) ? false : true;
    }

    public static String c(String str) {
        if (f5348a == null) {
            return null;
        }
        return (String) f5348a.get(str.toLowerCase());
    }

    public static int d(String str) throws NumberFormatException {
        String strC = c(str);
        if (strC == null) {
            return -1;
        }
        try {
            int i = Integer.parseInt(strC);
            if (i > 0) {
                return i;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
