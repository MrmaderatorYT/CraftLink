package io.netty.util;

/* loaded from: classes.dex */
public class IllegalReferenceCountException extends IllegalStateException {
    public IllegalReferenceCountException() {
    }

    public IllegalReferenceCountException(int i) {
        this("refCnt: " + i);
    }

    public IllegalReferenceCountException(int i, int i2) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("refCnt: ");
        sb2.append(i);
        sb2.append(", ");
        if (i2 > 0) {
            sb = new StringBuilder();
            sb.append("increment: ");
        } else {
            sb = new StringBuilder();
            sb.append("decrement: ");
            i2 = -i2;
        }
        sb.append(i2);
        sb2.append(sb.toString());
        this(sb2.toString());
    }

    public IllegalReferenceCountException(String str) {
        super(str);
    }
}
