package com.github.steveice10.mc.auth.exception.request;

/* loaded from: classes.dex */
public class ServiceUnavailableException extends RequestException {
    private static final long serialVersionUID = 1;

    public ServiceUnavailableException() {
    }

    public ServiceUnavailableException(String str) {
        super(str);
    }

    public ServiceUnavailableException(String str, Throwable th) {
        super(str, th);
    }

    public ServiceUnavailableException(Throwable th) {
        super(th);
    }
}
