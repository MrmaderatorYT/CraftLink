package okhttp3.internal.publicsuffix;

import b.e;
import b.j;
import b.l;
import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.c;
import okhttp3.internal.e.f;

/* loaded from: classes.dex */
public final class PublicSuffixDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f5221a = {42};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f5222b = new String[0];
    private static final String[] c = {"*"};
    private static final PublicSuffixDatabase d = new PublicSuffixDatabase();
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final CountDownLatch f = new CountDownLatch(1);
    private byte[] g;
    private byte[] h;

    public static PublicSuffixDatabase a() {
        return d;
    }

    public String a(String str) throws InterruptedException {
        int length;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrA = a(strArrSplit);
        if (strArrSplit.length == strArrA.length && strArrA[0].charAt(0) != '!') {
            return null;
        }
        if (strArrA[0].charAt(0) == '!') {
            length = strArrSplit.length - strArrA.length;
        } else {
            length = strArrSplit.length - (strArrA.length + 1);
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        while (length < strArrSplit2.length) {
            sb.append(strArrSplit2[length]);
            sb.append('.');
            length++;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] a(String[] strArr) throws InterruptedException {
        String strA;
        String strA2;
        String strA3;
        String[] strArrSplit;
        String[] strArrSplit2;
        if (!this.e.get() && this.e.compareAndSet(false, true)) {
            b();
        } else {
            try {
                this.f.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(c.e);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= bArr.length) {
                strA = null;
                break;
            }
            strA = a(this.g, bArr, i2);
            if (strA != null) {
                break;
            }
            i2++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i3 = 0; i3 < bArr2.length - 1; i3++) {
                bArr2[i3] = f5221a;
                strA2 = a(this.g, bArr2, i3);
                if (strA2 != null) {
                    break;
                }
            }
            strA2 = null;
        } else {
            strA2 = null;
        }
        if (strA2 != null) {
            for (int i4 = 0; i4 < bArr.length - 1; i4++) {
                strA3 = a(this.h, bArr, i4);
                if (strA3 != null) {
                    break;
                }
            }
            strA3 = null;
        } else {
            strA3 = null;
        }
        if (strA3 != null) {
            return ("!" + strA3).split("\\.");
        }
        if (strA == null && strA2 == null) {
            return c;
        }
        if (strA != null) {
            strArrSplit = strA.split("\\.");
        } else {
            strArrSplit = f5222b;
        }
        if (strA2 != null) {
            strArrSplit2 = strA2.split("\\.");
        } else {
            strArrSplit2 = f5222b;
        }
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z) {
                    z = false;
                    i3 = 46;
                } else {
                    i3 = bArr2[i10][i11] & Constants.DimensionIds.NETHER;
                }
                i4 = i3 - (bArr[i7 + i12] & Constants.DimensionIds.NETHER);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length == i11) {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, c.e);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    private void b() {
        boolean z = false;
        while (true) {
            try {
                try {
                    c();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e) {
                    f.c().a(5, "Failed to read public suffix list", e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void c() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        e eVarA = l.a(new j(l.a(resourceAsStream)));
        try {
            byte[] bArr = new byte[eVarA.j()];
            eVarA.a(bArr);
            byte[] bArr2 = new byte[eVarA.j()];
            eVarA.a(bArr2);
            synchronized (this) {
                this.g = bArr;
                this.h = bArr2;
            }
            this.f.countDown();
        } finally {
            c.a(eVarA);
        }
    }
}
