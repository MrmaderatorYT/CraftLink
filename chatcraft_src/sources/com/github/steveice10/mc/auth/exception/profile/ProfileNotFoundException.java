package com.github.steveice10.mc.auth.exception.profile;

/* loaded from: classes.dex */
public class ProfileNotFoundException extends ProfileException {
    private static final long serialVersionUID = 1;

    public ProfileNotFoundException() {
    }

    public ProfileNotFoundException(String str) {
        super(str);
    }

    public ProfileNotFoundException(String str, Throwable th) {
        super(str, th);
    }

    public ProfileNotFoundException(Throwable th) {
        super(th);
    }
}
