package org.xbill.DNS;

import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/* compiled from: Client.java */
/* loaded from: classes.dex */
class l {
    private static bn c;

    /* renamed from: a, reason: collision with root package name */
    protected long f5422a;

    /* renamed from: b, reason: collision with root package name */
    protected SelectionKey f5423b;

    protected l(SelectableChannel selectableChannel, long j) throws Throwable {
        Selector selectorOpen;
        this.f5422a = j;
        try {
            selectorOpen = Selector.open();
            try {
                selectableChannel.configureBlocking(false);
                this.f5423b = selectableChannel.register(selectorOpen, 1);
            } catch (Throwable th) {
                th = th;
                if (selectorOpen != null) {
                    selectorOpen.close();
                }
                selectableChannel.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            selectorOpen = null;
        }
    }

    protected static void a(SelectionKey selectionKey, long j) throws IOException {
        int iSelectNow;
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        if (jCurrentTimeMillis > 0) {
            iSelectNow = selectionKey.selector().select(jCurrentTimeMillis);
        } else {
            iSelectNow = jCurrentTimeMillis == 0 ? selectionKey.selector().selectNow() : 0;
        }
        if (iSelectNow == 0) {
            throw new SocketTimeoutException();
        }
    }

    protected static void a(String str, SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr) {
        if (bk.b("verbosemsg")) {
            System.err.println(org.xbill.DNS.a.d.a(str, bArr));
        }
        if (c != null) {
            c.a(str, socketAddress, socketAddress2, bArr);
        }
    }

    void a() throws IOException {
        this.f5423b.selector().close();
        this.f5423b.channel().close();
    }
}
