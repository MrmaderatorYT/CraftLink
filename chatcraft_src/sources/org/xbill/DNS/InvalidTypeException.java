package org.xbill.DNS;

/* loaded from: classes.dex */
public class InvalidTypeException extends IllegalArgumentException {
    public InvalidTypeException(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Invalid DNS type: ");
        stringBuffer.append(i);
        super(stringBuffer.toString());
    }
}
