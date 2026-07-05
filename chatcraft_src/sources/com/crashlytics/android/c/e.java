package com.crashlytics.android.c;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: CLSUUID.java */
/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicLong f1340a = new AtomicLong(0);

    /* renamed from: b, reason: collision with root package name */
    private static String f1341b;

    public e(io.fabric.sdk.android.services.b.r rVar) {
        byte[] bArr = new byte[10];
        a(bArr);
        b(bArr);
        c(bArr);
        String strA = io.fabric.sdk.android.services.b.i.a(rVar.b());
        String strA2 = io.fabric.sdk.android.services.b.i.a(bArr);
        f1341b = String.format(Locale.US, "%s-%s-%s-%s", strA2.substring(0, 12), strA2.substring(12, 16), strA2.subSequence(16, 20), strA.substring(0, 12)).toUpperCase(Locale.US);
    }

    private void a(byte[] bArr) {
        long time = new Date().getTime();
        byte[] bArrA = a(time / 1000);
        bArr[0] = bArrA[0];
        bArr[1] = bArrA[1];
        bArr[2] = bArrA[2];
        bArr[3] = bArrA[3];
        byte[] bArrB = b(time % 1000);
        bArr[4] = bArrB[0];
        bArr[5] = bArrB[1];
    }

    private void b(byte[] bArr) {
        byte[] bArrB = b(f1340a.incrementAndGet());
        bArr[6] = bArrB[0];
        bArr[7] = bArrB[1];
    }

    private void c(byte[] bArr) {
        byte[] bArrB = b(Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = bArrB[0];
        bArr[9] = bArrB[1];
    }

    private static byte[] a(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt((int) j);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.position(0);
        return byteBufferAllocate.array();
    }

    private static byte[] b(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2);
        byteBufferAllocate.putShort((short) j);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.position(0);
        return byteBufferAllocate.array();
    }

    public String toString() {
        return f1341b;
    }
}
