package com.github.steveice10.opennbt.tag;

/* loaded from: classes.dex */
public class TagRegisterException extends RuntimeException {
    private static final long serialVersionUID = -2022049594558041160L;

    public TagRegisterException() {
    }

    public TagRegisterException(String str) {
        super(str);
    }

    public TagRegisterException(Throwable th) {
        super(th);
    }

    public TagRegisterException(String str, Throwable th) {
        super(str, th);
    }
}
