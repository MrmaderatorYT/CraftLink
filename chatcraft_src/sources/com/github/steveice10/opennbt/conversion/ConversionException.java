package com.github.steveice10.opennbt.conversion;

/* loaded from: classes.dex */
public class ConversionException extends RuntimeException {
    private static final long serialVersionUID = -2022049594558041160L;

    public ConversionException() {
    }

    public ConversionException(String str) {
        super(str);
    }

    public ConversionException(Throwable th) {
        super(th);
    }

    public ConversionException(String str, Throwable th) {
        super(str, th);
    }
}
