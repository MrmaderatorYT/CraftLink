package com.github.steveice10.packetlib.event.session;

/* loaded from: classes.dex */
public class SessionAdapter implements SessionListener {
    @Override // com.github.steveice10.packetlib.event.session.SessionListener
    public void connected(ConnectedEvent connectedEvent) {
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionListener
    public void disconnected(DisconnectedEvent disconnectedEvent) {
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionListener
    public void disconnecting(DisconnectingEvent disconnectingEvent) {
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionListener
    public void packetReceived(PacketReceivedEvent packetReceivedEvent) {
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionListener
    public void packetSending(PacketSendingEvent packetSendingEvent) {
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionListener
    public void packetSent(PacketSentEvent packetSentEvent) {
    }
}
