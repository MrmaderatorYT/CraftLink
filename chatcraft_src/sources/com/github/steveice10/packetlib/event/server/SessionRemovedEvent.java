package com.github.steveice10.packetlib.event.server;

import com.github.steveice10.packetlib.Server;
import com.github.steveice10.packetlib.Session;

/* loaded from: classes.dex */
public class SessionRemovedEvent implements ServerEvent {
    private Server server;
    private Session session;

    public SessionRemovedEvent(Server server, Session session) {
        this.server = server;
        this.session = session;
    }

    public Server getServer() {
        return this.server;
    }

    public Session getSession() {
        return this.session;
    }

    @Override // com.github.steveice10.packetlib.event.server.ServerEvent
    public void call(ServerListener serverListener) {
        serverListener.sessionRemoved(this);
    }
}
