package com.github.steveice10.packetlib.event.session;

import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class PacketReceivedEvent implements SessionEvent {
    private Packet packet;
    private Session session;

    public PacketReceivedEvent(Session session, Packet packet) {
        this.session = session;
        this.packet = packet;
    }

    public Session getSession() {
        return this.session;
    }

    public <T extends Packet> T getPacket() {
        try {
            return (T) this.packet;
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Tried to get packet as the wrong type. Actual type: " + this.packet.getClass().getName());
        }
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionEvent
    public void call(SessionListener sessionListener) {
        sessionListener.packetReceived(this);
    }
}
