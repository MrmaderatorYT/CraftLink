package com.github.steveice10.packetlib.tcp;

import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.packet.PacketProtocol;
import io.netty.a.c;
import io.netty.channel.a.e;
import io.netty.channel.al;
import io.netty.channel.b.d;
import io.netty.channel.c.a.b;
import io.netty.channel.g;
import io.netty.channel.p;
import io.netty.channel.r;
import io.netty.channel.w;
import java.net.Proxy;

/* loaded from: classes.dex */
public class TcpClientSession extends TcpSession {
    private Client client;
    private al group;
    private Proxy proxy;

    public TcpClientSession(String str, int i, PacketProtocol packetProtocol, Client client, Proxy proxy) {
        super(str, i, packetProtocol);
        this.client = client;
        this.proxy = proxy;
    }

    @Override // com.github.steveice10.packetlib.tcp.TcpSession, com.github.steveice10.packetlib.Session
    public void connect(boolean z) {
        if (this.disconnected) {
            throw new IllegalStateException("Session has already been disconnected.");
        }
        if (this.group != null) {
            return;
        }
        try {
            final c cVar = new c();
            if (this.proxy != null) {
                this.group = new d();
                cVar.a((g) new ProxyOioChannelFactory(this.proxy));
            } else {
                this.group = new e();
                cVar.a(b.class);
            }
            cVar.a(new p<io.netty.channel.d>() { // from class: com.github.steveice10.packetlib.tcp.TcpClientSession.1
                @Override // io.netty.channel.p
                public void initChannel(io.netty.channel.d dVar) {
                    TcpClientSession.this.getPacketProtocol().newClientSession(TcpClientSession.this.client, TcpClientSession.this);
                    dVar.D().a(r.u, 24);
                    dVar.D().a(r.z, false);
                    w wVarD = dVar.d();
                    TcpClientSession.this.refreshReadTimeoutHandler(dVar);
                    TcpClientSession.this.refreshWriteTimeoutHandler(dVar);
                    wVarD.b("encryption", new TcpPacketEncryptor(TcpClientSession.this));
                    wVarD.b("sizer", new TcpPacketSizer(TcpClientSession.this));
                    wVarD.b("codec", new TcpPacketCodec(TcpClientSession.this));
                    wVarD.b("manager", TcpClientSession.this);
                }
            }).a(this.group).a((r<r<Integer>>) r.d, (r<Integer>) Integer.valueOf(getConnectTimeout() * 1000));
            Runnable runnable = new Runnable() { // from class: com.github.steveice10.packetlib.tcp.TcpClientSession.2
                /* JADX WARN: Code restructure failed: missing block: B:11:0x005a, code lost:
                
                    r1 = ((org.xbill.DNS.cd) r5).d();
                    r0 = r2;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:12:0x005d, code lost:
                
                    r0 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:13:0x005e, code lost:
                
                    r2 = r0;
                    r0 = r2;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
                
                    r2.printStackTrace();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:9:0x0041, code lost:
                
                    r2 = ((org.xbill.DNS.cd) r5).e().toString().replaceFirst("\\.$", me.zhanghai.android.materialprogressbar.BuildConfig.FLAVOR);
                 */
                /* JADX WARN: Removed duplicated region for block: B:19:0x007e A[Catch: Throwable -> 0x0092, LOOP:1: B:19:0x007e->B:42:0x007e, LOOP_START, TryCatch #2 {Throwable -> 0x0092, blocks: (B:2:0x0000, B:16:0x0066, B:17:0x0069, B:19:0x007e, B:21:0x0086, B:24:0x008e), top: B:34:0x0000 }] */
                /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void run() {
                    /*
                        r8 = this;
                        com.github.steveice10.packetlib.tcp.TcpClientSession r0 = com.github.steveice10.packetlib.tcp.TcpClientSession.this     // Catch: java.lang.Throwable -> L92
                        java.lang.String r0 = r0.getHost()     // Catch: java.lang.Throwable -> L92
                        com.github.steveice10.packetlib.tcp.TcpClientSession r1 = com.github.steveice10.packetlib.tcp.TcpClientSession.this     // Catch: java.lang.Throwable -> L92
                        int r1 = r1.getPort()     // Catch: java.lang.Throwable -> L92
                        org.xbill.DNS.am r2 = new org.xbill.DNS.am     // Catch: java.lang.Throwable -> L65
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65
                        r3.<init>()     // Catch: java.lang.Throwable -> L65
                        com.github.steveice10.packetlib.tcp.TcpClientSession r4 = com.github.steveice10.packetlib.tcp.TcpClientSession.this     // Catch: java.lang.Throwable -> L65
                        com.github.steveice10.packetlib.packet.PacketProtocol r4 = r4.getPacketProtocol()     // Catch: java.lang.Throwable -> L65
                        java.lang.String r4 = r4.getSRVRecordPrefix()     // Catch: java.lang.Throwable -> L65
                        r3.append(r4)     // Catch: java.lang.Throwable -> L65
                        java.lang.String r4 = "._tcp."
                        r3.append(r4)     // Catch: java.lang.Throwable -> L65
                        r3.append(r0)     // Catch: java.lang.Throwable -> L65
                        java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L65
                        r4 = 33
                        r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L65
                        org.xbill.DNS.bt[] r2 = r2.d()     // Catch: java.lang.Throwable -> L65
                        if (r2 == 0) goto L69
                        int r3 = r2.length     // Catch: java.lang.Throwable -> L65
                        r4 = 0
                    L39:
                        if (r4 >= r3) goto L69
                        r5 = r2[r4]     // Catch: java.lang.Throwable -> L65
                        boolean r6 = r5 instanceof org.xbill.DNS.cd     // Catch: java.lang.Throwable -> L65
                        if (r6 == 0) goto L62
                        r2 = r5
                        org.xbill.DNS.cd r2 = (org.xbill.DNS.cd) r2     // Catch: java.lang.Throwable -> L65
                        org.xbill.DNS.bg r2 = r2.e()     // Catch: java.lang.Throwable -> L65
                        java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L65
                        java.lang.String r3 = "\\.$"
                        java.lang.String r4 = ""
                        java.lang.String r2 = r2.replaceFirst(r3, r4)     // Catch: java.lang.Throwable -> L65
                        org.xbill.DNS.cd r5 = (org.xbill.DNS.cd) r5     // Catch: java.lang.Throwable -> L5d
                        int r0 = r5.d()     // Catch: java.lang.Throwable -> L5d
                        r1 = r0
                        r0 = r2
                        goto L69
                    L5d:
                        r0 = move-exception
                        r7 = r2
                        r2 = r0
                        r0 = r7
                        goto L66
                    L62:
                        int r4 = r4 + 1
                        goto L39
                    L65:
                        r2 = move-exception
                    L66:
                        r2.printStackTrace()     // Catch: java.lang.Throwable -> L92
                    L69:
                        io.netty.a.c r2 = r2     // Catch: java.lang.Throwable -> L92
                        r2.b(r0, r1)     // Catch: java.lang.Throwable -> L92
                        io.netty.a.c r0 = r2     // Catch: java.lang.Throwable -> L92
                        io.netty.channel.h r0 = r0.n()     // Catch: java.lang.Throwable -> L92
                        io.netty.channel.h r0 = r0.h()     // Catch: java.lang.Throwable -> L92
                        boolean r0 = r0.l()     // Catch: java.lang.Throwable -> L92
                        if (r0 == 0) goto L99
                    L7e:
                        com.github.steveice10.packetlib.tcp.TcpClientSession r0 = com.github.steveice10.packetlib.tcp.TcpClientSession.this     // Catch: java.lang.Throwable -> L92
                        boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L92
                        if (r0 != 0) goto L99
                        com.github.steveice10.packetlib.tcp.TcpClientSession r0 = com.github.steveice10.packetlib.tcp.TcpClientSession.this     // Catch: java.lang.Throwable -> L92
                        boolean r0 = r0.disconnected     // Catch: java.lang.Throwable -> L92
                        if (r0 != 0) goto L99
                        r0 = 5
                        java.lang.Thread.sleep(r0)     // Catch: java.lang.InterruptedException -> L7e java.lang.Throwable -> L92
                        goto L7e
                    L92:
                        r0 = move-exception
                        com.github.steveice10.packetlib.tcp.TcpClientSession r1 = com.github.steveice10.packetlib.tcp.TcpClientSession.this
                        r2 = 0
                        r1.exceptionCaught(r2, r0)
                    L99:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.github.steveice10.packetlib.tcp.TcpClientSession.AnonymousClass2.run():void");
                }
            };
            if (z) {
                runnable.run();
            } else {
                new Thread(runnable).start();
            }
        } catch (Throwable th) {
            exceptionCaught(null, th);
        }
    }

    @Override // com.github.steveice10.packetlib.tcp.TcpSession, com.github.steveice10.packetlib.Session
    public void disconnect(String str, Throwable th, boolean z) {
        super.disconnect(str, th, z);
        if (this.group != null) {
            io.netty.util.concurrent.p<?> pVarL = this.group.l();
            if (z) {
                try {
                    pVarL.i();
                } catch (InterruptedException unused) {
                }
            }
            this.group = null;
        }
    }
}
