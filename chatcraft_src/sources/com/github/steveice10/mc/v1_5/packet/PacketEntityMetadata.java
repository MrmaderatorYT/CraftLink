package com.github.steveice10.mc.v1_5.packet;

import com.github.steveice10.mc.v1_5.data.WatchableObject;
import com.github.steveice10.mc.v1_5.net.Client;
import com.github.steveice10.mc.v1_5.net.ServerConnection;
import com.github.steveice10.mc.v1_5.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PacketEntityMetadata extends Packet {
    public int entityId;
    public WatchableObject[] metadata;

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public int getId() {
        return 40;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleClient(Client client) {
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void handleServer(ServerConnection serverConnection) {
    }

    public PacketEntityMetadata() {
    }

    public PacketEntityMetadata(int i, WatchableObject[] watchableObjectArr) {
        this.entityId = i;
        this.metadata = watchableObjectArr;
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void read(DataInputStream dataInputStream) {
        this.entityId = dataInputStream.readInt();
        this.metadata = IOUtils.readMetadata(dataInputStream);
    }

    @Override // com.github.steveice10.mc.v1_5.packet.Packet
    public void write(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        IOUtils.writeMetadata(dataOutputStream, this.metadata);
    }
}
