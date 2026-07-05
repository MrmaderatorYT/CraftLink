package okhttp3.internal.http2;

import java.io.IOException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: Http2.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    static final b.f f5180a = b.f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: b, reason: collision with root package name */
    static final String[] f5181b = new String[64];
    static final String[] c = new String[256];

    static {
        for (int i = 0; i < c.length; i++) {
            c[i] = okhttp3.internal.c.a("%8s", Integer.toBinaryString(i)).replace(' ', '0');
        }
        f5181b[0] = BuildConfig.FLAVOR;
        f5181b[1] = "END_STREAM";
        int[] iArr = {1};
        f5181b[8] = "PADDED";
        for (int i2 : iArr) {
            f5181b[i2 | 8] = f5181b[i2] + "|PADDED";
        }
        f5181b[4] = "END_HEADERS";
        f5181b[32] = "PRIORITY";
        f5181b[36] = "END_HEADERS|PRIORITY";
        for (int i3 : new int[]{4, 32, 36}) {
            for (int i4 : iArr) {
                int i5 = i4 | i3;
                f5181b[i5] = f5181b[i4] + '|' + f5181b[i3];
                f5181b[i5 | 8] = f5181b[i4] + '|' + f5181b[i3] + "|PADDED";
            }
        }
        for (int i6 = 0; i6 < f5181b.length; i6++) {
            if (f5181b[i6] == null) {
                f5181b[i6] = c[i6];
            }
        }
    }

    private d() {
    }

    static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(okhttp3.internal.c.a(str, objArr));
    }

    static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(okhttp3.internal.c.a(str, objArr));
    }

    static String a(boolean z, int i, int i2, byte b2, byte b3) {
        String strA = b2 < d.length ? d[b2] : okhttp3.internal.c.a("0x%02x", Byte.valueOf(b2));
        String strA2 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = strA;
        objArr[4] = strA2;
        return okhttp3.internal.c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return BuildConfig.FLAVOR;
        }
        switch (b2) {
            case 2:
            case 3:
            case 7:
            case 8:
                return c[b3];
            case 4:
            case 6:
                return b3 == 1 ? "ACK" : c[b3];
            case 5:
            default:
                String str = b3 < f5181b.length ? f5181b[b3] : c[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
        }
    }
}
