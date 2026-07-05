package com.crashlytics.android.c;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: ByteString.java */
/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1338a = new d(new byte[0]);

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f1339b;
    private volatile int c = 0;

    private d(byte[] bArr) {
        this.f1339b = bArr;
    }

    public int a() {
        return this.f1339b.length;
    }

    public static d a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new d(bArr2);
    }

    public static d a(String str) {
        try {
            return new d(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f1339b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        int length = this.f1339b.length;
        if (length != dVar.f1339b.length) {
            return false;
        }
        byte[] bArr = this.f1339b;
        byte[] bArr2 = dVar.f1339b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.c;
        if (i == 0) {
            byte[] bArr = this.f1339b;
            int length = this.f1339b.length;
            int i2 = length;
            for (int i3 = 0; i3 < length; i3++) {
                i2 = (i2 * 31) + bArr[i3];
            }
            i = i2 == 0 ? 1 : i2;
            this.c = i;
        }
        return i;
    }

    public InputStream b() {
        return new ByteArrayInputStream(this.f1339b);
    }
}
