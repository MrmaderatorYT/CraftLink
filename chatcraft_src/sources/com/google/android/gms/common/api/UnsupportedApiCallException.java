package com.google.android.gms.common.api;

/* loaded from: classes.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.common.c f1690a;

    @Override // java.lang.Throwable
    public final String getMessage() {
        String strValueOf = String.valueOf(this.f1690a);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 8);
        sb.append("Missing ");
        sb.append(strValueOf);
        return sb.toString();
    }
}
