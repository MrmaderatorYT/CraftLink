package com.github.steveice10.packetlib.event.session;

import com.github.steveice10.packetlib.Session;

/* loaded from: classes.dex */
public class ConnectedEvent implements SessionEvent {
    private Session session;

    public ConnectedEvent(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return this.session;
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionEvent
    public void call(SessionListener sessionListener) {
        sessionListener.connected(this);
    }
}
