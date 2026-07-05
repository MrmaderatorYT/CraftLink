package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class bnl {

    /* renamed from: a, reason: collision with root package name */
    private ByteArrayOutputStream f2877a = new ByteArrayOutputStream(4096);

    /* renamed from: b, reason: collision with root package name */
    private Base64OutputStream f2878b = new Base64OutputStream(this.f2877a, 10);

    public final void a(byte[] bArr) {
        this.f2878b.write(bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() throws IOException {
        try {
            this.f2878b.close();
        } catch (IOException e) {
            xe.b("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.f2877a.close();
            return this.f2877a.toString();
        } catch (IOException e2) {
            xe.b("HashManager: Unable to convert to Base64.", e2);
            return BuildConfig.FLAVOR;
        } finally {
            this.f2877a = null;
            this.f2878b = null;
        }
    }
}
