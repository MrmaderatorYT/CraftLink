package com.github.steveice10.packetlib;

import com.github.steveice10.packetlib.packet.PacketProtocol;

/* loaded from: classes.dex */
public class Client {
    private String host;
    private int port;
    private PacketProtocol protocol;
    private Session session;

    public Client(String str, int i, PacketProtocol packetProtocol, SessionFactory sessionFactory) {
        this.host = str;
        this.port = i;
        this.protocol = packetProtocol;
        this.session = sessionFactory.createClientSession(this);
    }

    public Client(String str, int i, PacketProtocol packetProtocol, Session session) {
        this.host = str;
        this.port = i;
        this.protocol = packetProtocol;
        this.session = session;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public PacketProtocol getPacketProtocol() {
        return this.protocol;
    }

    public Session getSession() {
        return this.session;
    }
}
