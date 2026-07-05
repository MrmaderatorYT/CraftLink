package okhttp3.internal.b;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import okhttp3.aa;
import okhttp3.m;
import okhttp3.r;
import okhttp3.s;
import okhttp3.y;

/* compiled from: HttpHeaders.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f5111a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long a(aa aaVar) {
        return a(aaVar.g());
    }

    public static long a(r rVar) {
        return a(rVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean a(aa aaVar, r rVar, y yVar) {
        for (String str : e(aaVar)) {
            if (!okhttp3.internal.c.a(rVar.b(str), yVar.b(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(aa aaVar) {
        return b(aaVar.g());
    }

    public static boolean b(r rVar) {
        return c(rVar).contains("*");
    }

    private static Set<String> e(aa aaVar) {
        return c(aaVar.g());
    }

    public static Set<String> c(r rVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iA = rVar.a();
        Set<String> treeSet = setEmptySet;
        for (int i = 0; i < iA; i++) {
            if ("Vary".equalsIgnoreCase(rVar.a(i))) {
                String strB = rVar.b(i);
                if (treeSet.isEmpty()) {
                    treeSet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strB.split(",")) {
                    treeSet.add(str.trim());
                }
            }
        }
        return treeSet;
    }

    public static r c(aa aaVar) {
        return a(aaVar.j().a().c(), aaVar.g());
    }

    public static r a(r rVar, r rVar2) {
        Set<String> setC = c(rVar2);
        if (setC.isEmpty()) {
            return new r.a().a();
        }
        r.a aVar = new r.a();
        int iA = rVar.a();
        for (int i = 0; i < iA; i++) {
            String strA = rVar.a(i);
            if (setC.contains(strA)) {
                aVar.a(strA, rVar.b(i));
            }
        }
        return aVar.a();
    }

    public static void a(m mVar, s sVar, r rVar) {
        if (mVar == m.f5232a) {
            return;
        }
        List<okhttp3.l> listA = okhttp3.l.a(sVar, rVar);
        if (listA.isEmpty()) {
            return;
        }
        mVar.a(sVar, listA);
    }

    public static boolean d(aa aaVar) {
        if (aaVar.a().b().equals("HEAD")) {
            return false;
        }
        int iC = aaVar.c();
        return (((iC >= 100 && iC < 200) || iC == 204 || iC == 304) && a(aaVar) == -1 && !"chunked".equalsIgnoreCase(aaVar.a("Transfer-Encoding"))) ? false : true;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int b(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
