package com.github.steveice10.packetlib.event.session;

/* loaded from: classes.dex */
public interface SessionListener {
    void connected(ConnectedEvent connectedEvent);

    void disconnected(DisconnectedEvent disconnectedEvent);

    void disconnecting(DisconnectingEvent disconnectingEvent);

    void packetReceived(PacketReceivedEvent packetReceivedEvent);

    void packetSending(PacketSendingEvent packetSendingEvent);

    void packetSent(PacketSentEvent packetSentEvent);
}
