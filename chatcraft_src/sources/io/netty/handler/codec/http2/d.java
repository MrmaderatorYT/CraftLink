package io.netty.handler.codec.http2;

/* compiled from: Http2Error.java */
/* loaded from: classes.dex */
public enum d {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    SETTINGS_TIMEOUT(4),
    STREAM_CLOSED(5),
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);

    private static final d[] p;
    private final long o;

    static {
        d[] dVarArrValues = values();
        d[] dVarArr = new d[dVarArrValues.length];
        for (d dVar : dVarArrValues) {
            dVarArr[(int) dVar.a()] = dVar;
        }
        p = dVarArr;
    }

    d(long j) {
        this.o = j;
    }

    public long a() {
        return this.o;
    }
}
