package okhttp3;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: HttpUrl.java */
/* loaded from: classes.dex */
public final class s {
    private static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    final String f5242a;

    /* renamed from: b, reason: collision with root package name */
    final String f5243b;
    final int c;
    private final String e;
    private final String f;
    private final List<String> g;

    @Nullable
    private final List<String> h;

    @Nullable
    private final String i;
    private final String j;

    s(a aVar) {
        this.f5242a = aVar.f5244a;
        this.e = a(aVar.f5245b, false);
        this.f = a(aVar.c, false);
        this.f5243b = aVar.d;
        this.c = aVar.a();
        this.g = a(aVar.f, false);
        this.h = aVar.g != null ? a(aVar.g, true) : null;
        this.i = aVar.h != null ? a(aVar.h, false) : null;
        this.j = aVar.toString();
    }

    public URI a() {
        String string = n().b().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", BuildConfig.FLAVOR));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String b() {
        return this.f5242a;
    }

    public boolean c() {
        return this.f5242a.equals("https");
    }

    public String d() {
        if (this.e.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        int length = this.f5242a.length() + 3;
        return this.j.substring(length, okhttp3.internal.c.a(this.j, length, this.j.length(), ":@"));
    }

    public String e() {
        if (this.f.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        return this.j.substring(this.j.indexOf(58, this.f5242a.length() + 3) + 1, this.j.indexOf(64));
    }

    public String f() {
        return this.f5243b;
    }

    public int g() {
        return this.c;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String h() {
        int iIndexOf = this.j.indexOf(47, this.f5242a.length() + 3);
        return this.j.substring(iIndexOf, okhttp3.internal.c.a(this.j, iIndexOf, this.j.length(), "?#"));
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> i() {
        int iIndexOf = this.j.indexOf(47, this.f5242a.length() + 3);
        int iA = okhttp3.internal.c.a(this.j, iIndexOf, this.j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iA) {
            int i = iIndexOf + 1;
            int iA2 = okhttp3.internal.c.a(this.j, i, iA, '/');
            arrayList.add(this.j.substring(i, iA2));
            iIndexOf = iA2;
        }
        return arrayList;
    }

    @Nullable
    public String j() {
        if (this.h == null) {
            return null;
        }
        int iIndexOf = this.j.indexOf(63) + 1;
        return this.j.substring(iIndexOf, okhttp3.internal.c.a(this.j, iIndexOf, this.j.length(), '#'));
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    public String k() {
        if (this.h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.h);
        return sb.toString();
    }

    @Nullable
    public String l() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public String m() {
        return d("/...").b(BuildConfig.FLAVOR).c(BuildConfig.FLAVOR).c().toString();
    }

    @Nullable
    public s c(String str) {
        a aVarD = d(str);
        if (aVarD != null) {
            return aVarD.c();
        }
        return null;
    }

    public a n() {
        a aVar = new a();
        aVar.f5244a = this.f5242a;
        aVar.f5245b = d();
        aVar.c = e();
        aVar.d = this.f5243b;
        aVar.e = this.c != a(this.f5242a) ? this.c : -1;
        aVar.f.clear();
        aVar.f.addAll(i());
        aVar.e(j());
        aVar.h = l();
        return aVar;
    }

    @Nullable
    public a d(String str) {
        a aVar = new a();
        if (aVar.a(this, str) == a.EnumC0125a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    @Nullable
    public static s e(String str) {
        a aVar = new a();
        if (aVar.a(null, str) == a.EnumC0125a.SUCCESS) {
            return aVar.c();
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof s) && ((s) obj).j.equals(this.j);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }

    /* compiled from: HttpUrl.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        String f5244a;

        @Nullable
        String d;

        @Nullable
        List<String> g;

        @Nullable
        String h;

        /* renamed from: b, reason: collision with root package name */
        String f5245b = BuildConfig.FLAVOR;
        String c = BuildConfig.FLAVOR;
        int e = -1;
        final List<String> f = new ArrayList();

        /* compiled from: HttpUrl.java */
        /* renamed from: okhttp3.s$a$a, reason: collision with other inner class name */
        enum EnumC0125a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            this.f.add(BuildConfig.FLAVOR);
        }

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f5244a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.f5244a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f5245b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a c(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a d(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strE = e(str, 0, str.length());
            if (strE == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.d = strE;
            return this;
        }

        public a a(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.e = i;
            return this;
        }

        int a() {
            return this.e != -1 ? this.e : s.a(this.f5244a);
        }

        public a e(@Nullable String str) {
            this.g = str != null ? s.b(s.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        a b() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, s.a(this.f.get(i), "[]", true, true, false, true));
            }
            if (this.g != null) {
                int size2 = this.g.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, s.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            if (this.h != null) {
                this.h = s.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public s c() {
            if (this.f5244a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.d == null) {
                throw new IllegalStateException("host == null");
            }
            return new s(this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5244a);
            sb.append("://");
            if (!this.f5245b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.f5245b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
            int iA = a();
            if (iA != s.a(this.f5244a)) {
                sb.append(':');
                sb.append(iA);
            }
            s.a(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                s.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        EnumC0125a a(@Nullable s sVar, String str) {
            int iA;
            int i;
            int i2;
            int iA2 = okhttp3.internal.c.a(str, 0, str.length());
            int iB = okhttp3.internal.c.b(str, iA2, str.length());
            if (b(str, iA2, iB) != -1) {
                if (str.regionMatches(true, iA2, "https:", 0, 6)) {
                    this.f5244a = "https";
                    iA2 += "https:".length();
                } else if (str.regionMatches(true, iA2, "http:", 0, 5)) {
                    this.f5244a = "http";
                    iA2 += "http:".length();
                } else {
                    return EnumC0125a.UNSUPPORTED_SCHEME;
                }
            } else if (sVar != null) {
                this.f5244a = sVar.f5242a;
            } else {
                return EnumC0125a.MISSING_SCHEME;
            }
            int iC = c(str, iA2, iB);
            char c = '#';
            if (iC >= 2 || sVar == null || !sVar.f5242a.equals(this.f5244a)) {
                int i3 = iA2 + iC;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    iA = okhttp3.internal.c.a(str, i3, iB, "@/\\?#");
                    char cCharAt = iA != iB ? str.charAt(iA) : (char) 65535;
                    if (cCharAt != 65535 && cCharAt != c && cCharAt != '/' && cCharAt != '\\') {
                        switch (cCharAt) {
                            case '?':
                                break;
                            case '@':
                                if (!z) {
                                    int iA3 = okhttp3.internal.c.a(str, i3, iA, ':');
                                    i2 = iA;
                                    String strA = s.a(str, i3, iA3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    if (z2) {
                                        strA = this.f5245b + "%40" + strA;
                                    }
                                    this.f5245b = strA;
                                    if (iA3 != i2) {
                                        this.c = s.a(str, iA3 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                        z = true;
                                    }
                                    z2 = true;
                                } else {
                                    i2 = iA;
                                    this.c += "%40" + s.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                }
                                i3 = i2 + 1;
                                continue;
                                c = '#';
                            default:
                                c = '#';
                        }
                    }
                }
                i = iA;
                int iD = d(str, i3, i);
                int i4 = iD + 1;
                if (i4 < i) {
                    this.d = e(str, i3, iD);
                    this.e = f(str, i4, i);
                    if (this.e == -1) {
                        return EnumC0125a.INVALID_PORT;
                    }
                } else {
                    this.d = e(str, i3, iD);
                    this.e = s.a(this.f5244a);
                }
                if (this.d == null) {
                    return EnumC0125a.INVALID_HOST;
                }
            } else {
                this.f5245b = sVar.d();
                this.c = sVar.e();
                this.d = sVar.f5243b;
                this.e = sVar.c;
                this.f.clear();
                this.f.addAll(sVar.i());
                if (iA2 == iB || str.charAt(iA2) == '#') {
                    e(sVar.j());
                }
                i = iA2;
            }
            int iA4 = okhttp3.internal.c.a(str, i, iB, "?#");
            a(str, i, iA4);
            if (iA4 < iB && str.charAt(iA4) == '?') {
                int iA5 = okhttp3.internal.c.a(str, iA4, iB, '#');
                this.g = s.b(s.a(str, iA4 + 1, iA5, " \"'<>#", true, false, true, true, null));
                iA4 = iA5;
            }
            if (iA4 < iB && str.charAt(iA4) == '#') {
                this.h = s.a(str, 1 + iA4, iB, BuildConfig.FLAVOR, true, false, false, false, null);
            }
            return EnumC0125a.SUCCESS;
        }

        private void a(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f.clear();
                this.f.add(BuildConfig.FLAVOR);
                i++;
            } else {
                this.f.set(this.f.size() - 1, BuildConfig.FLAVOR);
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = okhttp3.internal.c.a(str, i3, i2, "/\\");
                boolean z = i < i2;
                a(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String strA = s.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (f(strA)) {
                return;
            }
            if (g(strA)) {
                d();
                return;
            }
            if (this.f.get(this.f.size() - 1).isEmpty()) {
                this.f.set(this.f.size() - 1, strA);
            } else {
                this.f.add(strA);
            }
            if (z) {
                this.f.add(BuildConfig.FLAVOR);
            }
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void d() {
            if (this.f.remove(this.f.size() - 1).isEmpty() && !this.f.isEmpty()) {
                this.f.set(this.f.size() - 1, BuildConfig.FLAVOR);
            } else {
                this.f.add(BuildConfig.FLAVOR);
            }
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
                return -1;
            }
            while (true) {
                i++;
                if (i >= i2) {
                    return -1;
                }
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        if (cCharAt2 < '0' || cCharAt2 > '9') {
                            if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                if (cCharAt2 == ':') {
                                    return i;
                                }
                                return -1;
                            }
                        }
                    }
                }
            }
        }

        private static int c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int d(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static String e(String str, int i, int i2) {
            return okhttp3.internal.c.a(s.a(str, i, i2, false));
        }

        private static int f(String str, int i, int i2) throws NumberFormatException {
            try {
                int i3 = Integer.parseInt(s.a(str, i, i2, BuildConfig.FLAVOR, false, false, false, true, null));
                if (i3 <= 0 || i3 > 65535) {
                    return -1;
                }
                return i3;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                b.c cVar = new b.c();
                cVar.a(str, i, i3);
                a(cVar, str, i3, i2, z);
                return cVar.p();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void a(b.c r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = okhttp3.internal.c.a(r2)
            char r3 = r6.charAt(r1)
            int r3 = okhttp3.internal.c.a(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.i(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.i(r1)
            goto L3c
        L39:
            r5.a(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.s.a(b.c, java.lang.String, int, int, boolean):void");
    }

    static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && okhttp3.internal.c.a(str.charAt(i + 1)) != -1 && okhttp3.internal.c.a(str.charAt(i3)) != -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || a(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    b.c cVar = new b.c();
                    cVar.a(str, i, iCharCount);
                    a(cVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                    return cVar.p();
                }
            } else {
                b.c cVar2 = new b.c();
                cVar2.a(str, i, iCharCount);
                a(cVar2, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return cVar2.p();
            }
        }
        return str.substring(i, i2);
    }

    static void a(b.c cVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        b.c cVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    cVar.b(z ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z4) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z || (z2 && !a(str, i, i2)))))) {
                    if (cVar2 == null) {
                        cVar2 = new b.c();
                    }
                    if (charset == null || charset.equals(okhttp3.internal.c.e)) {
                        cVar2.a(iCodePointAt);
                    } else {
                        cVar2.a(str, i, Character.charCount(iCodePointAt) + i, charset);
                    }
                    while (!cVar2.e()) {
                        int iH = cVar2.h() & Constants.DimensionIds.NETHER;
                        cVar.i(37);
                        cVar.i((int) d[(iH >> 4) & 15]);
                        cVar.i((int) d[iH & 15]);
                    }
                } else {
                    cVar.a(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
