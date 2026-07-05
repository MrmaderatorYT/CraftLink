package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Headers.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f5240a;

    r(a aVar) {
        this.f5240a = (String[]) aVar.f5241a.toArray(new String[aVar.f5241a.size()]);
    }

    @Nullable
    public String a(String str) {
        return a(this.f5240a, str);
    }

    public int a() {
        return this.f5240a.length / 2;
    }

    public String a(int i) {
        return this.f5240a[i * 2];
    }

    public String b(int i) {
        return this.f5240a[(i * 2) + 1];
    }

    public List<String> b(String str) {
        int iA = a();
        ArrayList arrayList = null;
        for (int i = 0; i < iA; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public a b() {
        a aVar = new a();
        Collections.addAll(aVar.f5241a, this.f5240a);
        return aVar;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof r) && Arrays.equals(((r) obj).f5240a, this.f5240a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5240a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iA = a();
        for (int i = 0; i < iA; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* compiled from: Headers.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final List<String> f5241a = new ArrayList(20);

        a a(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return b(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return b(BuildConfig.FLAVOR, str.substring(1));
            }
            return b(BuildConfig.FLAVOR, str);
        }

        public a a(String str, String str2) {
            d(str, str2);
            return b(str, str2);
        }

        a b(String str, String str2) {
            this.f5241a.add(str);
            this.f5241a.add(str2.trim());
            return this;
        }

        public a b(String str) {
            int i = 0;
            while (i < this.f5241a.size()) {
                if (str.equalsIgnoreCase(this.f5241a.get(i))) {
                    this.f5241a.remove(i);
                    this.f5241a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public a c(String str, String str2) {
            d(str, str2);
            b(str);
            b(str, str2);
            return this;
        }

        private void d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    throw new IllegalArgumentException(okhttp3.internal.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(okhttp3.internal.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public String c(String str) {
            for (int size = this.f5241a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f5241a.get(size))) {
                    return this.f5241a.get(size + 1);
                }
            }
            return null;
        }

        public r a() {
            return new r(this);
        }
    }
}
