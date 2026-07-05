package okhttp3;

import java.io.IOException;

/* compiled from: Protocol.java */
/* loaded from: classes.dex */
public enum w {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    QUIC("quic");

    private final String f;

    w(String str) {
        this.f = str;
    }

    public static w a(String str) throws IOException {
        if (str.equals(HTTP_1_0.f)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f)) {
            return SPDY_3;
        }
        if (str.equals(QUIC.f)) {
            return QUIC;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f;
    }
}
