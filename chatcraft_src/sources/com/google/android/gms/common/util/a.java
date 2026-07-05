package com.google.android.gms.common.util;

import android.util.Base64;

/* loaded from: classes.dex */
public final class a {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }
}
