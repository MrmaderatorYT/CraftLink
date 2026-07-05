package org.xbill.DNS;

/* loaded from: classes.dex */
public class InvalidDClassException extends IllegalArgumentException {
    public InvalidDClassException(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Invalid DNS class: ");
        stringBuffer.append(i);
        super(stringBuffer.toString());
    }
}
