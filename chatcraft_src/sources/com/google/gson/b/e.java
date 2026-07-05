package com.google.gson.b;

/* compiled from: JavaVersion.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int f3996a = c();

    private static int c() {
        return a(System.getProperty("java.version"));
    }

    static int a(String str) throws NumberFormatException {
        int iB = b(str);
        if (iB == -1) {
            iB = c(str);
        }
        if (iB == -1) {
            return 6;
        }
        return iB;
    }

    private static int b(String str) throws NumberFormatException {
        try {
            String[] strArrSplit = str.split("[._]");
            int i = Integer.parseInt(strArrSplit[0]);
            return (i != 1 || strArrSplit.length <= 1) ? i : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static int c(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int a() {
        return f3996a;
    }

    public static boolean b() {
        return f3996a >= 9;
    }
}
