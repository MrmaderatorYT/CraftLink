package com.github.steveice10.packetlib.tcp;

import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.ConnectionListener;
import com.github.steveice10.packetlib.Server;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.SessionFactory;
import java.net.Proxy;

/* loaded from: classes.dex */
public class TcpSessionFactory implements SessionFactory {
    private Proxy clientProxy;

    public TcpSessionFactory() {
    }

    public TcpSessionFactory(Proxy proxy) {
        this.clientProxy = proxy;
    }

    @Override // com.github.steveice10.packetlib.SessionFactory
    public Session createClientSession(Client client) {
        return new TcpClientSession(client.getHost(), client.getPort(), client.getPacketProtocol(), client, this.clientProxy);
    }

    @Override // com.github.steveice10.packetlib.SessionFactory
    public ConnectionListener createServerListener(Server server) {
        return new TcpConnectionListener(server.getHost(), server.getPort(), server);
    }
}
