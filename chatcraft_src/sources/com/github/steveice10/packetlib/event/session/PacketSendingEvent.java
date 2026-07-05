package com.github.steveice10.packetlib.event.session;

import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.packet.Packet;

/* loaded from: classes.dex */
public class PacketSendingEvent implements SessionEvent {
    private boolean cancelled = false;
    private Packet packet;
    private Session session;

    public PacketSendingEvent(Session session, Packet packet) {
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

    public void setPacket(Packet packet) {
        this.packet = packet;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean z) {
        this.cancelled = z;
    }

    @Override // com.github.steveice10.packetlib.event.session.SessionEvent
    public void call(SessionListener sessionListener) {
        sessionListener.packetSending(this);
    }
}
