package io.netty.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* compiled from: ByteBuf.java */
/* loaded from: classes.dex */
public abstract class i implements io.netty.util.n, Comparable<i> {
    public abstract i A_();

    public abstract i C(int i);

    public abstract j F();

    @Deprecated
    public abstract ByteOrder G();

    public abstract boolean H();

    public abstract boolean I();

    public abstract byte[] J();

    public abstract int K();

    public abstract boolean L();

    public abstract long M();

    public abstract int N();

    public abstract int Q();

    public abstract int a();

    public abstract int a(int i, InputStream inputStream, int i2);

    public abstract int a(int i, GatheringByteChannel gatheringByteChannel, int i2);

    public abstract int a(int i, ScatteringByteChannel scatteringByteChannel, int i2);

    public abstract int a(InputStream inputStream, int i);

    public abstract int a(GatheringByteChannel gatheringByteChannel, int i);

    public abstract int a(ScatteringByteChannel scatteringByteChannel, int i);

    public abstract i a(double d);

    public abstract i a(float f);

    public abstract i a(int i, int i2);

    public abstract i a(int i, long j);

    public abstract i a(int i, i iVar, int i2, int i3);

    public abstract i a(int i, OutputStream outputStream, int i2);

    public abstract i a(int i, byte[] bArr, int i2, int i3);

    public abstract i a(long j);

    public abstract i a(i iVar);

    public abstract i a(i iVar, int i, int i2);

    public abstract i a(OutputStream outputStream, int i);

    @Override // io.netty.util.n
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract i b(Object obj);

    @Deprecated
    public abstract i a(ByteOrder byteOrder);

    public abstract i a(boolean z);

    public abstract i a(byte[] bArr);

    public abstract i a(byte[] bArr, int i, int i2);

    public abstract int b();

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract int compareTo(i iVar);

    public abstract i b(int i);

    public abstract i b(int i, int i2);

    public abstract i b(int i, i iVar, int i2, int i3);

    public abstract i b(int i, byte[] bArr, int i2, int i3);

    public abstract i b(byte[] bArr);

    public abstract i b(byte[] bArr, int i, int i2);

    public abstract int c();

    public abstract i c(int i);

    public abstract i d(int i, int i2);

    public abstract i e(int i);

    public abstract boolean e();

    public abstract boolean equals(Object obj);

    public abstract byte f(int i);

    public abstract i f(int i, int i2);

    public abstract boolean f();

    public abstract int g();

    public abstract int h();

    public abstract i h(int i, int i2);

    public abstract short h(int i);

    public abstract int hashCode();

    public abstract int i();

    public abstract short i(int i);

    public abstract i j();

    public abstract i k();

    public abstract short k(int i);

    public abstract i l();

    public abstract ByteBuffer l(int i, int i2);

    public abstract int m(int i);

    public abstract ByteBuffer m(int i, int i2);

    public abstract byte n();

    public abstract ByteBuffer[] n(int i, int i2);

    public abstract int o(int i);

    public abstract boolean o();

    public abstract short p();

    public abstract long q(int i);

    public abstract short q();

    public abstract int r();

    public abstract long r(int i);

    public abstract int s();

    public abstract long s(int i);

    public abstract long t();

    public abstract String toString();

    public abstract char u();

    public abstract i u(int i);

    public abstract float v();

    public abstract i v(int i);

    public abstract double w();

    public abstract i w(int i);

    public abstract i x();

    public abstract i x(int i);

    public abstract i y(int i);

    public abstract ByteBuffer y();

    public abstract ByteBuffer[] z();
}
