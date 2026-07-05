package io.netty.util.a;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.regex.Pattern;

/* compiled from: SystemPropertyUtil.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private static final io.netty.util.a.b.c f4698a = io.netty.util.a.b.d.a((Class<?>) q.class);

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f4699b = Pattern.compile("-?[0-9]+");

    public static boolean a(String str) {
        return b(str) != null;
    }

    public static String b(String str) {
        return a(str, (String) null);
    }

    public static String a(final String str, String str2) {
        String property;
        if (str == null) {
            throw new NullPointerException("key");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("key must not be empty.");
        }
        String str3 = null;
        try {
            if (System.getSecurityManager() == null) {
                property = System.getProperty(str);
            } else {
                property = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.util.a.q.1
                    @Override // java.security.PrivilegedAction
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public String run() {
                        return System.getProperty(str);
                    }
                });
            }
            str3 = property;
        } catch (Exception e) {
            f4698a.c("Unable to retrieve a system property '{}'; default values will be used.", str, e);
        }
        return str3 == null ? str2 : str3;
    }

    public static boolean a(String str, boolean z) {
        String strB = b(str);
        if (strB == null) {
            return z;
        }
        String lowerCase = strB.trim().toLowerCase();
        if (lowerCase.isEmpty() || "true".equals(lowerCase) || "yes".equals(lowerCase) || "1".equals(lowerCase)) {
            return true;
        }
        if ("false".equals(lowerCase) || "no".equals(lowerCase) || "0".equals(lowerCase)) {
            return false;
        }
        f4698a.b("Unable to parse the boolean system property '{}':{} - using the default value: {}", str, lowerCase, Boolean.valueOf(z));
        return z;
    }

    public static int a(String str, int i) {
        String strB = b(str);
        if (strB == null) {
            return i;
        }
        String lowerCase = strB.trim().toLowerCase();
        if (f4699b.matcher(lowerCase).matches()) {
            try {
                return Integer.parseInt(lowerCase);
            } catch (Exception unused) {
            }
        }
        f4698a.b("Unable to parse the integer system property '{}':{} - using the default value: {}", str, lowerCase, Integer.valueOf(i));
        return i;
    }

    public static long a(String str, long j) {
        String strB = b(str);
        if (strB == null) {
            return j;
        }
        String lowerCase = strB.trim().toLowerCase();
        if (f4699b.matcher(lowerCase).matches()) {
            try {
                return Long.parseLong(lowerCase);
            } catch (Exception unused) {
            }
        }
        f4698a.b("Unable to parse the long integer system property '{}':{} - using the default value: {}", str, lowerCase, Long.valueOf(j));
        return j;
    }

    private q() {
    }
}
