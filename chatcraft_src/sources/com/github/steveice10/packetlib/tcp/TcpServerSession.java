package com.github.steveice10.packetlib.tcp;

import com.github.steveice10.packetlib.Server;
import com.github.steveice10.packetlib.packet.PacketProtocol;
import io.netty.channel.l;
import java.util.Map;

/* loaded from: classes.dex */
public class TcpServerSession extends TcpSession {
    private Server server;

    public TcpServerSession(String str, int i, PacketProtocol packetProtocol, Server server) {
        super(str, i, packetProtocol);
        this.server = server;
    }

    @Override // com.github.steveice10.packetlib.tcp.TcpSession, com.github.steveice10.packetlib.Session
    public Map<String, Object> getFlags() {
        Map<String, Object> flags = super.getFlags();
        flags.putAll(this.server.getGlobalFlags());
        return flags;
    }

    @Override // com.github.steveice10.packetlib.tcp.TcpSession, io.netty.channel.o, io.netty.channel.n
    public void channelActive(l lVar) {
        super.channelActive(lVar);
        this.server.addSession(this);
    }

    @Override // com.github.steveice10.packetlib.tcp.TcpSession, io.netty.channel.o, io.netty.channel.n
    public void channelInactive(l lVar) {
        super.channelInactive(lVar);
        this.server.removeSession(this);
    }
}
