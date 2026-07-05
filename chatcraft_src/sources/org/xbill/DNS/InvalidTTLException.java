package org.xbill.DNS;

/* loaded from: classes.dex */
public class InvalidTTLException extends IllegalArgumentException {
    public InvalidTTLException(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Invalid DNS TTL: ");
        stringBuffer.append(j);
        super(stringBuffer.toString());
    }
}
