package mattecarra.usavsursschat.d;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: RegexValidator.java */
/* loaded from: classes.dex */
public class c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private final Pattern[] f4971a;

    public c(String str) {
        this(str, true);
    }

    public c(String str, boolean z) {
        this(new String[]{str}, z);
    }

    public c(String[] strArr, boolean z) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("Regular expressions are missing");
        }
        this.f4971a = new Pattern[strArr.length];
        int i = z ? 0 : 2;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2] == null || strArr[i2].length() == 0) {
                throw new IllegalArgumentException("Regular expression[" + i2 + "] is missing");
            }
            this.f4971a[i2] = Pattern.compile(strArr[i2], i);
        }
    }

    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < this.f4971a.length; i++) {
            if (this.f4971a[i].matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public String[] b(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f4971a.length; i2++) {
            Matcher matcher = this.f4971a[i2].matcher(str);
            if (matcher.matches()) {
                int iGroupCount = matcher.groupCount();
                String[] strArr = new String[iGroupCount];
                while (i < iGroupCount) {
                    int i3 = i + 1;
                    strArr[i] = matcher.group(i3);
                    i = i3;
                }
                return strArr;
            }
        }
        return null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RegexValidator{");
        for (int i = 0; i < this.f4971a.length; i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(this.f4971a[i].pattern());
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
