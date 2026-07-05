package org.xbill.DNS;

/* compiled from: Serial.java */
/* loaded from: classes.dex */
public final class cg {
    public static int a(long j, long j2) {
        if (j < 0 || j > 4294967295L) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(j);
            stringBuffer.append(" out of range");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        if (j2 < 0 || j2 > 4294967295L) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(j2);
            stringBuffer2.append(" out of range");
            throw new IllegalArgumentException(stringBuffer2.toString());
        }
        long j3 = j - j2;
        if (j3 >= 4294967295L) {
            j3 -= 4294967296L;
        } else if (j3 < -4294967295L) {
            j3 += 4294967296L;
        }
        return (int) j3;
    }
}
