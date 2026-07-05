package com.github.steveice10.packetlib.tcp;

import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.event.session.ConnectedEvent;
import com.github.steveice10.packetlib.event.session.DisconnectedEvent;
import com.github.steveice10.packetlib.event.session.DisconnectingEvent;
import com.github.steveice10.packetlib.event.session.PacketReceivedEvent;
import com.github.steveice10.packetlib.event.session.PacketSendingEvent;
import com.github.steveice10.packetlib.event.session.PacketSentEvent;
import com.github.steveice10.packetlib.event.session.SessionEvent;
import com.github.steveice10.packetlib.event.session.SessionListener;
import com.github.steveice10.packetlib.packet.Packet;
import com.github.steveice10.packetlib.packet.PacketProtocol;
import io.netty.channel.ConnectTimeoutException;
import io.netty.channel.aw;
import io.netty.channel.d;
import io.netty.channel.h;
import io.netty.channel.i;
import io.netty.channel.l;
import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.handler.timeout.WriteTimeoutException;
import io.netty.handler.timeout.e;
import java.net.ConnectException;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public abstract class TcpSession extends aw<Packet> implements Session {
    private d channel;
    private String host;
    private Thread packetHandleThread;
    private int port;
    private PacketProtocol protocol;
    private int compressionThreshold = -1;
    private int connectTimeout = 30;
    private int readTimeout = 30;
    private int writeTimeout = 0;
    private Map<String, Object> flags = new HashMap();
    private List<SessionListener> listeners = new CopyOnWriteArrayList();
    protected boolean disconnected = false;
    private BlockingQueue<Packet> packets = new LinkedBlockingQueue();

    public void connect(boolean z) {
    }

    public TcpSession(String str, int i, PacketProtocol packetProtocol) {
        this.host = str;
        this.port = i;
        this.protocol = packetProtocol;
    }

    @Override // com.github.steveice10.packetlib.Session
    public void connect() {
        connect(true);
    }

    @Override // com.github.steveice10.packetlib.Session
    public String getHost() {
        return this.host;
    }

    @Override // com.github.steveice10.packetlib.Session
    public int getPort() {
        return this.port;
    }

    @Override // com.github.steveice10.packetlib.Session
    public SocketAddress getLocalAddress() {
        if (this.channel != null) {
            return this.channel.g();
        }
        return null;
    }

    @Override // com.github.steveice10.packetlib.Session
    public SocketAddress getRemoteAddress() {
        if (this.channel != null) {
            return this.channel.h();
        }
        return null;
    }

    @Override // com.github.steveice10.packetlib.Session
    public PacketProtocol getPacketProtocol() {
        return this.protocol;
    }

    public Map<String, Object> getFlags() {
        return new HashMap(this.flags);
    }

    @Override // com.github.steveice10.packetlib.Session
    public boolean hasFlag(String str) {
        return getFlags().containsKey(str);
    }

    @Override // com.github.steveice10.packetlib.Session
    public <T> T getFlag(String str) {
        T t = (T) getFlags().get(str);
        if (t == null) {
            return null;
        }
        return t;
    }

    @Override // com.github.steveice10.packetlib.Session
    public void setFlag(String str, Object obj) {
        this.flags.put(str, obj);
    }

    @Override // com.github.steveice10.packetlib.Session
    public List<SessionListener> getListeners() {
        return new ArrayList(this.listeners);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void addListener(SessionListener sessionListener) {
        this.listeners.add(sessionListener);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void removeListener(SessionListener sessionListener) {
        this.listeners.remove(sessionListener);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void callEvent(SessionEvent sessionEvent) {
        try {
            Iterator<SessionListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                sessionEvent.call(it.next());
            }
        } catch (Throwable th) {
            exceptionCaught(null, th);
        }
    }

    @Override // com.github.steveice10.packetlib.Session
    public int getCompressionThreshold() {
        return this.compressionThreshold;
    }

    @Override // com.github.steveice10.packetlib.Session
    public void setCompressionThreshold(int i) {
        this.compressionThreshold = i;
        if (this.channel != null) {
            if (this.compressionThreshold >= 0) {
                if (this.channel.d().b("compression") == null) {
                    this.channel.d().a("codec", "compression", new TcpPacketCompression(this));
                }
            } else if (this.channel.d().b("compression") != null) {
                this.channel.d().a("compression");
            }
        }
    }

    @Override // com.github.steveice10.packetlib.Session
    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    @Override // com.github.steveice10.packetlib.Session
    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    @Override // com.github.steveice10.packetlib.Session
    public int getReadTimeout() {
        return this.readTimeout;
    }

    @Override // com.github.steveice10.packetlib.Session
    public void setReadTimeout(int i) {
        this.readTimeout = i;
        refreshReadTimeoutHandler();
    }

    @Override // com.github.steveice10.packetlib.Session
    public int getWriteTimeout() {
        return this.writeTimeout;
    }

    @Override // com.github.steveice10.packetlib.Session
    public void setWriteTimeout(int i) {
        this.writeTimeout = i;
        refreshWriteTimeoutHandler();
    }

    @Override // com.github.steveice10.packetlib.Session
    public boolean isConnected() {
        return (this.channel == null || !this.channel.E() || this.disconnected) ? false : true;
    }

    @Override // com.github.steveice10.packetlib.Session
    public void send(Packet packet) {
        if (this.channel == null) {
            return;
        }
        PacketSendingEvent packetSendingEvent = new PacketSendingEvent(this, packet);
        callEvent(packetSendingEvent);
        if (packetSendingEvent.isCancelled()) {
            return;
        }
        final Packet packet2 = packetSendingEvent.getPacket();
        h hVarB = this.channel.a(packet2).b(new i() { // from class: com.github.steveice10.packetlib.tcp.TcpSession.1
            @Override // io.netty.util.concurrent.r
            public void operationComplete(h hVar) {
                if (hVar.l()) {
                    TcpSession.this.callEvent(new PacketSentEvent(TcpSession.this, packet2));
                } else {
                    TcpSession.this.exceptionCaught(null, hVar.k());
                }
            }
        });
        if (packet2.isPriority()) {
            try {
                hVarB.i();
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // com.github.steveice10.packetlib.Session
    public void disconnect(String str) {
        disconnect(str, false);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void disconnect(String str, boolean z) {
        disconnect(str, null, z);
    }

    @Override // com.github.steveice10.packetlib.Session
    public void disconnect(String str, Throwable th) {
        disconnect(str, th, false);
    }

    public void disconnect(final String str, final Throwable th, boolean z) {
        if (this.disconnected) {
            return;
        }
        this.disconnected = true;
        if (this.packetHandleThread != null) {
            this.packetHandleThread.interrupt();
            this.packetHandleThread = null;
        }
        if (this.channel != null && this.channel.E()) {
            callEvent(new DisconnectingEvent(this, str, th));
            h hVarB = this.channel.k().j().b(new i() { // from class: com.github.steveice10.packetlib.tcp.TcpSession.2
                @Override // io.netty.util.concurrent.r
                public void operationComplete(h hVar) {
                    TcpSession.this.callEvent(new DisconnectedEvent(TcpSession.this, str != null ? str : "Connection closed.", th));
                }
            });
            if (z) {
                try {
                    hVarB.i();
                } catch (InterruptedException unused) {
                }
            }
        } else {
            if (str == null) {
                str = "Connection closed.";
            }
            callEvent(new DisconnectedEvent(this, str, th));
        }
        this.channel = null;
    }

    protected void refreshReadTimeoutHandler() {
        refreshReadTimeoutHandler(this.channel);
    }

    protected void refreshReadTimeoutHandler(d dVar) {
        if (dVar != null) {
            if (this.readTimeout <= 0) {
                if (dVar.d().b("readTimeout") != null) {
                    dVar.d().a("readTimeout");
                }
            } else if (dVar.d().b("readTimeout") == null) {
                dVar.d().a("readTimeout", new io.netty.handler.timeout.d(this.readTimeout));
            } else {
                dVar.d().b("readTimeout", "readTimeout", new io.netty.handler.timeout.d(this.readTimeout));
            }
        }
    }

    protected void refreshWriteTimeoutHandler() {
        refreshWriteTimeoutHandler(this.channel);
    }

    protected void refreshWriteTimeoutHandler(d dVar) {
        if (dVar != null) {
            if (this.writeTimeout <= 0) {
                if (dVar.d().b("writeTimeout") != null) {
                    dVar.d().a("writeTimeout");
                }
            } else if (dVar.d().b("writeTimeout") == null) {
                dVar.d().a("writeTimeout", new e(this.writeTimeout));
            } else {
                dVar.d().b("writeTimeout", "writeTimeout", new e(this.writeTimeout));
            }
        }
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelActive(l lVar) {
        if (this.disconnected || this.channel != null) {
            lVar.a().j();
            return;
        }
        this.channel = lVar.a();
        this.packetHandleThread = new Thread(new Runnable() { // from class: com.github.steveice10.packetlib.tcp.TcpSession.3
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        Packet packet = (Packet) TcpSession.this.packets.take();
                        if (packet == null) {
                            return;
                        } else {
                            TcpSession.this.callEvent(new PacketReceivedEvent(TcpSession.this, packet));
                        }
                    } catch (InterruptedException unused) {
                        return;
                    } catch (Throwable th) {
                        TcpSession.this.exceptionCaught(null, th);
                        return;
                    }
                }
            }
        });
        this.packetHandleThread.start();
        callEvent(new ConnectedEvent(this));
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelInactive(l lVar) {
        if (lVar.a() == this.channel) {
            disconnect("Connection closed.");
        }
    }

    @Override // io.netty.channel.o, io.netty.channel.k, io.netty.channel.j
    public void exceptionCaught(l lVar, Throwable th) {
        String string;
        if ((th instanceof ConnectTimeoutException) || ((th instanceof ConnectException) && th.getMessage().contains("connection timed out"))) {
            string = "Connection timed out.";
        } else if (th instanceof ReadTimeoutException) {
            string = "Read timed out.";
        } else {
            string = th instanceof WriteTimeoutException ? "Write timed out." : th.toString();
        }
        disconnect(string, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.aw
    public void channelRead0(l lVar, Packet packet) {
        if (packet.isPriority()) {
            return;
        }
        this.packets.add(packet);
    }
}
