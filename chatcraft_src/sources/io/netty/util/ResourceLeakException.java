package io.netty.util;

import java.util.Arrays;

@Deprecated
/* loaded from: classes.dex */
public class ResourceLeakException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final StackTraceElement[] f4621a = getStackTrace();

    public int hashCode() {
        int iHashCode = 0;
        for (StackTraceElement stackTraceElement : this.f4621a) {
            iHashCode = (iHashCode * 31) + stackTraceElement.hashCode();
        }
        return iHashCode;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceLeakException)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Arrays.equals(this.f4621a, ((ResourceLeakException) obj).f4621a);
    }
}
