package com.github.steveice10.mc.auth.exception.request;

/* loaded from: classes.dex */
public class UserMigratedException extends InvalidCredentialsException {
    private static final long serialVersionUID = 1;

    public UserMigratedException() {
    }

    public UserMigratedException(String str) {
        super(str);
    }

    public UserMigratedException(String str, Throwable th) {
        super(str, th);
    }

    public UserMigratedException(Throwable th) {
        super(th);
    }
}
