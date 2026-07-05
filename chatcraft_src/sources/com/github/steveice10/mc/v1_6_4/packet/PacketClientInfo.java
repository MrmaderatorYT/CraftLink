package com.github.steveice10.mc.v1_6_4.packet;

import com.github.steveice10.mc.v1_6_4.net.Client;
import com.github.steveice10.mc.v1_6_4.net.ServerConnection;
import com.github.steveice10.packetlib.io.NetInput;
import com.github.steveice10.packetlib.io.NetOutput;

/* loaded from: classes.dex */
public class PacketClientInfo extends Packet {
    public boolean cape;
    public byte chatFlags;
    public byte difficulty;
    public String locale;
    public byte viewDistance;

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public int getId() {
        return 204;
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_6_4.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketClientInfo() {
    }

    public PacketClientInfo(String str, byte b2, byte b3, byte b4, boolean z) {
        this.locale = str;
        this.viewDistance = b2;
        this.chatFlags = b3;
        this.difficulty = b4;
        this.cape = z;
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void read(NetInput netInput) {
        this.locale = netInput.readString();
        this.viewDistance = netInput.readByte();
        this.chatFlags = netInput.readByte();
        this.difficulty = netInput.readByte();
        this.cape = netInput.readBoolean();
    }

    @Override // com.github.steveice10.packetlib.packet.Packet
    public void write(NetOutput netOutput) {
        netOutput.writeString(this.locale);
        netOutput.writeByte(this.viewDistance);
        netOutput.writeByte(this.chatFlags);
        netOutput.writeByte(this.difficulty);
        netOutput.writeBoolean(this.cape);
    }
}
