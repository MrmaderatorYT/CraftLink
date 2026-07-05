package com.github.steveice10.packetlib.event.server;

import com.github.steveice10.packetlib.Server;

/* loaded from: classes.dex */
public class ServerClosedEvent implements ServerEvent {
    private Server server;

    public ServerClosedEvent(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return this.server;
    }

    @Override // com.github.steveice10.packetlib.event.server.ServerEvent
    public void call(ServerListener serverListener) {
        serverListener.serverClosed(this);
    }
}
