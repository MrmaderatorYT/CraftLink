package org.xbill.DNS;

/* loaded from: classes.dex */
public class RelativeNameException extends IllegalArgumentException {
    public RelativeNameException(bg bgVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("'");
        stringBuffer.append(bgVar);
        stringBuffer.append("' is not an absolute name");
        super(stringBuffer.toString());
    }
}
