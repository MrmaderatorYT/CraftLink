package com.github.steveice10.packetlib.event.server;

/* loaded from: classes.dex */
public interface ServerListener {
    void serverBound(ServerBoundEvent serverBoundEvent);

    void serverClosed(ServerClosedEvent serverClosedEvent);

    void serverClosing(ServerClosingEvent serverClosingEvent);

    void sessionAdded(SessionAddedEvent sessionAddedEvent);

    void sessionRemoved(SessionRemovedEvent sessionRemovedEvent);
}
