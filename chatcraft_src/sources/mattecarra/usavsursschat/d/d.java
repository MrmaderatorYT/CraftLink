package mattecarra.usavsursschat.d;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: UrlValidator.java */
/* loaded from: classes.dex */
public class d implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f4972a = Pattern.compile("^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f4973b = Pattern.compile("^\\p{Alpha}[\\p{Alnum}\\+\\-\\.]*");
    private static final Pattern c = Pattern.compile("^([\\p{Alnum}\\-\\.]*)(:\\d*)?(.*)?");
    private static final Pattern d = Pattern.compile("^(/[-\\w:@&?=+,.!/~*'%$_;\\(\\)]*)?$");
    private static final Pattern e = Pattern.compile("^(.*)$");
    private static final Pattern f = Pattern.compile("^:(\\d{1,5})$");
    private static final String[] g = {"http", "https", "ftp"};
    private static final d h = new d();
    private final long i;
    private final Set j;
    private final c k;

    public d() {
        this(null);
    }

    public d(String[] strArr) {
        this(strArr, 0L);
    }

    public d(String[] strArr, long j) {
        this(strArr, null, j);
    }

    public d(String[] strArr, c cVar, long j) {
        this.i = j;
        if (a(1L)) {
            this.j = Collections.EMPTY_SET;
        } else {
            strArr = strArr == null ? g : strArr;
            this.j = new HashSet(strArr.length);
            for (String str : strArr) {
                this.j.add(str.toLowerCase(Locale.ENGLISH));
            }
        }
        this.k = cVar;
    }

    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = f4972a.matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        String strGroup = matcher.group(2);
        if (!b(strGroup)) {
            return false;
        }
        String strGroup2 = matcher.group(4);
        return (("file".equals(strGroup) && BuildConfig.FLAVOR.equals(strGroup2)) || c(strGroup2)) && d(matcher.group(5)) && e(matcher.group(7)) && f(matcher.group(9));
    }

    protected boolean b(String str) {
        if (str != null && f4973b.matcher(str).matches()) {
            return !b(1L) || this.j.contains(str.toLowerCase(Locale.ENGLISH));
        }
        return false;
    }

    protected boolean c(String str) {
        if (str == null) {
            return false;
        }
        if (this.k != null && this.k.a(str)) {
            return true;
        }
        Matcher matcher = c.matcher(a.a(str));
        if (!matcher.matches()) {
            return false;
        }
        String strGroup = matcher.group(1);
        if (!a.a(a(8L)).b(strGroup) && !b.a().a(strGroup)) {
            return false;
        }
        String strGroup2 = matcher.group(2);
        if (strGroup2 != null && !f.matcher(strGroup2).matches()) {
            return false;
        }
        String strGroup3 = matcher.group(3);
        return strGroup3 == null || strGroup3.trim().length() <= 0;
    }

    protected boolean d(String str) {
        if (str == null || !d.matcher(str).matches()) {
            return false;
        }
        int iA = a("//", str);
        if (b(2L) && iA > 0) {
            return false;
        }
        int iA2 = a("/", str);
        int iA3 = a("..", str);
        return iA3 <= 0 || (iA2 - iA) - 1 > iA3;
    }

    protected boolean e(String str) {
        if (str == null) {
            return true;
        }
        return e.matcher(str).matches();
    }

    protected boolean f(String str) {
        if (str == null) {
            return true;
        }
        return b(4L);
    }

    protected int a(String str, String str2) {
        int iIndexOf = 0;
        int i = 0;
        while (iIndexOf != -1) {
            iIndexOf = str2.indexOf(str, iIndexOf);
            if (iIndexOf > -1) {
                iIndexOf++;
                i++;
            }
        }
        return i;
    }

    private boolean a(long j) {
        return (j & this.i) > 0;
    }

    private boolean b(long j) {
        return (j & this.i) == 0;
    }
}
