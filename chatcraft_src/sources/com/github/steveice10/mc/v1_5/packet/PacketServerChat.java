package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import com.github.steveice10.mc.v1_6_4.data.message.Message;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketServerChat extends Packet {
    public Message message;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 3;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketServerChat() {
    }

    public PacketServerChat(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.message = Message.fromString(IOUtils.readString(dataInputStream));
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        IOUtils.writeString(dataOutputStream, this.message.toJsonString());
    }
}
