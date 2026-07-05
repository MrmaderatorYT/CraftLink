package com.github.steveice10.mc.auth.exception.request;

/* loaded from: classes.dex */
public class InvalidCredentialsException extends RequestException {
    private static final long serialVersionUID = 1;

    public InvalidCredentialsException() {
    }

    public InvalidCredentialsException(String str) {
        super(str);
    }

    public InvalidCredentialsException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidCredentialsException(Throwable th) {
        super(th);
    }
}
