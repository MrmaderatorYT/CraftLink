package io.netty.channel.b;

import io.netty.b.i;
import io.netty.channel.an;
import io.netty.channel.ar;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.WritableByteChannel;

/* compiled from: OioByteStreamChannel.java */
/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: b, reason: collision with root package name */
    private static final InputStream f4526b = new InputStream() { // from class: io.netty.channel.b.c.1
        @Override // java.io.InputStream
        public int read() {
            return -1;
        }
    };
    private static final OutputStream c = new OutputStream() { // from class: io.netty.channel.b.c.2
        @Override // java.io.OutputStream
        public void write(int i) throws ClosedChannelException {
            throw new ClosedChannelException();
        }
    };
    private InputStream d;
    private OutputStream e;
    private WritableByteChannel f;

    protected c(io.netty.channel.d dVar) {
        super(dVar);
    }

    protected final void a(InputStream inputStream, OutputStream outputStream) {
        if (this.d != null) {
            throw new IllegalStateException("input was set already");
        }
        if (this.e != null) {
            throw new IllegalStateException("output was set already");
        }
        if (inputStream == null) {
            throw new NullPointerException("is");
        }
        if (outputStream == null) {
            throw new NullPointerException("os");
        }
        this.d = inputStream;
        this.e = outputStream;
    }

    @Override // io.netty.channel.d
    public boolean F() {
        OutputStream outputStream;
        InputStream inputStream = this.d;
        return (inputStream == null || inputStream == f4526b || (outputStream = this.e) == null || outputStream == c) ? false : true;
    }

    @Override // io.netty.channel.b.a
    protected int K() {
        try {
            return this.d.available();
        } catch (IOException unused) {
            return 0;
        }
    }

    @Override // io.netty.channel.b.a
    protected int a(i iVar) {
        ar.a aVarA = n().a();
        aVarA.c(Math.max(1, Math.min(K(), iVar.i())));
        return iVar.a(this.d, aVarA.e());
    }

    @Override // io.netty.channel.b.a
    protected void b(i iVar) {
        OutputStream outputStream = this.e;
        if (outputStream == null) {
            throw new NotYetConnectedException();
        }
        iVar.a(outputStream, iVar.g());
    }

    @Override // io.netty.channel.b.a
    protected void a(an anVar) throws EOFException {
        OutputStream outputStream = this.e;
        if (outputStream == null) {
            throw new NotYetConnectedException();
        }
        if (this.f == null) {
            this.f = Channels.newChannel(outputStream);
        }
        long j = 0;
        do {
            long jA = anVar.a(this.f, j);
            if (jA == -1) {
                b(anVar);
                return;
            }
            j += jA;
        } while (j < anVar.b());
    }

    private static void b(an anVar) throws EOFException {
        if (anVar.a() >= anVar.b()) {
            return;
        }
        throw new EOFException("Expected to be able to write " + anVar.b() + " bytes, but only wrote " + anVar.a());
    }

    @Override // io.netty.channel.a
    protected void u() throws IOException {
        InputStream inputStream = this.d;
        OutputStream outputStream = this.e;
        this.d = f4526b;
        this.e = c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }
}
