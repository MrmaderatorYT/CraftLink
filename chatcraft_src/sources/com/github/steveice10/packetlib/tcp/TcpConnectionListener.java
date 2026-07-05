package com.github.steveice10.packetlib.tcp;

import com.github.steveice10.packetlib.ConnectionListener;
import com.github.steveice10.packetlib.Server;
import io.netty.a.f;
import io.netty.channel.a.e;
import io.netty.channel.al;
import io.netty.channel.c.a.a;
import io.netty.channel.d;
import io.netty.channel.h;
import io.netty.channel.i;
import io.netty.channel.p;
import io.netty.channel.r;
import io.netty.channel.w;
import java.net.InetSocketAddress;

/* loaded from: classes.dex */
public class TcpConnectionListener implements ConnectionListener {
    private d channel;
    private al group;
    private String host;
    private int port;
    private Server server;

    public TcpConnectionListener(String str, int i, Server server) {
        this.host = str;
        this.port = i;
        this.server = server;
    }

    @Override // com.github.steveice10.packetlib.ConnectionListener
    public String getHost() {
        return this.host;
    }

    @Override // com.github.steveice10.packetlib.ConnectionListener
    public int getPort() {
        return this.port;
    }

    @Override // com.github.steveice10.packetlib.ConnectionListener
    public boolean isListening() {
        return this.channel != null && this.channel.E();
    }

    @Override // com.github.steveice10.packetlib.ConnectionListener
    public void bind() {
        bind(true);
    }

    @Override // com.github.steveice10.packetlib.ConnectionListener
    public void bind(boolean z) {
        bind(z, null);
    }

    @Override // com.github.steveice10.packetlib.ConnectionListener
    public void bind(boolean z, final Runnable runnable) {
        if (this.group == null && this.channel == null) {
            this.group = new e();
            h hVarC = new f().a(a.class).b(new p<d>() { // from class: com.github.steveice10.packetlib.tcp.TcpConnectionListener.1
                @Override // io.netty.channel.p
                public void initChannel(d dVar) throws NoSuchMethodException, SecurityException {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) dVar.h();
                    TcpServerSession tcpServerSession = new TcpServerSession(inetSocketAddress.getHostName(), inetSocketAddress.getPort(), TcpConnectionListener.this.server.createPacketProtocol(), TcpConnectionListener.this.server);
                    tcpServerSession.getPacketProtocol().newServerSession(TcpConnectionListener.this.server, tcpServerSession);
                    dVar.D().a(r.u, 24);
                    dVar.D().a(r.z, false);
                    w wVarD = dVar.d();
                    tcpServerSession.refreshReadTimeoutHandler(dVar);
                    tcpServerSession.refreshWriteTimeoutHandler(dVar);
                    wVarD.b("encryption", new TcpPacketEncryptor(tcpServerSession));
                    wVarD.b("sizer", new TcpPacketSizer(tcpServerSession));
                    wVarD.b("codec", new TcpPacketCodec(tcpServerSession));
                    wVarD.b("manager", tcpServerSession);
                }
            }).a(this.group).a(this.host, this.port).c();
            if (z) {
                try {
                    hVarC.h();
                } catch (InterruptedException unused) {
                }
                this.channel = hVarC.e();
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            hVarC.b(new i() { // from class: com.github.steveice10.packetlib.tcp.TcpConnectionListener.2
                @Override // io.netty.util.concurrent.r
                public void operationComplete(h hVar) {
                    if (hVar.l()) {
                        TcpConnectionListener.this.channel = hVar.e();
                        if (runnable != null) {
                            runnable.run();
                            return;
                        }
                        return;
                    }
                    System.err.println("[ERROR] Failed to asynchronously bind connection listener.");
                    if (hVar.k() != null) {
                        hVar.k().printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.github.steveice10.packetlib.ConnectionListener
    public void close() {
        close(false);
    }

    @Override // com.github.steveice10.packetlib.ConnectionListener
    public void close(boolean z) {
        close(z, null);
    }

    @Override // com.github.steveice10.packetlib.ConnectionListener
    public void close(boolean z, final Runnable runnable) {
        if (this.channel != null) {
            if (this.channel.E()) {
                h hVarJ = this.channel.j();
                if (z) {
                    try {
                        hVarJ.h();
                    } catch (InterruptedException unused) {
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                } else {
                    hVarJ.b(new i() { // from class: com.github.steveice10.packetlib.tcp.TcpConnectionListener.3
                        @Override // io.netty.util.concurrent.r
                        public void operationComplete(h hVar) {
                            if (hVar.l()) {
                                if (runnable != null) {
                                    runnable.run();
                                }
                            } else {
                                System.err.println("[ERROR] Failed to asynchronously close connection listener.");
                                if (hVar.k() != null) {
                                    hVar.k().printStackTrace();
                                }
                            }
                        }
                    });
                }
            }
            this.channel = null;
        }
        if (this.group != null) {
            io.netty.util.concurrent.p<?> pVarL = this.group.l();
            if (z) {
                try {
                    pVarL.h();
                } catch (InterruptedException unused2) {
                }
            } else {
                pVarL.b(new io.netty.util.concurrent.r() { // from class: com.github.steveice10.packetlib.tcp.TcpConnectionListener.4
                    @Override // io.netty.util.concurrent.r
                    public void operationComplete(io.netty.util.concurrent.p pVar) {
                        if (pVar.l()) {
                            return;
                        }
                        System.err.println("[ERROR] Failed to asynchronously close connection listener.");
                        if (pVar.k() != null) {
                            pVar.k().printStackTrace();
                        }
                    }
                });
            }
            this.group = null;
        }
    }
}
