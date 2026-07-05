package com.github.steveice10.mc.auth.exception.request;

/* loaded from: classes.dex */
public class RequestException extends Exception {
    private static final long serialVersionUID = 1;

    public RequestException() {
    }

    public RequestException(String str) {
        super(str);
    }

    public RequestException(String str, Throwable th) {
        super(str, th);
    }

    public RequestException(Throwable th) {
        super(th);
    }
}
